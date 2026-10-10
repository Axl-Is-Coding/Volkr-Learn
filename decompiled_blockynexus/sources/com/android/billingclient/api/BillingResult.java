package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final class BillingResult {
    private String mDebugMessage;
    private int mResponseCode;

    public static class Builder {
        private String mDebugMessage;
        private int mResponseCode;

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.mResponseCode = this.mResponseCode;
            billingResult.mDebugMessage = this.mDebugMessage;
            return billingResult;
        }

        public Builder setDebugMessage(String str) {
            this.mDebugMessage = str;
            return this;
        }

        public Builder setResponseCode(int i) {
            this.mResponseCode = i;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDebugMessage() {
        return this.mDebugMessage;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
