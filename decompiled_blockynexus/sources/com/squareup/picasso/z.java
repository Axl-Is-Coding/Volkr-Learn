package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: PicassoDrawable.java */
/* JADX INFO: loaded from: classes5.dex */
final class z extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f19325a = new Paint();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f19327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Picasso.LoadedFrom f19328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f19329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f19330f;
    boolean g;
    int h;

    z(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.h = 255;
        this.f19326b = z2;
        this.f19327c = context.getResources().getDisplayMetrics().density;
        this.f19328d = loadedFrom;
        if ((loadedFrom == Picasso.LoadedFrom.MEMORY || z) ? false : true) {
            this.f19329e = drawable;
            this.g = true;
            this.f19330f = SystemClock.uptimeMillis();
        }
    }

    static void a(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new z(context, bitmap, drawable, loadedFrom, z, z2));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.g) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f19330f) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.g = false;
                this.f19329e = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f19329e;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.h * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.h);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f19326b) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f19329e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.h = i;
        Drawable drawable = this.f19329e;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f19329e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private void a(Canvas canvas) {
        f19325a.setColor(-1);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f19327c * 16.0f)), f19325a);
        f19325a.setColor(this.f19328d.debugColor);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f19327c * 15.0f)), f19325a);
    }

    private static Path a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
