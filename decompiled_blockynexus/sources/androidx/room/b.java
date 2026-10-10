package androidx.room;

import a.a.d;
import android.util.Log;
import androidx.sqlite.db.f;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InvalidationTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2051a = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f2053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long[] f2054d;
    final RoomDatabase g;
    volatile f j;
    private a k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object[] f2055e = new Object[1];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f2056f = 0;
    AtomicBoolean h = new AtomicBoolean(false);
    private volatile boolean i = false;
    final androidx.arch.core.b.b<AbstractC0032b, c> l = new androidx.arch.core.b.b<>();
    Runnable m = new androidx.room.a(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a.a.b<String, Integer> f2052b = new a.a.b<>();

    /* JADX INFO: compiled from: InvalidationTracker.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f2057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean[] f2058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f2059c;

        a(int i) {
            this.f2057a = new long[i];
            this.f2058b = new boolean[i];
            this.f2059c = new int[i];
            Arrays.fill(this.f2057a, 0L);
            Arrays.fill(this.f2058b, false);
        }
    }

    /* JADX INFO: renamed from: androidx.room.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InvalidationTracker.java */
    public static abstract class AbstractC0032b {
        public abstract void a(Set<String> set);
    }

    /* JADX INFO: compiled from: InvalidationTracker.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f2060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f2061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f2062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AbstractC0032b f2063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set<String> f2064e;

        void a(long[] jArr) {
            int length = this.f2060a.length;
            Set<String> dVar = null;
            for (int i = 0; i < length; i++) {
                long j = jArr[this.f2060a[i]];
                long[] jArr2 = this.f2062c;
                if (jArr2[i] < j) {
                    jArr2[i] = j;
                    if (length == 1) {
                        dVar = this.f2064e;
                    } else {
                        if (dVar == null) {
                            dVar = new d<>(length);
                        }
                        dVar.add(this.f2061b[i]);
                    }
                }
            }
            if (dVar != null) {
                this.f2063d.a(dVar);
            }
        }
    }

    public b(RoomDatabase roomDatabase, String... strArr) {
        this.g = roomDatabase;
        this.k = new a(strArr.length);
        int length = strArr.length;
        this.f2053c = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.f2052b.put(lowerCase, Integer.valueOf(i));
            this.f2053c[i] = lowerCase;
        }
        this.f2054d = new long[strArr.length];
        Arrays.fill(this.f2054d, 0L);
    }

    boolean a() {
        if (!this.g.e()) {
            return false;
        }
        if (!this.i) {
            this.g.c().a();
        }
        if (this.i) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }
}
