package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.ChatRoomResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class T extends OnResponseListener<ChatRoomResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Z f17943d;

    T(Z z, Game game, String str, String str2) {
        this.f17943d = z;
        this.f17940a = game;
        this.f17941b = str;
        this.f17942c = str2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ChatRoomResponse chatRoomResponse) {
        this.f17943d.a(chatRoomResponse.getRoomId(), this.f17940a, this.f17941b, this.f17942c);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f17943d.f17962a, R.string.base_party_create_chat_room_failed);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f17943d.f17962a, R.string.base_party_create_chat_room_failed);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }
}
