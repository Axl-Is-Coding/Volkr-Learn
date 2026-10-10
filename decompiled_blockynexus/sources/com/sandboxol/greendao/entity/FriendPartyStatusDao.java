package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class FriendPartyStatusDao extends a<FriendPartyStatus, Void> {
    public static final String TABLENAME = "FRIEND_PARTY_STATUS";

    public static class Properties {
        public static final f CaptainId = new f(0, Long.TYPE, "captainId", false, "CAPTAIN_ID");
        public static final f ChatGroupId = new f(1, String.class, "chatGroupId", false, "CHAT_GROUP_ID");
        public static final f Cur = new f(2, Integer.TYPE, "cur", false, "CUR");
        public static final f Max = new f(3, Integer.TYPE, "max", false, "MAX");
        public static final f EngineVersion = new f(4, Integer.TYPE, "engineVersion", false, "ENGINE_VERSION");
        public static final f GameId = new f(5, String.class, "gameId", false, "GAME_ID");
        public static final f Psid = new f(6, String.class, "psid", false, "PSID");
        public static final f TeamCount = new f(7, Integer.TYPE, "teamCount", false, "TEAM_COUNT");
        public static final f TeamId = new f(8, String.class, "teamId", false, "TEAM_ID");
        public static final f TeamMemberCount = new f(9, Integer.TYPE, "teamMemberCount", false, "TEAM_MEMBER_COUNT");
        public static final f Title = new f(10, String.class, "title", false, ShareConstants.TITLE);
        public static final f TeamType = new f(11, Integer.TYPE, "teamType", false, "TEAM_TYPE");
        public static final f GameName = new f(12, String.class, "gameName", false, "GAME_NAME");
    }

    public FriendPartyStatusDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"FRIEND_PARTY_STATUS\" (\"CAPTAIN_ID\" INTEGER NOT NULL ,\"CHAT_GROUP_ID\" TEXT,\"CUR\" INTEGER NOT NULL ,\"MAX\" INTEGER NOT NULL ,\"ENGINE_VERSION\" INTEGER NOT NULL ,\"GAME_ID\" TEXT,\"PSID\" TEXT,\"TEAM_COUNT\" INTEGER NOT NULL ,\"TEAM_ID\" TEXT,\"TEAM_MEMBER_COUNT\" INTEGER NOT NULL ,\"TITLE\" TEXT,\"TEAM_TYPE\" INTEGER NOT NULL ,\"GAME_NAME\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FRIEND_PARTY_STATUS\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    public Void getKey(FriendPartyStatus friendPartyStatus) {
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(FriendPartyStatus friendPartyStatus) {
        return false;
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Void readKey(Cursor cursor, int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Void updateKeyAfterInsert(FriendPartyStatus friendPartyStatus, long j) {
        return null;
    }

    public FriendPartyStatusDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, FriendPartyStatus friendPartyStatus) {
        cVar.d();
        cVar.a(1, friendPartyStatus.getCaptainId());
        String chatGroupId = friendPartyStatus.getChatGroupId();
        if (chatGroupId != null) {
            cVar.a(2, chatGroupId);
        }
        cVar.a(3, friendPartyStatus.getCur());
        cVar.a(4, friendPartyStatus.getMax());
        cVar.a(5, friendPartyStatus.getEngineVersion());
        String gameId = friendPartyStatus.getGameId();
        if (gameId != null) {
            cVar.a(6, gameId);
        }
        String psid = friendPartyStatus.getPsid();
        if (psid != null) {
            cVar.a(7, psid);
        }
        cVar.a(8, friendPartyStatus.getTeamCount());
        String teamId = friendPartyStatus.getTeamId();
        if (teamId != null) {
            cVar.a(9, teamId);
        }
        cVar.a(10, friendPartyStatus.getTeamMemberCount());
        String title = friendPartyStatus.getTitle();
        if (title != null) {
            cVar.a(11, title);
        }
        cVar.a(12, friendPartyStatus.getTeamType());
        String gameName = friendPartyStatus.getGameName();
        if (gameName != null) {
            cVar.a(13, gameName);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public FriendPartyStatus readEntity(Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 5;
        int i4 = i + 6;
        int i5 = i + 8;
        int i6 = i + 10;
        int i7 = i + 12;
        return new FriendPartyStatus(cursor.getLong(i + 0), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.getInt(i + 3), cursor.getInt(i + 4), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 7), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.getInt(i + 9), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 11), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, FriendPartyStatus friendPartyStatus, int i) {
        friendPartyStatus.setCaptainId(cursor.getLong(i + 0));
        int i2 = i + 1;
        friendPartyStatus.setChatGroupId(cursor.isNull(i2) ? null : cursor.getString(i2));
        friendPartyStatus.setCur(cursor.getInt(i + 2));
        friendPartyStatus.setMax(cursor.getInt(i + 3));
        friendPartyStatus.setEngineVersion(cursor.getInt(i + 4));
        int i3 = i + 5;
        friendPartyStatus.setGameId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 6;
        friendPartyStatus.setPsid(cursor.isNull(i4) ? null : cursor.getString(i4));
        friendPartyStatus.setTeamCount(cursor.getInt(i + 7));
        int i5 = i + 8;
        friendPartyStatus.setTeamId(cursor.isNull(i5) ? null : cursor.getString(i5));
        friendPartyStatus.setTeamMemberCount(cursor.getInt(i + 9));
        int i6 = i + 10;
        friendPartyStatus.setTitle(cursor.isNull(i6) ? null : cursor.getString(i6));
        friendPartyStatus.setTeamType(cursor.getInt(i + 11));
        int i7 = i + 12;
        friendPartyStatus.setGameName(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, FriendPartyStatus friendPartyStatus) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, friendPartyStatus.getCaptainId());
        String chatGroupId = friendPartyStatus.getChatGroupId();
        if (chatGroupId != null) {
            sQLiteStatement.bindString(2, chatGroupId);
        }
        sQLiteStatement.bindLong(3, friendPartyStatus.getCur());
        sQLiteStatement.bindLong(4, friendPartyStatus.getMax());
        sQLiteStatement.bindLong(5, friendPartyStatus.getEngineVersion());
        String gameId = friendPartyStatus.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(6, gameId);
        }
        String psid = friendPartyStatus.getPsid();
        if (psid != null) {
            sQLiteStatement.bindString(7, psid);
        }
        sQLiteStatement.bindLong(8, friendPartyStatus.getTeamCount());
        String teamId = friendPartyStatus.getTeamId();
        if (teamId != null) {
            sQLiteStatement.bindString(9, teamId);
        }
        sQLiteStatement.bindLong(10, friendPartyStatus.getTeamMemberCount());
        String title = friendPartyStatus.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(11, title);
        }
        sQLiteStatement.bindLong(12, friendPartyStatus.getTeamType());
        String gameName = friendPartyStatus.getGameName();
        if (gameName != null) {
            sQLiteStatement.bindString(13, gameName);
        }
    }
}
