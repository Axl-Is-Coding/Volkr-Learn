package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.CampaignManager;
import com.sandboxol.center.utils.FiveStarsLogicUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class jc implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Boolean f10917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ User f10918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ nc f10919c;

    jc(nc ncVar, Boolean bool, User user) {
        this.f10919c = ncVar;
        this.f10917a = bool;
        this.f10918b = user;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        boolean zFiveStartLogic = FiveStarsLogicUtils.fiveStartLogic(this.f10919c.f10939c, bool.booleanValue());
        CampaignManager.getActivitySignUp(this.f10919c.f10939c, true);
        if (zFiveStartLogic && AccountCenter.newInstance().login.get().booleanValue() && !SharedUtils.getBoolean(this.f10919c.f10939c, "is.has.market.rate") && bool.booleanValue() && this.f10917a.booleanValue()) {
            com.disabngo.blockynexus.d.D.c((Context) this.f10919c.f10939c);
        } else {
            if (AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0) {
                return;
            }
            com.sandboxol.greendao.c.va.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new ic(this));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
