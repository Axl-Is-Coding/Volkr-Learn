package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes2.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f13692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f13693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f13695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13696f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    public v(TextInputLayout textInputLayout) {
        this.f13691a = textInputLayout.getContext();
        this.f13692b = textInputLayout;
        this.h = this.f13691a.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private TextView d(int i) {
        if (i == 1) {
            return this.m;
        }
        if (i != 2) {
            return null;
        }
        return this.r;
    }

    private boolean e(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    private boolean f(int i) {
        return (i != 2 || this.r == null || TextUtils.isEmpty(this.p)) ? false : true;
    }

    private boolean n() {
        return (this.f13693c == null || this.f13692b.getEditText() == null) ? false : true;
    }

    boolean a(int i) {
        return i == 0 || i == 1;
    }

    void b(CharSequence charSequence) {
        b();
        this.p = charSequence;
        this.r.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.r, charSequence));
    }

    boolean c() {
        return e(this.j);
    }

    CharSequence g() {
        return this.p;
    }

    int h() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    boolean i() {
        return f(this.i);
    }

    void j() {
        this.k = null;
        b();
        if (this.i == 1) {
            if (!this.q || TextUtils.isEmpty(this.p)) {
                this.j = 0;
            } else {
                this.j = 2;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    void k() {
        b();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.r, (CharSequence) null));
    }

    boolean l() {
        return this.l;
    }

    boolean m() {
        return this.q;
    }

    void c(int i) {
        this.s = i;
        TextView textView = this.r;
        if (textView != null) {
            TextViewCompat.d(textView, i);
        }
    }

    CharSequence d() {
        return this.k;
    }

    int e() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList f() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    void a(CharSequence charSequence) {
        b();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    void b() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    void b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f13693c == null) {
            return;
        }
        if (a(i) && (frameLayout = this.f13695e) != null) {
            this.f13696f--;
            a(frameLayout, this.f13696f);
            this.f13695e.removeView(textView);
        } else {
            this.f13693c.removeView(textView);
        }
        this.f13694d--;
        a(this.f13693c, this.f13694d);
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return ViewCompat.C(this.f13692b) && this.f13692b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.q, this.r, 2, i, i2);
            a(arrayList, this.l, this.m, 1, i, i2);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new u(this, i2, d(i), i, d(i2)));
            animatorSet.start();
        } else {
            a(i, i2);
        }
        this.f13692b.updateEditTextBackground();
        this.f13692b.updateLabelState(z);
        this.f13692b.updateTextInputBoxState();
    }

    void b(boolean z) {
        if (this.q == z) {
            return;
        }
        b();
        if (z) {
            this.r = new AppCompatTextView(this.f13691a);
            this.r.setId(R.id.textinput_helper_text);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            ViewCompat.e(this.r, 1);
            c(this.s);
            b(this.t);
            a(this.r, 1);
        } else {
            k();
            b(this.r, 1);
            this.r = null;
            this.f13692b.updateEditTextBackground();
            this.f13692b.updateTextInputBoxState();
        }
        this.q = z;
    }

    private void a(int i, int i2) {
        TextView textViewD;
        TextView textViewD2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewD2 = d(i2)) != null) {
            textViewD2.setVisibility(0);
            textViewD2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewD = d(i)) != null) {
            textViewD.setVisibility(4);
            if (i == 1) {
                textViewD.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(a(textView, i3 == i));
            if (i3 == i) {
                list.add(a(textView));
            }
        }
    }

    void b(int i) {
        this.n = i;
        TextView textView = this.m;
        if (textView != null) {
            this.f13692b.setTextAppearanceCompatWithErrorFallback(textView, i);
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13081a);
        return objectAnimatorOfFloat;
    }

    void b(ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13084d);
        return objectAnimatorOfFloat;
    }

    void a() {
        if (n()) {
            ViewCompat.b(this.f13693c, ViewCompat.r(this.f13692b.getEditText()), 0, ViewCompat.q(this.f13692b.getEditText()), 0);
        }
    }

    void a(TextView textView, int i) {
        if (this.f13693c == null && this.f13695e == null) {
            this.f13693c = new LinearLayout(this.f13691a);
            this.f13693c.setOrientation(0);
            this.f13692b.addView(this.f13693c, -1, -2);
            this.f13695e = new FrameLayout(this.f13691a);
            this.f13693c.addView(this.f13695e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f13693c.addView(new Space(this.f13691a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f13692b.getEditText() != null) {
                a();
            }
        }
        if (a(i)) {
            this.f13695e.setVisibility(0);
            this.f13695e.addView(textView);
            this.f13696f++;
        } else {
            this.f13693c.addView(textView, i);
        }
        this.f13693c.setVisibility(0);
        this.f13694d++;
    }

    private void a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    void a(boolean z) {
        if (this.l == z) {
            return;
        }
        b();
        if (z) {
            this.m = new AppCompatTextView(this.f13691a);
            this.m.setId(R.id.textinput_error);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            b(this.n);
            a(this.o);
            this.m.setVisibility(4);
            ViewCompat.e(this.m, 1);
            a(this.m, 0);
        } else {
            j();
            b(this.m, 0);
            this.m = null;
            this.f13692b.updateEditTextBackground();
            this.f13692b.updateTextInputBoxState();
        }
        this.l = z;
    }

    void a(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            a(this.m, typeface);
            a(this.r, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    void a(ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }
}
