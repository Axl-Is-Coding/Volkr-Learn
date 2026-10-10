package com.disabngo.blockynexus.e.b.ha;

import android.app.Activity;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.e.C0834f;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.UserVerifyInfo;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;

/* JADX INFO: compiled from: SecretQuestionVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<UserVerifyInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f9808b;

    h(i iVar, int i) {
        this.f9808b = iVar;
        this.f9807a = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserVerifyInfo userVerifyInfo) {
        this.f9808b.k.set(true);
        if (!userVerifyInfo.isRight()) {
            AppToastUtils.showShortPositiveTipToast(this.f9808b.f9809a, R.string.answer_incorrect);
            return;
        }
        this.f9808b.l.set(true);
        this.f9808b.j.f8729a.setFocusable(true);
        this.f9808b.j.f8729a.setFocusableInTouchMode(true);
        this.f9808b.j.f8729a.requestFocus();
        if (this.f9807a == 1) {
            if (this.f9808b.f9811c) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.AUTHCODE, userVerifyInfo.getAuthCode());
                bundle.putString("user_id", this.f9808b.h);
                bundle.putString(StringConstant.UID, this.f9808b.i);
                TemplateNewUtils.startTemplate(this.f9808b.f9809a, com.disabngo.blockynexus.e.b.ba.e.class, this.f9808b.f9809a.getString(R.string.item_view_forget_password), bundle);
                if ((this.f9808b.f9809a instanceof Activity) && !((Activity) this.f9808b.f9809a).isFinishing()) {
                    ((Activity) this.f9808b.f9809a).finish();
                }
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_RESET_PASSWORD);
                return;
            }
            AppToastUtils.showShortPositiveTipToast(this.f9808b.f9809a, R.string.pass_friend_verify);
            Bundle bundle2 = new Bundle();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.f9808b.o.get());
            arrayList.add(this.f9808b.p.get());
            bundle2.putStringArrayList(StringConstant.SECRET_ANSWER, arrayList);
            TemplateUtils.startTemplate(this.f9808b.f9809a, C0834f.class, this.f9808b.f9809a.getString(R.string.item_view_bind_email), bundle2);
            if (!(this.f9808b.f9809a instanceof Activity) || ((Activity) this.f9808b.f9809a).isFinishing()) {
                return;
            }
            ((Activity) this.f9808b.f9809a).finish();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9808b.k.set(true);
        switch (i) {
            case 119:
                AppToastUtils.showShortNegativeTipToast(this.f9808b.f9809a, R.string.not_set_secret_question);
                break;
            case 120:
                AppToastUtils.showShortNegativeTipToast(this.f9808b.f9809a, R.string.frequently_answer);
                break;
            case 121:
                AppToastUtils.showShortNegativeTipToast(this.f9808b.f9809a, R.string.frequently_answer_more_ten);
                break;
            default:
                AppToastUtils.showShortNegativeTipToast(this.f9808b.f9809a, str);
                break;
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9808b.k.set(true);
        ServerOnError.showOnServerError(this.f9808b.f9809a, i);
    }
}
