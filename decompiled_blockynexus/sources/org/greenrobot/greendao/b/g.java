package org.greenrobot.greendao.b;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: StandardDatabaseStatement.java */
/* JADX INFO: loaded from: classes5.dex */
public class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteStatement f23568a;

    public g(SQLiteStatement sQLiteStatement) {
        this.f23568a = sQLiteStatement;
    }

    @Override // org.greenrobot.greendao.b.c
    public void a(int i, String str) {
        this.f23568a.bindString(i, str);
    }

    @Override // org.greenrobot.greendao.b.c
    public long b() {
        return this.f23568a.executeInsert();
    }

    @Override // org.greenrobot.greendao.b.c
    public long c() {
        return this.f23568a.simpleQueryForLong();
    }

    @Override // org.greenrobot.greendao.b.c
    public void close() {
        this.f23568a.close();
    }

    @Override // org.greenrobot.greendao.b.c
    public void d() {
        this.f23568a.clearBindings();
    }

    @Override // org.greenrobot.greendao.b.c
    public void execute() {
        this.f23568a.execute();
    }

    @Override // org.greenrobot.greendao.b.c
    public void a(int i, long j) {
        this.f23568a.bindLong(i, j);
    }

    @Override // org.greenrobot.greendao.b.c
    public Object a() {
        return this.f23568a;
    }
}
