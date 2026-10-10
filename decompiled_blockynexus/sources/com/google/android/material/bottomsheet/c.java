package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f13227a;

    c(BottomSheetBehavior bottomSheetBehavior) {
        this.f13227a = bottomSheetBehavior;
    }

    @Override // androidx.customview.b.g.a
    public void a(View view, int i, int i2, int i3, int i4) {
        this.f13227a.a(i2);
    }

    @Override // androidx.customview.b.g.a
    public boolean b(View view, int i) {
        BottomSheetBehavior bottomSheetBehavior = this.f13227a;
        int i2 = bottomSheetBehavior.v;
        if (i2 == 1 || bottomSheetBehavior.I) {
            return false;
        }
        if (i2 == 3 && bottomSheetBehavior.G == i) {
            WeakReference<View> weakReference = bottomSheetBehavior.D;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference<V> weakReference2 = this.f13227a.C;
        return weakReference2 != 0 && weakReference2.get() == view;
    }

    @Override // androidx.customview.b.g.a
    public void c(int i) {
        if (i == 1) {
            this.f13227a.f(1);
        }
    }

    @Override // androidx.customview.b.g.a
    public void a(View view, float f2, float f3) {
        int i;
        int i2 = 4;
        if (f3 < WheelView.DividerConfig.FILL) {
            if (this.f13227a.f13206c) {
                i = this.f13227a.o;
            } else {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = this.f13227a;
                int i3 = bottomSheetBehavior.p;
                if (top > i3) {
                    i = i3;
                    i2 = 6;
                } else {
                    i = bottomSheetBehavior.n;
                }
            }
            i2 = 3;
        } else {
            BottomSheetBehavior bottomSheetBehavior2 = this.f13227a;
            if (bottomSheetBehavior2.t && bottomSheetBehavior2.a(view, f3) && (view.getTop() > this.f13227a.r || Math.abs(f2) < Math.abs(f3))) {
                i = this.f13227a.B;
                i2 = 5;
            } else if (f3 == WheelView.DividerConfig.FILL || Math.abs(f2) > Math.abs(f3)) {
                int top2 = view.getTop();
                if (!this.f13227a.f13206c) {
                    BottomSheetBehavior bottomSheetBehavior3 = this.f13227a;
                    int i4 = bottomSheetBehavior3.p;
                    if (top2 < i4) {
                        if (top2 < Math.abs(top2 - bottomSheetBehavior3.r)) {
                            i = this.f13227a.n;
                            i2 = 3;
                        } else {
                            i = this.f13227a.p;
                        }
                    } else if (Math.abs(top2 - i4) < Math.abs(top2 - this.f13227a.r)) {
                        i = this.f13227a.p;
                    } else {
                        i = this.f13227a.r;
                    }
                    i2 = 6;
                } else if (Math.abs(top2 - this.f13227a.o) < Math.abs(top2 - this.f13227a.r)) {
                    i = this.f13227a.o;
                    i2 = 3;
                } else {
                    i = this.f13227a.r;
                }
            } else if (this.f13227a.f13206c) {
                i = this.f13227a.r;
            } else {
                int top3 = view.getTop();
                if (Math.abs(top3 - this.f13227a.p) < Math.abs(top3 - this.f13227a.r)) {
                    i = this.f13227a.p;
                    i2 = 6;
                } else {
                    i = this.f13227a.r;
                }
            }
        }
        this.f13227a.a(view, i2, i, true);
    }

    @Override // androidx.customview.b.g.a
    public int b(View view, int i, int i2) {
        int iF = this.f13227a.f();
        BottomSheetBehavior bottomSheetBehavior = this.f13227a;
        return androidx.core.c.a.a(i, iF, bottomSheetBehavior.t ? bottomSheetBehavior.B : bottomSheetBehavior.r);
    }

    @Override // androidx.customview.b.g.a
    public int b(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f13227a;
        if (bottomSheetBehavior.t) {
            return bottomSheetBehavior.B;
        }
        return bottomSheetBehavior.r;
    }

    @Override // androidx.customview.b.g.a
    public int a(View view, int i, int i2) {
        return view.getLeft();
    }
}
