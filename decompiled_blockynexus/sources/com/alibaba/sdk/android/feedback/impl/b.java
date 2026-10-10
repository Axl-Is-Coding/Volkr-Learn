package com.alibaba.sdk.android.feedback.impl;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ErrorPageActivity f3697a;

    b(ErrorPageActivity errorPageActivity) {
        this.f3697a = errorPageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3697a.finish();
    }
}
