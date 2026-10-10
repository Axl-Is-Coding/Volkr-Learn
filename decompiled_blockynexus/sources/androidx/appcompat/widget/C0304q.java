package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;

/* JADX INFO: renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0304q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f682b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f683c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f684d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f685e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f686f;

    C0304q(CompoundButton compoundButton) {
        this.f681a = compoundButton;
    }

    void a(AttributeSet attributeSet, int i) {
        boolean z;
        int resourceId;
        int resourceId2;
        TypedArray typedArrayObtainStyledAttributes = this.f681a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonCompat) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.f681a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f681a.getContext(), resourceId2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z && typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f681a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f681a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.c.a(this.f681a, typedArrayObtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.a(this.f681a, F.a(typedArrayObtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    ColorStateList b() {
        return this.f682b;
    }

    PorterDuff.Mode c() {
        return this.f683c;
    }

    void d() {
        if (this.f686f) {
            this.f686f = false;
        } else {
            this.f686f = true;
            a();
        }
    }

    void a(ColorStateList colorStateList) {
        this.f682b = colorStateList;
        this.f684d = true;
        a();
    }

    void a(PorterDuff.Mode mode) {
        this.f683c = mode;
        this.f685e = true;
        a();
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f681a);
        if (drawableA != null) {
            if (this.f684d || this.f685e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.i(drawableA).mutate();
                if (this.f684d) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.f682b);
                }
                if (this.f685e) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.f683c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f681a.getDrawableState());
                }
                this.f681a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int a(int i) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.c.a(this.f681a)) == null) ? i : i + drawableA.getIntrinsicWidth();
    }
}
