package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZR extends DownloadAction {
    public static byte[] A01;
    public static String[] A02;
    public static final DownloadAction.Deserializer A03;

    @Nullable
    public final String A00;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A01 = new byte[]{3, 1, 28, 20, 1, 22, 0, 0, 26, 5, 22};
    }

    public static void A07() {
        A02 = new String[]{"zIk8lFjKPo5VqXBeAWetc3TePOqewtK4", "Krv9CUV84BxP4tXlBDsVq5ZfguHkkPOw", "qZweMgdQpTvQjM16IN332AToX", "5wIly2IGyFbenCO8uByiE", "WVTy90LHtMArJ1Mx15Navn95RKOGxxfC", "YMittl3f14YbQo67yPLY6h3Kxcx5v1", "fVvKsKq8KPyH9", "YcDFZjjwvX0vuueDfq7B81mncQMZao1W"};
    }

    static {
        A07();
        A06();
        A03 = new ZQ(A05(0, 11, 68), 0);
    }

    public ZR(Uri uri, boolean z, @Nullable byte[] bArr, @Nullable String str) {
        super(A05(0, 11, 68), 0, uri, z, bArr);
        this.A00 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final ZT A08(C1576Ed c1576Ed) {
        return new ZT(this.A01, this.A00, c1576Ed);
    }

    private String A04() {
        String str = this.A00;
        return str != null ? str : C1652Hh.A01(this.A01);
    }

    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction
    public final void A09(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.A01.toString());
        dataOutputStream.writeBoolean(this.A03);
        dataOutputStream.writeInt(this.A04.length);
        dataOutputStream.write(this.A04);
        boolean z = this.A00 != null;
        dataOutputStream.writeBoolean(z);
        if (z) {
            dataOutputStream.writeUTF(this.A00);
        }
    }

    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction
    public final boolean A0A(DownloadAction downloadAction) {
        return (downloadAction instanceof ZR) && A04().equals(((ZR) downloadAction).A04());
    }

    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        boolean zEquals = super.equals(obj);
        String[] strArr = A02;
        if (strArr[0].charAt(3) == strArr[1].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "S1dYnav0YyHlHBWJfncCN";
        strArr2[3] = "S1dYnav0YyHlHBWJfncCN";
        if (!zEquals) {
            return false;
        }
        return IW.A0h(this.A00, ((ZR) obj).A00);
    }

    @Override // com.facebook.ads.internal.exoplayer2.offline.DownloadAction
    public final int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.A00;
        int result = str != null ? str.hashCode() : 0;
        int i = iHashCode + result;
        String[] strArr = A02;
        if (strArr[6].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "5idVnwwxM2TXqOP7ezpSPuxFrlenP4PE";
        strArr2[4] = "5idVnwwxM2TXqOP7ezpSPuxFrlenP4PE";
        return i;
    }
}
