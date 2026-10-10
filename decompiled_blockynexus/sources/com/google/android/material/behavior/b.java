package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: SwipeDismissBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13167b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeDismissBehavior f13168c;

    b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f13168c = swipeDismissBehavior;
    }

    @Override // androidx.customview.b.g.a
    public void a(View view, int i) {
        this.f13167b = i;
        this.f13166a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // androidx.customview.b.g.a
    public boolean b(View view, int i) {
        int i2 = this.f13167b;
        return (i2 == -1 || i2 == i) && this.f13168c.a(view);
    }

    @Override // androidx.customview.b.g.a
    public void c(int i) {
        SwipeDismissBehavior.a aVar = this.f13168c.f13157b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // androidx.customview.b.g.a
    public int b(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.b.g.a
    public void a(View view, float f2, float f3) {
        int i;
        boolean z;
        SwipeDismissBehavior.a aVar;
        this.f13167b = -1;
        int width = view.getWidth();
        if (a(view, f2)) {
            int left = view.getLeft();
            int i2 = this.f13166a;
            i = left < i2 ? i2 - width : i2 + width;
            z = true;
        } else {
            i = this.f13166a;
            z = false;
        }
        if (this.f13168c.f13156a.d(i, view.getTop())) {
            ViewCompat.a(view, new SwipeDismissBehavior.b(view, z));
        } else {
            if (!z || (aVar = this.f13168c.f13157b) == null) {
                return;
            }
            aVar.a(view);
        }
    }

    private boolean a(View view, float f2) {
        if (f2 == WheelView.DividerConfig.FILL) {
            return Math.abs(view.getLeft() - this.f13166a) >= Math.round(((float) view.getWidth()) * this.f13168c.g);
        }
        boolean z = ViewCompat.m(view) == 1;
        int i = this.f13168c.f13161f;
        if (i == 2) {
            return true;
        }
        if (i == 0) {
            if (z) {
                if (f2 >= WheelView.DividerConfig.FILL) {
                    return false;
                }
            } else if (f2 <= WheelView.DividerConfig.FILL) {
                return false;
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        if (z) {
            if (f2 <= WheelView.DividerConfig.FILL) {
                return false;
            }
        } else if (f2 >= WheelView.DividerConfig.FILL) {
            return false;
        }
        return true;
    }

    @Override // androidx.customview.b.g.a
    public int a(View view) {
        return view.getWidth();
    }

    @Override // androidx.customview.b.g.a
    public int a(View view, int i, int i2) {
        int width;
        int width2;
        int width3;
        boolean z = ViewCompat.m(view) == 1;
        int i3 = this.f13168c.f13161f;
        if (i3 == 0) {
            if (z) {
                width = this.f13166a - view.getWidth();
                width2 = this.f13166a;
            } else {
                width = this.f13166a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i3 != 1) {
            width = this.f13166a - view.getWidth();
            width2 = view.getWidth() + this.f13166a;
        } else if (z) {
            width = this.f13166a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f13166a - view.getWidth();
            width2 = this.f13166a;
        }
        return SwipeDismissBehavior.a(width, i, width2);
    }

    @Override // androidx.customview.b.g.a
    public void a(View view, int i, int i2, int i3, int i4) {
        float width = this.f13166a + (view.getWidth() * this.f13168c.h);
        float width2 = this.f13166a + (view.getWidth() * this.f13168c.i);
        float f2 = i;
        if (f2 <= width) {
            view.setAlpha(1.0f);
        } else if (f2 >= width2) {
            view.setAlpha(WheelView.DividerConfig.FILL);
        } else {
            view.setAlpha(SwipeDismissBehavior.a(WheelView.DividerConfig.FILL, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
        }
    }
}
