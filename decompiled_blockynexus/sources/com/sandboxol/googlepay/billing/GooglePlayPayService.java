package com.sandboxol.googlepay.billing;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.android.vending.billing.IInAppBillingService;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleApi.IGooglePlayPayService;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayOrder;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.moduleInfo.pay.PayToken;
import com.sandboxol.center.router.moduleInfo.pay.ThirdPayResponse;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.DialogUtilsWrap;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.config.TagConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.googlepay.R;
import com.sandboxol.greendao.entity.User;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = RouterServicePath.EventGooglePlayPay.PAY_SERVICE)
public class GooglePlayPayService implements IGooglePlayPayService {
    private BillingClient billingClient;
    private boolean isServiceConnected;
    private PayloadProxy payloadProxy;

    class PayloadProxy implements InvocationHandler {
        private String extras;
        private Object originObj;

        public PayloadProxy(Object obj) {
            this.originObj = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if ("getBuyIntent".endsWith(name)) {
                objArr[4] = this.extras;
            } else if ("getBuyIntentToReplaceSkus".endsWith(name)) {
                objArr[5] = this.extras;
            } else if ("getBuyIntentExtraParams".endsWith(name)) {
                objArr[4] = this.extras;
            }
            return method.invoke(this.originObj, objArr);
        }

        public void setExtras(String str) {
            this.extras = str;
        }
    }

    private void executeServiceRequest(Runnable runnable) {
        if (this.isServiceConnected) {
            runnable.run();
        } else {
            startBillingServiceConnection(runnable);
        }
    }

    private void handlePurchase(Purchase purchase) {
        if (purchase.getPurchaseState() == 1) {
            Messenger.getDefault().send(new PayOrder(1, true, "pay money success", purchase), MessageToken.TOKEN_RECHARGE_PAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hook(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            this.payloadProxy = new PayloadProxy(declaredField.get(obj));
            declaredField.set(obj, (IInAppBillingService) Proxy.newProxyInstance(IInAppBillingService.class.getClassLoader(), new Class[]{IInAppBillingService.class}, this.payloadProxy));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private void launchBillingFlow(final Activity activity, final List<SkuDetails> list) {
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f18277a.a(list, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryPurchases() {
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f18293a.b();
            }
        });
    }

    private void queryPurchasesFromGoodId(final String str, final Runnable runnable) {
        if (str == null) {
            return;
        }
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f18290a.a(str, runnable);
            }
        });
    }

    private void querySkuDetailsAsync(final Activity activity, final List<String> list, final String str, final String str2, final Action0 action0) {
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18271a.a(str2, list, str, activity, action0);
            }
        });
    }

    private void setdeveloperPayload(String str) {
        PayloadProxy payloadProxy = this.payloadProxy;
        if (payloadProxy != null) {
            payloadProxy.setExtras(str);
        }
    }

    private void startBillingServiceConnection(final Runnable runnable) {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            billingClient.startConnection(new BillingClientStateListener() { // from class: com.sandboxol.googlepay.billing.GooglePlayPayService.2
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                    GooglePlayPayService.this.isServiceConnected = false;
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    com.apkfuns.logutils.c.a(TagConstant.Billing).d("Setup finished. Response code: " + billingResult.getResponseCode());
                    if (billingResult.getResponseCode() == 0) {
                        GooglePlayPayService.this.isServiceConnected = true;
                        GooglePlayPayService googlePlayPayService = GooglePlayPayService.this;
                        googlePlayPayService.hook(googlePlayPayService.billingClient);
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        } else {
                            GooglePlayPayService.this.queryPurchases();
                        }
                    }
                }
            });
        }
    }

    public /* synthetic */ void a(String str, Activity activity, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        querySkuDetailsAsync(activity, arrayList, str2, str3, new Action0() { // from class: com.sandboxol.googlepay.billing.k
            @Override // rx.functions.Action0
            public final void call() {
                DialogUtilsWrap.newsInstant().hideLoadingDialog();
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void acknowledgePurchase(final Purchase purchase, final boolean z) {
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f18280a.a(purchase, z);
            }
        });
    }

    public /* synthetic */ void b(final Purchase purchase, final boolean z) {
        if (this.billingClient != null) {
            this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).setDeveloperPayload(purchase.getDeveloperPayload()).build(), new ConsumeResponseListener() { // from class: com.sandboxol.googlepay.billing.l
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public final void onConsumeResponse(BillingResult billingResult, String str) {
                    GooglePlayPayService.a(z, purchase, billingResult, str);
                }
            });
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void buySubs(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        PayApi.buySubs(context, buyParam, starCodeUser, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void buyVip(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        PayApi.buyVip(context, buyParam, starCodeUser, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void buyVipExtend(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener) {
        PayApi.buyVipExtend(context, buyParam, starCodeUser, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void consumeAsync(final Purchase purchase, final boolean z) {
        ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.ON_PAY_CONSUME, "appversion:" + BaseApplication.getApp().getMetaDataAppVersion() + ",consume billDetail:" + purchase.getDeveloperPayload());
        executeServiceRequest(new Runnable() { // from class: com.sandboxol.googlepay.billing.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f18294a.b(purchase, z);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void firstTopUp(Context context, OnResponseListener<FirstTopUp> onResponseListener) {
        PayApi.firstTopUp(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void getPaySignature(Context context, OnResponseListener<PaySignatureInfo> onResponseListener) {
        PayApi.getPaySignature(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void initClient(final Context context) {
        this.billingClient = BillingClient.newBuilder(context).setListener(new PurchasesUpdatedListener() { // from class: com.sandboxol.googlepay.billing.g
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                this.f18288a.a(context, billingResult, list);
            }
        }).enablePendingPurchases().build();
        startBillingServiceConnection(null);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void isShowThirdPart(Context context, OnResponseListener<Boolean> onResponseListener) {
        PayApi.isShowThirdPart(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void productsList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        PayApi.productsList(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void productsListAndAds(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        PayApi.productsListAndAds(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void productsListAndAdsAndVipList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener) {
        PayApi.productsListAndAdsAndVipList(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void recharge(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<RechargeEntity> onResponseListener) {
        PayApi.recharge(context, buyParam, starCodeUser, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void rechargeGift(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener) {
        PayApi.rechargeGift(context, buyParam, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void rechargeHistory(Context context, int i, int i2, OnResponseListener<PageData<PayRecordInfo>> onResponseListener) {
        PayApi.rechargeHistory(context, i, i2, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void showThirdPartPayList(Context context, String str, OnResponseListener<ThirdPayResponse> onResponseListener) {
        PayApi.showThirdPartPayList(context, str, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void startPay(final Activity activity, final String str, String str2, String str3, final String str4) {
        if (!ChannelManager.isHasGoogleService(activity)) {
            AppToastUtils.showShortNegativeTipToast(activity, R.string.googleplay_download_google_play_tip);
            return;
        }
        if (str4 == null || "".equals(str4)) {
            Messenger.getDefault().send(new PayOrder(2, true, "userid is null", null), MessageToken.TOKEN_RECHARGE_PAY);
            ReportDataAdapter.onEvent(activity, EventConstant.ON_PAY_USER_NULL, AccountCenter.newInstance().userId.get() + "");
            return;
        }
        DialogUtilsWrap.newsInstant().showLoadingDialog(activity);
        if (TextUtils.isEmpty(str2)) {
            str2 = BillingClient.SkuType.INAPP;
        }
        final String str5 = str2;
        queryPurchasesFromGoodId(str, new Runnable() { // from class: com.sandboxol.googlepay.billing.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f18283a.a(str, activity, str5, str4);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void updateMoney(Context context, OnResponseListener<RechargeEntity> onResponseListener) {
        PayApi.updateMoney(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void updateUserMoney(final Context context, final boolean z, final User user) {
        PayApi.updateMoney(context, new OnResponseListener<RechargeEntity>() { // from class: com.sandboxol.googlepay.billing.GooglePlayPayService.1
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(RechargeEntity rechargeEntity) {
                AccountCenter.newInstance().gDiamonds.set(Long.valueOf(rechargeEntity.getgDiamonds()));
                AccountCenter.newInstance().diamonds.set(Long.valueOf(rechargeEntity.getDiamonds()));
                AccountCenter.newInstance().golds.set(Long.valueOf(rechargeEntity.getGolds()));
                AccountCenter.newInstance().gDiamondsProfit.set(Long.valueOf(rechargeEntity.getgDiamondsProfit()));
                AccountCenter.newInstance().money.set(Double.valueOf(rechargeEntity.getMoney()));
                AccountCenter.putAccountInfo();
                if (AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0) {
                    return;
                }
                if (!z) {
                    LoginManager.paramCheck(context, "2", new OnResponseListener<Long>() { // from class: com.sandboxol.googlepay.billing.GooglePlayPayService.1.1
                        @Override // com.sandboxol.common.base.web.OnResponseListener
                        public void onError(int i, String str) {
                        }

                        @Override // com.sandboxol.common.base.web.OnResponseListener
                        public void onServerError(int i) {
                        }

                        @Override // com.sandboxol.common.base.web.OnResponseListener
                        public void onSuccess(Long l) {
                            if (l.longValue() > 100) {
                                IntentUtils.startPasswordSettingDialog(context, false);
                            }
                        }
                    });
                    return;
                }
                User user2 = user;
                if (user2 == null || user2.getGolds() > rechargeEntity.getGolds() || user.getDiamonds() > rechargeEntity.getDiamonds() || user.getGDiamonds() > rechargeEntity.getgDiamonds()) {
                    IntentUtils.startPasswordSettingDialog(context, false);
                }
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void vipProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener) {
        PayApi.vipProductsList(context, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.IGooglePlayPayService
    public void vipSubsProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener) {
        PayApi.vipSubsProductsList(context, onResponseListener);
    }

    static /* synthetic */ void a(boolean z, Purchase purchase, BillingResult billingResult, String str) {
        com.apkfuns.logutils.c.a(TagConstant.Billing).d("consumeAsync result :" + billingResult.toString() + ",code:" + billingResult.getResponseCode());
        if (billingResult.getResponseCode() == 0) {
            Messenger.getDefault().send(new PayOrder(5, z, "Consumption successful.", purchase), MessageToken.TOKEN_RECHARGE_PAY);
            return;
        }
        Messenger.getDefault().send(new PayOrder(6, z, "Error while consuming: " + billingResult.getDebugMessage(), purchase), MessageToken.TOKEN_RECHARGE_PAY);
    }

    public /* synthetic */ void b() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            Purchase.PurchasesResult purchasesResultQueryPurchases = billingClient.queryPurchases(BillingClient.SkuType.INAPP);
            Purchase.PurchasesResult purchasesResultQueryPurchases2 = this.billingClient.queryPurchases(BillingClient.SkuType.SUBS);
            ArrayList<Purchase> arrayList = new ArrayList();
            arrayList.addAll((purchasesResultQueryPurchases == null || purchasesResultQueryPurchases.getPurchasesList() == null) ? new ArrayList<>() : purchasesResultQueryPurchases.getPurchasesList());
            arrayList.addAll((purchasesResultQueryPurchases2 == null || purchasesResultQueryPurchases2.getPurchasesList() == null) ? new ArrayList<>() : purchasesResultQueryPurchases2.getPurchasesList());
            if (arrayList.size() > 0) {
                for (Purchase purchase : arrayList) {
                    com.apkfuns.logutils.c.a(TagConstant.Billing).d("Purchase: " + purchase.toString());
                    if (purchase.getPurchaseState() == 1) {
                        Messenger.getDefault().send(new PayOrder(1, false, "pay success", purchase), PayToken.TOKEN_GOOGLE_PAY);
                    }
                }
            }
        }
    }

    public /* synthetic */ void a(final Purchase purchase, final boolean z) {
        if (this.billingClient != null) {
            if (purchase.isAcknowledged()) {
                Messenger.getDefault().send(new PayOrder(5, z, "Consumption successful.", purchase), MessageToken.TOKEN_RECHARGE_PAY);
            } else {
                this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).setDeveloperPayload(purchase.getDeveloperPayload()).build(), new AcknowledgePurchaseResponseListener() { // from class: com.sandboxol.googlepay.billing.b
                    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                        GooglePlayPayService.a(z, purchase, billingResult);
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(boolean z, Purchase purchase, BillingResult billingResult) {
        com.apkfuns.logutils.c.a(TagConstant.Billing).d("acknowledgePurchase result :" + billingResult.toString() + ",code:" + billingResult.getResponseCode());
        if (billingResult.getResponseCode() == 0) {
            Messenger.getDefault().send(new PayOrder(5, z, "Consumption successful.", purchase), MessageToken.TOKEN_RECHARGE_PAY);
            return;
        }
        Messenger.getDefault().send(new PayOrder(6, z, "Error while consuming: " + billingResult.getDebugMessage(), purchase), MessageToken.TOKEN_RECHARGE_PAY);
    }

    public /* synthetic */ void a(Context context, BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                handlePurchase(purchase);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.ON_PAY_RESULT, "appversion:" + BaseApplication.getApp().getMetaDataAppVersion() + ",billDetail:" + purchase.getDeveloperPayload());
            }
            return;
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Purchase purchase2 = (Purchase) it2.next();
                if (billingResult.getResponseCode() == 1) {
                    Messenger.getDefault().send(new PayOrder(3, true, "Error purchasing: " + billingResult.getDebugMessage(), purchase2), MessageToken.TOKEN_RECHARGE_PAY);
                } else if (billingResult.getDebugMessage() != null && billingResult.getDebugMessage().contains("Error checking for billing v3 support.")) {
                    Messenger.getDefault().send(new PayOrder(8, true, "Error purchasing: " + billingResult.getDebugMessage(), purchase2), MessageToken.TOKEN_RECHARGE_PAY);
                } else {
                    Messenger.getDefault().send(new PayOrder(2, true, "Error purchasing: " + billingResult.getDebugMessage(), purchase2), MessageToken.TOKEN_RECHARGE_PAY);
                }
            }
            return;
        }
        Messenger.getDefault().send(new PayOrder(2, true, "Error purchasing: " + billingResult.getDebugMessage(), null), MessageToken.TOKEN_RECHARGE_PAY);
        if (billingResult == null || billingResult.getResponseCode() != 7) {
            return;
        }
        VipManager.reportAlreadyOwnedVipSub(context);
    }

    public /* synthetic */ void a(List list, Activity activity) {
        if (this.billingClient != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (this.billingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setSkuDetails((SkuDetails) it.next()).build()).getResponseCode() != 0) {
                    ToastUtils.showLongToast(activity, R.string.googleplay_launch_billing_flow_failed);
                }
            }
        }
    }

    public /* synthetic */ void a(String str, List list, String str2, final Activity activity, final Action0 action0) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        setdeveloperPayload(str);
        SkuDetailsParams.Builder builderNewBuilder = SkuDetailsParams.newBuilder();
        builderNewBuilder.setSkusList(list).setType(str2);
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            billingClient.querySkuDetailsAsync(builderNewBuilder.build(), new SkuDetailsResponseListener() { // from class: com.sandboxol.googlepay.billing.a
                @Override // com.android.billingclient.api.SkuDetailsResponseListener
                public final void onSkuDetailsResponse(BillingResult billingResult, List list2) {
                    this.f18265a.a(jCurrentTimeMillis, activity, action0, billingResult, list2);
                }
            });
        } else {
            action0.call();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(long r7, android.app.Activity r9, rx.functions.Action0 r10, com.android.billingclient.api.BillingResult r11, java.util.List r12) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.googlepay.billing.GooglePlayPayService.a(long, android.app.Activity, rx.functions.Action0, com.android.billingclient.api.BillingResult, java.util.List):void");
    }

    public /* synthetic */ void a(String str, Runnable runnable) {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            Purchase.PurchasesResult purchasesResultQueryPurchases = billingClient.queryPurchases(BillingClient.SkuType.INAPP);
            Purchase.PurchasesResult purchasesResultQueryPurchases2 = this.billingClient.queryPurchases(BillingClient.SkuType.SUBS);
            ArrayList<Purchase> arrayList = new ArrayList((purchasesResultQueryPurchases == null || purchasesResultQueryPurchases.getPurchasesList() == null) ? new ArrayList<>() : purchasesResultQueryPurchases.getPurchasesList());
            ArrayList<Purchase> arrayList2 = new ArrayList((purchasesResultQueryPurchases2 == null || purchasesResultQueryPurchases2.getPurchasesList() == null) ? new ArrayList<>() : purchasesResultQueryPurchases2.getPurchasesList());
            if (arrayList.size() > 0) {
                for (Purchase purchase : arrayList) {
                    if (purchase.getPurchaseState() == 1 && str.endsWith(purchase.getSku())) {
                        DialogUtilsWrap.newsInstant().hideLoadingDialog();
                        Messenger.getDefault().send(new PayOrder(1, true, "pay success", purchase), MessageToken.TOKEN_RECHARGE_PAY);
                        return;
                    }
                }
            }
            if (arrayList2.size() > 0) {
                for (Purchase purchase2 : arrayList2) {
                    if (purchase2.getPurchaseState() == 1 && str.endsWith(purchase2.getSku())) {
                        if (!purchase2.isAcknowledged()) {
                            DialogUtilsWrap.newsInstant().hideLoadingDialog();
                            Messenger.getDefault().send(new PayOrder(1, true, "pay success", purchase2), MessageToken.TOKEN_RECHARGE_PAY);
                            return;
                        } else {
                            DialogUtilsWrap.newsInstant().hideLoadingDialog();
                            AppToastUtils.showShortNegativeTipToast(BaseApplication.getContext(), R.string.googleplay_has_already_subscribed_product);
                            return;
                        }
                    }
                }
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
