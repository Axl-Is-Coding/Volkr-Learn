package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.greendao.b.c;
import com.sandboxol.greendao.b.e;
import com.sandboxol.greendao.b.f;
import com.sandboxol.greendao.b.i;
import com.sandboxol.greendao.b.m;
import com.sandboxol.greendao.b.n;
import java.util.List;
import org.greenrobot.greendao.a;

/* JADX INFO: loaded from: classes3.dex */
public class GameDao extends a<Game, String> {
    public static final String TABLENAME = "GAME";
    private final com.sandboxol.greendao.b.a authorInfoConverter;
    private final i bannerPicConverter;
    private final c gameBannerVideoInfosConverter;
    private final e gamePayInfoConverter;
    private final i gameTypesConverter;
    private final n latestResVersionsConverter;
    private final m realPlayGameListConverter;
    private final f warmUpResponseConverter;

    public static class Properties {
        public static final org.greenrobot.greendao.f GameId = new org.greenrobot.greendao.f(0, String.class, "gameId", true, "GAME_ID");
        public static final org.greenrobot.greendao.f GameTitle = new org.greenrobot.greendao.f(1, String.class, "gameTitle", false, "GAME_TITLE");
        public static final org.greenrobot.greendao.f GameName = new org.greenrobot.greendao.f(2, String.class, "gameName", false, "GAME_NAME");
        public static final org.greenrobot.greendao.f GameCoverPic = new org.greenrobot.greendao.f(3, String.class, "gameCoverPic", false, "GAME_COVER_PIC");
        public static final org.greenrobot.greendao.f BannerPic = new org.greenrobot.greendao.f(4, String.class, "bannerPic", false, "BANNER_PIC");
        public static final org.greenrobot.greendao.f GameBannerVideoInfos = new org.greenrobot.greendao.f(5, String.class, "gameBannerVideoInfos", false, "GAME_BANNER_VIDEO_INFOS");
        public static final org.greenrobot.greendao.f GameDetail = new org.greenrobot.greendao.f(6, String.class, "gameDetail", false, "GAME_DETAIL");
        public static final org.greenrobot.greendao.f GameTypes = new org.greenrobot.greendao.f(7, String.class, "gameTypes", false, "GAME_TYPES");
        public static final org.greenrobot.greendao.f Appreciate = new org.greenrobot.greendao.f(8, Boolean.TYPE, StringConstant.GAME_ORDER_TYPE_APPRECIATE, false, "APPRECIATE");
        public static final org.greenrobot.greendao.f GameMode = new org.greenrobot.greendao.f(9, Integer.TYPE, "gameMode", false, "GAME_MODE");
        public static final org.greenrobot.greendao.f VisitorEnter = new org.greenrobot.greendao.f(10, Integer.TYPE, "visitorEnter", false, "VISITOR_ENTER");
        public static final org.greenrobot.greendao.f Version = new org.greenrobot.greendao.f(11, Integer.TYPE, "version", false, "VERSION");
        public static final org.greenrobot.greendao.f IsRankOnline = new org.greenrobot.greendao.f(12, Integer.TYPE, "isRankOnline", false, "IS_RANK_ONLINE");
        public static final org.greenrobot.greendao.f IsShopOnline = new org.greenrobot.greendao.f(13, Integer.TYPE, "isShopOnline", false, "IS_SHOP_ONLINE");
        public static final org.greenrobot.greendao.f IsOpenParty = new org.greenrobot.greendao.f(14, Integer.TYPE, "isOpenParty", false, "IS_OPEN_PARTY");
        public static final org.greenrobot.greendao.f IsPay = new org.greenrobot.greendao.f(15, Integer.TYPE, "isPay", false, "IS_PAY");
        public static final org.greenrobot.greendao.f TurntableStatus = new org.greenrobot.greendao.f(16, Integer.TYPE, "turntableStatus", false, "TURNTABLE_STATUS");
        public static final org.greenrobot.greendao.f TurntableRemainCount = new org.greenrobot.greendao.f(17, Integer.TYPE, "turntableRemainCount", false, "TURNTABLE_REMAIN_COUNT");
        public static final org.greenrobot.greendao.f IsNewEngine = new org.greenrobot.greendao.f(18, Integer.TYPE, "isNewEngine", false, "IS_NEW_ENGINE");
        public static final org.greenrobot.greendao.f IsUgcGame = new org.greenrobot.greendao.f(19, Integer.TYPE, "isUgcGame", false, "IS_UGC_GAME");
        public static final org.greenrobot.greendao.f CurrentPage = new org.greenrobot.greendao.f(20, Integer.TYPE, "currentPage", false, "CURRENT_PAGE");
        public static final org.greenrobot.greendao.f CurrentSize = new org.greenrobot.greendao.f(21, Integer.TYPE, "currentSize", false, "CURRENT_SIZE");
        public static final org.greenrobot.greendao.f ResVersion = new org.greenrobot.greendao.f(22, Long.TYPE, "resVersion", false, "RES_VERSION");
        public static final org.greenrobot.greendao.f PageType = new org.greenrobot.greendao.f(23, Integer.TYPE, "pageType", false, "PAGE_TYPE");
        public static final org.greenrobot.greendao.f TypeId = new org.greenrobot.greendao.f(24, Long.TYPE, "typeId", false, "TYPE_ID");
        public static final org.greenrobot.greendao.f CreateTime = new org.greenrobot.greendao.f(25, Long.TYPE, "createTime", false, "CREATE_TIME");
        public static final org.greenrobot.greendao.f ComplexNum = new org.greenrobot.greendao.f(26, Integer.TYPE, "complexNum", false, "COMPLEX_NUM");
        public static final org.greenrobot.greendao.f PraiseNumber = new org.greenrobot.greendao.f(27, Integer.TYPE, "praiseNumber", false, "PRAISE_NUMBER");
        public static final org.greenrobot.greendao.f OnlineNumber = new org.greenrobot.greendao.f(28, Integer.TYPE, "onlineNumber", false, "ONLINE_NUMBER");
        public static final org.greenrobot.greendao.f Index = new org.greenrobot.greendao.f(29, Integer.TYPE, FirebaseAnalytics.Param.INDEX, false, "INDEX");
        public static final org.greenrobot.greendao.f GameUgcType = new org.greenrobot.greendao.f(30, String.class, "gameUgcType", false, "GAME_UGC_TYPE");
        public static final org.greenrobot.greendao.f GamePayInfo = new org.greenrobot.greendao.f(31, String.class, "gamePayInfo", false, "GAME_PAY_INFO");
        public static final org.greenrobot.greendao.f WarmUpResponse = new org.greenrobot.greendao.f(32, String.class, "warmUpResponse", false, "WARM_UP_RESPONSE");
        public static final org.greenrobot.greendao.f AuthorInfo = new org.greenrobot.greendao.f(33, String.class, "authorInfo", false, "AUTHOR_INFO");
        public static final org.greenrobot.greendao.f RealPlayGameList = new org.greenrobot.greendao.f(34, String.class, "realPlayGameList", false, "REAL_PLAY_GAME_LIST");
        public static final org.greenrobot.greendao.f LatestResVersions = new org.greenrobot.greendao.f(35, String.class, "latestResVersions", false, "LATEST_RES_VERSIONS");
    }

    public GameDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.bannerPicConverter = new i();
        this.gameBannerVideoInfosConverter = new c();
        this.gameTypesConverter = new i();
        this.gamePayInfoConverter = new e();
        this.warmUpResponseConverter = new f();
        this.authorInfoConverter = new com.sandboxol.greendao.b.a();
        this.realPlayGameListConverter = new m();
        this.latestResVersionsConverter = new n();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"GAME\" (\"GAME_ID\" TEXT PRIMARY KEY NOT NULL ,\"GAME_TITLE\" TEXT,\"GAME_NAME\" TEXT,\"GAME_COVER_PIC\" TEXT,\"BANNER_PIC\" TEXT,\"GAME_BANNER_VIDEO_INFOS\" TEXT,\"GAME_DETAIL\" TEXT,\"GAME_TYPES\" TEXT,\"APPRECIATE\" INTEGER NOT NULL ,\"GAME_MODE\" INTEGER NOT NULL ,\"VISITOR_ENTER\" INTEGER NOT NULL ,\"VERSION\" INTEGER NOT NULL ,\"IS_RANK_ONLINE\" INTEGER NOT NULL ,\"IS_SHOP_ONLINE\" INTEGER NOT NULL ,\"IS_OPEN_PARTY\" INTEGER NOT NULL ,\"IS_PAY\" INTEGER NOT NULL ,\"TURNTABLE_STATUS\" INTEGER NOT NULL ,\"TURNTABLE_REMAIN_COUNT\" INTEGER NOT NULL ,\"IS_NEW_ENGINE\" INTEGER NOT NULL ,\"IS_UGC_GAME\" INTEGER NOT NULL ,\"CURRENT_PAGE\" INTEGER NOT NULL ,\"CURRENT_SIZE\" INTEGER NOT NULL ,\"RES_VERSION\" INTEGER NOT NULL ,\"PAGE_TYPE\" INTEGER NOT NULL ,\"TYPE_ID\" INTEGER NOT NULL ,\"CREATE_TIME\" INTEGER NOT NULL ,\"COMPLEX_NUM\" INTEGER NOT NULL ,\"PRAISE_NUMBER\" INTEGER NOT NULL ,\"ONLINE_NUMBER\" INTEGER NOT NULL ,\"INDEX\" INTEGER NOT NULL ,\"GAME_UGC_TYPE\" TEXT,\"GAME_PAY_INFO\" TEXT,\"WARM_UP_RESPONSE\" TEXT,\"AUTHOR_INFO\" TEXT,\"REAL_PLAY_GAME_LIST\" TEXT,\"LATEST_RES_VERSIONS\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"GAME\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public String getKey(Game game) {
        if (game != null) {
            return game.getGameId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(Game game) {
        return game.getGameId() != null;
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
    public final String updateKeyAfterInsert(Game game, long j) {
        return game.getGameId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(org.greenrobot.greendao.b.c cVar, Game game) {
        cVar.d();
        String gameId = game.getGameId();
        if (gameId != null) {
            cVar.a(1, gameId);
        }
        String gameTitle = game.getGameTitle();
        if (gameTitle != null) {
            cVar.a(2, gameTitle);
        }
        String gameName = game.getGameName();
        if (gameName != null) {
            cVar.a(3, gameName);
        }
        String gameCoverPic = game.getGameCoverPic();
        if (gameCoverPic != null) {
            cVar.a(4, gameCoverPic);
        }
        List<String> bannerPic = game.getBannerPic();
        if (bannerPic != null) {
            cVar.a(5, this.bannerPicConverter.a(bannerPic));
        }
        List<BannerEntity> gameBannerVideoInfos = game.getGameBannerVideoInfos();
        if (gameBannerVideoInfos != null) {
            cVar.a(6, this.gameBannerVideoInfosConverter.a(gameBannerVideoInfos));
        }
        String gameDetail = game.getGameDetail();
        if (gameDetail != null) {
            cVar.a(7, gameDetail);
        }
        List<String> gameTypes = game.getGameTypes();
        if (gameTypes != null) {
            cVar.a(8, this.gameTypesConverter.a(gameTypes));
        }
        cVar.a(9, game.getAppreciate() ? 1L : 0L);
        cVar.a(10, game.getGameMode());
        cVar.a(11, game.getVisitorEnter());
        cVar.a(12, game.getVersion());
        cVar.a(13, game.getIsRankOnline());
        cVar.a(14, game.getIsShopOnline());
        cVar.a(15, game.getIsOpenParty());
        cVar.a(16, game.getIsPay());
        cVar.a(17, game.getTurntableStatus());
        cVar.a(18, game.getTurntableRemainCount());
        cVar.a(19, game.getIsNewEngine());
        cVar.a(20, game.getIsUgcGame());
        cVar.a(21, game.getCurrentPage());
        cVar.a(22, game.getCurrentSize());
        cVar.a(23, game.getResVersion());
        cVar.a(24, game.getPageType());
        cVar.a(25, game.getTypeId());
        cVar.a(26, game.getCreateTime());
        cVar.a(27, game.getComplexNum());
        cVar.a(28, game.getPraiseNumber());
        cVar.a(29, game.getOnlineNumber());
        cVar.a(30, game.getIndex());
        String gameUgcType = game.getGameUgcType();
        if (gameUgcType != null) {
            cVar.a(31, gameUgcType);
        }
        GamePayInfo gamePayInfo = game.getGamePayInfo();
        if (gamePayInfo != null) {
            cVar.a(32, this.gamePayInfoConverter.a(gamePayInfo));
        }
        GameWarmUpResponse warmUpResponse = game.getWarmUpResponse();
        if (warmUpResponse != null) {
            cVar.a(33, this.warmUpResponseConverter.a(warmUpResponse));
        }
        AuthorInfo authorInfo = game.getAuthorInfo();
        if (authorInfo != null) {
            cVar.a(34, this.authorInfoConverter.a(authorInfo));
        }
        List<RealPlayGame> realPlayGameList = game.getRealPlayGameList();
        if (realPlayGameList != null) {
            cVar.a(35, this.realPlayGameListConverter.a(realPlayGameList));
        }
        ResourceLatestVersionData latestResVersions = game.getLatestResVersions();
        if (latestResVersions != null) {
            cVar.a(36, this.latestResVersionsConverter.a(latestResVersions));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Game readEntity(Cursor cursor, int i) {
        int i2;
        GamePayInfo gamePayInfoA;
        int i3 = i + 0;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 1;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 2;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 3;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 4;
        List<String> listA = cursor.isNull(i7) ? null : this.bannerPicConverter.a(cursor.getString(i7));
        int i8 = i + 5;
        List<BannerEntity> listA2 = cursor.isNull(i8) ? null : this.gameBannerVideoInfosConverter.a(cursor.getString(i8));
        int i9 = i + 6;
        String string5 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 7;
        List<String> listA3 = cursor.isNull(i10) ? null : this.gameTypesConverter.a(cursor.getString(i10));
        boolean z = cursor.getShort(i + 8) != 0;
        int i11 = cursor.getInt(i + 9);
        int i12 = cursor.getInt(i + 10);
        int i13 = cursor.getInt(i + 11);
        int i14 = cursor.getInt(i + 12);
        int i15 = cursor.getInt(i + 13);
        int i16 = cursor.getInt(i + 14);
        int i17 = cursor.getInt(i + 15);
        int i18 = cursor.getInt(i + 16);
        int i19 = cursor.getInt(i + 17);
        int i20 = cursor.getInt(i + 18);
        int i21 = cursor.getInt(i + 19);
        int i22 = cursor.getInt(i + 20);
        int i23 = cursor.getInt(i + 21);
        long j = cursor.getLong(i + 22);
        int i24 = cursor.getInt(i + 23);
        long j2 = cursor.getLong(i + 24);
        long j3 = cursor.getLong(i + 25);
        int i25 = cursor.getInt(i + 26);
        int i26 = cursor.getInt(i + 27);
        int i27 = cursor.getInt(i + 28);
        int i28 = cursor.getInt(i + 29);
        int i29 = i + 30;
        String string6 = cursor.isNull(i29) ? null : cursor.getString(i29);
        int i30 = i + 31;
        if (cursor.isNull(i30)) {
            i2 = i14;
            gamePayInfoA = null;
        } else {
            i2 = i14;
            gamePayInfoA = this.gamePayInfoConverter.a(cursor.getString(i30));
        }
        int i31 = i + 32;
        GameWarmUpResponse gameWarmUpResponseA = cursor.isNull(i31) ? null : this.warmUpResponseConverter.a(cursor.getString(i31));
        int i32 = i + 33;
        AuthorInfo authorInfoA = cursor.isNull(i32) ? null : this.authorInfoConverter.a(cursor.getString(i32));
        int i33 = i + 34;
        List<RealPlayGame> listA4 = cursor.isNull(i33) ? null : this.realPlayGameListConverter.a(cursor.getString(i33));
        int i34 = i + 35;
        return new Game(string, string2, string3, string4, listA, listA2, string5, listA3, z, i11, i12, i13, i2, i15, i16, i17, i18, i19, i20, i21, i22, i23, j, i24, j2, j3, i25, i26, i27, i28, string6, gamePayInfoA, gameWarmUpResponseA, authorInfoA, listA4, cursor.isNull(i34) ? null : this.latestResVersionsConverter.a(cursor.getString(i34)));
    }

    public GameDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.bannerPicConverter = new i();
        this.gameBannerVideoInfosConverter = new c();
        this.gameTypesConverter = new i();
        this.gamePayInfoConverter = new e();
        this.warmUpResponseConverter = new f();
        this.authorInfoConverter = new com.sandboxol.greendao.b.a();
        this.realPlayGameListConverter = new m();
        this.latestResVersionsConverter = new n();
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, Game game, int i) {
        int i2 = i + 0;
        game.setGameId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        game.setGameTitle(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        game.setGameName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        game.setGameCoverPic(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        game.setBannerPic(cursor.isNull(i6) ? null : this.bannerPicConverter.a(cursor.getString(i6)));
        int i7 = i + 5;
        game.setGameBannerVideoInfos(cursor.isNull(i7) ? null : this.gameBannerVideoInfosConverter.a(cursor.getString(i7)));
        int i8 = i + 6;
        game.setGameDetail(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        game.setGameTypes(cursor.isNull(i9) ? null : this.gameTypesConverter.a(cursor.getString(i9)));
        game.setAppreciate(cursor.getShort(i + 8) != 0);
        game.setGameMode(cursor.getInt(i + 9));
        game.setVisitorEnter(cursor.getInt(i + 10));
        game.setVersion(cursor.getInt(i + 11));
        game.setIsRankOnline(cursor.getInt(i + 12));
        game.setIsShopOnline(cursor.getInt(i + 13));
        game.setIsOpenParty(cursor.getInt(i + 14));
        game.setIsPay(cursor.getInt(i + 15));
        game.setTurntableStatus(cursor.getInt(i + 16));
        game.setTurntableRemainCount(cursor.getInt(i + 17));
        game.setIsNewEngine(cursor.getInt(i + 18));
        game.setIsUgcGame(cursor.getInt(i + 19));
        game.setCurrentPage(cursor.getInt(i + 20));
        game.setCurrentSize(cursor.getInt(i + 21));
        game.setResVersion(cursor.getLong(i + 22));
        game.setPageType(cursor.getInt(i + 23));
        game.setTypeId(cursor.getLong(i + 24));
        game.setCreateTime(cursor.getLong(i + 25));
        game.setComplexNum(cursor.getInt(i + 26));
        game.setPraiseNumber(cursor.getInt(i + 27));
        game.setOnlineNumber(cursor.getInt(i + 28));
        game.setIndex(cursor.getInt(i + 29));
        int i10 = i + 30;
        game.setGameUgcType(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 31;
        game.setGamePayInfo(cursor.isNull(i11) ? null : this.gamePayInfoConverter.a(cursor.getString(i11)));
        int i12 = i + 32;
        game.setWarmUpResponse(cursor.isNull(i12) ? null : this.warmUpResponseConverter.a(cursor.getString(i12)));
        int i13 = i + 33;
        game.setAuthorInfo(cursor.isNull(i13) ? null : this.authorInfoConverter.a(cursor.getString(i13)));
        int i14 = i + 34;
        game.setRealPlayGameList(cursor.isNull(i14) ? null : this.realPlayGameListConverter.a(cursor.getString(i14)));
        int i15 = i + 35;
        game.setLatestResVersions(cursor.isNull(i15) ? null : this.latestResVersionsConverter.a(cursor.getString(i15)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, Game game) {
        sQLiteStatement.clearBindings();
        String gameId = game.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(1, gameId);
        }
        String gameTitle = game.getGameTitle();
        if (gameTitle != null) {
            sQLiteStatement.bindString(2, gameTitle);
        }
        String gameName = game.getGameName();
        if (gameName != null) {
            sQLiteStatement.bindString(3, gameName);
        }
        String gameCoverPic = game.getGameCoverPic();
        if (gameCoverPic != null) {
            sQLiteStatement.bindString(4, gameCoverPic);
        }
        List<String> bannerPic = game.getBannerPic();
        if (bannerPic != null) {
            sQLiteStatement.bindString(5, this.bannerPicConverter.a(bannerPic));
        }
        List<BannerEntity> gameBannerVideoInfos = game.getGameBannerVideoInfos();
        if (gameBannerVideoInfos != null) {
            sQLiteStatement.bindString(6, this.gameBannerVideoInfosConverter.a(gameBannerVideoInfos));
        }
        String gameDetail = game.getGameDetail();
        if (gameDetail != null) {
            sQLiteStatement.bindString(7, gameDetail);
        }
        List<String> gameTypes = game.getGameTypes();
        if (gameTypes != null) {
            sQLiteStatement.bindString(8, this.gameTypesConverter.a(gameTypes));
        }
        sQLiteStatement.bindLong(9, game.getAppreciate() ? 1L : 0L);
        sQLiteStatement.bindLong(10, game.getGameMode());
        sQLiteStatement.bindLong(11, game.getVisitorEnter());
        sQLiteStatement.bindLong(12, game.getVersion());
        sQLiteStatement.bindLong(13, game.getIsRankOnline());
        sQLiteStatement.bindLong(14, game.getIsShopOnline());
        sQLiteStatement.bindLong(15, game.getIsOpenParty());
        sQLiteStatement.bindLong(16, game.getIsPay());
        sQLiteStatement.bindLong(17, game.getTurntableStatus());
        sQLiteStatement.bindLong(18, game.getTurntableRemainCount());
        sQLiteStatement.bindLong(19, game.getIsNewEngine());
        sQLiteStatement.bindLong(20, game.getIsUgcGame());
        sQLiteStatement.bindLong(21, game.getCurrentPage());
        sQLiteStatement.bindLong(22, game.getCurrentSize());
        sQLiteStatement.bindLong(23, game.getResVersion());
        sQLiteStatement.bindLong(24, game.getPageType());
        sQLiteStatement.bindLong(25, game.getTypeId());
        sQLiteStatement.bindLong(26, game.getCreateTime());
        sQLiteStatement.bindLong(27, game.getComplexNum());
        sQLiteStatement.bindLong(28, game.getPraiseNumber());
        sQLiteStatement.bindLong(29, game.getOnlineNumber());
        sQLiteStatement.bindLong(30, game.getIndex());
        String gameUgcType = game.getGameUgcType();
        if (gameUgcType != null) {
            sQLiteStatement.bindString(31, gameUgcType);
        }
        GamePayInfo gamePayInfo = game.getGamePayInfo();
        if (gamePayInfo != null) {
            sQLiteStatement.bindString(32, this.gamePayInfoConverter.a(gamePayInfo));
        }
        GameWarmUpResponse warmUpResponse = game.getWarmUpResponse();
        if (warmUpResponse != null) {
            sQLiteStatement.bindString(33, this.warmUpResponseConverter.a(warmUpResponse));
        }
        AuthorInfo authorInfo = game.getAuthorInfo();
        if (authorInfo != null) {
            sQLiteStatement.bindString(34, this.authorInfoConverter.a(authorInfo));
        }
        List<RealPlayGame> realPlayGameList = game.getRealPlayGameList();
        if (realPlayGameList != null) {
            sQLiteStatement.bindString(35, this.realPlayGameListConverter.a(realPlayGameList));
        }
        ResourceLatestVersionData latestResVersions = game.getLatestResVersions();
        if (latestResVersions != null) {
            sQLiteStatement.bindString(36, this.latestResVersionsConverter.a(latestResVersions));
        }
    }
}
