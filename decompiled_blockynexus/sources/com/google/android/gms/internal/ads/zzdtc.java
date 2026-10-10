package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdtc {
    private static volatile zzbw.zza.zzc zzhme = zzbw.zza.zzc.UNKNOWN;
    private final Executor executor;
    private final Task<zztx> zzhmd;
    private final Context zzvr;

    private zzdtc(Context context, Executor executor, Task<zztx> task) {
        this.zzvr = context;
        this.executor = executor;
        this.zzhmd = task;
    }

    public static zzdtc zza(final Context context, Executor executor) {
        return new zzdtc(context, executor, Tasks.call(executor, new Callable(context) { // from class: com.google.android.gms.internal.ads.zzdtb
            private final Context zzcyt;

            {
                this.zzcyt = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdtc.zzcj(this.zzcyt);
            }
        }));
    }

    static void zzb(zzbw.zza.zzc zzcVar) {
        zzhme = zzcVar;
    }

    static final /* synthetic */ zztx zzcj(Context context) throws Exception {
        return new zztx(context, "GLAS", null);
    }

    public final Task<Boolean> zzg(int i, long j) {
        return zza(i, j, null, null, null, null);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return zza(4007, 0L, null, null, null, str);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, null, str, null, null);
    }

    private final Task<Boolean> zza(final int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        final zzbw.zza.C0105zza c0105zzaZzc = zzbw.zza.zzs().zzk(this.zzvr.getPackageName()).zzc(j);
        c0105zzaZzc.zza(zzhme);
        if (exc != null) {
            c0105zzaZzc.zzl(zzdwh.zza(exc)).zzm(exc.getClass().getName());
        }
        if (str2 != null) {
            c0105zzaZzc.zzn(str2);
        }
        if (str != null) {
            c0105zzaZzc.zzo(str);
        }
        return this.zzhmd.continueWith(this.executor, new Continuation(c0105zzaZzc, i) { // from class: com.google.android.gms.internal.ads.zzdte
            private final int zzebs;
            private final zzbw.zza.C0105zza zzhmf;

            {
                this.zzhmf = c0105zzaZzc;
                this.zzebs = i;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzdtc.zza(this.zzhmf, this.zzebs, task);
            }
        });
    }

    static final /* synthetic */ Boolean zza(zzbw.zza.C0105zza c0105zza, int i, Task task) throws Exception {
        if (task.isSuccessful()) {
            zzub zzubVarZzf = ((zztx) task.getResult()).zzf(((zzbw.zza) c0105zza.zzbgt()).toByteArray());
            zzubVarZzf.zzby(i);
            zzubVarZzf.zzdx();
            return true;
        }
        return false;
    }
}
