package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;

/* JADX INFO: renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0307u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ga f712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ga f713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ga f714d;

    public C0307u(ImageView imageView) {
        this.f711a = imageView;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f712b != null : i == 21;
    }

    public void a(AttributeSet attributeSet, int i) {
        int iG;
        ia iaVarA = ia.a(this.f711a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f711a.getDrawable();
            if (drawable == null && (iG = iaVarA.g(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f711a.getContext(), iG)) != null) {
                this.f711a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                F.b(drawable);
            }
            if (iaVarA.g(R.styleable.AppCompatImageView_tint)) {
                androidx.core.widget.g.a(this.f711a, iaVarA.a(R.styleable.AppCompatImageView_tint));
            }
            if (iaVarA.g(R.styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.g.a(this.f711a, F.a(iaVarA.d(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            iaVarA.a();
        }
    }

    ColorStateList b() {
        ga gaVar = this.f713c;
        if (gaVar != null) {
            return gaVar.f654a;
        }
        return null;
    }

    PorterDuff.Mode c() {
        ga gaVar = this.f713c;
        if (gaVar != null) {
            return gaVar.f655b;
        }
        return null;
    }

    boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f711a.getBackground() instanceof RippleDrawable);
    }

    public void a(int i) {
        if (i != 0) {
            Drawable drawableB = androidx.appcompat.a.a.a.b(this.f711a.getContext(), i);
            if (drawableB != null) {
                F.b(drawableB);
            }
            this.f711a.setImageDrawable(drawableB);
        } else {
            this.f711a.setImageDrawable(null);
        }
        a();
    }

    void a(ColorStateList colorStateList) {
        if (this.f713c == null) {
            this.f713c = new ga();
        }
        ga gaVar = this.f713c;
        gaVar.f654a = colorStateList;
        gaVar.f657d = true;
        a();
    }

    void a(PorterDuff.Mode mode) {
        if (this.f713c == null) {
            this.f713c = new ga();
        }
        ga gaVar = this.f713c;
        gaVar.f655b = mode;
        gaVar.f656c = true;
        a();
    }

    void a() {
        Drawable drawable = this.f711a.getDrawable();
        if (drawable != null) {
            F.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            ga gaVar = this.f713c;
            if (gaVar != null) {
                C0305s.a(drawable, gaVar, this.f711a.getDrawableState());
                return;
            }
            ga gaVar2 = this.f712b;
            if (gaVar2 != null) {
                C0305s.a(drawable, gaVar2, this.f711a.getDrawableState());
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.f714d == null) {
            this.f714d = new ga();
        }
        ga gaVar = this.f714d;
        gaVar.a();
        ColorStateList colorStateListA = androidx.core.widget.g.a(this.f711a);
        if (colorStateListA != null) {
            gaVar.f657d = true;
            gaVar.f654a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.g.b(this.f711a);
        if (modeB != null) {
            gaVar.f656c = true;
            gaVar.f655b = modeB;
        }
        if (!gaVar.f657d && !gaVar.f656c) {
            return false;
        }
        C0305s.a(drawable, gaVar, this.f711a.getDrawableState());
        return true;
    }
}
