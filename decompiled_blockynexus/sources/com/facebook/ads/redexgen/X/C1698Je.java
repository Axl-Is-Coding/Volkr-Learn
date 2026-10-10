package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Je, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1698Je extends Exception {
    public final AdErrorType A00;
    public final String A01;

    public C1698Je(AdErrorType adErrorType, String str) {
        this(adErrorType, str, null);
    }

    public C1698Je(AdErrorType adErrorType, String str, Throwable th) {
        super(str, th);
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public final AdErrorType A00() {
        return this.A00;
    }

    public final String A01() {
        return this.A01;
    }
}
