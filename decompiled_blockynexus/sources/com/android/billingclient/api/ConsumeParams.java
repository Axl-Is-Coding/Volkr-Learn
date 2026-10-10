package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class ConsumeParams {
    private String developerPayload;
    private String purchaseToken;

    public static final class Builder {
        private String developerPayload;
        private String purchaseToken;

        public ConsumeParams build() {
            ConsumeParams consumeParams = new ConsumeParams();
            consumeParams.purchaseToken = this.purchaseToken;
            consumeParams.developerPayload = this.developerPayload;
            return consumeParams;
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

    private ConsumeParams() {
    }
}
