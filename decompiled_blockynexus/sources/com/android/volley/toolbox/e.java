package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Comparator<byte[]> f4042a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f4043b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f4044c = new ArrayList(64);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4045d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4046e;

    public e(int i) {
        this.f4046e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f4044c.size(); i2++) {
            byte[] bArr = this.f4044c.get(i2);
            if (bArr.length >= i) {
                this.f4045d -= bArr.length;
                this.f4044c.remove(i2);
                this.f4043b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f4046e) {
                this.f4043b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f4044c, bArr, f4042a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f4044c.add(iBinarySearch, bArr);
                this.f4045d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f4045d > this.f4046e) {
            byte[] bArrRemove = this.f4043b.remove(0);
            this.f4044c.remove(bArrRemove);
            this.f4045d -= bArrRemove.length;
        }
    }
}
