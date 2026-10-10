package zlc.season.rxdownload3.core;

import io.reactivex.j;
import io.reactivex.l;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadService;
import zlc.season.rxdownload3.core.RemoteMissionBox;

/* JADX INFO: compiled from: RemoteMissionBox.kt */
/* JADX INFO: loaded from: classes5.dex */
final class RemoteMissionBox$isExists$1<T> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RemoteMissionBox f23790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Mission f23791b;

    @Override // io.reactivex.l
    public final void a(final j<Boolean> jVar) {
        i.b(jVar, "emitter");
        this.f23790a.a((b<? super DownloadService.DownloadBinder, kotlin.l>) new b<DownloadService.DownloadBinder, kotlin.l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$isExists$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ kotlin.l invoke(DownloadService.DownloadBinder downloadBinder) {
                invoke2(downloadBinder);
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadService.DownloadBinder downloadBinder) {
                i.b(downloadBinder, "it");
                Mission mission = RemoteMissionBox$isExists$1.this.f23791b;
                DownloadService.BoolCallback boolCallback = new DownloadService.BoolCallback() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox.isExists.1.1.1
                    @Override // zlc.season.rxdownload3.core.DownloadService.BoolCallback
                    public void a(boolean z) {
                        jVar.onSuccess(Boolean.valueOf(z));
                    }
                };
                j jVar2 = jVar;
                i.a((Object) jVar2, "emitter");
                downloadBinder.a(mission, boolCallback, new RemoteMissionBox.ErrorCallbackImpl(jVar2));
            }
        });
    }
}
