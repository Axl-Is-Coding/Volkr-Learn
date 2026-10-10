package com.disabngo.blockynexus.e.b.L;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: InboxModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9342a;

    h(j jVar) {
        this.f9342a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        Messenger.getDefault().send(bool, MessageToken.TOKEN_IS_HAS_NEW_EMAIL);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Messenger.getDefault().send(false, MessageToken.TOKEN_IS_HAS_NEW_EMAIL);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Messenger.getDefault().send(false, MessageToken.TOKEN_IS_HAS_NEW_EMAIL);
    }
}
