package com.ardenolgundemir.template.controller.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by ardenolgundemir on 20/10/16.
 */

public class TextViewRegular extends android.support.v7.widget.AppCompatTextView {
    Context context = null;

    public TextViewRegular(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Nunito-Regular.ttf");
        setTypeface(font);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
    }
}