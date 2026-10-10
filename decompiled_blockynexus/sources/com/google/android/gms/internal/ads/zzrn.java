package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrn {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbtw;

    @VisibleForTesting
    public zzrn(float f2, float f3, float f4, float f5, int i) {
        this.left = f2;
        this.top = f3;
        this.right = f2 + f4;
        this.bottom = f3 + f5;
        this.zzbtw = i;
    }

    final float zzmn() {
        return this.left;
    }

    final float zzmo() {
        return this.top;
    }

    final float zzmp() {
        return this.right;
    }

    final float zzmq() {
        return this.bottom;
    }

    final int zzmr() {
        return this.zzbtw;
    }
}
