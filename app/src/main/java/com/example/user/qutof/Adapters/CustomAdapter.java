package com.example.user.qutof.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.qutof.Clothings;
import com.example.user.qutof.R;

/**
 * Created by USER on 14-01-16.
 */
public class CustomAdapter extends BaseAdapter {

    String [] result;
   // int[] images;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Clothings c, String[] prgmNameList/*, int[] prgmImages*/) {

        result=prgmNameList;
        //images=prgmImages;
        context=c;

        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView iv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.clothings_custom, null);
        holder.tv=(TextView) rowView.findViewById(R.id.clothings_custom_textView1);
        //holder.iv= (ImageView) rowView.findViewById(R.id.clothings_custom_imageView1);
        holder.tv.setText(result[position]);
       // holder.iv.setImageResource(R.drawable.next);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
