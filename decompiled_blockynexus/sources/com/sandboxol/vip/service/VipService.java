package com.sandboxol.vip.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.moduleApi.IVipService;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.vip.R;
import com.sandboxol.vip.c.a;
import com.sandboxol.vip.d.a.a.j;
import com.sandboxol.vip.entity.VipDiamond;
import com.sandboxol.vip.entity.VipFree;
import com.sandboxol.vip.view.fragment.main.n;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventVip.VIP_SERVICE)
public class VipService implements IVipService {
    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void buyVip(Context context, int i, String str) {
        IntentUtils.startGooglePayActivity(context, i == 2 ? "and.vip.2.1" : i == 3 ? "and.vip.3.1" : "and.vip.1.1", MessageToken.TOKEN_RECHARGE_PAY, str);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void enterVipFragment(Context context) {
        TemplateUtils.startTemplate(context, n.class, context.getString(R.string.vip_privilege_center_title));
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public VipProductEntity getProductEntityByVipType(boolean z, int i) {
        return a.a(z, i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public boolean getSubscribeStatus(int i) {
        return a.d(i);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public int getVipSubsDiamond(int i) {
        if (i == 2) {
            return 360;
        }
        if (i == 3) {
            return VipDiamond.MVP;
        }
        return 66;
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public String getVipSubsFree(int i) {
        return i == 2 ? VipFree.VIP_PLUS : i == 3 ? VipFree.MVP : VipFree.VIP;
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportAlreadyOwnedVipSub(Context context) {
        ReportDataAdapter.onEvent(context, "has_supvip");
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportHomeVipClick(Context context) {
        ReportDataAdapter.onEvent(context, "me_vip_click");
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportRechargePageVipClick(Context context, String str) {
        ReportDataAdapter.onEvent(context, "click_vip_intopup", str);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportVipSubWin(Context context) {
        ReportDataAdapter.onEvent(context, "vip_sub_win");
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportVipSubscribeFail(Context context, String str) {
        ReportDataAdapter.onEvent(context, "vip_subfail", str);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void reportVipSubscribeSuccess(Context context, String str) {
        ReportDataAdapter.onEvent(context, "vip_subsuccess", str);
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void resetVipInfo() {
        VipDataManager.getInstance().setVipSubInfo(new VipSubInfo());
    }

    @Override // com.sandboxol.center.router.moduleApi.IVipService
    public void showSubscribeDialog(Context context) {
        List<Integer> vipList = AppInfoCenter.newInstance().getAppConfig().getVipList();
        if (vipList == null || vipList.size() <= 0) {
            return;
        }
        new j(context, false, vipList.get(0).intValue(), true).show();
    }
}
