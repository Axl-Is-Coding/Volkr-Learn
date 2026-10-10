package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AsyncTimeout.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static a f4839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f4840b = TimeUnit.SECONDS.toMillis(60);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f4841d = TimeUnit.MILLISECONDS.toNanos(f4840b);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4843f;
    private long g;

    /* JADX INFO: renamed from: com.bytedance.sdk.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTimeout.java */
    private static final class C0065a extends Thread {
        C0065a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.a_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.a.a.a> r0 = com.bytedance.sdk.a.a.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.bytedance.sdk.a.a.a r1 = com.bytedance.sdk.a.a.a.d()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.a.a.a r2 = com.bytedance.sdk.a.a.a.f4839a     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.a.a.a.f4839a = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.a_()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.a.a.C0065a.run():void");
        }
    }

    static a d() throws InterruptedException {
        a aVar = f4839a.f4843f;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(f4840b);
            if (f4839a.f4843f != null || System.nanoTime() - jNanoTime < f4841d) {
                return null;
            }
            return f4839a;
        }
        long jB = aVar.b(System.nanoTime());
        if (jB > 0) {
            long j = jB / 1000000;
            a.class.wait(j, (int) (jB - (1000000 * j)));
            return null;
        }
        f4839a.f4843f = aVar.f4843f;
        aVar.f4843f = null;
        return aVar;
    }

    public final void a() {
        if (this.f4842e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jB_ = b_();
        boolean zC = c();
        if (jB_ != 0 || zC) {
            this.f4842e = true;
            a(this, jB_, zC);
        }
    }

    protected void a_() {
    }

    public final boolean b() {
        if (!this.f4842e) {
            return false;
        }
        this.f4842e = false;
        return a(this);
    }

    private long b(long j) {
        return this.g - j;
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        if (f4839a == null) {
            f4839a = new a();
            new C0065a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.g = Math.min(j, aVar.c_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.g = j + jNanoTime;
        } else if (z) {
            aVar.g = aVar.c_();
        } else {
            throw new AssertionError();
        }
        long jB = aVar.b(jNanoTime);
        a aVar2 = f4839a;
        while (aVar2.f4843f != null && jB >= aVar2.f4843f.b(jNanoTime)) {
            aVar2 = aVar2.f4843f;
        }
        aVar.f4843f = aVar2.f4843f;
        aVar2.f4843f = aVar;
        if (aVar2 == f4839a) {
            a.class.notify();
        }
    }

    private static synchronized boolean a(a aVar) {
        for (a aVar2 = f4839a; aVar2 != null; aVar2 = aVar2.f4843f) {
            if (aVar2.f4843f == aVar) {
                aVar2.f4843f = aVar.f4843f;
                aVar.f4843f = null;
                return false;
            }
        }
        return true;
    }

    public final r a(final r rVar) {
        return new r() { // from class: com.bytedance.sdk.a.a.a.1
            @Override // com.bytedance.sdk.a.a.r
            public t a() {
                return a.this;
            }

            @Override // com.bytedance.sdk.a.a.r
            public void a_(c cVar, long j) throws IOException {
                u.a(cVar.f4852b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    o oVar = cVar.f4851a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += (long) (oVar.f4886c - oVar.f4885b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        oVar = oVar.f4889f;
                    }
                    a.this.a();
                    try {
                        try {
                            rVar.a_(cVar, j2);
                            j -= j2;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.a(e2);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.flush();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() { // from class: com.bytedance.sdk.a.a.a.2
            @Override // com.bytedance.sdk.a.a.s
            public long a(c cVar, long j) throws IOException {
                a.this.a();
                try {
                    try {
                        long jA = sVar.a(cVar, j);
                        a.this.a(true);
                        return jA;
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.a(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }

            @Override // com.bytedance.sdk.a.a.s
            public t a() {
                return a.this;
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (b() && z) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) throws IOException {
        return !b() ? iOException : b(iOException);
    }
}
