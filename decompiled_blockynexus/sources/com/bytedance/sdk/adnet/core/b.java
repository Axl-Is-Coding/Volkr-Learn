package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Comparator<byte[]> f5479a = new Comparator<byte[]>() { // from class: com.bytedance.sdk.adnet.core.b.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f5480b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f5481c = new ArrayList(64);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5482d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5483e;

    public b(int i) {
        this.f5483e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f5481c.size(); i2++) {
            byte[] bArr = this.f5481c.get(i2);
            if (bArr.length >= i) {
                this.f5482d -= bArr.length;
                this.f5481c.remove(i2);
                this.f5480b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f5483e) {
                this.f5480b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f5481c, bArr, f5479a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f5481c.add(iBinarySearch, bArr);
                this.f5482d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f5482d > this.f5483e) {
            byte[] bArrRemove = this.f5480b.remove(0);
            this.f5481c.remove(bArrRemove);
            this.f5482d -= bArrRemove.length;
        }
    }
}
