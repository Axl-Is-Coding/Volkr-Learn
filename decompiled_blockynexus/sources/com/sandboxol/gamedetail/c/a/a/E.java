package com.sandboxol.gamedetail.c.a.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.greendao.entity.BannerEntity;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GameDetailDataLogic.java */
/* JADX INFO: loaded from: classes3.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17903a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17904b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17905c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f17906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17908f;
    private wa g;
    private Z h;
    private boolean i;
    public ObservableList<String> j;
    public ObservableList<String> k;
    public ObservableList<BannerEntity> l;

    public E(Context context, String str, ObservableList<String> observableList, ObservableList<String> observableList2, ObservableList<BannerEntity> observableList3, wa waVar) {
        this.f17906d = context;
        this.f17907e = str;
        this.j = observableList;
        this.k = observableList2;
        this.l = observableList3;
        this.g = waVar;
        this.h = new Z(context);
    }

    private void c(Game game) {
        if (game == null || game.getBannerPic() == null || game.getBannerPic().size() == 0) {
            return;
        }
        this.k.clear();
        this.j.clear();
        this.l.clear();
        this.k.addAll(new ArrayList());
        this.j.addAll(game.getBannerPic());
        BannerEntity bannerEntity = new BannerEntity();
        bannerEntity.setImage(game.getBannerPic().get(0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(bannerEntity);
        this.l.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Game game) {
        this.g.a(game, false);
    }

    public void a(P p) {
        com.sandboxol.greendao.c.U.newInstance().a(this.f17907e, new B(this, p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Game game, int i, wa waVar, ObservableField<Boolean> observableField) {
        this.h.a(this.f17907e, EngineEnv.getEngineVersion(game.getIsNewEngine(), game.getIsUgc()), new C(this, i, game, observableField, waVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Game game) {
        if (this.f17908f || game == null) {
            return;
        }
        this.k.clear();
        this.j.clear();
        this.l.clear();
        if (game.getGameBannerVideoInfos() != null && game.getGameBannerVideoInfos().size() > 0) {
            Helper.manageBannerData(game.getGameBannerVideoInfos(), this.k, this.j, this.l);
            if (this.l.size() > 0) {
                this.l.addAll(game.getGameBannerVideoInfos());
            } else {
                c(game);
            }
        } else {
            c(game);
        }
        this.f17908f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Game game, long j, long j2, String str, String str2) {
        a(game, j, j2, str, str2, false);
    }

    public void a(Game game, long j, long j2, String str, String str2, boolean z) {
        if (z) {
            this.i = true;
        }
        this.h.a(j, j2, str, str2, game.getGameUgcType(), new D(this, game));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AppEngineResourceUpdateResult> list) {
        for (AppEngineResourceUpdateResult appEngineResourceUpdateResult : list) {
            String str = this.f17907e;
            byte b2 = -1;
            if (str.hashCode() == 96630125 && str.equals(StringConstant.DRAGON_EGG_GAME_ID)) {
                b2 = 0;
            }
            if (b2 == 0) {
                appEngineResourceUpdateResult.setNeedUpdate(false);
            }
        }
    }
}
