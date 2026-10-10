package com.disabngo.blockynexus.e.b.ia;

import rx.Subscriber;

/* JADX INFO: compiled from: SettingViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends Subscriber<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9835a;

    l(m mVar) {
        this.f9835a = mVar;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(String str) {
        this.f9835a.f9838c.set(str);
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }
}
