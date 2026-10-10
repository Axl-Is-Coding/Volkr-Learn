package com.sandboxol.pingreport.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.sandboxol.pingreport.converter.IntListConverter;
import com.umeng.analytics.pro.ay;
import java.util.List;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes4.dex */
public class PingEventDao extends a<PingEvent, Long> {
    public static final String TABLENAME = "PING_EVENT";
    private final IntListConverter fpsValueListConverter;
    private final IntListConverter netPingValueListConverter;
    private final IntListConverter pingValueListConverter;

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f GameId = new f(1, String.class, "gameId", false, "GAME_ID");
        public static final f PingValueList = new f(2, String.class, "pingValueList", false, "PING_VALUE_LIST");
        public static final f NetPingValueList = new f(3, String.class, "netPingValueList", false, "NET_PING_VALUE_LIST");
        public static final f FpsValueList = new f(4, String.class, "fpsValueList", false, "FPS_VALUE_LIST");
    }

    public PingEventDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.pingValueListConverter = new IntListConverter();
        this.netPingValueListConverter = new IntListConverter();
        this.fpsValueListConverter = new IntListConverter();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PING_EVENT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"GAME_ID\" TEXT,\"PING_VALUE_LIST\" TEXT,\"NET_PING_VALUE_LIST\" TEXT,\"FPS_VALUE_LIST\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PING_EVENT\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(PingEvent pingEvent) {
        if (pingEvent != null) {
            return pingEvent.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(PingEvent pingEvent) {
        return pingEvent.getID() != null;
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
    public final Long updateKeyAfterInsert(PingEvent pingEvent, long j) {
        pingEvent.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, PingEvent pingEvent) {
        cVar.d();
        Long id = pingEvent.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        String gameId = pingEvent.getGameId();
        if (gameId != null) {
            cVar.a(2, gameId);
        }
        List<Integer> pingValueList = pingEvent.getPingValueList();
        if (pingValueList != null) {
            cVar.a(3, this.pingValueListConverter.convertToDatabaseValue(pingValueList));
        }
        List<Integer> netPingValueList = pingEvent.getNetPingValueList();
        if (netPingValueList != null) {
            cVar.a(4, this.netPingValueListConverter.convertToDatabaseValue(netPingValueList));
        }
        List<Integer> fpsValueList = pingEvent.getFpsValueList();
        if (fpsValueList != null) {
            cVar.a(5, this.fpsValueListConverter.convertToDatabaseValue(fpsValueList));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public PingEvent readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        List<Integer> listConvertToEntityProperty = cursor.isNull(i4) ? null : this.pingValueListConverter.convertToEntityProperty(cursor.getString(i4));
        int i5 = i + 3;
        int i6 = i + 4;
        return new PingEvent(lValueOf, string, listConvertToEntityProperty, cursor.isNull(i5) ? null : this.netPingValueListConverter.convertToEntityProperty(cursor.getString(i5)), cursor.isNull(i6) ? null : this.fpsValueListConverter.convertToEntityProperty(cursor.getString(i6)));
    }

    public PingEventDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.pingValueListConverter = new IntListConverter();
        this.netPingValueListConverter = new IntListConverter();
        this.fpsValueListConverter = new IntListConverter();
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, PingEvent pingEvent, int i) {
        int i2 = i + 0;
        pingEvent.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        pingEvent.setGameId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        pingEvent.setPingValueList(cursor.isNull(i4) ? null : this.pingValueListConverter.convertToEntityProperty(cursor.getString(i4)));
        int i5 = i + 3;
        pingEvent.setNetPingValueList(cursor.isNull(i5) ? null : this.netPingValueListConverter.convertToEntityProperty(cursor.getString(i5)));
        int i6 = i + 4;
        pingEvent.setFpsValueList(cursor.isNull(i6) ? null : this.fpsValueListConverter.convertToEntityProperty(cursor.getString(i6)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, PingEvent pingEvent) {
        sQLiteStatement.clearBindings();
        Long id = pingEvent.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String gameId = pingEvent.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(2, gameId);
        }
        List<Integer> pingValueList = pingEvent.getPingValueList();
        if (pingValueList != null) {
            sQLiteStatement.bindString(3, this.pingValueListConverter.convertToDatabaseValue(pingValueList));
        }
        List<Integer> netPingValueList = pingEvent.getNetPingValueList();
        if (netPingValueList != null) {
            sQLiteStatement.bindString(4, this.netPingValueListConverter.convertToDatabaseValue(netPingValueList));
        }
        List<Integer> fpsValueList = pingEvent.getFpsValueList();
        if (fpsValueList != null) {
            sQLiteStatement.bindString(5, this.fpsValueListConverter.convertToDatabaseValue(fpsValueList));
        }
    }
}
