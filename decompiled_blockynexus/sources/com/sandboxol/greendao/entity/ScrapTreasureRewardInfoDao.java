package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.internal.AnalyticsEvents;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapTreasureRewardInfoDao extends a<ScrapTreasureRewardInfo, Void> {
    public static final String TABLENAME = "SCRAP_TREASURE_REWARD_INFO";

    public static class Properties {
        public static final f UserId = new f(0, Long.TYPE, "userId", false, "USER_ID");
        public static final f GameId = new f(1, String.class, "gameId", false, "GAME_ID");
        public static final f Status = new f(2, Integer.TYPE, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, false, "STATUS");
        public static final f Probability = new f(3, String.class, "probability", false, "PROBABILITY");
        public static final f ScrapId = new f(4, String.class, "scrapId", false, "SCRAP_ID");
        public static final f ScrapLevel = new f(5, Integer.TYPE, "scrapLevel", false, "SCRAP_LEVEL");
        public static final f ScrapName = new f(6, String.class, "scrapName", false, "SCRAP_NAME");
        public static final f ScrapPic = new f(7, String.class, "scrapPic", false, "SCRAP_PIC");
        public static final f ScrapType = new f(8, Integer.TYPE, "scrapType", false, "SCRAP_TYPE");
        public static final f ScrapDesc = new f(9, String.class, "scrapDesc", false, "SCRAP_DESC");
        public static final f ScrapValue = new f(10, Integer.TYPE, "scrapValue", false, "SCRAP_VALUE");
    }

    public ScrapTreasureRewardInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"SCRAP_TREASURE_REWARD_INFO\" (\"USER_ID\" INTEGER NOT NULL ,\"GAME_ID\" TEXT,\"STATUS\" INTEGER NOT NULL ,\"PROBABILITY\" TEXT,\"SCRAP_ID\" TEXT,\"SCRAP_LEVEL\" INTEGER NOT NULL ,\"SCRAP_NAME\" TEXT,\"SCRAP_PIC\" TEXT,\"SCRAP_TYPE\" INTEGER NOT NULL ,\"SCRAP_DESC\" TEXT,\"SCRAP_VALUE\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"SCRAP_TREASURE_REWARD_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    public Void getKey(ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
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
    public final Void updateKeyAfterInsert(ScrapTreasureRewardInfo scrapTreasureRewardInfo, long j) {
        return null;
    }

    public ScrapTreasureRewardInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        cVar.d();
        cVar.a(1, scrapTreasureRewardInfo.getUserId());
        String gameId = scrapTreasureRewardInfo.getGameId();
        if (gameId != null) {
            cVar.a(2, gameId);
        }
        cVar.a(3, scrapTreasureRewardInfo.getStatus());
        String probability = scrapTreasureRewardInfo.getProbability();
        if (probability != null) {
            cVar.a(4, probability);
        }
        String scrapId = scrapTreasureRewardInfo.getScrapId();
        if (scrapId != null) {
            cVar.a(5, scrapId);
        }
        cVar.a(6, scrapTreasureRewardInfo.getScrapLevel());
        String scrapName = scrapTreasureRewardInfo.getScrapName();
        if (scrapName != null) {
            cVar.a(7, scrapName);
        }
        String scrapPic = scrapTreasureRewardInfo.getScrapPic();
        if (scrapPic != null) {
            cVar.a(8, scrapPic);
        }
        cVar.a(9, scrapTreasureRewardInfo.getScrapType());
        String scrapDesc = scrapTreasureRewardInfo.getScrapDesc();
        if (scrapDesc != null) {
            cVar.a(10, scrapDesc);
        }
        cVar.a(11, scrapTreasureRewardInfo.getScrapValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public ScrapTreasureRewardInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 3;
        int i4 = i + 4;
        int i5 = i + 6;
        int i6 = i + 7;
        int i7 = i + 9;
        return new ScrapTreasureRewardInfo(cursor.getLong(i + 0), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 5), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 8), cursor.isNull(i7) ? null : cursor.getString(i7), cursor.getInt(i + 10));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, ScrapTreasureRewardInfo scrapTreasureRewardInfo, int i) {
        scrapTreasureRewardInfo.setUserId(cursor.getLong(i + 0));
        int i2 = i + 1;
        scrapTreasureRewardInfo.setGameId(cursor.isNull(i2) ? null : cursor.getString(i2));
        scrapTreasureRewardInfo.setStatus(cursor.getInt(i + 2));
        int i3 = i + 3;
        scrapTreasureRewardInfo.setProbability(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        scrapTreasureRewardInfo.setScrapId(cursor.isNull(i4) ? null : cursor.getString(i4));
        scrapTreasureRewardInfo.setScrapLevel(cursor.getInt(i + 5));
        int i5 = i + 6;
        scrapTreasureRewardInfo.setScrapName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 7;
        scrapTreasureRewardInfo.setScrapPic(cursor.isNull(i6) ? null : cursor.getString(i6));
        scrapTreasureRewardInfo.setScrapType(cursor.getInt(i + 8));
        int i7 = i + 9;
        scrapTreasureRewardInfo.setScrapDesc(cursor.isNull(i7) ? null : cursor.getString(i7));
        scrapTreasureRewardInfo.setScrapValue(cursor.getInt(i + 10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, scrapTreasureRewardInfo.getUserId());
        String gameId = scrapTreasureRewardInfo.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(2, gameId);
        }
        sQLiteStatement.bindLong(3, scrapTreasureRewardInfo.getStatus());
        String probability = scrapTreasureRewardInfo.getProbability();
        if (probability != null) {
            sQLiteStatement.bindString(4, probability);
        }
        String scrapId = scrapTreasureRewardInfo.getScrapId();
        if (scrapId != null) {
            sQLiteStatement.bindString(5, scrapId);
        }
        sQLiteStatement.bindLong(6, scrapTreasureRewardInfo.getScrapLevel());
        String scrapName = scrapTreasureRewardInfo.getScrapName();
        if (scrapName != null) {
            sQLiteStatement.bindString(7, scrapName);
        }
        String scrapPic = scrapTreasureRewardInfo.getScrapPic();
        if (scrapPic != null) {
            sQLiteStatement.bindString(8, scrapPic);
        }
        sQLiteStatement.bindLong(9, scrapTreasureRewardInfo.getScrapType());
        String scrapDesc = scrapTreasureRewardInfo.getScrapDesc();
        if (scrapDesc != null) {
            sQLiteStatement.bindString(10, scrapDesc);
        }
        sQLiteStatement.bindLong(11, scrapTreasureRewardInfo.getScrapValue());
    }
}
