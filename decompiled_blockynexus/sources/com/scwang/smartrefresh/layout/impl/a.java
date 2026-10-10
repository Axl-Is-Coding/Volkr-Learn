package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.l;
import androidx.core.view.p;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.k;
import com.scwang.smartrefresh.layout.c.c;
import java.util.LinkedList;

/* JADX INFO: compiled from: RefreshContentWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ValueAnimator.AnimatorUpdateListener, e, com.scwang.smartrefresh.layout.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f19172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected View f19173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected View f19174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected View f19175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected View f19176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f19177f = 0;
    protected boolean g = true;
    protected boolean h = true;
    protected b i = new b();

    public a(View view) {
        this.f19174c = view;
        this.f19173b = view;
        this.f19172a = view;
    }

    protected void a(View view, i iVar) {
        boolean zIsInEditMode = this.f19172a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof p) || (view2 instanceof l))) {
                break;
            }
            view = a(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                com.scwang.smartrefresh.layout.c.b.a(view, iVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f19174c = view2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public boolean b() {
        return this.g && this.i.a(this.f19172a);
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public boolean c() {
        return this.h && this.i.b(this.f19172a);
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public View getView() {
        return this.f19172a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f19177f) * this.f19174c.getScaleY();
            if (this.f19174c instanceof AbsListView) {
                c.a((AbsListView) this.f19174c, (int) scaleY);
            } else {
                this.f19174c.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f19177f = iIntValue;
    }

    @Override // com.scwang.smartrefresh.layout.b.a
    public void a(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    protected View a(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && c.a(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    protected View a(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (c.a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && c.a(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewA = a(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewA;
                }
            }
        }
        return view2;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public View a() {
        return this.f19174c;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void a(int i, int i2, int i3) {
        boolean z;
        View viewFindViewById;
        View viewFindViewById2;
        if (i2 == -1 || (viewFindViewById2 = this.f19173b.findViewById(i2)) == null) {
            z = false;
        } else if (i > 0) {
            viewFindViewById2.setTranslationY(i);
            z = true;
        } else {
            if (viewFindViewById2.getTranslationY() > WheelView.DividerConfig.FILL) {
                viewFindViewById2.setTranslationY(WheelView.DividerConfig.FILL);
            }
            z = false;
        }
        if (i3 != -1 && (viewFindViewById = this.f19173b.findViewById(i3)) != null) {
            if (i < 0) {
                viewFindViewById.setTranslationY(i);
                z = true;
            } else if (viewFindViewById.getTranslationY() < WheelView.DividerConfig.FILL) {
                viewFindViewById.setTranslationY(WheelView.DividerConfig.FILL);
            }
        }
        if (!z) {
            this.f19173b.setTranslationY(i);
        } else {
            this.f19173b.setTranslationY(WheelView.DividerConfig.FILL);
        }
        View view = this.f19175d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.f19176e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f19172a.getLeft(), -this.f19172a.getTop());
        View view = this.f19174c;
        View view2 = this.f19172a;
        if (view != view2) {
            this.f19174c = a(view2, pointF, view);
        }
        if (this.f19174c == this.f19172a) {
            this.i.f19178a = null;
        } else {
            this.i.f19178a = pointF;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void a(i iVar, View view, View view2) {
        a(this.f19172a, iVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f19175d = view;
        this.f19176e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f19172a.getContext());
        int iIndexOfChild = iVar.b().getLayout().indexOfChild(this.f19172a);
        iVar.b().getLayout().removeView(this.f19172a);
        frameLayout.addView(this.f19172a, 0, new ViewGroup.LayoutParams(-1, -1));
        iVar.b().getLayout().addView(frameLayout, iIndexOfChild, this.f19172a.getLayoutParams());
        this.f19172a = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = c.c(view);
            viewGroup.addView(new Space(this.f19172a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = c.c(view2);
            viewGroup2.addView(new Space(this.f19172a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void a(k kVar) {
        if (kVar instanceof b) {
            this.i = (b) kVar;
        } else {
            this.i.f19179b = kVar;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void a(boolean z) {
        this.i.f19180c = z;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public ValueAnimator.AnimatorUpdateListener a(int i) {
        View view = this.f19174c;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !c.a(view, 1)) && (i <= 0 || !c.a(this.f19174c, -1))) {
            return null;
        }
        this.f19177f = i;
        return this;
    }
}
