package androidx.customview.b;

import a.a.j;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C;
import androidx.core.view.C0313a;
import androidx.core.view.ViewCompat;
import androidx.customview.b.d;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Rect f1312d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.a<androidx.core.view.accessibility.b> f1313e = new androidx.customview.b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d.b<j<androidx.core.view.accessibility.b>, androidx.core.view.accessibility.b> f1314f = new b();
    private final AccessibilityManager k;
    private final View l;
    private a m;
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final int[] j = new int[2];
    int n = Integer.MIN_VALUE;
    int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    public c(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.l = view;
        this.k = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.k(view) == 0) {
            ViewCompat.f(view, 1);
        }
    }

    private boolean d() {
        int i = this.o;
        return i != Integer.MIN_VALUE && a(i, 16, (Bundle) null);
    }

    private AccessibilityEvent e(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.l.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private j<androidx.core.view.accessibility.b> f() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        j<androidx.core.view.accessibility.b> jVar = new j<>();
        for (int i = 0; i < arrayList.size(); i++) {
            jVar.c(i, f(i));
        }
        return jVar;
    }

    private static int g(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean h(int i) {
        int i2;
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled() || (i2 = this.n) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            d(i2);
        }
        this.n = i;
        this.l.invalidate();
        a(i, 32768);
        return true;
    }

    private void i(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        a(i, 128);
        a(i2, 256);
    }

    protected abstract int a(float f2, float f3);

    @Override // androidx.core.view.C0313a
    public androidx.core.view.accessibility.c a(View view) {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    protected void a(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void a(int i, androidx.core.view.accessibility.b bVar);

    protected void a(int i, boolean z) {
    }

    protected void a(AccessibilityEvent accessibilityEvent) {
    }

    protected void a(androidx.core.view.accessibility.b bVar) {
    }

    protected abstract void a(List<Integer> list);

    protected abstract boolean a(int i, int i2, Bundle bundle);

    public final int b() {
        return this.n;
    }

    public final int c() {
        return this.o;
    }

    @Override // androidx.core.view.C0313a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    private boolean b(int i, Rect rect) {
        androidx.core.view.accessibility.b bVar;
        j<androidx.core.view.accessibility.b> jVarF = f();
        int i2 = this.o;
        androidx.core.view.accessibility.b bVarA = i2 == Integer.MIN_VALUE ? null : jVarF.a(i2);
        if (i == 1 || i == 2) {
            bVar = (androidx.core.view.accessibility.b) d.a(jVarF, f1314f, f1313e, bVarA, i, ViewCompat.m(this.l) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.o;
            if (i3 != Integer.MIN_VALUE) {
                a(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.l, i, rect2);
            }
            bVar = (androidx.core.view.accessibility.b) d.a(jVarF, f1314f, f1313e, bVarA, rect2, i);
        }
        return c(bVar != null ? jVarF.c(jVarF.a(bVar)) : Integer.MIN_VALUE);
    }

    private AccessibilityEvent c(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        androidx.core.view.accessibility.b bVarB = b(i);
        accessibilityEventObtain.getText().add(bVarB.i());
        accessibilityEventObtain.setContentDescription(bVarB.e());
        accessibilityEventObtain.setScrollable(bVarB.t());
        accessibilityEventObtain.setPassword(bVarB.s());
        accessibilityEventObtain.setEnabled(bVarB.o());
        accessibilityEventObtain.setChecked(bVarB.m());
        a(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(bVarB.d());
        androidx.core.view.accessibility.d.a(accessibilityEventObtain, this.l, i);
        accessibilityEventObtain.setPackageName(this.l.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private boolean d(int i) {
        if (this.n != i) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        this.l.invalidate();
        a(i, 65536);
        return true;
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    private class a extends androidx.core.view.accessibility.c {
        a() {
        }

        @Override // androidx.core.view.accessibility.c
        public androidx.core.view.accessibility.b a(int i) {
            return androidx.core.view.accessibility.b.a(c.this.b(i));
        }

        @Override // androidx.core.view.accessibility.c
        public androidx.core.view.accessibility.b b(int i) {
            int i2 = i == 2 ? c.this.n : c.this.o;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        @Override // androidx.core.view.accessibility.c
        public boolean a(int i, int i2, Bundle bundle) {
            return c.this.b(i, i2, bundle);
        }
    }

    private androidx.core.view.accessibility.b e() {
        androidx.core.view.accessibility.b bVarB = androidx.core.view.accessibility.b.b(this.l);
        ViewCompat.a(this.l, bVarB);
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        if (bVarB.c() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bVarB.a(this.l, ((Integer) arrayList.get(i)).intValue());
        }
        return bVarB;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.p == Integer.MIN_VALUE) {
                return false;
            }
            i(Integer.MIN_VALUE);
            return true;
        }
        int iA = a(motionEvent.getX(), motionEvent.getY());
        i(iA);
        return iA != Integer.MIN_VALUE;
    }

    private androidx.core.view.accessibility.b f(int i) {
        androidx.core.view.accessibility.b bVarX = androidx.core.view.accessibility.b.x();
        bVarX.h(true);
        bVarX.i(true);
        bVarX.b("android.view.View");
        bVarX.c(f1312d);
        bVarX.d(f1312d);
        bVarX.c(this.l);
        a(i, bVarX);
        if (bVarX.i() == null && bVarX.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVarX.a(this.h);
        if (!this.h.equals(f1312d)) {
            int iB = bVarX.b();
            if ((iB & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            if ((iB & 128) == 0) {
                bVarX.f(this.l.getContext().getPackageName());
                bVarX.c(this.l, i);
                if (this.n == i) {
                    bVarX.a(true);
                    bVarX.a(128);
                } else {
                    bVarX.a(false);
                    bVarX.a(64);
                }
                boolean z = this.o == i;
                if (z) {
                    bVarX.a(2);
                } else if (bVarX.p()) {
                    bVarX.a(1);
                }
                bVarX.j(z);
                this.l.getLocationOnScreen(this.j);
                bVarX.b(this.g);
                if (this.g.equals(f1312d)) {
                    bVarX.a(this.g);
                    if (bVarX.f1231c != -1) {
                        androidx.core.view.accessibility.b bVarX2 = androidx.core.view.accessibility.b.x();
                        for (int i2 = bVarX.f1231c; i2 != -1; i2 = bVarX2.f1231c) {
                            bVarX2.b(this.l, -1);
                            bVarX2.c(f1312d);
                            a(i2, bVarX2);
                            bVarX2.a(this.h);
                            Rect rect = this.g;
                            Rect rect2 = this.h;
                            rect.offset(rect2.left, rect2.top);
                        }
                        bVarX2.y();
                    }
                    this.g.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                }
                if (this.l.getLocalVisibleRect(this.i)) {
                    this.i.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                    if (this.g.intersect(this.i)) {
                        bVarX.d(this.g);
                        if (a(this.g)) {
                            bVarX.q(true);
                        }
                    }
                }
                return bVarX;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public final boolean a(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int iG = g(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && b(iG, (Rect) null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            d();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        }
        if (keyEvent.hasModifiers(1)) {
            return b(1, (Rect) null);
        }
        return false;
    }

    private boolean c(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return c(i);
        }
        if (i2 == 2) {
            return a(i);
        }
        if (i2 == 64) {
            return h(i);
        }
        if (i2 != 128) {
            return a(i, i2, bundle);
        }
        return d(i);
    }

    private AccessibilityEvent b(int i, int i2) {
        if (i != -1) {
            return c(i, i2);
        }
        return e(i2);
    }

    androidx.core.view.accessibility.b b(int i) {
        if (i == -1) {
            return e();
        }
        return f(i);
    }

    public final boolean c(int i) {
        int i2;
        if ((!this.l.isFocused() && !this.l.requestFocus()) || (i2 = this.o) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            a(i2);
        }
        this.o = i;
        a(i, true);
        a(i, 8);
        return true;
    }

    boolean b(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return c(i, i2, bundle);
        }
        return a(i2, bundle);
    }

    public final void a(boolean z, int i, Rect rect) {
        int i2 = this.o;
        if (i2 != Integer.MIN_VALUE) {
            a(i2);
        }
        if (z) {
            b(i, rect);
        }
    }

    private void a(int i, Rect rect) {
        b(i).a(rect);
    }

    private static Rect a(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean a(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.k.isEnabled() || (parent = this.l.getParent()) == null) {
            return false;
        }
        return C.a(parent, this.l, b(i, i2));
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        a(bVar);
    }

    private boolean a(int i, Bundle bundle) {
        return ViewCompat.a(this.l, i, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.l.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.l.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= WheelView.DividerConfig.FILL || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean a(int i) {
        if (this.o != i) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        a(i, false);
        a(i, 8);
        return true;
    }
}
