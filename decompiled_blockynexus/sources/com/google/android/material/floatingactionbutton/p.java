package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends FloatingActionButtonImpl {

    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    static class a extends com.google.android.material.l.i {
        a(com.google.android.material.l.n nVar) {
            super(nVar);
        }

        @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    p(FloatingActionButton floatingActionButton, com.google.android.material.k.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        this.i = a();
        this.i.setTintList(colorStateList);
        if (mode != null) {
            this.i.setTintMode(mode);
        }
        this.i.a(this.F.getContext());
        if (i > 0) {
            this.k = a(i, colorStateList);
            d dVar = this.k;
            androidx.core.f.h.a(dVar);
            com.google.android.material.l.i iVar = this.i;
            androidx.core.f.h.a(iVar);
            layerDrawable = new LayerDrawable(new Drawable[]{dVar, iVar});
        } else {
            this.k = null;
            layerDrawable = this.i;
        }
        this.j = new RippleDrawable(com.google.android.material.j.c.b(colorStateList2), layerDrawable, null);
        this.l = this.j;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void b(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.j.c.b(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float c() {
        return this.F.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void l() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void n() {
        x();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean s() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean t() {
        return this.G.a() || !u();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void v() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl.f13373b, a(f2, f4));
            stateListAnimator.addState(FloatingActionButtonImpl.f13374c, a(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.f13375d, a(f2, f3));
            stateListAnimator.addState(FloatingActionButtonImpl.f13376e, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, "elevation", f2).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, WheelView.DividerConfig.FILL).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl.f13372a);
            stateListAnimator.addState(FloatingActionButtonImpl.f13377f, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl.g, a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (t()) {
            x();
        }
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.f13372a);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.F.isEnabled()) {
                this.F.setElevation(this.o);
                if (this.F.isPressed()) {
                    this.F.setTranslationZ(this.q);
                    return;
                } else if (!this.F.isFocused() && !this.F.isHovered()) {
                    this.F.setTranslationZ(WheelView.DividerConfig.FILL);
                    return;
                } else {
                    this.F.setTranslationZ(this.p);
                    return;
                }
            }
            this.F.setElevation(WheelView.DividerConfig.FILL);
            this.F.setTranslationZ(WheelView.DividerConfig.FILL);
        }
    }

    d a(int i, ColorStateList colorStateList) {
        Context context = this.F.getContext();
        com.google.android.material.l.n nVar = this.h;
        androidx.core.f.h.a(nVar);
        d dVar = new d(nVar);
        dVar.a(androidx.core.content.b.a(context, R.color.design_fab_stroke_top_outer_color), androidx.core.content.b.a(context, R.color.design_fab_stroke_top_inner_color), androidx.core.content.b.a(context, R.color.design_fab_stroke_end_inner_color), androidx.core.content.b.a(context, R.color.design_fab_stroke_end_outer_color));
        dVar.a(i);
        dVar.a(colorStateList);
        return dVar;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    com.google.android.material.l.i a() {
        com.google.android.material.l.n nVar = this.h;
        androidx.core.f.h.a(nVar);
        return new a(nVar);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a(Rect rect) {
        if (this.G.a()) {
            super.a(rect);
        } else if (!u()) {
            int sizeDimension = (this.r - this.F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
