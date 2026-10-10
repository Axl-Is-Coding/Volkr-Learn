package com.disabngo.blockynexus.e.b.e;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0837i extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f9728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0839k f9729b;

    C0837i(C0839k c0839k, boolean z) {
        this.f9729b = c0839k;
        this.f9728a = z;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9729b.f9731a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (!this.f9728a) {
            this.f9729b.h.set(false);
            this.f9729b.h();
        }
        ServerOnError.showOnServerError(this.f9729b.f9731a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (!this.f9728a) {
            this.f9729b.h.set(false);
            this.f9729b.h();
        }
        this.f9729b.j.set(true);
        String string = this.f9729b.f9731a.getResources().getString(R.string.send_verify_email_tips);
        C0839k c0839k = this.f9729b;
        c0839k.k.set(String.format(string, String.format("%s*****@%s", c0839k.f9733c.getEmail().split("@")[0].substring(0, 4), this.f9729b.f9733c.getEmail().split("@")[1])));
        AppToastUtils.showShortPositiveTipToast(this.f9729b.f9731a, R.string.bind_phone_code_send_success);
    }
}
