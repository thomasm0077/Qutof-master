package com.example.user.qutof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.example.user.qutof.Adapters.SpinnerAdapter;
import com.example.user.qutof.Pojos.SpinnerData;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        b1 = (Button) findViewById(R.id.splash_screen_button1);
        b2 = (Button) findViewById(R.id.splash_screen_button2);
        ArrayList<SpinnerData> list = new ArrayList<>();
        list.add(new SpinnerData("Kuwait", R.drawable.flag1));
        list.add(new SpinnerData("India", R.drawable.flag1));
        list.add(new SpinnerData("Japan", R.drawable.flag1));
        list.add(new SpinnerData("China", R.drawable.flag1));
        Spinner sp = (Spinner) findViewById(R.id.splash_screen_spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.custom_spinner_layout, R.id.txt, list);
        sp.setAdapter(adapter);

    }
}
