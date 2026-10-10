package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2M<K, V> implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    public static byte[] A04;
    public static String[] A05;
    public int A00;
    public final /* synthetic */ C2O A03;
    public boolean A02 = false;
    public int A01 = -1;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{28, -40, -20, -19, -9, -92, -25, -13, -14, -8, -27, -19, -14, -23, -10, -92, -24, -13, -23, -9, -92, -14, -13, -8, -92, -9, -7, -12, -12, -13, -10, -8, -92, -10, -23, -8, -27, -19, -14, -19, -14, -21, -92, -47, -27, -12, -78, -55, -14, -8, -10, -3, -92, -13, -26, -18, -23, -25, -8, -9};
    }

    public static void A03() {
        A05 = new String[]{"XqZAhum", "ZDgQMvtBgNrA71zPtdKPERKXDyY", "", "fQnh1QnAdjSL19mcL6hVXdKAmOMxUcoe", "Jl6IPYfhih6t3CzPawLUV", "5ptyQxfboOWL43Tud8kOlHSoYTCJZrHB", "GBGqVCnWWQQidVcjkSktabcuIfs5iNWm", "2xozQVjtj3EM4viJRxfTyERGPuYGzhPM"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    public C2M(C2O c2o) {
        this.A03 = c2o;
        this.A00 = c2o.A05() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final Map.Entry<K, V> next() {
        if (hasNext()) {
            this.A01++;
            this.A02 = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.A02) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C2H.A04(entry.getKey(), this.A03.A08(this.A01, 0)) && C2H.A04(entry.getValue(), this.A03.A08(this.A01, 1));
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final K getKey() {
        if (this.A02) {
            return (K) this.A03.A08(this.A01, 0);
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final V getValue() {
        if (this.A02) {
            return (V) this.A03.A08(this.A01, 1);
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A01 < this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (this.A02) {
            Object objA08 = this.A03.A08(this.A01, 0);
            Object objA082 = this.A03.A08(this.A01, 1);
            int iHashCode = (objA082 != null ? objA082.hashCode() : 0) ^ (objA08 == null ? 0 : objA08.hashCode());
            if (A05[4].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "cWQoJWn94PUAudj4depS9TLvBWA1Kd9i";
            strArr[6] = "6piqOMntm5J7SpM7GaPxMNyHyjGIVV8O";
            return iHashCode;
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Iterator
    public final void remove() {
        if (this.A02) {
            this.A03.A0F(this.A01);
            this.A01--;
            this.A00--;
            this.A02 = false;
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        if (this.A02) {
            return (V) this.A03.A09(this.A01, v);
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2M != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$MapIterator */
    public final String toString() {
        return getKey() + A00(0, 1, 115) + getValue();
    }
}
