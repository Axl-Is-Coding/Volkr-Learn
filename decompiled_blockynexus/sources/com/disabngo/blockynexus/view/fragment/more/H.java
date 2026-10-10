package com.disabngo.blockynexus.view.fragment.more;

import rx.Subscriber;

/* JADX INFO: compiled from: MoreViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends Subscriber<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MoreViewModel f11845a;

    H(MoreViewModel moreViewModel) {
        this.f11845a = moreViewModel;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Boolean bool) {
        if (bool.booleanValue()) {
            this.f11845a.f11850e.set(true);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }
}
