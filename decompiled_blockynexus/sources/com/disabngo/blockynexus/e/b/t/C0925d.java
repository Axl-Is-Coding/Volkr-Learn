package com.disabngo.blockynexus.e.b.t;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.t.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnsureEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0925d extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0927f f10177a;

    C0925d(C0927f c0927f) {
        this.f10177a = c0927f;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f10177a.f10179a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10177a.f10179a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        C0927f c0927f = this.f10177a;
        c0927f.f10181c = str;
        c0927f.f10182d.set(c0927f.f10179a.getString(R.string.tips_verify_email, str));
    }
}
