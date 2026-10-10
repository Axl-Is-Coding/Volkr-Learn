package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfi implements Iterable<zzbfg> {
    private final List<zzbfg> zzell = new ArrayList();

    public static boolean zzc(zzbdu zzbduVar) {
        zzbfg zzbfgVarZzd = zzd(zzbduVar);
        if (zzbfgVarZzd == null) {
            return false;
        }
        zzbfgVarZzd.zzelk.abort();
        return true;
    }

    static zzbfg zzd(zzbdu zzbduVar) {
        for (zzbfg zzbfgVar : com.google.android.gms.ads.internal.zzp.zzln()) {
            if (zzbfgVar.zzegh == zzbduVar) {
                return zzbfgVar;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbfg> iterator() {
        return this.zzell.iterator();
    }

    public final void zza(zzbfg zzbfgVar) {
        this.zzell.add(zzbfgVar);
    }

    public final void zzb(zzbfg zzbfgVar) {
        this.zzell.remove(zzbfgVar);
    }
}
