package com.google.zxing.a.a;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: State.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final g f14409a = new g(h.f14414a, 0, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f14411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f14413e;

    private g(h hVar, int i, int i2, int i3) {
        this.f14411c = hVar;
        this.f14410b = i;
        this.f14412d = i2;
        this.f14413e = i3;
    }

    int a() {
        return this.f14412d;
    }

    int b() {
        return this.f14413e;
    }

    int c() {
        return this.f14410b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", e.f14402a[this.f14410b], Integer.valueOf(this.f14413e), Integer.valueOf(this.f14412d));
    }

    g a(int i, int i2) {
        int i3 = this.f14413e;
        h hVarA = this.f14411c;
        int i4 = this.f14410b;
        if (i != i4) {
            int i5 = e.f14403b[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            hVarA = hVarA.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new g(hVarA.a(i2, i8), i, 0, i3 + i8);
    }

    g b(int i, int i2) {
        h hVar = this.f14411c;
        int i3 = this.f14410b == 2 ? 4 : 5;
        return new g(hVar.a(e.f14405d[this.f14410b][i], i3).a(i2, 5), this.f14410b, 0, this.f14413e + i3 + 5);
    }

    g b(int i) {
        int i2 = this.f14412d;
        return i2 == 0 ? this : new g(this.f14411c.b(i - i2, i2), this.f14410b, 0, this.f14413e);
    }

    g a(int i) {
        h hVarA = this.f14411c;
        int i2 = this.f14410b;
        int i3 = this.f14413e;
        if (i2 == 4 || i2 == 2) {
            int i4 = e.f14403b[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            hVarA = hVarA.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.f14412d;
        g gVar = new g(hVarA, i2, this.f14412d + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return gVar.f14412d == 2078 ? gVar.b(i + 1) : gVar;
    }

    boolean a(g gVar) {
        int i;
        int i2 = this.f14413e + (e.f14403b[this.f14410b][gVar.f14410b] >> 16);
        int i3 = gVar.f14412d;
        if (i3 > 0 && ((i = this.f14412d) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= gVar.f14413e;
    }

    com.google.zxing.common.a a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (h hVarA = b(bArr.length).f14411c; hVarA != null; hVarA = hVarA.a()) {
            linkedList.addFirst(hVarA);
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(aVar, bArr);
        }
        return aVar;
    }
}
