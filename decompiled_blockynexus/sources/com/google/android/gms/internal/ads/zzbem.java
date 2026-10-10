package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbem implements zzom {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzekd;
    private final zzom zzeke;
    private final zzpa<zzom> zzekf;
    private final zzbep zzekg;
    private final Context zzvr;

    public zzbem(Context context, zzom zzomVar, zzpa<zzom> zzpaVar, zzbep zzbepVar) {
        this.zzvr = context;
        this.zzeke = zzomVar;
        this.zzekf = zzpaVar;
        this.zzekg = zzbepVar;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        if (!this.isOpen) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.isOpen = false;
        this.uri = null;
        InputStream inputStream = this.zzekd;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzekd = null;
        } else {
            this.zzeke.close();
        }
        zzpa<zzom> zzpaVar = this.zzekf;
        if (zzpaVar != null) {
            zzpaVar.zze(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.isOpen) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzekd;
        int i3 = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzeke.read(bArr, i, i2);
        zzpa<zzom> zzpaVar = this.zzekf;
        if (zzpaVar != null) {
            zzpaVar.zzc(this, i3);
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzonVar) throws IOException {
        Long l;
        zzon zzonVar2 = zzonVar;
        if (this.isOpen) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.isOpen = true;
        this.uri = zzonVar2.uri;
        zzpa<zzom> zzpaVar = this.zzekf;
        if (zzpaVar != null) {
            zzpaVar.zza(this, zzonVar2);
        }
        zzte zzteVarZzd = zzte.zzd(zzonVar2.uri);
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzctd)).booleanValue()) {
            zzsz zzszVarZza = null;
            if (zzteVarZzd != null) {
                zzteVarZzd.zzbvk = zzonVar2.position;
                zzszVarZza = com.google.android.gms.ads.internal.zzp.zzkx().zza(zzteVarZzd);
            }
            if (zzszVarZza != null && zzszVarZza.zzmw()) {
                this.zzekd = zzszVarZza.zzmx();
                return -1L;
            }
        } else if (zzteVarZzd != null) {
            zzteVarZzd.zzbvk = zzonVar2.position;
            if (zzteVarZzd.zzbvj) {
                l = (Long) zzwm.zzpx().zzd(zzabb.zzctf);
            } else {
                l = (Long) zzwm.zzpx().zzd(zzabb.zzcte);
            }
            long jLongValue = l.longValue();
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
            com.google.android.gms.ads.internal.zzp.zzll();
            Future<InputStream> futureZza = zztp.zza(this.zzvr, zzteVarZzd);
            try {
                try {
                    this.zzekd = futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
                    this.zzekg.zzb(true, jElapsedRealtime2);
                    StringBuilder sb = new StringBuilder(44);
                    sb.append("Cache connection took ");
                    sb.append(jElapsedRealtime2);
                    sb.append("ms");
                    zzayp.zzei(sb.toString());
                    return -1L;
                } catch (InterruptedException unused) {
                    futureZza.cancel(true);
                    Thread.currentThread().interrupt();
                    long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
                    this.zzekg.zzb(false, jElapsedRealtime3);
                    StringBuilder sb2 = new StringBuilder(44);
                    sb2.append("Cache connection took ");
                    sb2.append(jElapsedRealtime3);
                    sb2.append("ms");
                    zzayp.zzei(sb2.toString());
                } catch (ExecutionException | TimeoutException unused2) {
                    futureZza.cancel(true);
                    long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
                    this.zzekg.zzb(false, jElapsedRealtime4);
                    StringBuilder sb3 = new StringBuilder(44);
                    sb3.append("Cache connection took ");
                    sb3.append(jElapsedRealtime4);
                    sb3.append("ms");
                    zzayp.zzei(sb3.toString());
                }
            } catch (Throwable th) {
                long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
                this.zzekg.zzb(false, jElapsedRealtime5);
                StringBuilder sb4 = new StringBuilder(44);
                sb4.append("Cache connection took ");
                sb4.append(jElapsedRealtime5);
                sb4.append("ms");
                zzayp.zzei(sb4.toString());
                throw th;
            }
        }
        if (zzteVarZzd != null) {
            zzonVar2 = new zzon(Uri.parse(zzteVarZzd.url), zzonVar2.zzbic, zzonVar2.zzbid, zzonVar2.position, zzonVar2.zzcp, zzonVar2.zzcn, zzonVar2.flags);
        }
        return this.zzeke.zza(zzonVar2);
    }
}
