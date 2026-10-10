package com.sandboxol.report.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes4.dex */
public class EventInfoRequestDao extends a<EventInfoRequest, Long> {
    public static final String TABLENAME = "EVENT_INFO_REQUEST";

    public static class Properties {
        public static final f ID = new f(0, Long.class, "ID", true, ay.f20688d);
        public static final f Event = new f(1, String.class, "event", false, "EVENT");
        public static final f EventType = new f(2, String.class, "eventType", false, "EVENT_TYPE");
        public static final f Platform = new f(3, String.class, "platform", false, "PLATFORM");
        public static final f Data = new f(4, String.class, "data", false, "DATA");
        public static final f UserId = new f(5, Long.class, "userId", false, "USER_ID");
    }

    public EventInfoRequestDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"EVENT_INFO_REQUEST\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"EVENT\" TEXT,\"EVENT_TYPE\" TEXT,\"PLATFORM\" TEXT,\"DATA\" TEXT,\"USER_ID\" INTEGER);");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"EVENT_INFO_REQUEST\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public EventInfoRequestDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(EventInfoRequest eventInfoRequest) {
        if (eventInfoRequest != null) {
            return eventInfoRequest.getID();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(EventInfoRequest eventInfoRequest) {
        return eventInfoRequest.getID() != null;
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
    public final Long updateKeyAfterInsert(EventInfoRequest eventInfoRequest, long j) {
        eventInfoRequest.setID(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, EventInfoRequest eventInfoRequest) {
        cVar.d();
        Long id = eventInfoRequest.getID();
        if (id != null) {
            cVar.a(1, id.longValue());
        }
        String event = eventInfoRequest.getEvent();
        if (event != null) {
            cVar.a(2, event);
        }
        String eventType = eventInfoRequest.getEventType();
        if (eventType != null) {
            cVar.a(3, eventType);
        }
        String platform = eventInfoRequest.getPlatform();
        if (platform != null) {
            cVar.a(4, platform);
        }
        String data = eventInfoRequest.getData();
        if (data != null) {
            cVar.a(5, data);
        }
        Long userId = eventInfoRequest.getUserId();
        if (userId != null) {
            cVar.a(6, userId.longValue());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public EventInfoRequest readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long lValueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        int i7 = i + 5;
        return new EventInfoRequest(lValueOf, string, string2, string3, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : Long.valueOf(cursor.getLong(i7)));
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, EventInfoRequest eventInfoRequest, int i) {
        int i2 = i + 0;
        eventInfoRequest.setID(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        eventInfoRequest.setEvent(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        eventInfoRequest.setEventType(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        eventInfoRequest.setPlatform(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        eventInfoRequest.setData(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        eventInfoRequest.setUserId(cursor.isNull(i7) ? null : Long.valueOf(cursor.getLong(i7)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, EventInfoRequest eventInfoRequest) {
        sQLiteStatement.clearBindings();
        Long id = eventInfoRequest.getID();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String event = eventInfoRequest.getEvent();
        if (event != null) {
            sQLiteStatement.bindString(2, event);
        }
        String eventType = eventInfoRequest.getEventType();
        if (eventType != null) {
            sQLiteStatement.bindString(3, eventType);
        }
        String platform = eventInfoRequest.getPlatform();
        if (platform != null) {
            sQLiteStatement.bindString(4, platform);
        }
        String data = eventInfoRequest.getData();
        if (data != null) {
            sQLiteStatement.bindString(5, data);
        }
        Long userId = eventInfoRequest.getUserId();
        if (userId != null) {
            sQLiteStatement.bindLong(6, userId.longValue());
        }
    }
}
