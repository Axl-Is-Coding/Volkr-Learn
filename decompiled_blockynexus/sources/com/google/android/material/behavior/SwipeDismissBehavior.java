package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f13156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f13157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13158c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13160e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13159d = WheelView.DividerConfig.FILL;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f13161f = 2;
    float g = 0.5f;
    float h = WheelView.DividerConfig.FILL;
    float i = 0.5f;
    private final g.a j = new com.google.android.material.behavior.b(this);

    public interface a {
        void a(int i);

        void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f13162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13163b;

        b(View view, boolean z) {
            this.f13162a = view;
            this.f13163b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            g gVar = SwipeDismissBehavior.this.f13156a;
            if (gVar != null && gVar.a(true)) {
                ViewCompat.a(this.f13162a, this);
            } else {
                if (!this.f13163b || (aVar = SwipeDismissBehavior.this.f13157b) == null) {
                    return;
                }
                aVar.a(this.f13162a);
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(a aVar) {
        this.f13157b = aVar;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.h = a(WheelView.DividerConfig.FILL, f2, 1.0f);
    }

    public void a(int i) {
        this.f13161f = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar = this.f13156a;
        if (gVar == null) {
            return false;
        }
        gVar.a(motionEvent);
        return true;
    }

    public void a(float f2) {
        this.i = a(WheelView.DividerConfig.FILL, f2, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f13158c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f13158c = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f13158c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f13158c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f13156a.b(motionEvent);
    }

    private void a(ViewGroup viewGroup) {
        g gVarA;
        if (this.f13156a == null) {
            if (this.f13160e) {
                gVarA = g.a(viewGroup, this.f13159d, this.j);
            } else {
                gVarA = g.a(viewGroup, this.j);
            }
            this.f13156a = gVarA;
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
