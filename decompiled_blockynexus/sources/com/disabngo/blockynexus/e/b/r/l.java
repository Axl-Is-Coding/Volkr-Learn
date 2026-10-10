package com.disabngo.blockynexus.e.b.r;

import androidx.databinding.Observable;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10111a;

    l(v vVar) {
        this.f10111a = vVar;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (this.f10111a.o.get().booleanValue() || this.f10111a.p.get().booleanValue() || this.f10111a.q.get().booleanValue()) {
            return;
        }
        this.f10111a.D();
    }
}
