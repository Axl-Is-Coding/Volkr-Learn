package org.greenrobot.greendao.async;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final OperationType f23550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.greenrobot.greendao.a<Object, Object> f23551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.greenrobot.greendao.b.a f23552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f23553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f23554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile long f23555f;
    volatile long g;
    private volatile boolean h;
    volatile Throwable i;
    volatile Object j;
    volatile int k;

    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    org.greenrobot.greendao.b.a a() {
        org.greenrobot.greendao.b.a aVar = this.f23552c;
        return aVar != null ? aVar : this.f23551b.getDatabase();
    }

    public boolean b() {
        return this.i != null;
    }

    public boolean c() {
        return (this.f23554e & 1) != 0;
    }

    void d() {
        this.f23555f = 0L;
        this.g = 0L;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = 0;
    }

    synchronized void e() {
        this.h = true;
        notifyAll();
    }

    boolean a(AsyncOperation asyncOperation) {
        return asyncOperation != null && c() && asyncOperation.c() && a() == asyncOperation.a();
    }
}
