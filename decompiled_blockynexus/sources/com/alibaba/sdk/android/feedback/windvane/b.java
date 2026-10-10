package com.alibaba.sdk.android.feedback.windvane;

import android.content.Intent;
import android.view.View;
import com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity;

/* JADX INFO: loaded from: classes.dex */
class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomHybirdActivity f3734a;

    b(CustomHybirdActivity customHybirdActivity) {
        this.f3734a = customHybirdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("url", ((XBBaseHybridActivity) this.f3734a).mUrl);
        this.f3734a.setResult(com.alibaba.sdk.android.feedback.xblink.f.b.a.f3836e, intent);
        if (this.f3734a.mPageAction.a()) {
            this.f3734a.mPageAction.b();
        } else if (this.f3734a.isCanGoBack()) {
            this.f3734a.webview.goBack();
        } else {
            this.f3734a.finish();
        }
    }
}
