package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.v;

/* JADX INFO: renamed from: okhttp3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Address.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2936a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final v f23055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Dns f23056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f23057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Authenticator f23058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<Protocol> f23059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<m> f23060f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final C2943h k;

    public C2936a(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C2943h c2943h, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<m> list2, ProxySelector proxySelector) {
        v.a aVar = new v.a();
        aVar.e(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i);
        this.f23055a = aVar.a();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.f23056b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f23057c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f23058d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f23059e = okhttp3.a.e.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f23060f = okhttp3.a.e.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = c2943h;
    }

    public C2943h a() {
        return this.k;
    }

    public List<m> b() {
        return this.f23060f;
    }

    public Dns c() {
        return this.f23056b;
    }

    public HostnameVerifier d() {
        return this.j;
    }

    public List<Protocol> e() {
        return this.f23059e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2936a) {
            C2936a c2936a = (C2936a) obj;
            if (this.f23055a.equals(c2936a.f23055a) && a(c2936a)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.h;
    }

    public Authenticator g() {
        return this.f23058d;
    }

    public ProxySelector h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f23055a.hashCode()) * 31) + this.f23056b.hashCode()) * 31) + this.f23058d.hashCode()) * 31) + this.f23059e.hashCode()) * 31) + this.f23060f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        C2943h c2943h = this.k;
        return iHashCode4 + (c2943h != null ? c2943h.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f23057c;
    }

    public SSLSocketFactory j() {
        return this.i;
    }

    public v k() {
        return this.f23055a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f23055a.g());
        sb.append(":");
        sb.append(this.f23055a.k());
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

    boolean a(C2936a c2936a) {
        return this.f23056b.equals(c2936a.f23056b) && this.f23058d.equals(c2936a.f23058d) && this.f23059e.equals(c2936a.f23059e) && this.f23060f.equals(c2936a.f23060f) && this.g.equals(c2936a.g) && okhttp3.a.e.a(this.h, c2936a.h) && okhttp3.a.e.a(this.i, c2936a.i) && okhttp3.a.e.a(this.j, c2936a.j) && okhttp3.a.e.a(this.k, c2936a.k) && k().k() == c2936a.k().k();
    }
}
