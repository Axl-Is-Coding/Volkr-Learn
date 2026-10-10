package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Address.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s f4898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o f4899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f4900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f4901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<w> f4902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<k> f4903f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.f4898a = new s.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i).c();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f4899b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f4900c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f4901d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f4902e = com.bytedance.sdk.a.b.a.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f4903f = com.bytedance.sdk.a.b.a.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public s a() {
        return this.f4898a;
    }

    public o b() {
        return this.f4899b;
    }

    public SocketFactory c() {
        return this.f4900c;
    }

    public b d() {
        return this.f4901d;
    }

    public List<w> e() {
        return this.f4902e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f4898a.equals(aVar.f4898a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public List<k> f() {
        return this.f4903f;
    }

    public ProxySelector g() {
        return this.g;
    }

    public Proxy h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f4898a.hashCode()) * 31) + this.f4899b.hashCode()) * 31) + this.f4901d.hashCode()) * 31) + this.f4902e.hashCode()) * 31) + this.f4903f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return iHashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public HostnameVerifier j() {
        return this.j;
    }

    public g k() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f4898a.f());
        sb.append(":");
        sb.append(this.f4898a.g());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }

    boolean a(a aVar) {
        return this.f4899b.equals(aVar.f4899b) && this.f4901d.equals(aVar.f4901d) && this.f4902e.equals(aVar.f4902e) && this.f4903f.equals(aVar.f4903f) && this.g.equals(aVar.g) && com.bytedance.sdk.a.b.a.c.a(this.h, aVar.h) && com.bytedance.sdk.a.b.a.c.a(this.i, aVar.i) && com.bytedance.sdk.a.b.a.c.a(this.j, aVar.j) && com.bytedance.sdk.a.b.a.c.a(this.k, aVar.k) && a().g() == aVar.a().g();
    }
}
