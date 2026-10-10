package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: androidx.recyclerview.widget.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0352b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InterfaceC0031b f1946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f1947b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f1948c = new ArrayList();

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChildHelper.java */
    interface InterfaceC0031b {
        int a();

        View a(int i);

        void a(View view);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        void addView(View view, int i);

        RecyclerView.w b(View view);

        void b();

        void b(int i);

        int c(View view);

        void c(int i);

        void d(View view);
    }

    C0352b(InterfaceC0031b interfaceC0031b) {
        this.f1946a = interfaceC0031b;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int iA = this.f1946a.a();
        int i2 = i;
        while (i2 < iA) {
            int iB = i - (i2 - this.f1947b.b(i2));
            if (iB == 0) {
                while (this.f1947b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    private void g(View view) {
        this.f1948c.add(view);
        this.f1946a.a(view);
    }

    private boolean h(View view) {
        if (!this.f1948c.remove(view)) {
            return false;
        }
        this.f1946a.d(view);
        return true;
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    View b(int i) {
        int size = this.f1948c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f1948c.get(i2);
            RecyclerView.w wVarB = this.f1946a.b(view);
            if (wVarB.getLayoutPosition() == i && !wVarB.isInvalid() && !wVarB.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View c(int i) {
        return this.f1946a.a(f(i));
    }

    void d(View view) {
        int iC = this.f1946a.c(view);
        if (iC < 0) {
            return;
        }
        if (this.f1947b.d(iC)) {
            h(view);
        }
        this.f1946a.c(iC);
    }

    void e(int i) {
        int iF = f(i);
        View viewA = this.f1946a.a(iF);
        if (viewA == null) {
            return;
        }
        if (this.f1947b.d(iF)) {
            h(viewA);
        }
        this.f1946a.c(iF);
    }

    public String toString() {
        return this.f1947b.toString() + ", hidden list:" + this.f1948c.size();
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$a */
    /* JADX INFO: compiled from: ChildHelper.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f1949a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f1950b;

        a() {
        }

        private void b() {
            if (this.f1950b == null) {
                this.f1950b = new a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.f1949a &= (1 << i) ^ (-1);
                return;
            }
            a aVar = this.f1950b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f1949a & (1 << i)) != 0;
            }
            b();
            return this.f1950b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f1950b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1949a & j) != 0;
            this.f1949a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.f1949a;
            this.f1949a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            a aVar = this.f1950b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1950b.d(0);
            }
            return z;
        }

        void e(int i) {
            if (i < 64) {
                this.f1949a |= 1 << i;
            } else {
                b();
                this.f1950b.e(i - 64);
            }
        }

        public String toString() {
            if (this.f1950b == null) {
                return Long.toBinaryString(this.f1949a);
            }
            return this.f1950b.toString() + "xx" + Long.toBinaryString(this.f1949a);
        }

        int b(int i) {
            a aVar = this.f1950b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f1949a);
                }
                return Long.bitCount(this.f1949a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f1949a & ((1 << i) - 1));
            }
            return aVar.b(i - 64) + Long.bitCount(this.f1949a);
        }

        void a() {
            this.f1949a = 0L;
            a aVar = this.f1950b;
            if (aVar != null) {
                aVar.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f1950b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1949a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1949a;
            this.f1949a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f1950b != null) {
                b();
                this.f1950b.a(0, z2);
            }
        }
    }

    void a(View view, int i, boolean z) {
        int iA = i < 0 ? this.f1946a.a() : f(i);
        this.f1947b.a(iA, z);
        if (z) {
            g(view);
        }
        this.f1946a.addView(view, iA);
    }

    void c() {
        this.f1947b.a();
        for (int size = this.f1948c.size() - 1; size >= 0; size--) {
            this.f1946a.d(this.f1948c.get(size));
            this.f1948c.remove(size);
        }
        this.f1946a.b();
    }

    void f(View view) {
        int iC = this.f1946a.c(view);
        if (iC >= 0) {
            if (this.f1947b.c(iC)) {
                this.f1947b.a(iC);
                h(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    View d(int i) {
        return this.f1946a.a(i);
    }

    boolean e(View view) {
        int iC = this.f1946a.c(view);
        if (iC == -1) {
            h(view);
            return true;
        }
        if (!this.f1947b.c(iC)) {
            return false;
        }
        this.f1947b.d(iC);
        h(view);
        this.f1946a.c(iC);
        return true;
    }

    void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iF;
        if (i < 0) {
            iF = this.f1946a.a();
        } else {
            iF = f(i);
        }
        this.f1947b.a(iF, z);
        if (z) {
            g(view);
        }
        this.f1946a.a(view, iF, layoutParams);
    }

    int b() {
        return this.f1946a.a();
    }

    int b(View view) {
        int iC = this.f1946a.c(view);
        if (iC == -1 || this.f1947b.c(iC)) {
            return -1;
        }
        return iC - this.f1947b.b(iC);
    }

    boolean c(View view) {
        return this.f1948c.contains(view);
    }

    int a() {
        return this.f1946a.a() - this.f1948c.size();
    }

    void a(int i) {
        int iF = f(i);
        this.f1947b.d(iF);
        this.f1946a.b(iF);
    }

    void a(View view) {
        int iC = this.f1946a.c(view);
        if (iC >= 0) {
            this.f1947b.e(iC);
            g(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }
}
