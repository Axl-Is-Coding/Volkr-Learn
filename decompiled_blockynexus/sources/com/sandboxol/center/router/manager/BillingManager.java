package com.sandboxol.center.router.manager;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IGooglePlayPayService;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.moduleInfo.pay.ThirdPayResponse;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.User;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BillingManager {
    private IGooglePlayPayService googlePlayPayService;

    private static class BillingManagerProxy {
        public static BillingManager billingManager = new BillingManager();

        private BillingManagerProxy() {
        }
    }

    public static BillingManager getInstance() {
        return BillingManagerProxy.billingManager;
    }

    public void acknowledgePurchase(Purchase purchase, boolean z) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.acknowledgePurchase(purchase, z);
        }
    }

    public void buySubs(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.buySubs(context, buyParam, starCodeUser, onResponseListener);
        }
    }

    public void buyVip(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.buyVip(context, buyParam, starCodeUser, onResponseListener);
        }
    }

    public void buyVipExtend(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.buyVipExtend(context, buyParam, starCodeUser, onResponseListener);
        }
    }

    public void consumeAsync(Purchase purchase, boolean z) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.consumeAsync(purchase, z);
        }
    }

    public void firstTopUp(Context context, OnResponseListener<FirstTopUp> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.firstTopUp(context, onResponseListener);
        }
    }

    public void getPaySignature(Context context, OnResponseListener<PaySignatureInfo> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.getPaySignature(context, onResponseListener);
        }
    }

    public void initClient(Context context) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.initClient(context);
        }
    }

    public void isShowThirdPart(Context context, OnResponseListener<Boolean> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.isShowThirdPart(context, onResponseListener);
        }
    }

    public void productsList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.productsList(context, onResponseListener);
        }
    }

    public void productsListAndAds(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.productsListAndAds(context, onResponseListener);
        }
    }

    public void productsListAndAdsAndVipList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.productsListAndAdsAndVipList(context, onResponseListener);
        }
    }

    public void recharge(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<RechargeEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.recharge(context, buyParam, starCodeUser, onResponseListener);
        }
    }

    public void rechargeGift(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.rechargeGift(context, buyParam, onResponseListener);
        }
    }

    public void rechargeHistory(Context context, int i, int i2, OnResponseListener<PageData<PayRecordInfo>> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.rechargeHistory(context, i, i2, onResponseListener);
        }
    }

    public void showThirdPartPayList(Context context, String str, OnResponseListener<ThirdPayResponse> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.showThirdPartPayList(context, str, onResponseListener);
        }
    }

    public void startPay(Activity activity, String str, String str2, String str3) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.startPay(activity, str, null, str2, str3);
        }
    }

    public void updateMoney(Context context, OnResponseListener<RechargeEntity> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.updateMoney(context, onResponseListener);
        }
    }

    public void updateUserMoney(Context context) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.updateUserMoney(context, false, null);
        }
    }

    public void vipProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.vipProductsList(context, onResponseListener);
        }
    }

    public void vipSubsProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.vipSubsProductsList(context, onResponseListener);
        }
    }

    private BillingManager() {
        this.googlePlayPayService = (IGooglePlayPayService) RouteServiceManager.provide(RouterServicePath.EventGooglePlayPay.PAY_SERVICE);
    }

    public void startPay(Activity activity, String str, String str2, String str3, String str4) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.startPay(activity, str, str2, str3, str4);
        }
    }

    public void updateUserMoney(Context context, boolean z) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.updateUserMoney(context, z, null);
        }
    }

    public void updateUserMoney(Context context, User user) {
        IGooglePlayPayService iGooglePlayPayService = this.googlePlayPayService;
        if (iGooglePlayPayService != null) {
            iGooglePlayPayService.updateUserMoney(context, true, user);
        }
    }
}
