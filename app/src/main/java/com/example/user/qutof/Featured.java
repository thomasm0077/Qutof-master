package com.example.user.qutof;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.qutof.Adapters.HeaderRecyclerAdapter;
import com.example.user.qutof.Pojos.RecyclerPojo;
import com.example.user.qutof.Recycler.RecyclerDecorations;
import com.example.user.qutof.utils.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 09-01-16.
 */
public class Featured extends AppCompatActivity {

    RecyclerView rv;
    Toolbar toolbar,bottomToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.featured_layout);

        toolbar=(Toolbar)findViewById(R.id.featured_toptoolbar);
        bottomToolbar=(Toolbar)findViewById(R.id.featured_bottomToolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main_menu);

        initializeRecyclerView();
        List<RecyclerPojo> rowListItem=getAllItemList();

        rv.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });


//        RecyclerViewHeader header= (RecyclerViewHeader) findViewById(R.id.header);
//        header.attachTo(rv, true);
//
//        RecyclerViewAdapter rca=new RecyclerViewAdapter(rowListItem, Featured.this);
//        rv.setAdapter(rca);



    }

    public void initializeRecyclerView(){
        rv= (RecyclerView) findViewById(R.id.recycler_View);
        final GridLayoutManager glm=new GridLayoutManager(Featured.this,2);
        rv.addItemDecoration(new RecyclerDecorations(this));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(glm);

        View header = LayoutInflater.from(this).inflate(R.layout.featured_header, rv, false);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Header Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        final HeaderRecyclerAdapter adapter = new HeaderRecyclerAdapter(header,getAllItemList());
        rv.setAdapter(adapter);

        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? glm.getSpanCount() : 1;
            }
        });
    }


    private void hideViews() {
        //  toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) bottomToolbar.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        bottomToolbar.animate().translationY(bottomToolbar.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        bottomToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    private List<RecyclerPojo> getAllItemList() {

        List<RecyclerPojo> allItems = new ArrayList<>();
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}


