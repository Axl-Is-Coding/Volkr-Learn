package com.jakewharton.rxbinding.widget;

import android.view.View;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
class ToolbarNavigationClickOnSubscribe$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Subscriber f15445a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15445a.isUnsubscribed()) {
            return;
        }
        this.f15445a.onNext(null);
    }
}
