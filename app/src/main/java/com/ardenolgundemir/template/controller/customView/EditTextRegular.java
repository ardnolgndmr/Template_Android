package com.ardenolgundemir.template.controller.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by ardenolgundemir on 18/01/2017.
 */

public class EditTextRegular extends android.support.v7.widget.AppCompatEditText {
    Context context = null;

    public EditTextRegular(Context context, AttributeSet attrs) {
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