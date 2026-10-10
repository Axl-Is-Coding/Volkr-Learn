package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class ac implements InterfaceC0447mb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f3088c;
    public String g;
    public Ia h;
    public InterfaceC0418d i;
    private C0457q l;
    public long q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3089d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3090e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3091f = -1;
    public volatile boolean j = false;
    private int k = 0;
    public int m = 0;
    public boolean n = true;
    CountDownLatch o = new CountDownLatch(1);
    public volatile boolean p = false;

    public ac(String str, byte[] bArr) {
        this.g = "";
        this.f3086a = str;
        this.f3087b = bArr;
        this.g = C0455pa.d();
    }

    @Override // c.t.m.g.InterfaceC0447mb
    public final String a() {
        return this.g;
    }

    public final synchronized void a(C0457q c0457q) {
        this.l = c0457q;
    }

    @Override // c.t.m.g.InterfaceC0447mb
    public final void a(String str, String str2) {
        if (this.f3088c == null) {
            this.f3088c = new HashMap();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f3088c.put(str, str2);
    }

    @Override // c.t.m.g.InterfaceC0447mb
    public final void b() {
        this.m = 15000;
    }

    public final boolean c() {
        try {
            return this.o.await(this.m, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            return true;
        }
    }

    public final synchronized C0457q d() {
        return this.l;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("url:" + this.f3086a);
        sb.append(",body:" + C0455pa.b(this.f3087b));
        sb.append(",isGet:false");
        sb.append(",timeout:" + this.f3091f);
        sb.append(",tag:" + ((Object) null));
        sb.append(",httpCallback:" + ((Object) null));
        sb.append(",testMode:0");
        sb.append(",httpCallback:" + ((Object) null));
        sb.append(",testMode:0");
        sb.append(",followRedirects:" + this.f3090e);
        sb.append(",isAbort:" + this.j);
        sb.append(",headers:" + this.f3088c);
        return sb.toString();
    }
}
