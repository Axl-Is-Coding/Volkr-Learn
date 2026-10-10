package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.center.entity.UserSignInList;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.Iterator;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class ac extends OnResponseListener<UserSignInResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10876b;

    ac(bc bcVar, Context context) {
        this.f10876b = bcVar;
        this.f10875a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserSignInResponse userSignInResponse) {
        if (userSignInResponse == null || userSignInResponse.getUserSignInList() == null || userSignInResponse.getUserSignInList().size() == 0) {
            return;
        }
        if (userSignInResponse.getSignInStatus() == 0) {
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
        }
        new com.disabngo.blockynexus.view.dialog.a.d(this.f10875a, userSignInResponse).show();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f10875a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10875a, i);
    }
}
