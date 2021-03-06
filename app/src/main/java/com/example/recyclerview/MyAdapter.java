package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private Context mContext;
    private int[] mPlaceList;

    public MyAdapter(Context mContext, int[] mPlaceList) {
        this.mContext = mContext;
        this.mPlaceList = mPlaceList;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_custom_layout,
                parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {
        holder.mPlace.setImageResource(mPlaceList[position]);
        holder.mPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailedActivity.class);
                mIntent.putExtra("Image", mPlaceList[holder.getAdapterPosition()]);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaceList.length;
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder {

    ImageView mPlace;

    public PlaceViewHolder(View itemView) {
        super(itemView);

        mPlace = itemView.findViewById(R.id.ivPlace);
    }
}
