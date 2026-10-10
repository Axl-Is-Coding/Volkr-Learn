package com.disabngo.blockynexus.e.b.t;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.t.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnsureEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0926e extends OnResponseListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0927f f10178a;

    C0926e(C0927f c0927f) {
        this.f10178a = c0927f;
    }

    public /* synthetic */ void a() {
        ((Activity) this.f10178a.f10179a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f10178a.f10179a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10178a.f10179a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        OneButtonDialog oneButtonDialog = new OneButtonDialog(this.f10178a.f10179a);
        oneButtonDialog.setButtonText(R.string.confirm);
        oneButtonDialog.setDetailText(this.f10178a.f10179a.getResources().getString(R.string.send_email_tips, this.f10178a.f10181c));
        oneButtonDialog.show();
        oneButtonDialog.setListener(new OneButtonDialog.OneButtonDialogListener() { // from class: com.disabngo.blockynexus.e.b.t.a
            @Override // com.sandboxol.center.view.dialog.OneButtonDialog.OneButtonDialogListener
            public final void onClick() {
                this.f10175a.a();
            }
        });
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_RESET_PASSWORD);
        LoginManager.logoutOnModifyPwd(this.f10178a.f10179a, Long.valueOf(this.f10178a.f10180b).longValue(), false);
    }
}
