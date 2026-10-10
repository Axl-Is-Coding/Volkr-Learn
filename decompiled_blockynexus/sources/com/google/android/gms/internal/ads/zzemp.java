package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemp<K, V> implements Comparable<zzemp>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzemk zzinm;

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zzinq;

    zzemp(zzemk zzemkVar, Map.Entry<K, V> entry) {
        this(zzemkVar, (Comparable) entry.getKey(), entry.getValue());
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzemp zzempVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzempVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzinq, entry.getKey()) && equals(this.value, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzinq;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zzinq;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.value;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzinm.zzbip();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzinq);
        String strValueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzemp(zzemk zzemkVar, K k, V v) {
        this.zzinm = zzemkVar;
        this.zzinq = k;
        this.value = v;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
