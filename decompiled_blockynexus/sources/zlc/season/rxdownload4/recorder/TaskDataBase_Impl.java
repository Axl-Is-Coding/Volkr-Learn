package zlc.season.rxdownload4.recorder;

import androidx.room.b;

/* JADX INFO: loaded from: classes5.dex */
public final class TaskDataBase_Impl extends TaskDataBase {
    @Override // androidx.room.RoomDatabase
    protected b a() {
        return new b(this, "task_record");
    }
}
