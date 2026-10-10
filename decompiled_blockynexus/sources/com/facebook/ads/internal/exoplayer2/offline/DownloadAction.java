package com.facebook.ads.internal.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C1576Ed;
import com.facebook.ads.redexgen.X.EH;
import com.facebook.ads.redexgen.X.InterfaceC1575Ec;
import com.umeng.analytics.pro.ci;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class DownloadAction {
    public static byte[] A05;
    public final int A00;
    public final Uri A01;
    public final String A02;
    public final boolean A03;
    public final byte[] A04;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-55, -67, ci.l, 47, -32, 36, 37, 51, 37, 50, 41, 33, 44, 41, 58, 37, 50, -32, 38, 47, 53, 46, 36, -32, 38, 47, 50, -6};
    }

    public abstract InterfaceC1575Ec A08(C1576Ed c1576Ed);

    public abstract void A09(DataOutputStream dataOutputStream) throws IOException;

    /* JADX WARN: Classes with same name are omitted, all sources:
      assets.dex
      assets/audience_network.dex
     */
    public static abstract class Deserializer {
        public final int A00;
        public final String A01;

        public abstract DownloadAction A01(int i, DataInputStream dataInputStream) throws IOException;

        public Deserializer(String str, int i) {
            this.A01 = str;
            this.A00 = i;
        }
    }

    public DownloadAction(String str, int i, Uri uri, boolean z, @Nullable byte[] bArr) {
        this.A02 = str;
        this.A00 = i;
        this.A01 = uri;
        this.A03 = z;
        this.A04 = bArr == null ? new byte[0] : bArr;
    }

    public static DownloadAction A00(Deserializer[] deserializerArr, InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String utf = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        for (Deserializer deserializer : deserializerArr) {
            if (utf.equals(deserializer.A01) && deserializer.A00 >= i) {
                return deserializer.A01(i, dataInputStream);
            }
        }
        throw new EH(A01(2, 26, 85) + utf + A01(0, 2, 50) + i);
    }

    public static void A03(DownloadAction downloadAction, OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(downloadAction.A02);
        dataOutputStream.writeInt(downloadAction.A00);
        downloadAction.A09(dataOutputStream);
        dataOutputStream.flush();
    }

    public boolean A0A(DownloadAction downloadAction) {
        return this.A01.equals(downloadAction.A01);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DownloadAction that = (DownloadAction) obj;
        return this.A02.equals(that.A02) && this.A00 == that.A00 && this.A01.equals(that.A01) && this.A03 == that.A03 && Arrays.equals(this.A04, that.A04);
    }

    public int hashCode() {
        return (((this.A01.hashCode() * 31) + (this.A03 ? 1 : 0)) * 31) + Arrays.hashCode(this.A04);
    }
}
