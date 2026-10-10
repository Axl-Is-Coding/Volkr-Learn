package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_CHILD_DIRECTED = "childDirected";
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    public static final String EXTRA_PARAM_KEY_DEVELOPER_ID = "developerId";
    public static final String EXTRA_PARAM_KEY_OLD_SKUS = "skusToReplace";
    public static final String EXTRA_PARAM_KEY_REPLACE_SKUS_PRORATION_MODE = "prorationMode";
    public static final String EXTRA_PARAM_KEY_RSKU = "rewardToken";
    public static final String EXTRA_PARAM_KEY_VR = "vr";
    public static final String EXTRA_PARAM_UNDER_AGE_OF_CONSENT = "underAgeOfConsent";
    private String mAccountId;
    private String mDeveloperId;
    private String mOldSku;
    private int mReplaceSkusProrationMode = 0;
    private SkuDetails mSkuDetails;
    private boolean mVrPurchaseFlow;

    public static class Builder {
        private String mAccountId;
        private String mDeveloperId;
        private String mOldSku;
        private int mReplaceSkusProrationMode;
        private SkuDetails mSkuDetails;
        private boolean mVrPurchaseFlow;

        @Deprecated
        public Builder addOldSku(String str) {
            this.mOldSku = str;
            return this;
        }

        public BillingFlowParams build() {
            BillingFlowParams billingFlowParams = new BillingFlowParams();
            billingFlowParams.mSkuDetails = this.mSkuDetails;
            billingFlowParams.mOldSku = this.mOldSku;
            billingFlowParams.mAccountId = this.mAccountId;
            billingFlowParams.mVrPurchaseFlow = this.mVrPurchaseFlow;
            billingFlowParams.mReplaceSkusProrationMode = this.mReplaceSkusProrationMode;
            billingFlowParams.mDeveloperId = this.mDeveloperId;
            return billingFlowParams;
        }

        public Builder setAccountId(String str) {
            this.mAccountId = str;
            return this;
        }

        public Builder setDeveloperId(String str) {
            this.mDeveloperId = str;
            return this;
        }

        public Builder setOldSku(String str) {
            this.mOldSku = str;
            return this;
        }

        @Deprecated
        public Builder setOldSkus(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mOldSku = arrayList.get(0);
            }
            return this;
        }

        public Builder setReplaceSkusProrationMode(int i) {
            this.mReplaceSkusProrationMode = i;
            return this;
        }

        public Builder setSkuDetails(SkuDetails skuDetails) {
            this.mSkuDetails = skuDetails;
            return this;
        }

        public Builder setVrPurchaseFlow(boolean z) {
            this.mVrPurchaseFlow = z;
            return this;
        }

        private Builder() {
            this.mReplaceSkusProrationMode = 0;
        }

        private Builder setSkuDetails(String str) {
            try {
                this.mSkuDetails = new SkuDetails(str);
                return this;
            } catch (JSONException unused) {
                throw new RuntimeException("Incorrect skuDetails JSON object!");
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProrationMode {
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public String getDeveloperId() {
        return this.mDeveloperId;
    }

    public String getOldSku() {
        return this.mOldSku;
    }

    @Deprecated
    public ArrayList<String> getOldSkus() {
        return new ArrayList<>(Arrays.asList(this.mOldSku));
    }

    public int getReplaceSkusProrationMode() {
        return this.mReplaceSkusProrationMode;
    }

    public String getSku() {
        SkuDetails skuDetails = this.mSkuDetails;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getSku();
    }

    public SkuDetails getSkuDetails() {
        return this.mSkuDetails;
    }

    public String getSkuType() {
        SkuDetails skuDetails = this.mSkuDetails;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getType();
    }

    public boolean getVrPurchaseFlow() {
        return this.mVrPurchaseFlow;
    }

    boolean hasExtraParams() {
        return (!this.mVrPurchaseFlow && this.mAccountId == null && this.mDeveloperId == null && this.mReplaceSkusProrationMode == 0) ? false : true;
    }
}
