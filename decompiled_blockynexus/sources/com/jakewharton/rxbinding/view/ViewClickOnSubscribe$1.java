package com.jakewharton.rxbinding.view;

import android.view.View;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
class ViewClickOnSubscribe$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Subscriber f15444a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15444a.isUnsubscribed()) {
            return;
        }
        this.f15444a.onNext(null);
    }
}
