package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IGameDetailService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
public class GameDetailManager {
    private static IGameDetailService iGameDetailService = (IGameDetailService) RouteServiceManager.provide(RouterServicePath.EventGameDetail.GAME_DETAIL_SERVICE);

    public static void enterGameDetail(Context context, String str, Game game) {
        IGameDetailService iGameDetailService2 = iGameDetailService;
        if (iGameDetailService2 != null) {
            iGameDetailService2.enterGameDetail(context, str, game);
        }
    }

    public static void gameDetail(Context context, String str, long j, OnResponseListener<Game> onResponseListener) {
        IGameDetailService iGameDetailService2 = iGameDetailService;
        if (iGameDetailService2 != null) {
            iGameDetailService2.gameDetail(context, str, j, onResponseListener);
        }
    }

    public static void enterGameDetail(Context context, String str, String str2) {
        IGameDetailService iGameDetailService2 = iGameDetailService;
        if (iGameDetailService2 != null) {
            iGameDetailService2.enterGameDetail(context, str, str2);
        }
    }
}
