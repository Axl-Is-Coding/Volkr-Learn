package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: DBHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f6155c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6157b;

    /* JADX INFO: compiled from: DBHelper.java */
    private class b extends AbstractCursor {
        private b() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return WheelView.DividerConfig.FILL;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    f(Context context) {
        try {
            this.f6157b = context == null ? o.a() : context.getApplicationContext();
            if (this.f6156a == null) {
                this.f6156a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        Context context = this.f6157b;
        return context == null ? o.a() : context;
    }

    public c a() {
        return this.f6156a;
    }

    /* JADX INFO: compiled from: DBHelper.java */
    public class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SQLiteDatabase f6162b = null;

        public c() {
        }

        private synchronized void d() {
            boolean zE;
            try {
                synchronized (f.f6155c) {
                    if (this.f6162b == null || !this.f6162b.isOpen()) {
                        this.f6162b = f.this.new a(f.this.c()).getWritableDatabase();
                        this.f6162b.setLockingEnabled(false);
                    }
                }
            } finally {
                if (zE) {
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private synchronized boolean e() {
            /*
                r1 = this;
                monitor-enter(r1)
                android.database.sqlite.SQLiteDatabase r0 = r1.f6162b     // Catch: java.lang.Throwable -> L10
                if (r0 == 0) goto Ld
                boolean r0 = r0.inTransaction()     // Catch: java.lang.Throwable -> L10
                if (r0 == 0) goto Ld
                r0 = 1
                goto Le
            Ld:
                r0 = 0
            Le:
                monitor-exit(r1)
                return r0
            L10:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.c.e():boolean");
        }

        public synchronized void a(String str) throws SQLException {
            boolean zE;
            try {
                d();
                this.f6162b.execSQL(str);
            } finally {
                if (zE) {
                }
            }
        }

        public synchronized void b() {
            d();
            if (this.f6162b == null) {
                return;
            }
            this.f6162b.setTransactionSuccessful();
        }

        public synchronized void c() {
            d();
            if (this.f6162b == null) {
                return;
            }
            this.f6162b.endTransaction();
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                d();
                cursorQuery = this.f6162b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (e()) {
                    throw th;
                }
                cursorQuery = bVar;
            }
            return cursorQuery;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                d();
                iUpdate = this.f6162b.update(str, contentValues, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long jInsert;
            try {
                d();
                jInsert = this.f6162b.insert(str, str2, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                jInsert = -1;
            }
            return jInsert;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                d();
                iDelete = this.f6162b.delete(str, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized void a() {
            d();
            if (this.f6162b == null) {
                return;
            }
            this.f6162b.beginTransaction();
        }
    }

    /* JADX INFO: compiled from: DBHelper.java */
    private class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f6158a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 4);
            this.f6158a = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.f.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.j.h.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d());
        }

        private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.f6158a);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    a(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.f6157b);
                    com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                } else {
                    a(sQLiteDatabase, f.this.f6157b);
                }
                if (i == 1) {
                    com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade.....执行表创建.....");
                    return;
                }
                if (i == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    return;
                }
                if (i == 3) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
                } else if (i == 4) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d());
                } else {
                    if (i != 5) {
                        return;
                    }
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListB = b(sQLiteDatabase);
            if (arrayListB == null || arrayListB.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListB.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}
