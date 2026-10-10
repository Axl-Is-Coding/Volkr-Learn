package com.sandboxol.center.router.manager;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.ICampaignService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.interfaces.OnDataListener;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignManager {
    private static ICampaignService iCampaignService = (ICampaignService) RouteServiceManager.provide(RouterServicePath.EventCampaign.CAMPAIGN_SERVICE);

    public static void getActivitySignUp(Context context, boolean z) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.getActivitySignUp(context, z);
        }
    }

    public static void isCampaignHasRedPoint(Context context, ObservableField<Integer> observableField) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.isCampaignHasRedPoint(context, observableField);
        }
    }

    public static void isGoCampaignRefresh(Context context, ObservableField<Integer> observableField) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.isGoCampaignRefresh(context, observableField);
        }
    }

    public static void isShowCampaign(Context context, ObservableField<Boolean> observableField) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.isShowCampaign(context, observableField);
        }
    }

    public static void onGoCampaign(Context context, String str) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.onGoCampaign(context, str);
        }
    }

    public static void showResultDialog(Context context, Serializable serializable, OnDataListener onDataListener) {
        ICampaignService iCampaignService2 = iCampaignService;
        if (iCampaignService2 != null) {
            iCampaignService2.showResultDialog(context, serializable, onDataListener);
        }
    }
}
