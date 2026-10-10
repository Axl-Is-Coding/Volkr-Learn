package com.disabngo.blockynexus.e.b.r;

import androidx.databinding.Observable;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10112a;

    m(v vVar) {
        this.f10112a = vVar;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (this.f10112a.o.get().booleanValue() || this.f10112a.p.get().booleanValue() || this.f10112a.q.get().booleanValue()) {
            return;
        }
        this.f10112a.D();
    }
}
