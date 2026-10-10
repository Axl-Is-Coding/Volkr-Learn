package com.tendcloud.tenddata;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.BitSet;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f20017a = 1048576;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f20018b = {5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BitSet f20019c = new BitSet(1048576);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a[] f20020d = new a[f20018b.length];

    /* JADX INFO: compiled from: td */
    static class a {
        private int cap;
        private int seed;

        a(int i, int i2) {
            this.cap = i;
            this.seed = i2;
        }

        int hash(String str) {
            int length = str.length();
            int iCharAt = 0;
            for (int i = 0; i < length; i++) {
                iCharAt = str.charAt(i) + (this.seed * iCharAt);
            }
            return (this.cap - 1) & iCharAt;
        }
    }

    private f() {
        int i = 0;
        while (true) {
            int[] iArr = f20018b;
            if (i >= iArr.length) {
                return;
            }
            this.f20020d[i] = new a(1048576, iArr[i]);
            i++;
        }
    }

    public static f a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            f fVar = new f();
            fVar.f20019c = (BitSet) object;
            return fVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        boolean z = true;
        for (a aVar : this.f20020d) {
            z = z && this.f20019c.get(aVar.hash(str));
        }
        return z;
    }
}
