package com.android.billingclient.api;

import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class PriceChangeFlowParams {
    private SkuDetails skuDetails;

    public static class Builder {
        private SkuDetails skuDetails;

        public PriceChangeFlowParams build() {
            PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
            SkuDetails skuDetails = this.skuDetails;
            if (skuDetails == null) {
                throw new RuntimeException("SkuDetails must be set");
            }
            priceChangeFlowParams.skuDetails = skuDetails;
            return priceChangeFlowParams;
        }

        public Builder setSkuDetails(SkuDetails skuDetails) {
            this.skuDetails = skuDetails;
            return this;
        }

        private Builder setSkuDetails(String str) {
            try {
                this.skuDetails = new SkuDetails(str);
                return this;
            } catch (JSONException unused) {
                throw new RuntimeException("Incorrect skuDetails JSON object!");
            }
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public SkuDetails getSkuDetails() {
        return this.skuDetails;
    }
}
