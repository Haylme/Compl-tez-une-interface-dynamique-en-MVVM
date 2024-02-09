package com.openclassrooms.tajmahal.ui.restaurant;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.adapter.ReviewsAdapter;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReviewsListFragment extends Fragment {

    private FragmentReviewsListBinding binding;

    private ReviewsListViewModel reviewsListViewModel;

    private ReviewsAdapter adapter;

    List<Review> reviewsList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentReviewsListBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewModel();
        toolBar();


        adapter = new ReviewsAdapter(reviewsList);


        reviewsListViewModel.getReviews().observe(getViewLifecycleOwner(), new Observer<List<Review>>() { //observe the change in fragment and update with refresh method


            @Override
            public void onChanged(List<Review> reviewslist) {


                adapter.refresh(reviewslist);


            }
        });
        setupNewItem();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(binding.recyclerview.getContext(), DividerItemDecoration.VERTICAL));


    }


    private void setupViewModel() {
        reviewsListViewModel = new ViewModelProvider(this).get(ReviewsListViewModel.class);
    }

    //back stack function

    private void toolBar() {


        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getActivity() != null) {
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment_main_container).navigateUp();
                }
            }
        });
    }

    /**
     *
     * set on click method that update list data with new item
     *
     */

    private void setupNewItem() {
        binding.validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.namePost.getText().toString();
                int rate = (int) binding.etoilesPost.getRating();
                String comment = binding.textedit.getText().toString();
                String picture = Uri.parse("android.resource://com.openclassrooms.tajmahal/" + R.drawable.avatarpost).toString();

                if (validateInput(rate, comment)) {
                    Review newReview = new Review(username, picture, comment, rate);
                    reviewsListViewModel.addReview(newReview);

                    binding.textedit.setText(""); //reset text value
                    binding.etoilesPost.setRating(0);  //reset rate value


                }
            }
        });
    }

    private boolean validateInput(int rate, String comment) { ///check if input are not empty and valid


        if (rate < 1) {
            Snackbar.make(binding.getRoot(), "Select a valid rate value", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();
            return false;
        }

        if (comment.isEmpty()) {
            Snackbar.make(binding.getRoot(), "Review is needed", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();
            return false;
        }

        return true;
    }


}





