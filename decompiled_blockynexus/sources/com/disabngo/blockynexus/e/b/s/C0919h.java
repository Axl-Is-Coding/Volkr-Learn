package com.disabngo.blockynexus.e.b.s;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.s.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0919h extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0921j f10160a;

    C0919h(C0921j c0921j) {
        this.f10160a = c0921j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f10160a.f10162a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10160a.f10162a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10160a.f10166e.set(true);
        String string = this.f10160a.f10162a.getResources().getString(R.string.send_verify_email_tips);
        C0921j c0921j = this.f10160a;
        c0921j.k.set(String.format(string, String.format("%s*****@%s", c0921j.h.getEmail().split("@")[0].substring(0, 4), this.f10160a.h.getEmail().split("@")[1])));
        AppToastUtils.showShortPositiveTipToast(this.f10160a.f10162a, R.string.bind_phone_code_send_success);
    }
}
