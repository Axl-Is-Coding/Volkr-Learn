package com.google.android.gms.ads.rewarded;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class ServerSideVerificationOptions {
    private final String zzdvz;
    private final String zzdwa;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static final class Builder {
        private String zzdvz = "";
        private String zzdwa = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.zzdwa = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.zzdvz = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdvz = builder.zzdvz;
        this.zzdwa = builder.zzdwa;
    }

    public String getCustomData() {
        return this.zzdwa;
    }

    public String getUserId() {
        return this.zzdvz;
    }
}
