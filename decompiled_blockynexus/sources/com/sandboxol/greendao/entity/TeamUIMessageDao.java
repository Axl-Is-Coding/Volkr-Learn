package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class TeamUIMessageDao extends a<TeamUIMessage, Long> {
    public static final String TABLENAME = "TEAM_UIMESSAGE";

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f UserId = new f(1, Long.TYPE, "userId", false, "USER_ID");
        public static final f MessageId = new f(2, Integer.TYPE, "messageId", false, "MESSAGE_ID");
        public static final f SentTime = new f(3, Long.TYPE, "sentTime", false, "SENT_TIME");
    }

    public TeamUIMessageDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"TEAM_UIMESSAGE\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" INTEGER NOT NULL ,\"MESSAGE_ID\" INTEGER NOT NULL ,\"SENT_TIME\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"TEAM_UIMESSAGE\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public TeamUIMessageDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(TeamUIMessage teamUIMessage) {
        if (teamUIMessage != null) {
            return teamUIMessage.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(TeamUIMessage teamUIMessage) {
        return teamUIMessage.getID() != null;
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
    public final Long updateKeyAfterInsert(TeamUIMessage teamUIMessage, long j) {
        teamUIMessage.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, TeamUIMessage teamUIMessage) {
        cVar.d();
        Long id = teamUIMessage.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        cVar.a(2, teamUIMessage.getUserId());
        cVar.a(3, teamUIMessage.getMessageId());
        cVar.a(4, teamUIMessage.getSentTime());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public TeamUIMessage readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        return new TeamUIMessage(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getLong(i + 1), cursor.getInt(i + 2), cursor.getLong(i + 3));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, TeamUIMessage teamUIMessage, int i) {
        int i2 = i + 0;
        teamUIMessage.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        teamUIMessage.setUserId(cursor.getLong(i + 1));
        teamUIMessage.setMessageId(cursor.getInt(i + 2));
        teamUIMessage.setSentTime(cursor.getLong(i + 3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, TeamUIMessage teamUIMessage) {
        sQLiteStatement.clearBindings();
        Long id = teamUIMessage.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, teamUIMessage.getUserId());
        sQLiteStatement.bindLong(3, teamUIMessage.getMessageId());
        sQLiteStatement.bindLong(4, teamUIMessage.getSentTime());
    }
}
