package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: Handshake.java */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ad f5283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f5284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f5285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f5286d;

    private q(ad adVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f5283a = adVar;
        this.f5284b = hVar;
        this.f5285c = list;
        this.f5286d = list2;
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h hVarA = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ad adVarA = ad.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listA = peerCertificates != null ? com.bytedance.sdk.a.b.a.c.a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(adVarA, hVarA, listA, localCertificates != null ? com.bytedance.sdk.a.b.a.c.a(localCertificates) : Collections.emptyList());
    }

    public List<Certificate> b() {
        return this.f5285c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5283a.equals(qVar.f5283a) && this.f5284b.equals(qVar.f5284b) && this.f5285c.equals(qVar.f5285c) && this.f5286d.equals(qVar.f5286d);
    }

    public int hashCode() {
        return ((((((527 + this.f5283a.hashCode()) * 31) + this.f5284b.hashCode()) * 31) + this.f5285c.hashCode()) * 31) + this.f5286d.hashCode();
    }

    public h a() {
        return this.f5284b;
    }
}
