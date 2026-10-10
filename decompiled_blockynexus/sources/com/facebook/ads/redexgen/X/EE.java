package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EE {
    public static byte[] A02;
    public static String[] A03;
    public final C1664Ht A00;
    public final File A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {7, 60, 33, 39, 34, 34, 61, 32, 38, 55, 54, 114, 51, 49, 38, 59, 61, 60, 114, 52, 59, 62, 55, 114, 36, 55, 32, 33, 59, 61, 60, 104, 114};
        String[] strArr = A03;
        if (strArr[4].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "YMHIgoMQBupXygUq8X9ePyvP7esYeyMN";
        strArr2[7] = "V8iBact6T2ktuOUxJFnyGTvZTdpLIqou";
        A02 = bArr;
    }

    public static void A02() {
        A03 = new String[]{"PP5DU49yUGbqRFal6tR", "e4", "s2qoG2vtUJJ5SExk2bCAu68n8G6q3yTT", "MeMR7L2JKLgMWPmkziO", "xwzH1HasKQzILES6mTt", "p6SQsg09HqPHNf1RzYLQg9nXgmiNy", "F9DvreFu89Z0Ps32kzSJSyvHkTkLNKEg", "2vix8bbWvPZkkjsVpCvfcLhNaaIRZhff"};
    }

    public EE(File file) {
        this.A01 = file;
        this.A00 = new C1664Ht(file);
    }

    public final void A03(DownloadAction... downloadActionArr) throws IOException {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(this.A00.A05());
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(downloadActionArr.length);
            for (DownloadAction downloadAction : downloadActionArr) {
                DownloadAction.A03(downloadAction, dataOutputStream);
            }
            this.A00.A07(dataOutputStream);
            IW.A0Y(null);
        } catch (Throwable th) {
            IW.A0Y(dataOutputStream);
            throw th;
        }
    }

    public final DownloadAction[] A04(DownloadAction.Deserializer... deserializerArr) throws IOException {
        if (!this.A01.exists()) {
            return new DownloadAction[0];
        }
        try {
            InputStream inputStreamA04 = this.A00.A04();
            DataInputStream dataInputStream = new DataInputStream(inputStreamA04);
            int i = dataInputStream.readInt();
            if (i <= 0) {
                int i2 = dataInputStream.readInt();
                DownloadAction[] downloadActionArr = new DownloadAction[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    downloadActionArr[i3] = DownloadAction.A00(deserializerArr, dataInputStream);
                }
                IW.A0Y(inputStreamA04);
                return downloadActionArr;
            }
            throw new IOException(A00(0, 33, 48) + i);
        } catch (Throwable th) {
            IW.A0Y(null);
            throw th;
        }
    }
}
