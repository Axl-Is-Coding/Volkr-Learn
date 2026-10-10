package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaik implements zzx {
    private volatile zzahz zzdfx;
    private final Context zzvr;

    public zzaik(Context context) {
        this.zzvr = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdfx == null) {
            return;
        }
        this.zzdfx.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzx
    public final zzy zzc(zzaa<?> zzaaVar) throws zzao {
        zzaic zzaicVarZzh = zzaic.zzh(zzaaVar);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
        try {
            zzbcg zzbcgVar = new zzbcg();
            this.zzdfx = new zzahz(this.zzvr, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), new zzaio(this, zzbcgVar), new zzain(this, zzbcgVar));
            this.zzdfx.checkAvailabilityAndConnect();
            zzdzc zzdzcVarZza = zzdyq.zza(zzdyq.zzb(zzbcgVar, new zzaij(this, zzaicVarZzh), zzbbz.zzeep), ((Integer) zzwm.zzpx().zzd(zzabb.zzcti)).intValue(), TimeUnit.MILLISECONDS, zzbbz.zzees);
            zzdzcVarZza.addListener(new zzail(this), zzbbz.zzeep);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzdzcVarZza.get();
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(jElapsedRealtime2);
            sb.append("ms");
            zzayp.zzei(sb.toString());
            zzaie zzaieVar = (zzaie) new zzatb(parcelFileDescriptor).zza(zzaie.CREATOR);
            if (zzaieVar == null) {
                return null;
            }
            if (zzaieVar.zzdfv) {
                throw new zzao(zzaieVar.zzcgw);
            }
            if (zzaieVar.zzdft.length != zzaieVar.zzdfu.length) {
                return null;
            }
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                String[] strArr = zzaieVar.zzdft;
                if (i >= strArr.length) {
                    return new zzy(zzaieVar.statusCode, zzaieVar.data, map, zzaieVar.zzan, zzaieVar.zzao);
                }
                map.put(strArr[i], zzaieVar.zzdfu[i]);
                i++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(jElapsedRealtime3);
            sb2.append("ms");
            zzayp.zzei(sb2.toString());
            return null;
        } catch (Throwable th) {
            long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(jElapsedRealtime4);
            sb3.append("ms");
            zzayp.zzei(sb3.toString());
            throw th;
        }
    }
}
