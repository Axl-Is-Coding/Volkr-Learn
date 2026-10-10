package com.google.android.gms.measurement.internal;

import a.a.b;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaf extends zzki {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzag zzj;
    private final zzke zzk;

    zzaf(zzkl zzklVar) {
        super(zzklVar);
        this.zzk = new zzke(zzl());
        this.zzj = new zzag(this, zzm(), "google_app_measurement.db");
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    @VisibleForTesting
    private final boolean zzal() {
        return zzm().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = c_().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void b_() {
        zzaj();
        c_().setTransactionSuccessful();
    }

    @VisibleForTesting
    final SQLiteDatabase c_() {
        zzc();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzq().zzh().zza("Error opening database", e2);
            throw e2;
        }
    }

    public final String d_() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzq().zze().zza("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            th = th2;
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    public final boolean e_() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzkw zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzc()
            r18.zzaj()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.c_()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r1] = r19     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r2] = r8     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            if (r0 != 0) goto L44
            if (r10 == 0) goto L43
            r10.close()
        L43:
            return r9
        L44:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            if (r1 == 0) goto L73
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
        L73:
            if (r10 == 0) goto L78
            r10.close()
        L78:
            return r0
        L79:
            r0 = move-exception
            goto L8c
        L7b:
            r0 = move-exception
            r11 = r18
            goto Lac
        L7f:
            r0 = move-exception
            r11 = r18
            goto L8c
        L83:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto Lac
        L88:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8c:
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r19)     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzeo r4 = r18.zzn()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lab
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lab
            if (r10 == 0) goto Laa
            r10.close()
        Laa:
            return r9
        Lab:
            r0 = move-exception
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkw");
    }

    public final zzz zzd(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            try {
                cursorQuery = c_().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                String string = cursorQuery.getString(0);
                try {
                    Object objZza = zza(cursorQuery, 1);
                    boolean z = cursorQuery.getInt(2) != 0;
                    zzz zzzVar = new zzz(str, string, new zzku(str2, cursorQuery.getLong(8), objZza, string), cursorQuery.getLong(6), z, cursorQuery.getString(3), (zzaq) f_().zza(cursorQuery.getBlob(5), zzaq.CREATOR), cursorQuery.getLong(4), (zzaq) f_().zza(cursorQuery.getBlob(7), zzaq.CREATOR), cursorQuery.getLong(9), (zzaq) f_().zza(cursorQuery.getBlob(10), zzaq.CREATOR));
                    if (cursorQuery.moveToNext()) {
                        zzq().zze().zza("Got multiple records for conditional property, expected one", zzeq.zza(str), zzn().zzc(str2));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzzVar;
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (SQLiteException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        zzq().zze().zza("Error querying conditional property", zzeq.zza(str), zzn().zzc(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzd() {
        return false;
    }

    public final void zze() {
        zzaj();
        c_().beginTransaction();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zzb>> zzf(java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    public final void zzg() {
        zzaj();
        c_().endTransaction();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(6:39|3|4|36|5|6)|(5:8|(3:10|11|12)(1:13)|30|31|32)|38|14|(3:16|17|18)(3:19|20|32)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c6, code lost:
    
        r0 = e;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final long zzh(java.lang.String r18, java.lang.String r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzh(java.lang.String, java.lang.String):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzi(java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzi(java.lang.String):android.os.Bundle");
    }

    public final zzac zzj(String str) {
        Preconditions.checkNotNull(str);
        zzc();
        zzaj();
        return zzac.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    final void zzu() {
        int iDelete;
        zzc();
        zzaj();
        if (zzal()) {
            long jZza = zzr().zzf.zza();
            long jElapsedRealtime = zzl().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzas.zzx.zza(null).longValue()) {
                zzr().zzf.zza(jElapsedRealtime);
                zzc();
                zzaj();
                if (!zzal() || (iDelete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzl().currentTimeMillis()), String.valueOf(zzab.zzu())})) <= 0) {
                    return;
                }
                zzq().zzw().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final long zzv() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long zzw() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzz() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Error querying raw events", e2);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error deleting conditional property", zzeq.zza(str), zzn().zzc(str2), e2);
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zze>> zzg(java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getString(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return str2;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error deleting user property. appId", zzeq.zza(str), zzn().zzc(str2), e2);
        }
    }

    final Map<Integer, List<zzbv.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        b bVar = new b();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzbv.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzbv.zzb zzbVar = (zzbv.zzb) ((com.google.android.gms.internal.measurement.zzhy) ((zzbv.zzb.zza) zzkr.zza(zzbv.zzb.zzl(), cursorQuery.getBlob(1))).zzy());
                        if (zzbVar.zzf()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) bVar.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                bVar.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e2) {
                        zzq().zze().zza("Failed to merge filter. appId", zzeq.zza(str), e2);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return bVar;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e3);
            Map<Integer, List<zzbv.zzb>> mapEmptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return mapEmptyMap2;
        }
    }

    public final zzam zza(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorQuery;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            try {
                cursorQuery = c_().query(com.umeng.analytics.pro.b.ao, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                long j = cursorQuery.getLong(0);
                long j2 = cursorQuery.getLong(1);
                long j3 = cursorQuery.getLong(2);
                long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                if (cursorQuery.isNull(7)) {
                    boolValueOf = null;
                } else {
                    boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                }
                cursor2 = cursorQuery;
                try {
                    zzam zzamVar = new zzam(str, str2, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursor2.moveToNext()) {
                        zzq().zze().zza("Got multiple records for event aggregates, expected one. appId", zzeq.zza(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzamVar;
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor2 = cursorQuery;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        zzq().zze().zza("Error querying events. appId", zzeq.zza(str), zzn().zza(str2), e);
        if (cursor2 != null) {
            cursor2.close();
        }
        return null;
    }

    public final List<zzz> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            return c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzs().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error deleting over the limit events. appId", zzeq.zza(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzaj()
            r7.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            a.a.b r0 = new a.a.b
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9f
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6c
        L67:
            r8 = move-exception
            r1 = r2
            goto La0
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch: java.lang.Throwable -> L9f
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza(r8)     // Catch: java.lang.Throwable -> L9f
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> L9f
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> L9f
            if (r0 == 0) goto L99
            com.google.android.gms.measurement.internal.zzab r0 = r7.zzs()     // Catch: java.lang.Throwable -> L9f
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> L9f
            boolean r8 = r0.zze(r8, r3)     // Catch: java.lang.Throwable -> L9f
            if (r8 == 0) goto L99
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L98
            r1.close()
        L98:
            return r8
        L99:
            if (r1 == 0) goto L9e
            r1.close()
        L9e:
            return r2
        L9f:
            r8 = move-exception
        La0:
            if (r1 == 0) goto La5
            r1.close()
        La5:
            goto La7
        La6:
            throw r8
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcd.zzi> zzg(java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String):java.util.Map");
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final byte[] zzd(String str) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            cursorQuery = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        zzq().zze().zza("Got multiple records for app config, expected one. appId", zzeq.zza(str));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return blob;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzq().zze().zza("Error querying remote config. appId", zzeq.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
            }
            th = th;
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw th;
    }

    public final void zza(zzam zzamVar) {
        Preconditions.checkNotNull(zzamVar);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzamVar.zza);
        contentValues.put("name", zzamVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzamVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzamVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzamVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzamVar.zzg));
        contentValues.put("last_bundled_day", zzamVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzamVar.zzi);
        contentValues.put("last_sampling_rate", zzamVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzamVar.zze));
        Boolean bool = zzamVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict(com.umeng.analytics.pro.b.ao, null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update event aggregates (got -1). appId", zzeq.zza(zzamVar.zza));
            }
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing event aggregates. appId", zzeq.zza(zzamVar.zza), e2);
        }
    }

    public final boolean zza(zzkw zzkwVar) {
        Preconditions.checkNotNull(zzkwVar);
        zzc();
        zzaj();
        if (zzc(zzkwVar.zza, zzkwVar.zzc) == null) {
            if (zzkv.zza(zzkwVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkwVar.zza}) >= zzs().zzd(zzkwVar.zza)) {
                    return false;
                }
            } else if (!"_npa".equals(zzkwVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkwVar.zza, zzkwVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkwVar.zza);
        contentValues.put("origin", zzkwVar.zzb);
        contentValues.put("name", zzkwVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkwVar.zzd));
        zza(contentValues, "value", zzkwVar.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update user property (got -1). appId", zzeq.zza(zzkwVar.zza));
            }
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing user property. appId", zzeq.zza(zzkwVar.zza), e2);
        }
        return true;
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzaj();
        zzc();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zzs().zzb(str, zzas.zzae)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 140);
            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(string);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseC_.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
    
        zzq().zze().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzz zzzVar) {
        Preconditions.checkNotNull(zzzVar);
        zzc();
        zzaj();
        if (zzc(zzzVar.zza, zzzVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzzVar.zza}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzzVar.zza);
        contentValues.put("origin", zzzVar.zzb);
        contentValues.put("name", zzzVar.zzc.zza);
        zza(contentValues, "value", zzzVar.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzzVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzzVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzzVar.zzh));
        zzo();
        contentValues.put("timed_out_event", zzkv.zza((Parcelable) zzzVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzzVar.zzd));
        zzo();
        contentValues.put("triggered_event", zzkv.zza((Parcelable) zzzVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzzVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzzVar.zzj));
        zzo();
        contentValues.put("expired_event", zzkv.zza((Parcelable) zzzVar.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update conditional user property (got -1)", zzeq.zza(zzzVar.zza));
            }
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing conditional user property", zzeq.zza(zzzVar.zza), e2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008e, code lost:
    
        zzq().zze().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzz> zza(java.lang.String r40, java.lang.String[] r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfVar.zzc());
        contentValues.put("app_instance_id", zzfVar.zzd());
        contentValues.put("gmp_app_id", zzfVar.zze());
        contentValues.put("resettable_device_id_hash", zzfVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzk()));
        contentValues.put("app_version", zzfVar.zzl());
        contentValues.put("app_store", zzfVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzr()));
        contentValues.put("day", Long.valueOf(zzfVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zzm()));
        contentValues.put("firebase_instance_id", zzfVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzaa()));
        contentValues.put("health_monitor_sample", zzfVar.zzac());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzfVar.zzag()));
        contentValues.put("admob_app_id", zzfVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzq()));
        if (zzfVar.zzai() != null) {
            if (zzfVar.zzai().size() == 0) {
                zzq().zzh().zza("Safelisted events should not be an empty list. appId", zzfVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzfVar.zzai()));
            }
        }
        if (zznv.zzb() && zzs().zze(zzfVar.zzc(), zzas.zzbi)) {
            contentValues.put("ga_app_id", zzfVar.zzg());
        }
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            if (sQLiteDatabaseC_.update("apps", contentValues, "app_id = ?", new String[]{zzfVar.zzc()}) == 0 && sQLiteDatabaseC_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update app (got -1). appId", zzeq.zza(zzfVar.zzc()));
            }
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing app. appId", zzeq.zza(zzfVar.zzc()), e2);
        }
    }

    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzae zza(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzae");
    }

    public final boolean zza(zzcd.zzg zzgVar, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzu();
        long jCurrentTimeMillis = zzl().currentTimeMillis();
        if (zzgVar.zzl() < jCurrentTimeMillis - zzab.zzu() || zzgVar.zzl() > zzab.zzu() + jCurrentTimeMillis) {
            zzq().zzh().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeq.zza(zzgVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] bArrZzc = f_().zzc(zzgVar.zzbk());
            zzq().zzw().zza("Saving bundle, size", Integer.valueOf(bArrZzc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", bArrZzc);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzq().zze().zza("Failed to insert bundle (got -1). appId", zzeq.zza(zzgVar.zzx()));
                return false;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Error storing bundle. appId", zzeq.zza(zzgVar.zzx()), e2);
                return false;
            }
        } catch (IOException e3) {
            zzq().zze().zza("Data loss. Failed to serialize bundle. appId", zzeq.zza(zzgVar.zzx()), e3);
            return false;
        }
    }

    public final List<Pair<zzcd.zzg, Long>> zza(String str, int i, int i2) {
        byte[] bArrZzb;
        zzc();
        zzaj();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzcd.zzg, Long>> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzb = f_().zzb(cursorQuery.getBlob(1));
                    } catch (IOException e2) {
                        zzq().zze().zza("Failed to unzip queued bundle. appId", zzeq.zza(str), e2);
                    }
                    if (!arrayList.isEmpty() && bArrZzb.length + length > i2) {
                        break;
                    }
                    try {
                        zzcd.zzg.zza zzaVar = (zzcd.zzg.zza) zzkr.zza(zzcd.zzg.zzbh(), bArrZzb);
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzb.length;
                        arrayList.add(Pair.create((zzcd.zzg) ((com.google.android.gms.internal.measurement.zzhy) zzaVar.zzy()), Long.valueOf(j)));
                    } catch (IOException e3) {
                        zzq().zze().zza("Failed to merge queued bundle. appId", zzeq.zza(str), e3);
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                } while (length <= i2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                zzq().zze().zza("Error querying bundles. appId", zzeq.zza(str), e4);
                List<Pair<zzcd.zzg, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    final void zza(List<Long> list) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzal()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb2.toString(), (String[]) null) > 0) {
                zzq().zzh().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseC_ = c_();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseC_.execSQL(sb3.toString());
            } catch (SQLiteException e2) {
                zzq().zze().zza("Error incrementing retry count. error", e2);
            }
        }
    }

    private final boolean zza(String str, int i, zzbv.zzb zzbVar) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzq().zzh().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzeq.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbk = zzbVar.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        contentValues.put("data", bArrZzbk);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert event filter (got -1). appId", zzeq.zza(str));
            return true;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing event filter. appId", zzeq.zza(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbv.zze zzeVar) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzq().zzh().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzeq.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbk = zzeVar.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbk);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert property filter (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing property filter. appId", zzeq.zza(str), e2);
            return false;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzq().zze().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            zzq().zze().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzq().zze().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long zza(zzcd.zzg zzgVar) throws IOException {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] bArrZzbk = zzgVar.zzbk();
        long jZza = f_().zza(bArrZzbk);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbk);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing raw event metadata. appId", zzeq.zza(zzgVar.zzx()), e2);
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzc()
            r4.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.c_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzeq r6 = r4.zzq()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzw()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L45
        L40:
            r6 = move-exception
            r5 = r0
            goto L59
        L43:
            r6 = move-exception
            r5 = r0
        L45:
            com.google.android.gms.measurement.internal.zzeq r1 = r4.zzq()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L57
            r5.close()
        L57:
            return r0
        L58:
            r6 = move-exception
        L59:
            if (r5 == 0) goto L5e
            r5.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcd.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzw()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzji r2 = com.google.android.gms.measurement.internal.zzkr.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7e
        L79:
            r8 = move-exception
            r1 = r0
            goto L92
        L7c:
            r8 = move-exception
            r1 = r0
        L7e:
            com.google.android.gms.measurement.internal.zzeq r9 = r7.zzq()     // Catch: java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzes r9 = r9.zze()     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L90
            r1.close()
        L90:
            return r0
        L91:
            r8 = move-exception
        L92:
            if (r1 == 0) goto L97
            r1.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcd.zzc zzcVar) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbk = zzcVar.zzbk();
        zzq().zzw().zza("Saving complex main event, appId, data size", zzn().zza(str), Integer.valueOf(bArrZzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbk);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert complex main event (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing complex main event. appId", zzeq.zza(str), e2);
            return false;
        }
    }

    final boolean zza(String str, Bundle bundle) {
        zzc();
        zzaj();
        byte[] bArrZzbk = f_().zza(new zzan(this.zzy, "", str, "dep", 0L, 0L, bundle)).zzbk();
        zzq().zzw().zza("Saving default event parameters, appId, data size", zzn().zza(str), Integer.valueOf(bArrZzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbk);
        try {
            if (c_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert default event parameters (got -1). appId", zzeq.zza(str));
            return false;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing default event parameters. appId", zzeq.zza(str), e2);
            return false;
        }
    }

    public final boolean zza(zzan zzanVar, long j, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzanVar);
        Preconditions.checkNotEmpty(zzanVar.zza);
        byte[] bArrZzbk = f_().zza(zzanVar).zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzanVar.zza);
        contentValues.put("name", zzanVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzanVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbk);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert raw event (got -1). appId", zzeq.zza(zzanVar.zza));
            return false;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Error storing raw event. appId", zzeq.zza(zzanVar.zza), e2);
            return false;
        }
    }

    final void zza(String str, List<zzbv.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbv.zza.C0124zza c0124zzaZzbo = list.get(i).zzbo();
            if (c0124zzaZzbo.zzb() != 0) {
                zzbv.zza.C0124zza c0124zzaZza = c0124zzaZzbo;
                for (int i2 = 0; i2 < c0124zzaZza.zzb(); i2++) {
                    zzbv.zzb.zza zzaVarZzbo = c0124zzaZza.zzb(i2).zzbo();
                    zzbv.zzb.zza zzaVar = (zzbv.zzb.zza) zzaVarZzbo.clone();
                    String strZzb = zzgv.zzb(zzaVarZzbo.zza());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z3 = z2;
                    for (int i3 = 0; i3 < zzaVarZzbo.zzb(); i3++) {
                        zzbv.zzc zzcVarZza = zzaVarZzbo.zza(i3);
                        String strZza = zzgu.zza(zzcVarZza.zzh());
                        if (strZza != null) {
                            zzaVar.zza(i3, (zzbv.zzc) zzcVarZza.zzbo().zza(strZza).zzy());
                            z3 = true;
                        }
                    }
                    if (z3) {
                        c0124zzaZza = c0124zzaZza.zza(i2, zzaVar);
                        list.set(i, (zzbv.zza) c0124zzaZza.zzy());
                    }
                }
                c0124zzaZzbo = c0124zzaZza;
            }
            if (c0124zzaZzbo.zza() != 0) {
                for (int i4 = 0; i4 < c0124zzaZzbo.zza(); i4++) {
                    zzbv.zze zzeVarZza = c0124zzaZzbo.zza(i4);
                    String strZza2 = zzgx.zza(zzeVarZza.zzc());
                    if (strZza2 != null) {
                        c0124zzaZzbo = c0124zzaZzbo.zza(i4, zzeVarZza.zzbo().zza(strZza2));
                        list.set(i, (zzbv.zza) c0124zzaZzbo.zzy());
                    }
                }
            }
        }
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        try {
            zzaj();
            zzc();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseC_2 = c_();
            sQLiteDatabaseC_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseC_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbv.zza zzaVar2 : list) {
                zzaj();
                zzc();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zza()) {
                    zzq().zzh().zza("Audience with no ID. appId", zzeq.zza(str));
                } else {
                    int iZzb = zzaVar2.zzb();
                    Iterator<zzbv.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzq().zzh().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            Iterator<zzbv.zze> it2 = zzaVar2.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzq().zzh().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(iZzb));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbv.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, iZzb, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbv.zze> it4 = zzaVar2.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, iZzb, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzaj();
                                        zzc();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseC_3 = c_();
                                        sQLiteDatabaseC_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                        sQLiteDatabaseC_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zza() ? Integer.valueOf(zzaVar3.zzb()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseC_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseC_.endTransaction();
        }
    }
}
