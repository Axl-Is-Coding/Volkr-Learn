package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.78, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass78 {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04;
    public static volatile AnonymousClass78 A05;
    public final C2027Wc A00;
    public final Map<String, AnonymousClass74> A01 = Collections.synchronizedMap(new HashMap());

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A02 = new byte[]{97, 102, 34, 124, 98, 107, 68, 103, 98, 38, 105, 115, 114, 118, 115, 114, 38, 98, 99, 117, 114, 111, 104, 103, 114, 111, 105, 104, 38, 46, 96, 111, 106, 99, 59, 27, 57, 59, 48, 61, 120, 61, 42, 42, 55, 42, 118, 120, 26, 49, 44, 53, 57, 40, 120, 49, 43, 120, 54, 45, 52, 52, 118, 98, 69, 77, 72, 65, 64, 4, 80, 75, 4, 71, 75, 84, 93, 4, 72, 75, 71, 69, 72, 4, 77, 73, 69, 67, 65, 4, 77, 74, 80, 75, 4, 71, 69, 71, 76, 65, 4, 12, 81, 86, 72, 25, 42, 17, 30, 29, 19, 26, 95, 11, ci.n, 95, 8, ci.k, 22, 11, 26, 95, 29, 22, 11, 18, 30, ci.m, 95, 11, ci.n, 95, 25, 22, 19, 26, 95, 87, 10, ci.k, 19, 66, 53, ci.l, 1, 2, 12, 5, 64, 20, ci.m, 64, 23, 18, 9, 20, 5, 64, 2, 9, 20, ci.k, 1, ci.n, 64, 20, ci.m, 64, ci.m, 21, 20, ci.n, 21, 20, 64, 19, 20, 18, 5, 1, ci.k, 100, 118, 118, 96, 113, Utf8.REPLACEMENT_BYTE, 42, 42, 42, 121, 118, 115, 122, 37, 48, 48, 48, 52, 56, 62, 60, 78, 77, 67, 70, 7, 28, 25, 28, 29, 5, 28};
    }

    public static void A09() {
        A03 = new String[]{"xEW9LSpkxtcMkiVkCjWXuTu5CJHPJiyq", "tTP", "A", "dhAFlm3SiPB0s9864OvgcmZEVzRtwwmX", "mnE9bSEHBlleLkXo6La2W5bpkmZqSUyN", "0jwmHWkFqK", "xBcWrb6s57BN1yke0uYkFqIHC7aAgPEb", "dL0KwaEpZdlIbw3ka3MpOkzONR5qkJY2"};
    }

    static {
        A09();
        A08();
        A04 = AnonymousClass78.class.getSimpleName();
    }

    public AnonymousClass78(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    private int A00(String str, @Nullable Bitmap bitmap) {
        String strA07 = A07(0, 2, 17);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File file = new File(this.A00.getCacheDir(), str.hashCode() + A07(2, 4, 85));
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            int size = byteArrayOutputStream.size();
            int size2 = C1693Iy.A0D(this.A00);
            if (size >= size2) {
                return 0;
            }
            fileOutputStream = new FileOutputStream(file);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            return size;
        } catch (FileNotFoundException e2) {
            Log.e(A04, A07(6, 29, 95) + file.getPath() + strA07, e2);
            A0B(e2);
            return 0;
        } catch (IOException e3) {
            A0B(e3);
            Log.e(A04, A07(106, 36, 38) + str + strA07, e3);
            return 0;
        } catch (OutOfMemoryError e4) {
            A0B(e4);
            Log.e(A04, A07(142, 39, 57), e4);
            return 0;
        } finally {
            A0A(byteArrayOutputStream);
            A0A(fileOutputStream);
        }
    }

    @Nullable
    private final Bitmap A01(AnonymousClass87 anonymousClass87, AnonymousClass74 anonymousClass74, int i, int i2, String str) {
        if (C7A.A06(anonymousClass87) && A07(202, 4, 123).equals(str)) {
            Map<String, AnonymousClass74> map = this.A01;
            if (A03[4].charAt(4) != 'b') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "FHlvPh";
            strArr[1] = "FHlvPh";
            map.put(anonymousClass74.A07, anonymousClass74);
        }
        String str2 = anonymousClass74.A07;
        AnonymousClass79 anonymousClass79 = new AnonymousClass79(anonymousClass74.A05, anonymousClass74.A06, A07(197, 5, 0), str, str2);
        File file = new File(this.A00.getCacheDir(), str2.hashCode() + A07(2, 4, 85));
        if (!file.exists()) {
            C7A.A04(anonymousClass87, anonymousClass79, false);
            if (str2.startsWith(A07(190, 7, 70))) {
                return A04(str2, i2, i);
            }
            return A02(anonymousClass87, anonymousClass74, str);
        }
        C7A.A04(anonymousClass87, anonymousClass79, true);
        try {
            if (A0C(i2, i)) {
                return C7B.A02(file.getCanonicalPath(), i2, i, this.A00);
            }
            return BitmapFactory.decodeFile(file.getCanonicalPath());
        } catch (IOException e2) {
            A0B(e2);
            return null;
        }
    }

    @Nullable
    private Bitmap A02(AnonymousClass87 anonymousClass87, AnonymousClass74 anonymousClass74, String str) {
        Bitmap bitmapA03;
        String failureReason = anonymousClass74.A07;
        int i = anonymousClass74.A03;
        int i2 = anonymousClass74.A04;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOException e2 = null;
        if (failureReason.startsWith(A07(181, 9, 92))) {
            try {
                try {
                    try {
                        InputStream inputStreamOpen = this.A00.getAssets().open(failureReason.substring(9));
                        if (A0C(i, i2)) {
                            bitmapA03 = C7B.A01(inputStreamOpen, i, i2);
                        } else {
                            bitmapA03 = BitmapFactory.decodeStream(inputStreamOpen);
                        }
                        if (inputStreamOpen != null) {
                            A0A(inputStreamOpen);
                        }
                    } catch (OutOfMemoryError e3) {
                        A0B(e3);
                        if (0 != 0) {
                            A0A(null);
                        }
                        return null;
                    }
                } catch (IOException e4) {
                    A0B(e4);
                    if (0 != 0) {
                        A0A(null);
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    A0A(null);
                }
                throw th;
            }
        } else if (A0C(i, i2)) {
            try {
                bitmapA03 = A05(failureReason, i, i2);
            } catch (IOException e5) {
                e2 = e5;
                A0B(e2);
                bitmapA03 = A03(failureReason);
            }
            int height = A03[2].length();
            if (height == 5) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
            strArr[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
        } else {
            bitmapA03 = A03(failureReason);
        }
        String string = e2 != null ? e2.toString() : null;
        if (bitmapA03 == null) {
            C7A.A03(anonymousClass87, anonymousClass74, str, C7A.A03, string, null, null);
        } else {
            int iA00 = A00(failureReason, bitmapA03);
            long requestTime = System.currentTimeMillis();
            long loadTime = requestTime - jCurrentTimeMillis;
            if (iA00 > 0) {
                C7A.A03(anonymousClass87, anonymousClass74, str, C7A.A02, string, Integer.valueOf(iA00), Long.valueOf(loadTime));
            } else {
                int i3 = C7A.A01;
                String[] strArr2 = A03;
                String str2 = strArr2[0];
                String str3 = strArr2[6];
                int storedSize = str2.charAt(0);
                if (storedSize != str3.charAt(0)) {
                    C7A.A03(anonymousClass87, anonymousClass74, str, i3, string, null, null);
                } else {
                    String[] strArr3 = A03;
                    strArr3[1] = "v696HPT8k3klpjO3N";
                    strArr3[1] = "v696HPT8k3klpjO3N";
                    C7A.A03(anonymousClass87, anonymousClass74, str, i3, string, null, null);
                }
            }
        }
        return bitmapA03;
    }

    @Nullable
    private Bitmap A03(String str) {
        byte[] bArrA5a;
        InterfaceC1853Pi interfaceC1853PiABv = Q1.A00(this.A00).ABv(str, new C1868Px());
        if (interfaceC1853PiABv != null && (bArrA5a = interfaceC1853PiABv.A5a()) != null) {
            return BitmapFactory.decodeByteArray(bArrA5a, 0, bArrA5a.length);
        }
        return null;
    }

    @Nullable
    private Bitmap A04(String str, int i, int i2) {
        Bitmap bitmapA02;
        try {
            boolean zA0C = A0C(i, i2);
            String strA07 = A07(190, 7, 70);
            if (!zA0C) {
                bitmapA02 = BitmapFactory.decodeStream(new FileInputStream(str.substring(strA07.length())), null, null);
            } else {
                bitmapA02 = C7B.A02(str.substring(strA07.length()), i, i2, this.A00);
            }
            A00(str, bitmapA02);
            return bitmapA02;
        } catch (IOException e2) {
            Log.e(A04, A07(63, 43, 125) + str + A07(0, 2, 17), e2);
            return null;
        }
    }

    @Nullable
    private Bitmap A05(String str, int i, int i2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap bitmapA01 = C7B.A01(inputStream, i, i2);
        A0A(inputStream);
        return bitmapA01;
    }

    public static AnonymousClass78 A06(C2027Wc c2027Wc) {
        if (A05 == null) {
            synchronized (AnonymousClass78.class) {
                if (A05 == null) {
                    A05 = new AnonymousClass78(c2027Wc);
                }
            }
        }
        return A05;
    }

    public static void A0A(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(@Nullable Throwable th) {
        String strA07 = A07(197, 5, 0);
        if (th != null) {
            this.A00.A04().A8H(strA07, C8Y.A1M, new C8Z(th));
        } else {
            this.A00.A04().A8H(strA07, C8Y.A1M, new C8Z(A07(35, 28, 1)));
        }
    }

    private boolean A0C(int i, int i2) {
        return i > 0 && i2 > 0 && C1693Iy.A0t(this.A00);
    }

    @Nullable
    public final Bitmap A0D(AnonymousClass74 anonymousClass74) {
        return A01(this.A00, anonymousClass74, anonymousClass74.A04, anonymousClass74.A03, anonymousClass74.A01);
    }

    @Nullable
    public final Bitmap A0E(AnonymousClass87 anonymousClass87, String str, int i, int i2, String str2) {
        AnonymousClass74 anonymousClass74 = this.A01.get(str);
        return (!C7A.A06(anonymousClass87) || anonymousClass74 == null) ? A01(anonymousClass87, new AnonymousClass74(str, i, i2, A07(206, 7, 43), A07(206, 7, 43)), i2, i, str2) : A01(anonymousClass87, anonymousClass74, i2, i, str2);
    }

    public final String A0F(String str) {
        File file = new File(this.A00.getCacheDir(), str.hashCode() + A07(2, 4, 85));
        return file.exists() ? file.getPath() : str;
    }
}
