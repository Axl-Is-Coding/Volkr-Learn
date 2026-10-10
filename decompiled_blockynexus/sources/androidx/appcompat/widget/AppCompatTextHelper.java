package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.a.h;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ga f506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ga f507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ga f508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ga f509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ga f510f;
    private ga g;
    private ga h;
    private final E i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    private static class a extends h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<AppCompatTextHelper> f511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f513c;

        /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatTextHelper$a$a, reason: collision with other inner class name */
        private class RunnableC0004a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<AppCompatTextHelper> f514a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Typeface f515b;

            RunnableC0004a(WeakReference<AppCompatTextHelper> weakReference, Typeface typeface) {
                this.f514a = weakReference;
                this.f515b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppCompatTextHelper appCompatTextHelper = this.f514a.get();
                if (appCompatTextHelper == null) {
                    return;
                }
                appCompatTextHelper.setTypefaceByCallback(this.f515b);
            }
        }

        a(AppCompatTextHelper appCompatTextHelper, int i, int i2) {
            this.f511a = new WeakReference<>(appCompatTextHelper);
            this.f512b = i;
            this.f513c = i2;
        }

        @Override // androidx.core.content.a.h.a
        public void a(int i) {
        }

        @Override // androidx.core.content.a.h.a
        public void a(Typeface typeface) {
            int i;
            AppCompatTextHelper appCompatTextHelper = this.f511a.get();
            if (appCompatTextHelper == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f512b) != -1) {
                typeface = Typeface.create(typeface, i, (this.f513c & 2) != 0);
            }
            appCompatTextHelper.a(new RunnableC0004a(this.f511a, typeface));
        }
    }

    AppCompatTextHelper(TextView textView) {
        this.f505a = textView;
        this.i = new E(this.f505a);
    }

    private void l() {
        ga gaVar = this.h;
        this.f506b = gaVar;
        this.f507c = gaVar;
        this.f508d = gaVar;
        this.f509e = gaVar;
        this.f510f = gaVar;
        this.g = gaVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instruction units count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.a(android.util.AttributeSet, int):void");
    }

    void b() {
        this.i.a();
    }

    int c() {
        return this.i.b();
    }

    int d() {
        return this.i.c();
    }

    int e() {
        return this.i.d();
    }

    int[] f() {
        return this.i.e();
    }

    int g() {
        return this.i.f();
    }

    ColorStateList h() {
        ga gaVar = this.h;
        if (gaVar != null) {
            return gaVar.f654a;
        }
        return null;
    }

    PorterDuff.Mode i() {
        ga gaVar = this.h;
        if (gaVar != null) {
            return gaVar.f655b;
        }
        return null;
    }

    boolean j() {
        return this.i.g();
    }

    void k() {
        a();
    }

    public void setTypefaceByCallback(Typeface typeface) {
        if (this.m) {
            this.f505a.setTypeface(typeface);
            this.l = typeface;
        }
    }

    private void b(int i, float f2) {
        this.i.a(i, f2);
    }

    public void a(Runnable runnable) {
        this.f505a.post(runnable);
    }

    private void a(Context context, ia iaVar) {
        String strD;
        this.j = iaVar.d(R.styleable.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            this.k = iaVar.d(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (!iaVar.g(R.styleable.TextAppearance_android_fontFamily) && !iaVar.g(R.styleable.TextAppearance_fontFamily)) {
            if (iaVar.g(R.styleable.TextAppearance_android_typeface)) {
                this.m = false;
                int iD = iaVar.d(R.styleable.TextAppearance_android_typeface, 1);
                if (iD == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (iD == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (iD != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i = iaVar.g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        int i2 = this.k;
        int i3 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceA = iaVar.a(i, this.j, new a(this, i2, i3));
                if (typefaceA != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                        this.l = Typeface.create(Typeface.create(typefaceA, 0), this.k, (this.j & 2) != 0);
                    } else {
                        this.l = typefaceA;
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strD = iaVar.d(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
            this.l = Typeface.create(Typeface.create(strD, 0), this.k, (this.j & 2) != 0);
        } else {
            this.l = Typeface.create(strD, this.j);
        }
    }

    void a(Context context, int i) {
        String strD;
        ColorStateList colorStateListA;
        ia iaVarA = ia.a(context, i, R.styleable.TextAppearance);
        if (iaVarA.g(R.styleable.TextAppearance_textAllCaps)) {
            a(iaVarA.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && iaVarA.g(R.styleable.TextAppearance_android_textColor) && (colorStateListA = iaVarA.a(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f505a.setTextColor(colorStateListA);
        }
        if (iaVarA.g(R.styleable.TextAppearance_android_textSize) && iaVarA.c(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f505a.setTextSize(0, WheelView.DividerConfig.FILL);
        }
        a(context, iaVarA);
        if (Build.VERSION.SDK_INT >= 26 && iaVarA.g(R.styleable.TextAppearance_fontVariationSettings) && (strD = iaVarA.d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f505a.setFontVariationSettings(strD);
        }
        iaVarA.a();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f505a.setTypeface(typeface, this.j);
        }
    }

    void a(boolean z) {
        this.f505a.setAllCaps(z);
    }

    void a() {
        if (this.f506b != null || this.f507c != null || this.f508d != null || this.f509e != null) {
            Drawable[] compoundDrawables = this.f505a.getCompoundDrawables();
            a(compoundDrawables[0], this.f506b);
            a(compoundDrawables[1], this.f507c);
            a(compoundDrawables[2], this.f508d);
            a(compoundDrawables[3], this.f509e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f510f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f505a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f510f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, ga gaVar) {
        if (drawable == null || gaVar == null) {
            return;
        }
        C0305s.a(drawable, gaVar, this.f505a.getDrawableState());
    }

    private static ga a(Context context, C0305s c0305s, int i) {
        ColorStateList colorStateListB = c0305s.b(context, i);
        if (colorStateListB == null) {
            return null;
        }
        ga gaVar = new ga();
        gaVar.f657d = true;
        gaVar.f654a = colorStateListB;
        return gaVar;
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.f1298a) {
            return;
        }
        b();
    }

    void a(int i, float f2) {
        if (androidx.core.widget.b.f1298a || j()) {
            return;
        }
        b(i, f2);
    }

    void a(int i) {
        this.i.b(i);
    }

    void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.i.a(i, i2, i3, i4);
    }

    void a(int[] iArr, int i) throws IllegalArgumentException {
        this.i.a(iArr, i);
    }

    void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new ga();
        }
        ga gaVar = this.h;
        gaVar.f654a = colorStateList;
        gaVar.f657d = colorStateList != null;
        l();
    }

    void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new ga();
        }
        ga gaVar = this.h;
        gaVar.f655b = mode;
        gaVar.f656c = mode != null;
        l();
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f505a.getCompoundDrawablesRelative();
            TextView textView = this.f505a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f505a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f505a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f505a.getCompoundDrawables();
        TextView textView3 = this.f505a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
}
