package com.example.user.qutof.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by USER on 19-01-16.
 */
public class GothamBookTextview extends TextView {
    public GothamBookTextview(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public GothamBookTextview(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public GothamBookTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("gotham-book.ttf", context);
        setTypeface(customFont);
    }

}
