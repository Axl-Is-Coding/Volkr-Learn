package com.bytedance.sdk.a.b.a;

/* JADX INFO: compiled from: NamedRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f4935b;

    public b(String str, Object... objArr) {
        this.f4935b = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4935b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
