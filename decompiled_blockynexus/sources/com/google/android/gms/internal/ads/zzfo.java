package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfo extends zzgm {
    private static final zzgl<zzcy> zzaax = new zzgl<>();
    private final Context zzaav;
    private zzby.zza zzaay;

    public zzfo(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2, Context context, zzby.zza zzaVar) {
        super(zzexVar, str, str2, c0108zza, i, 27);
        this.zzaay = null;
        this.zzaav = context;
        this.zzaay = zzaVar;
    }

    private static String zza(zzby.zza zzaVar) {
        if (zzaVar == null || !zzaVar.zzz() || zzfg.zzas(zzaVar.zzaa().zzaf())) {
            return null;
        }
        return zzaVar.zzaa().zzaf();
    }

    private final String zzcx() {
        try {
            if (this.zzwg.zzcp() != null) {
                this.zzwg.zzcp().get();
            }
            zzcf.zza zzaVarZzco = this.zzwg.zzco();
            if (zzaVarZzco == null || !zzaVarZzco.zzaj()) {
                return null;
            }
            return zzaVarZzco.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        zzcy zzcyVar;
        zzcb zzcbVar;
        AtomicReference<zzcy> atomicReferenceZzat = zzaax.zzat(this.zzaav.getPackageName());
        synchronized (atomicReferenceZzat) {
            zzcy zzcyVar2 = atomicReferenceZzat.get();
            if (zzcyVar2 == null || zzfg.zzas(zzcyVar2.zznw) || zzcyVar2.zznw.equals("E") || zzcyVar2.zznw.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzfg.zzas(zza(this.zzaay))) {
                    zzby.zza zzaVar = this.zzaay;
                    zzcbVar = (Boolean.valueOf(zzfg.zzas(zza(zzaVar)) && zzaVar != null && zzaVar.zzx() && zzaVar.zzy().zzac() == zzcb.ENUM_SIGNAL_SOURCE_GASS).booleanValue() && this.zzwg.zzcm()) ? zzcb.ENUM_SIGNAL_SOURCE_GASS : zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD;
                } else {
                    zzcbVar = zzcb.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                }
                Method method = this.zzabm;
                Object[] objArr = new Object[3];
                objArr[0] = this.zzaav;
                objArr[1] = Boolean.valueOf(zzcbVar == zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD);
                objArr[2] = zzwm.zzpx().zzd(zzabb.zzcrb);
                zzcy zzcyVar3 = new zzcy((String) method.invoke(null, objArr));
                if (zzfg.zzas(zzcyVar3.zznw) || zzcyVar3.zznw.equals("E")) {
                    int i = zzfn.zzaaw[zzcbVar.ordinal()];
                    if (i == 1) {
                        zzcyVar3.zznw = this.zzaay.zzaa().zzaf();
                    } else if (i == 2) {
                        String strZzcx = zzcx();
                        if (!zzfg.zzas(strZzcx)) {
                            zzcyVar3.zznw = strZzcx;
                        }
                    }
                }
                atomicReferenceZzat.set(zzcyVar3);
            }
            zzcyVar = atomicReferenceZzat.get();
        }
        synchronized (this.zzabc) {
            if (zzcyVar != null) {
                this.zzabc.zzw(zzcyVar.zznw);
                this.zzabc.zzt(zzcyVar.zznx);
                this.zzabc.zzy(zzcyVar.zzny);
                this.zzabc.zzz(zzcyVar.zznz);
                this.zzabc.zzaa(zzcyVar.zzoa);
            }
        }
    }
}
