package com.example.user.qutof.Pojos;

import android.support.v7.widget.RecyclerView;

/**
 * Created by USER on 09-01-16.
 */
public class RecyclerPojo {

    private String offer;
    private String designer_name;
    private int item_image;

    public RecyclerPojo(String designer_name, String offer, int item_image) {
        this.offer = offer;
        this.designer_name = designer_name;
        this.item_image = item_image;
    }

    public String getOffer() {
        return offer;
    }

    public String getDesigner_name() {
        return designer_name;
    }

    public int getItem_image() {
        return item_image;
    }


    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setDesigner_name(String designer_name) {
        this.designer_name = designer_name;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
