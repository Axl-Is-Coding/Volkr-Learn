package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzccu implements zzbqp<zzbqu> {
    private final zzcep zzfqc;
    private final Map<String, zzcta<zzbqu>> zzfrw;
    private final zzeph<zzbqp<zzboq>> zzfxh;
    private final Map<String, zzcta<zzcdx>> zzfxi;
    private final Map<String, zzcvl<zzcdx>> zzfxj;

    zzccu(Map<String, zzcta<zzbqu>> map, Map<String, zzcta<zzcdx>> map2, Map<String, zzcvl<zzcdx>> map3, zzeph<zzbqp<zzboq>> zzephVar, zzcep zzcepVar) {
        this.zzfrw = map;
        this.zzfxi = map2;
        this.zzfxj = map3;
        this.zzfxh = zzephVar;
        this.zzfqc = zzcepVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqp
    public final zzcta<zzbqu> zze(int i, String str) {
        zzcta<zzboq> zzctaVarZze;
        zzcta<zzbqu> zzctaVar = this.zzfrw.get(str);
        if (zzctaVar != null) {
            return zzctaVar;
        }
        if (i == 1) {
            if (this.zzfqc.zzams() == null || (zzctaVarZze = this.zzfxh.get().zze(i, str)) == null) {
                return null;
            }
            return zzbqu.zza(zzctaVarZze);
        }
        if (i != 4) {
            return null;
        }
        zzcvl<zzcdx> zzcvlVar = this.zzfxj.get(str);
        if (zzcvlVar != null) {
            return zzbqu.zza((zzcvl<? extends zzbqo>) zzcvlVar);
        }
        zzcta<zzcdx> zzctaVar2 = this.zzfxi.get(str);
        if (zzctaVar2 != null) {
            return zzbqu.zza(zzctaVar2);
        }
        return null;
    }
}
