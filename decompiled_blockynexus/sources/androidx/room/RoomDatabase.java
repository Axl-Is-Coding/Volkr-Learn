package androidx.room;

import android.database.Cursor;
import androidx.sqlite.db.c;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile androidx.sqlite.db.b f2044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2045b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantLock f2048e = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2046c = a();

    public static class Builder<T extends RoomDatabase> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<a> f2049a;

        public Builder<T> addCallback(a aVar) {
            if (this.f2049a == null) {
                this.f2049a = new ArrayList<>();
            }
            this.f2049a.add(aVar);
            return this;
        }
    }

    public static abstract class a {
    }

    public Cursor a(String str, Object[] objArr) {
        return this.f2045b.a().a(new androidx.sqlite.db.a(str, objArr));
    }

    protected abstract b a();

    Lock b() {
        return this.f2048e;
    }

    public c c() {
        return this.f2045b;
    }

    public boolean d() {
        return this.f2045b.a().J();
    }

    public boolean e() {
        androidx.sqlite.db.b bVar = this.f2044a;
        return bVar != null && bVar.isOpen();
    }
}
