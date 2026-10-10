package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.AuthorInfo;
import java.util.List;

/* JADX INFO: compiled from: GameDetailIntroduceModel.java */
/* JADX INFO: loaded from: classes3.dex */
class i extends OnResponseListener<List<AuthorInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f18058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f18059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f18060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f18061d;

    i(k kVar, List list, boolean z, Context context) {
        this.f18061d = kVar;
        this.f18058a = list;
        this.f18059b = z;
        this.f18060c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f18060c, R.string.gamedetail_connect_server_failure_error);
        this.f18061d.a(this.f18059b);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18060c, i);
        this.f18061d.a(this.f18059b);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<AuthorInfo> list) {
        this.f18058a.addAll(list);
        this.f18061d.a(this.f18059b);
    }
}
