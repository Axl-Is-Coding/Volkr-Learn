package org.greenrobot.greendao.b;

import net.sqlcipher.database.SQLiteStatement;

/* JADX INFO: compiled from: EncryptedDatabaseStatement.java */
/* JADX INFO: loaded from: classes5.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteStatement f23566a;

    public e(SQLiteStatement sQLiteStatement) {
        this.f23566a = sQLiteStatement;
    }

    @Override // org.greenrobot.greendao.b.c
    public void a(int i, String str) {
        this.f23566a.bindString(i, str);
    }

    @Override // org.greenrobot.greendao.b.c
    public long b() {
        return this.f23566a.executeInsert();
    }

    @Override // org.greenrobot.greendao.b.c
    public long c() {
        return this.f23566a.simpleQueryForLong();
    }

    @Override // org.greenrobot.greendao.b.c
    public void close() {
        this.f23566a.close();
    }

    @Override // org.greenrobot.greendao.b.c
    public void d() {
        this.f23566a.clearBindings();
    }

    @Override // org.greenrobot.greendao.b.c
    public void execute() {
        this.f23566a.execute();
    }

    @Override // org.greenrobot.greendao.b.c
    public void a(int i, long j) {
        this.f23566a.bindLong(i, j);
    }

    @Override // org.greenrobot.greendao.b.c
    public Object a() {
        return this.f23566a;
    }
}
