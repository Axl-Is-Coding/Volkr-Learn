package com.sandboxol.center.view.widget.counDownView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sandboxol.center.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class NormalCountDownView extends LinearLayout implements ICountDownProvider {
    public static final int UNIT_DAY = 100;
    public static final int UNIT_HOUR = 101;
    public static final int UNIT_MINUTE = 102;
    public static final int UNIT_NULL = 0;
    public static final int UNIT_SECOND = 103;
    private String color_text;
    private Context context;
    private int day;
    private String delimiter_1;
    private String delimiter_2;
    private TextView firstDelimiterView;
    private TextView firstTimeView;
    private int firstUnit;
    private int hour;
    private boolean isCap;
    private boolean isShowUnit;
    private int minute;
    private NormalCountDownTimer normalCountDownTimer;
    private int second;
    private TextView secondDelimiterView;
    private TextView secondTimeView;
    private int secondUnit;
    private int text_size;
    private TextView thirdTimeView;
    private int thirdUnit;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }

    public NormalCountDownView(Context context) {
        this(context, null);
    }

    private void initView() {
        this.firstTimeView = (TextView) findViewById(R.id.base_tv_first);
        this.secondTimeView = (TextView) findViewById(R.id.base_tv_second);
        this.thirdTimeView = (TextView) findViewById(R.id.base_tv_third);
        this.firstDelimiterView = (TextView) findViewById(R.id.base_tv_delimiter_1);
        this.secondDelimiterView = (TextView) findViewById(R.id.base_tv_delimiter_2);
        try {
            this.firstTimeView.setTextColor(Color.parseColor(this.color_text));
            this.secondTimeView.setTextColor(Color.parseColor(this.color_text));
            this.thirdTimeView.setTextColor(Color.parseColor(this.color_text));
            this.firstDelimiterView.setTextColor(Color.parseColor(this.color_text));
            this.secondDelimiterView.setTextColor(Color.parseColor(this.color_text));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.firstTimeView.setTextSize(this.text_size);
        this.secondTimeView.setTextSize(this.text_size);
        this.thirdTimeView.setTextSize(this.text_size);
        this.firstDelimiterView.setTextSize(this.text_size);
        this.secondDelimiterView.setTextSize(this.text_size);
        this.firstDelimiterView.setText(this.delimiter_1);
        this.secondDelimiterView.setText(this.delimiter_2);
    }

    private void onUpdateTime(long j) {
        timeFormat((int) (j / 1000));
        this.firstTimeView.setText(forMatString(this.firstUnit, this.isCap));
        this.secondTimeView.setText(forMatString(this.secondUnit, this.isCap));
        int i = this.thirdUnit;
        if (i != 0) {
            this.thirdTimeView.setText(forMatString(i, this.isCap));
        } else {
            this.secondDelimiterView.setVisibility(8);
            this.thirdTimeView.setVisibility(8);
        }
    }

    private void timeFormat(int i) {
        this.day = i / 86400;
        this.hour = (i % 86400) / 3600;
        this.minute = (i % 3600) / 60;
        this.second = i % 60;
    }

    public void bindFormat(int i, int i2, int i3, boolean z) {
        this.firstUnit = i;
        this.secondUnit = i2;
        this.thirdUnit = i3;
        this.isCap = z;
    }

    public String forMatString(int i, boolean z) {
        int i2;
        switch (i) {
            case 100:
                i2 = this.day;
                break;
            case 101:
                i2 = this.hour;
                break;
            case 102:
                i2 = this.minute;
                break;
            case 103:
                i2 = this.second;
                break;
            default:
                i2 = 0;
                break;
        }
        StringBuilder sb = new StringBuilder();
        if (i == 100 || String.valueOf(i2).length() != 1) {
            sb.append(i2);
        } else {
            sb.append("0" + i2);
        }
        if (this.isShowUnit) {
            switch (i) {
                case 100:
                    if (!z) {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_day));
                    } else {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_day_cap));
                    }
                    break;
                case 101:
                    if (!z) {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_hour));
                    } else {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_hour_cap));
                    }
                    break;
                case 102:
                    if (!z) {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_minute));
                    } else {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_minute_cap));
                    }
                    break;
                case 103:
                    if (!z) {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_second));
                    } else {
                        sb.append(this.context.getString(com.sandboxol.common.R.string.time_count_down_unit_second_cap));
                    }
                    break;
            }
        }
        return sb.toString();
    }

    public void onBindCountDownTimer(NormalCountDownTimer normalCountDownTimer) {
        this.normalCountDownTimer = normalCountDownTimer;
        if (normalCountDownTimer != null) {
            this.normalCountDownTimer.setiCountDownProvider(this);
        }
    }

    @Override // com.sandboxol.center.view.widget.counDownView.ICountDownProvider
    public void onUpdate(long j) {
        onUpdateTime(j);
    }

    public NormalCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NormalCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.text_size = 10;
        this.context = context;
        LinearLayout.inflate(context, R.layout.base_layout_timer, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseTimeCountDownView);
        this.text_size = typedArrayObtainStyledAttributes.getInteger(R.styleable.BaseTimeCountDownView_base_text_size, this.text_size);
        this.color_text = typedArrayObtainStyledAttributes.getString(R.styleable.BaseTimeCountDownView_base_text_color);
        this.delimiter_1 = typedArrayObtainStyledAttributes.getString(R.styleable.BaseTimeCountDownView_base_delimiter_1);
        if (TextUtils.isEmpty(this.delimiter_1)) {
            this.delimiter_1 = " ";
        }
        this.delimiter_2 = typedArrayObtainStyledAttributes.getString(R.styleable.BaseTimeCountDownView_base_delimiter_2);
        if (TextUtils.isEmpty(this.delimiter_2)) {
            this.delimiter_2 = " ";
        }
        this.isShowUnit = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseTimeCountDownView_base_isShowUnit, false);
        typedArrayObtainStyledAttributes.recycle();
        initView();
    }
}
