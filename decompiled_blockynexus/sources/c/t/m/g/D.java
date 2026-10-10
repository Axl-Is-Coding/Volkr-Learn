package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class D extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, D> f2890a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2891b = new Object();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2893b;

        public a(long j, String str) {
            this.f2892a = j;
            this.f2893b = str;
        }

        public a(long j, String str, byte b2) {
            this(j, str);
        }
    }

    private D(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private int a(boolean z, boolean z2) {
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                cursorQuery = (z && z2) ? writableDatabase.query("halley_action_tbl", new String[]{"key"}, null, null, null, null, null) : z ? writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"add"}, null, null, null) : writableDatabase.query("halley_action_tbl", new String[]{"key"}, "state=?", new String[]{"remove"}, null, null, null);
                count = cursorQuery != null ? cursorQuery.getCount() : 0;
            } catch (Throwable th) {
                th.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return count;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static D a(String str) {
        D d2;
        synchronized (f2891b) {
            d2 = f2890a.get(str);
            if (d2 == null) {
                fc.b();
                D d3 = new D(fc.a(), "HalleyAction_" + fc.c() + "_" + fc.i() + "_" + str + com.umeng.analytics.process.a.f20990d);
                f2890a.put(str, d3);
                d2 = d3;
            }
        }
        return d2;
    }

    public final boolean a(int i) {
        if (a(true, true) <= i) {
            return false;
        }
        try {
            getWritableDatabase().delete("halley_action_tbl", null, null);
            return true;
        } catch (Exception unused) {
            if (a(true, true) <= i) {
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
                } catch (SQLException unused2) {
                }
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
                    return false;
                } catch (SQLException e2) {
                    throw e2;
                }
            } catch (Throwable unused3) {
                return false;
            }
        }
    }

    public final long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", str);
            contentValues.put(ServerProtocol.DIALOG_PARAM_STATE, "add");
            return writableDatabase.insert("halley_action_tbl", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[PHI: r1
      0x0068: PHI (r1v3 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:18:0x0066, B:12:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<c.t.m.g.D.a> b(int r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.getWritableDatabase()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            java.lang.String r3 = "halley_action_tbl"
            r4 = 0
            java.lang.String r5 = "state=?"
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            java.lang.String r7 = "add"
            r11 = 0
            r6[r11] = r7     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            if (r1 == 0) goto L5d
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            int r13 = java.lang.Math.min(r2, r13)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            if (r2 == 0) goto L5d
            r2 = 0
        L2f:
            java.lang.String r3 = "key"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            java.lang.String r5 = "data"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            java.lang.String r6 = "state"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            r1.getString(r6)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            c.t.m.g.D$a r6 = new c.t.m.g.D$a     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            r6.<init>(r3, r5, r11)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            r0.add(r6)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            int r2 = r2 + r10
            if (r2 >= r13) goto L5d
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L62
            if (r3 != 0) goto L2f
        L5d:
            if (r1 == 0) goto L6b
            goto L68
        L60:
            r13 = move-exception
            goto L6c
        L62:
            r13 = move-exception
            r13.printStackTrace()     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L6b
        L68:
            r1.close()
        L6b:
            return r0
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            goto L73
        L72:
            throw r13
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.D.b(int):java.util.List");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
        } catch (SQLException e2) {
            throw e2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
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
                if (version < 2) {
                    onUpgrade(sQLiteDatabase, version, 2);
                } else if (version > 2) {
                    onDowngrade(sQLiteDatabase, version, 2);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (SQLException unused) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            } catch (SQLException e2) {
                throw e2;
            }
        } catch (Exception unused2) {
        }
    }

    public final void a(List<Long> list) {
        if (list.size() <= 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ServerProtocol.DIALOG_PARAM_STATE, "remove");
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                writableDatabase.update("halley_action_tbl", contentValues, "key=?", new String[]{String.valueOf(it.next().longValue())});
            }
            Iterator<Long> it2 = list.iterator();
            while (it2.hasNext()) {
                writableDatabase.delete("halley_action_tbl", "key=?", new String[]{String.valueOf(it2.next().longValue())});
            }
            if (a(false, true) <= 0 || a(true, false) > 0) {
                return;
            }
            try {
                writableDatabase.execSQL("DROP TABLE IF EXISTS halley_action_tbl");
            } catch (SQLException unused) {
            }
            try {
                writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_action_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT,state TEXT);");
            } catch (SQLException e2) {
                throw e2;
            }
        } catch (Exception unused2) {
        }
    }
}
