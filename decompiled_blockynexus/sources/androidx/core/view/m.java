package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: NestedScrollingChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f1262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f1263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f1264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f1266e;

    public m(View view) {
        this.f1264c = view;
    }

    private ViewParent d(int i) {
        if (i == 0) {
            return this.f1262a;
        }
        if (i != 1) {
            return null;
        }
        return this.f1263b;
    }

    public void a(boolean z) {
        if (this.f1265d) {
            ViewCompat.I(this.f1264c);
        }
        this.f1265d = z;
    }

    public boolean b() {
        return this.f1265d;
    }

    public void c() {
        c(0);
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c(int i) {
        ViewParent viewParentD = d(i);
        if (viewParentD != null) {
            C.a(viewParentD, this.f1264c, i);
            a(i, (ViewParent) null);
        }
    }

    private boolean b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentD;
        int i6;
        int i7;
        int[] iArr3;
        if (!b() || (viewParentD = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f1264c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrD = d();
            iArrD[0] = 0;
            iArrD[1] = 0;
            iArr3 = iArrD;
        } else {
            iArr3 = iArr2;
        }
        C.a(viewParentD, this.f1264c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f1264c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    private int[] d() {
        if (this.f1266e == null) {
            this.f1266e = new int[2];
        }
        return this.f1266e;
    }

    public boolean a() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!b()) {
            return false;
        }
        View view = this.f1264c;
        for (ViewParent parent = this.f1264c.getParent(); parent != null; parent = parent.getParent()) {
            if (C.b(parent, view, this.f1264c, i, i2)) {
                a(i2, parent);
                C.a(parent, view, this.f1264c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return b(i, i2, i3, i4, iArr, 0, null);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return b(i, i2, i3, i4, iArr, i5, null);
    }

    public void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentD;
        int i4;
        int i5;
        if (!b() || (viewParentD = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f1264c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = d();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C.a(viewParentD, this.f1264c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f1264c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent viewParentD;
        if (!b() || (viewParentD = d(0)) == null) {
            return false;
        }
        return C.a(viewParentD, this.f1264c, f2, f3, z);
    }

    public boolean a(float f2, float f3) {
        ViewParent viewParentD;
        if (!b() || (viewParentD = d(0)) == null) {
            return false;
        }
        return C.a(viewParentD, this.f1264c, f2, f3);
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f1262a = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.f1263b = viewParent;
        }
    }
}
