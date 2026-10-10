package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsp extends SQLiteOpenHelper {
    private final zzdzb zzglx;

    public zzcsp(Context context, zzdzb zzdzbVar) {
        super(context, "OfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zzglx = zzdzbVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    final void zza(final SQLiteDatabase sQLiteDatabase, final zzbbu zzbbuVar, final String str) {
        this.zzglx.execute(new Runnable(sQLiteDatabase, str, zzbbuVar) { // from class: com.google.android.gms.internal.ads.zzcsr
            private final String zzdgm;
            private final SQLiteDatabase zzgnj;
            private final zzbbu zzgnk;

            {
                this.zzgnj = sQLiteDatabase;
                this.zzdgm = str;
                this.zzgnk = zzbbuVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SQLiteDatabase sQLiteDatabase2 = this.zzgnj;
                String str2 = this.zzdgm;
                zzbbu zzbbuVar2 = this.zzgnk;
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_state", (Integer) 1);
                sQLiteDatabase2.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str2});
                sQLiteDatabase2.beginTransaction();
                try {
                    StringBuilder sb = new StringBuilder(25);
                    sb.append("event_state = 1");
                    Cursor cursorQuery = sQLiteDatabase2.query("offline_buffered_pings", new String[]{"url"}, sb.toString(), null, null, null, "timestamp ASC", null);
                    String[] strArr = new String[cursorQuery.getCount()];
                    int i = 0;
                    while (cursorQuery.moveToNext()) {
                        int columnIndex = cursorQuery.getColumnIndex("url");
                        if (columnIndex != -1) {
                            strArr[i] = cursorQuery.getString(columnIndex);
                        }
                        i++;
                    }
                    cursorQuery.close();
                    sQLiteDatabase2.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                    for (String str3 : strArr) {
                        zzbbuVar2.zzes(str3);
                    }
                } catch (Throwable th) {
                    sQLiteDatabase2.endTransaction();
                    throw th;
                }
            }
        });
    }

    public final void zza(final zzcsv zzcsvVar) {
        zzdyq.zza(this.zzglx.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcss
            private final zzcsp zzgnl;

            {
                this.zzgnl = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgnl.getWritableDatabase();
            }
        }), new zzcst(this, new zzdrp(zzcsvVar) { // from class: com.google.android.gms.internal.ads.zzcsu
            private final zzcsv zzgnm;

            {
                this.zzgnm = zzcsvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdrp
            public final Object apply(Object obj) {
                zzcsv zzcsvVar2 = this.zzgnm;
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(zzcsvVar2.timestamp));
                contentValues.put("gws_query_id", zzcsvVar2.zzdtb);
                contentValues.put("url", zzcsvVar2.url);
                contentValues.put("event_state", Integer.valueOf(zzcsvVar2.zzgnn - 1));
                ((SQLiteDatabase) obj).insert("offline_buffered_pings", null, contentValues);
                return null;
            }
        }), this.zzglx);
    }
}
