package com.example.user.qutof;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
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
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.user.qutof.Adapters.HeaderRecyclerAdapter;
import com.example.user.qutof.JSON.JSONParser;
import com.example.user.qutof.Pojos.RecyclerPojo;
import com.example.user.qutof.Recycler.RecyclerDecorations;
import com.example.user.qutof.utils.HidingScrollListener;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 09-01-16.
 */
public class Featured extends AppCompatActivity {

    RecyclerView rv;
    Toolbar toolbar,bottomToolbar;
    private ProgressDialog pDialog;
    JSONParser jp=new JSONParser();
    JSONObject jobj;
    List<RecyclerPojo> rowListItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.featured_layout);

        toolbar=(Toolbar)findViewById(R.id.featured_toptoolbar);
        bottomToolbar=(Toolbar)findViewById(R.id.featured_bottomToolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main_menu);

        initializeRecyclerView();
        rowListItem=getAllItemList();

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

            //new getImages().execute("");

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
        final HeaderRecyclerAdapter adapter = new HeaderRecyclerAdapter(getAllItemList());
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
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo1));
        allItems.add(new RecyclerPojo("HIJAB FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("HIJAB FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("HIJAB FASHION", "Extra 30%", R.drawable.demo3));
        allItems.add(new RecyclerPojo("ABHAYA FASHION", "Extra 30%", R.drawable.demo2));
        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private class getImages extends AsyncTask<String, String, String>{

        String resultedData = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Featured.this);
            pDialog.setMessage("Please Wait....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {


            List<NameValuePair> params1 = new ArrayList<NameValuePair>();
            try {
                String h = "http://qutofv2.anathothonline.us/Bannerweb.asmx/GetSingleBannerold";
                //resultedData = jsonparser.getJSON(h);
                resultedData=jp.makeHttpRequest(h,"GET",params1);
            } catch (Exception ex) {
                resultedData = "There's an error, that's all I know right now.. :(";
            }
            return resultedData;

        }


        @Override
        protected void onPostExecute(String s) {

            pDialog.dismiss();
            try{
                ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();
                JSONArray jarray = new JSONArray(s);
                for (int i = 0; i < jarray.length(); i++) {
                    Map<String, String> datanum = new HashMap<String, String>();
                    jobj = jarray.getJSONObject(i);
                    datanum.put("offers", jobj.getString("caption"));
                    datanum.put("designer_name", jobj.getString("captionar"));
                    data.add(datanum);
                }


//                int[] views = {R.id.featured_grid_textView1,R.id.featured_grid_textView2};
//                String[] from = {"offers","designer_name"};
//                final SimpleAdapter ADA = new SimpleAdapter(Featured.this,
//                        data, R.layout.featured_grid, from, views);
//                rv.setAdapter(ADA);

            }catch(Exception e){

            }
        }
    }
}


