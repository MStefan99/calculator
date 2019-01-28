package com.annushkaproject.programmerscalculator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class CalculatorButton extends android.support.v7.widget.AppCompatButton {
    private Context context = getContext();
    private int verticalNumber;
    private int horizontalNumber;
    private float topOffset;
    private int width = context.getResources().getDisplayMetrics().widthPixels;
    private int height = context.getResources().getDisplayMetrics().heightPixels;

    public CalculatorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SquareButton,
                0, 0);
        try {
            int horizontalNumber = a.getInteger(R.styleable.SquareButton_horizontalNumber, 4);
            setHorizontalNumber(horizontalNumber);
            int verticalNumber = a.getInteger(R.styleable.SquareButton_verticalNumber, 5);
            setVerticalNumber(verticalNumber);
            float offset = a.getFloat(R.styleable.SquareButton_topOffset, .4f);
            setTopOffset(offset);
        } finally {
            a.recycle();
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int maxWidth = width / this.getHorizontalNumber();
        int maxHeight = Math.round(height * ( 1f - this.getTopOffset() ) / this.getVerticalNumber());
        int minDimension = Math.min(maxWidth, maxHeight);
        setMeasuredDimension(maxWidth, maxHeight);
    }

    public void setVerticalNumber(int height) {
        this.verticalNumber = height;
    }

    public void setTopOffset(float offset) {
        this.topOffset = offset;
    }

    public void setHorizontalNumber(int width) {
        this.horizontalNumber = width;
    }

    public int getVerticalNumber() {
        return this.verticalNumber;
    }

    public float getTopOffset() {
        return this.topOffset;
    }

    public int getHorizontalNumber() {
        return this.horizontalNumber;
    }
}