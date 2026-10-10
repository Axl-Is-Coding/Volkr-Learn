package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ga;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class P implements ga.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f1841a;

    P(RecyclerView recyclerView) {
        this.f1841a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.ga.b
    public void a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f1841a.animateAppearance(wVar, cVar, cVar2);
    }

    @Override // androidx.recyclerview.widget.ga.b
    public void b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f1841a.mRecycler.c(wVar);
        this.f1841a.animateDisappearance(wVar, cVar, cVar2);
    }

    @Override // androidx.recyclerview.widget.ga.b
    public void c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        wVar.setIsRecyclable(false);
        RecyclerView recyclerView = this.f1841a;
        if (recyclerView.mDataSetHasChangedAfterLayout) {
            if (recyclerView.mItemAnimator.a(wVar, wVar, cVar, cVar2)) {
                this.f1841a.postAnimationRunner();
            }
        } else if (recyclerView.mItemAnimator.c(wVar, cVar, cVar2)) {
            this.f1841a.postAnimationRunner();
        }
    }

    @Override // androidx.recyclerview.widget.ga.b
    public void a(RecyclerView.w wVar) {
        RecyclerView recyclerView = this.f1841a;
        recyclerView.mLayout.removeAndRecycleView(wVar.itemView, recyclerView.mRecycler);
    }
}
