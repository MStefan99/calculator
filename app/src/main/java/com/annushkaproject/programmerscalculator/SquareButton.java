package com.annushkaproject.programmerscalculator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class SquareButton extends Button {
    Context context = getContext();
    int width = context.getResources().getDisplayMetrics().widthPixels;

    public SquareButton(Context context) {
        super(context);
    }

    public SquareButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(width/4, width/4); // make it square

    }
}