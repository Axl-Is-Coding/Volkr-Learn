package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public interface IRechargeService extends IBaseService {
    void buySubs(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener);

    void buyVip(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener);

    void buyVipExtend(Context context, BuyParam buyParam, OnResponseListener<BuyVipEntity> onResponseListener);

    void recharge(Context context, BuyParam buyParam, OnResponseListener<RechargeEntity> onResponseListener);
}
