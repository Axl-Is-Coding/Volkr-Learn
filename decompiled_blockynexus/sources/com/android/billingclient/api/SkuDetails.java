package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.util.BillingHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SkuDetails {
    private final String mOriginalJson;
    private final JSONObject mParsedJson;

    public static class SkuDetailsResult {
        private String mDebugMessage;
        private int mResponseCode;
        private List<SkuDetails> mSkuDetailsList;

        public SkuDetailsResult(int i, String str, List<SkuDetails> list) {
            this.mResponseCode = i;
            this.mDebugMessage = str;
            this.mSkuDetailsList = list;
        }

        public String getDebugMessage() {
            return this.mDebugMessage;
        }

        public int getResponseCode() {
            return this.mResponseCode;
        }

        public List<SkuDetails> getSkuDetailsList() {
            return this.mSkuDetailsList;
        }
    }

    public SkuDetails(String str) throws JSONException {
        this.mOriginalJson = str;
        this.mParsedJson = new JSONObject(this.mOriginalJson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SkuDetails.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.mOriginalJson, ((SkuDetails) obj).mOriginalJson);
    }

    public String getDescription() {
        return this.mParsedJson.optString("description");
    }

    public String getFreeTrialPeriod() {
        return this.mParsedJson.optString("freeTrialPeriod");
    }

    public String getIconUrl() {
        return this.mParsedJson.optString("iconUrl");
    }

    public String getIntroductoryPrice() {
        return this.mParsedJson.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.mParsedJson.optLong("introductoryPriceAmountMicros");
    }

    public String getIntroductoryPriceCycles() {
        return this.mParsedJson.optString("introductoryPriceCycles");
    }

    public String getIntroductoryPricePeriod() {
        return this.mParsedJson.optString("introductoryPricePeriod");
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
    }

    public String getOriginalPrice() {
        return this.mParsedJson.has("original_price") ? this.mParsedJson.optString("original_price") : getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        return this.mParsedJson.has("original_price_micros") ? this.mParsedJson.optLong("original_price_micros") : getPriceAmountMicros();
    }

    public String getPrice() {
        return this.mParsedJson.optString("price");
    }

    public long getPriceAmountMicros() {
        return this.mParsedJson.optLong("price_amount_micros");
    }

    public String getPriceCurrencyCode() {
        return this.mParsedJson.optString("price_currency_code");
    }

    public String getSku() {
        return this.mParsedJson.optString("productId");
    }

    String getSkuDetailsToken() {
        return this.mParsedJson.optString(BillingHelper.EXTRA_PARAM_KEY_SKU_DETAILS_TOKEN);
    }

    public String getSubscriptionPeriod() {
        return this.mParsedJson.optString("subscriptionPeriod");
    }

    public String getTitle() {
        return this.mParsedJson.optString("title");
    }

    public String getType() {
        return this.mParsedJson.optString("type");
    }

    public int hashCode() {
        return this.mOriginalJson.hashCode();
    }

    public boolean isRewarded() {
        return this.mParsedJson.has(BillingFlowParams.EXTRA_PARAM_KEY_RSKU);
    }

    String rewardToken() {
        return this.mParsedJson.optString(BillingFlowParams.EXTRA_PARAM_KEY_RSKU);
    }

    public String toString() {
        return "SkuDetails: " + this.mOriginalJson;
    }
}
