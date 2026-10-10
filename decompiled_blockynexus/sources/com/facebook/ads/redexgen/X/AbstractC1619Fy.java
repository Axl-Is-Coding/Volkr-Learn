package com.facebook.ads.redexgen.X;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1619Fy implements InterfaceC1869Py {
    public static byte[] A01;
    public static String[] A02;
    public final InterfaceC1870Pz A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{89, 123, 123, 125, -120, -116, 69, 91, -128, 121, -118, -117, 125, -116, -98, -67, -49, -59, -65, -82, -63, -51, -47, -63, -49, -48, -92, -67, -54, -64, -56, -63, -50, -118, -53, -54, -95, -50, -50, -53, -50, 124, -61, -53, -48, -102, -58, -59, -53, -68, -59, -53, -124, -85, -48, -57, -68, -71, -72, -86, -111, -100};
    }

    public static void A02() {
        A02 = new String[]{"rzjVC70O4bd9DzHjbWZgWXgUSmVLYSU4", "d5zo8W4K", "Hv98ROwnq0amXTKQof8zpMynpU6nXYzw", "m02wtPmJvn7xvEVIhgILVdsvYaekd1y1", "NwXA6aDXoJPzKJxJycW", "lujFiBBwg3lGF", "5iNla1hEs57TMoL8Mlh58N0Q757SBHKY", "iek06qmxI9TIJY"};
    }

    public AbstractC1619Fy() {
        this(new C1612Fr());
    }

    public AbstractC1619Fy(InterfaceC1870Pz interfaceC1870Pz) {
        this.A00 = interfaceC1870Pz;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final boolean A9r(C1867Pw c1867Pw) {
        InterfaceC1853Pi interfaceC1853PiA00 = c1867Pw.A00();
        if (this.A00.A7t()) {
            this.A00.A88(A00(14, 31, 78));
            c1867Pw.printStackTrace();
        }
        if (interfaceC1853PiA00 != null && interfaceC1853PiA00.A7B() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final HttpURLConnection ABl(String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final InputStream ABm(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final OutputStream ABn(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final void AC3(HttpURLConnection httpURLConnection, EnumC1865Pu enumC1865Pu, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC1865Pu.A03());
        httpURLConnection.setDoOutput(enumC1865Pu.A05());
        httpURLConnection.setDoInput(enumC1865Pu.A04());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(45, 12, 73), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 10), A00(57, 5, 86));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final byte[] ACN(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            if (A02[4].length() != 19) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "eO7qbggyddGiOQuVn8N8jDULGwym82oB";
            strArr[6] = "iN6CFd4LV6hdOWp44ZZbGtT2nODAuDvC";
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1869Py
    public final void AEG(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
