package zlc.season.rxdownload3.database;

import android.database.Cursor;
import io.reactivex.j;
import io.reactivex.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.a;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.Mission;

/* JADX INFO: compiled from: SQLiteActor.kt */
/* JADX INFO: loaded from: classes5.dex */
final class SQLiteActor$getAllMission$1<T> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SQLiteActor f23813a;

    @Override // io.reactivex.l
    public final void a(j<List<Mission>> jVar) throws IOException {
        i.b(jVar, "emitter");
        Throwable th = null;
        Cursor cursorRawQuery = this.f23813a.m.getReadableDatabase().rawQuery("SELECT * FROM " + this.f23813a.a(), null);
        try {
            try {
                ArrayList arrayList = new ArrayList();
                while (cursorRawQuery.moveToNext()) {
                    SQLiteActor sQLiteActor = this.f23813a;
                    i.a((Object) cursorRawQuery, "cursor");
                    arrayList.add(sQLiteActor.a(cursorRawQuery));
                }
                jVar.onSuccess(arrayList);
                kotlin.l lVar = kotlin.l.f22855a;
            } finally {
            }
        } finally {
            a.a(cursorRawQuery, th);
        }
    }
}
