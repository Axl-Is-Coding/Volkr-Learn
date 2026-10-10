package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReedSolomonEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f14431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f14432b = new ArrayList();

    public c(a aVar) {
        this.f14431a = aVar;
        this.f14432b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.f14432b.size()) {
            List<b> list = this.f14432b;
            b bVarC = list.get(list.size() - 1);
            for (int size = this.f14432b.size(); size <= i; size++) {
                a aVar = this.f14431a;
                bVarC = bVarC.c(new b(aVar, new int[]{1, aVar.a((size - 1) + aVar.a())}));
                this.f14432b.add(bVarC);
            }
        }
        return this.f14432b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                b bVarA = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new b(this.f14431a, iArr2).a(i, 1).b(bVarA)[1].a();
                int length2 = i - iArrA.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
