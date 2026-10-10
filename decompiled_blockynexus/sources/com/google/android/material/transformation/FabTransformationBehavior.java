package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f13702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f13703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f13704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f13705f;
    private float g;
    private float h;

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f13706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f13707b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
        this.f13702c = new Rect();
        this.f13703d = new RectF();
        this.f13704e = new RectF();
        this.f13705f = new int[2];
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fI = ViewCompat.i(view2) - ViewCompat.i(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fI);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, WheelView.DividerConfig.FILL);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fI);
        }
        aVar.f13706a.b("elevation").a((Animator) objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.e) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f13088a, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f13088a, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new d(this, view2));
            aVar.f13706a.b("iconFade").a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new e(this, eVar, drawable));
        }
    }

    protected abstract a a(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        a aVarA = a(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, aVarA, arrayList, arrayList2);
        }
        RectF rectF = this.f13703d;
        a(view, view2, z, z2, aVarA, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        a(view, view2, z, aVarA, arrayList);
        d(view, view2, z, z2, aVarA, arrayList, arrayList2);
        a(view, view2, z, z2, aVarA, fWidth, fHeight, arrayList, arrayList2);
        b(view, view2, z, z2, aVarA, arrayList, arrayList2);
        a(view, view2, z, z2, aVarA, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new c(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13702c = new Rect();
        this.f13703d = new RectF();
        this.f13704e = new RectF();
        this.f13705f = new int[2];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout.d dVar) {
        if (dVar.h == 0) {
            dVar.h = 80;
        }
    }

    private float c(View view, View view2, j jVar) {
        float fCenterX;
        float fCenterX2;
        float f2;
        RectF rectF = this.f13703d;
        RectF rectF2 = this.f13704e;
        a(view, rectF);
        b(view2, rectF2);
        int i = jVar.f13101a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else if (i == 5) {
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        } else {
            f2 = WheelView.DividerConfig.FILL;
            return f2 + jVar.f13102b;
        }
        f2 = fCenterX - fCenterX2;
        return f2 + jVar.f13102b;
    }

    private void a(View view, View view2, boolean z, a aVar, List<Animator> list) {
        float fC = c(view, view2, aVar.f13707b);
        float fD = d(view, view2, aVar.f13707b);
        Pair<i, i> pairA = a(fC, fD, z, aVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            fC = this.g;
        }
        fArr[0] = fC;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            fD = this.h;
        }
        fArr2[0] = fD;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private float d(View view, View view2, j jVar) {
        float fCenterY;
        float fCenterY2;
        float f2;
        RectF rectF = this.f13703d;
        RectF rectF2 = this.f13704e;
        a(view, rectF);
        b(view2, rectF2);
        int i = jVar.f13101a & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else if (i == 80) {
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        } else {
            f2 = WheelView.DividerConfig.FILL;
            return f2 + jVar.f13103c;
        }
        f2 = fCenterY - fCenterY2;
        return f2 + jVar.f13103c;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fC = c(view, view2, aVar.f13707b);
        float fD = d(view, view2, aVar.f13707b);
        Pair<i, i> pairA = a(fC, fD, z, aVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fC);
                view2.setTranslationY(-fD);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, WheelView.DividerConfig.FILL);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, WheelView.DividerConfig.FILL);
            a(view2, aVar, iVar, iVar2, -fC, -fD, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fC);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fD);
        }
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.e) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            int iB = b(view);
            int i = 16777215 & iB;
            if (z) {
                if (!z2) {
                    eVar.setCircularRevealScrimColor(iB);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(eVar, e.c.f13269a, i);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(eVar, e.c.f13269a, iB);
            }
            objectAnimatorOfInt.setEvaluator(com.google.android.material.a.c.a());
            aVar.f13706a.b("color").a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void b(View view, RectF rectF) {
        rectF.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f13705f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.e) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            float fA = a(view, view2, aVar.f13707b);
            float fB = b(view, view2, aVar.f13707b);
            ((FloatingActionButton) view).getContentRect(this.f13702c);
            float fWidth = this.f13702c.width() / 2.0f;
            i iVarB = aVar.f13706a.b("expansion");
            if (z) {
                if (!z2) {
                    eVar.setRevealInfo(new e.d(fA, fB, fWidth));
                }
                if (z2) {
                    fWidth = eVar.getRevealInfo().f13272c;
                }
                animatorA = com.google.android.material.circularreveal.b.a(eVar, fA, fB, com.google.android.material.h.a.a(fA, fB, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f2, f3));
                animatorA.addListener(new f(this, eVar));
                a(view2, iVarB.a(), (int) fA, (int) fB, fWidth, list);
            } else {
                float f4 = eVar.getRevealInfo().f13272c;
                Animator animatorA2 = com.google.android.material.circularreveal.b.a(eVar, fA, fB, fWidth);
                int i = (int) fA;
                int i2 = (int) fB;
                a(view2, iVarB.a(), i, i2, f4, list);
                a(view2, iVarB.a(), iVarB.b(), aVar.f13706a.a(), i, i2, fWidth, list);
                animatorA = animatorA2;
            }
            iVarB.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.b.a(eVar));
        }
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.f13703d;
        RectF rectF2 = this.f13704e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(WheelView.DividerConfig.FILL, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList colorStateListE = ViewCompat.e(view);
        if (colorStateListE != null) {
            return colorStateListE.getColorForState(view.getDrawableState(), colorStateListE.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupA;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.e) && com.google.android.material.circularreveal.c.f13260a == 0) || (viewGroupA = a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.a.d.f13087a.set(viewGroupA, Float.valueOf(WheelView.DividerConfig.FILL));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupA, com.google.android.material.a.d.f13087a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupA, com.google.android.material.a.d.f13087a, WheelView.DividerConfig.FILL);
            }
            aVar.f13706a.b("contentFade").a((Animator) objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    private Pair<i, i> a(float f2, float f3, boolean z, a aVar) {
        i iVarB;
        i iVarB2;
        if (f2 == WheelView.DividerConfig.FILL || f3 == WheelView.DividerConfig.FILL) {
            iVarB = aVar.f13706a.b("translationXLinear");
            iVarB2 = aVar.f13706a.b("translationYLinear");
        } else if ((z && f3 < WheelView.DividerConfig.FILL) || (!z && f3 > WheelView.DividerConfig.FILL)) {
            iVarB = aVar.f13706a.b("translationXCurveUpwards");
            iVarB2 = aVar.f13706a.b("translationYCurveUpwards");
        } else {
            iVarB = aVar.f13706a.b("translationXCurveDownwards");
            iVarB2 = aVar.f13706a.b("translationYCurveDownwards");
        }
        return new Pair<>(iVarB, iVarB2);
    }

    private void a(View view, RectF rectF) {
        b(view, rectF);
        rectF.offset(this.g, this.h);
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.f13703d;
        RectF rectF2 = this.f13704e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), WheelView.DividerConfig.FILL);
        return rectF.centerX() - rectF2.left;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float fA = a(aVar, iVar, f2, f4);
        float fA2 = a(aVar, iVar2, f3, f5);
        Rect rect = this.f13702c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f13703d;
        rectF2.set(rect);
        RectF rectF3 = this.f13704e;
        b(view, rectF3);
        rectF3.offset(fA, fA2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long jA = iVar.a();
        long jB = iVar.b();
        i iVarB = aVar.f13706a.b("expansion");
        return com.google.android.material.a.a.a(f2, f3, iVar.c().getInterpolation((((iVarB.a() + iVarB.b()) + 17) - jA) / jB));
    }

    private ViewGroup a(View view) {
        View viewFindViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return c(viewFindViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return c(view);
        }
        return c(((ViewGroup) view).getChildAt(0));
    }

    private void a(View view, long j, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
        animatorCreateCircularReveal.setStartDelay(0L);
        animatorCreateCircularReveal.setDuration(j);
        list.add(animatorCreateCircularReveal);
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
                animatorCreateCircularReveal.setStartDelay(j4);
                animatorCreateCircularReveal.setDuration(j3 - j4);
                list.add(animatorCreateCircularReveal);
            }
        }
    }
}
