package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class AcknowledgePurchaseParams {
    private String developerPayload;
    private String purchaseToken;

    public static final class Builder {
        private String developerPayload;
        private String purchaseToken;

        public AcknowledgePurchaseParams build() {
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams();
            acknowledgePurchaseParams.developerPayload = this.developerPayload;
            acknowledgePurchaseParams.purchaseToken = this.purchaseToken;
            return acknowledgePurchaseParams;
        }

        public Builder setDeveloperPayload(String str) {
            this.developerPayload = str;
            return this;
        }

        public Builder setPurchaseToken(String str) {
            this.purchaseToken = str;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDeveloperPayload() {
        return this.developerPayload;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    private AcknowledgePurchaseParams() {
    }
}
