package com.sandboxol.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sandboxol.common.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class TimeCountDownView extends LinearLayout {
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
    private int hour;
    private boolean isRunning;
    private boolean isShowUnit;
    private int minute;
    private int second;
    private TextView secondDelimiterView;
    private TextView secondTimeView;
    private int text_size;
    private TextView thirdTimeView;
    private CountDownTimer timer;

    public interface OnTimeOver {
        void onFinish();
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }

    public TimeCountDownView(Context context) {
        this(context, null);
    }

    private void initView() {
        this.firstTimeView = (TextView) findViewById(R.id.tv_first);
        this.secondTimeView = (TextView) findViewById(R.id.tv_second);
        this.thirdTimeView = (TextView) findViewById(R.id.tv_third);
        this.firstDelimiterView = (TextView) findViewById(R.id.tv_delimiter_1);
        this.secondDelimiterView = (TextView) findViewById(R.id.tv_delimiter_2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void timeFormat(int i) {
        this.day = i / 86400;
        this.hour = (i % 86400) / 3600;
        this.minute = (i % 3600) / 60;
        this.second = i % 60;
    }

    public void closeTimer() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
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
                        sb.append(this.context.getString(R.string.time_count_down_unit_day));
                    } else {
                        sb.append(this.context.getString(R.string.time_count_down_unit_day_cap));
                    }
                    break;
                case 101:
                    if (!z) {
                        sb.append(this.context.getString(R.string.time_count_down_unit_hour));
                    } else {
                        sb.append(this.context.getString(R.string.time_count_down_unit_hour_cap));
                    }
                    break;
                case 102:
                    if (!z) {
                        sb.append(this.context.getString(R.string.time_count_down_unit_minute));
                    } else {
                        sb.append(this.context.getString(R.string.time_count_down_unit_minute_cap));
                    }
                    break;
                case 103:
                    if (!z) {
                        sb.append(this.context.getString(R.string.time_count_down_unit_second));
                    } else {
                        sb.append(this.context.getString(R.string.time_count_down_unit_second_cap));
                    }
                    break;
            }
        }
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        closeTimer();
        super.onDetachedFromWindow();
    }

    public void setTime(long j, int i, int i2, boolean z, OnTimeOver onTimeOver) {
        setTime(j, i, i2, 0, z, onTimeOver);
    }

    public TimeCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTime(long j, final int i, final int i2, final int i3, final boolean z, final OnTimeOver onTimeOver) {
        long j2;
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        long j3 = i3 == 102 ? 60000L : 1000L;
        if (i3 == 0) {
            if (i2 != 101) {
                j2 = i2 == 102 ? 60L : 3600L;
            }
            j3 *= j2;
        }
        this.timer = new CountDownTimer(j, j3) { // from class: com.sandboxol.common.widget.TimeCountDownView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                OnTimeOver onTimeOver2 = onTimeOver;
                if (onTimeOver2 != null) {
                    onTimeOver2.onFinish();
                }
                cancel();
                TimeCountDownView.this.isRunning = false;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                try {
                    TimeCountDownView.this.timeFormat((int) (j4 / 1000));
                    TimeCountDownView.this.firstTimeView.setText(TimeCountDownView.this.forMatString(i, z));
                    TimeCountDownView.this.secondTimeView.setText(TimeCountDownView.this.forMatString(i2, z));
                    if (i3 == 0) {
                        TimeCountDownView.this.secondDelimiterView.setVisibility(8);
                        TimeCountDownView.this.thirdTimeView.setVisibility(8);
                    } else {
                        TimeCountDownView.this.thirdTimeView.setText(TimeCountDownView.this.forMatString(i3, z));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cancel();
                    TimeCountDownView.this.isRunning = false;
                }
            }
        }.start();
    }

    public TimeCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.text_size = 10;
        this.context = context;
        LinearLayout.inflate(context, R.layout.layout_timer, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TimeCountDownView);
        this.text_size = typedArrayObtainStyledAttributes.getInteger(R.styleable.TimeCountDownView_text_size, this.text_size);
        this.color_text = typedArrayObtainStyledAttributes.getString(R.styleable.TimeCountDownView_text_color);
        this.delimiter_1 = typedArrayObtainStyledAttributes.getString(R.styleable.TimeCountDownView_delimiter_1);
        if (TextUtils.isEmpty(this.delimiter_1)) {
            this.delimiter_1 = " ";
        }
        this.delimiter_2 = typedArrayObtainStyledAttributes.getString(R.styleable.TimeCountDownView_delimiter_2);
        if (TextUtils.isEmpty(this.delimiter_2)) {
            this.delimiter_2 = " ";
        }
        this.isShowUnit = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TimeCountDownView_isShowUnit, false);
        typedArrayObtainStyledAttributes.recycle();
        initView();
    }
}
