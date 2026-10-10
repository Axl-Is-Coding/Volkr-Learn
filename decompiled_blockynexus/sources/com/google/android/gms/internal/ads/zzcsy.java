package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsy extends zzaqs {
    private final zzcsp zzgha;
    private final zzbbu zzgnp;
    private final Context zzvr;

    public zzcsy(Context context, zzcsp zzcspVar, zzbbu zzbbuVar) {
        this.zzvr = context;
        this.zzgnp = zzbbuVar;
        this.zzgha = zzcspVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra(ShareConstants.MEDIA_URI);
            com.google.android.gms.ads.internal.zzp.zzkr();
            boolean zZzbf = zzayu.zzbf(this.zzvr);
            int i = zzcsq.zzgnh;
            if (stringExtra.equals("offline_notification_clicked")) {
                if (zZzbf) {
                    i = zzcsq.zzgng;
                }
                Context context = this.zzvr;
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    launchIntentForPackage.setData(Uri.parse(stringExtra3));
                }
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
            try {
                SQLiteDatabase writableDatabase = this.zzgha.getWritableDatabase();
                if (i == zzcsq.zzgng) {
                    this.zzgha.zza(writableDatabase, this.zzgnp, stringExtra2);
                } else {
                    writableDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{stringExtra2, Integer.toString(0)});
                }
            } catch (SQLiteException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(strValueOf);
                zzbbq.zzfc(sb.toString());
            }
        }
    }
}
