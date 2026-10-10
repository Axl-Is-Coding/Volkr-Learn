package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.sandboxol.greendao.b.k;
import java.util.Map;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class GameDiskCacheInfoDao extends a<GameDiskCacheInfo, String> {
    public static final String TABLENAME = "GAME_DISK_CACHE_INFO";
    private final k mapPathNameConverter;

    public static class Properties {
        public static final f GameId = new f(0, String.class, "gameId", true, "GAME_ID");
        public static final f GameTitle = new f(1, String.class, "gameTitle", false, "GAME_TITLE");
        public static final f GameName = new f(2, String.class, "gameName", false, "GAME_NAME");
        public static final f GameCoverPic = new f(3, String.class, "gameCoverPic", false, "GAME_COVER_PIC");
        public static final f IsNewEngine = new f(4, Integer.TYPE, "isNewEngine", false, "IS_NEW_ENGINE");
        public static final f LastOpenedTime = new f(5, Long.TYPE, "lastOpenedTime", false, "LAST_OPENED_TIME");
        public static final f DiskSpaceSize = new f(6, Long.TYPE, "diskSpaceSize", false, "DISK_SPACE_SIZE");
        public static final f MapPathName = new f(7, String.class, "mapPathName", false, "MAP_PATH_NAME");
        public static final f IsDataChange = new f(8, Boolean.TYPE, "isDataChange", false, "IS_DATA_CHANGE");
        public static final f IsUgcGame = new f(9, Integer.TYPE, "isUgcGame", false, "IS_UGC_GAME");
    }

    public GameDiskCacheInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.mapPathNameConverter = new k();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"GAME_DISK_CACHE_INFO\" (\"GAME_ID\" TEXT PRIMARY KEY NOT NULL ,\"GAME_TITLE\" TEXT,\"GAME_NAME\" TEXT,\"GAME_COVER_PIC\" TEXT,\"IS_NEW_ENGINE\" INTEGER NOT NULL ,\"LAST_OPENED_TIME\" INTEGER NOT NULL ,\"DISK_SPACE_SIZE\" INTEGER NOT NULL ,\"MAP_PATH_NAME\" TEXT,\"IS_DATA_CHANGE\" INTEGER NOT NULL ,\"IS_UGC_GAME\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"GAME_DISK_CACHE_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public String getKey(GameDiskCacheInfo gameDiskCacheInfo) {
        if (gameDiskCacheInfo != null) {
            return gameDiskCacheInfo.getGameId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(GameDiskCacheInfo gameDiskCacheInfo) {
        return gameDiskCacheInfo.getGameId() != null;
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
    public final String updateKeyAfterInsert(GameDiskCacheInfo gameDiskCacheInfo, long j) {
        return gameDiskCacheInfo.getGameId();
    }

    public GameDiskCacheInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.mapPathNameConverter = new k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, GameDiskCacheInfo gameDiskCacheInfo) {
        cVar.d();
        String gameId = gameDiskCacheInfo.getGameId();
        if (gameId != null) {
            cVar.a(1, gameId);
        }
        String gameTitle = gameDiskCacheInfo.getGameTitle();
        if (gameTitle != null) {
            cVar.a(2, gameTitle);
        }
        String gameName = gameDiskCacheInfo.getGameName();
        if (gameName != null) {
            cVar.a(3, gameName);
        }
        String gameCoverPic = gameDiskCacheInfo.getGameCoverPic();
        if (gameCoverPic != null) {
            cVar.a(4, gameCoverPic);
        }
        cVar.a(5, gameDiskCacheInfo.getIsNewEngine());
        cVar.a(6, gameDiskCacheInfo.getLastOpenedTime());
        cVar.a(7, gameDiskCacheInfo.getDiskSpaceSize());
        Map<String, String> mapPathName = gameDiskCacheInfo.getMapPathName();
        if (mapPathName != null) {
            cVar.a(8, this.mapPathNameConverter.a(mapPathName));
        }
        cVar.a(9, gameDiskCacheInfo.getIsDataChange() ? 1L : 0L);
        cVar.a(10, gameDiskCacheInfo.getIsUgcGame());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public GameDiskCacheInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Map<String, String> mapA = null;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 4);
        long j = cursor.getLong(i + 5);
        long j2 = cursor.getLong(i + 6);
        int i7 = i + 7;
        if (!cursor.isNull(i7)) {
            mapA = this.mapPathNameConverter.a(cursor.getString(i7));
        }
        return new GameDiskCacheInfo(string, string2, string3, string4, i6, j, j2, mapA, cursor.getShort(i + 8) != 0, cursor.getInt(i + 9));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, GameDiskCacheInfo gameDiskCacheInfo, int i) {
        int i2 = i + 0;
        gameDiskCacheInfo.setGameId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        gameDiskCacheInfo.setGameTitle(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        gameDiskCacheInfo.setGameName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        gameDiskCacheInfo.setGameCoverPic(cursor.isNull(i5) ? null : cursor.getString(i5));
        gameDiskCacheInfo.setIsNewEngine(cursor.getInt(i + 4));
        gameDiskCacheInfo.setLastOpenedTime(cursor.getLong(i + 5));
        gameDiskCacheInfo.setDiskSpaceSize(cursor.getLong(i + 6));
        int i6 = i + 7;
        gameDiskCacheInfo.setMapPathName(cursor.isNull(i6) ? null : this.mapPathNameConverter.a(cursor.getString(i6)));
        gameDiskCacheInfo.setIsDataChange(cursor.getShort(i + 8) != 0);
        gameDiskCacheInfo.setIsUgcGame(cursor.getInt(i + 9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, GameDiskCacheInfo gameDiskCacheInfo) {
        sQLiteStatement.clearBindings();
        String gameId = gameDiskCacheInfo.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(1, gameId);
        }
        String gameTitle = gameDiskCacheInfo.getGameTitle();
        if (gameTitle != null) {
            sQLiteStatement.bindString(2, gameTitle);
        }
        String gameName = gameDiskCacheInfo.getGameName();
        if (gameName != null) {
            sQLiteStatement.bindString(3, gameName);
        }
        String gameCoverPic = gameDiskCacheInfo.getGameCoverPic();
        if (gameCoverPic != null) {
            sQLiteStatement.bindString(4, gameCoverPic);
        }
        sQLiteStatement.bindLong(5, gameDiskCacheInfo.getIsNewEngine());
        sQLiteStatement.bindLong(6, gameDiskCacheInfo.getLastOpenedTime());
        sQLiteStatement.bindLong(7, gameDiskCacheInfo.getDiskSpaceSize());
        Map<String, String> mapPathName = gameDiskCacheInfo.getMapPathName();
        if (mapPathName != null) {
            sQLiteStatement.bindString(8, this.mapPathNameConverter.a(mapPathName));
        }
        sQLiteStatement.bindLong(9, gameDiskCacheInfo.getIsDataChange() ? 1L : 0L);
        sQLiteStatement.bindLong(10, gameDiskCacheInfo.getIsUgcGame());
    }
}
