package com.openclassrooms.tajmahal.ui.restaurant;

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
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.adapter.ReviewsAdapter;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupReviewList();
        toolBar();


        adapter = new ReviewsAdapter(reviewsList);


        reviewsListViewModel.getReviews().observe(getViewLifecycleOwner(), new Observer<List<Review>>() {


            @Override
            public void onChanged(List<Review> reviewslist) {


                adapter.refresh(reviewslist);


            }
        });
        updateNewReviews(reviewsList);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(binding.recyclerview.getContext(), DividerItemDecoration.VERTICAL));


    }


    private void setupReviewList() {
        reviewsListViewModel = new ViewModelProvider(this).get(ReviewsListViewModel.class);
    }


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

    private void updateNewReviews(final List<Review> reviewList) {
        binding.validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Review newReview = newPost();
                if (newReview != null) {

                    reviewList.add(0, newReview);

                    adapter.notifyItemInserted(0);

                    binding.recyclerview.scrollToPosition(0);
                }
            }
        });
    }


    private Review newPost() {


        String username = binding.namePost.getText().toString();
        if (getView() != null) {
            if (username.isEmpty()) {
                Snackbar.make(
                        getView(), "Name is needed", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();

            }
        }


        int rate = (int) binding.etoilesPost.getRating();
        if (getView() != null) {
            if (rate < 1) {
                Snackbar.make(getView(), "Select a valid rate value", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();


            }
        }
        String comment = binding.textedit.getText().toString();
        if (getView() != null) {
            if (comment.isEmpty()) {
                Snackbar.make(getView(), "Review is needed", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();


            }
        }


        String picture = binding.avatarPost.getDrawable().toString();
        if (getView() != null) {
            if (picture == null) {
                Snackbar.make(getView(), "Need a picture", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();

            }


        }


        return new Review(username, picture, comment, rate);
    }


}





