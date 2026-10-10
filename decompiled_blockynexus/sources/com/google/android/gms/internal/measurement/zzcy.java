package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcy implements zzcx {
    private static zzcy zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzcy(Context context) {
        this.zzb = context;
        this.zzc = new zzda(this, null);
        context.getContentResolver().registerContentObserver(zzcp.zza, true, this.zzc);
    }

    static zzcy zza(Context context) {
        zzcy zzcyVar;
        synchronized (zzcy.class) {
            if (zza == null) {
                zza = c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcy(context) : new zzcy();
            }
            zzcyVar = zza;
        }
        return zzcyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcx
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcw.zza(new zzcz(this, str) { // from class: com.google.android.gms.internal.measurement.zzdb
                private final zzcy zza;
                private final String zzb;

                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzcz
                public final Object zza() {
                    return this.zza.zzb(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    final /* synthetic */ String zzb(String str) {
        return zzcp.zza(this.zzb.getContentResolver(), str, (String) null);
    }

    private zzcy() {
        this.zzb = null;
        this.zzc = null;
    }

    static synchronized void zza() {
        if (zza != null && zza.zzb != null && zza.zzc != null) {
            zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
        }
        zza = null;
    }
}
