package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbam extends zzaa<zzy> {
    private final Map<String, String> zzam;
    private final zzbcg<zzy> zzecx;
    private final zzbbk zzecy;

    public zzbam(String str, zzbcg<zzy> zzbcgVar) {
        this(str, null, zzbcgVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzaa
    protected final zzaj<zzy> zza(zzy zzyVar) {
        return zzaj.zza(zzyVar, zzbc.zzb(zzyVar));
    }

    private zzbam(String str, Map<String, String> map, zzbcg<zzy> zzbcgVar) {
        super(0, str, new zzbap(zzbcgVar));
        this.zzam = null;
        this.zzecx = zzbcgVar;
        this.zzecy = new zzbbk();
        this.zzecy.zza(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    protected final /* synthetic */ void zza(zzy zzyVar) {
        zzy zzyVar2 = zzyVar;
        this.zzecy.zza(zzyVar2.zzam, zzyVar2.statusCode);
        zzbbk zzbbkVar = this.zzecy;
        byte[] bArr = zzyVar2.data;
        if (zzbbk.isEnabled() && bArr != null) {
            zzbbkVar.zzi(bArr);
        }
        this.zzecx.set(zzyVar2);
    }
}
