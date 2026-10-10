package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.d.h;

/* JADX INFO: compiled from: AsyncOperationExecutor.java */
/* JADX INFO: loaded from: classes5.dex */
class b implements Handler.Callback, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f23557a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f23559c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile c f23561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile c f23562f;
    private int h;
    private int i;
    private Handler j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<AsyncOperation> f23558b = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f23560d = 50;
    private volatile int g = 50;

    b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        r8.E();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r8.F();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        r9 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        org.greenrobot.greendao.d.b("Async transaction could not be ended, success so far was: " + r4, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.greenrobot.greendao.async.AsyncOperation r8, org.greenrobot.greendao.async.AsyncOperation r9) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.async.b.a(org.greenrobot.greendao.async.AsyncOperation, org.greenrobot.greendao.async.AsyncOperation):void");
    }

    private void b(AsyncOperation asyncOperation) {
        a(asyncOperation);
        e(asyncOperation);
    }

    private void c(AsyncOperation asyncOperation) throws Exception {
        org.greenrobot.greendao.b.a aVarA = asyncOperation.a();
        aVarA.D();
        try {
            asyncOperation.j = ((Callable) asyncOperation.f23553d).call();
            aVarA.E();
        } finally {
            aVarA.F();
        }
    }

    private void d(AsyncOperation asyncOperation) {
        org.greenrobot.greendao.b.a aVarA = asyncOperation.a();
        aVarA.D();
        try {
            ((Runnable) asyncOperation.f23553d).run();
            aVarA.E();
        } finally {
            aVarA.F();
        }
    }

    private void e(AsyncOperation asyncOperation) {
        asyncOperation.e();
        c cVar = this.f23561e;
        if (cVar != null) {
            cVar.a(asyncOperation);
        }
        if (this.f23562f != null) {
            if (this.j == null) {
                this.j = new Handler(Looper.getMainLooper(), this);
            }
            this.j.sendMessage(this.j.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            this.i++;
            if (this.i == this.h) {
                notifyAll();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar = this.f23562f;
        if (cVar == null) {
            return false;
        }
        cVar.a((AsyncOperation) message.obj);
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncOperation asyncOperationPoll;
        AsyncOperation asyncOperationPoll2;
        while (true) {
            try {
                asyncOperationPoll = this.f23558b.poll(1L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                org.greenrobot.greendao.d.c(Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f23559c = false;
            }
            if (asyncOperationPoll == null) {
                synchronized (this) {
                    asyncOperationPoll = this.f23558b.poll();
                    if (asyncOperationPoll == null) {
                        return;
                    }
                    org.greenrobot.greendao.d.c(Thread.currentThread().getName() + " was interruppted", e2);
                    return;
                }
            }
            if (!asyncOperationPoll.c() || (asyncOperationPoll2 = this.f23558b.poll(this.g, TimeUnit.MILLISECONDS)) == null) {
                b(asyncOperationPoll);
            } else if (asyncOperationPoll.a(asyncOperationPoll2)) {
                a(asyncOperationPoll, asyncOperationPoll2);
            } else {
                b(asyncOperationPoll);
                b(asyncOperationPoll2);
            }
        }
    }

    private void a(AsyncOperation asyncOperation) {
        asyncOperation.f23555f = System.currentTimeMillis();
        try {
            switch (a.f23556a[asyncOperation.f23550a.ordinal()]) {
                case 1:
                    asyncOperation.f23551b.delete(asyncOperation.f23553d);
                    break;
                case 2:
                    asyncOperation.f23551b.deleteInTx((Iterable<Object>) asyncOperation.f23553d);
                    break;
                case 3:
                    asyncOperation.f23551b.deleteInTx((Object[]) asyncOperation.f23553d);
                    break;
                case 4:
                    asyncOperation.f23551b.insert(asyncOperation.f23553d);
                    break;
                case 5:
                    asyncOperation.f23551b.insertInTx((Iterable<Object>) asyncOperation.f23553d);
                    break;
                case 6:
                    asyncOperation.f23551b.insertInTx((Object[]) asyncOperation.f23553d);
                    break;
                case 7:
                    asyncOperation.f23551b.insertOrReplace(asyncOperation.f23553d);
                    break;
                case 8:
                    asyncOperation.f23551b.insertOrReplaceInTx((Iterable<Object>) asyncOperation.f23553d);
                    break;
                case 9:
                    asyncOperation.f23551b.insertOrReplaceInTx((Object[]) asyncOperation.f23553d);
                    break;
                case 10:
                    asyncOperation.f23551b.update(asyncOperation.f23553d);
                    break;
                case 11:
                    asyncOperation.f23551b.updateInTx((Iterable<Object>) asyncOperation.f23553d);
                    break;
                case 12:
                    asyncOperation.f23551b.updateInTx((Object[]) asyncOperation.f23553d);
                    break;
                case 13:
                    d(asyncOperation);
                    break;
                case 14:
                    c(asyncOperation);
                    break;
                case 15:
                    asyncOperation.j = ((h) asyncOperation.f23553d).b().c();
                    break;
                case 16:
                    asyncOperation.j = ((h) asyncOperation.f23553d).b().d();
                    break;
                case 17:
                    asyncOperation.f23551b.deleteByKey(asyncOperation.f23553d);
                    break;
                case 18:
                    asyncOperation.f23551b.deleteAll();
                    break;
                case 19:
                    asyncOperation.j = asyncOperation.f23551b.load(asyncOperation.f23553d);
                    break;
                case 20:
                    asyncOperation.j = asyncOperation.f23551b.loadAll();
                    break;
                case 21:
                    asyncOperation.j = Long.valueOf(asyncOperation.f23551b.count());
                    break;
                case 22:
                    asyncOperation.f23551b.refresh(asyncOperation.f23553d);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.f23550a);
            }
        } catch (Throwable th) {
            asyncOperation.i = th;
        }
        asyncOperation.g = System.currentTimeMillis();
    }
}
