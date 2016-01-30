package com.example.user.qutof.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.qutof.Pojos.RecyclerPojo;
import com.example.user.qutof.R;

import java.util.ArrayList;
import java.util.List;

public class HeaderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private static final int ITEM_VIEW_TYPE_HEADER = 0;
  private static final int ITEM_VIEW_TYPE_ITEM = 1;

 // private final View header;
//  private final List<String> labels;
  private List<RecyclerPojo> allItem;


  public HeaderRecyclerAdapter(List<RecyclerPojo> allItemList) {
    this.allItem=allItemList;
//    if (header == null) {
//      throw new IllegalArgumentException("header may not be null");
//    }
//    this.header = header;
  }

  public boolean isHeader(int position) {
    if(position==0){
      return true;
    }
    return false;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == ITEM_VIEW_TYPE_HEADER) {
     View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_header, parent, false);
      return new ViewHolder(header);
    }else {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_grid, parent, false);
      return new ViewHolder(view);
    }
  }

  @Override
  public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    ImageView imgViewIcon;
    if (isHeader(position)) {

      try {

        ((ViewHolder) holder).t3.setText(allItem.get(position).getOffer());
        ((ViewHolder) holder).t4.setText(allItem.get(position).getDesigner_name());

        ((ViewHolder) holder).imgViewIconheader.setImageResource(allItem.get(position).getItem_image());


      } catch (Exception e) {
        System.out.println(e);
      }


    }else {


      try {

        ((ViewHolder) holder).t1.setText(allItem.get(position).getOffer());
        ((ViewHolder) holder).t2.setText(allItem.get(position).getDesigner_name());

        ((ViewHolder) holder).imgViewIcongrid.setImageResource(allItem.get(position).getItem_image());


      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

//    public TextView txtViewTitle;
      ImageView imgViewIcongrid,imgViewIconheader;
      TextView t1,t2,t3,t4;

    public ViewHolder(View v) {

      super(v);
//      txtViewTitle = (TextView) v.findViewById(R.id.item_title);
        imgViewIcongrid = (ImageView) v.findViewById(R.id.featured_grid_imageView1);
        imgViewIconheader = (ImageView) v.findViewById(R.id.featured_header_imageView1);
        t1= (TextView) v.findViewById(R.id.featured_grid_textView1);
        t2= (TextView) v.findViewById(R.id.featured_grid_textView2);
        t3= (TextView) v.findViewById(R.id.featured_header_textView1);
        t4= (TextView) v.findViewById(R.id.featured_header_textView2);

    }
  }

  @Override
  public int getItemViewType(int position) {
    return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
  }

  @Override
  public int getItemCount() {
    return allItem.size() + 1;
  }
}