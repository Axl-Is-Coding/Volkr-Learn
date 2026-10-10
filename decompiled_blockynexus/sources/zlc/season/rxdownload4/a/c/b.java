package zlc.season.rxdownload4.a.c;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: WatcherImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f23870c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f23868a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f23869b = new LinkedHashMap();

    private b() {
    }

    @Override // zlc.season.rxdownload4.a.c.a
    public synchronized void a(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        boolean z = true;
        if (!(f23868a.get(aVar.f()) == null)) {
            throw new IllegalStateException(("Task [" + aVar.f() + " is exists!").toString());
        }
        String canonicalPath = zlc.season.rxdownload4.download.utils.a.b(aVar).getCanonicalPath();
        if (f23869b.get(canonicalPath) != null) {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException(("File [" + canonicalPath + "] is occupied!").toString());
        }
        Map<String, String> map = f23868a;
        String strF = aVar.f();
        i.a((Object) strF, "task.tag()");
        String strF2 = aVar.f();
        i.a((Object) strF2, "task.tag()");
        map.put(strF, strF2);
        Map<String, String> map2 = f23869b;
        i.a((Object) canonicalPath, "filePath");
        map2.put(canonicalPath, canonicalPath);
    }

    @Override // zlc.season.rxdownload4.a.c.a
    public synchronized void b(zlc.season.rxdownload4.a.a.a aVar) {
        i.b(aVar, "task");
        f23868a.remove(aVar.f());
        f23869b.remove(zlc.season.rxdownload4.download.utils.a.b(aVar).getCanonicalPath());
    }
}
