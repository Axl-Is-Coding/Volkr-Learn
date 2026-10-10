package com.sandboxol.decorate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.decorate.R;

/* JADX INFO: loaded from: classes3.dex */
public class DiscountTextView extends AppCompatTextView {
    private Paint paint;

    public DiscountTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(WheelView.DividerConfig.FILL, getMeasuredHeight() / 2, getMeasuredWidth(), getMeasuredHeight() / 2, this.paint);
    }

    public DiscountTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DiscountTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiscountTextView);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.DiscountTextView_lineColor, -16777216);
        this.paint = new Paint();
        this.paint.setColor(color);
        this.paint.setStrokeWidth(2.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
