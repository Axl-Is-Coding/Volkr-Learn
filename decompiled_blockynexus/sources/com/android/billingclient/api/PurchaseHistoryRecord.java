package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.util.BillingHelper;
import io.rong.imlib.common.RongLibConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PurchaseHistoryRecord {
    private final String mOriginalJson;
    private final JSONObject mParsedJson;
    private final String mSignature;

    public PurchaseHistoryRecord(String str, String str2) throws JSONException {
        this.mOriginalJson = str;
        this.mSignature = str2;
        this.mParsedJson = new JSONObject(this.mOriginalJson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.mOriginalJson, purchaseHistoryRecord.getOriginalJson()) && TextUtils.equals(this.mSignature, purchaseHistoryRecord.getSignature());
    }

    public String getDeveloperPayload() {
        return this.mParsedJson.optString(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD);
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
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

    public String toString() {
        return "PurchaseHistoryRecord. Json: " + this.mOriginalJson;
    }
}
