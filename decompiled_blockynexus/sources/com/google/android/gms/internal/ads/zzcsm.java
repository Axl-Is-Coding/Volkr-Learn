package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzua;
import com.umeng.analytics.pro.au;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsm {
    private zzbbx zzdqm;
    private zzcrw zzgmo;
    private zzts zzgna;
    private Context zzvr;

    public zzcsm(Context context, zzbbx zzbbxVar, zzts zztsVar, zzcrw zzcrwVar) {
        this.zzvr = context;
        this.zzdqm = zzbbxVar;
        this.zzgna = zztsVar;
        this.zzgmo = zzcrwVar;
    }

    public final void zzaqh() {
        try {
            this.zzgmo.zza(new zzdrp(this) { // from class: com.google.android.gms.internal.ads.zzcsl
                private final zzcsm zzgmz;

                {
                    this.zzgmz = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdrp
                public final Object apply(Object obj) {
                    return this.zzgmz.zzb((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            zzbbq.zzfc(strValueOf.length() != 0 ? "Error in offline signals database startup: ".concat(strValueOf) : new String("Error in offline signals database startup: "));
        }
    }

    final /* synthetic */ Void zzb(SQLiteDatabase sQLiteDatabase) throws Exception {
        ArrayList<zzua.zzo.zza> arrayListZza = zzcsj.zza(sQLiteDatabase);
        final zzua.zzo zzoVar = (zzua.zzo) zzua.zzo.zzom().zzce(this.zzvr.getPackageName()).zzcf(Build.MODEL).zzco(zzcsj.zza(sQLiteDatabase, 0)).zzf(arrayListZza).zzcp(zzcsj.zza(sQLiteDatabase, 1)).zzev(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis()).zzew(zzcsj.zzb(sQLiteDatabase, 2)).zzbgt();
        int size = arrayListZza.size();
        long timestamp = 0;
        int i = 0;
        while (i < size) {
            zzua.zzo.zza zzaVar = arrayListZza.get(i);
            i++;
            zzua.zzo.zza zzaVar2 = zzaVar;
            if (zzaVar2.zzoj() == zzuk.ENUM_TRUE && zzaVar2.getTimestamp() > timestamp) {
                timestamp = zzaVar2.getTimestamp();
            }
        }
        if (timestamp != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(timestamp));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zzgna.zza(new zztr(zzoVar) { // from class: com.google.android.gms.internal.ads.zzcso
            private final zzua.zzo zzgnc;

            {
                this.zzgnc = zzoVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar3) {
                zzaVar3.zza(this.zzgnc);
            }
        });
        final zzua.zzu zzuVar = (zzua.zzu) zzua.zzu.zzot().zzcq(this.zzdqm.zzeel).zzcr(this.zzdqm.zzeem).zzcs(this.zzdqm.zzeen ? 0 : 2).zzbgt();
        this.zzgna.zza(new zztr(zzuVar) { // from class: com.google.android.gms.internal.ads.zzcsn
            private final zzua.zzu zzgnb;

            {
                this.zzgnb = zzuVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar3) {
                zzaVar3.zza(zzaVar3.zzny().zzbgg().zza(this.zzgnb));
            }
        });
        this.zzgna.zza(zztu.zza.zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{au.U});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
