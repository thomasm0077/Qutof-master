package com.example.user.qutof.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.qutof.R;

/**
 * Created by USER on 09-01-16.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView offer;
    public TextView designer_name;
    public ImageView item_image;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        offer = (TextView) itemView.findViewById(R.id.custom_recycler_view_textView1);
        designer_name = (TextView) itemView.findViewById(R.id.custom_recycler_view_textView2);
        item_image= (ImageView) itemView.findViewById(R.id.custom_recycler_view_imageView);

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(), "Clicked Card = " + designer_name.toString(), Toast.LENGTH_SHORT).show();

    }
}
