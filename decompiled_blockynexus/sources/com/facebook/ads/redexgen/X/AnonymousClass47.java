package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.47, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass47 extends C1605Fk implements InterfaceC1604Fj {
    public static byte[] A01;
    public boolean A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{70, 113, 106, 96, 104, 97, 36, 106, 107, 112, 36, 118, 97, 101, 96, 125};
    }

    public final synchronized void A07() {
        this.A00 = true;
    }

    public final synchronized boolean A08(AtomicReference<JSONObject> atomicReference, AtomicReference<JSONObject> atomicReference2) {
        if (A7w()) {
            if (!this.A00) {
                atomicReference2.set(A6P());
                return false;
            }
            atomicReference.set(A64());
            atomicReference2.set(A6P());
            this.A00 = false;
            return true;
        }
        throw new IllegalStateException(A00(0, 16, 62));
    }
}
