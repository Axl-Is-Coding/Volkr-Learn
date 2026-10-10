package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ft, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1614Ft implements InterfaceC1853Pi {
    public int A00;

    @Nullable
    public String A01;

    @Nullable
    public Map<String, List<String>> A02;

    @Nullable
    public byte[] A03;

    public C1614Ft(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.A00 = httpURLConnection.getResponseCode();
            this.A01 = httpURLConnection.getURL().toString();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.A02 = httpURLConnection.getHeaderFields();
        this.A03 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1853Pi
    @Nullable
    public final byte[] A5a() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1853Pi
    @Nullable
    public final String A5b() {
        byte[] bArr = this.A03;
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1853Pi
    @Nullable
    public final Map<String, List<String>> A6S() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1853Pi
    public final int A7B() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1853Pi
    @Nullable
    public final String getUrl() {
        return this.A01;
    }
}
