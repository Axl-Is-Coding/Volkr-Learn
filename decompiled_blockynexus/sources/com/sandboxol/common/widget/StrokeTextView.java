package com.sandboxol.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.R;
import java.lang.reflect.Field;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class StrokeTextView extends AppCompatTextView {
    private static final int HORIZENTAL = 0;
    private static final int VERTICAL = 1;
    private boolean gradientChanged;
    private LinearGradient mGradient;
    private int[] mGradientColor;
    private int mGradientOrientation;
    private TextPaint mPaint;
    private int mStrokeColor;
    private int mStrokeWidth;
    private int mTextColor;

    public StrokeTextView(Context context) {
        super(context);
        this.mStrokeColor = -16777216;
        init(context, null);
    }

    private LinearGradient getGradient() {
        return this.mGradientOrientation == 0 ? new LinearGradient(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getWidth(), WheelView.DividerConfig.FILL, this.mGradientColor, (float[]) null, Shader.TileMode.CLAMP) : new LinearGradient(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getHeight(), this.mGradientColor, (float[]) null, Shader.TileMode.CLAMP);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mPaint = getPaint();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StrokeTextView);
            this.mStrokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.StrokeTextView_strokeColor, -16777216);
            this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StrokeTextView_strokeWidth, 0);
            this.mGradientOrientation = typedArrayObtainStyledAttributes.getInt(R.styleable.StrokeTextView_gradientOrientation, 0);
            setStrokeColor(this.mStrokeColor);
            setStrokeWidth(this.mStrokeWidth);
            setGradientOrientation(this.mGradientOrientation);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void setColor(int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCurTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i));
            declaredField.setAccessible(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mPaint.setColor(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mStrokeWidth <= 0) {
            super.onDraw(canvas);
            return;
        }
        this.mTextColor = getCurrentTextColor();
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setFakeBoldText(true);
        this.mPaint.setShadowLayer(this.mStrokeWidth, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        setColor(this.mStrokeColor);
        this.mPaint.setShader(null);
        super.onDraw(canvas);
        if (this.gradientChanged) {
            if (this.mGradientColor != null) {
                this.mGradient = getGradient();
            }
            this.gradientChanged = false;
        }
        LinearGradient linearGradient = this.mGradient;
        if (linearGradient != null) {
            this.mPaint.setShader(linearGradient);
            this.mPaint.setColor(-1);
        } else {
            setColor(this.mTextColor);
        }
        this.mPaint.setStrokeWidth(WheelView.DividerConfig.FILL);
        this.mPaint.setShadowLayer(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
        super.onDraw(canvas);
    }

    public void setGradientColor(int[] iArr) {
        if (Arrays.equals(iArr, this.mGradientColor)) {
            return;
        }
        this.mGradientColor = iArr;
        this.gradientChanged = true;
        invalidate();
    }

    public void setGradientOrientation(int i) {
        if (this.mGradientOrientation != i) {
            this.mGradientOrientation = i;
            this.gradientChanged = true;
            invalidate();
        }
    }

    public void setStrokeColor(int i) {
        if (this.mStrokeColor != i) {
            this.mStrokeColor = i;
            invalidate();
        }
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        invalidate();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStrokeColor = -16777216;
        init(context, attributeSet);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrokeColor = -16777216;
        init(context, attributeSet);
    }
}
