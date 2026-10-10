package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.UserSignInList;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.Iterator;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Zb extends OnResponseListener<UserSignInResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ _b f10867a;

    Zb(_b _bVar) {
        this.f10867a = _bVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserSignInResponse userSignInResponse) {
        if (userSignInResponse == null || userSignInResponse.getUserSignInList() == null || userSignInResponse.getUserSignInList().size() == 0) {
            return;
        }
        int signInStatus = userSignInResponse.getSignInStatus();
        if (signInStatus == 0) {
            Iterator<UserSignInList> it = userSignInResponse.getUserSignInList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UserSignInList next = it.next();
                if (next.getStatus() == 0) {
                    next.setSelect(true);
                    break;
                }
            }
            if (this.f10867a.f10869a) {
                com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
            }
            new com.disabngo.blockynexus.view.dialog.a.d(this.f10867a.f10870b, userSignInResponse).show();
            com.sandboxol.greendao.c.ya.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), true);
            return;
        }
        if (signInStatus != 2) {
            return;
        }
        if (DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd").equals(SharedUtils.getString(this.f10867a.f10870b, AccountCenter.newInstance().userId.get() + SharedConstant.ACTIVITY_SIGN_UP_IS_LAST_DAY))) {
            return;
        }
        if (this.f10867a.f10869a) {
            com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
        }
        _b _bVar = this.f10867a;
        _bVar.f10871c.e(_bVar.f10870b);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i != 8006) {
            CampaignOnError.showErrorTip(this.f10867a.f10870b, i);
            return;
        }
        if (this.f10867a.f10869a) {
            com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
        }
        _b _bVar = this.f10867a;
        _bVar.f10871c.e(_bVar.f10870b);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10867a.f10870b, i);
    }
}
