package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.x;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CCDBManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f20965b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f20966d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f20967a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f20968c;

    /* JADX INFO: compiled from: CCDBManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final z f20969a = new z();

        private a() {
        }
    }

    public static z a(Context context) {
        if (f20966d == null && context != null) {
            f20966d = context.getApplicationContext();
            f20965b = y.a(f20966d);
        }
        return a.f20969a;
    }

    public synchronized void b() {
        try {
            if (this.f20967a.decrementAndGet() == 0) {
                this.f20968c.close();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String c() {
        SQLiteDatabase sQLiteDatabase;
        String str = "";
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    Cursor cursorRawQuery = this.f20968c.rawQuery("select *  from __cc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            str = str + String.format("timeStamp = %s, content = %s, active = %s", cursorRawQuery.getString(cursorRawQuery.getColumnIndex(x.a.C0179a.f20955a)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__c")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"))) + UMCustomLogInfoBuilder.LINE_SEP;
                        }
                    }
                    this.f20968c.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            } catch (Throwable unused2) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
            b();
            return str;
        } catch (Throwable th) {
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused3) {
            }
            b();
            throw th;
        }
    }

    public ae d() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorRawQuery;
        ae aeVar = new ae();
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    cursorRawQuery = this.f20968c.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                } catch (Throwable unused) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            } catch (Throwable unused2) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (cursorRawQuery == null || !cursorRawQuery.moveToNext()) {
                this.f20968c.setTransactionSuccessful();
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                    sQLiteDatabase.endTransaction();
                }
                b();
                return aeVar;
            }
            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(x.a.C0179a.f20955a));
            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__c"));
            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
            ULog.i("jessie", "[DbManager] selectRecentActiveOne" + (String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + UMCustomLogInfoBuilder.LINE_SEP));
            ae aeVar2 = new ae();
            aeVar2.a(string);
            aeVar2.b(string2);
            aeVar2.c(string3);
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused3) {
            }
            b();
            return aeVar2;
        } catch (Throwable th) {
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused4) {
            }
            b();
            throw th;
        }
    }

    public boolean e() {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    Cursor cursorRawQuery = this.f20968c.rawQuery("select *  from __cc where __a=\"0\" order by __ts asc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(x.a.C0179a.f20955a)));
                        }
                    }
                    int size = arrayList.size() - 5;
                    if (size > 0) {
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str = i != size - 1 ? str + "__ts=\"" + ((String) arrayList.get(i)) + "\" or " : str + "__ts=\"" + ((String) arrayList.get(i)) + "\"";
                        }
                        String str2 = "delete from __cc where " + str;
                        ULog.i("jessie", "[DbManager] deleteExtraCloudConfigInfo: " + str2);
                        this.f20968c.execSQL(str2);
                        this.f20968c.setTransactionSuccessful();
                    }
                } catch (Throwable unused) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            } catch (Throwable unused2) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
            b();
            return false;
        } catch (Throwable th) {
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused3) {
            }
            b();
            throw th;
        }
    }

    public ae f() {
        SQLiteDatabase sQLiteDatabase;
        ae aeVar = new ae();
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    Cursor cursorRawQuery = this.f20968c.rawQuery("select *  from __cc order by __ts desc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(x.a.C0179a.f20955a));
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__c"));
                            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                            ULog.i("jessie", "[DbManager] getLastestConfigInfo" + (String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + UMCustomLogInfoBuilder.LINE_SEP));
                            aeVar.a(string);
                            aeVar.b(string2);
                            aeVar.c(string3);
                            if (string != null) {
                                try {
                                    if (this.f20968c != null) {
                                        this.f20968c.endTransaction();
                                    }
                                } catch (Throwable unused) {
                                }
                                b();
                                return aeVar;
                            }
                        }
                    }
                    this.f20968c.setTransactionSuccessful();
                } catch (Throwable unused2) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            } catch (Throwable unused3) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
            b();
            return aeVar;
        } catch (Throwable th) {
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused4) {
            }
            b();
            throw th;
        }
    }

    private z() {
        this.f20967a = new AtomicInteger();
    }

    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    Cursor cursorRawQuery = this.f20968c.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(x.a.C0179a.f20955a));
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__c"));
                            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                            String str2 = String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + UMCustomLogInfoBuilder.LINE_SEP;
                            ae aeVar = new ae();
                            aeVar.a(string);
                            aeVar.b(string2);
                            aeVar.c(string3);
                            if (!TextUtils.isEmpty(string) && !str.equals(string)) {
                                arrayList.add(aeVar);
                            }
                        }
                    }
                    int size = arrayList.size();
                    String str3 = "";
                    for (int i = 0; i < size; i++) {
                        ae aeVar2 = (ae) arrayList.get(i);
                        str3 = i != size - 1 ? str3 + "__ts=\"" + aeVar2.a() + "\" or " : str3 + "__ts=\"" + aeVar2.a() + "\"";
                        String str4 = "update  __cc set __a=\"0\" where " + str3;
                        ULog.i("jessie", "[DbManager] updateOtherCloudConfigInfo : " + str4);
                        this.f20968c.execSQL(str4);
                        this.f20968c.setTransactionSuccessful();
                    }
                } catch (Throwable unused) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                try {
                    if (this.f20968c != null) {
                        this.f20968c.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
                b();
                return false;
            } catch (Throwable unused3) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
            b();
            return true;
        } catch (Throwable th) {
            try {
                if (this.f20968c != null) {
                    this.f20968c.endTransaction();
                }
            } catch (Throwable unused4) {
            }
            b();
            throw th;
        }
    }

    public synchronized SQLiteDatabase a() {
        if (this.f20967a.incrementAndGet() == 1) {
            this.f20968c = f20965b.getWritableDatabase();
        }
        return this.f20968c;
    }

    public void a(String str, String str2, String str3) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                try {
                    a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(x.a.C0179a.f20955a, str);
                    contentValues.put("__c", str2);
                    contentValues.put("__a", str3);
                    ULog.i("jessie", "[DbManager] insert timeStamp: " + str + " content: " + str2 + " active: " + str3);
                    this.f20968c.insert(x.a.f20954a, null, contentValues);
                    this.f20968c.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        if (this.f20968c != null) {
                            this.f20968c.endTransaction();
                        }
                    } catch (Throwable unused) {
                    }
                    b();
                    throw th;
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                ULog.i("jessie", "[DbManager] insert failed");
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            } catch (Throwable unused3) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        b();
    }

    public boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                try {
                    a();
                    this.f20968c.beginTransaction();
                    String str2 = "update  __cc set __a=\"1\" where __ts=\"" + str + "\"";
                    ULog.i("jessie", "[DbManager] updateCloudConfigByTimestamp：" + str2);
                    this.f20968c.execSQL(str2);
                    this.f20968c.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        if (this.f20968c != null) {
                            this.f20968c.endTransaction();
                        }
                    } catch (Throwable unused) {
                    }
                    b();
                    throw th;
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e2.printStackTrace();
                try {
                    if (this.f20968c != null) {
                        this.f20968c.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
                b();
                return false;
            } catch (Throwable unused3) {
                if (this.f20968c != null) {
                    sQLiteDatabase = this.f20968c;
                }
            }
            if (this.f20968c != null) {
                sQLiteDatabase = this.f20968c;
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        b();
        return true;
    }
}
