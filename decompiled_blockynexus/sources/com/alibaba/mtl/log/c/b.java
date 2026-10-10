package com.alibaba.mtl.log.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import com.umeng.analytics.pro.ay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: LogSqliteStore.java */
/* JADX INFO: loaded from: classes.dex */
class b implements com.alibaba.mtl.log.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f3617a;
    String ae = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    String af = "SELECT count(*) FROM %s";
    String ag = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";

    /* JADX INFO: compiled from: LogSqliteStore.java */
    class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SQLiteDatabase f3618a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AtomicInteger f3619e;

        a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.f3619e = new AtomicInteger();
        }

        public synchronized void a(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.f3619e.decrementAndGet() == 0 && this.f3618a != null) {
                    this.f3618a.close();
                    this.f3618a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
            } catch (Throwable th) {
                i.a("TAG", "e", th);
                com.alibaba.mtl.appmonitor.b.b.m17a(th);
            }
            if (this.f3619e.incrementAndGet() == 1) {
                this.f3618a = super.getWritableDatabase();
            }
            return this.f3618a;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable th) {
                b.this.a((Cursor) null);
                throw th;
            }
            b.this.a(cursorRawQuery);
            super.onOpen(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    i.a("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }
    }

    protected b(Context context) {
        this.f3617a = new a(context);
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized void c(String str, String str2) {
        a aVar;
        SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                try {
                    writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
                    aVar = this.f3617a;
                } catch (Throwable unused) {
                    aVar = this.f3617a;
                }
                aVar.a(writableDatabase);
            } catch (Throwable th) {
                this.f3617a.a(writableDatabase);
                throw th;
            }
        } else {
            i.a("UTSqliteLogStore", "db is null");
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized void clear() {
        SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.f3617a.a(writableDatabase);
        }
    }

    @Override // com.alibaba.mtl.log.c.a
    public void e(int i) {
        if (i <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
        if (writableDatabase == null) {
            i.a("UTSqliteLogStore", "db is null");
            return;
        }
        try {
            writableDatabase.execSQL(String.format(this.ag, Integer.valueOf(i)));
        } catch (Throwable th) {
            this.f3617a.a(writableDatabase);
            throw th;
        }
        this.f3617a.a(writableDatabase);
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized int g() {
        int i;
        a aVar;
        SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
        i = 0;
        if (writableDatabase != null) {
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = writableDatabase.rawQuery(String.format(this.af, "log"), null);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.moveToFirst();
                        i = cursorRawQuery.getInt(0);
                    }
                    a(cursorRawQuery);
                    aVar = this.f3617a;
                } catch (Throwable th) {
                    a(cursorRawQuery);
                    this.f3617a.a(writableDatabase);
                    throw th;
                }
            } catch (Throwable unused) {
                a(cursorRawQuery);
                aVar = this.f3617a;
            }
            aVar.a(writableDatabase);
        } else {
            i.a("UTSqliteLogStore", "db is null");
        }
        return i;
    }

    @Override // com.alibaba.mtl.log.c.a
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo21a(List<com.alibaba.mtl.log.model.a> list) {
        a aVar;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = null;
                boolean z = false;
                try {
                    try {
                        writableDatabase = this.f3617a.getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.beginTransaction();
                            int i = 0;
                            while (true) {
                                try {
                                    if (i >= list.size()) {
                                        z = true;
                                        break;
                                    }
                                    com.alibaba.mtl.log.model.a aVar2 = list.get(i);
                                    if (aVar2 != null) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("eventId", aVar2.X);
                                        contentValues.put("priority", aVar2.Y);
                                        contentValues.put("content", aVar2.j());
                                        contentValues.put("time", aVar2.aa);
                                        contentValues.put("_index", aVar2.ab);
                                        long jInsert = writableDatabase.insert("log", "", contentValues);
                                        if (jInsert == -1) {
                                            break;
                                        }
                                        i.a("UTSqliteLogStore", "[insert] ", aVar2.ab, " isSuccess:", true, "ret", Long.valueOf(jInsert));
                                    }
                                    i++;
                                } catch (Throwable th) {
                                    th = th;
                                    z = true;
                                    i.a("UTSqliteLogStore", "insert error", th);
                                    com.alibaba.mtl.appmonitor.b.b.m17a(th);
                                    if (writableDatabase != null) {
                                        try {
                                            writableDatabase.setTransactionSuccessful();
                                        } catch (Throwable unused) {
                                        }
                                        try {
                                            writableDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    aVar = this.f3617a;
                                }
                            }
                        } else {
                            i.a("UTSqliteLogStore", "db is null");
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.setTransactionSuccessful();
                            } catch (Throwable unused3) {
                            }
                            try {
                                writableDatabase.endTransaction();
                            } catch (Throwable unused4) {
                            }
                        }
                        aVar = this.f3617a;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    aVar.a(writableDatabase);
                    return z;
                } catch (Throwable th3) {
                    if (0 != 0) {
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (Throwable unused5) {
                        }
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable unused6) {
                        }
                    }
                    this.f3617a.a(null);
                    throw th3;
                }
            }
        }
        return true;
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized int a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z;
        int i;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.beginTransaction();
                        z = true;
                        i = 0;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            long jDelete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i2).id + ""});
                            if (jDelete <= 0) {
                                i.a("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i2).id), " ret:", Long.valueOf(jDelete));
                                z = false;
                            } else if (!"6005".equalsIgnoreCase(list.get(i2).X)) {
                                i++;
                            }
                        }
                    } finally {
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (Throwable unused) {
                        }
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable unused2) {
                        }
                        this.f3617a.a(writableDatabase);
                    }
                } else {
                    i.a("UTSqliteLogStore", "db is null");
                    z = false;
                    i = 0;
                }
                i.a("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                return i;
            }
        }
        return 0;
    }

    @Override // com.alibaba.mtl.log.c.a
    public synchronized ArrayList<com.alibaba.mtl.log.model.a> a(String str, int i) {
        ArrayList<com.alibaba.mtl.log.model.a> arrayList;
        a aVar;
        Cursor cursorRawQuery = null;
        try {
        } catch (Throwable unused) {
            arrayList = null;
        }
        if (i <= 0) {
            return (ArrayList) Collections.EMPTY_LIST;
        }
        arrayList = new ArrayList<>(i);
        try {
            SQLiteDatabase writableDatabase = this.f3617a.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM ");
                sb.append("log");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" WHERE ");
                    sb.append(str);
                }
                sb.append(" ORDER BY ");
                sb.append("time");
                sb.append(" ASC ");
                sb.append(" LIMIT ");
                sb.append(i + "");
                String string = sb.toString();
                i.a("UTSqliteLogStore", "sql:" + string);
                try {
                    try {
                        cursorRawQuery = writableDatabase.rawQuery(string, null);
                        while (cursorRawQuery != null) {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            com.alibaba.mtl.log.model.a aVar2 = new com.alibaba.mtl.log.model.a();
                            i.a("UTSqliteLogStore", "pos", Integer.valueOf(cursorRawQuery.getPosition()), "count", Integer.valueOf(cursorRawQuery.getCount()));
                            aVar2.id = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(ay.f20688d));
                            aVar2.X = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("eventId"));
                            aVar2.Y = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("priority"));
                            aVar2.l(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("content")));
                            aVar2.aa = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("time"));
                            try {
                                aVar2.ab = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("_index"));
                            } catch (Throwable unused2) {
                            }
                            arrayList.add(aVar2);
                        }
                        a(cursorRawQuery);
                        aVar = this.f3617a;
                    } catch (Throwable th) {
                        i.a("UTSqliteLogStore", "[get]", th);
                        a(cursorRawQuery);
                        aVar = this.f3617a;
                    }
                    aVar.a(writableDatabase);
                } catch (Throwable th2) {
                    a(cursorRawQuery);
                    this.f3617a.a(writableDatabase);
                    throw th2;
                }
            } else {
                i.a("UTSqliteLogStore", "db is null");
            }
        } catch (Throwable unused3) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
