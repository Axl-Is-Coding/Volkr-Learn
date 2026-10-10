package com.sandboxol.greendao.entity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.b;
import org.greenrobot.greendao.b.a;
import org.greenrobot.greendao.b.f;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes3.dex */
public class DaoMaster extends b {
    public static final int SCHEMA_VERSION = 88;

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
            super(context, str, 88);
        }

        @Override // org.greenrobot.greendao.b.b
        public void onCreate(a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 88");
            DaoMaster.createAllTables(aVar, false);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 88);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new f(sQLiteDatabase));
    }

    public static void createAllTables(a aVar, boolean z) {
        FloatViewInfoDao.createTable(aVar, z);
        PartyMemberInfoDao.createTable(aVar, z);
        UserCacheDao.createTable(aVar, z);
        VideoDetailInfoDao.createTable(aVar, z);
        TribeMemberDao.createTable(aVar, z);
        FriendDao.createTable(aVar, z);
        UserDao.createTable(aVar, z);
        UserGameRecordInfoDao.createTable(aVar, z);
        ScrapTreasureRewardInfoDao.createTable(aVar, z);
        GameDiskCacheInfoDao.createTable(aVar, z);
        VideoInfoDao.createTable(aVar, z);
        FriendPartyStatusDao.createTable(aVar, z);
        TeamUIMessageDao.createTable(aVar, z);
        UserInfoDao.createTable(aVar, z);
        GameDao.createTable(aVar, z);
    }

    public static void dropAllTables(a aVar, boolean z) {
        FloatViewInfoDao.dropTable(aVar, z);
        PartyMemberInfoDao.dropTable(aVar, z);
        UserCacheDao.dropTable(aVar, z);
        VideoDetailInfoDao.dropTable(aVar, z);
        TribeMemberDao.dropTable(aVar, z);
        FriendDao.dropTable(aVar, z);
        UserDao.dropTable(aVar, z);
        UserGameRecordInfoDao.dropTable(aVar, z);
        ScrapTreasureRewardInfoDao.dropTable(aVar, z);
        GameDiskCacheInfoDao.dropTable(aVar, z);
        VideoInfoDao.dropTable(aVar, z);
        FriendPartyStatusDao.dropTable(aVar, z);
        TeamUIMessageDao.dropTable(aVar, z);
        UserInfoDao.dropTable(aVar, z);
        GameDao.dropTable(aVar, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(a aVar) {
        super(aVar, 88);
        registerDaoClass(FloatViewInfoDao.class);
        registerDaoClass(PartyMemberInfoDao.class);
        registerDaoClass(UserCacheDao.class);
        registerDaoClass(VideoDetailInfoDao.class);
        registerDaoClass(TribeMemberDao.class);
        registerDaoClass(FriendDao.class);
        registerDaoClass(UserDao.class);
        registerDaoClass(UserGameRecordInfoDao.class);
        registerDaoClass(ScrapTreasureRewardInfoDao.class);
        registerDaoClass(GameDiskCacheInfoDao.class);
        registerDaoClass(VideoInfoDao.class);
        registerDaoClass(FriendPartyStatusDao.class);
        registerDaoClass(TeamUIMessageDao.class);
        registerDaoClass(UserInfoDao.class);
        registerDaoClass(GameDao.class);
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
