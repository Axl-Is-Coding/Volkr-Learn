package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class OverlayImageView extends ImageView {
    a overlay;

    public OverlayImageView(Context context) {
        super(context);
        this.overlay = new a(null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.overlay.a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.overlay.f20376a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.overlay.a(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.overlay.a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.overlay.a(i, i2);
    }

    public void setOverlayDrawable(Drawable drawable) {
        a aVar = this.overlay;
        if (drawable != aVar.f20376a) {
            aVar.a(this);
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.overlay = new a(drawable);
            this.overlay.a(getDrawableState());
            requestLayout();
        }
    }

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Drawable f20376a;

        a(Drawable drawable) {
            this.f20376a = drawable;
        }

        protected void a(ImageView imageView) {
            Drawable drawable = this.f20376a;
            if (drawable != null) {
                drawable.setCallback(null);
                imageView.unscheduleDrawable(this.f20376a);
            }
        }

        protected void a(int i, int i2) {
            Drawable drawable = this.f20376a;
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i2);
            }
        }

        protected void a(int[] iArr) {
            Drawable drawable = this.f20376a;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.f20376a.setState(iArr);
        }

        protected void a(Canvas canvas) {
            Drawable drawable = this.f20376a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    public OverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.overlay = new a(null);
    }
}
