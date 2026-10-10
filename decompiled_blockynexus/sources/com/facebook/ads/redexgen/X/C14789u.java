package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14789u extends Exception {
    public final int A00;
    public final int A01;

    public C14789u(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.A01 = i;
        this.A00 = i2;
    }

    public static C14789u A00(IOException iOException) {
        return new C14789u(0, null, iOException, -1);
    }

    public static C14789u A01(Exception exc, int i) {
        return new C14789u(1, null, exc, i);
    }

    public static C14789u A02(RuntimeException runtimeException) {
        return new C14789u(2, null, runtimeException, -1);
    }
}
