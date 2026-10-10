package okhttp3.internal.connection;

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
import okhttp3.C2936a;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.K;
import okhttp3.v;

/* JADX INFO: compiled from: RouteSelector.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2936a f23218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f23219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Call f23220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventListener f23221d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23223f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Proxy> f23222e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<K> h = new ArrayList();

    /* JADX INFO: compiled from: RouteSelector.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<K> f23224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f23225b = 0;

        a(List<K> list) {
            this.f23224a = list;
        }

        public List<K> a() {
            return new ArrayList(this.f23224a);
        }

        public boolean b() {
            return this.f23225b < this.f23224a.size();
        }

        public K c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<K> list = this.f23224a;
            int i = this.f23225b;
            this.f23225b = i + 1;
            return list.get(i);
        }
    }

    public f(C2936a c2936a, e eVar, Call call, EventListener eventListener) {
        this.f23218a = c2936a;
        this.f23219b = eVar;
        this.f23220c = call;
        this.f23221d = eventListener;
        a(c2936a.k(), c2936a.f());
    }

    private boolean c() {
        return this.f23223f < this.f23222e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f23222e;
            int i = this.f23223f;
            this.f23223f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f23218a.k().g() + "; exhausted proxy configurations: " + this.f23222e);
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
                K k = new K(this.f23218a, proxyD, this.g.get(i));
                if (this.f23219b.c(k)) {
                    this.h.add(k);
                } else {
                    arrayList.add(k);
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

    public void a(K k, IOException iOException) {
        if (k.b().type() != Proxy.Type.DIRECT && this.f23218a.h() != null) {
            this.f23218a.h().connectFailed(this.f23218a.k().p(), k.b().address(), iOException);
        }
        this.f23219b.b(k);
    }

    private void a(v vVar, Proxy proxy) {
        List<Proxy> listA;
        if (proxy != null) {
            this.f23222e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f23218a.h().select(vVar.p());
            if (listSelect != null && !listSelect.isEmpty()) {
                listA = okhttp3.a.e.a(listSelect);
            } else {
                listA = okhttp3.a.e.a(Proxy.NO_PROXY);
            }
            this.f23222e = listA;
        }
        this.f23223f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String strG;
        int iK;
        this.g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strG = a(inetSocketAddress);
                iK = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
        } else {
            strG = this.f23218a.k().g();
            iK = this.f23218a.k().k();
        }
        if (iK >= 1 && iK <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.g.add(InetSocketAddress.createUnresolved(strG, iK));
                return;
            }
            this.f23221d.a(this.f23220c, strG);
            List<InetAddress> listLookup = this.f23218a.c().lookup(strG);
            if (!listLookup.isEmpty()) {
                this.f23221d.a(this.f23220c, strG, listLookup);
                int size = listLookup.size();
                for (int i = 0; i < size; i++) {
                    this.g.add(new InetSocketAddress(listLookup.get(i), iK));
                }
                return;
            }
            throw new UnknownHostException(this.f23218a.c() + " returned no addresses for " + strG);
        }
        throw new SocketException("No route to " + strG + ":" + iK + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
