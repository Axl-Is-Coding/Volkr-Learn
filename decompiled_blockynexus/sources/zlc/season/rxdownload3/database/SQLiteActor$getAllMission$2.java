package zlc.season.rxdownload3.database;

import io.reactivex.b.g;
import zlc.season.rxdownload3.helper.LoggerKt;

/* JADX INFO: compiled from: SQLiteActor.kt */
/* JADX INFO: loaded from: classes5.dex */
final class SQLiteActor$getAllMission$2<T> implements g<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SQLiteActor$getAllMission$2 f23814a = new SQLiteActor$getAllMission$2();

    SQLiteActor$getAllMission$2() {
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        LoggerKt.a("get all mission error", th);
    }
}
