package com.disabngo.blockynexus.view.fragment.main;

import androidx.databinding.Observable;
import com.sandboxol.center.download.entity.GameProgressInfo;

/* JADX INFO: compiled from: BaseGameItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GameProgressInfo f11756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f11757b;

    C(E e2, GameProgressInfo gameProgressInfo) {
        this.f11757b = e2;
        this.f11756a = gameProgressInfo;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (this.f11756a.getIsAnimEnd().get().booleanValue()) {
            this.f11757b.g.set(false);
        } else {
            this.f11757b.g.set(Boolean.valueOf(!r1.h.get().booleanValue()));
        }
    }
}
