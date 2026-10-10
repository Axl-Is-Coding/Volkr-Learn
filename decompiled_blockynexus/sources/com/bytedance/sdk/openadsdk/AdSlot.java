package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5577f;
    private boolean g;
    private String h;
    private int i;
    private String j;
    private String k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private String p;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5578a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5581d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f5583f;
        private int g;
        private String h;
        private String i;
        private int j;
        private int k;
        private float l;
        private float m;
        private boolean n;
        private String o;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5579b = 640;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5580c = 320;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5582e = 1;
        private boolean p = true;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f5572a = this.f5578a;
            adSlot.f5577f = this.f5582e;
            adSlot.g = this.f5581d;
            adSlot.f5573b = this.f5579b;
            adSlot.f5574c = this.f5580c;
            adSlot.f5575d = this.l;
            adSlot.f5576e = this.m;
            adSlot.h = this.f5583f;
            adSlot.i = this.g;
            adSlot.j = this.h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.m = this.k;
            adSlot.n = this.p;
            adSlot.o = this.n;
            adSlot.p = this.o;
            return adSlot;
        }

        public Builder isExpressAd(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setAdCount(int i) {
            this.f5582e = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f5578a = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.l = f2;
            this.m = f3;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.f5579b = i;
            this.f5580c = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.p = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.h = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.k = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.j = i;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.g = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f5583f = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f5581d = z;
            return this;
        }

        public Builder setUserID(String str) {
            this.i = str;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.o = str;
            return this;
        }
    }

    public static int getPosition(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
            case 4:
            case 7:
            case 8:
                return 5;
            case 5:
            case 6:
            case 9:
            default:
                return 3;
        }
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 320);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(iOptInt, iOptInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(dOptDouble).floatValue(), Double.valueOf(dOptDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setOrientation(jSONObject.optInt("mOrientation"));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
        } catch (Exception unused) {
        }
        return builder.build();
    }

    public int getAdCount() {
        return this.f5577f;
    }

    public String getBidAdm() {
        return this.p;
    }

    public String getCodeId() {
        return this.f5572a;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f5576e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f5575d;
    }

    public int getImgAcceptedHeight() {
        return this.f5574c;
    }

    public int getImgAcceptedWidth() {
        return this.f5573b;
    }

    public String getMediaExtra() {
        return this.j;
    }

    public int getNativeAdType() {
        return this.m;
    }

    public int getOrientation() {
        return this.l;
    }

    public int getRewardAmount() {
        return this.i;
    }

    public String getRewardName() {
        return this.h;
    }

    public String getUserID() {
        return this.k;
    }

    public boolean isAutoPlay() {
        return this.n;
    }

    public boolean isExpressAd() {
        return this.o;
    }

    public boolean isSupportDeepLink() {
        return this.g;
    }

    public void setAdCount(int i) {
        this.f5577f = i;
    }

    public void setNativeAdType(int i) {
        this.m = i;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f5572a);
            jSONObject.put("mAdCount", this.f5577f);
            jSONObject.put("mIsAutoPlay", this.n);
            jSONObject.put("mImgAcceptedWidth", this.f5573b);
            jSONObject.put("mImgAcceptedHeight", this.f5574c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f5575d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f5576e);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mRewardName", this.h);
            jSONObject.put("mRewardAmount", this.i);
            jSONObject.put("mMediaExtra", this.j);
            jSONObject.put("mUserID", this.k);
            jSONObject.put("mOrientation", this.l);
            jSONObject.put("mNativeAdType", this.m);
            jSONObject.put("mIsExpressAd", this.o);
            jSONObject.put("mBidAdm", this.p);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f5572a + "', mImgAcceptedWidth=" + this.f5573b + ", mImgAcceptedHeight=" + this.f5574c + ", mExpressViewAcceptedWidth=" + this.f5575d + ", mExpressViewAcceptedHeight=" + this.f5576e + ", mAdCount=" + this.f5577f + ", mSupportDeepLink=" + this.g + ", mRewardName='" + this.h + "', mRewardAmount=" + this.i + ", mMediaExtra='" + this.j + "', mUserID='" + this.k + "', mOrientation=" + this.l + ", mNativeAdType=" + this.m + ", mIsAutoPlay=" + this.n + '}';
    }

    private AdSlot() {
        this.l = 2;
        this.n = true;
        this.o = false;
    }
}
