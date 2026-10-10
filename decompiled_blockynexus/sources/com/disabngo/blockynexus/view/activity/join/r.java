package com.disabngo.blockynexus.view.activity.join;

import com.disabngo.blockynexus.R;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.Dispatch;

/* JADX INFO: compiled from: EnterGameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends OnResponseListener<Dispatch> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f10736a;

    r(s sVar) {
        this.f10736a = sVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 2) {
            s sVar = this.f10736a;
            sVar.b(sVar.f10737a.getString(R.string.follow_friend_is_full));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_is_full));
            return;
        }
        if (i == 3) {
            s sVar2 = this.f10736a;
            sVar2.b(sVar2.f10737a.getString(R.string.game_detail_appreciation_game_not_exist));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.game_detail_appreciation_game_not_exist));
            return;
        }
        if (i == 4) {
            s sVar3 = this.f10736a;
            sVar3.b(sVar3.f10737a.getString(R.string.game_version_not_match));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.game_version_not_match));
            return;
        }
        if (i == 10) {
            s sVar4 = this.f10736a;
            sVar4.b(sVar4.f10737a.getString(R.string.follow_friend_is_finish));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_is_finish));
            return;
        }
        if (i == 11) {
            s sVar5 = this.f10736a;
            sVar5.b(sVar5.f10737a.getString(R.string.follow_friend_is_full));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_is_full));
            return;
        }
        if (i == 12) {
            s sVar6 = this.f10736a;
            sVar6.b(sVar6.f10737a.getString(R.string.follow_friend_not_support_watch));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_not_support_watch));
            return;
        }
        if (i == 14) {
            s sVar7 = this.f10736a;
            sVar7.b(sVar7.f10737a.getString(R.string.follow_friend_engine_version_not_support));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_engine_version_not_support));
            return;
        }
        if (i == 15) {
            s sVar8 = this.f10736a;
            sVar8.b(sVar8.f10737a.getString(R.string.follow_friend_not_in_game));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_not_in_game));
            return;
        }
        if (i == 16) {
            s sVar9 = this.f10736a;
            sVar9.b(sVar9.f10737a.getString(R.string.follow_friend_is_watching));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_is_watching));
            return;
        }
        if (i == 2009) {
            s sVar10 = this.f10736a;
            sVar10.b(sVar10.f10737a.getString(R.string.dialog_button_update));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.dialog_button_update));
        } else if (i == 2010) {
            s sVar11 = this.f10736a;
            sVar11.b(sVar11.f10737a.getString(R.string.game_version_too_low));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.game_version_too_low));
        } else if (i == 2011) {
            s sVar12 = this.f10736a;
            sVar12.b(sVar12.f10737a.getString(R.string.follow_friend_not_match));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, this.f10736a.f10737a.getString(R.string.follow_friend_not_match));
        } else {
            s sVar13 = this.f10736a;
            sVar13.b(HttpUtils.getHttpErrorMsg(sVar13.f10737a, i));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, HttpUtils.getHttpErrorMsg(this.f10736a.f10737a, i));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i != 2) {
            s sVar = this.f10736a;
            sVar.b(HttpUtils.getHttpErrorMsg(sVar.f10737a, i));
            com.disabngo.blockynexus.d.n.a(this.f10736a.f10737a, HttpUtils.getHttpErrorMsg(this.f10736a.f10737a, i));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Dispatch dispatch) {
        String str;
        AppInfoCenter appInfoCenterNewInstance = AppInfoCenter.newInstance();
        if ("".equals(dispatch.region) || (str = dispatch.region) == null) {
            str = NativeContentAd.ASSET_HEADLINE;
        }
        appInfoCenterNewInstance.setLatelyRegion(str);
        this.f10736a.a(dispatch, true);
        com.disabngo.blockynexus.d.n.e(this.f10736a.f10737a);
    }
}
