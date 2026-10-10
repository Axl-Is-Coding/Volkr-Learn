package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzua;
import com.umeng.analytics.pro.au;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcsi implements zzdyr<Bundle> {
    private final /* synthetic */ boolean zzgmw;
    final /* synthetic */ zzcsf zzgmx;

    zzcsi(zzcsf zzcsfVar, boolean z) {
        this.zzgmx = zzcsfVar;
        this.zzgmw = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcsf zzcsfVar = this.zzgmx;
        final ArrayList arrayListZzm = zzcsf.zzm(bundle2);
        zzcsf zzcsfVar2 = this.zzgmx;
        final zzua.zzo.zzb zzbVarZzl = zzcsf.zzl(bundle2);
        final zzua.zzm zzmVarZzk = this.zzgmx.zzk(bundle2);
        zzcrw zzcrwVar = this.zzgmx.zzgmo;
        final boolean z = this.zzgmw;
        zzcrwVar.zza(new zzdrp(this, z, arrayListZzm, zzmVarZzk, zzbVarZzl) { // from class: com.google.android.gms.internal.ads.zzcsh
            private final boolean zzeha;
            private final zzcsi zzgms;
            private final ArrayList zzgmt;
            private final zzua.zzm zzgmu;
            private final zzua.zzo.zzb zzgmv;

            {
                this.zzgms = this;
                this.zzeha = z;
                this.zzgmt = arrayListZzm;
                this.zzgmu = zzmVarZzk;
                this.zzgmv = zzbVarZzl;
            }

            @Override // com.google.android.gms.internal.ads.zzdrp
            public final Object apply(Object obj) {
                zzcsi zzcsiVar = this.zzgms;
                boolean z2 = this.zzeha;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                byte[] bArrZza = zzcsiVar.zzgmx.zza(z2, this.zzgmt, this.zzgmu, this.zzgmv);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis()));
                contentValues.put("serialized_proto_data", bArrZza);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", au.U));
                }
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzbbq.zzfc("Failed to get signals bundle");
    }
}
