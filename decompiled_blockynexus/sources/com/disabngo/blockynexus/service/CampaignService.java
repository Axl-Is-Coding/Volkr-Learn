package com.disabngo.blockynexus.service;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.sandboxol.center.router.moduleApi.ICampaignService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.interfaces.OnDataListener;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventCampaign.CAMPAIGN_SERVICE)
public class CampaignService implements ICampaignService {
    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void getActivitySignUp(Context context, boolean z) {
        new bc().a(context, z);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void isCampaignHasRedPoint(Context context, ObservableField<Integer> observableField) {
        com.disabngo.blockynexus.b.b.a().a(context, observableField);
    }

    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void isGoCampaignRefresh(Context context, ObservableField<Integer> observableField) {
        com.disabngo.blockynexus.b.b.a().b(context, observableField);
    }

    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void isShowCampaign(Context context, ObservableField<Boolean> observableField) {
        com.disabngo.blockynexus.b.b.a().c(context, observableField);
    }

    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void onGoCampaign(Context context, String str) {
        com.disabngo.blockynexus.b.b.a().a(context, str);
    }

    @Override // com.sandboxol.center.router.moduleApi.ICampaignService
    public void showResultDialog(Context context, Serializable serializable, OnDataListener onDataListener) {
        com.disabngo.blockynexus.b.b.a().a(context, serializable, onDataListener);
    }
}
