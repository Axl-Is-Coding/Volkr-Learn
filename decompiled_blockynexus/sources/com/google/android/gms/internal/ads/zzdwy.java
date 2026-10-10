package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdwy<K, V> extends zzdwt<K, V> {
    private static final zzdwt<Object, Object> zzhqx = new zzdwy(null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzhqy;
    private final transient Object[] zzhqz;

    private zzdwy(Object obj, Object[] objArr, int i) {
        this.zzhqy = obj;
        this.zzhqz = objArr;
        this.size = i;
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 39 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length() + String.valueOf(strValueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ca, code lost:
    
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <K, V> com.google.android.gms.internal.ads.zzdwy<K, V> zzc(int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwy.zzc(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdwy");
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, java.util.Map
    public final V get(Object obj) {
        Object obj2 = this.zzhqy;
        Object[] objArr = this.zzhqz;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iZzel = zzdwl.zzel(obj.hashCode());
            while (true) {
                int i2 = iZzel & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return (V) objArr[i3 ^ 1];
                }
                iZzel = i2 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iZzel2 = zzdwl.zzel(obj.hashCode());
            while (true) {
                int i4 = iZzel2 & length2;
                int i5 = sArr[i4] & 65535;
                if (i5 == 65535) {
                    return null;
                }
                if (objArr[i5].equals(obj)) {
                    return (V) objArr[i5 ^ 1];
                }
                iZzel2 = i4 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iZzel3 = zzdwl.zzel(obj.hashCode());
            while (true) {
                int i6 = iZzel3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    return null;
                }
                if (objArr[i7].equals(obj)) {
                    return (V) objArr[i7 ^ 1];
                }
                iZzel3 = i6 + 1;
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdws<Map.Entry<K, V>> zzaxr() {
        return new zzdxb(this, this.zzhqz, 0, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdws<K> zzaxs() {
        return new zzdxd(this, new zzdxc(this.zzhqz, 0, this.size));
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdwk<V> zzaxt() {
        return new zzdxc(this.zzhqz, 1, this.size);
    }
}
