package com.example.user.qutof;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.qutof.Adapters.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by USER on 14-01-16.
 */
public class Clothings extends AppCompatActivity {


    ListView lv;
    Context context;
    Toolbar t1,t2;
    ImageView im;

    ArrayList prgmName;
   // public static int [] prgmImages={R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript","Thomas","Anju","Hellow World","Hello","Hai"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothings);

        t1= (Toolbar) findViewById(R.id.clothings_layout_topToolbar);
        t2= (Toolbar) findViewById(R.id.clothing_layout_bottomToolbar);
        setSupportActionBar(t1);
        //im= (ImageView) t1.findViewById(R.id.clothings_toolbar_imageView);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        context=this;

        lv=(ListView) findViewById(R.id.clothings_layout_listView);
        lv.setVerticalScrollBarEnabled(false);
        lv.setAdapter(new CustomAdapter(this, prgmNameList /*,prgmImages*/));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
