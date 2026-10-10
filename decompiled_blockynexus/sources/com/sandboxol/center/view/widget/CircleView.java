package com.sandboxol.center.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class CircleView extends AppCompatTextView {
    private Context context;
    private Paint mPaint;
    private int radius;

    public CircleView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mPaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleView, i, 0);
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.CircleView_circleRadius, this.radius);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int dp2px(float f2) {
        return (int) ((f2 * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth() / 2;
        this.mPaint.setColor(-65536);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        float f2 = width;
        canvas.drawCircle(f2, f2, f2, this.mPaint);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init(context, attributeSet, i);
    }
}
