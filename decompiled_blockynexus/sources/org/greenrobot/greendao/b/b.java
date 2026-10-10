package org.greenrobot.greendao.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: compiled from: DatabaseOpenHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends SQLiteOpenHelper {
    private final Context context;
    private a encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    /* JADX INFO: compiled from: DatabaseOpenHelper.java */
    private class a extends net.sqlcipher.database.SQLiteOpenHelper {
        public a(Context context, String str, int i, boolean z) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            if (z) {
                SQLiteDatabase.loadLibs(context);
            }
        }

        protected org.greenrobot.greendao.b.a a(SQLiteDatabase sQLiteDatabase) {
            return new d(sQLiteDatabase);
        }
    }

    public b(Context context, String str, int i) {
        this(context, str, null, i);
    }

    private a checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            this.encryptedHelper = new a(this.context, this.name, this.version, this.loadSQLCipherNativeLibs);
        }
        return this.encryptedHelper;
    }

    public org.greenrobot.greendao.b.a getEncryptedReadableDb(String str) {
        a aVarCheckEncryptedHelper = checkEncryptedHelper();
        return aVarCheckEncryptedHelper.a(aVarCheckEncryptedHelper.getReadableDatabase(str));
    }

    public org.greenrobot.greendao.b.a getEncryptedWritableDb(String str) {
        a aVarCheckEncryptedHelper = checkEncryptedHelper();
        return aVarCheckEncryptedHelper.a(aVarCheckEncryptedHelper.getWritableDatabase(str));
    }

    public org.greenrobot.greendao.b.a getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public org.greenrobot.greendao.b.a getWritableDb() {
        return wrap(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public abstract void onCreate(org.greenrobot.greendao.b.a aVar);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    public void onOpen(org.greenrobot.greendao.b.a aVar) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(wrap(sQLiteDatabase), i, i2);
    }

    public void onUpgrade(org.greenrobot.greendao.b.a aVar, int i, int i2) {
    }

    public void setLoadSQLCipherNativeLibs(boolean z) {
        this.loadSQLCipherNativeLibs = z;
    }

    protected org.greenrobot.greendao.b.a wrap(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        return new f(sQLiteDatabase);
    }

    public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i;
    }

    public org.greenrobot.greendao.b.a getEncryptedReadableDb(char[] cArr) {
        a aVarCheckEncryptedHelper = checkEncryptedHelper();
        return aVarCheckEncryptedHelper.a(aVarCheckEncryptedHelper.getReadableDatabase(cArr));
    }

    public org.greenrobot.greendao.b.a getEncryptedWritableDb(char[] cArr) {
        a aVarCheckEncryptedHelper = checkEncryptedHelper();
        return aVarCheckEncryptedHelper.a(aVarCheckEncryptedHelper.getWritableDatabase(cArr));
    }
}
