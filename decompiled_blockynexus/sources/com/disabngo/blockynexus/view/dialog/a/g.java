package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: ActivitySignUpModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<Map<String, Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UserSignInResponse f11458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f11459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f11460d;

    g(h hVar, Context context, UserSignInResponse userSignInResponse, d dVar) {
        this.f11460d = hVar;
        this.f11457a = context;
        this.f11458b = userSignInResponse;
        this.f11459c = dVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Map<String, Integer> map) {
        if (map == null || map.get("signInId") == null) {
            return;
        }
        SandboxReportManager.onEvent(ReportEvent.USER_SIGN_UP, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
        ReportDataAdapter.onEvent(this.f11457a, EventConstant.EDAY_SIGNIN_SUC, String.valueOf(map.get("signInId")));
        this.f11458b.setSignInStatus(1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f11460d.a(this.f11458b.getUserSignInList(), map.get("signInId").intValue(), arrayList, arrayList2);
        if (arrayList.size() >= 4 && arrayList2.size() >= 4) {
            SharedUtils.putString(this.f11457a, AccountCenter.newInstance().userId.get() + SharedConstant.ACTIVITY_SIGN_UP_IS_LAST_DAY, DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd"));
        }
        BillingManager.getInstance().updateUserMoney(this.f11457a);
        new CampaignGetIntegralRewardDialog(this.f11457a).setStringDataList(arrayList.size(), arrayList, arrayList2).show();
        this.f11459c.dismiss();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f11457a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11457a, i);
    }
}
