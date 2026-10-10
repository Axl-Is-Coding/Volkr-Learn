package com.sandboxol.googlepay.view.fragment.recharge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.databinding.ObservableField;
import com.android.billingclient.util.BillingHelper;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.googlepay.R;
import java.util.Map;

/* JADX INFO: compiled from: RechargeModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {
    public void b(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        Map map = (Map) new com.google.gson.j().a(buyParam.getPurchaseData(), Map.class);
        String str = map != null ? (String) map.get(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD) : null;
        StarCodeUser starCodeUser = new StarCodeUser();
        if (str != null && str.contains("starCodeUserId") && str.contains("starCode")) {
            for (String str2 : str.split("&")) {
                if (str2.startsWith("starCodeUserId")) {
                    starCodeUser.setUserId(Long.parseLong(str2.split("=")[1]));
                }
                if (str2.startsWith("starCode")) {
                    starCodeUser.setStarCode(str2.split("=")[1]);
                }
            }
        }
        BillingManager.getInstance().buyVip(context, buyParam, starCodeUser, onResponseListener);
    }

    public void c(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        Map map = (Map) new com.google.gson.j().a(buyParam.getPurchaseData(), Map.class);
        String str = map != null ? (String) map.get(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD) : null;
        StarCodeUser starCodeUser = new StarCodeUser();
        if (str != null && str.contains("starCodeUserId") && str.contains("starCode")) {
            for (String str2 : str.split("&")) {
                if (str2.startsWith("starCodeUserId")) {
                    starCodeUser.setUserId(Long.parseLong(str2.split("=")[1]));
                }
                if (str2.startsWith("starCode")) {
                    starCodeUser.setStarCode(str2.split("=")[1]);
                }
            }
        }
        BillingManager.getInstance().buyVipExtend(context, buyParam, starCodeUser, onResponseListener);
    }

    public void d(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener) {
        Map map = (Map) new com.google.gson.j().a(buyParam.getPurchaseData(), Map.class);
        String str = map != null ? (String) map.get(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD) : null;
        StarCodeUser starCodeUser = new StarCodeUser();
        if (str != null && str.contains("starCodeUserId") && str.contains("starCode")) {
            for (String str2 : str.split("&")) {
                if (str2.startsWith("starCodeUserId")) {
                    starCodeUser.setUserId(Long.parseLong(str2.split("=")[1]));
                }
                if (str2.startsWith("starCode")) {
                    starCodeUser.setStarCode(str2.split("=")[1]);
                }
            }
        }
        BillingManager.getInstance().recharge(context, buyParam, starCodeUser, onResponseListener);
    }

    public void a(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener) {
        Map map = (Map) new com.google.gson.j().a(buyParam.getPurchaseData(), Map.class);
        String str = map != null ? (String) map.get(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD) : null;
        StarCodeUser starCodeUser = new StarCodeUser();
        if (str != null && str.contains("starCodeUserId") && str.contains("starCode")) {
            for (String str2 : str.split("&")) {
                if (str2.startsWith("starCodeUserId")) {
                    starCodeUser.setUserId(Long.parseLong(str2.split("=")[1]));
                }
                if (str2.startsWith("starCode")) {
                    starCodeUser.setStarCode(str2.split("=")[1]);
                }
            }
        }
        BillingManager.getInstance().buySubs(context, buyParam, starCodeUser, onResponseListener);
    }

    public void a(Context context) {
        IntentUtils.startTopLoadingDialog((Activity) context);
        BillingManager.getInstance().getPaySignature(context, new q(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (Helper.hasBrowserCount(context)) {
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        AppToastUtils.showShortNegativeTipToast(context, R.string.base_no_browser);
    }

    public void a(Context context, String str, OnResponseListener<StarCodeUser> onResponseListener) {
        UserApi.getStarCodeUserInfo(context, str, onResponseListener);
    }

    public void a(Context context, int i) {
        if (!AccountCenter.newInstance().login.get().booleanValue()) {
            LoginManager.forceReLogin(context);
        } else {
            SharedUtils.putLong(context, "last.time.watch.ads", System.currentTimeMillis());
            UserApi.newSignIn(context, new r(this, context));
        }
    }

    public void a(Context context, ObservableField<Boolean> observableField) {
        BillingManager.getInstance().isShowThirdPart(context, new s(this, observableField, context));
    }
}
