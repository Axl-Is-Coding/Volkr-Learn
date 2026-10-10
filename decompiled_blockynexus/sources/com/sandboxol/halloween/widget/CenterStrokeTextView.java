package com.sandboxol.halloween.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.halloween.R;

/* JADX INFO: loaded from: classes4.dex */
public class CenterStrokeTextView extends AppCompatTextView {
    private Paint mPaint;
    private int mStrokeColor;
    private int mStrokeWidth;

    public CenterStrokeTextView(Context context) {
        super(context);
        this.mStrokeColor = -16777216;
        this.mStrokeWidth = 0;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mPaint = getPaint();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CenterStrokeTextView);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.CenterStrokeTextView_startColor);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.CenterStrokeTextView_endColor);
            this.mStrokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CenterStrokeTextView_stroke_color, -16777216);
            this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CenterStrokeTextView_stroke_width, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return;
            }
            getPaint().setShader(new LinearGradient(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getLineHeight(), Color.parseColor(string), Color.parseColor(string2), Shader.TileMode.REPEAT));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        ColorStateList textColors = getTextColors();
        this.mPaint.setFakeBoldText(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        setTextColor(this.mStrokeColor);
        setGravity(17);
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        setTextColor(textColors);
        setGravity(17);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth() + this.mStrokeWidth, getMeasuredHeight() + this.mStrokeWidth);
    }

    public CenterStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStrokeColor = -16777216;
        this.mStrokeWidth = 0;
        init(context, attributeSet);
    }

    public CenterStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrokeColor = -16777216;
        this.mStrokeWidth = 0;
        init(context, attributeSet);
    }
}
