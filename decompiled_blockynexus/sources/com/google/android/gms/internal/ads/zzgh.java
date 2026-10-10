package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgh extends zzgm {
    private final View zzaat;

    public zzgh(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2, View view) {
        super(zzexVar, str, str2, c0108zza, i, 57);
        this.zzaat = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaat != null) {
            Boolean bool = (Boolean) zzwm.zzpx().zzd(zzabb.zzcrl);
            zzff zzffVar = new zzff((String) this.zzabm.invoke(null, this.zzaat, this.zzwg.getContext().getResources().getDisplayMetrics(), bool));
            zzcf.zza.zzf.C0110zza c0110zzaZzax = zzcf.zza.zzf.zzax();
            c0110zzaZzax.zzcy(zzffVar.zzaab.longValue()).zzcz(zzffVar.zzaac.longValue()).zzda(zzffVar.zzaad.longValue());
            if (bool.booleanValue()) {
                c0110zzaZzax.zzdb(zzffVar.zzaae.longValue());
            }
            this.zzabc.zza((zzcf.zza.zzf) c0110zzaZzax.zzbgt());
        }
    }
}
