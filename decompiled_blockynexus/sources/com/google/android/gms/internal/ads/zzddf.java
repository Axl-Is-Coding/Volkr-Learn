package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import io.rong.common.LibStorageUtils;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddf implements zzdgx<zzddc> {
    private final zzdzb zzgcz;
    private final Context zzvr;

    public zzddf(zzdzb zzdzbVar, Context context) {
        this.zzgcz = zzdzbVar;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzddc> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdde
            private final zzddf zzgwc;

            {
                this.zzgwc = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwc.zzarn();
            }
        });
    }

    final /* synthetic */ zzddc zzarn() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzvr.getSystemService(LibStorageUtils.AUDIO);
        return new zzddc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), com.google.android.gms.ads.internal.zzp.zzkw().zzqg(), com.google.android.gms.ads.internal.zzp.zzkw().zzqh());
    }
}
