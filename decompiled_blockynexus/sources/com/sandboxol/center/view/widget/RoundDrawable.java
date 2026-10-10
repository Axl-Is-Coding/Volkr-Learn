package com.sandboxol.center.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.sandboxol.common.utils.SizeUtil;

/* JADX INFO: loaded from: classes3.dex */
public class RoundDrawable extends Drawable {
    private Bitmap bitmap;
    private BitmapShader bitmapShader;
    private Context context;
    private Paint paint;
    private RectF rectF;
    private float roundX;
    private float roundY;

    public RoundDrawable(Context context, Bitmap bitmap, int i, int i2) {
        this.context = context;
        this.bitmap = bitmap;
        this.roundX = i;
        this.roundY = i2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setShader(this.bitmapShader);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.rectF, (int) SizeUtil.dp2px(this.context, this.roundX), (int) SizeUtil.dp2px(this.context, this.roundY), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.bitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.rectF = new RectF(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
