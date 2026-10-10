package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected m.a<T> f5462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Handler f5463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o.a f5464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5467f;
    private final int g;
    private final Object h;
    private Integer i;
    private l j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private com.bytedance.sdk.adnet.face.d o;
    private a.C0073a p;
    private Object q;
    private long r;
    private long s;
    private boolean t;
    private String u;
    private Map<String, Object> v;
    private a w;

    interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    @Deprecated
    public Request(String str, m.a aVar) {
        this(-1, str, aVar);
    }

    private static int b(String str) {
        Uri uri;
        String host;
        try {
            if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
                return 0;
            }
            return host.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }

    protected abstract m<T> a(i iVar);

    protected VAdError a(VAdError vAdError) {
        return vAdError;
    }

    protected void a(long j, long j2) {
    }

    protected abstract void a(m<T> mVar);

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.v == null) {
                this.v = new HashMap();
            }
            this.v.put(str, obj);
        }
        return this;
    }

    public void addMarker(String str) {
        if (o.a.f5546a) {
            this.f5464c.a(str, Thread.currentThread().getId());
        }
    }

    public void build(l lVar) {
        if (lVar != null) {
            lVar.a(this);
        }
    }

    protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
        return null;
    }

    public void cancel() {
        synchronized (this.h) {
            this.l = true;
            this.f5462a = null;
        }
    }

    protected String d() {
        return "UTF-8";
    }

    public void deliverError(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.h) {
            aVar = this.f5462a;
        }
        if (aVar != null) {
            aVar.b(mVar);
        }
    }

    void e() {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public m.a getBaseListener() {
        m.a<T> aVar;
        synchronized (this.h) {
            aVar = this.f5462a;
        }
        return aVar;
    }

    public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> mapC = c();
        if (mapC == null || mapC.size() <= 0) {
            return null;
        }
        return a(mapC, d());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public a.C0073a getCacheEntry() {
        return this.p;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return Integer.toString(method) + '-' + url;
    }

    public Map<String, Object> getExtra() {
        return this.v;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        return Collections.emptyMap();
    }

    public String getIpAddrStr() {
        return this.u;
    }

    public int getMethod() {
        return this.f5465d;
    }

    public long getNetDuration() {
        return this.s;
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> mapA = a();
        if (mapA == null || mapA.size() <= 0) {
            return null;
        }
        return a(mapA, b());
    }

    public b getPriority() {
        return b.NORMAL;
    }

    public final l getRequestQueue() {
        return this.j;
    }

    public com.bytedance.sdk.adnet.face.d getRetryPolicy() {
        return this.o;
    }

    public final int getSequence() {
        Integer num = this.i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public long getStartTime() {
        return this.r;
    }

    public Object getTag() {
        return this.q;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().a();
    }

    public int getTrafficStatsTag() {
        return this.g;
    }

    public String getUrl() {
        return this.f5466e;
    }

    public String getUserAgent() {
        return this.f5467f;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.h) {
            z = this.m;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.h) {
            z = this.l;
        }
        return z;
    }

    public boolean isResponseOnMain() {
        return this.t;
    }

    public void markDelivered() {
        synchronized (this.h) {
            this.m = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(a.C0073a c0073a) {
        this.p = c0073a;
        return this;
    }

    public void setIpAddrStr(String str) {
        this.u = str;
    }

    public void setNetDuration(long j) {
        this.s = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(l lVar) {
        this.j = lVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        this.t = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(com.bytedance.sdk.adnet.face.d dVar) {
        this.o = dVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i) {
        this.i = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.k = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.n = z;
        return this;
    }

    public void setStartTime() {
        this.r = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.q = obj;
        return this;
    }

    public void setUrl(String str) {
        this.f5466e = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        this.f5467f = str;
        return this;
    }

    public final boolean shouldCache() {
        return this.k;
    }

    public final boolean shouldRetryServerErrors() {
        return this.n;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.i);
        return sb.toString();
    }

    public Request(int i, String str, m.a aVar) {
        this.f5464c = o.a.f5546a ? new o.a() : null;
        this.f5467f = "VADNetAgent/0";
        this.h = new Object();
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0L;
        this.s = 0L;
        this.t = true;
        this.f5463b = new Handler(Looper.getMainLooper());
        this.f5465d = i;
        this.f5466e = str;
        this.f5462a = aVar;
        setRetryPolicy(new e());
        this.g = b(str);
    }

    void a(final String str) {
        l lVar = this.j;
        if (lVar != null) {
            lVar.c(this);
        }
        if (o.a.f5546a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f5463b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.core.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.f5464c.a(str, id);
                        Request.this.f5464c.a(Request.this.toString());
                    }
                });
            } else {
                this.f5464c.a(str, id);
                this.f5464c.a(toString());
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Request<T> request) {
        b priority = getPriority();
        b priority2 = request.getPriority();
        return priority == priority2 ? this.i.intValue() - request.i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Deprecated
    protected String b() {
        return d();
    }

    void b(m<?> mVar) {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this, mVar);
        }
    }

    void a(int i) {
        l lVar = this.j;
        if (lVar != null) {
            lVar.a(this, i);
        }
    }

    @Deprecated
    protected Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
        return c();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    void a(a aVar) {
        synchronized (this.h) {
            this.w = aVar;
        }
    }
}
