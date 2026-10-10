package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXBaseHybridActivity f3746a;

    i(WXBaseHybridActivity wXBaseHybridActivity) {
        this.f3746a = wXBaseHybridActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3746a.finish();
    }
}
