package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: GhostViewPort.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class F extends ViewGroup implements B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewGroup f2162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f2163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f2164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Matrix f2166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f2167f;

    F(View view) {
        super(view.getContext());
        this.f2167f = new E(this);
        this.f2164c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static void b(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        va.b(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        va.c(viewGroup, matrix);
    }

    void a(Matrix matrix) {
        this.f2166e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f2164c, this);
        this.f2164c.getViewTreeObserver().addOnPreDrawListener(this.f2167f);
        va.a(this.f2164c, 4);
        if (this.f2164c.getParent() != null) {
            ((View) this.f2164c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f2164c.getViewTreeObserver().removeOnPreDrawListener(this.f2167f);
        va.a(this.f2164c, 0);
        a(this.f2164c, (F) null);
        if (this.f2164c.getParent() != null) {
            ((View) this.f2164c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        C0378b.a(canvas, true);
        canvas.setMatrix(this.f2166e);
        va.a(this.f2164c, 0);
        this.f2164c.invalidate();
        va.a(this.f2164c, 4);
        drawChild(canvas, this.f2164c, getDrawingTime());
        C0378b.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, androidx.transition.B
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (a(this.f2164c) == this) {
            va.a(this.f2164c, i == 0 ? 4 : 0);
        }
    }

    @Override // androidx.transition.B
    public void a(ViewGroup viewGroup, View view) {
        this.f2162a = viewGroup;
        this.f2163b = view;
    }

    static void a(View view, View view2) {
        va.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static void b(View view) {
        F fA = a(view);
        if (fA != null) {
            fA.f2165d--;
            if (fA.f2165d <= 0) {
                ((C) fA.getParent()).removeView(fA);
            }
        }
    }

    static F a(View view) {
        return (F) view.getTag(R.id.ghost_view);
    }

    static void a(View view, F f2) {
        view.setTag(R.id.ghost_view, f2);
    }

    static F a(View view, ViewGroup viewGroup, Matrix matrix) {
        C c2;
        if (view.getParent() instanceof ViewGroup) {
            C cA = C.a(viewGroup);
            F fA = a(view);
            int i = 0;
            if (fA != null && (c2 = (C) fA.getParent()) != cA) {
                i = fA.f2165d;
                c2.removeView(fA);
                fA = null;
            }
            if (fA == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    b(view, viewGroup, matrix);
                }
                fA = new F(view);
                fA.a(matrix);
                if (cA == null) {
                    cA = new C(viewGroup);
                } else {
                    cA.a();
                }
                a((View) viewGroup, (View) cA);
                a((View) viewGroup, (View) fA);
                cA.a(fA);
                fA.f2165d = i;
            } else if (matrix != null) {
                fA.a(matrix);
            }
            fA.f2165d++;
            return fA;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }
}
