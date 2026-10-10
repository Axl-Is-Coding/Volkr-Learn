package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
class C0365o extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0366p f2012a;

    C0365o(C0366p c0366p) {
        this.f2012a = c0366p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.f2012a.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
