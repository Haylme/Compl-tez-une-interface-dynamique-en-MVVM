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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.adapter.ReviewsAdapter;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

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

        reviewsListViewModel.getReviews().observe(getViewLifecycleOwner(), new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviewslist) {

                adapter.refresh(reviewslist);
            }
        });

        adapter = new ReviewsAdapter(reviewsList);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(binding.recyclerview.getContext(), DividerItemDecoration.VERTICAL));

    }


    private void setupReviewList() {
        reviewsListViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(ReviewsListViewModel.class);
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


}

