package com.sandboxol.gamedetail.c.a.a;

import androidx.databinding.ObservableField;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.center.utils.GameResVersionManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.BannerPic;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: GameDetailDataLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class C extends OnResponseListener<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f17896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Game f17897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f17898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ wa f17899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ E f17900e;

    C(E e2, int i, Game game, ObservableField observableField, wa waVar) {
        this.f17900e = e2;
        this.f17896a = i;
        this.f17897b = game;
        this.f17898c = observableField;
        this.f17899d = waVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        int i = this.f17896a;
        if (game.getWarmUpResponse() != null) {
            game.getWarmUpResponse().getFeaturedPlay().add(0, new BannerPic(game.getWarmUpResponse().getGameDetail(), true));
        }
        this.f17897b.setIsNewEngine(game.getIsNewEngine());
        long oldGameResVersion = GameResVersionManager.getOldGameResVersion(this.f17897b, game.getGameId());
        if (game.getIsNewEngine() == 0 && this.f17897b.getLatestResVersions() != null) {
            if (game.getLatestResVersions().getGresVersion() <= oldGameResVersion) {
                i = 3;
            } else if (oldGameResVersion != 0) {
                i = 2;
            }
        }
        if (game.getIsNewEngine() == 1 && !CommonUtils.isNewEngineCommonGame(this.f17900e.f17907e) && game.getLatestResVersions().getGresVersion() <= this.f17897b.getLatestResVersions().getGresVersion() && game.getLatestResVersions().getCresVersion() <= EngineEnv.loadCommonResVersion(this.f17900e.f17906d, game.getIsNewEngine(), game.getIsUgc())) {
            if (game.getLatestResVersions().getGresVersion() <= oldGameResVersion) {
                i = 3;
            } else if (oldGameResVersion != 0) {
                i = 2;
            }
        }
        if (game.getIsNewEngine() != 0 && CommonUtils.isNewEngineCommonGame(this.f17900e.f17907e) && game.getLatestResVersions() != null && game.getLatestResVersions().getCresVersion() <= EngineEnv.loadCommonResVersion(this.f17900e.f17906d, game.getIsNewEngine(), game.getIsUgc()) && game.getLatestResVersions().getGresVersion() <= SharedUtils.getLong(this.f17900e.f17906d, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION)) {
            i = 3;
        }
        long engineVersion = EngineEnv.getEngineVersion(game.getIsNewEngine(), game.getIsUgc());
        String engineType = EngineEnv.getEngineType(game.getIsNewEngine(), game.getIsUgc());
        if (i == 1) {
            this.f17898c.set(true);
            E e2 = this.f17900e;
            e2.a(game, engineVersion, 0L, e2.f17907e, engineType);
        } else if (i == 2) {
            this.f17898c.set(true);
            E e3 = this.f17900e;
            e3.a(game, engineVersion, oldGameResVersion, e3.f17907e, engineType);
        } else if (i == 3) {
            this.f17898c.set(false);
            if (CommonHelper.hasWriteExternalStorage(this.f17900e.f17906d)) {
                com.sandboxol.greendao.c.U.newInstance().a(game);
            }
        }
        this.f17900e.a(game);
        this.f17899d.a(game);
        if (this.f17900e.f17907e != null) {
            this.f17900e.h.a(this.f17900e.f17907e);
        }
        this.f17900e.h.a(game.getTurntableStatus(), game.getTurntableRemainCount(), this.f17900e.f17907e);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f17900e.f17906d, HttpUtils.getHttpErrorMsg(this.f17900e.f17906d, i));
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f17900e.f17906d, HttpUtils.getHttpErrorMsg(this.f17900e.f17906d, i));
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }
}
