package com.disabngo.blockynexus.e.b.fa;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.SecretQuestionFinishDialog;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SecretQuestionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9775a;

    k(l lVar) {
        this.f9775a = lVar;
    }

    public /* synthetic */ void a() {
        ((Activity) this.f9775a.f9776a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 102) {
            AppToastUtils.showShortNegativeTipToast(this.f9775a.f9776a, R.string.user_not_exist);
            return;
        }
        if (i == 114) {
            AppToastUtils.showShortNegativeTipToast(this.f9775a.f9776a, R.string.bind_email_user_has_bind);
            return;
        }
        if (i == 117) {
            AppToastUtils.showShortNegativeTipToast(this.f9775a.f9776a, R.string.verify_email_fail);
        } else if (i != 118) {
            AppToastUtils.showShortNegativeTipToast(this.f9775a.f9776a, str);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f9775a.f9776a, R.string.has_set_secret_question);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9775a.f9776a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AccountCenter.newInstance().isFinishSecretQuestion.set(true);
        AccountCenter.putAccountInfo();
        l lVar = this.f9775a;
        SecretQuestionFinishDialog secretQuestionFinishDialog = new SecretQuestionFinishDialog(lVar.f9776a, lVar.m.get(), this.f9775a.n.get(), this.f9775a.k.get(), this.f9775a.l.get());
        secretQuestionFinishDialog.a(new SecretQuestionFinishDialog.Listener() { // from class: com.disabngo.blockynexus.e.b.fa.a
            @Override // com.disabngo.blockynexus.view.dialog.SecretQuestionFinishDialog.Listener
            public final void onClickSave() {
                this.f9765a.a();
            }
        });
        secretQuestionFinishDialog.show();
    }
}
