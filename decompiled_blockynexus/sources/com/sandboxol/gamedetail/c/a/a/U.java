package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class U extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Game f17945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f17947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Z f17948e;

    U(Z z, String str, Game game, String str2, String str3) {
        this.f17948e = z;
        this.f17944a = str;
        this.f17945b = game;
        this.f17946c = str2;
        this.f17947d = str3;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f17948e.f17962a, R.string.base_party_create_chat_room_failed);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f17948e.f17962a, R.string.base_party_create_chat_room_failed);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        this.f17948e.a(miniGameToken.getRegion(), miniGameToken.getDispUrl(), this.f17944a, this.f17945b, this.f17946c, this.f17947d);
    }
}
