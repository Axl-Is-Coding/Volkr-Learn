package io.reactivex.internal.util;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.w;

/* JADX INFO: compiled from: QueueDrainHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r1 = r15.a(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void a(io.reactivex.c.a.j<T> r11, io.reactivex.w<? super U> r12, boolean r13, io.reactivex.disposables.b r14, io.reactivex.internal.util.h<T, U> r15) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r15.done()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.done()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = 1
            goto L24
        L22:
            r4 = 0
            r10 = 0
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.a(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.a(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.k.a(io.reactivex.c.a.j, io.reactivex.w, boolean, io.reactivex.disposables.b, io.reactivex.internal.util.h):void");
    }

    public static <T, U> boolean a(boolean z, boolean z2, w<?> wVar, boolean z3, io.reactivex.c.a.k<?> kVar, io.reactivex.disposables.b bVar, h<T, U> hVar) {
        if (hVar.a()) {
            kVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable thError = hVar.error();
            if (thError != null) {
                wVar.onError(thError);
            } else {
                wVar.onComplete();
            }
            return true;
        }
        Throwable thError2 = hVar.error();
        if (thError2 != null) {
            kVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            wVar.onError(thError2);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        wVar.onComplete();
        return true;
    }

    public static <T> io.reactivex.c.a.k<T> a(int i) {
        if (i < 0) {
            return new io.reactivex.internal.queue.a(-i);
        }
        return new SpscArrayQueue(i);
    }
}
