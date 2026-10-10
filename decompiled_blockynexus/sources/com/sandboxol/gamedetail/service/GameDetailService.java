package com.sandboxol.gamedetail.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.moduleApi.IGameDetailService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.gamedetail.c.a.a.Z;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterServicePath.EventGameDetail.GAME_DETAIL_SERVICE)
public class GameDetailService implements IGameDetailService {
    @Override // com.sandboxol.center.router.moduleApi.IGameDetailService
    public void enterGameDetail(Context context, String str, Game game) {
        new Z(context).a(str, game);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGameDetailService
    public void gameDetail(Context context, String str, long j, OnResponseListener<Game> onResponseListener) {
        new Z(context).a(str, j, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGameDetailService
    public void enterGameDetail(Context context, String str, String str2) {
        GameApi.gameDetail(context, str2, 0L, new a(this, context, str));
    }
}
