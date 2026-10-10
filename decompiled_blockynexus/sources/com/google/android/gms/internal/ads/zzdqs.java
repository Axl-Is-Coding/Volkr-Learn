package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqo;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdqs<AdT extends zzbqo> {
    private final zzdpz zzhbu;
    private final zzdpw zzhiy;
    private zzdqy zzhiz;
    private zzdzj<zzdqk<AdT>> zzhja;
    private zzdzc<zzdqk<AdT>> zzhjb;
    private final zzdqv<AdT> zzhjd;
    private int zzhjc = zzdqi.zzhim;
    private final zzdyr<zzdqk<AdT>> zzhjf = new zzdqt(this);
    private final LinkedList<zzdqy> zzhje = new LinkedList<>();

    public zzdqs(zzdpz zzdpzVar, zzdpw zzdpwVar, zzdqv<AdT> zzdqvVar) {
        this.zzhbu = zzdpzVar;
        this.zzhiy = zzdpwVar;
        this.zzhjd = zzdqvVar;
        this.zzhiy.zza(new zzdpv(this) { // from class: com.google.android.gms.internal.ads.zzdqu
            private final zzdqs zzhix;

            {
                this.zzhix = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdpv
            public final void execute() {
                this.zzhix.zzaut();
            }
        });
    }

    private final boolean zzaus() {
        zzdzc<zzdqk<AdT>> zzdzcVar = this.zzhjb;
        return zzdzcVar == null || zzdzcVar.isDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(zzdqy zzdqyVar) {
        while (zzaus()) {
            if (zzdqyVar == null && this.zzhje.isEmpty()) {
                return;
            }
            if (zzdqyVar == null) {
                zzdqyVar = this.zzhje.remove();
            }
            if (zzdqyVar.zzasx() != null && this.zzhbu.zzb(zzdqyVar.zzasx())) {
                this.zzhiz = zzdqyVar.zzasy();
                this.zzhja = zzdzj.zzayi();
                this.zzhjb = this.zzhjd.zza(this.zzhiz);
                zzdyq.zza(this.zzhjb, this.zzhjf, zzdqyVar.getExecutor());
                return;
            }
            zzdqyVar = null;
        }
        if (zzdqyVar != null) {
            this.zzhje.add(zzdqyVar);
        }
    }

    final /* synthetic */ void zzaut() {
        synchronized (this) {
            zzd(this.zzhiz);
        }
    }

    public final void zzb(zzdqy zzdqyVar) {
        this.zzhje.add(zzdqyVar);
    }

    public final synchronized zzdzc<zzdqw<AdT>> zzc(zzdqy zzdqyVar) {
        if (zzaus()) {
            return null;
        }
        this.zzhjc = zzdqi.zzhio;
        if (this.zzhiz.zzasx() != null && zzdqyVar.zzasx() != null && this.zzhiz.zzasx().equals(zzdqyVar.zzasx())) {
            this.zzhjc = zzdqi.zzhin;
            return zzdyq.zzb(this.zzhja, new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzdqr
                private final zzdqs zzhix;

                {
                    this.zzhix = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return this.zzhix.zzc((zzdqk) obj);
                }
            }, zzdqyVar.getExecutor());
        }
        return null;
    }

    final /* synthetic */ zzdzc zzc(zzdqk zzdqkVar) throws Exception {
        zzdzc zzdzcVarZzaf;
        synchronized (this) {
            zzdzcVarZzaf = zzdyq.zzaf(new zzdqw(zzdqkVar, this.zzhiz));
        }
        return zzdzcVarZzaf;
    }
}
