package me.iwf.photopicker.fragment;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PhotoPickerFragment.java */
/* JADX INFO: loaded from: classes5.dex */
class b extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f22937a;

    b(c cVar) {
        this.f22937a = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            this.f22937a.j();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (Math.abs(i2) > this.f22937a.g) {
            this.f22937a.j.pauseRequests();
        } else {
            this.f22937a.j();
        }
    }
}
