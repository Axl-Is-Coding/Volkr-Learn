package com.disabngo.blockynexus.view.fragment.main;

import androidx.databinding.Observable;
import com.sandboxol.center.download.entity.GameProgressInfo;

/* JADX INFO: compiled from: BaseGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GameProgressInfo f11758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f11759b;

    D(E e2, GameProgressInfo gameProgressInfo) {
        this.f11759b = e2;
        this.f11758a = gameProgressInfo;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        this.f11759b.g.set(Boolean.valueOf(!this.f11758a.getIsAnimEnd().get().booleanValue()));
    }
}
