package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcry implements zzdyr<SQLiteDatabase> {
    private final /* synthetic */ zzdrp zzglz;

    zzcry(zzcrw zzcrwVar, zzdrp zzdrpVar) {
        this.zzglz = zzdrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(SQLiteDatabase sQLiteDatabase) {
        try {
            this.zzglz.apply(sQLiteDatabase);
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            zzbbq.zzfc(strValueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(strValueOf) : new String("Error executing function on offline signal database: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        zzbbq.zzfc(strValueOf.length() != 0 ? "Failed to get offline signal database: ".concat(strValueOf) : new String("Failed to get offline signal database: "));
    }
}
