package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.An, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1497An extends AbstractC2069Xs<C1490Ag, AR, G7> implements InterfaceC2129a4 {
    public static byte[] A01;
    public final String A00;

    static {
        A0K();
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0K() {
        A01 = new byte[]{Utf8.REPLACEMENT_BYTE, 88, 79, 98, 90, 79, 77, 94, 79, 78, 10, 78, 79, 77, 89, 78, 79, 10, 79, 92, 92, 89, 92};
    }

    public abstract G6 A0d(byte[] bArr, int i, boolean z) throws G7;

    public AbstractC1497An(String str) {
        super(new C1490Ag[2], new AR[2]);
        this.A00 = str;
        A0a(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC2069Xs
    /* JADX INFO: renamed from: A0F, reason: merged with bridge method [inline-methods] */
    public final G7 A0Y(C1490Ag c1490Ag, AR ar, boolean z) {
        try {
            ByteBuffer byteBuffer = c1490Ag.A01;
            ar.A09(((C2067Xq) c1490Ag).A00, A0d(byteBuffer.array(), byteBuffer.limit(), z), c1490Ag.A00);
            ar.A01(Integer.MIN_VALUE);
            return null;
        } catch (G7 e2) {
            return e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC2069Xs
    /* JADX INFO: renamed from: A0G, reason: merged with bridge method [inline-methods] */
    public final G7 A0Z(Throwable th) {
        return new G7(A0J(0, 23, 109), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC2069Xs
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C1490Ag A0V() {
        return new C1490Ag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC2069Xs
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final AR A0X() {
        return new AR(this) { // from class: com.facebook.ads.redexgen.X.3D
            public final AbstractC1497An A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.X.AR
            public final void A08() {
                this.A00.A0c(this);
            }
        };
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC2069Xs
    /* JADX INFO: renamed from: A0e, reason: merged with bridge method [inline-methods] */
    public final void A0c(AR ar) {
        super.A0c(ar);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2129a4
    public final void ADN(long j) {
    }
}
