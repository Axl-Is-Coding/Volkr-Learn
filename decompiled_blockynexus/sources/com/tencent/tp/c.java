package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f19691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private X509Certificate f19693c;

    public c(Context context, String str) {
        this.f19691a = context;
        this.f19692b = str;
    }

    private void d() throws Exception {
        if (this.f19693c != null) {
            return;
        }
        e();
    }

    private void e() throws Exception {
        Signature[] signatureArr;
        if (this.f19692b == null) {
            this.f19692b = v.e();
            if (this.f19692b == null) {
                return;
            }
        }
        PackageInfo packageInfo = this.f19691a.getPackageManager().getPackageInfo(this.f19692b, 64);
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
            return;
        }
        this.f19693c = (X509Certificate) CertificateFactory.getInstance(q.a("S.509")).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
    }

    public String a() {
        BigInteger p;
        String string = null;
        try {
            d();
            if (this.f19693c == null) {
                return null;
            }
            PublicKey publicKey = this.f19693c.getPublicKey();
            String algorithm = publicKey.getAlgorithm();
            if (algorithm != null && algorithm.indexOf(q.a("MNV")) != -1) {
                p = ((RSAPublicKey) publicKey).getModulus();
            } else {
                if (algorithm == null || algorithm.indexOf(q.a("YNV")) == -1) {
                    return null;
                }
                p = ((DSAPublicKey) publicKey).getParams().getP();
            }
            string = p.toString();
            return string;
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b() {
        try {
            d();
            if (this.f19693c != null) {
                return this.f19693c.getIssuerDN().toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String c() {
        try {
            d();
            if (this.f19693c != null) {
                return this.f19693c.getSubjectDN().toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
