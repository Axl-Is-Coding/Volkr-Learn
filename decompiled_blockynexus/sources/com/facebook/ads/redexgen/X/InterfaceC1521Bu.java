package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.Bv;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public interface InterfaceC1521Bu<T extends Bv> {
    InterfaceC1520Bt<T> A2Q(Looper looper, DrmInitData drmInitData);

    boolean A3x(DrmInitData drmInitData);

    void ACc(InterfaceC1520Bt<T> interfaceC1520Bt);
}
