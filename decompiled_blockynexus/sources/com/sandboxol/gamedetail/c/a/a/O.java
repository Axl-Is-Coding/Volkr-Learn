package com.sandboxol.gamedetail.c.a.a;

import android.app.Activity;
import android.content.Intent;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.CampaignManager;
import com.sandboxol.center.router.manager.DialogManager;
import com.sandboxol.center.utils.FiveStarsLogicUtils;
import com.sandboxol.common.R;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: GameDetailFragment.java */
/* JADX INFO: loaded from: classes3.dex */
class O implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f17927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ User f17928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ P f17929c;

    O(P p, Intent intent, User user) {
        this.f17929c = p;
        this.f17927a = intent;
        this.f17928b = user;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        boolean zFiveStartLogic = FiveStarsLogicUtils.fiveStartLogic(((BaseFragment) this.f17929c).context, bool.booleanValue());
        CampaignManager.getActivitySignUp(((BaseFragment) this.f17929c).context, true);
        if (zFiveStartLogic && AccountCenter.newInstance().login.get().booleanValue() && !SharedUtils.getBoolean(((BaseFragment) this.f17929c).context, "is.has.market.rate") && bool.booleanValue() && this.f17927a.getBooleanExtra(GameConstant.IS_EXIT_NORMAL, true)) {
            DialogManager.startFiveStarsDialog(((BaseFragment) this.f17929c).context);
        } else if (!AccountCenter.newInstance().hasPassword.get().booleanValue() && AccountCenter.newInstance().userId.get().longValue() != 0) {
            com.sandboxol.greendao.c.va.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), new N(this));
        }
        if (((Activity) ((BaseFragment) this.f17929c).context).findViewById(R.id.tvTip).getVisibility() == 0) {
            this.f17929c.f17931b.a(this.f17929c.f17930a, false);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
