package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.ea;

/* JADX INFO: compiled from: DressItemModel.java */
/* JADX INFO: loaded from: classes3.dex */
class da extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ea.a f17414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f17415b;

    da(ea.a aVar, Context context) {
        this.f17414a = aVar;
        this.f17415b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f17415b, R.string.decorate_dress_failed);
        com.sandboxol.decorate.web.u.a(this.f17415b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f17415b, R.string.decorate_dress_failed);
        ServerOnError.showOnServerError(this.f17415b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        ea.a aVar = this.f17414a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
