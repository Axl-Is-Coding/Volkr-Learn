package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3744a;

    g(d dVar) {
        this.f3744a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3744a.getActivity().finish();
    }
}
