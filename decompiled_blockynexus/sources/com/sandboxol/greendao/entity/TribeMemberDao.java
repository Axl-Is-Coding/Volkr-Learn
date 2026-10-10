package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class TribeMemberDao extends a<TribeMember, Long> {
    public static final String TABLENAME = "TRIBE_MEMBER";

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f UserId = new f(1, Long.TYPE, "userId", false, "USER_ID");
        public static final f LocalUserId = new f(2, Long.TYPE, "localUserId", false, "LOCAL_USER_ID");
        public static final f Experience = new f(3, Integer.TYPE, "experience", false, "EXPERIENCE");
        public static final f ExpireDate = new f(4, String.class, "expireDate", false, "EXPIRE_DATE");
        public static final f HeadPic = new f(5, String.class, "headPic", false, "HEAD_PIC");
        public static final f NickName = new f(6, String.class, "nickName", false, "NICK_NAME");
        public static final f Role = new f(7, Integer.TYPE, "role", false, "ROLE");
        public static final f Status = new f(8, Integer.TYPE, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, false, "STATUS");
        public static final f Vip = new f(9, Integer.TYPE, "vip", false, "VIP");
    }

    public TribeMemberDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"TRIBE_MEMBER\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" INTEGER NOT NULL ,\"LOCAL_USER_ID\" INTEGER NOT NULL ,\"EXPERIENCE\" INTEGER NOT NULL ,\"EXPIRE_DATE\" TEXT,\"HEAD_PIC\" TEXT,\"NICK_NAME\" TEXT,\"ROLE\" INTEGER NOT NULL ,\"STATUS\" INTEGER NOT NULL ,\"VIP\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"TRIBE_MEMBER\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public TribeMemberDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(TribeMember tribeMember) {
        if (tribeMember != null) {
            return tribeMember.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(TribeMember tribeMember) {
        return tribeMember.getID() != null;
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
    public final Long updateKeyAfterInsert(TribeMember tribeMember, long j) {
        tribeMember.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, TribeMember tribeMember) {
        cVar.d();
        Long id = tribeMember.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        cVar.a(2, tribeMember.getUserId());
        cVar.a(3, tribeMember.getLocalUserId());
        cVar.a(4, tribeMember.getExperience());
        String expireDate = tribeMember.getExpireDate();
        if (expireDate != null) {
            cVar.a(5, expireDate);
        }
        String headPic = tribeMember.getHeadPic();
        if (headPic != null) {
            cVar.a(6, headPic);
        }
        String nickName = tribeMember.getNickName();
        if (nickName != null) {
            cVar.a(7, nickName);
        }
        cVar.a(8, tribeMember.getRole());
        cVar.a(9, tribeMember.getStatus());
        cVar.a(10, tribeMember.getVip());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public TribeMember readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        long j = cursor.getLong(i + 1);
        long j2 = cursor.getLong(i + 2);
        int i3 = cursor.getInt(i + 3);
        int i4 = i + 4;
        String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 5;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 6;
        return new TribeMember(lValueOf, j, j2, i3, string, string2, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.getInt(i + 9));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, TribeMember tribeMember, int i) {
        int i2 = i + 0;
        tribeMember.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        tribeMember.setUserId(cursor.getLong(i + 1));
        tribeMember.setLocalUserId(cursor.getLong(i + 2));
        tribeMember.setExperience(cursor.getInt(i + 3));
        int i3 = i + 4;
        tribeMember.setExpireDate(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 5;
        tribeMember.setHeadPic(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 6;
        tribeMember.setNickName(cursor.isNull(i5) ? null : cursor.getString(i5));
        tribeMember.setRole(cursor.getInt(i + 7));
        tribeMember.setStatus(cursor.getInt(i + 8));
        tribeMember.setVip(cursor.getInt(i + 9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, TribeMember tribeMember) {
        sQLiteStatement.clearBindings();
        Long id = tribeMember.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, tribeMember.getUserId());
        sQLiteStatement.bindLong(3, tribeMember.getLocalUserId());
        sQLiteStatement.bindLong(4, tribeMember.getExperience());
        String expireDate = tribeMember.getExpireDate();
        if (expireDate != null) {
            sQLiteStatement.bindString(5, expireDate);
        }
        String headPic = tribeMember.getHeadPic();
        if (headPic != null) {
            sQLiteStatement.bindString(6, headPic);
        }
        String nickName = tribeMember.getNickName();
        if (nickName != null) {
            sQLiteStatement.bindString(7, nickName);
        }
        sQLiteStatement.bindLong(8, tribeMember.getRole());
        sQLiteStatement.bindLong(9, tribeMember.getStatus());
        sQLiteStatement.bindLong(10, tribeMember.getVip());
    }
}
