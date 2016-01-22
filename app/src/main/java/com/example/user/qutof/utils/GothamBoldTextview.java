package com.example.user.qutof.utils;

/**
 * Created by USER on 20-01-16.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by USER on 19-01-16.
 */
public class GothamBoldTextview extends TextView {
    public GothamBoldTextview(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public GothamBoldTextview(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public GothamBoldTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("gotham-bold.ttf", context);
        setTypeface(customFont);
    }

}
