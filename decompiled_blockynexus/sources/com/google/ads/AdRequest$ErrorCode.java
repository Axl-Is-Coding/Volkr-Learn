package com.google.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public enum AdRequest$ErrorCode {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");

    private final String description;

    AdRequest$ErrorCode(String str) {
        this.description = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.description;
    }
}
