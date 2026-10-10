package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0303p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f674a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ga f677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ga f678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ga f679f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f676c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0305s f675b = C0305s.b();

    C0303p(View view) {
        this.f674a = view;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f677d != null : i == 21;
    }

    void a(AttributeSet attributeSet, int i) {
        ia iaVarA = ia.a(this.f674a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (iaVarA.g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f676c = iaVarA.g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListB = this.f675b.b(this.f674a.getContext(), this.f676c);
                if (colorStateListB != null) {
                    a(colorStateListB);
                }
            }
            if (iaVarA.g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.a(this.f674a, iaVarA.a(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (iaVarA.g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.a(this.f674a, F.a(iaVarA.d(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            iaVarA.a();
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.f678e == null) {
            this.f678e = new ga();
        }
        ga gaVar = this.f678e;
        gaVar.f654a = colorStateList;
        gaVar.f657d = true;
        a();
    }

    PorterDuff.Mode c() {
        ga gaVar = this.f678e;
        if (gaVar != null) {
            return gaVar.f655b;
        }
        return null;
    }

    ColorStateList b() {
        ga gaVar = this.f678e;
        if (gaVar != null) {
            return gaVar.f654a;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f679f == null) {
            this.f679f = new ga();
        }
        ga gaVar = this.f679f;
        gaVar.a();
        ColorStateList colorStateListE = ViewCompat.e(this.f674a);
        if (colorStateListE != null) {
            gaVar.f657d = true;
            gaVar.f654a = colorStateListE;
        }
        PorterDuff.Mode modeF = ViewCompat.f(this.f674a);
        if (modeF != null) {
            gaVar.f656c = true;
            gaVar.f655b = modeF;
        }
        if (!gaVar.f657d && !gaVar.f656c) {
            return false;
        }
        C0305s.a(drawable, gaVar, this.f674a.getDrawableState());
        return true;
    }

    void a(int i) {
        this.f676c = i;
        C0305s c0305s = this.f675b;
        a(c0305s != null ? c0305s.b(this.f674a.getContext(), i) : null);
        a();
    }

    void a(Drawable drawable) {
        this.f676c = -1;
        a((ColorStateList) null);
        a();
    }

    void a(PorterDuff.Mode mode) {
        if (this.f678e == null) {
            this.f678e = new ga();
        }
        ga gaVar = this.f678e;
        gaVar.f655b = mode;
        gaVar.f656c = true;
        a();
    }

    void a() {
        Drawable background = this.f674a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            ga gaVar = this.f678e;
            if (gaVar != null) {
                C0305s.a(background, gaVar, this.f674a.getDrawableState());
                return;
            }
            ga gaVar2 = this.f677d;
            if (gaVar2 != null) {
                C0305s.a(background, gaVar2, this.f674a.getDrawableState());
            }
        }
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f677d == null) {
                this.f677d = new ga();
            }
            ga gaVar = this.f677d;
            gaVar.f654a = colorStateList;
            gaVar.f657d = true;
        } else {
            this.f677d = null;
        }
        a();
    }
}
