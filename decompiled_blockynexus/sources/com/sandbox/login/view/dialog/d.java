package com.sandbox.login.view.dialog;

import android.util.Log;
import rx.Observer;

/* JADX INFO: compiled from: ProtocolDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProtocolDialog f15980a;

    d(ProtocolDialog protocolDialog) {
        this.f15980a = protocolDialog;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(String str) {
        this.f15980a.f15971a.setText(str);
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Log.e("NexFragment", "读取数据失败。。。" + th.toString());
    }
}
