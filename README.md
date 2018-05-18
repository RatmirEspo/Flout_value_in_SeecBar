# Example Flout value in Android SeecBar

## How to use

### marking:
```xml
<TextView
        android:id="@+id/msg"
        android:layout_marginTop="40dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:singleLine="false"
        android:lines="4"
        android:text="0.0"
        android:textSize="38sp"
        android:textStyle="bold"
        android:textColor="@android:color/black"
        android:textAlignment="center"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"/>
```

### Code

```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.msg);
        FloatSeekBar seek = findViewById(R.id.cosSeeck);

        seek.setOnFloatSeekBarChangeListener(new FloatSeekBar.OnFloatSeekBarChangeListener() {
            @Override
            public void onFloatSeekProgressChanged(SeekBar seekBar, float i, boolean b) {
                txt.setText(String.format("%.1f", i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }
```
### FloatSeekBar class

```java
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
```

![IMAGE 2018-05-18 13:30:26](https://lh3.googleusercontent.com/-PzukNGFG0cM/Wv6rlgE3R-I/AAAAAAAACbU/vdjIHCoKKtUv4hh_3dDQuNYfBJ2KbMWmQCHMYCw/I/IMAGE%2B2018-05-18%2B13%253A30%253A26.jpg)

![IMAGE 2018-05-18 13:30:27](https://lh3.googleusercontent.com/-eqRmuPIrFyU/Wv6rtS3SOpI/AAAAAAAACbY/fywpg7lEyy8s2rh9u0MZicM_8GEGDYOgwCHMYCw/I/IMAGE%2B2018-05-18%2B13%253A30%253A27.jpg)

![IMAGE 2018-05-18 13:30:29](https://lh3.googleusercontent.com/--uC_7oJIizo/Wv6rvdPfuCI/AAAAAAAACbc/7r_73yT41mQvxpmq5iU8owTyxPT75fEsQCHMYCw/I/IMAGE%2B2018-05-18%2B13%253A30%253A29.jpg)

![IMAGE 2018-05-18 13:30:32](https://lh3.googleusercontent.com/-aUSQCf9-zIc/Wv6rx96GgWI/AAAAAAAACbg/a2MIf2nIhTkhM4Fgshp0sETF8mlHSnmfgCHMYCw/I/IMAGE%2B2018-05-18%2B13%253A30%253A32.jpg)




