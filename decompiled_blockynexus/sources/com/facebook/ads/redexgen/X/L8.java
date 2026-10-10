package com.facebook.ads.redexgen.X;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class L8 extends Thread implements Closeable {
    public static String[] A02;
    public boolean A00 = false;
    public final /* synthetic */ L9 A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"TlcI8clPy2cAxmBQLm6V1herqnmAITse", "yZ5kpCkqR1osI6zLxCntBCQkuWvFDLL5", "q2c", "jrNyDVk0HDDQUaPHkyGFAgSqoyhAwgQL", "WhGkB9GwGiTJZue6wwGhsu4RprprQOI3", "P0d", "2ZYrdgfLM", "x3INJ1jAMxJto"};
    }

    public L8(L9 l9) {
        this.A01 = l9;
        start();
    }

    public final synchronized void A01() {
        this.A01.A02.A02();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            this.A00 = true;
            this.A01.A02.A02();
        }
        try {
            join();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r1 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r0 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r5.A01.A03.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x005b, code lost:
    
        monitor-enter(r5.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005c, code lost:
    
        r5.A01.A02.A03();
        r5.A01.A00 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006b, code lost:
    
        throw r2;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = com.facebook.ads.redexgen.X.KL.A02(r5)
            if (r0 == 0) goto L7
            return
        L7:
            r4 = r5
        L8:
            r3 = 0
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
            com.facebook.ads.redexgen.X.L7 r0 = com.facebook.ads.redexgen.X.L9.A00(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
            r0.A04()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
            com.facebook.ads.redexgen.X.L9 r2 = r4.A01     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L55
            boolean r1 = r4.A00     // Catch: java.lang.Throwable -> L4f
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L4f
            com.facebook.ads.redexgen.X.L7 r0 = com.facebook.ads.redexgen.X.L9.A00(r0)     // Catch: java.lang.Throwable -> L4f
            boolean r0 = r0.A05()     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L27
            goto L35
        L27:
            if (r0 == 0) goto L8
            goto L2c
        L2a:
            r0 = move-exception
            goto L56
        L2c:
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L6f
            java.lang.Runnable r0 = com.facebook.ads.redexgen.X.L9.A02(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L6f
            r0.run()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L6f
        L35:
            com.facebook.ads.redexgen.X.L9 r1 = r4.A01     // Catch: java.lang.Throwable -> L88
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L88
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L48
            com.facebook.ads.redexgen.X.L7 r0 = com.facebook.ads.redexgen.X.L9.A00(r0)     // Catch: java.lang.Throwable -> L48
            r0.A03()     // Catch: java.lang.Throwable -> L48
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L48
            com.facebook.ads.redexgen.X.L9.A01(r0, r3)     // Catch: java.lang.Throwable -> L48
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L48
            goto L81
        L48:
            r0 = move-exception
        L49:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4b
            goto L87
        L4b:
            r0 = move-exception
            goto L49
        L4d:
            r2 = move-exception
            goto L59
        L4f:
            r0 = move-exception
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L52
            goto L54
        L52:
            r0 = move-exception
            goto L50
        L54:
            throw r0     // Catch: java.lang.Throwable -> L55
        L55:
            r0 = move-exception
        L56:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            throw r0     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L6f
        L58:
            r2 = move-exception
        L59:
            com.facebook.ads.redexgen.X.L9 r1 = r4.A01     // Catch: java.lang.Throwable -> L88
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L88
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L6c
            com.facebook.ads.redexgen.X.L7 r0 = com.facebook.ads.redexgen.X.L9.A00(r0)     // Catch: java.lang.Throwable -> L6c
            r0.A03()     // Catch: java.lang.Throwable -> L6c
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L6c
            com.facebook.ads.redexgen.X.L9.A01(r0, r3)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6c
            throw r2     // Catch: java.lang.Throwable -> L88
        L6c:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6c
            throw r0     // Catch: java.lang.Throwable -> L88
        L6f:
            com.facebook.ads.redexgen.X.L9 r1 = r4.A01     // Catch: java.lang.Throwable -> L88
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L88
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L82
            com.facebook.ads.redexgen.X.L7 r0 = com.facebook.ads.redexgen.X.L9.A00(r0)     // Catch: java.lang.Throwable -> L82
            r0.A03()     // Catch: java.lang.Throwable -> L82
            com.facebook.ads.redexgen.X.L9 r0 = r4.A01     // Catch: java.lang.Throwable -> L82
            com.facebook.ads.redexgen.X.L9.A01(r0, r3)     // Catch: java.lang.Throwable -> L82
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L82
        L81:
            return
        L82:
            r0 = move-exception
        L83:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            goto L87
        L85:
            r0 = move-exception
            goto L83
        L87:
            throw r0     // Catch: java.lang.Throwable -> L88
        L88:
            r3 = move-exception
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.L8.A02
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 3
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La2
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        La2:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.L8.A02
            java.lang.String r1 = "H8LkVKTaRgPgjJ8wA09keGujcKIyNUsx"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "efuks0AdkGQXVqtKjDHDj7Hnj0oyHabl"
            r0 = 1
            r2[r0] = r1
            com.facebook.ads.redexgen.X.KL.A00(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L8.run():void");
    }
}
