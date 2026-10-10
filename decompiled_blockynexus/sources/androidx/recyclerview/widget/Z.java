package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
class Z extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1933a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ba f1934b;

    Z(ba baVar) {
        this.f1934b = baVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0 && this.f1933a) {
            this.f1933a = false;
            this.f1934b.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.f1933a = true;
    }
}
