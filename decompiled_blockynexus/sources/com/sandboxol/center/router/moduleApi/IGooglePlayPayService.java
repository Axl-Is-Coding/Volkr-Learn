package com.sandboxol.center.router.moduleApi;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.moduleInfo.pay.ThirdPayResponse;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.User;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IGooglePlayPayService extends IBaseService {
    void acknowledgePurchase(Purchase purchase, boolean z);

    void buySubs(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener);

    void buyVip(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener);

    void buyVipExtend(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<BuyVipEntity> onResponseListener);

    void consumeAsync(Purchase purchase, boolean z);

    void firstTopUp(Context context, OnResponseListener<FirstTopUp> onResponseListener);

    void getPaySignature(Context context, OnResponseListener<PaySignatureInfo> onResponseListener);

    void initClient(Context context);

    void isShowThirdPart(Context context, OnResponseListener<Boolean> onResponseListener);

    void productsList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener);

    void productsListAndAds(Context context, OnResponseListener<List<ProductEntity>> onResponseListener);

    void productsListAndAdsAndVipList(Context context, OnResponseListener<List<ProductEntity>> onResponseListener);

    void recharge(Context context, BuyParam buyParam, StarCodeUser starCodeUser, OnResponseListener<RechargeEntity> onResponseListener);

    void rechargeGift(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener);

    void rechargeHistory(Context context, int i, int i2, OnResponseListener<PageData<PayRecordInfo>> onResponseListener);

    void showThirdPartPayList(Context context, String str, OnResponseListener<ThirdPayResponse> onResponseListener);

    void startPay(Activity activity, String str, String str2, String str3, String str4);

    void updateMoney(Context context, OnResponseListener<RechargeEntity> onResponseListener);

    void updateUserMoney(Context context, boolean z, User user);

    void vipProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener);

    void vipSubsProductsList(Context context, OnResponseListener<VipProductResponse> onResponseListener);
}
