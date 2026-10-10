package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class UserInfoDao extends a<UserInfo, String> {
    public static final String TABLENAME = "USER_INFO";

    public static class Properties {
        public static final f Id = new f(0, String.class, "id", true, "ID");
        public static final f Name = new f(1, String.class, "name", false, "NAME");
        public static final f PortraitUri = new f(2, String.class, "portraitUri", false, "PORTRAIT_URI");
    }

    public UserInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER_INFO\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"NAME\" TEXT,\"PORTRAIT_URI\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public String getKey(UserInfo userInfo) {
        if (userInfo != null) {
            return userInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(UserInfo userInfo) {
        return userInfo.getId() != null;
    }

    @Override // org.greenrobot.greendao.a
    public String readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final String updateKeyAfterInsert(UserInfo userInfo, long j) {
        return userInfo.getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, UserInfo userInfo) {
        cVar.d();
        String id = userInfo.getId();
        if (id != null) {
            cVar.a(1, id);
        }
        String name = userInfo.getName();
        if (name != null) {
            cVar.a(2, name);
        }
        String portraitUri = userInfo.getPortraitUri();
        if (portraitUri != null) {
            cVar.a(3, portraitUri);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public UserInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        return new UserInfo(cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, UserInfo userInfo, int i) {
        int i2 = i + 0;
        userInfo.setId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        userInfo.setName(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        userInfo.setPortraitUri(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, UserInfo userInfo) {
        sQLiteStatement.clearBindings();
        String id = userInfo.getId();
        if (id != null) {
            sQLiteStatement.bindString(1, id);
        }
        String name = userInfo.getName();
        if (name != null) {
            sQLiteStatement.bindString(2, name);
        }
        String portraitUri = userInfo.getPortraitUri();
        if (portraitUri != null) {
            sQLiteStatement.bindString(3, portraitUri);
        }
    }
}
