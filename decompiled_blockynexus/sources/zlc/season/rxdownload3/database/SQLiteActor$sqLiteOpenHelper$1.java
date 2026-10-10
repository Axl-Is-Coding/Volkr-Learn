package zlc.season.rxdownload3.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;

/* JADX INFO: compiled from: SQLiteActor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteActor$sqLiteOpenHelper$1 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SQLiteActor f23815a;

    private final void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(str);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        a(sQLiteDatabase, this.f23815a.b());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase != null && i < 2) {
            Iterator<T> it = this.f23815a.c().iterator();
            while (it.hasNext()) {
                a(sQLiteDatabase, (String) it.next());
            }
        }
    }
}
