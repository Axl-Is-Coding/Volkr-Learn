package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeju;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejs<T extends zzeju<T>> {
    private static final zzejs zzigk = new zzejs(true);
    final zzemk<T, Object> zzigh;
    private boolean zzigi;
    private boolean zzigj;

    private zzejs() {
        this.zzigh = zzemk.zzho(16);
    }

    private final Object zza(T t) {
        Object obj = this.zzigh.get(t);
        if (!(obj instanceof zzeko)) {
            return obj;
        }
        zzeko.zzbhh();
        throw null;
    }

    private static Object zzak(Object obj) {
        if (obj instanceof zzels) {
            return ((zzels) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static <T extends zzeju<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzbgb() == zzenr.MESSAGE) {
            if (key.zzbgc()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzelj) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzelj)) {
                    if (value instanceof zzeko) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzelj) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T extends zzeju<T>> zzejs<T> zzbfy() {
        return zzigk;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzeko) {
            zzeko.zzbhh();
            throw null;
        }
        if (key.zzbgc()) {
            Object objZza = zza(key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zzak(it.next()));
            }
            this.zzigh.put(key, objZza);
            return;
        }
        if (key.zzbgb() != zzenr.MESSAGE) {
            this.zzigh.put(key, zzak(value));
            return;
        }
        Object objZza2 = zza(key);
        if (objZza2 == null) {
            this.zzigh.put(key, zzak(value));
        } else {
            this.zzigh.put(key, objZza2 instanceof zzels ? key.zza((zzels) objZza2, (zzels) value) : key.zza(((zzelj) objZza2).zzbgl(), (zzelj) value).zzbgt());
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.zzbgb() != zzenr.MESSAGE || key.zzbgc() || key.zzbgd()) ? zzb((zzeju<?>) key, value) : value instanceof zzeko ? zzejj.zzb(entry.getKey().zzv(), (zzeko) value) : zzejj.zzb(entry.getKey().zzv(), (zzelj) value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzejs zzejsVar = new zzejs();
        for (int i = 0; i < this.zzigh.zzbim(); i++) {
            Map.Entry<K, Object> entryZzhp = this.zzigh.zzhp(i);
            zzejsVar.zza((zzeju) entryZzhp.getKey(), entryZzhp.getValue());
        }
        Iterator it = this.zzigh.zzbin().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzejsVar.zza((zzeju) entry.getKey(), entry.getValue());
        }
        zzejsVar.zzigj = this.zzigj;
        return zzejsVar;
    }

    final Iterator<Map.Entry<T, Object>> descendingIterator() {
        return this.zzigj ? new zzekp(this.zzigh.zzbio().iterator()) : this.zzigh.zzbio().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzejs) {
            return this.zzigh.equals(((zzejs) obj).zzigh);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzigh.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzigi;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzigh.zzbim(); i++) {
            if (!zzb(this.zzigh.zzhp(i))) {
                return false;
            }
        }
        Iterator it = this.zzigh.zzbin().iterator();
        while (it.hasNext()) {
            if (!zzb((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        return this.zzigj ? new zzekp(this.zzigh.entrySet().iterator()) : this.zzigh.entrySet().iterator();
    }

    public final void zzbec() {
        if (this.zzigi) {
            return;
        }
        this.zzigh.zzbec();
        this.zzigi = true;
    }

    public final int zzbfz() {
        int iZzd = 0;
        for (int i = 0; i < this.zzigh.zzbim(); i++) {
            iZzd += zzd(this.zzigh.zzhp(i));
        }
        Iterator it = this.zzigh.zzbin().iterator();
        while (it.hasNext()) {
            iZzd += zzd((Map.Entry) it.next());
        }
        return iZzd;
    }

    private zzejs(boolean z) {
        this(zzemk.zzho(0));
        zzbec();
    }

    private final void zza(T t, Object obj) {
        if (t.zzbgc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    zza(t.zzbga(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zza(t.zzbga(), obj);
        }
        if (obj instanceof zzeko) {
            this.zzigj = true;
        }
        this.zzigh.put(t, obj);
    }

    private zzejs(zzemk<T, Object> zzemkVar) {
        this.zzigh = zzemkVar;
        zzbec();
    }

    private static int zzb(zzeno zzenoVar, Object obj) {
        switch (zzejr.zzifq[zzenoVar.ordinal()]) {
            case 1:
                return zzejj.zzd(((Double) obj).doubleValue());
            case 2:
                return zzejj.zzg(((Float) obj).floatValue());
            case 3:
                return zzejj.zzfl(((Long) obj).longValue());
            case 4:
                return zzejj.zzfm(((Long) obj).longValue());
            case 5:
                return zzejj.zzgr(((Integer) obj).intValue());
            case 6:
                return zzejj.zzfo(((Long) obj).longValue());
            case 7:
                return zzejj.zzgu(((Integer) obj).intValue());
            case 8:
                return zzejj.zzbt(((Boolean) obj).booleanValue());
            case 9:
                return zzejj.zzi((zzelj) obj);
            case 10:
                if (obj instanceof zzeko) {
                    return zzejj.zza((zzeko) obj);
                }
                return zzejj.zzh((zzelj) obj);
            case 11:
                if (obj instanceof zzeip) {
                    return zzejj.zzai((zzeip) obj);
                }
                return zzejj.zzhw((String) obj);
            case 12:
                if (obj instanceof zzeip) {
                    return zzejj.zzai((zzeip) obj);
                }
                return zzejj.zzx((byte[]) obj);
            case 13:
                return zzejj.zzgs(((Integer) obj).intValue());
            case 14:
                return zzejj.zzgv(((Integer) obj).intValue());
            case 15:
                return zzejj.zzfp(((Long) obj).longValue());
            case 16:
                return zzejj.zzgt(((Integer) obj).intValue());
            case 17:
                return zzejj.zzfn(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzeke) {
                    return zzejj.zzgw(((zzeke) obj).zzv());
                }
                return zzejj.zzgw(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.ads.zzeno r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzekb.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzejr.zzigg
            com.google.android.gms.internal.ads.zzenr r2 = r2.zzbje()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzelj
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeko
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeke
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeip
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4e
        L4d:
            throw r2
        L4e:
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejs.zza(com.google.android.gms.internal.ads.zzeno, java.lang.Object):void");
    }

    public final void zza(zzejs<T> zzejsVar) {
        for (int i = 0; i < zzejsVar.zzigh.zzbim(); i++) {
            zzc(zzejsVar.zzigh.zzhp(i));
        }
        Iterator it = zzejsVar.zzigh.zzbin().iterator();
        while (it.hasNext()) {
            zzc((Map.Entry) it.next());
        }
    }

    static void zza(zzejj zzejjVar, zzeno zzenoVar, int i, Object obj) throws IOException {
        if (zzenoVar == zzeno.zzipf) {
            zzelj zzeljVar = (zzelj) obj;
            zzekb.zzk(zzeljVar);
            zzejjVar.writeTag(i, 3);
            zzeljVar.zzb(zzejjVar);
            zzejjVar.writeTag(i, 4);
        }
        zzejjVar.writeTag(i, zzenoVar.zzbjf());
        switch (zzejr.zzifq[zzenoVar.ordinal()]) {
            case 1:
                zzejjVar.zzc(((Double) obj).doubleValue());
                break;
            case 2:
                zzejjVar.zzf(((Float) obj).floatValue());
                break;
            case 3:
                zzejjVar.zzfi(((Long) obj).longValue());
                break;
            case 4:
                zzejjVar.zzfi(((Long) obj).longValue());
                break;
            case 5:
                zzejjVar.zzgm(((Integer) obj).intValue());
                break;
            case 6:
                zzejjVar.zzfk(((Long) obj).longValue());
                break;
            case 7:
                zzejjVar.zzgp(((Integer) obj).intValue());
                break;
            case 8:
                zzejjVar.zzbs(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzelj) obj).zzb(zzejjVar);
                break;
            case 10:
                zzejjVar.zzg((zzelj) obj);
                break;
            case 11:
                if (obj instanceof zzeip) {
                    zzejjVar.zzah((zzeip) obj);
                } else {
                    zzejjVar.zzhv((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzeip) {
                    zzejjVar.zzah((zzeip) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzejjVar.zzk(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzejjVar.zzgn(((Integer) obj).intValue());
                break;
            case 14:
                zzejjVar.zzgp(((Integer) obj).intValue());
                break;
            case 15:
                zzejjVar.zzfk(((Long) obj).longValue());
                break;
            case 16:
                zzejjVar.zzgo(((Integer) obj).intValue());
                break;
            case 17:
                zzejjVar.zzfj(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzeke) {
                    zzejjVar.zzgm(((zzeke) obj).zzv());
                } else {
                    zzejjVar.zzgm(((Integer) obj).intValue());
                }
                break;
        }
    }

    public static int zzb(zzeju<?> zzejuVar, Object obj) {
        zzeno zzenoVarZzbga = zzejuVar.zzbga();
        int iZzv = zzejuVar.zzv();
        if (zzejuVar.zzbgc()) {
            int iZza = 0;
            if (zzejuVar.zzbgd()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza += zzb(zzenoVarZzbga, it.next());
                }
                return zzejj.zzgq(iZzv) + iZza + zzejj.zzgy(iZza);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza += zza(zzenoVarZzbga, iZzv, it2.next());
            }
            return iZza;
        }
        return zza(zzenoVarZzbga, iZzv, obj);
    }

    static int zza(zzeno zzenoVar, int i, Object obj) {
        int iZzgq = zzejj.zzgq(i);
        if (zzenoVar == zzeno.zzipf) {
            zzekb.zzk((zzelj) obj);
            iZzgq <<= 1;
        }
        return iZzgq + zzb(zzenoVar, obj);
    }
}
