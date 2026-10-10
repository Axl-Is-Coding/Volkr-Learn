package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class UserCacheDao extends a<UserCache, Long> {
    public static final String TABLENAME = "USER_CACHE";

    public static class Properties {
        public static final f UserId = new f(0, Long.TYPE, "userId", true, ay.f20688d);
        public static final f IsShowGoldDiamondDialog = new f(1, Boolean.TYPE, "isShowGoldDiamondDialog", false, "IS_SHOW_GOLD_DIAMOND_DIALOG");
        public static final f IsShowPasswordSettingDialog = new f(2, Boolean.TYPE, "isShowPasswordSettingDialog", false, "IS_SHOW_PASSWORD_SETTING_DIALOG");
        public static final f IsDiamondsOver100 = new f(3, Boolean.TYPE, "isDiamondsOver100", false, "IS_DIAMONDS_OVER100");
        public static final f IsExistGamePay = new f(4, Boolean.TYPE, "isExistGamePay", false, "IS_EXIST_GAME_PAY");
    }

    public UserCacheDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER_CACHE\" (\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"IS_SHOW_GOLD_DIAMOND_DIALOG\" INTEGER NOT NULL ,\"IS_SHOW_PASSWORD_SETTING_DIALOG\" INTEGER NOT NULL ,\"IS_DIAMONDS_OVER100\" INTEGER NOT NULL ,\"IS_EXIST_GAME_PAY\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER_CACHE\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserCacheDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(UserCache userCache) {
        if (userCache != null) {
            return Long.valueOf(userCache.getUserId());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(UserCache userCache) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(UserCache userCache, long j) {
        userCache.setUserId(j);
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, UserCache userCache) {
        cVar.d();
        cVar.a(1, userCache.getUserId());
        cVar.a(2, userCache.getIsShowGoldDiamondDialog() ? 1L : 0L);
        cVar.a(3, userCache.getIsShowPasswordSettingDialog() ? 1L : 0L);
        cVar.a(4, userCache.getIsDiamondsOver100() ? 1L : 0L);
        cVar.a(5, userCache.getIsExistGamePay() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public UserCache readEntity(Cursor cursor, int i) {
        return new UserCache(cursor.getLong(i + 0), cursor.getShort(i + 1) != 0, cursor.getShort(i + 2) != 0, cursor.getShort(i + 3) != 0, cursor.getShort(i + 4) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, UserCache userCache) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, userCache.getUserId());
        sQLiteStatement.bindLong(2, userCache.getIsShowGoldDiamondDialog() ? 1L : 0L);
        sQLiteStatement.bindLong(3, userCache.getIsShowPasswordSettingDialog() ? 1L : 0L);
        sQLiteStatement.bindLong(4, userCache.getIsDiamondsOver100() ? 1L : 0L);
        sQLiteStatement.bindLong(5, userCache.getIsExistGamePay() ? 1L : 0L);
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, UserCache userCache, int i) {
        userCache.setUserId(cursor.getLong(i + 0));
        userCache.setIsShowGoldDiamondDialog(cursor.getShort(i + 1) != 0);
        userCache.setIsShowPasswordSettingDialog(cursor.getShort(i + 2) != 0);
        userCache.setIsDiamondsOver100(cursor.getShort(i + 3) != 0);
        userCache.setIsExistGamePay(cursor.getShort(i + 4) != 0);
    }
}
