package com.sandboxol.report.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.sandboxol.report.convert.EventListConverter;
import com.umeng.analytics.pro.ay;
import java.util.List;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes4.dex */
public class NewEventInfoRequestDao extends a<NewEventInfoRequest, Long> {
    public static final String TABLENAME = "NEW_EVENT_INFO_REQUEST";
    private final EventListConverter eventListConverter;

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f EventType = new f(1, String.class, "eventType", false, "EVENT_TYPE");
        public static final f Platform = new f(2, String.class, "platform", false, "PLATFORM");
        public static final f GameId = new f(3, String.class, "gameId", false, "GAME_ID");
        public static final f StatisticType = new f(4, Integer.TYPE, "statisticType", false, "STATISTIC_TYPE");
        public static final f Timestamp = new f(5, Long.TYPE, "timestamp", false, "TIMESTAMP");
        public static final f IsUpdate = new f(6, Boolean.TYPE, "isUpdate", false, "IS_UPDATE");
        public static final f EventList = new f(7, String.class, "eventList", false, "EVENT_LIST");
    }

    public NewEventInfoRequestDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
        this.eventListConverter = new EventListConverter();
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"NEW_EVENT_INFO_REQUEST\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"EVENT_TYPE\" TEXT,\"PLATFORM\" TEXT,\"GAME_ID\" TEXT,\"STATISTIC_TYPE\" INTEGER NOT NULL ,\"TIMESTAMP\" INTEGER NOT NULL ,\"IS_UPDATE\" INTEGER NOT NULL ,\"EVENT_LIST\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"NEW_EVENT_INFO_REQUEST\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(NewEventInfoRequest newEventInfoRequest) {
        if (newEventInfoRequest != null) {
            return newEventInfoRequest.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(NewEventInfoRequest newEventInfoRequest) {
        return newEventInfoRequest.getID() != null;
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
    public final Long updateKeyAfterInsert(NewEventInfoRequest newEventInfoRequest, long j) {
        newEventInfoRequest.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public NewEventInfoRequestDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
        this.eventListConverter = new EventListConverter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, NewEventInfoRequest newEventInfoRequest) {
        cVar.d();
        Long id = newEventInfoRequest.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        String eventType = newEventInfoRequest.getEventType();
        if (eventType != null) {
            cVar.a(2, eventType);
        }
        String platform = newEventInfoRequest.getPlatform();
        if (platform != null) {
            cVar.a(3, platform);
        }
        String gameId = newEventInfoRequest.getGameId();
        if (gameId != null) {
            cVar.a(4, gameId);
        }
        cVar.a(5, newEventInfoRequest.getStatisticType());
        cVar.a(6, newEventInfoRequest.getTimestamp());
        cVar.a(7, newEventInfoRequest.getIsUpdate() ? 1L : 0L);
        List<NewEvent> eventList = newEventInfoRequest.getEventList();
        if (eventList != null) {
            cVar.a(8, this.eventListConverter.convertToDatabaseValue(eventList));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public NewEventInfoRequest readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 4);
        long j = cursor.getLong(i + 5);
        boolean z = cursor.getShort(i + 6) != 0;
        int i7 = i + 7;
        return new NewEventInfoRequest(lValueOf, string, string2, string3, i6, j, z, cursor.isNull(i7) ? null : this.eventListConverter.convertToEntityProperty(cursor.getString(i7)));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, NewEventInfoRequest newEventInfoRequest, int i) {
        int i2 = i + 0;
        newEventInfoRequest.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        newEventInfoRequest.setEventType(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        newEventInfoRequest.setPlatform(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        newEventInfoRequest.setGameId(cursor.isNull(i5) ? null : cursor.getString(i5));
        newEventInfoRequest.setStatisticType(cursor.getInt(i + 4));
        newEventInfoRequest.setTimestamp(cursor.getLong(i + 5));
        newEventInfoRequest.setIsUpdate(cursor.getShort(i + 6) != 0);
        int i6 = i + 7;
        newEventInfoRequest.setEventList(cursor.isNull(i6) ? null : this.eventListConverter.convertToEntityProperty(cursor.getString(i6)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, NewEventInfoRequest newEventInfoRequest) {
        sQLiteStatement.clearBindings();
        Long id = newEventInfoRequest.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String eventType = newEventInfoRequest.getEventType();
        if (eventType != null) {
            sQLiteStatement.bindString(2, eventType);
        }
        String platform = newEventInfoRequest.getPlatform();
        if (platform != null) {
            sQLiteStatement.bindString(3, platform);
        }
        String gameId = newEventInfoRequest.getGameId();
        if (gameId != null) {
            sQLiteStatement.bindString(4, gameId);
        }
        sQLiteStatement.bindLong(5, newEventInfoRequest.getStatisticType());
        sQLiteStatement.bindLong(6, newEventInfoRequest.getTimestamp());
        sQLiteStatement.bindLong(7, newEventInfoRequest.getIsUpdate() ? 1L : 0L);
        List<NewEvent> eventList = newEventInfoRequest.getEventList();
        if (eventList != null) {
            sQLiteStatement.bindString(8, this.eventListConverter.convertToDatabaseValue(eventList));
        }
    }
}
