package com.example.user.qutof.Recycler;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.qutof.R;

/**
 * Created by USER on 09-01-16.
 */
public class RecyclerDecorations extends RecyclerView.ItemDecoration {

    private int margin;

    public RecyclerDecorations(Context context) {
        margin = context.getResources().getDimensionPixelSize(R.dimen.item_margins);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin, margin, margin, margin);
    }
}
