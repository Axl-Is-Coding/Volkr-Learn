package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: RouteSelector.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.sdk.a.b.a f4949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f4950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.a.b.e f4951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f4952d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4954f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Proxy> f4953e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ac> h = new ArrayList();

    /* JADX INFO: compiled from: RouteSelector.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<ac> f4955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4956b = 0;

        a(List<ac> list) {
            this.f4955a = list;
        }

        public boolean a() {
            return this.f4956b < this.f4955a.size();
        }

        public ac b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<ac> list = this.f4955a;
            int i = this.f4956b;
            this.f4956b = i + 1;
            return list.get(i);
        }

        public List<ac> c() {
            return new ArrayList(this.f4955a);
        }
    }

    public f(com.bytedance.sdk.a.b.a aVar, d dVar, com.bytedance.sdk.a.b.e eVar, p pVar) {
        this.f4949a = aVar;
        this.f4950b = dVar;
        this.f4951c = eVar;
        this.f4952d = pVar;
        a(aVar.a(), aVar.h());
    }

    private boolean c() {
        return this.f4954f < this.f4953e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f4953e;
            int i = this.f4954f;
            this.f4954f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f4949a.a().f() + "; exhausted proxy configurations: " + this.f4953e);
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy proxyD = d();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ac acVar = new ac(this.f4949a, proxyD, this.g.get(i));
                if (this.f4950b.c(acVar)) {
                    this.h.add(acVar);
                } else {
                    arrayList.add(acVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    public void a(ac acVar, IOException iOException) {
        if (acVar.b().type() != Proxy.Type.DIRECT && this.f4949a.g() != null) {
            this.f4949a.g().connectFailed(this.f4949a.a().a(), acVar.b().address(), iOException);
        }
        this.f4950b.a(acVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> listA;
        if (proxy != null) {
            this.f4953e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f4949a.g().select(sVar.a());
            if (listSelect != null && !listSelect.isEmpty()) {
                listA = com.bytedance.sdk.a.b.a.c.a(listSelect);
            } else {
                listA = com.bytedance.sdk.a.b.a.c.a(Proxy.NO_PROXY);
            }
            this.f4953e = listA;
        }
        this.f4954f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String strF;
        int iG;
        this.g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strF = a(inetSocketAddress);
                iG = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
        } else {
            strF = this.f4949a.a().f();
            iG = this.f4949a.a().g();
        }
        if (iG >= 1 && iG <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.g.add(InetSocketAddress.createUnresolved(strF, iG));
                return;
            }
            this.f4952d.a(this.f4951c, strF);
            List<InetAddress> listA = this.f4949a.b().a(strF);
            if (!listA.isEmpty()) {
                this.f4952d.a(this.f4951c, strF, listA);
                int size = listA.size();
                for (int i = 0; i < size; i++) {
                    this.g.add(new InetSocketAddress(listA.get(i), iG));
                }
                return;
            }
            throw new UnknownHostException(this.f4949a.b() + " returned no addresses for " + strF);
        }
        throw new SocketException("No route to " + strF + ":" + iG + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
