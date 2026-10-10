package com.disabngo.blockynexus.e.b.r;

import androidx.databinding.Observable;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10113a;

    n(v vVar) {
        this.f10113a = vVar;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (this.f10113a.o.get().booleanValue() || this.f10113a.p.get().booleanValue() || this.f10113a.q.get().booleanValue()) {
            return;
        }
        this.f10113a.D();
    }
}
