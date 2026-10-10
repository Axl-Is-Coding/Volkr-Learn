package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0371v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper.c f2039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f2040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper f2041c;

    RunnableC0371v(ItemTouchHelper itemTouchHelper, ItemTouchHelper.c cVar, int i) {
        this.f2041c = itemTouchHelper;
        this.f2039a = cVar;
        this.f2040b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.f2041c.r;
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        ItemTouchHelper.c cVar = this.f2039a;
        if (cVar.l || cVar.f1813e.getAdapterPosition() == -1) {
            return;
        }
        RecyclerView.f itemAnimator = this.f2041c.r.getItemAnimator();
        if ((itemAnimator == null || !itemAnimator.a((RecyclerView.f.a) null)) && !this.f2041c.a()) {
            this.f2041c.m.onSwiped(this.f2039a.f1813e, this.f2040b);
        } else {
            this.f2041c.r.post(this);
        }
    }
}
