package com.example.user.qutof.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.qutof.Pojos.RecyclerPojo;
import com.example.user.qutof.R;
import com.example.user.qutof.Recycler.RecyclerViewHolder;

import java.util.List;

/**
 * Created by USER on 09-01-16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<RecyclerPojo> itemList;
    private Context context;

    public RecyclerViewAdapter(List<RecyclerPojo> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_view, null);
        RecyclerViewHolder rvh=new RecyclerViewHolder(layoutView);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.offer.setText(itemList.get(position).getOffer());
        holder.designer_name.setText(itemList.get(position).getDesigner_name());
        holder.item_image.setImageResource(itemList.get(position).getItem_image());
    }

    @Override
    public int getItemCount() {

        return this.itemList.size();
    }
}
