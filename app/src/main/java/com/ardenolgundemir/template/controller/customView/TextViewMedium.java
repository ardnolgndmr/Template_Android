package com.ardenolgundemir.template.controller.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by ardenolgundemir on 11/09/2017.
 */

public class TextViewMedium extends android.support.v7.widget.AppCompatTextView {
    Context context = null;

    public TextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Medium.ttf");
        setTypeface(font);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
    }
}