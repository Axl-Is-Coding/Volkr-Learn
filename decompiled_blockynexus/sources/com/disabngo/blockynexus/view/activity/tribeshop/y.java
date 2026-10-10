package com.disabngo.blockynexus.view.activity.tribeshop;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: TribeShopActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class y implements com.sandboxol.messager.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TribeShopActivity f11187a;

    y(TribeShopActivity tribeShopActivity) {
        this.f11187a = tribeShopActivity;
    }

    @Override // com.sandboxol.messager.a.a
    public void onCall() {
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_SHOP_LIST);
    }
}
