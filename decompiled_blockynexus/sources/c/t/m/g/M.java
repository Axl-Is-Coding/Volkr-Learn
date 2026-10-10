package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import c.t.m.g.qc;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2960a;

    class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void a() {
            int count;
            try {
                ArrayList arrayList = new ArrayList();
                int iA = qc.a.a("apn_cache_num", 1, 100, 8);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Cursor cursorQuery = null;
                try {
                    cursorQuery = writableDatabase.query("halley_schedule_tbl", new String[]{"apn"}, null, null, null, null, "key");
                    if (cursorQuery != null && (count = cursorQuery.getCount() - iA) > 0 && cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("apn"));
                            if (!TextUtils.isEmpty(string) && !arrayList.contains(string)) {
                                arrayList.add(string);
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            int i = count - 1;
                            if (count <= 0) {
                                break;
                            } else {
                                count = i;
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{(String) it.next()});
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public final synchronized void a(String str, byte[] bArr) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                int iDelete = writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("apn", str);
                contentValues.put("result", bArr);
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (-1 != writableDatabase.insert("halley_schedule_tbl", null, contentValues) && iDelete <= 0) {
                    a();
                }
            } catch (Throwable unused) {
            }
        }

        public final synchronized byte[] a(String str) {
            Cursor cursorQuery;
            try {
                try {
                    cursorQuery = getReadableDatabase().query("halley_schedule_tbl", null, "apn=?", new String[]{str}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                byte[] blob = cursorQuery.getBlob(cursorQuery.getColumnIndex("result"));
                                if (!C0455pa.a(blob)) {
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return blob;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
                } catch (SQLException unused) {
                }
                try {
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                } catch (SQLException e2) {
                    throw e2;
                }
            } catch (Exception unused2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            try {
                int version = sQLiteDatabase.getVersion();
                if (version != 0) {
                    if (version <= 0) {
                        onUpgrade(sQLiteDatabase, version, 1);
                    } else if (version > 1) {
                        onDowngrade(sQLiteDatabase, version, 1);
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
                } catch (SQLException unused) {
                }
                try {
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                } catch (SQLException e2) {
                    throw e2;
                }
            } catch (Exception unused2) {
            }
        }
    }

    public M(String str) {
        fc.b();
        this.f2960a = new a(fc.a(), "halley_schedule_" + fc.c() + "_" + fc.i() + "_" + str + com.umeng.analytics.process.a.f20990d);
    }

    public final synchronized void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            this.f2960a.a(str, bArr);
        }
    }

    public final synchronized byte[] a(String str) {
        return this.f2960a.a(str);
    }
}
