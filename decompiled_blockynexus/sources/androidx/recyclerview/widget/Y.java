package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Y extends RecyclerView.f {
    boolean g = true;

    public abstract boolean a(RecyclerView.w wVar, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        return (cVar == null || (cVar.f1853a == cVar2.f1853a && cVar.f1854b == cVar2.f1854b)) ? f(wVar) : a(wVar, cVar.f1853a, cVar.f1854b, cVar2.f1853a, cVar2.f1854b);
    }

    public abstract boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.w wVar) {
        return !this.g || wVar.isInvalid();
    }

    public void c(RecyclerView.w wVar, boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f1853a != cVar2.f1853a || cVar.f1854b != cVar2.f1854b) {
            return a(wVar, cVar.f1853a, cVar.f1854b, cVar2.f1853a, cVar2.f1854b);
        }
        j(wVar);
        return false;
    }

    public void d(RecyclerView.w wVar, boolean z) {
    }

    public abstract boolean f(RecyclerView.w wVar);

    public abstract boolean g(RecyclerView.w wVar);

    public final void h(RecyclerView.w wVar) {
        n(wVar);
        c(wVar);
    }

    public final void i(RecyclerView.w wVar) {
        o(wVar);
    }

    public final void j(RecyclerView.w wVar) {
        p(wVar);
        c(wVar);
    }

    public final void k(RecyclerView.w wVar) {
        q(wVar);
    }

    public final void l(RecyclerView.w wVar) {
        r(wVar);
        c(wVar);
    }

    public final void m(RecyclerView.w wVar) {
        s(wVar);
    }

    public void n(RecyclerView.w wVar) {
    }

    public void o(RecyclerView.w wVar) {
    }

    public void p(RecyclerView.w wVar) {
    }

    public void q(RecyclerView.w wVar) {
    }

    public void r(RecyclerView.w wVar) {
    }

    public void s(RecyclerView.w wVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f1853a;
        int i2 = cVar.f1854b;
        View view = wVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1853a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1854b;
        if (wVar.isRemoved() || (i == left && i2 == top)) {
            return g(wVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(wVar, i, i2, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f1853a;
        int i4 = cVar.f1854b;
        if (wVar2.shouldIgnore()) {
            int i5 = cVar.f1853a;
            i2 = cVar.f1854b;
            i = i5;
        } else {
            i = cVar2.f1853a;
            i2 = cVar2.f1854b;
        }
        return a(wVar, wVar2, i3, i4, i, i2);
    }

    public final void a(RecyclerView.w wVar, boolean z) {
        c(wVar, z);
        c(wVar);
    }

    public final void b(RecyclerView.w wVar, boolean z) {
        d(wVar, z);
    }
}
