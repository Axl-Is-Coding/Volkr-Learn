package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.util.BillingHelper;
import io.rong.imlib.common.RongLibConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {
    private final String mOriginalJson;
    private final JSONObject mParsedJson;
    private final String mSignature;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PurchaseState {
        public static final int PENDING = 2;
        public static final int PURCHASED = 1;
        public static final int UNSPECIFIED_STATE = 0;
    }

    public static class PurchasesResult {
        private BillingResult mBillingResult;
        private List<Purchase> mPurchaseList;

        public PurchasesResult(BillingResult billingResult, List<Purchase> list) {
            this.mPurchaseList = list;
            this.mBillingResult = billingResult;
        }

        public BillingResult getBillingResult() {
            return this.mBillingResult;
        }

        public List<Purchase> getPurchasesList() {
            return this.mPurchaseList;
        }

        public int getResponseCode() {
            return getBillingResult().getResponseCode();
        }
    }

    public Purchase(String str, String str2) throws JSONException {
        this.mOriginalJson = str;
        this.mSignature = str2;
        this.mParsedJson = new JSONObject(this.mOriginalJson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.mOriginalJson, purchase.getOriginalJson()) && TextUtils.equals(this.mSignature, purchase.getSignature());
    }

    public String getDeveloperPayload() {
        return this.mParsedJson.optString(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD);
    }

    public String getOrderId() {
        return this.mParsedJson.optString("orderId");
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
    }

    public String getPackageName() {
        return this.mParsedJson.optString("packageName");
    }

    public int getPurchaseState() {
        return this.mParsedJson.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long getPurchaseTime() {
        return this.mParsedJson.optLong("purchaseTime");
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.mParsedJson;
        return jSONObject.optString(RongLibConst.KEY_TOKEN, jSONObject.optString("purchaseToken"));
    }

    public String getSignature() {
        return this.mSignature;
    }

    public String getSku() {
        return this.mParsedJson.optString("productId");
    }

    public int hashCode() {
        return this.mOriginalJson.hashCode();
    }

    public boolean isAcknowledged() {
        return this.mParsedJson.optBoolean("acknowledged", true);
    }

    public boolean isAutoRenewing() {
        return this.mParsedJson.optBoolean("autoRenewing");
    }

    public String toString() {
        return "Purchase. Json: " + this.mOriginalJson;
    }
}
