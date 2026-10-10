package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomHybirdActivity f3733a;

    a(CustomHybirdActivity customHybirdActivity) {
        this.f3733a = customHybirdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3733a.finish();
    }
}
