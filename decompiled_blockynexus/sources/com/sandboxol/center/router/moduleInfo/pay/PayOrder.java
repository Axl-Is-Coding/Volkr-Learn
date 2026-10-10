package com.sandboxol.center.router.moduleInfo.pay;

import com.android.billingclient.api.Purchase;

/* JADX INFO: loaded from: classes3.dex */
public class PayOrder {
    public static final int PAY_ATTR_ERROR = 4;
    public static final int PAY_CANCEL = 3;
    public static final int PAY_CONSUME_FAILED = 6;
    public static final int PAY_CONSUME_SUCCESS = 5;
    public static final int PAY_FAILED = 2;
    public static final int PAY_MONEY_SUCCESS = 9;
    public static final int PAY_NO_INSTALL = 7;
    public static final int PAY_SUCCESS = 1;
    public static final int PAY_UNLOGIN_GOOGLE = 8;
    public int code;
    public boolean isShowDialog;
    public String message;
    public Purchase purchase;

    public PayOrder(int i, boolean z, String str, Purchase purchase) {
        this.code = i;
        this.isShowDialog = z;
        this.message = str;
        this.purchase = purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
