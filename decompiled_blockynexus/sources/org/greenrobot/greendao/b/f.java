package org.greenrobot.greendao.b;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: StandardDatabase.java */
/* JADX INFO: loaded from: classes5.dex */
public class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f23567a;

    public f(SQLiteDatabase sQLiteDatabase) {
        this.f23567a = sQLiteDatabase;
    }

    @Override // org.greenrobot.greendao.b.a
    public void D() {
        this.f23567a.beginTransaction();
    }

    @Override // org.greenrobot.greendao.b.a
    public void E() {
        this.f23567a.setTransactionSuccessful();
    }

    @Override // org.greenrobot.greendao.b.a
    public void F() {
        this.f23567a.endTransaction();
    }

    @Override // org.greenrobot.greendao.b.a
    public Cursor a(String str, String[] strArr) {
        return this.f23567a.rawQuery(str, strArr);
    }

    @Override // org.greenrobot.greendao.b.a
    public c b(String str) {
        return new g(this.f23567a.compileStatement(str));
    }

    @Override // org.greenrobot.greendao.b.a
    public void a(String str) throws SQLException {
        this.f23567a.execSQL(str);
    }

    @Override // org.greenrobot.greendao.b.a
    public boolean b() {
        return this.f23567a.isDbLockedByCurrentThread();
    }

    @Override // org.greenrobot.greendao.b.a
    public void a(String str, Object[] objArr) throws SQLException {
        this.f23567a.execSQL(str, objArr);
    }

    @Override // org.greenrobot.greendao.b.a
    public Object a() {
        return this.f23567a;
    }
}
