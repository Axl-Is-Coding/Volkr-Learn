package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class PartyMemberInfoDao extends a<PartyMemberInfo, Long> {
    public static final String TABLENAME = "PARTY_MEMBER_INFO";

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f UserId = new f(1, Long.TYPE, "userId", false, "USER_ID");
        public static final f LocalUserId = new f(2, Long.TYPE, "localUserId", false, "LOCAL_USER_ID");
        public static final f NickName = new f(3, String.class, "nickName", false, "NICK_NAME");
        public static final f PicUrl = new f(4, String.class, "picUrl", false, "PIC_URL");
    }

    public PartyMemberInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PARTY_MEMBER_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" INTEGER NOT NULL ,\"LOCAL_USER_ID\" INTEGER NOT NULL ,\"NICK_NAME\" TEXT,\"PIC_URL\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PARTY_MEMBER_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public PartyMemberInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(PartyMemberInfo partyMemberInfo) {
        if (partyMemberInfo != null) {
            return partyMemberInfo.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(PartyMemberInfo partyMemberInfo) {
        return partyMemberInfo.getID() != null;
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
    public final Long updateKeyAfterInsert(PartyMemberInfo partyMemberInfo, long j) {
        partyMemberInfo.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, PartyMemberInfo partyMemberInfo) {
        cVar.d();
        Long id = partyMemberInfo.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        cVar.a(2, partyMemberInfo.getUserId());
        cVar.a(3, partyMemberInfo.getLocalUserId());
        String nickName = partyMemberInfo.getNickName();
        if (nickName != null) {
            cVar.a(4, nickName);
        }
        String picUrl = partyMemberInfo.getPicUrl();
        if (picUrl != null) {
            cVar.a(5, picUrl);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public PartyMemberInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        long j = cursor.getLong(i + 1);
        long j2 = cursor.getLong(i + 2);
        int i3 = i + 3;
        int i4 = i + 4;
        return new PartyMemberInfo(lValueOf, j, j2, cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, PartyMemberInfo partyMemberInfo, int i) {
        int i2 = i + 0;
        partyMemberInfo.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        partyMemberInfo.setUserId(cursor.getLong(i + 1));
        partyMemberInfo.setLocalUserId(cursor.getLong(i + 2));
        int i3 = i + 3;
        partyMemberInfo.setNickName(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        partyMemberInfo.setPicUrl(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, PartyMemberInfo partyMemberInfo) {
        sQLiteStatement.clearBindings();
        Long id = partyMemberInfo.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, partyMemberInfo.getUserId());
        sQLiteStatement.bindLong(3, partyMemberInfo.getLocalUserId());
        String nickName = partyMemberInfo.getNickName();
        if (nickName != null) {
            sQLiteStatement.bindString(4, nickName);
        }
        String picUrl = partyMemberInfo.getPicUrl();
        if (picUrl != null) {
            sQLiteStatement.bindString(5, picUrl);
        }
    }
}
