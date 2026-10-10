package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f1608a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1609b = false;

    final void a() {
        this.f1609b = true;
        Map<String, Object> map = this.f1608a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f1608a.values().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
        b();
    }

    protected void b() {
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
