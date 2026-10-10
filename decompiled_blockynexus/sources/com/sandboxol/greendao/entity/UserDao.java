package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class UserDao extends a<User, Long> {
    public static final String TABLENAME = "USER";

    public static class Properties {
        public static final f UserId = new f(0, Long.TYPE, "userId", true, ay.f20688d);
        public static final f Account = new f(1, String.class, GameSharedConstant.ACCOUNT, false, "ACCOUNT");
        public static final f NickName = new f(2, String.class, "nickName", false, "NICK_NAME");
        public static final f Sex = new f(3, Integer.TYPE, "sex", false, "SEX");
        public static final f PicUrl = new f(4, String.class, "picUrl", false, "PIC_URL");
        public static final f AccessToken = new f(5, String.class, "accessToken", false, "ACCESS_TOKEN");
        public static final f Details = new f(6, String.class, "details", false, "DETAILS");
        public static final f Telephone = new f(7, String.class, "telephone", false, "TELEPHONE");
        public static final f Email = new f(8, String.class, "email", false, "EMAIL");
        public static final f Birthday = new f(9, String.class, "birthday", false, "BIRTHDAY");
        public static final f Golds = new f(10, Long.TYPE, StringConstant.CHRISTMAS_GOLDS, false, "GOLDS");
        public static final f Diamonds = new f(11, Long.TYPE, StringConstant.CHRISTMAS_DIAMONDS, false, "DIAMONDS");
        public static final f GDiamonds = new f(12, Long.TYPE, "gDiamonds", false, "G_DIAMONDS");
        public static final f Password = new f(13, String.class, "password", false, "PASSWORD");
        public static final f IsFirstLogin = new f(14, Boolean.TYPE, "isFirstLogin", false, "IS_FIRST_LOGIN");
        public static final f ExpireDate = new f(15, String.class, "expireDate", false, "EXPIRE_DATE");
        public static final f Vip = new f(16, Integer.TYPE, "vip", false, "VIP");
        public static final f HasPassword = new f(17, Boolean.TYPE, "hasPassword", false, "HAS_PASSWORD");
        public static final f Platform = new f(18, String.class, "platform", false, "PLATFORM");
        public static final f StarCode = new f(19, String.class, "starCode", false, "STAR_CODE");
    }

    public UserDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"USER\" (\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"ACCOUNT\" TEXT,\"NICK_NAME\" TEXT,\"SEX\" INTEGER NOT NULL ,\"PIC_URL\" TEXT,\"ACCESS_TOKEN\" TEXT,\"DETAILS\" TEXT,\"TELEPHONE\" TEXT,\"EMAIL\" TEXT,\"BIRTHDAY\" TEXT,\"GOLDS\" INTEGER NOT NULL ,\"DIAMONDS\" INTEGER NOT NULL ,\"G_DIAMONDS\" INTEGER NOT NULL ,\"PASSWORD\" TEXT,\"IS_FIRST_LOGIN\" INTEGER NOT NULL ,\"EXPIRE_DATE\" TEXT,\"VIP\" INTEGER NOT NULL ,\"HAS_PASSWORD\" INTEGER NOT NULL ,\"PLATFORM\" TEXT,\"STAR_CODE\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"USER\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(User user) {
        if (user != null) {
            return Long.valueOf(user.getUserId());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(User user) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(User user, long j) {
        user.setUserId(j);
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, User user) {
        cVar.d();
        cVar.a(1, user.getUserId());
        String account = user.getAccount();
        if (account != null) {
            cVar.a(2, account);
        }
        String nickName = user.getNickName();
        if (nickName != null) {
            cVar.a(3, nickName);
        }
        cVar.a(4, user.getSex());
        String picUrl = user.getPicUrl();
        if (picUrl != null) {
            cVar.a(5, picUrl);
        }
        String accessToken = user.getAccessToken();
        if (accessToken != null) {
            cVar.a(6, accessToken);
        }
        String details = user.getDetails();
        if (details != null) {
            cVar.a(7, details);
        }
        String telephone = user.getTelephone();
        if (telephone != null) {
            cVar.a(8, telephone);
        }
        String email = user.getEmail();
        if (email != null) {
            cVar.a(9, email);
        }
        String birthday = user.getBirthday();
        if (birthday != null) {
            cVar.a(10, birthday);
        }
        cVar.a(11, user.getGolds());
        cVar.a(12, user.getDiamonds());
        cVar.a(13, user.getGDiamonds());
        String password = user.getPassword();
        if (password != null) {
            cVar.a(14, password);
        }
        cVar.a(15, user.getIsFirstLogin() ? 1L : 0L);
        String expireDate = user.getExpireDate();
        if (expireDate != null) {
            cVar.a(16, expireDate);
        }
        cVar.a(17, user.getVip());
        cVar.a(18, user.getHasPassword() ? 1L : 0L);
        String platform = user.getPlatform();
        if (platform != null) {
            cVar.a(19, platform);
        }
        String starCode = user.getStarCode();
        if (starCode != null) {
            cVar.a(20, starCode);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public User readEntity(Cursor cursor, int i) {
        long j = cursor.getLong(i + 0);
        int i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = i + 4;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 6;
        String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 7;
        String string6 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 8;
        String string7 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 9;
        String string8 = cursor.isNull(i10) ? null : cursor.getString(i10);
        long j2 = cursor.getLong(i + 10);
        long j3 = cursor.getLong(i + 11);
        long j4 = cursor.getLong(i + 12);
        int i11 = i + 13;
        String string9 = cursor.isNull(i11) ? null : cursor.getString(i11);
        boolean z = cursor.getShort(i + 14) != 0;
        int i12 = i + 15;
        String string10 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = cursor.getInt(i + 16);
        boolean z2 = cursor.getShort(i + 17) != 0;
        int i14 = i + 18;
        String string11 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 19;
        return new User(j, string, string2, i4, string3, string4, string5, string6, string7, string8, j2, j3, j4, string9, z, string10, i13, z2, string11, cursor.isNull(i15) ? null : cursor.getString(i15));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, User user, int i) {
        user.setUserId(cursor.getLong(i + 0));
        int i2 = i + 1;
        user.setAccount(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        user.setNickName(cursor.isNull(i3) ? null : cursor.getString(i3));
        user.setSex(cursor.getInt(i + 3));
        int i4 = i + 4;
        user.setPicUrl(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        user.setAccessToken(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 6;
        user.setDetails(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 7;
        user.setTelephone(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 8;
        user.setEmail(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 9;
        user.setBirthday(cursor.isNull(i9) ? null : cursor.getString(i9));
        user.setGolds(cursor.getLong(i + 10));
        user.setDiamonds(cursor.getLong(i + 11));
        user.setGDiamonds(cursor.getLong(i + 12));
        int i10 = i + 13;
        user.setPassword(cursor.isNull(i10) ? null : cursor.getString(i10));
        user.setIsFirstLogin(cursor.getShort(i + 14) != 0);
        int i11 = i + 15;
        user.setExpireDate(cursor.isNull(i11) ? null : cursor.getString(i11));
        user.setVip(cursor.getInt(i + 16));
        user.setHasPassword(cursor.getShort(i + 17) != 0);
        int i12 = i + 18;
        user.setPlatform(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 19;
        user.setStarCode(cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, User user) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, user.getUserId());
        String account = user.getAccount();
        if (account != null) {
            sQLiteStatement.bindString(2, account);
        }
        String nickName = user.getNickName();
        if (nickName != null) {
            sQLiteStatement.bindString(3, nickName);
        }
        sQLiteStatement.bindLong(4, user.getSex());
        String picUrl = user.getPicUrl();
        if (picUrl != null) {
            sQLiteStatement.bindString(5, picUrl);
        }
        String accessToken = user.getAccessToken();
        if (accessToken != null) {
            sQLiteStatement.bindString(6, accessToken);
        }
        String details = user.getDetails();
        if (details != null) {
            sQLiteStatement.bindString(7, details);
        }
        String telephone = user.getTelephone();
        if (telephone != null) {
            sQLiteStatement.bindString(8, telephone);
        }
        String email = user.getEmail();
        if (email != null) {
            sQLiteStatement.bindString(9, email);
        }
        String birthday = user.getBirthday();
        if (birthday != null) {
            sQLiteStatement.bindString(10, birthday);
        }
        sQLiteStatement.bindLong(11, user.getGolds());
        sQLiteStatement.bindLong(12, user.getDiamonds());
        sQLiteStatement.bindLong(13, user.getGDiamonds());
        String password = user.getPassword();
        if (password != null) {
            sQLiteStatement.bindString(14, password);
        }
        sQLiteStatement.bindLong(15, user.getIsFirstLogin() ? 1L : 0L);
        String expireDate = user.getExpireDate();
        if (expireDate != null) {
            sQLiteStatement.bindString(16, expireDate);
        }
        sQLiteStatement.bindLong(17, user.getVip());
        sQLiteStatement.bindLong(18, user.getHasPassword() ? 1L : 0L);
        String platform = user.getPlatform();
        if (platform != null) {
            sQLiteStatement.bindString(19, platform);
        }
        String starCode = user.getStarCode();
        if (starCode != null) {
            sQLiteStatement.bindString(20, starCode);
        }
    }
}
