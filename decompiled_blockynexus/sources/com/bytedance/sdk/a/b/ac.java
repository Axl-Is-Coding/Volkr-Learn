package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: Route.java */
/* JADX INFO: loaded from: classes.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f5212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f5213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f5214c;

    public ac(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f5212a = aVar;
        this.f5213b = proxy;
        this.f5214c = inetSocketAddress;
    }

    public a a() {
        return this.f5212a;
    }

    public Proxy b() {
        return this.f5213b;
    }

    public InetSocketAddress c() {
        return this.f5214c;
    }

    public boolean d() {
        return this.f5212a.i != null && this.f5213b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            if (acVar.f5212a.equals(this.f5212a) && acVar.f5213b.equals(this.f5213b) && acVar.f5214c.equals(this.f5214c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f5212a.hashCode()) * 31) + this.f5213b.hashCode()) * 31) + this.f5214c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f5214c + "}";
    }
}
