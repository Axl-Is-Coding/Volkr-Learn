package zlc.season.rxdownload4.download.storage;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: MemoryStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0279a f23926b = new C0279a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<zlc.season.rxdownload4.a.a.a, zlc.season.rxdownload4.a.a.a> f23925a = new LinkedHashMap();

    /* JADX INFO: renamed from: zlc.season.rxdownload4.download.storage.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryStorage.kt */
    public static final class C0279a {
        private C0279a() {
        }

        public /* synthetic */ C0279a(f fVar) {
            this();
        }
    }

    @Override // zlc.season.rxdownload4.download.storage.c
    public synchronized void a(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        f23925a.remove(aVar);
    }

    @Override // zlc.season.rxdownload4.download.storage.c
    public synchronized void b(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        f23925a.put(aVar, aVar);
    }

    @Override // zlc.season.rxdownload4.download.storage.c
    public synchronized void c(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        zlc.season.rxdownload4.a.a.a aVar2 = f23925a.get(aVar);
        if (aVar2 != null) {
            aVar.a(aVar2.a());
            aVar.b(aVar2.b());
        }
    }
}
