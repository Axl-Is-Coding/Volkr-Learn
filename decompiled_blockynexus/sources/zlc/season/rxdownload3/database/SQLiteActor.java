package zlc.season.rxdownload3.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.internal.AnalyticsEvents;
import java.io.IOException;
import java.util.List;
import kotlin.collections.m;
import kotlin.io.a;
import kotlin.jvm.internal.i;
import kotlin.l;
import zlc.season.rxdownload3.core.Failed;
import zlc.season.rxdownload3.core.Mission;
import zlc.season.rxdownload3.core.Normal;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.core.Status;
import zlc.season.rxdownload3.core.Succeed;
import zlc.season.rxdownload3.core.Suspend;
import zlc.season.rxdownload3.extension.ApkInstallExtension;

/* JADX INFO: compiled from: SQLiteActor.kt */
/* JADX INFO: loaded from: classes5.dex */
public class SQLiteActor implements DbActor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23812f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final SQLiteActor$sqLiteOpenHelper$1 m;

    public String b() {
        return "\n            CREATE TABLE " + this.f23810d + " (\n                " + this.f23811e + " TEXT PRIMARY KEY NOT NULL,\n                " + this.f23812f + " TEXT NOT NULL,\n                " + this.g + " TEXT,\n                " + this.h + " TEXT,\n                " + this.i + " INTEGER,\n                " + this.j + " TEXT,\n                " + this.k + " TEXT,\n                " + this.l + " INTEGER)\n            ";
    }

    public List<String> c() {
        return m.c("ALTER TABLE " + this.f23810d + " ADD " + this.j + " TEXT", "ALTER TABLE " + this.f23810d + " ADD " + this.l + " INTEGER");
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public void d(RealMission realMission) {
        i.b(realMission, "mission");
        SQLiteDatabase writableDatabase = this.m.getWritableDatabase();
        ContentValues contentValuesH = h(realMission);
        writableDatabase.update(this.f23810d, contentValuesH, this.f23811e + "=?", new String[]{realMission.b().d()});
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public void e(RealMission realMission) {
        i.b(realMission, "mission");
        Mission missionB = realMission.b();
        this.m.getWritableDatabase().delete(this.f23810d, this.f23811e + "=?", new String[]{missionB.d()});
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public void f(RealMission realMission) {
        i.b(realMission, "mission");
        SQLiteDatabase writableDatabase = this.m.getWritableDatabase();
        ContentValues contentValuesI = i(realMission);
        if (contentValuesI.size() > 0) {
            writableDatabase.update(this.f23810d, contentValuesI, this.f23811e + "=?", new String[]{realMission.b().d()});
        }
    }

    public ContentValues g(RealMission realMission) {
        i.b(realMission, "mission");
        Mission missionB = realMission.b();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f23811e, missionB.d());
        contentValues.put(this.f23812f, missionB.e());
        contentValues.put(this.g, missionB.b());
        contentValues.put(this.h, missionB.c());
        contentValues.put(this.i, Integer.valueOf(a(missionB.a())));
        contentValues.put(this.k, Long.valueOf(realMission.f()));
        return contentValues;
    }

    public ContentValues h(RealMission realMission) {
        i.b(realMission, "mission");
        Mission missionB = realMission.b();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.g, missionB.b());
        contentValues.put(this.h, missionB.c());
        contentValues.put(this.i, Integer.valueOf(a(missionB.a())));
        contentValues.put(this.k, Long.valueOf(realMission.f()));
        return contentValues;
    }

    public ContentValues i(RealMission realMission) {
        i.b(realMission, "mission");
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.j, Long.valueOf(realMission.e().b()));
        contentValues.put(this.l, Integer.valueOf(a(realMission.e())));
        return contentValues;
    }

    protected final String a() {
        return this.f23810d;
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public boolean a(RealMission realMission) throws IOException {
        i.b(realMission, "mission");
        Mission missionB = realMission.b();
        Cursor cursorRawQuery = this.m.getReadableDatabase().rawQuery("SELECT " + this.f23811e + " FROM " + this.f23810d + " where " + this.f23811e + " = ?", new String[]{missionB.d()});
        Throwable th = null;
        try {
            cursorRawQuery.moveToFirst();
            i.a((Object) cursorRawQuery, "cursor");
            return cursorRawQuery.getCount() != 0;
        } finally {
            a.a(cursorRawQuery, th);
        }
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public void c(RealMission realMission) throws IOException {
        i.b(realMission, "mission");
        Cursor cursorRawQuery = this.m.getReadableDatabase().rawQuery("SELECT * FROM " + this.f23810d + " where " + this.f23811e + " = ?", new String[]{realMission.b().d()});
        Throwable th = null;
        try {
            try {
                cursorRawQuery.moveToFirst();
                i.a((Object) cursorRawQuery, "cursor");
                if (cursorRawQuery.getCount() == 0) {
                    return;
                }
                a(cursorRawQuery, realMission);
                l lVar = l.f22855a;
                return;
            } finally {
            }
        } finally {
            a.a(cursorRawQuery, th);
        }
        a.a(cursorRawQuery, th);
    }

    public int a(Status status) {
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        if (status instanceof Normal) {
            return 1;
        }
        if (status instanceof Suspend) {
            return 2;
        }
        if (status instanceof Failed) {
            return 3;
        }
        if (status instanceof Succeed) {
            return 4;
        }
        return status instanceof ApkInstallExtension.Installed ? 5 : 1;
    }

    @Override // zlc.season.rxdownload3.database.DbActor
    public void b(RealMission realMission) {
        i.b(realMission, "mission");
        this.m.getWritableDatabase().insert(this.f23810d, null, g(realMission));
    }

    public void a(Cursor cursor, RealMission realMission) {
        i.b(cursor, "cursor");
        i.b(realMission, "mission");
        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.g));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.h));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow(this.i));
        long j = cursor.getLong(cursor.getColumnIndexOrThrow(this.j));
        long j2 = cursor.getLong(cursor.getColumnIndexOrThrow(this.k));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow(this.l));
        Mission missionB = realMission.b();
        i.a((Object) string, "saveName");
        missionB.a(string);
        i.a((Object) string2, "savePath");
        missionB.b(string2);
        missionB.a(a(i));
        Status status = new Status(j, j2, false, null, 8, null);
        realMission.a(j2);
        realMission.c(a(i2, status));
    }

    public Status a(int i, Status status) {
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        if (i == 1) {
            return new Normal(status);
        }
        if (i == 2) {
            return new Suspend(status);
        }
        if (i == 3) {
            return new Failed(status, new Exception());
        }
        if (i == 4) {
            return new Succeed(status);
        }
        if (i != 5) {
            return new Normal(status);
        }
        return new ApkInstallExtension.Installed(status);
    }

    public Mission a(Cursor cursor) {
        i.b(cursor, "cursor");
        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.f23811e));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.f23812f));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(this.g));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(this.h));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow(this.i));
        cursor.getLong(cursor.getColumnIndexOrThrow(this.k));
        i.a((Object) string2, "url");
        i.a((Object) string3, "saveName");
        i.a((Object) string4, "savePath");
        Boolean boolA = a(i);
        i.a((Object) string, "tag");
        return new Mission(string2, string3, string4, boolA, string);
    }

    private final int a(Boolean bool) {
        return i.a((Object) bool, (Object) true) ? this.f23809c : i.a((Object) bool, (Object) false) ? this.f23808b : -this.f23807a;
    }

    private final Boolean a(int i) {
        if (i == this.f23809c) {
            return true;
        }
        return i == this.f23808b ? false : null;
    }
}
