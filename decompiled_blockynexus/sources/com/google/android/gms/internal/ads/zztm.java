package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zztm implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zztk zzbvl;
    private final /* synthetic */ zzte zzbvr;
    private final /* synthetic */ zzbcg zzbvs;

    zztm(zztk zztkVar, zzte zzteVar, zzbcg zzbcgVar) {
        this.zzbvl = zztkVar;
        this.zzbvr = zzteVar;
        this.zzbvs = zzbcgVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbvl.lock) {
            if (this.zzbvl.zzbvm) {
                return;
            }
            zztk.zza(this.zzbvl, true);
            final zztb zztbVar = this.zzbvl.zzbvb;
            if (zztbVar == null) {
                return;
            }
            zzdzb zzdzbVar = zzbbz.zzeep;
            final zzte zzteVar = this.zzbvr;
            final zzbcg zzbcgVar = this.zzbvs;
            final zzdzc<?> zzdzcVarSubmit = zzdzbVar.submit(new Runnable(this, zztbVar, zzteVar, zzbcgVar) { // from class: com.google.android.gms.internal.ads.zztl
                private final zztm zzbvn;
                private final zztb zzbvo;
                private final zzte zzbvp;
                private final zzbcg zzbvq;

                {
                    this.zzbvn = this;
                    this.zzbvo = zztbVar;
                    this.zzbvp = zzteVar;
                    this.zzbvq = zzbcgVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zztm zztmVar = this.zzbvn;
                    zztb zztbVar2 = this.zzbvo;
                    zzte zzteVar2 = this.zzbvp;
                    zzbcg zzbcgVar2 = this.zzbvq;
                    try {
                        zzsz zzszVarZza = zztbVar2.zzmz().zza(zzteVar2);
                        if (!zzszVarZza.zzmw()) {
                            zzbcgVar2.setException(new RuntimeException("No entry contents."));
                            zztmVar.zzbvl.disconnect();
                            return;
                        }
                        zztn zztnVar = new zztn(zztmVar, zzszVarZza.zzmx(), 1);
                        int i = zztnVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zztnVar.unread(i);
                        zzbcgVar2.set(zztnVar);
                    } catch (RemoteException | IOException e2) {
                        zzbbq.zzc("Unable to obtain a cache service instance.", e2);
                        zzbcgVar2.setException(e2);
                        zztmVar.zzbvl.disconnect();
                    }
                }
            });
            zzbcg zzbcgVar2 = this.zzbvs;
            final zzbcg zzbcgVar3 = this.zzbvs;
            zzbcgVar2.addListener(new Runnable(zzbcgVar3, zzdzcVarSubmit) { // from class: com.google.android.gms.internal.ads.zzto
                private final zzbcg zzbvu;
                private final Future zzbvv;

                {
                    this.zzbvu = zzbcgVar3;
                    this.zzbvv = zzdzcVarSubmit;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbcg zzbcgVar4 = this.zzbvu;
                    Future future = this.zzbvv;
                    if (zzbcgVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbbz.zzeeu);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
