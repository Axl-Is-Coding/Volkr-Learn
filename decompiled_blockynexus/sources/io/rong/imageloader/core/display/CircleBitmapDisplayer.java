package io.rong.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.imageaware.ImageAware;
import io.rong.imageloader.core.imageaware.ImageViewAware;

/* JADX INFO: loaded from: classes5.dex */
public class CircleBitmapDisplayer implements BitmapDisplayer {
    protected final Integer strokeColor;
    protected final float strokeWidth;

    public static class CircleDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final Paint paint;
        protected float radius;
        protected final Paint strokePaint;
        protected float strokeRadius;
        protected final float strokeWidth;

        public CircleDrawable(Bitmap bitmap, Integer num, float f2) {
            this.radius = Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapRect = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, bitmap.getWidth(), bitmap.getHeight());
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
            if (num == null) {
                this.strokePaint = null;
            } else {
                this.strokePaint = new Paint();
                this.strokePaint.setStyle(Paint.Style.STROKE);
                this.strokePaint.setColor(num.intValue());
                this.strokePaint.setStrokeWidth(f2);
                this.strokePaint.setAntiAlias(true);
            }
            this.strokeWidth = f2;
            this.strokeRadius = this.radius - (f2 / 2.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float f2 = this.radius;
            canvas.drawCircle(f2, f2, f2, this.paint);
            Paint paint = this.strokePaint;
            if (paint != null) {
                float f3 = this.radius;
                canvas.drawCircle(f3, f3, this.strokeRadius, paint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.mRect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, rect.width(), rect.height());
            this.radius = Math.min(rect.width(), rect.height()) / 2;
            this.strokeRadius = this.radius - (this.strokeWidth / 2.0f);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.paint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public CircleBitmapDisplayer() {
        this(null);
    }

    @Override // io.rong.imageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new CircleDrawable(bitmap, this.strokeColor, this.strokeWidth));
    }

    public CircleBitmapDisplayer(Integer num) {
        this(num, WheelView.DividerConfig.FILL);
    }

    public CircleBitmapDisplayer(Integer num, float f2) {
        this.strokeColor = num;
        this.strokeWidth = f2;
    }
}
