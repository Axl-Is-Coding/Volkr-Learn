package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f1840a;

    N(RecyclerView recyclerView) {
        this.f1840a = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView.f fVar = this.f1840a.mItemAnimator;
        if (fVar != null) {
            fVar.i();
        }
        this.f1840a.mPostedAnimatorRunner = false;
    }
}
