package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Twitter.java */
/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final i f20257a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static volatile n f20258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f20259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExecutorService f20260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f20261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.twitter.sdk.android.core.internal.e f20262f;
    private final i g;
    private final boolean h;

    private n(u uVar) {
        this.f20259c = uVar.f20269a;
        this.f20262f = new com.twitter.sdk.android.core.internal.e(this.f20259c);
        q qVar = uVar.f20271c;
        if (qVar == null) {
            this.f20261e = new q(com.twitter.sdk.android.core.internal.f.b(this.f20259c, "com.twitter.sdk.android.CONSUMER_KEY", ""), com.twitter.sdk.android.core.internal.f.b(this.f20259c, "com.twitter.sdk.android.CONSUMER_SECRET", ""));
        } else {
            this.f20261e = qVar;
        }
        ExecutorService executorService = uVar.f20272d;
        if (executorService == null) {
            this.f20260d = com.twitter.sdk.android.core.internal.h.a("twitter-worker");
        } else {
            this.f20260d = executorService;
        }
        i iVar = uVar.f20270b;
        if (iVar == null) {
            this.g = f20257a;
        } else {
            this.g = iVar;
        }
        Boolean bool = uVar.f20273e;
        if (bool == null) {
            this.h = false;
        } else {
            this.h = bool.booleanValue();
        }
    }

    static synchronized n a(u uVar) {
        if (f20258b != null) {
            return f20258b;
        }
        f20258b = new n(uVar);
        return f20258b;
    }

    public static void b(u uVar) {
        a(uVar);
    }

    public static n d() {
        a();
        return f20258b;
    }

    public static i e() {
        return f20258b == null ? f20257a : f20258b.g;
    }

    public static boolean g() {
        if (f20258b == null) {
            return false;
        }
        return f20258b.h;
    }

    public ExecutorService c() {
        return this.f20260d;
    }

    public q f() {
        return this.f20261e;
    }

    public com.twitter.sdk.android.core.internal.e b() {
        return this.f20262f;
    }

    static void a() {
        if (f20258b == null) {
            throw new IllegalStateException("Must initialize Twitter before using getInstance()");
        }
    }

    public Context a(String str) {
        return new v(this.f20259c, str, ".TwitterKit" + File.separator + str);
    }
}
