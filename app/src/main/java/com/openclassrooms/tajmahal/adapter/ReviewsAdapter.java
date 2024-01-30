package com.openclassrooms.tajmahal.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.databinding.ReviewsItemBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

public class ReviewsAdapter extends RefreshAbleAdapter<ReviewsAdapter.ReviewsViewholder> {


    public ReviewsAdapter(List<Review> data) {
        refresh(data);

    }


    @NonNull
    @Override
    public ReviewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReviewsViewholder(ReviewsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewholder holder, int position) {


        Review review = data.get(position);


        Glide.with(holder.itemView)
                .load(review.getPicture())
                .into(holder.binding.avatarReviews);

        holder.binding.nameReviews.setText(review.getUsername());
        holder.binding.textReviews.setText(review.getComment());
        holder.binding.etoilesReviews.setRating(review.getRate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ReviewsViewholder extends RecyclerView.ViewHolder {

        ReviewsItemBinding binding;

        public ReviewsViewholder(ReviewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
