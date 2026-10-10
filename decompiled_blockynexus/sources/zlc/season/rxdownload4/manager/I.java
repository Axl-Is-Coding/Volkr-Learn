package zlc.season.rxdownload4.manager;

import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskManagerPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I f23945b = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<zlc.season.rxdownload4.a.a.a, H> f23944a = new LinkedHashMap();

    private I() {
    }

    private final void a(zlc.season.rxdownload4.a.a.a aVar, H h) {
        f23944a.put(aVar, h);
    }

    private final H b(zlc.season.rxdownload4.a.a.a aVar, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, zlc.season.rxdownload4.download.storage.c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3, InterfaceC2960i interfaceC2960i, J j2, r rVar) {
        io.reactivex.a.a<zlc.season.rxdownload4.a.a> aVarG = zlc.season.rxdownload4.a.b.a(aVar, map, i, j, bVar, bVar2, cVar, aVar2, aVar3).g();
        kotlin.jvm.internal.i.a((Object) aVarG, "download.publish()");
        return new H(aVar, cVar, aVarG, interfaceC2960i, j2, rVar);
    }

    private final H a(zlc.season.rxdownload4.a.a.a aVar) {
        return f23944a.get(aVar);
    }

    public final H a(zlc.season.rxdownload4.a.a.a aVar, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, zlc.season.rxdownload4.download.storage.c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3, InterfaceC2960i interfaceC2960i, J j2, r rVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        kotlin.jvm.internal.i.b(map, "header");
        kotlin.jvm.internal.i.b(bVar, "dispatcher");
        kotlin.jvm.internal.i.b(bVar2, "validator");
        kotlin.jvm.internal.i.b(cVar, "storage");
        kotlin.jvm.internal.i.b(aVar2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        kotlin.jvm.internal.i.b(aVar3, "watcher");
        kotlin.jvm.internal.i.b(interfaceC2960i, "notificationCreator");
        kotlin.jvm.internal.i.b(j2, "recorder");
        kotlin.jvm.internal.i.b(rVar, "taskLimitation");
        if (a(aVar) == null) {
            synchronized (this) {
                if (f23945b.a(aVar) == null) {
                    f23945b.a(aVar, f23945b.b(aVar, map, i, j, bVar, bVar2, cVar, aVar2, aVar3, interfaceC2960i, j2, rVar));
                }
                kotlin.l lVar = kotlin.l.f22855a;
            }
        }
        H hA = a(aVar);
        if (hA != null) {
            return hA;
        }
        kotlin.jvm.internal.i.a();
        throw null;
    }
}
