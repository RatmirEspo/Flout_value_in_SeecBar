package ru.ratmir.soft.notifycloudmassadges.costume;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

import ru.ratmir.soft.notifycloudmassadges.R;

/**
 * Created RATMIR on 16.05.2018.
 * Copyright © Ratmir
 */
public class FloatSeekBar extends android.support.v7.widget.AppCompatSeekBar
        implements SeekBar.OnSeekBarChangeListener  {
    private OnFloatSeekBarChangeListener floatListener;
    private float floatMaxValue = 100.f;
    private float floatProgress = 0.f;
    private float minProgress = 0.f;

    public float getMinProgress() {
        return minProgress;
    }

    public void setMin(float minProgress) {
        this.minProgress = minProgress;
        int middle = getMiddle(floatMaxValue, minProgress);
        super.setMax(middle);


    }

    private int getMiddle(float floatMaxValue, float minPrgress) {
        float v = floatMaxValue - minPrgress;
        int round = Math.round(v * 10);
        return round;
    }


    public float getFloatProgress() {
        return floatProgress;
    }

    public void setFloatProgress(float floatProgress) {
        this.floatProgress = floatProgress;
        int i = Math.round((floatProgress - minProgress) * 10);
        super.setProgress(i);

    }


    public FloatSeekBar(Context context) {
        super(context);
        this.setOnSeekBarChangeListener(this);

    }


    public FloatSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FloatSeekBar, 0, 0);

        floatMaxValue = typedArray.getFloat(R.styleable.FloatSeekBar_floatMax, 100f);
        minProgress = typedArray.getFloat(R.styleable.FloatSeekBar_floatMin, 0f);
        floatProgress = typedArray.getFloat(R.styleable.FloatSeekBar_progress, 0f);

        setFloatProgress(floatProgress);
        this.setOnSeekBarChangeListener(this);
    }

    public float getMaxProgress() {
        return floatMaxValue;
    }

    public void setMax(float value) {
        floatMaxValue = value;
        int middle = getMiddle(floatMaxValue, minProgress);
        super.setMax(middle);

    }


    public void setOnFloatSeekBarChangeListener(OnFloatSeekBarChangeListener floatListener) {
        this.floatListener = floatListener;
        int middle = getMiddle(floatMaxValue, minProgress);
        super.setMax(middle);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        floatProgress = minProgress + i / 10.0f;
        floatListener.onFloatSeekProgressChanged(seekBar, floatProgress, b);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        floatListener.onStartTrackingTouch(seekBar);

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        floatListener.onStopTrackingTouch(seekBar);
    }

    public static interface OnFloatSeekBarChangeListener {
        public void onFloatSeekProgressChanged(SeekBar seekBar, float i, boolean b);
        public void onStartTrackingTouch(SeekBar seekBar);
        public void onStopTrackingTouch(SeekBar seekBar);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}

