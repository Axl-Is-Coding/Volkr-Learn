package org.greenrobot.greendao.b;

import android.database.Cursor;
import android.database.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: compiled from: EncryptedDatabase.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f23565a;

    public d(SQLiteDatabase sQLiteDatabase) {
        this.f23565a = sQLiteDatabase;
    }

    @Override // org.greenrobot.greendao.b.a
    public void D() {
        this.f23565a.beginTransaction();
    }

    @Override // org.greenrobot.greendao.b.a
    public void E() {
        this.f23565a.setTransactionSuccessful();
    }

    @Override // org.greenrobot.greendao.b.a
    public void F() {
        this.f23565a.endTransaction();
    }

    @Override // org.greenrobot.greendao.b.a
    public Cursor a(String str, String[] strArr) {
        return this.f23565a.rawQuery(str, strArr);
    }

    @Override // org.greenrobot.greendao.b.a
    public c b(String str) {
        return new e(this.f23565a.compileStatement(str));
    }

    @Override // org.greenrobot.greendao.b.a
    public void a(String str) throws SQLException {
        this.f23565a.execSQL(str);
    }

    @Override // org.greenrobot.greendao.b.a
    public boolean b() {
        return this.f23565a.isDbLockedByCurrentThread();
    }

    @Override // org.greenrobot.greendao.b.a
    public void a(String str, Object[] objArr) throws SQLException {
        this.f23565a.execSQL(str, objArr);
    }

    @Override // org.greenrobot.greendao.b.a
    public Object a() {
        return this.f23565a;
    }
}
