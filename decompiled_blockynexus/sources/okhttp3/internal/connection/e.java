package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.K;

/* JADX INFO: compiled from: RouteDatabase.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<K> f23217a = new LinkedHashSet();

    public synchronized void a(K k) {
        this.f23217a.remove(k);
    }

    public synchronized void b(K k) {
        this.f23217a.add(k);
    }

    public synchronized boolean c(K k) {
        return this.f23217a.contains(k);
    }
}
