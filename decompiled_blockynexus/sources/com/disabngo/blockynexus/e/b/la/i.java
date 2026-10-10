package com.disabngo.blockynexus.e.b.la;

import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: TribeCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f9910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f9911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f9912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f9913f;

    i(l lVar, int i, String str, List list, String str2, int i2) {
        this.f9913f = lVar;
        this.f9908a = i;
        this.f9909b = str;
        this.f9910c = list;
        this.f9911d = str2;
        this.f9912e = i2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f9913f.f9917a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9913f.f9917a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        int i = this.f9908a;
        if (i == 1) {
            this.f9913f.a(str, this.f9909b, (List<String>) this.f9910c, this.f9911d, this.f9912e);
            return;
        }
        if (i != 2) {
            return;
        }
        this.f9913f.a(str, (List<String>) this.f9910c, this.f9909b, this.f9911d);
    }
}
