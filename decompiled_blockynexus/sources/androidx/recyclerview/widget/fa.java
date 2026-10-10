package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
class fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f1965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f1966b = new a();

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    fa(b bVar) {
        this.f1965a = bVar;
    }

    View a(int i, int i2, int i3, int i4) {
        int iA = this.f1965a.a();
        int iB = this.f1965a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA = this.f1965a.a(i);
            this.f1966b.a(iA, iB, this.f1965a.a(viewA), this.f1965a.b(viewA));
            if (i3 != 0) {
                this.f1966b.b();
                this.f1966b.a(i3);
                if (this.f1966b.a()) {
                    return viewA;
                }
            }
            if (i4 != 0) {
                this.f1966b.b();
                this.f1966b.a(i4);
                if (this.f1966b.a()) {
                    view = viewA;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1967a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1971e;

        a() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a(int i, int i2, int i3, int i4) {
            this.f1968b = i;
            this.f1969c = i2;
            this.f1970d = i3;
            this.f1971e = i4;
        }

        void b() {
            this.f1967a = 0;
        }

        void a(int i) {
            this.f1967a = i | this.f1967a;
        }

        boolean a() {
            int i = this.f1967a;
            if ((i & 7) != 0 && (i & (a(this.f1970d, this.f1968b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1967a;
            if ((i2 & 112) != 0 && (i2 & (a(this.f1970d, this.f1969c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1967a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.f1971e, this.f1968b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1967a;
            return (i4 & 28672) == 0 || (i4 & (a(this.f1971e, this.f1969c) << 12)) != 0;
        }
    }

    boolean a(View view, int i) {
        this.f1966b.a(this.f1965a.a(), this.f1965a.b(), this.f1965a.a(view), this.f1965a.b(view));
        if (i == 0) {
            return false;
        }
        this.f1966b.b();
        this.f1966b.a(i);
        return this.f1966b.a();
    }
}
