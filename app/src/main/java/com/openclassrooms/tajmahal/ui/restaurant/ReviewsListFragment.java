package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.adapter.ReviewsAdapter;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

public class ReviewsListFragment extends Fragment {

    private FragmentReviewsListBinding binding;

    //private ReviewsListViewModel reviewsListViewModel;

    private ReviewsAdapter adapter;


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
        //SetupReviewList();


        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(binding.recyclerview.getContext(), DividerItemDecoration.VERTICAL));

    }


  /**  private void SetupReviewList() {


        reviewsListViewModel = new ViewModelProvider(this).get(ReviewsListViewModel.class);


    }**/


}

