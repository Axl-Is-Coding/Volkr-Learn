package androidx.recyclerview.widget;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f1839a;

    M(RecyclerView recyclerView) {
        this.f1839a = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.f1839a;
        if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
            return;
        }
        RecyclerView recyclerView2 = this.f1839a;
        if (!recyclerView2.mIsAttached) {
            recyclerView2.requestLayout();
        } else if (recyclerView2.mLayoutSuppressed) {
            recyclerView2.mLayoutWasDefered = true;
        } else {
            recyclerView2.consumePendingUpdateOperations();
        }
    }
}
