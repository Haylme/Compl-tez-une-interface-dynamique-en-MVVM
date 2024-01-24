package com.openclassrooms.tajmahal.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

public abstract class RefreshAbleAdapter< T extends ReviewsAdapter.ReviewsViewholder > extends RecyclerView.Adapter<T>{

    protected List<Review>data = new ArrayList<>();

    public void refresh(List<Review>data){

        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();

    }




}
