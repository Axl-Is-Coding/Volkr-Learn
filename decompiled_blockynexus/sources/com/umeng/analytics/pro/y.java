package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: CCDBHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class y extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20961a = "cc.db";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f20962c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20963b;

    /* JADX INFO: compiled from: CCDBHelper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final y f20964a = new y(y.f20962c);

        private a() {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private y(Context context) {
        super(context, "cc.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f20963b = null;
    }

    public static y a(Context context) {
        if (f20962c == null) {
            f20962c = context.getApplicationContext();
        }
        return a.f20964a;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f20963b = "create table if not exists __cc(id INTEGER primary key autoincrement, __ts TEXT, __c TEXT, __a TEXT)";
            sQLiteDatabase.execSQL(this.f20963b);
        } catch (SQLException unused) {
        }
    }
}
