package com.sandboxol.gamedetail.c.a.a;

import android.os.Bundle;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class Q implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Z f17935c;

    Q(Z z, Game game, String str) {
        this.f17935c = z;
        this.f17933a = game;
        this.f17934b = str;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        Bundle bundle = new Bundle();
        if (game != null) {
            bundle.putSerializable(StringConstant.MINI_GAME_DETAIL, game);
        }
        bundle.putSerializable(StringConstant.GAME_NO_DETAIL, this.f17933a);
        bundle.putString(StringConstant.MINI_GAME_ID, this.f17933a.getGameId());
        TemplateUtils.startSingleTemplate(this.f17935c.f17962a, P.class, this.f17934b, bundle);
        SharedUtils.putBoolean(this.f17935c.f17962a, SharedConstant.IS_SHOW_GAME_DETAIL_BACK_ADS, true);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
