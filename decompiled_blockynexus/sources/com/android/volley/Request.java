package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.a;
import com.android.volley.m;
import com.android.volley.p;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p.a f3970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f3974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m.a f3975f;
    private Integer g;
    private l h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private o m;
    private a.C0049a n;
    private a o;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    public Request(int i, String str, m.a aVar) {
        this.f3970a = p.a.f4031a ? new p.a() : null;
        this.f3974e = new Object();
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.f3971b = i;
        this.f3972c = str;
        this.f3975f = aVar;
        a((o) new d());
        this.f3973d = c(str);
    }

    private static int c(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    protected abstract m<T> a(j jVar);

    protected abstract void a(T t);

    protected VolleyError b(VolleyError volleyError) {
        return volleyError;
    }

    void b(String str) {
        l lVar = this.h;
        if (lVar != null) {
            lVar.b(this);
        }
        if (p.a.f4031a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new k(this, str, id));
            } else {
                this.f3970a.a(str, id);
                this.f3970a.a(toString());
            }
        }
    }

    public String d() {
        String strT = t();
        int iF = f();
        if (iF == 0 || iF == -1) {
            return strT;
        }
        return Integer.toString(iF) + '-' + strT;
    }

    public Map<String, String> e() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public int f() {
        return this.f3971b;
    }

    protected Map<String, String> g() throws AuthFailureError {
        return null;
    }

    protected String h() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] i() throws AuthFailureError {
        Map<String, String> mapN = n();
        if (mapN == null || mapN.size() <= 0) {
            return null;
        }
        return a(mapN, o());
    }

    @Deprecated
    public String m() {
        return b();
    }

    @Deprecated
    protected Map<String, String> n() throws AuthFailureError {
        return g();
    }

    @Deprecated
    protected String o() {
        return h();
    }

    public Priority p() {
        return Priority.NORMAL;
    }

    public o q() {
        return this.m;
    }

    public final int r() {
        return q().b();
    }

    public int s() {
        return this.f3973d;
    }

    public String t() {
        return this.f3972c;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(s());
        StringBuilder sb = new StringBuilder();
        sb.append(v() ? "[X] " : "[ ] ");
        sb.append(t());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(p());
        sb.append(" ");
        sb.append(this.g);
        return sb.toString();
    }

    public boolean u() {
        boolean z;
        synchronized (this.f3974e) {
            z = this.k;
        }
        return z;
    }

    public boolean v() {
        boolean z;
        synchronized (this.f3974e) {
            z = this.j;
        }
        return z;
    }

    public void w() {
        synchronized (this.f3974e) {
            this.k = true;
        }
    }

    void x() {
        a aVar;
        synchronized (this.f3974e) {
            aVar = this.o;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final boolean y() {
        return this.i;
    }

    public final boolean z() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(o oVar) {
        this.m = oVar;
        return this;
    }

    public void a(String str) {
        if (p.a.f4031a) {
            this.f3970a.a(str, Thread.currentThread().getId());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(l lVar) {
        this.h = lVar;
        return this;
    }

    public a.C0049a c() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> a(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(a.C0049a c0049a) {
        this.n = c0049a;
        return this;
    }

    public byte[] a() throws AuthFailureError {
        Map<String, String> mapG = g();
        if (mapG == null || mapG.size() <= 0) {
            return null;
        }
        return a(mapG, h());
    }

    public String b() {
        return "application/x-www-form-urlencoded; charset=" + h();
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

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Request<T> request) {
        Priority priorityP = p();
        Priority priorityP2 = request.p();
        return priorityP == priorityP2 ? this.g.intValue() - request.g.intValue() : priorityP2.ordinal() - priorityP.ordinal();
    }

    public void a(VolleyError volleyError) {
        m.a aVar;
        synchronized (this.f3974e) {
            aVar = this.f3975f;
        }
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    void a(a aVar) {
        synchronized (this.f3974e) {
            this.o = aVar;
        }
    }

    void a(m<?> mVar) {
        a aVar;
        synchronized (this.f3974e) {
            aVar = this.o;
        }
        if (aVar != null) {
            aVar.a(this, mVar);
        }
    }
}
