package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzclb implements zzeoy<zzts> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzua.zza.EnumC0120zza> zzfow;
    private final zzeph<String> zzfuc;
    private final zzeph<zzbbx> zzfup;
    private final zzeph<String> zzggd;

    private zzclb(zzeph<Context> zzephVar, zzeph<String> zzephVar2, zzeph<zzbbx> zzephVar3, zzeph<zzua.zza.EnumC0120zza> zzephVar4, zzeph<String> zzephVar5) {
        this.zzesu = zzephVar;
        this.zzfuc = zzephVar2;
        this.zzfup = zzephVar3;
        this.zzfow = zzephVar4;
        this.zzggd = zzephVar5;
    }

    public static zzclb zze(zzeph<Context> zzephVar, zzeph<String> zzephVar2, zzeph<zzbbx> zzephVar3, zzeph<zzua.zza.EnumC0120zza> zzephVar4, zzeph<String> zzephVar5) {
        return new zzclb(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Context context = this.zzesu.get();
        final String str = this.zzfuc.get();
        zzbbx zzbbxVar = this.zzfup.get();
        final zzua.zza.EnumC0120zza enumC0120zza = this.zzfow.get();
        final String str2 = this.zzggd.get();
        zzts zztsVar = new zzts(new zztx(context));
        final zzua.zzu zzuVar = (zzua.zzu) zzua.zzu.zzot().zzcq(zzbbxVar.zzeel).zzcr(zzbbxVar.zzeem).zzcs(zzbbxVar.zzeen ? 0 : 2).zzbgt();
        zztsVar.zza(new zztr(enumC0120zza, str, zzuVar, str2) { // from class: com.google.android.gms.internal.ads.zzclc
            private final String zzdgm;
            private final zzua.zza.EnumC0120zza zzgge;
            private final zzua.zzu zzggf;
            private final String zzggg;

            {
                this.zzgge = enumC0120zza;
                this.zzdgm = str;
                this.zzggf = zzuVar;
                this.zzggg = str2;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzua.zza.EnumC0120zza enumC0120zza2 = this.zzgge;
                String str3 = this.zzdgm;
                zzua.zzu zzuVar2 = this.zzggf;
                zzaVar.zza(zzaVar.zznz().zzbgg().zzb(enumC0120zza2)).zza(zzaVar.zzny().zzbgg().zzbz(str3).zza(zzuVar2)).zzcb(this.zzggg);
            }
        });
        zzepe.zza(zztsVar, "Cannot return null from a non-@Nullable @Provides method");
        return zztsVar;
    }
}
