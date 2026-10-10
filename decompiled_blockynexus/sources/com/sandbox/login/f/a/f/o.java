package com.sandbox.login.f.a.f;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandbox.login.f.a.f.q;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.BlockAccountResult;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: StepModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<AuthTokenResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SetPasswordForm f15895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f15896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ q.b f15897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f15898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ q f15899e;

    o(q qVar, SetPasswordForm setPasswordForm, Context context, q.b bVar, ObservableField observableField) {
        this.f15899e = qVar;
        this.f15895a = setPasswordForm;
        this.f15896b = context;
        this.f15897c = bVar;
        this.f15898d = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i != 17) {
            UserOnError.showErrorTip(this.f15896b, i);
        } else if (str != null) {
            try {
                BlockAccountResult blockAccountResult = (BlockAccountResult) new com.google.gson.j().a(str, new n(this).getType());
                AppInfoCenter.newInstance().setBlockAccount(blockAccountResult);
                if (blockAccountResult != null) {
                    Messenger.getDefault().sendNoMsg(MessageToken.SHOW_BLOCK_ACCOUNT_DIALOG);
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_APP);
                    if (!(this.f15896b instanceof Activity) || ((Activity) this.f15896b).isFinishing()) {
                        return;
                    }
                    ((Activity) this.f15896b).finish();
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f15898d.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15896b, i);
        this.f15898d.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(AuthTokenResponse authTokenResponse) {
        AccountManager.getInstance().onNewAccountCreated(authTokenResponse);
        this.f15895a.setUserId(Long.valueOf(authTokenResponse.getUserId()));
        this.f15899e.a(this.f15896b, this.f15895a, this.f15897c);
    }
}
