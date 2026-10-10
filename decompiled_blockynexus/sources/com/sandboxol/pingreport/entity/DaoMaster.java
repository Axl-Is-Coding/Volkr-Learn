package com.sandboxol.pingreport.entity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.b;
import org.greenrobot.greendao.b.a;
import org.greenrobot.greendao.b.f;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes4.dex */
public class DaoMaster extends b {
    public static final int SCHEMA_VERSION = 70;

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        @Override // org.greenrobot.greendao.b.b
        public void onUpgrade(a aVar, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            DaoMaster.dropAllTables(aVar, true);
            onCreate(aVar);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }
    }

    public static abstract class OpenHelper extends org.greenrobot.greendao.b.b {
        public OpenHelper(Context context, String str) {
            super(context, str, 70);
        }

        @Override // org.greenrobot.greendao.b.b
        public void onCreate(a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 70");
            DaoMaster.createAllTables(aVar, false);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 70);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new f(sQLiteDatabase));
    }

    public static void createAllTables(a aVar, boolean z) {
        PingEventDao.createTable(aVar, z);
    }

    public static void dropAllTables(a aVar, boolean z) {
        PingEventDao.dropTable(aVar, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(a aVar) {
        super(aVar, 70);
        registerDaoClass(PingEventDao.class);
    }

    @Override // org.greenrobot.greendao.b
    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.b
    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }
}
