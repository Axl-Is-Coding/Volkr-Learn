package io.reactivex.internal.util;

import io.reactivex.b.q;

/* JADX INFO: compiled from: AppendOnlyLinkedArrayList.java */
/* JADX INFO: loaded from: classes5.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f22724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f22725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f22726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f22727d;

    /* JADX INFO: renamed from: io.reactivex.internal.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppendOnlyLinkedArrayList.java */
    public interface InterfaceC0208a<T> extends q<T> {
        @Override // io.reactivex.b.q
        boolean test(T t);
    }

    public a(int i) {
        this.f22724a = i;
        this.f22725b = new Object[i + 1];
        this.f22726c = this.f22725b;
    }

    public void a(T t) {
        int i = this.f22724a;
        int i2 = this.f22727d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f22726c[i] = objArr;
            this.f22726c = objArr;
            i2 = 0;
        }
        this.f22726c[i2] = t;
        this.f22727d = i2 + 1;
    }

    public void b(T t) {
        this.f22725b[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(io.reactivex.internal.util.a.InterfaceC0208a<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f22725b
            int r1 = r4.f22724a
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L15
            return
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(io.reactivex.internal.util.a$a):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(f.b.c<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f22725b
            int r1 = r4.f22724a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(f.b.c):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(io.reactivex.w<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f22725b
            int r1 = r4.f22724a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(io.reactivex.w):boolean");
    }
}
