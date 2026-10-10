package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements androidx.core.view.v, androidx.core.widget.n {
    private final C0303p mBackgroundTintHelper;
    private final C0307u mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a();
        }
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a();
        }
    }

    @Override // androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.b();
        }
        return null;
    }

    @Override // androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            return c0303p.c();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            return c0307u.b();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            return c0307u.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mImageHelper.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a();
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.b(colorStateList);
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0303p c0303p = this.mBackgroundTintHelper;
        if (c0303p != null) {
            c0303p.a(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0307u c0307u = this.mImageHelper;
        if (c0307u != null) {
            c0307u.a(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0303p(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mImageHelper = new C0307u(this);
        this.mImageHelper.a(attributeSet, i);
    }
}
