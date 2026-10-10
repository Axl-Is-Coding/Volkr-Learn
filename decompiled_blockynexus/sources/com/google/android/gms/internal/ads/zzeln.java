package com.google.android.gms.internal.ads;

import cn.qqtheme.framework.widget.WheelView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeln<T> implements zzemf<T> {
    private final int[] zzilo;
    private final Object[] zzilp;
    private final int zzilq;
    private final int zzilr;
    private final zzelj zzils;
    private final boolean zzilt;
    private final boolean zzilu;
    private final boolean zzilv;
    private final boolean zzilw;
    private final int[] zzilx;
    private final int zzily;
    private final int zzilz;
    private final zzelr zzima;
    private final zzekt zzimb;
    private final zzemx<?, ?> zzimc;
    private final zzejo<?> zzimd;
    private final zzelg zzime;
    private static final int[] zziln = new int[0];
    private static final Unsafe zzhsa = zzend.zzbja();

    private zzeln(int[] iArr, Object[] objArr, int i, int i2, zzelj zzeljVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzelr zzelrVar, zzekt zzektVar, zzemx<?, ?> zzemxVar, zzejo<?> zzejoVar, zzelg zzelgVar) {
        this.zzilo = iArr;
        this.zzilp = objArr;
        this.zzilq = i;
        this.zzilr = i2;
        this.zzilu = zzeljVar instanceof zzejz;
        this.zzilv = z;
        this.zzilt = zzejoVar != null && zzejoVar.zzj(zzeljVar);
        this.zzilw = false;
        this.zzilx = iArr2;
        this.zzily = i3;
        this.zzilz = i4;
        this.zzima = zzelrVar;
        this.zzimb = zzektVar;
        this.zzimc = zzemxVar;
        this.zzimd = zzejoVar;
        this.zzils = zzeljVar;
        this.zzime = zzelgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x0396  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.ads.zzeln<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.ads.zzelh r34, com.google.android.gms.internal.ads.zzelr r35, com.google.android.gms.internal.ads.zzekt r36, com.google.android.gms.internal.ads.zzemx<?, ?> r37, com.google.android.gms.internal.ads.zzejo<?> r38, com.google.android.gms.internal.ads.zzelg r39) {
        /*
            Method dump skipped, instruction units count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zza(java.lang.Class, com.google.android.gms.internal.ads.zzelh, com.google.android.gms.internal.ads.zzelr, com.google.android.gms.internal.ads.zzekt, com.google.android.gms.internal.ads.zzemx, com.google.android.gms.internal.ads.zzejo, com.google.android.gms.internal.ads.zzelg):com.google.android.gms.internal.ads.zzeln");
    }

    private final int zzan(int i, int i2) {
        if (i < this.zzilq || i > this.zzilr) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zzilo.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzilo[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static zzena zzau(Object obj) {
        zzejz zzejzVar = (zzejz) obj;
        zzena zzenaVar = zzejzVar.zzijc;
        if (zzenaVar != zzena.zzbiv()) {
            return zzenaVar;
        }
        zzena zzenaVarZzbiw = zzena.zzbiw();
        zzejzVar.zzijc = zzenaVarZzbiw;
        return zzenaVarZzbiw;
    }

    private final void zzb(T t, T t2, int i) {
        int iZzhi = zzhi(i);
        int i2 = this.zzilo[i];
        long j = iZzhi & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzp = zzend.zzp(t, j);
            Object objZzp2 = zzend.zzp(t2, j);
            if (objZzp != null && objZzp2 != null) {
                zzend.zza(t, j, zzekb.zze(objZzp, objZzp2));
                zzb(t, i2, i);
            } else if (objZzp2 != null) {
                zzend.zza(t, j, objZzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze((Object) t, i) == zze((Object) t2, i);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzend.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzend.zzp(t, j)).doubleValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzend.zzp(t, j)).intValue();
    }

    private final zzemf zzhf(int i) {
        int i2 = (i / 3) << 1;
        zzemf zzemfVar = (zzemf) this.zzilp[i2];
        if (zzemfVar != null) {
            return zzemfVar;
        }
        zzemf<T> zzemfVarZzh = zzely.zzbic().zzh((Class) this.zzilp[i2 + 1]);
        this.zzilp[i2] = zzemfVarZzh;
        return zzemfVarZzh;
    }

    private final Object zzhg(int i) {
        return this.zzilp[(i / 3) << 1];
    }

    private final zzekg zzhh(int i) {
        return (zzekg) this.zzilp[((i / 3) << 1) + 1];
    }

    private final int zzhi(int i) {
        return this.zzilo[i + 1];
    }

    private final int zzhj(int i) {
        return this.zzilo[i + 2];
    }

    private static boolean zzhk(int i) {
        return (i & 536870912) != 0;
    }

    private final int zzhl(int i) {
        if (i < this.zzilq || i > this.zzilr) {
            return -1;
        }
        return zzao(i, 0);
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzend.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzend.zzp(t, j)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(T r10, T r11) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final int hashCode(T t) {
        int i;
        int iZzfr;
        int length = this.zzilo.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzhi = zzhi(i3);
            int i4 = this.zzilo[i3];
            long j = 1048575 & iZzhi;
            int iHashCode = 37;
            switch ((iZzhi & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(Double.doubleToLongBits(zzend.zzo(t, j)));
                    i2 = i + iZzfr;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzfr = Float.floatToIntBits(zzend.zzn(t, j));
                    i2 = i + iZzfr;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(zzend.zzl(t, j));
                    i2 = i + iZzfr;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(zzend.zzl(t, j));
                    i2 = i + iZzfr;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(zzend.zzl(t, j));
                    i2 = i + iZzfr;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzfr = zzekb.zzbu(zzend.zzm(t, j));
                    i2 = i + iZzfr;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzfr = ((String) zzend.zzp(t, j)).hashCode();
                    i2 = i + iZzfr;
                    break;
                case 9:
                    Object objZzp = zzend.zzp(t, j);
                    if (objZzp != null) {
                        iHashCode = objZzp.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzfr = zzend.zzp(t, j).hashCode();
                    i2 = i + iZzfr;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(zzend.zzl(t, j));
                    i2 = i + iZzfr;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzfr = zzend.zzk(t, j);
                    i2 = i + iZzfr;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzfr = zzekb.zzfr(zzend.zzl(t, j));
                    i2 = i + iZzfr;
                    break;
                case 17:
                    Object objZzp2 = zzend.zzp(t, j);
                    if (objZzp2 != null) {
                        iHashCode = objZzp2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZzfr = zzend.zzp(t, j).hashCode();
                    i2 = i + iZzfr;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzfr = zzend.zzp(t, j).hashCode();
                    i2 = i + iZzfr;
                    break;
                case 51:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(Double.doubleToLongBits(zzf(t, j)));
                        i2 = i + iZzfr;
                    }
                    break;
                case 52:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = Float.floatToIntBits(zzg(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 53:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(zzi(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 54:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(zzi(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 55:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 56:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(zzi(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 57:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 58:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzbu(zzj(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 59:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = ((String) zzend.zzp(t, j)).hashCode();
                        i2 = i + iZzfr;
                    }
                    break;
                case 60:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzend.zzp(t, j).hashCode();
                        i2 = i + iZzfr;
                    }
                    break;
                case 61:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzend.zzp(t, j).hashCode();
                        i2 = i + iZzfr;
                    }
                    break;
                case 62:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 63:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 64:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 65:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(zzi(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 66:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzh(t, j);
                        i2 = i + iZzfr;
                    }
                    break;
                case 67:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzekb.zzfr(zzi(t, j));
                        i2 = i + iZzfr;
                    }
                    break;
                case 68:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZzfr = zzend.zzp(t, j).hashCode();
                        i2 = i + iZzfr;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzimc.zzax(t).hashCode();
        return this.zzilt ? (iHashCode2 * 53) + this.zzimd.zzah(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final T newInstance() {
        return (T) this.zzima.newInstance(this.zzils);
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final void zzaj(T t) {
        int i;
        int i2 = this.zzily;
        while (true) {
            i = this.zzilz;
            if (i2 >= i) {
                break;
            }
            long jZzhi = zzhi(this.zzilx[i2]) & 1048575;
            Object objZzp = zzend.zzp(t, jZzhi);
            if (objZzp != null) {
                zzend.zza(t, jZzhi, this.zzime.zzar(objZzp));
            }
            i2++;
        }
        int length = this.zzilx.length;
        while (i < length) {
            this.zzimb.zzb(t, this.zzilx[i]);
            i++;
        }
        this.zzimc.zzaj(t);
        if (this.zzilt) {
            this.zzimd.zzaj(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:421:0x090c A[PHI: r5
      0x090c: PHI (r5v4 int) = 
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v13 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v14 int)
      (r5v1 int)
     binds: [B:257:0x0549, B:461:0x09ba, B:458:0x09b0, B:452:0x0994, B:449:0x0982, B:446:0x0973, B:443:0x0966, B:440:0x0959, B:436:0x094e, B:433:0x0943, B:430:0x0936, B:427:0x0929, B:424:0x0916, B:397:0x0822, B:391:0x0805, B:385:0x07e8, B:379:0x07cb, B:373:0x07ad, B:367:0x078f, B:361:0x0771, B:355:0x0753, B:349:0x0735, B:343:0x0717, B:337:0x06f9, B:331:0x06db, B:325:0x06bd, B:319:0x069f, B:314:0x066b, B:311:0x065e, B:308:0x064e, B:305:0x063e, B:302:0x062e, B:299:0x0620, B:296:0x0613, B:293:0x0607, B:287:0x05e9, B:284:0x05d5, B:281:0x05c3, B:278:0x05b3, B:275:0x05a3, B:438:0x0955, B:272:0x0596, B:269:0x0588, B:266:0x0578, B:263:0x0568, B:420:0x090b, B:260:0x0552] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzat(T r20) {
        /*
            Method dump skipped, instruction units count: 2978
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zzat(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.ads.zzemf] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzemf] */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzav(T r19) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zzav(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzemf
    public final void zzg(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzilo.length; i += 3) {
            int iZzhi = zzhi(i);
            long j = 1048575 & iZzhi;
            int i2 = this.zzilo[i];
            switch ((iZzhi & 267386880) >>> 20) {
                case 0:
                    if (zze((Object) t2, i)) {
                        zzend.zza(t, j, zzend.zzo(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 1:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzn(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 2:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzl(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 3:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzl(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 4:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 5:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzl(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 6:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 7:
                    if (zze((Object) t2, i)) {
                        zzend.zza(t, j, zzend.zzm(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 8:
                    if (zze((Object) t2, i)) {
                        zzend.zza(t, j, zzend.zzp(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zze((Object) t2, i)) {
                        zzend.zza(t, j, zzend.zzp(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 11:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 12:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 13:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 14:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzl(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 15:
                    if (zze((Object) t2, i)) {
                        zzend.zzb(t, j, zzend.zzk(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 16:
                    if (zze((Object) t2, i)) {
                        zzend.zza((Object) t, j, zzend.zzl(t2, j));
                        zzf((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzimb.zza(t, t2, j);
                    break;
                case 50:
                    zzemh.zza(this.zzime, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzend.zza(t, j, zzend.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzend.zza(t, j, zzend.zzp(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzemh.zza(this.zzimc, t, t2);
        if (this.zzilt) {
            zzemh.zza(this.zzimd, t, t2);
        }
    }

    private final boolean zze(T t, int i) {
        int iZzhj = zzhj(i);
        long j = iZzhj & 1048575;
        if (j != 1048575) {
            return (zzend.zzk(t, j) & (1 << (iZzhj >>> 20))) != 0;
        }
        int iZzhi = zzhi(i);
        long j2 = iZzhi & 1048575;
        switch ((iZzhi & 267386880) >>> 20) {
            case 0:
                return zzend.zzo(t, j2) != 0.0d;
            case 1:
                return zzend.zzn(t, j2) != WheelView.DividerConfig.FILL;
            case 2:
                return zzend.zzl(t, j2) != 0;
            case 3:
                return zzend.zzl(t, j2) != 0;
            case 4:
                return zzend.zzk(t, j2) != 0;
            case 5:
                return zzend.zzl(t, j2) != 0;
            case 6:
                return zzend.zzk(t, j2) != 0;
            case 7:
                return zzend.zzm(t, j2);
            case 8:
                Object objZzp = zzend.zzp(t, j2);
                if (objZzp instanceof String) {
                    return !((String) objZzp).isEmpty();
                }
                if (objZzp instanceof zzeip) {
                    return !zzeip.zzier.equals(objZzp);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzend.zzp(t, j2) != null;
            case 10:
                return !zzeip.zzier.equals(zzend.zzp(t, j2));
            case 11:
                return zzend.zzk(t, j2) != 0;
            case 12:
                return zzend.zzk(t, j2) != 0;
            case 13:
                return zzend.zzk(t, j2) != 0;
            case 14:
                return zzend.zzl(t, j2) != 0;
            case 15:
                return zzend.zzk(t, j2) != 0;
            case 16:
                return zzend.zzl(t, j2) != 0;
            case 17:
                return zzend.zzp(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzf(T t, int i) {
        int iZzhj = zzhj(i);
        long j = 1048575 & iZzhj;
        if (j == 1048575) {
            return;
        }
        zzend.zzb(t, j, (1 << (iZzhj >>> 20)) | zzend.zzk(t, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzb(T r18, com.google.android.gms.internal.ads.zzenu r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzenu):void");
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzend.zzp(t, j)).floatValue();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzhi = zzhi(i) & 1048575;
        if (zze((Object) t2, i)) {
            Object objZzp = zzend.zzp(t, jZzhi);
            Object objZzp2 = zzend.zzp(t2, jZzhi);
            if (objZzp != null && objZzp2 != null) {
                zzend.zza(t, jZzhi, zzekb.zze(objZzp, objZzp2));
                zzf((Object) t, i);
            } else if (objZzp2 != null) {
                zzend.zza(t, jZzhi, objZzp2);
                zzf((Object) t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzemx<UT, UB> zzemxVar, T t) {
        return zzemxVar.zzat(zzemxVar.zzax(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzenu r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zza(java.lang.Object, com.google.android.gms.internal.ads.zzenu):void");
    }

    private final void zzb(T t, int i, int i2) {
        zzend.zzb(t, zzhj(i2) & 1048575, i);
    }

    private final <K, V> void zza(zzenu zzenuVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzenuVar.zza(i, this.zzime.zzao(zzhg(i2)), this.zzime.zzap(obj));
        }
    }

    private static <UT, UB> void zza(zzemx<UT, UB> zzemxVar, T t, zzenu zzenuVar) throws IOException {
        zzemxVar.zza(zzemxVar.zzax(t), zzenuVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05cb A[LOOP:5: B:163:0x05c7->B:165:0x05cb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05d8  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r13, com.google.android.gms.internal.ads.zzelz r14, com.google.android.gms.internal.ads.zzejm r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zza(java.lang.Object, com.google.android.gms.internal.ads.zzelz, com.google.android.gms.internal.ads.zzejm):void");
    }

    private static int zza(byte[] bArr, int i, int i2, zzeno zzenoVar, Class<?> cls, zzeik zzeikVar) throws IOException {
        switch (zzelq.zzifq[zzenoVar.ordinal()]) {
            case 1:
                int iZzb = zzeil.zzb(bArr, i, zzeikVar);
                zzeikVar.zziem = Boolean.valueOf(zzeikVar.zziel != 0);
                return iZzb;
            case 2:
                return zzeil.zze(bArr, i, zzeikVar);
            case 3:
                zzeikVar.zziem = Double.valueOf(zzeil.zzj(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzeikVar.zziem = Integer.valueOf(zzeil.zzh(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzeikVar.zziem = Long.valueOf(zzeil.zzi(bArr, i));
                return i + 8;
            case 8:
                zzeikVar.zziem = Float.valueOf(zzeil.zzk(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzeil.zza(bArr, i, zzeikVar);
                zzeikVar.zziem = Integer.valueOf(zzeikVar.zziek);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzeil.zzb(bArr, i, zzeikVar);
                zzeikVar.zziem = Long.valueOf(zzeikVar.zziel);
                return iZzb2;
            case 14:
                return zzeil.zza(zzely.zzbic().zzh(cls), bArr, i, i2, zzeikVar);
            case 15:
                int iZza2 = zzeil.zza(bArr, i, zzeikVar);
                zzeikVar.zziem = Integer.valueOf(zzeja.zzgc(zzeikVar.zziek));
                return iZza2;
            case 16:
                int iZzb3 = zzeil.zzb(bArr, i, zzeikVar);
                zzeikVar.zziem = Long.valueOf(zzeja.zzfh(zzeikVar.zziel));
                return iZzb3;
            case 17:
                return zzeil.zzd(bArr, i, zzeikVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzeik zzeikVar) throws IOException {
        int iZza;
        int iZza2 = i;
        zzekk zzekkVarZzft = (zzekk) zzhsa.getObject(t, j2);
        if (!zzekkVarZzft.zzbeb()) {
            int size = zzekkVarZzft.size();
            zzekkVarZzft = zzekkVarZzft.zzft(size == 0 ? 10 : size << 1);
            zzhsa.putObject(t, j2, zzekkVarZzft);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzejk zzejkVar = (zzejk) zzekkVarZzft;
                    int iZza3 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i8 = zzeikVar.zziek + iZza3;
                    while (iZza3 < i8) {
                        zzejkVar.zze(zzeil.zzj(bArr, iZza3));
                        iZza3 += 8;
                    }
                    if (iZza3 == i8) {
                        return iZza3;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 1) {
                    zzejk zzejkVar2 = (zzejk) zzekkVarZzft;
                    zzejkVar2.zze(zzeil.zzj(bArr, i));
                    while (true) {
                        int i9 = iZza2 + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iZza2 = zzeil.zza(bArr, i9, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return i9;
                        }
                        zzejkVar2.zze(zzeil.zzj(bArr, iZza2));
                    }
                }
                return iZza2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzejy zzejyVar = (zzejy) zzekkVarZzft;
                    int iZza4 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i10 = zzeikVar.zziek + iZza4;
                    while (iZza4 < i10) {
                        zzejyVar.zzh(zzeil.zzk(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i10) {
                        return iZza4;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 5) {
                    zzejy zzejyVar2 = (zzejy) zzekkVarZzft;
                    zzejyVar2.zzh(zzeil.zzk(bArr, i));
                    while (true) {
                        int i11 = iZza2 + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iZza2 = zzeil.zza(bArr, i11, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return i11;
                        }
                        zzejyVar2.zzh(zzeil.zzk(bArr, iZza2));
                    }
                }
                return iZza2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzekx zzekxVar = (zzekx) zzekkVarZzft;
                    int iZza5 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i12 = zzeikVar.zziek + iZza5;
                    while (iZza5 < i12) {
                        iZza5 = zzeil.zzb(bArr, iZza5, zzeikVar);
                        zzekxVar.zzfs(zzeikVar.zziel);
                    }
                    if (iZza5 == i12) {
                        return iZza5;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 0) {
                    zzekx zzekxVar2 = (zzekx) zzekkVarZzft;
                    int iZzb = zzeil.zzb(bArr, iZza2, zzeikVar);
                    zzekxVar2.zzfs(zzeikVar.zziel);
                    while (iZzb < i2) {
                        int iZza6 = zzeil.zza(bArr, iZzb, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return iZzb;
                        }
                        iZzb = zzeil.zzb(bArr, iZza6, zzeikVar);
                        zzekxVar2.zzfs(zzeikVar.zziel);
                    }
                    return iZzb;
                }
                return iZza2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzeil.zza(bArr, iZza2, (zzekk<?>) zzekkVarZzft, zzeikVar);
                }
                if (i5 == 0) {
                    return zzeil.zza(i3, bArr, i, i2, (zzekk<?>) zzekkVarZzft, zzeikVar);
                }
                return iZza2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzekx zzekxVar3 = (zzekx) zzekkVarZzft;
                    int iZza7 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i13 = zzeikVar.zziek + iZza7;
                    while (iZza7 < i13) {
                        zzekxVar3.zzfs(zzeil.zzi(bArr, iZza7));
                        iZza7 += 8;
                    }
                    if (iZza7 == i13) {
                        return iZza7;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 1) {
                    zzekx zzekxVar4 = (zzekx) zzekkVarZzft;
                    zzekxVar4.zzfs(zzeil.zzi(bArr, i));
                    while (true) {
                        int i14 = iZza2 + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iZza2 = zzeil.zza(bArr, i14, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return i14;
                        }
                        zzekxVar4.zzfs(zzeil.zzi(bArr, iZza2));
                    }
                }
                return iZza2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzekc zzekcVar = (zzekc) zzekkVarZzft;
                    int iZza8 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i15 = zzeikVar.zziek + iZza8;
                    while (iZza8 < i15) {
                        zzekcVar.zzhc(zzeil.zzh(bArr, iZza8));
                        iZza8 += 4;
                    }
                    if (iZza8 == i15) {
                        return iZza8;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 5) {
                    zzekc zzekcVar2 = (zzekc) zzekkVarZzft;
                    zzekcVar2.zzhc(zzeil.zzh(bArr, i));
                    while (true) {
                        int i16 = iZza2 + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iZza2 = zzeil.zza(bArr, i16, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return i16;
                        }
                        zzekcVar2.zzhc(zzeil.zzh(bArr, iZza2));
                    }
                }
                return iZza2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzein zzeinVar = (zzein) zzekkVarZzft;
                    iZza = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i17 = zzeikVar.zziek + iZza;
                    while (iZza < i17) {
                        iZza = zzeil.zzb(bArr, iZza, zzeikVar);
                        zzeinVar.addBoolean(zzeikVar.zziel != 0);
                    }
                    if (iZza != i17) {
                        throw zzekj.zzbgx();
                    }
                    return iZza;
                }
                if (i5 == 0) {
                    zzein zzeinVar2 = (zzein) zzekkVarZzft;
                    iZza2 = zzeil.zzb(bArr, iZza2, zzeikVar);
                    zzeinVar2.addBoolean(zzeikVar.zziel != 0);
                    while (iZza2 < i2) {
                        int iZza9 = zzeil.zza(bArr, iZza2, zzeikVar);
                        if (i3 == zzeikVar.zziek) {
                            iZza2 = zzeil.zzb(bArr, iZza9, zzeikVar);
                            zzeinVar2.addBoolean(zzeikVar.zziel != 0);
                        }
                    }
                }
                return iZza2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        iZza2 = zzeil.zza(bArr, iZza2, zzeikVar);
                        int i18 = zzeikVar.zziek;
                        if (i18 < 0) {
                            throw zzekj.zzbgy();
                        }
                        if (i18 == 0) {
                            zzekkVarZzft.add("");
                        } else {
                            zzekkVarZzft.add(new String(bArr, iZza2, i18, zzekb.UTF_8));
                            iZza2 += i18;
                        }
                        while (iZza2 < i2) {
                            int iZza10 = zzeil.zza(bArr, iZza2, zzeikVar);
                            if (i3 == zzeikVar.zziek) {
                                iZza2 = zzeil.zza(bArr, iZza10, zzeikVar);
                                int i19 = zzeikVar.zziek;
                                if (i19 < 0) {
                                    throw zzekj.zzbgy();
                                }
                                if (i19 == 0) {
                                    zzekkVarZzft.add("");
                                } else {
                                    zzekkVarZzft.add(new String(bArr, iZza2, i19, zzekb.UTF_8));
                                    iZza2 += i19;
                                }
                            }
                        }
                    } else {
                        iZza2 = zzeil.zza(bArr, iZza2, zzeikVar);
                        int i20 = zzeikVar.zziek;
                        if (i20 < 0) {
                            throw zzekj.zzbgy();
                        }
                        if (i20 == 0) {
                            zzekkVarZzft.add("");
                        } else {
                            int i21 = iZza2 + i20;
                            if (zzeng.zzm(bArr, iZza2, i21)) {
                                zzekkVarZzft.add(new String(bArr, iZza2, i20, zzekb.UTF_8));
                                iZza2 = i21;
                            } else {
                                throw zzekj.zzbhf();
                            }
                        }
                        while (iZza2 < i2) {
                            int iZza11 = zzeil.zza(bArr, iZza2, zzeikVar);
                            if (i3 == zzeikVar.zziek) {
                                iZza2 = zzeil.zza(bArr, iZza11, zzeikVar);
                                int i22 = zzeikVar.zziek;
                                if (i22 < 0) {
                                    throw zzekj.zzbgy();
                                }
                                if (i22 == 0) {
                                    zzekkVarZzft.add("");
                                } else {
                                    int i23 = iZza2 + i22;
                                    if (zzeng.zzm(bArr, iZza2, i23)) {
                                        zzekkVarZzft.add(new String(bArr, iZza2, i22, zzekb.UTF_8));
                                        iZza2 = i23;
                                    } else {
                                        throw zzekj.zzbhf();
                                    }
                                }
                            }
                        }
                    }
                }
                return iZza2;
            case 27:
                if (i5 == 2) {
                    return zzeil.zza(zzhf(i6), i3, bArr, i, i2, zzekkVarZzft, zzeikVar);
                }
                return iZza2;
            case 28:
                if (i5 == 2) {
                    int iZza12 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i24 = zzeikVar.zziek;
                    if (i24 >= 0) {
                        if (i24 > bArr.length - iZza12) {
                            throw zzekj.zzbgx();
                        }
                        if (i24 == 0) {
                            zzekkVarZzft.add(zzeip.zzier);
                        } else {
                            zzekkVarZzft.add(zzeip.zzi(bArr, iZza12, i24));
                            iZza12 += i24;
                        }
                        while (iZza12 < i2) {
                            int iZza13 = zzeil.zza(bArr, iZza12, zzeikVar);
                            if (i3 != zzeikVar.zziek) {
                                return iZza12;
                            }
                            iZza12 = zzeil.zza(bArr, iZza13, zzeikVar);
                            int i25 = zzeikVar.zziek;
                            if (i25 >= 0) {
                                if (i25 > bArr.length - iZza12) {
                                    throw zzekj.zzbgx();
                                }
                                if (i25 == 0) {
                                    zzekkVarZzft.add(zzeip.zzier);
                                } else {
                                    zzekkVarZzft.add(zzeip.zzi(bArr, iZza12, i25));
                                    iZza12 += i25;
                                }
                            } else {
                                throw zzekj.zzbgy();
                            }
                        }
                        return iZza12;
                    }
                    throw zzekj.zzbgy();
                }
                return iZza2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzeil.zza(i3, bArr, i, i2, (zzekk<?>) zzekkVarZzft, zzeikVar);
                    }
                    return iZza2;
                }
                iZza = zzeil.zza(bArr, iZza2, (zzekk<?>) zzekkVarZzft, zzeikVar);
                zzejz zzejzVar = (zzejz) t;
                zzena zzenaVar = zzejzVar.zzijc;
                if (zzenaVar == zzena.zzbiv()) {
                    zzenaVar = null;
                }
                zzena zzenaVar2 = (zzena) zzemh.zza(i4, zzekkVarZzft, zzhh(i6), zzenaVar, this.zzimc);
                if (zzenaVar2 != null) {
                    zzejzVar.zzijc = zzenaVar2;
                }
                return iZza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzekc zzekcVar3 = (zzekc) zzekkVarZzft;
                    int iZza14 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i26 = zzeikVar.zziek + iZza14;
                    while (iZza14 < i26) {
                        iZza14 = zzeil.zza(bArr, iZza14, zzeikVar);
                        zzekcVar3.zzhc(zzeja.zzgc(zzeikVar.zziek));
                    }
                    if (iZza14 == i26) {
                        return iZza14;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 0) {
                    zzekc zzekcVar4 = (zzekc) zzekkVarZzft;
                    int iZza15 = zzeil.zza(bArr, iZza2, zzeikVar);
                    zzekcVar4.zzhc(zzeja.zzgc(zzeikVar.zziek));
                    while (iZza15 < i2) {
                        int iZza16 = zzeil.zza(bArr, iZza15, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return iZza15;
                        }
                        iZza15 = zzeil.zza(bArr, iZza16, zzeikVar);
                        zzekcVar4.zzhc(zzeja.zzgc(zzeikVar.zziek));
                    }
                    return iZza15;
                }
                return iZza2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzekx zzekxVar5 = (zzekx) zzekkVarZzft;
                    int iZza17 = zzeil.zza(bArr, iZza2, zzeikVar);
                    int i27 = zzeikVar.zziek + iZza17;
                    while (iZza17 < i27) {
                        iZza17 = zzeil.zzb(bArr, iZza17, zzeikVar);
                        zzekxVar5.zzfs(zzeja.zzfh(zzeikVar.zziel));
                    }
                    if (iZza17 == i27) {
                        return iZza17;
                    }
                    throw zzekj.zzbgx();
                }
                if (i5 == 0) {
                    zzekx zzekxVar6 = (zzekx) zzekkVarZzft;
                    int iZzb2 = zzeil.zzb(bArr, iZza2, zzeikVar);
                    zzekxVar6.zzfs(zzeja.zzfh(zzeikVar.zziel));
                    while (iZzb2 < i2) {
                        int iZza18 = zzeil.zza(bArr, iZzb2, zzeikVar);
                        if (i3 != zzeikVar.zziek) {
                            return iZzb2;
                        }
                        iZzb2 = zzeil.zzb(bArr, iZza18, zzeikVar);
                        zzekxVar6.zzfs(zzeja.zzfh(zzeikVar.zziel));
                    }
                    return iZzb2;
                }
                return iZza2;
            case 49:
                if (i5 == 3) {
                    zzemf zzemfVarZzhf = zzhf(i6);
                    int i28 = (i3 & (-8)) | 4;
                    iZza2 = zzeil.zza(zzemfVarZzhf, bArr, i, i2, i28, zzeikVar);
                    zzekkVarZzft.add(zzeikVar.zziem);
                    while (iZza2 < i2) {
                        int iZza19 = zzeil.zza(bArr, iZza2, zzeikVar);
                        if (i3 == zzeikVar.zziek) {
                            iZza2 = zzeil.zza(zzemfVarZzhf, bArr, iZza19, i2, i28, zzeikVar);
                            zzekkVarZzft.add(zzeikVar.zziem);
                        }
                    }
                }
                return iZza2;
            default:
                return iZza2;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzeik zzeikVar) throws IOException {
        Unsafe unsafe = zzhsa;
        Object objZzhg = zzhg(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzime.zzaq(object)) {
            Object objZzas = this.zzime.zzas(objZzhg);
            this.zzime.zzf(objZzas, object);
            unsafe.putObject(t, j, objZzas);
            object = objZzas;
        }
        zzele<?, ?> zzeleVarZzao = this.zzime.zzao(objZzhg);
        Map<?, ?> mapZzan = this.zzime.zzan(object);
        int iZza = zzeil.zza(bArr, i, zzeikVar);
        int i4 = zzeikVar.zziek;
        if (i4 >= 0 && i4 <= i2 - iZza) {
            int i5 = i4 + iZza;
            K k = zzeleVarZzao.zzilj;
            V v = zzeleVarZzao.zzclg;
            while (iZza < i5) {
                int iZza2 = iZza + 1;
                int i6 = bArr[iZza];
                if (i6 < 0) {
                    iZza2 = zzeil.zza(i6, bArr, iZza2, zzeikVar);
                    i6 = zzeikVar.zziek;
                }
                int i7 = iZza2;
                int i8 = i6 >>> 3;
                int i9 = i6 & 7;
                if (i8 != 1) {
                    if (i8 == 2 && i9 == zzeleVarZzao.zzilk.zzbjf()) {
                        iZza = zza(bArr, i7, i2, zzeleVarZzao.zzilk, zzeleVarZzao.zzclg.getClass(), zzeikVar);
                        v = zzeikVar.zziem;
                    } else {
                        iZza = zzeil.zza(i6, bArr, i7, i2, zzeikVar);
                    }
                } else if (i9 == zzeleVarZzao.zzili.zzbjf()) {
                    iZza = zza(bArr, i7, i2, zzeleVarZzao.zzili, (Class<?>) null, zzeikVar);
                    k = (K) zzeikVar.zziem;
                } else {
                    iZza = zzeil.zza(i6, bArr, i7, i2, zzeikVar);
                }
            }
            if (iZza == i5) {
                mapZzan.put(k, v);
                return i5;
            }
            throw zzekj.zzbhe();
        }
        throw zzekj.zzbgx();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzeik zzeikVar) throws IOException {
        int iZzb;
        Unsafe unsafe = zzhsa;
        long j2 = this.zzilo[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(zzeil.zzj(bArr, i)));
                iZzb = i + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(zzeil.zzk(bArr, i)));
                iZzb = i + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzeil.zzb(bArr, i, zzeikVar);
                unsafe.putObject(t, j, Long.valueOf(zzeikVar.zziel));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzeil.zza(bArr, i, zzeikVar);
                unsafe.putObject(t, j, Integer.valueOf(zzeikVar.zziek));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(zzeil.zzi(bArr, i)));
                iZzb = i + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzeil.zzh(bArr, i)));
                iZzb = i + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzeil.zzb(bArr, i, zzeikVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzeikVar.zziel != 0));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzeil.zza(bArr, i, zzeikVar);
                int i9 = zzeikVar.zziek;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzeng.zzm(bArr, iZza, iZza + i9)) {
                        throw zzekj.zzbhf();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i9, zzekb.UTF_8));
                    iZza += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zzeil.zza(zzhf(i8), bArr, i, i2, zzeikVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzeikVar.zziem);
                } else {
                    unsafe.putObject(t, j, zzekb.zze(object, zzeikVar.zziem));
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iZzb = zzeil.zze(bArr, i, zzeikVar);
                unsafe.putObject(t, j, zzeikVar.zziem);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza3 = zzeil.zza(bArr, i, zzeikVar);
                int i10 = zzeikVar.zziek;
                zzekg zzekgVarZzhh = zzhh(i8);
                if (zzekgVarZzhh != null && !zzekgVarZzhh.zzi(i10)) {
                    zzau(t).zzd(i3, Long.valueOf(i10));
                    return iZza3;
                }
                unsafe.putObject(t, j, Integer.valueOf(i10));
                iZzb = iZza3;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzeil.zza(bArr, i, zzeikVar);
                unsafe.putObject(t, j, Integer.valueOf(zzeja.zzgc(zzeikVar.zziek)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzeil.zzb(bArr, i, zzeikVar);
                unsafe.putObject(t, j, Long.valueOf(zzeja.zzfh(zzeikVar.zziel)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iZzb = zzeil.zza(zzhf(i8), bArr, i, i2, (i3 & (-8)) | 4, zzeikVar);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, zzeikVar.zziem);
                } else {
                    unsafe.putObject(t, j, zzekb.zze(object2, zzeikVar.zziem));
                }
                unsafe.putInt(t, j2, i4);
                return iZzb;
            default:
                return i;
        }
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.ads.zzeik r33) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzeik):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0302, code lost:
    
        if (r0 == r5) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0306, code lost:
    
        r15 = r31;
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r11 = r36;
        r2 = r20;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x034b, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x036e, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0370, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0099. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzemf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.ads.zzeik r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeln.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeik):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzemx<UT, UB> zzemxVar) {
        zzekg zzekgVarZzhh;
        int i2 = this.zzilo[i];
        Object objZzp = zzend.zzp(obj, zzhi(i) & 1048575);
        return (objZzp == null || (zzekgVarZzhh = zzhh(i)) == null) ? ub : (UB) zza(i, i2, this.zzime.zzan(objZzp), zzekgVarZzhh, ub, zzemxVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzekg zzekgVar, UB ub, zzemx<UT, UB> zzemxVar) {
        zzele<?, ?> zzeleVarZzao = this.zzime.zzao(zzhg(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzekgVar.zzi(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzemxVar.zzbiu();
                }
                zzeix zzeixVarZzfw = zzeip.zzfw(zzelb.zza(zzeleVarZzao, next.getKey(), next.getValue()));
                try {
                    zzelb.zza(zzeixVarZzfw.zzbeo(), zzeleVarZzao, next.getKey(), next.getValue());
                    zzemxVar.zza(ub, i2, zzeixVarZzfw.zzben());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzemf zzemfVar) {
        return zzemfVar.zzav(zzend.zzp(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzenu zzenuVar) throws IOException {
        if (obj instanceof String) {
            zzenuVar.zzi(i, (String) obj);
        } else {
            zzenuVar.zza(i, (zzeip) obj);
        }
    }

    private final void zza(Object obj, int i, zzelz zzelzVar) throws IOException {
        if (zzhk(i)) {
            zzend.zza(obj, i & 1048575, zzelzVar.zzbew());
        } else if (this.zzilu) {
            zzend.zza(obj, i & 1048575, zzelzVar.readString());
        } else {
            zzend.zza(obj, i & 1048575, zzelzVar.zzbex());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zze((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i, int i2) {
        return zzend.zzk(t, (long) (zzhj(i2) & 1048575)) == i;
    }
}
