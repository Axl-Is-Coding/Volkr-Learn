package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class UserGameRecordInfoDao extends a<UserGameRecordInfo, Long> {
    public static final String TABLENAME = "USER_GAME_RECORD_INFO";

    public static class Properties {
        public static final f UserId = new f(0, Long.TYPE, "userId", true, ay.f20688d);
        public static final f IsPlayed = new f(1, Boolean.TYPE, "isPlayed", false, "IS_PLAYED");
        public static final f IsSignIn = new f(2, Boolean.TYPE, "isSignIn", false, "IS_SIGN_IN");
    }

    public UserGameRecordInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER_GAME_RECORD_INFO\" (\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"IS_PLAYED\" INTEGER NOT NULL ,\"IS_SIGN_IN\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER_GAME_RECORD_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserGameRecordInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(UserGameRecordInfo userGameRecordInfo) {
        if (userGameRecordInfo != null) {
            return Long.valueOf(userGameRecordInfo.getUserId());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(UserGameRecordInfo userGameRecordInfo) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(UserGameRecordInfo userGameRecordInfo, long j) {
        userGameRecordInfo.setUserId(j);
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, UserGameRecordInfo userGameRecordInfo) {
        cVar.d();
        cVar.a(1, userGameRecordInfo.getUserId());
        cVar.a(2, userGameRecordInfo.getIsPlayed() ? 1L : 0L);
        cVar.a(3, userGameRecordInfo.getIsSignIn() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public UserGameRecordInfo readEntity(Cursor cursor, int i) {
        return new UserGameRecordInfo(cursor.getLong(i + 0), cursor.getShort(i + 1) != 0, cursor.getShort(i + 2) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, UserGameRecordInfo userGameRecordInfo) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, userGameRecordInfo.getUserId());
        sQLiteStatement.bindLong(2, userGameRecordInfo.getIsPlayed() ? 1L : 0L);
        sQLiteStatement.bindLong(3, userGameRecordInfo.getIsSignIn() ? 1L : 0L);
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, UserGameRecordInfo userGameRecordInfo, int i) {
        userGameRecordInfo.setUserId(cursor.getLong(i + 0));
        userGameRecordInfo.setIsPlayed(cursor.getShort(i + 1) != 0);
        userGameRecordInfo.setIsSignIn(cursor.getShort(i + 2) != 0);
    }
}
