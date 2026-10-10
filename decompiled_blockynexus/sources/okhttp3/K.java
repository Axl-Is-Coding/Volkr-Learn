package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: Route.java */
/* JADX INFO: loaded from: classes5.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C2936a f23052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f23053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f23054c;

    public K(C2936a c2936a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c2936a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f23052a = c2936a;
        this.f23053b = proxy;
        this.f23054c = inetSocketAddress;
    }

    public C2936a a() {
        return this.f23052a;
    }

    public Proxy b() {
        return this.f23053b;
    }

    public boolean c() {
        return this.f23052a.i != null && this.f23053b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f23054c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof K) {
            K k = (K) obj;
            if (k.f23052a.equals(this.f23052a) && k.f23053b.equals(this.f23053b) && k.f23054c.equals(this.f23054c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f23052a.hashCode()) * 31) + this.f23053b.hashCode()) * 31) + this.f23054c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f23054c + "}";
    }
}
