package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3741a;

    e(d dVar) {
        this.f3741a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3741a.f3735a.post(new f(this, this.f3741a.f3737c.getWvUIModel()));
        this.f3741a.a();
    }
}
