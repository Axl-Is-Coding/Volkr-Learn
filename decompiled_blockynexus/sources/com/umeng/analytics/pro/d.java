package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.c;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: classes5.dex */
class d extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f20851b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20852a;

    /* JADX INFO: compiled from: UMDBCreater.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f20853a = new d(d.f20851b, f.b(d.f20851b), c.f20766b, null, 2);

        private a() {
        }
    }

    public static d a(Context context) {
        if (f20851b == null) {
            f20851b = context.getApplicationContext();
        }
        return a.f20853a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f20852a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f20852a);
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f20852a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f20852a);
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!f.a(sQLiteDatabase, c.d.f20807a, "__av")) {
            f.a(sQLiteDatabase, c.d.f20807a, "__sp", "TEXT");
            f.a(sQLiteDatabase, c.d.f20807a, "__pp", "TEXT");
            f.a(sQLiteDatabase, c.d.f20807a, "__av", "TEXT");
            f.a(sQLiteDatabase, c.d.f20807a, "__vc", "TEXT");
        }
        if (!f.a(sQLiteDatabase, c.b.f20781a, "__av")) {
            f.a(sQLiteDatabase, c.b.f20781a, "__av", "TEXT");
            f.a(sQLiteDatabase, c.b.f20781a, "__vc", "TEXT");
        }
        if (f.a(sQLiteDatabase, c.a.f20770a, "__av")) {
            return;
        }
        f.a(sQLiteDatabase, c.a.f20770a, "__av", "TEXT");
        f.a(sQLiteDatabase, c.a.f20770a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, c.d.f20807a);
        a(sQLiteDatabase, c.b.f20781a);
        a(sQLiteDatabase, c.a.f20770a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            f.a(f20851b);
            if (sQLiteDatabase != null) {
            }
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused4) {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private d(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new com.umeng.analytics.pro.a(context, str), str2, cursorFactory, i);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f20852a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f20852a);
        } catch (SQLException unused) {
        }
    }

    private d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? c.f20766b : str, cursorFactory, i);
        this.f20852a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!f.a(c.d.f20807a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!f.a(c.C0178c.f20794a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!f.a(c.b.f20781a, writableDatabase)) {
                b(writableDatabase);
            }
            if (f.a(c.a.f20770a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f20852a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f20852a);
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
