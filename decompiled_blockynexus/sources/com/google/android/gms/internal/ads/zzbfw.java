package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.sandboxol.center.config.StringConstant;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzbfw extends zzbfl implements zzbey {
    private String zzegt;
    private boolean zzema;
    private zzber zzemd;
    private Exception zzeme;
    private boolean zzemf;

    public zzbfw(zzbdu zzbduVar, zzbdv zzbdvVar) {
        super(zzbduVar);
        this.zzemd = new zzber(zzbduVar.getContext(), zzbdvVar);
        this.zzemd.zza(this);
    }

    private final void zzfq(String str) {
        synchronized (this) {
            this.zzema = true;
            notify();
            release();
        }
        String str2 = this.zzegt;
        if (str2 != null) {
            String strZzfo = zzfo(str2);
            Exception exc = this.zzeme;
            if (exc != null) {
                zza(this.zzegt, strZzfo, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzegt, strZzfo, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void abort() {
        zzfq(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzber zzberVar = this.zzemd;
        if (zzberVar != null) {
            zzberVar.zza((zzbey) null);
            this.zzemd.release();
        }
        super.release();
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(String str, Exception exc) {
        String str2 = (String) zzwm.zzpx().zzd(zzabb.zzcmd);
        if (str2 != null) {
            List listAsList = Arrays.asList(str2.split(","));
            if (listAsList.contains(StringConstant.VIDEO_TYPE_ALL) || listAsList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzeme = exc;
        zzbbq.zzd("Precache error", exc);
        zzfq(str);
    }

    public final zzber zzaaz() {
        synchronized (this) {
            this.zzemf = true;
            notify();
        }
        this.zzemd.zza((zzbey) null);
        zzber zzberVar = this.zzemd;
        this.zzemd = null;
        return zzberVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(final boolean z, final long j) {
        final zzbdu zzbduVar = this.zzels.get();
        if (zzbduVar != null) {
            zzbbz.zzeet.execute(new Runnable(zzbduVar, z, j) { // from class: com.google.android.gms.internal.ads.zzbfz
                private final boolean zzeha;
                private final long zzekc;
                private final zzbdu zzeml;

                {
                    this.zzeml = zzbduVar;
                    this.zzeha = z;
                    this.zzekc = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeml.zza(this.zzeha, this.zzekc);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzdl(int i) {
        this.zzemd.zzaax().zzds(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzdm(int i) {
        this.zzemd.zzaax().zzdt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzdn(int i) {
        this.zzemd.zzaax().zzdn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzdo(int i) {
        this.zzemd.zzaax().zzdo(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzdq(int i) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [long] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.internal.ads.zzbfl, com.google.android.gms.internal.ads.zzbfw, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zze(String str, String[] strArr) throws Throwable {
        ?? r20;
        long j;
        long j2;
        long j3;
        ?? r1;
        ?? r31;
        this.zzegt = str;
        String strZzfo = zzfo(str);
        ?? r14 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    uriArr[i] = Uri.parse(strArr[i]);
                } catch (Exception e2) {
                    e = e2;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzbbq.zzfe(sb.toString());
                    release();
                    zza(str, strZzfo, r14, zzb((String) r14, e));
                    return false;
                }
            }
            this.zzemd.zza(uriArr, this.zzedk);
            zzbdu zzbduVar = this.zzels.get();
            if (zzbduVar != null) {
                zzbduVar.zza(strZzfo, (zzbfl) this);
            }
            Clock clockZzky = com.google.android.gms.ads.internal.zzp.zzky();
            long jCurrentTimeMillis = clockZzky.currentTimeMillis();
            long jLongValue = ((Long) zzwm.zzpx().zzd(zzabb.zzcmk)).longValue();
            long jLongValue2 = ((Long) zzwm.zzpx().zzd(zzabb.zzcmj)).longValue() * 1000;
            long jIntValue = ((Integer) zzwm.zzpx().zzd(zzabb.zzcmi)).intValue();
            long j4 = -1;
            ?? r9 = jLongValue;
            r14 = r14;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (clockZzky.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                                long j5 = jLongValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j5);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                            if (this.zzema) {
                                if (this.zzeme != null) {
                                    throw this.zzeme;
                                }
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.zzemf) {
                                zzhc zzhcVarZzaau = this.zzemd.zzaau();
                                if (zzhcVarZzaau == null) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                r20 = r14;
                                try {
                                    long duration = zzhcVarZzaau.getDuration();
                                    if (duration > 0) {
                                        long bufferedPosition = zzhcVarZzaau.getBufferedPosition();
                                        if (bufferedPosition != j4) {
                                            j = jIntValue;
                                            j2 = jLongValue2;
                                            r31 = r9;
                                            zza(str, strZzfo, bufferedPosition, duration, bufferedPosition > 0, zzber.zzaav(), zzber.zzaaw());
                                            j4 = bufferedPosition;
                                        } else {
                                            j = jIntValue;
                                            j2 = jLongValue2;
                                            r31 = r9;
                                        }
                                        if (bufferedPosition >= duration) {
                                            zzc(str, strZzfo, duration);
                                        } else if (this.zzemd.getBytesTransferred() < j || bufferedPosition <= 0) {
                                            j3 = j4;
                                            r1 = r31;
                                        }
                                    } else {
                                        j = jIntValue;
                                        j2 = jLongValue2;
                                        j3 = j4;
                                        r1 = r9;
                                    }
                                    try {
                                        try {
                                            wait(r1);
                                        } catch (Throwable th) {
                                            th = th;
                                            r14 = r1;
                                            throw th;
                                        }
                                    } catch (InterruptedException unused) {
                                        throw new IOException("Wait interrupted.");
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r14 = r20;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    r9 = r1;
                    j4 = j3;
                    r14 = r20;
                    jIntValue = j;
                    jLongValue2 = j2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            return true;
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzfn(String str) {
        return zze(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    protected final String zzfo(String str) {
        String strValueOf = String.valueOf(super.zzfo(str));
        return strValueOf.length() != 0 ? "cache:".concat(strValueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzn(int i, int i2) {
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
