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
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.imageaware.ImageAware;
import io.rong.imageloader.core.imageaware.ImageViewAware;

/* JADX INFO: loaded from: classes5.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    protected final int cornerRadius;
    protected final int margin;

    public static class RoundedDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final int margin;
        protected final Paint paint;

        public RoundedDrawable(Bitmap bitmap, int i, int i2) {
            this.cornerRadius = i;
            this.margin = i2;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            float f2 = i2;
            this.mBitmapRect = new RectF(f2, f2, bitmap.getWidth() - i2, bitmap.getHeight() - i2);
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setShader(this.bitmapShader);
            this.paint.setFilterBitmap(true);
            this.paint.setDither(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f2 = this.cornerRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i = this.margin;
            rectF.set(i, i, rect.width() - this.margin, rect.height() - this.margin);
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

    public RoundedBitmapDisplayer(int i) {
        this(i, 0);
    }

    @Override // io.rong.imageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new RoundedDrawable(bitmap, this.cornerRadius, this.margin));
    }

    public RoundedBitmapDisplayer(int i, int i2) {
        this.cornerRadius = i;
        this.margin = i2;
    }
}
