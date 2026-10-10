package androidx.core.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f1095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Callable f1096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f1097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f1098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Condition f1099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ k f1100f;

    j(k kVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f1100f = kVar;
        this.f1095a = atomicReference;
        this.f1096b = callable;
        this.f1097c = reentrantLock;
        this.f1098d = atomicBoolean;
        this.f1099e = condition;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1095a.set(this.f1096b.call());
        } catch (Exception unused) {
        }
        this.f1097c.lock();
        try {
            this.f1098d.set(false);
            this.f1099e.signal();
        } finally {
            this.f1097c.unlock();
        }
    }
}
