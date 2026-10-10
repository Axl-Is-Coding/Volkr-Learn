package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.room.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: InvalidationTracker.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f2050a;

    a(b bVar) {
        this.f2050a = bVar;
    }

    private boolean a() {
        b bVar = this.f2050a;
        Cursor cursorA = bVar.g.a("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", bVar.f2055e);
        boolean z = false;
        while (cursorA.moveToNext()) {
            try {
                long j = cursorA.getLong(0);
                this.f2050a.f2054d[cursorA.getInt(1)] = j;
                this.f2050a.f2056f = j;
                z = true;
            } finally {
                cursorA.close();
            }
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Lock lockB = this.f2050a.g.b();
        boolean zA = false;
        try {
            try {
                lockB.lock();
            } finally {
                lockB.unlock();
            }
        } catch (SQLiteException | IllegalStateException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        }
        if (this.f2050a.a()) {
            if (this.f2050a.h.compareAndSet(true, false)) {
                if (this.f2050a.g.d()) {
                    return;
                }
                this.f2050a.j.H();
                this.f2050a.f2055e[0] = Long.valueOf(this.f2050a.f2056f);
                if (this.f2050a.g.f2047d) {
                    androidx.sqlite.db.b bVarA = this.f2050a.g.c().a();
                    try {
                        bVarA.D();
                        zA = a();
                        bVarA.E();
                        bVarA.F();
                    } catch (Throwable th) {
                        bVarA.F();
                        throw th;
                    }
                } else {
                    zA = a();
                }
                if (zA) {
                    synchronized (this.f2050a.l) {
                        Iterator<Map.Entry<b.AbstractC0032b, b.c>> it = this.f2050a.l.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().a(this.f2050a.f2054d);
                        }
                    }
                }
            }
        }
    }
}
