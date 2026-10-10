package b.f.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataBaseEventsStorage.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2603e;

    public a(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f2600b = 4;
        this.f2601c = 400;
        this.f2602d = "DROP TABLE IF EXISTS events";
        this.f2603e = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    }

    public static synchronized a a(Context context, String str, int i) {
        if (f2599a == null) {
            f2599a = new a(context, str, i);
        }
        return f2599a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.Cursor, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public synchronized ArrayList<b> c(String str) {
        ArrayList<b> arrayList;
        SQLiteDatabase sQLiteDatabaseA;
        arrayList = new ArrayList<>();
        ?? Query = 0;
        Query = 0;
        try {
            try {
                sQLiteDatabaseA = a(false);
                try {
                    Query = sQLiteDatabaseA.query(com.umeng.analytics.pro.b.ao, null, "type = ?", new String[]{str}, null, null, "timestamp ASC");
                    if (Query.getCount() > 0) {
                        Query.moveToFirst();
                        while (!Query.isAfterLast()) {
                            arrayList.add(new b(Query.getInt(Query.getColumnIndex("eventid")), Query.getLong(Query.getColumnIndex("timestamp")), new JSONObject(Query.getString(Query.getColumnIndex("data")))));
                            Query.moveToNext();
                        }
                        Query.close();
                    }
                    if (Query != 0 && !Query.isClosed()) {
                        Query.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    Log.e("IronSource", "Exception while loading events: ", th);
                    if (Query != 0 && !Query.isClosed()) {
                        Query.close();
                    }
                    if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                    }
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0 && !Query.isClosed()) {
                    Query.close();
                }
                if (0 != 0 && Query.isOpen()) {
                    Query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                Query.close();
            }
            if (0 != 0) {
                Query.close();
            }
            throw th;
        }
        if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
            sQLiteDatabaseA.close();
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    public synchronized void a(List<b> list, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabaseA = a(true);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabaseA = sQLiteDatabase;
                }
                try {
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        ContentValues contentValuesA = a(it.next(), str);
                        if (sQLiteDatabaseA != null && contentValuesA != null) {
                            sQLiteDatabaseA.insert(com.umeng.analytics.pro.b.ao, null, contentValuesA);
                        }
                    }
                    if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                        sQLiteDatabaseA.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                        sQLiteDatabaseA.close();
                    }
                    throw th;
                }
            }
        }
    }

    public synchronized void a(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        String[] strArr = {str};
        try {
            try {
                sQLiteDatabaseA = a(true);
                sQLiteDatabaseA.delete(com.umeng.analytics.pro.b.ao, "type = ?", strArr);
            } catch (Throwable th) {
                Log.e("IronSource", "Exception while clearing events: ", th);
                if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                sQLiteDatabaseA.close();
            }
        }
    }

    private ContentValues a(b bVar, String str) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(bVar.c()));
        contentValues.put("timestamp", Long.valueOf(bVar.d()));
        contentValues.put("type", str);
        contentValues.put("data", bVar.a());
        return contentValues;
    }

    private synchronized SQLiteDatabase a(boolean z) throws Throwable {
        int i;
        int i2 = 0;
        while (true) {
            try {
                if (z) {
                    return getWritableDatabase();
                }
                return getReadableDatabase();
            } finally {
                if (i2 < i) {
                }
            }
        }
    }
}
