package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.To, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1961To implements C6Y {
    public final /* synthetic */ U1 A00;

    public C1961To(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, CertificateException {
        Signature[] signatureArr = this.A00.A00.getPackageManager().getPackageInfo(this.A00.A00.getPackageName(), 64).signatures;
        HashMap map = new HashMap();
        for (int i = 0; i < signatureArr.length; i++) {
            map.put(Integer.valueOf(i), new U0(signatureArr[i]));
        }
        return this.A00.A05((HashMap<Integer, U0>) map);
    }
}
