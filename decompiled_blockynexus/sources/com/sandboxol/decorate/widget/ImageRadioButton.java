package com.sandboxol.decorate.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRadioButton extends AppCompatRadioButton {
    private Bitmap bitmap;
    private Paint paint;

    public ImageRadioButton(Context context) {
        super(context);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (this.bitmap != null) {
                Rect rect = new Rect(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
                Rect rect2 = new Rect((int) (getMeasuredWidth() * 0.1f), (int) (getMeasuredHeight() * 0.1f), (int) (getMeasuredWidth() * 0.9f), (int) (getMeasuredHeight() * 0.9f));
                if (this.paint != null) {
                    canvas.drawBitmap(this.bitmap, rect, rect2, this.paint);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setUrlBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidate();
    }

    public ImageRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ImageRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
