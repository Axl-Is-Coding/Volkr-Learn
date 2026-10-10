package com.disabngo.blockynexus.e.b.U;

import android.util.Log;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.GameWarmUpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.ReplaceMsg;

/* JADX INFO: compiled from: PreheatViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener<GameWarmUpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9459a;

    f(g gVar) {
        this.f9459a = gVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GameWarmUpResponse gameWarmUpResponse) {
        this.f9459a.f9460a.notifyData(gameWarmUpResponse);
        Messenger.getDefault().send(ReplaceMsg.create(gameWarmUpResponse.getFeaturedPlay()), MessageToken.TOKEN_REPLACE_PREHEAT_LIST);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("gamePreheat", str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("gamePreheat", String.valueOf(i));
    }
}
