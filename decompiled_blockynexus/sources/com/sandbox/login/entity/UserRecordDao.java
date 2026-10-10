package com.sandbox.login.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes2.dex */
public class UserRecordDao extends a<UserRecord, Long> {
    public static final String TABLENAME = "USER_RECORD";

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f UserId = new f(1, String.class, "userId", false, "USER_ID");
        public static final f NickName = new f(2, String.class, "nickName", false, "NICK_NAME");
        public static final f Account = new f(3, String.class, GameSharedConstant.ACCOUNT, false, "ACCOUNT");
        public static final f Password = new f(4, String.class, "password", false, "PASSWORD");
        public static final f UserIcon = new f(5, String.class, "userIcon", false, "USER_ICON");
        public static final f LoginType = new f(6, String.class, "loginType", false, "LOGIN_TYPE");
        public static final f LoginTime = new f(7, Long.TYPE, "loginTime", false, "LOGIN_TIME");
        public static final f HasPassword = new f(8, Boolean.TYPE, "hasPassword", false, "HAS_PASSWORD");
    }

    public UserRecordDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER_RECORD\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" TEXT,\"NICK_NAME\" TEXT,\"ACCOUNT\" TEXT,\"PASSWORD\" TEXT,\"USER_ICON\" TEXT,\"LOGIN_TYPE\" TEXT,\"LOGIN_TIME\" INTEGER NOT NULL ,\"HAS_PASSWORD\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER_RECORD\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserRecordDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(UserRecord userRecord) {
        if (userRecord != null) {
            return userRecord.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(UserRecord userRecord) {
        return userRecord.getID() != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(UserRecord userRecord, long j) {
        userRecord.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, UserRecord userRecord) {
        cVar.d();
        Long id = userRecord.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        String userId = userRecord.getUserId();
        if (userId != null) {
            cVar.a(2, userId);
        }
        String nickName = userRecord.getNickName();
        if (nickName != null) {
            cVar.a(3, nickName);
        }
        String account = userRecord.getAccount();
        if (account != null) {
            cVar.a(4, account);
        }
        String password = userRecord.getPassword();
        if (password != null) {
            cVar.a(5, password);
        }
        String userIcon = userRecord.getUserIcon();
        if (userIcon != null) {
            cVar.a(6, userIcon);
        }
        String loginType = userRecord.getLoginType();
        if (loginType != null) {
            cVar.a(7, loginType);
        }
        cVar.a(8, userRecord.getLoginTime());
        cVar.a(9, userRecord.getHasPassword() ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public UserRecord readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        return new UserRecord(lValueOf, string, string2, string3, string4, string5, cursor.isNull(i8) ? null : cursor.getString(i8), cursor.getLong(i + 7), cursor.getShort(i + 8) != 0);
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, UserRecord userRecord, int i) {
        int i2 = i + 0;
        userRecord.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        userRecord.setUserId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        userRecord.setNickName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        userRecord.setAccount(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        userRecord.setPassword(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        userRecord.setUserIcon(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        userRecord.setLoginType(cursor.isNull(i8) ? null : cursor.getString(i8));
        userRecord.setLoginTime(cursor.getLong(i + 7));
        userRecord.setHasPassword(cursor.getShort(i + 8) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, UserRecord userRecord) {
        sQLiteStatement.clearBindings();
        Long id = userRecord.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String userId = userRecord.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(2, userId);
        }
        String nickName = userRecord.getNickName();
        if (nickName != null) {
            sQLiteStatement.bindString(3, nickName);
        }
        String account = userRecord.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(4, account);
        }
        String password = userRecord.getPassword();
        if (password != null) {
            sQLiteStatement.bindString(5, password);
        }
        String userIcon = userRecord.getUserIcon();
        if (userIcon != null) {
            sQLiteStatement.bindString(6, userIcon);
        }
        String loginType = userRecord.getLoginType();
        if (loginType != null) {
            sQLiteStatement.bindString(7, loginType);
        }
        sQLiteStatement.bindLong(8, userRecord.getLoginTime());
        sQLiteStatement.bindLong(9, userRecord.getHasPassword() ? 1L : 0L);
    }
}
