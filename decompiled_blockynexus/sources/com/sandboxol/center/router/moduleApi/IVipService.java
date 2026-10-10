package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;

/* JADX INFO: loaded from: classes3.dex */
public interface IVipService extends IBaseService {
    void buyVip(Context context, int i, String str);

    void enterVipFragment(Context context);

    VipProductEntity getProductEntityByVipType(boolean z, int i);

    boolean getSubscribeStatus(int i);

    int getVipSubsDiamond(int i);

    String getVipSubsFree(int i);

    void reportAlreadyOwnedVipSub(Context context);

    void reportHomeVipClick(Context context);

    void reportRechargePageVipClick(Context context, String str);

    void reportVipSubWin(Context context);

    void reportVipSubscribeFail(Context context, String str);

    void reportVipSubscribeSuccess(Context context, String str);

    void resetVipInfo();

    void showSubscribeDialog(Context context);
}
