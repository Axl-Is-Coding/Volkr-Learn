package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class Y1 implements Bv {
    public final MediaCrypto A00;
    public final boolean A01;

    public final MediaCrypto A00() {
        return this.A00;
    }

    public final boolean A01(String str) {
        return !this.A01 && this.A00.requiresSecureDecoderComponent(str);
    }
}
