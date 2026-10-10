package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.internal.AnalyticsEvents;
import com.sandboxol.greendao.b.d;
import com.sandboxol.greendao.b.g;
import com.sandboxol.greendao.b.o;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class FriendDao extends a<Friend, Long> {
    public static final String TABLENAME = "FRIEND";
    private final d friendPartyStatusConverter;
    private final g gamingInfoConverter;
    private final o userGameDataResponseConverter;

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f UserId = new f(1, Long.TYPE, "userId", false, "USER_ID");
        public static final f LocalUserId = new f(2, Long.TYPE, "localUserId", false, "LOCAL_USER_ID");
        public static final f Alias = new f(3, String.class, "alias", false, "ALIAS");
        public static final f Details = new f(4, String.class, "details", false, "DETAILS");
        public static final f GameId = new f(5, String.class, "gameId", false, "GAME_ID");
        public static final f NickName = new f(6, String.class, "nickName", false, "NICK_NAME");
        public static final f PicUrl = new f(7, String.class, "picUrl", false, "PIC_URL");
        public static final f Status = new f(8, Integer.TYPE, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, false, "STATUS");
        public static final f ExpireDate = new f(9, String.class, "expireDate", false, "EXPIRE_DATE");
        public static final f Vip = new f(10, Integer.TYPE, "vip", false, "VIP");
        public static final f Sex = new f(11, Integer.TYPE, "sex", false, "SEX");
        public static final f Friend = new f(12, Boolean.TYPE, "friend", false, FriendDao.TABLENAME);
        public static final f ClanId = new f(13, Long.TYPE, "clanId", false, "CLAN_ID");
        public static final f ClanName = new f(14, String.class, "clanName", false, "CLAN_NAME");
        public static final f Role = new f(15, Integer.TYPE, "role", false, "ROLE");
        public static final f IsSearchById = new f(16, Boolean.TYPE, "isSearchById", false, "IS_SEARCH_BY_ID");
        public static final f GameName = new f(17, String.class, "gameName", false, "GAME_NAME");
        public static final f Age = new f(18, Integer.TYPE, "age", false, "AGE");
        public static final f Language = new f(19, String.class, au.M, false, "LANGUAGE");
        public static final f Country = new f(20, String.class, "country", false, "COUNTRY");
        public static final f FriendPartyStatus = new f(21, String.class, "friendPartyStatus", false, FriendPartyStatusDao.TABLENAME);
        public static final f GamingInfo = new f(22, String.class, "gamingInfo", false, "GAMING_INFO");
        public static final f UserGameDataResponse = new f(23, String.class, "userGameDataResponse", false, "USER_GAME_DATA_RESPONSE");
        public static final f StarCode = new f(24, String.class, "starCode", false, "STAR_CODE");
        public static final f LogoutTime = new f(25, Long.TYPE, "logoutTime", false, "LOGOUT_TIME");
    }

    public FriendDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.friendPartyStatusConverter = new d();
        this.gamingInfoConverter = new g();
        this.userGameDataResponseConverter = new o();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"FRIEND\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"USER_ID\" INTEGER NOT NULL ,\"LOCAL_USER_ID\" INTEGER NOT NULL ,\"ALIAS\" TEXT,\"DETAILS\" TEXT,\"GAME_ID\" TEXT,\"NICK_NAME\" TEXT,\"PIC_URL\" TEXT,\"STATUS\" INTEGER NOT NULL ,\"EXPIRE_DATE\" TEXT,\"VIP\" INTEGER NOT NULL ,\"SEX\" INTEGER NOT NULL ,\"FRIEND\" INTEGER NOT NULL ,\"CLAN_ID\" INTEGER NOT NULL ,\"CLAN_NAME\" TEXT,\"ROLE\" INTEGER NOT NULL ,\"IS_SEARCH_BY_ID\" INTEGER NOT NULL ,\"GAME_NAME\" TEXT,\"AGE\" INTEGER NOT NULL ,\"LANGUAGE\" TEXT,\"COUNTRY\" TEXT,\"FRIEND_PARTY_STATUS\" TEXT,\"GAMING_INFO\" TEXT,\"USER_GAME_DATA_RESPONSE\" TEXT,\"STAR_CODE\" TEXT,\"LOGOUT_TIME\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FRIEND\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(Friend friend) {
        if (friend != null) {
            return friend.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(Friend friend) {
        return friend.getID() != null;
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
    public final Long updateKeyAfterInsert(Friend friend, long j) {
        friend.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, Friend friend) {
        cVar.d();
        Long id = friend.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        cVar.a(2, friend.getUserId());
        cVar.a(3, friend.getLocalUserId());
        String alias = friend.getAlias();
        if (alias != null) {
            cVar.a(4, alias);
        }
        String details = friend.getDetails();
        if (details != null) {
            cVar.a(5, details);
        }
        String gameId = friend.getGameId();
        if (gameId != null) {
            cVar.a(6, gameId);
        }
        String nickName = friend.getNickName();
        if (nickName != null) {
            cVar.a(7, nickName);
        }
        String picUrl = friend.getPicUrl();
        if (picUrl != null) {
            cVar.a(8, picUrl);
        }
        cVar.a(9, friend.getStatus());
        String expireDate = friend.getExpireDate();
        if (expireDate != null) {
            cVar.a(10, expireDate);
        }
        cVar.a(11, friend.getVip());
        cVar.a(12, friend.getSex());
        cVar.a(13, friend.getFriend() ? 1L : 0L);
        cVar.a(14, friend.getClanId());
        String clanName = friend.getClanName();
        if (clanName != null) {
            cVar.a(15, clanName);
        }
        cVar.a(16, friend.getRole());
        cVar.a(17, friend.getIsSearchById() ? 1L : 0L);
        String gameName = friend.getGameName();
        if (gameName != null) {
            cVar.a(18, gameName);
        }
        cVar.a(19, friend.getAge());
        String language = friend.getLanguage();
        if (language != null) {
            cVar.a(20, language);
        }
        String country = friend.getCountry();
        if (country != null) {
            cVar.a(21, country);
        }
        FriendPartyStatus friendPartyStatus = friend.getFriendPartyStatus();
        if (friendPartyStatus != null) {
            cVar.a(22, this.friendPartyStatusConverter.a(friendPartyStatus));
        }
        GamingInfo gamingInfo = friend.getGamingInfo();
        if (gamingInfo != null) {
            cVar.a(23, this.gamingInfoConverter.a(gamingInfo));
        }
        UserGameCareerTotalData userGameDataResponse = friend.getUserGameDataResponse();
        if (userGameDataResponse != null) {
            cVar.a(24, this.userGameDataResponseConverter.a(userGameDataResponse));
        }
        String starCode = friend.getStarCode();
        if (starCode != null) {
            cVar.a(25, starCode);
        }
        cVar.a(26, friend.getLogoutTime());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Friend readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        long j = cursor.getLong(i + 1);
        long j2 = cursor.getLong(i + 2);
        int i3 = i + 3;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 4;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 5;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 6;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 7;
        String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = cursor.getInt(i + 8);
        int i9 = i + 9;
        String string6 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = cursor.getInt(i + 10);
        int i11 = cursor.getInt(i + 11);
        boolean z = cursor.getShort(i + 12) != 0;
        long j3 = cursor.getLong(i + 13);
        int i12 = i + 14;
        String string7 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = cursor.getInt(i + 15);
        boolean z2 = cursor.getShort(i + 16) != 0;
        int i14 = i + 17;
        String string8 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = cursor.getInt(i + 18);
        int i16 = i + 19;
        String string9 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 20;
        String string10 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 21;
        FriendPartyStatus friendPartyStatusA = cursor.isNull(i18) ? null : this.friendPartyStatusConverter.a(cursor.getString(i18));
        int i19 = i + 22;
        GamingInfo gamingInfoA = cursor.isNull(i19) ? null : this.gamingInfoConverter.a(cursor.getString(i19));
        int i20 = i + 23;
        UserGameCareerTotalData userGameCareerTotalDataA = cursor.isNull(i20) ? null : this.userGameDataResponseConverter.a(cursor.getString(i20));
        int i21 = i + 24;
        return new Friend(lValueOf, j, j2, string, string2, string3, string4, string5, i8, string6, i10, i11, z, j3, string7, i13, z2, string8, i15, string9, string10, friendPartyStatusA, gamingInfoA, userGameCareerTotalDataA, cursor.isNull(i21) ? null : cursor.getString(i21), cursor.getLong(i + 25));
    }

    public FriendDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.friendPartyStatusConverter = new d();
        this.gamingInfoConverter = new g();
        this.userGameDataResponseConverter = new o();
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, Friend friend, int i) {
        int i2 = i + 0;
        friend.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        friend.setUserId(cursor.getLong(i + 1));
        friend.setLocalUserId(cursor.getLong(i + 2));
        int i3 = i + 3;
        friend.setAlias(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        friend.setDetails(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        friend.setGameId(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 6;
        friend.setNickName(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 7;
        friend.setPicUrl(cursor.isNull(i7) ? null : cursor.getString(i7));
        friend.setStatus(cursor.getInt(i + 8));
        int i8 = i + 9;
        friend.setExpireDate(cursor.isNull(i8) ? null : cursor.getString(i8));
        friend.setVip(cursor.getInt(i + 10));
        friend.setSex(cursor.getInt(i + 11));
        friend.setFriend(cursor.getShort(i + 12) != 0);
        friend.setClanId(cursor.getLong(i + 13));
        int i9 = i + 14;
        friend.setClanName(cursor.isNull(i9) ? null : cursor.getString(i9));
        friend.setRole(cursor.getInt(i + 15));
        friend.setIsSearchById(cursor.getShort(i + 16) != 0);
        int i10 = i + 17;
        friend.setGameName(cursor.isNull(i10) ? null : cursor.getString(i10));
        friend.setAge(cursor.getInt(i + 18));
        int i11 = i + 19;
        friend.setLanguage(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 20;
        friend.setCountry(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 21;
        friend.setFriendPartyStatus(cursor.isNull(i13) ? null : this.friendPartyStatusConverter.a(cursor.getString(i13)));
        int i14 = i + 22;
        friend.setGamingInfo(cursor.isNull(i14) ? null : this.gamingInfoConverter.a(cursor.getString(i14)));
        int i15 = i + 23;
        friend.setUserGameDataResponse(cursor.isNull(i15) ? null : this.userGameDataResponseConverter.a(cursor.getString(i15)));
        int i16 = i + 24;
        friend.setStarCode(cursor.isNull(i16) ? null : cursor.getString(i16));
        friend.setLogoutTime(cursor.getLong(i + 25));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, Friend friend) {
        sQLiteStatement.clearBindings();
        Long id = friend.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, friend.getUserId());
        sQLiteStatement.bindLong(3, friend.getLocalUserId());
        String alias = friend.getAlias();
        if (alias != null) {
            sQLiteStatement.bindString(4, alias);
        }
        String details = friend.getDetails();
        if (details != null) {
            sQLiteStatement.bindString(5, details);
        }
        String gameId = friend.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(6, gameId);
        }
        String nickName = friend.getNickName();
        if (nickName != null) {
            sQLiteStatement.bindString(7, nickName);
        }
        String picUrl = friend.getPicUrl();
        if (picUrl != null) {
            sQLiteStatement.bindString(8, picUrl);
        }
        sQLiteStatement.bindLong(9, friend.getStatus());
        String expireDate = friend.getExpireDate();
        if (expireDate != null) {
            sQLiteStatement.bindString(10, expireDate);
        }
        sQLiteStatement.bindLong(11, friend.getVip());
        sQLiteStatement.bindLong(12, friend.getSex());
        sQLiteStatement.bindLong(13, friend.getFriend() ? 1L : 0L);
        sQLiteStatement.bindLong(14, friend.getClanId());
        String clanName = friend.getClanName();
        if (clanName != null) {
            sQLiteStatement.bindString(15, clanName);
        }
        sQLiteStatement.bindLong(16, friend.getRole());
        sQLiteStatement.bindLong(17, friend.getIsSearchById() ? 1L : 0L);
        String gameName = friend.getGameName();
        if (gameName != null) {
            sQLiteStatement.bindString(18, gameName);
        }
        sQLiteStatement.bindLong(19, friend.getAge());
        String language = friend.getLanguage();
        if (language != null) {
            sQLiteStatement.bindString(20, language);
        }
        String country = friend.getCountry();
        if (country != null) {
            sQLiteStatement.bindString(21, country);
        }
        FriendPartyStatus friendPartyStatus = friend.getFriendPartyStatus();
        if (friendPartyStatus != null) {
            sQLiteStatement.bindString(22, this.friendPartyStatusConverter.a(friendPartyStatus));
        }
        GamingInfo gamingInfo = friend.getGamingInfo();
        if (gamingInfo != null) {
            sQLiteStatement.bindString(23, this.gamingInfoConverter.a(gamingInfo));
        }
        UserGameCareerTotalData userGameDataResponse = friend.getUserGameDataResponse();
        if (userGameDataResponse != null) {
            sQLiteStatement.bindString(24, this.userGameDataResponseConverter.a(userGameDataResponse));
        }
        String starCode = friend.getStarCode();
        if (starCode != null) {
            sQLiteStatement.bindString(25, starCode);
        }
        sQLiteStatement.bindLong(26, friend.getLogoutTime());
    }
}
