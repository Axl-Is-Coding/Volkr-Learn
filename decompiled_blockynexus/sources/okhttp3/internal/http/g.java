package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.H;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: RealInterceptorChain.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Interceptor> f23241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.connection.g f23242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpCodec f23243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.connection.d f23244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C f23246f;
    private final Call g;
    private final EventListener h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<Interceptor> list, okhttp3.internal.connection.g gVar, HttpCodec httpCodec, okhttp3.internal.connection.d dVar, int i, C c2, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f23241a = list;
        this.f23244d = dVar;
        this.f23242b = gVar;
        this.f23243c = httpCodec;
        this.f23245e = i;
        this.f23246f = c2;
        this.g = call;
        this.h = eventListener;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public EventListener a() {
        return this.h;
    }

    public HttpCodec b() {
        return this.f23243c;
    }

    public okhttp3.internal.connection.g c() {
        return this.f23242b;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.g;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.i;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.f23244d;
    }

    @Override // okhttp3.Interceptor.Chain
    public H proceed(C c2) throws IOException {
        return a(c2, this.f23242b, this.f23243c, this.f23244d);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.j;
    }

    @Override // okhttp3.Interceptor.Chain
    public C request() {
        return this.f23246f;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new g(this.f23241a, this.f23242b, this.f23243c, this.f23244d, this.f23245e, this.f23246f, this.g, this.h, okhttp3.a.e.a("timeout", i, timeUnit), this.j, this.k);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new g(this.f23241a, this.f23242b, this.f23243c, this.f23244d, this.f23245e, this.f23246f, this.g, this.h, this.i, okhttp3.a.e.a("timeout", i, timeUnit), this.k);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new g(this.f23241a, this.f23242b, this.f23243c, this.f23244d, this.f23245e, this.f23246f, this.g, this.h, this.i, this.j, okhttp3.a.e.a("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.k;
    }

    public H a(C c2, okhttp3.internal.connection.g gVar, HttpCodec httpCodec, okhttp3.internal.connection.d dVar) throws IOException {
        if (this.f23245e >= this.f23241a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.f23243c != null && !this.f23244d.a(c2.g())) {
            throw new IllegalStateException("network interceptor " + this.f23241a.get(this.f23245e - 1) + " must retain the same host and port");
        }
        if (this.f23243c != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f23241a.get(this.f23245e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f23241a, gVar, httpCodec, dVar, this.f23245e + 1, c2, this.g, this.h, this.i, this.j, this.k);
        Interceptor interceptor = this.f23241a.get(this.f23245e);
        H hIntercept = interceptor.intercept(gVar2);
        if (httpCodec != null && this.f23245e + 1 < this.f23241a.size() && gVar2.l != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (hIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (hIntercept.b() != null) {
            return hIntercept;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }
}
