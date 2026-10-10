package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzemk<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzigi;
    private final int zzing;
    private List<zzemp> zzinh;
    private Map<K, V> zzini;
    private volatile zzemr zzinj;
    private Map<K, V> zzink;
    private volatile zzeml zzinl;

    private zzemk(int i) {
        this.zzing = i;
        this.zzinh = Collections.emptyList();
        this.zzini = Collections.emptyMap();
        this.zzink = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbip() {
        if (this.zzigi) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbiq() {
        zzbip();
        if (this.zzini.isEmpty() && !(this.zzini instanceof TreeMap)) {
            this.zzini = new TreeMap();
            this.zzink = ((TreeMap) this.zzini).descendingMap();
        }
        return (SortedMap) this.zzini;
    }

    static <FieldDescriptorType extends zzeju<FieldDescriptorType>> zzemk<FieldDescriptorType, Object> zzho(int i) {
        return new zzemj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzhq(int i) {
        zzbip();
        V v = (V) this.zzinh.remove(i).getValue();
        if (!this.zzini.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzbiq().entrySet().iterator();
            this.zzinh.add(new zzemp(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzbip();
        if (!this.zzinh.isEmpty()) {
            this.zzinh.clear();
        }
        if (this.zzini.isEmpty()) {
            return;
        }
        this.zzini.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzini.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzinj == null) {
            this.zzinj = new zzemr(this, null);
        }
        return this.zzinj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzemk)) {
            return super.equals(obj);
        }
        zzemk zzemkVar = (zzemk) obj;
        int size = size();
        if (size != zzemkVar.size()) {
            return false;
        }
        int iZzbim = zzbim();
        if (iZzbim != zzemkVar.zzbim()) {
            return entrySet().equals(zzemkVar.entrySet());
        }
        for (int i = 0; i < iZzbim; i++) {
            if (!zzhp(i).equals(zzemkVar.zzhp(i))) {
                return false;
            }
        }
        if (iZzbim != size) {
            return this.zzini.equals(zzemkVar.zzini);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzinh.get(iZza).getValue() : this.zzini.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzbim = zzbim();
        int iHashCode = 0;
        for (int i = 0; i < iZzbim; i++) {
            iHashCode += this.zzinh.get(i).hashCode();
        }
        return this.zzini.size() > 0 ? iHashCode + this.zzini.hashCode() : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzigi;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzbip();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzhq(iZza);
        }
        if (this.zzini.isEmpty()) {
            return null;
        }
        return this.zzini.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzinh.size() + this.zzini.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzbip();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzinh.get(iZza).setValue(v);
        }
        zzbip();
        if (this.zzinh.isEmpty() && !(this.zzinh instanceof ArrayList)) {
            this.zzinh = new ArrayList(this.zzing);
        }
        int i = -(iZza + 1);
        if (i >= this.zzing) {
            return zzbiq().put(k, v);
        }
        int size = this.zzinh.size();
        int i2 = this.zzing;
        if (size == i2) {
            zzemp zzempVarRemove = this.zzinh.remove(i2 - 1);
            zzbiq().put((Comparable) zzempVarRemove.getKey(), zzempVarRemove.getValue());
        }
        this.zzinh.add(i, new zzemp(this, k, v));
        return null;
    }

    public void zzbec() {
        if (this.zzigi) {
            return;
        }
        this.zzini = this.zzini.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzini);
        this.zzink = this.zzink.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzink);
        this.zzigi = true;
    }

    public final int zzbim() {
        return this.zzinh.size();
    }

    public final Iterable<Map.Entry<K, V>> zzbin() {
        return this.zzini.isEmpty() ? zzemo.zzbis() : this.zzini.entrySet();
    }

    final Set<Map.Entry<K, V>> zzbio() {
        if (this.zzinl == null) {
            this.zzinl = new zzeml(this, null);
        }
        return this.zzinl;
    }

    public final Map.Entry<K, V> zzhp(int i) {
        return this.zzinh.get(i);
    }

    /* synthetic */ zzemk(int i, zzemj zzemjVar) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzinh.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo((Comparable) this.zzinh.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = k.compareTo((Comparable) this.zzinh.get(i2).getKey());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}
