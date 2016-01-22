package com.example.user.qutof.Pojos;

/**
 * Created by USER on 06-01-16.
 */
public class SpinnerData {

    String text;
    Integer imageId;
    public SpinnerData(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}
