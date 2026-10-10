package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import android.content.Intent;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.CampaignManager;
import com.sandboxol.center.utils.FiveStarsLogicUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.nb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1038nb implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f10934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ User f10935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MainActivity f10936c;

    C1038nb(MainActivity mainActivity, Intent intent, User user) {
        this.f10936c = mainActivity;
        this.f10934a = intent;
        this.f10935b = user;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        boolean zFiveStartLogic = FiveStarsLogicUtils.fiveStartLogic(this.f10936c, bool.booleanValue());
        CampaignManager.getActivitySignUp(this.f10936c, true);
        if (zFiveStartLogic && AccountCenter.newInstance().login.get().booleanValue() && !SharedUtils.getBoolean(this.f10936c, "is.has.market.rate") && bool.booleanValue() && this.f10934a.getBooleanExtra(GameConstant.IS_EXIT_NORMAL, true)) {
            com.disabngo.blockynexus.d.D.c((Context) this.f10936c);
        } else {
            if (AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0) {
                return;
            }
            com.sandboxol.greendao.c.va.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new C1035mb(this));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
