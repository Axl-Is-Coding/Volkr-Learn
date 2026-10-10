package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Py, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1869Py {
    boolean A9r(C1867Pw c1867Pw);

    HttpURLConnection ABl(String str) throws IOException;

    InputStream ABm(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream ABn(HttpURLConnection httpURLConnection) throws IOException;

    void AC3(HttpURLConnection httpURLConnection, EnumC1865Pu enumC1865Pu, String str) throws IOException;

    byte[] ACN(InputStream inputStream) throws IOException;

    void AEG(OutputStream outputStream, byte[] bArr) throws IOException;
}
