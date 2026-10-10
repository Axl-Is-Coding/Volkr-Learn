package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: CacheDBHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class aw extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f20676b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static aw f20677c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20678d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20679e = "DROP TABLE IF EXISTS stf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20680f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f20681a;

    private aw(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f20681a = context;
    }

    public static final int a() {
        return 1;
    }

    public static aw a(Context context) {
        aw awVar;
        synchronized (f20676b) {
            if (f20677c == null) {
                f20677c = new aw(context, ay.f20686b, null, 1);
            }
            awVar = f20677c;
        }
        return awVar;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f20678d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null || !writableDatabase.isOpen()) {
            return;
        }
        try {
            writableDatabase.execSQL(f20680f);
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    public boolean c() {
        return !b(ay.f20687c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void b() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null || !writableDatabase.isOpen()) {
            return;
        }
        writableDatabase.close();
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f20679e);
            sQLiteDatabase.execSQL(f20678d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorQuery = null;
        if (writableDatabase != null) {
            try {
                if (writableDatabase.isOpen()) {
                    cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            if (cursorQuery.getCount() > 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                return true;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (writableDatabase == null) {
            return false;
        }
        writableDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null || !writableDatabase.isOpen()) {
            return;
        }
        try {
            writableDatabase.beginTransaction();
            writableDatabase.insert(str, null, contentValues);
            writableDatabase.setTransactionSuccessful();
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable unused) {
            if (writableDatabase == null) {
                return;
            }
        }
        writableDatabase.endTransaction();
        writableDatabase.close();
    }

    public void a(String str, String str2, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null || !writableDatabase.isOpen()) {
            return;
        }
        try {
            writableDatabase.beginTransaction();
            writableDatabase.delete(str, str2, strArr);
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable unused) {
            if (writableDatabase == null) {
                return;
            }
        }
        writableDatabase.endTransaction();
        writableDatabase.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.umeng.analytics.pro.ax a(java.lang.String r15) throws java.lang.Throwable {
        /*
            r14 = this;
            r0 = 3
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            java.lang.String r0 = "_uuid"
            r11 = 0
            r4[r11] = r0     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            java.lang.String r0 = "_hd"
            r12 = 1
            r4[r12] = r0     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            java.lang.String r0 = "_bd"
            r13 = 2
            r4[r13] = r0     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "1"
            r2 = r14
            r3 = r15
            android.database.Cursor r15 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            if (r15 == 0) goto L59
            boolean r0 = r15.moveToFirst()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L56
            if (r0 == 0) goto L59
            com.umeng.analytics.pro.ax r0 = new com.umeng.analytics.pro.ax     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L56
            java.lang.String r1 = r15.getString(r11)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r0.f20682a = r1     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            java.lang.String r1 = r15.getString(r12)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            java.lang.String r2 = r15.getString(r13)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.content.Context r3 = r14.f20681a     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            java.lang.String r1 = r3.d(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r0.f20683b = r1     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.content.Context r1 = r14.f20681a     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            java.lang.String r1 = r1.d(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r0.f20684c = r1     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            goto L5a
        L54:
            r0 = move-exception
            goto L6d
        L56:
            r0 = r1
        L57:
            r1 = r15
            goto L64
        L59:
            r0 = r1
        L5a:
            if (r15 == 0) goto L6c
            r15.close()
            goto L6c
        L60:
            r0 = move-exception
            r15 = r1
            goto L6d
        L63:
            r0 = r1
        L64:
            r14.d()     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L6c
            r1.close()
        L6c:
            return r0
        L6d:
            if (r15 == 0) goto L72
            r15.close()
        L72:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.aw.a(java.lang.String):com.umeng.analytics.pro.ax");
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return null;
        }
        try {
            if (writableDatabase.isOpen()) {
                return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
