package com.sandboxol.greendao.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.umeng.analytics.pro.ay;
import org.greenrobot.greendao.a;
import org.greenrobot.greendao.b.c;
import org.greenrobot.greendao.f;

/* JADX INFO: loaded from: classes3.dex */
public class FloatViewInfoDao extends a<FloatViewInfo, Long> {
    public static final String TABLENAME = "FLOAT_VIEW_INFO";

    public static class Properties {
        public static final f UserId = new f(0, Long.TYPE, "userId", true, ay.f20688d);
        public static final f LocationX = new f(1, Integer.TYPE, "locationX", false, "LOCATION_X");
        public static final f LocationY = new f(2, Integer.TYPE, "locationY", false, "LOCATION_Y");
    }

    public FloatViewInfoDao(org.greenrobot.greendao.c.a aVar) {
        super(aVar);
    }

    public static void createTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        aVar.a("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"FLOAT_VIEW_INFO\" (\"_id\" INTEGER PRIMARY KEY NOT NULL ,\"LOCATION_X\" INTEGER NOT NULL ,\"LOCATION_Y\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.b.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FLOAT_VIEW_INFO\"");
        aVar.a(sb.toString());
    }

    @Override // org.greenrobot.greendao.a
    protected final boolean isEntityUpdateable() {
        return true;
    }

    public FloatViewInfoDao(org.greenrobot.greendao.c.a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    @Override // org.greenrobot.greendao.a
    public Long getKey(FloatViewInfo floatViewInfo) {
        if (floatViewInfo != null) {
            return Long.valueOf(floatViewInfo.getUserId());
        }
        return null;
    }

    @Override // org.greenrobot.greendao.a
    public boolean hasKey(FloatViewInfo floatViewInfo) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final Long updateKeyAfterInsert(FloatViewInfo floatViewInfo, long j) {
        floatViewInfo.setUserId(j);
        return Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(c cVar, FloatViewInfo floatViewInfo) {
        cVar.d();
        cVar.a(1, floatViewInfo.getUserId());
        cVar.a(2, floatViewInfo.getLocationX());
        cVar.a(3, floatViewInfo.getLocationY());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.a
    public FloatViewInfo readEntity(Cursor cursor, int i) {
        return new FloatViewInfo(cursor.getLong(i + 0), cursor.getInt(i + 1), cursor.getInt(i + 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.a
    public final void bindValues(SQLiteStatement sQLiteStatement, FloatViewInfo floatViewInfo) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, floatViewInfo.getUserId());
        sQLiteStatement.bindLong(2, floatViewInfo.getLocationX());
        sQLiteStatement.bindLong(3, floatViewInfo.getLocationY());
    }

    @Override // org.greenrobot.greendao.a
    public void readEntity(Cursor cursor, FloatViewInfo floatViewInfo, int i) {
        floatViewInfo.setUserId(cursor.getLong(i + 0));
        floatViewInfo.setLocationX(cursor.getInt(i + 1));
        floatViewInfo.setLocationY(cursor.getInt(i + 2));
    }
}
