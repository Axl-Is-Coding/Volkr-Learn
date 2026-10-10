package zlc.season.rxdownload4.manager;

import com.facebook.share.internal.ShareConstants;
import java.util.Map;

/* JADX INFO: compiled from: RxDownloadManager.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {
    public static final void b(final H h) {
        kotlin.jvm.internal.i.b(h, "$this$start");
        zlc.season.ironbranch.d.a(new kotlin.jvm.a.a<kotlin.l>() { // from class: zlc.season.rxdownload4.manager.RxDownloadManagerKt$start$1
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public /* bridge */ /* synthetic */ kotlin.l invoke() {
                invoke2();
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                h.a().b(h);
            }
        });
    }

    public static final void c(final H h) {
        kotlin.jvm.internal.i.b(h, "$this$stop");
        zlc.season.ironbranch.d.a(new kotlin.jvm.a.a<kotlin.l>() { // from class: zlc.season.rxdownload4.manager.RxDownloadManagerKt$stop$1
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public /* bridge */ /* synthetic */ kotlin.l invoke() {
                invoke2();
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                h.a().a(h);
            }
        });
    }

    public static final H a(String str, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, zlc.season.rxdownload4.download.storage.c cVar, zlc.season.rxdownload4.download.request.a aVar, zlc.season.rxdownload4.a.c.a aVar2, InterfaceC2960i interfaceC2960i, J j2, r rVar) {
        kotlin.jvm.internal.i.b(str, "$this$manager");
        kotlin.jvm.internal.i.b(map, "header");
        kotlin.jvm.internal.i.b(bVar, "dispatcher");
        kotlin.jvm.internal.i.b(bVar2, "validator");
        kotlin.jvm.internal.i.b(cVar, "storage");
        kotlin.jvm.internal.i.b(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        kotlin.jvm.internal.i.b(aVar2, "watcher");
        kotlin.jvm.internal.i.b(interfaceC2960i, "notificationCreator");
        kotlin.jvm.internal.i.b(j2, "recorder");
        kotlin.jvm.internal.i.b(rVar, "taskLimitation");
        return a(new zlc.season.rxdownload4.a.a.a(str, null, null, null, 14, null), map, i, j, bVar, bVar2, cVar, aVar, aVar2, interfaceC2960i, j2, rVar);
    }

    public static final H a(zlc.season.rxdownload4.a.a.a aVar, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, zlc.season.rxdownload4.download.storage.c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3, InterfaceC2960i interfaceC2960i, J j2, r rVar) {
        kotlin.jvm.internal.i.b(aVar, "$this$manager");
        kotlin.jvm.internal.i.b(map, "header");
        kotlin.jvm.internal.i.b(bVar, "dispatcher");
        kotlin.jvm.internal.i.b(bVar2, "validator");
        kotlin.jvm.internal.i.b(cVar, "storage");
        kotlin.jvm.internal.i.b(aVar2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        kotlin.jvm.internal.i.b(aVar3, "watcher");
        kotlin.jvm.internal.i.b(interfaceC2960i, "notificationCreator");
        kotlin.jvm.internal.i.b(j2, "recorder");
        kotlin.jvm.internal.i.b(rVar, "taskLimitation");
        return I.f23945b.a(aVar, map, i, j, bVar, bVar2, cVar, aVar2, aVar3, interfaceC2960i, j2, rVar);
    }

    public static final void a(final H h) {
        kotlin.jvm.internal.i.b(h, "$this$delete");
        zlc.season.ironbranch.d.a(new kotlin.jvm.a.a<kotlin.l>() { // from class: zlc.season.rxdownload4.manager.RxDownloadManagerKt$delete$1
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public /* bridge */ /* synthetic */ kotlin.l invoke() {
                invoke2();
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                h.a().c(h);
            }
        });
    }
}
