package com.disabngo.blockynexus.e.b.L;

import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InboxListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<List<MailInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f9337b;

    e(f fVar, OnResponseListener onResponseListener) {
        this.f9337b = fVar;
        this.f9336a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9336a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9336a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<MailInfo> list) {
        Iterator<MailInfo> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getStatus() == 1) {
                i++;
            }
        }
        Messenger.getDefault().send(Boolean.valueOf(i > 0), MessageToken.TOKEN_IS_HAS_NEW_EMAIL);
        this.f9336a.onSuccess(list);
    }
}
