package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;

public class ReviewsListFragment extends Fragment {

    private FragmentReviewsListBinding binding;

    private ReviewsListViewModel reviewsListViewModel;


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
        SetupReviewList();
        reviewsListViewModel.getReviews();/** a terminer **/

    }


    private void SetupReviewList() {


        reviewsListViewModel = new ViewModelProvider(this).get(ReviewsListViewModel.class);


    }


    public static ReviewsListFragment newinstance() {
        return new ReviewsListFragment();
    }


}

