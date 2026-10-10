package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.e;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.y;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TwitterCore.java */
/* JADX INFO: loaded from: classes5.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static volatile w f20281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    m<y> f20282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m<e> f20283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.twitter.sdk.android.core.internal.j<y> f20284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f20285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<l, o> f20286f;
    private final Context g;
    private volatile o h;
    private volatile g i;

    w(q qVar) {
        this(qVar, new ConcurrentHashMap(), null);
    }

    public static w g() {
        if (f20281a == null) {
            synchronized (w.class) {
                if (f20281a == null) {
                    f20281a = new w(n.d().f());
                    n.d().c().execute(new Runnable() { // from class: com.twitter.sdk.android.core.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            w.f20281a.a();
                        }
                    });
                }
            }
        }
        return f20281a;
    }

    private synchronized void k() {
        if (this.h == null) {
            this.h = new o();
        }
    }

    private synchronized void l() {
        if (this.i == null) {
            this.i = new g(new OAuth2Service(this, new com.twitter.sdk.android.core.internal.m()), this.f20283c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f20282b.b();
        this.f20283c.b();
        e();
        this.f20284d.a(n.d().b());
    }

    public o b() {
        y yVar = (y) this.f20282b.b();
        return yVar == null ? d() : a(yVar);
    }

    public q c() {
        return this.f20285e;
    }

    public o d() {
        if (this.h == null) {
            k();
        }
        return this.h;
    }

    public g e() {
        if (this.i == null) {
            l();
        }
        return this.i;
    }

    public String f() {
        return "com.twitter.sdk.android:twitter-core";
    }

    public m<y> h() {
        return this.f20282b;
    }

    public String i() {
        return "3.3.0.12";
    }

    w(q qVar, ConcurrentHashMap<l, o> concurrentHashMap, o oVar) {
        this.f20285e = qVar;
        this.f20286f = concurrentHashMap;
        this.h = oVar;
        this.g = n.d().a(f());
        this.f20282b = new j(new com.twitter.sdk.android.core.internal.b.c(this.g, "session_store"), new y.a(), "active_twittersession", "twittersession");
        this.f20283c = new j(new com.twitter.sdk.android.core.internal.b.c(this.g, "session_store"), new e.a(), "active_guestsession", "guestsession");
        this.f20284d = new com.twitter.sdk.android.core.internal.j<>(this.f20282b, n.d().c(), new com.twitter.sdk.android.core.internal.n());
    }

    public o a(y yVar) {
        if (!this.f20286f.containsKey(yVar)) {
            this.f20286f.putIfAbsent(yVar, new o(yVar));
        }
        return this.f20286f.get(yVar);
    }
}
