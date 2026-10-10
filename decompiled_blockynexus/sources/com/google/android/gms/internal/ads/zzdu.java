package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzdu {
    private static final ConditionVariable zzwh = new ConditionVariable();
    protected static volatile zztx zzwi = null;
    private static volatile Random zzwk = null;
    private zzex zzwg;
    protected volatile Boolean zzwj;

    public zzdu(zzex zzexVar) {
        this.zzwg = zzexVar;
        zzexVar.zzcg().execute(new zzdt(this));
    }

    public static int zzbu() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzbv().nextInt();
        } catch (RuntimeException unused) {
            return zzbv().nextInt();
        }
    }

    private static Random zzbv() {
        if (zzwk == null) {
            synchronized (zzdu.class) {
                if (zzwk == null) {
                    zzwk = new Random();
                }
            }
        }
        return zzwk;
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzwh.block();
            if (!this.zzwj.booleanValue() || zzwi == null) {
                return;
            }
            zzbw.zza.C0105zza c0105zzaZzc = zzbw.zza.zzs().zzk(this.zzwg.zzvr.getPackageName()).zzc(j);
            if (str != null) {
                c0105zzaZzc.zzn(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzehy.zza(exc, new PrintWriter(stringWriter));
                c0105zzaZzc.zzl(stringWriter.toString()).zzm(exc.getClass().getName());
            }
            zzub zzubVarZzf = zzwi.zzf(((zzbw.zza) ((zzejz) c0105zzaZzc.zzbgt())).toByteArray());
            zzubVarZzf.zzby(i);
            if (i2 != -1) {
                zzubVarZzf.zzbx(i2);
            }
            zzubVarZzf.zzdx();
        } catch (Exception unused) {
        }
    }
}
