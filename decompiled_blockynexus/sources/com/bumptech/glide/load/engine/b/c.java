package com.bumptech.glide.load.engine.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f4505a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f4506b = new b();

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f4507a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4508b;

        a() {
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f4505a.get(str);
            if (aVarA == null) {
                aVarA = this.f4506b.a();
                this.f4505a.put(str, aVarA);
            }
            aVarA.f4508b++;
        }
        aVarA.f4507a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.f4505a.get(str);
            com.bumptech.glide.e.l.a(aVar2);
            aVar = aVar2;
            if (aVar.f4508b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f4508b);
            }
            aVar.f4508b--;
            if (aVar.f4508b == 0) {
                a aVarRemove = this.f4505a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.f4506b.a(aVarRemove);
            }
        }
        aVar.f4507a.unlock();
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f4509a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.f4509a) {
                aVarPoll = this.f4509a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.f4509a) {
                if (this.f4509a.size() < 10) {
                    this.f4509a.offer(aVar);
                }
            }
        }
    }
}
