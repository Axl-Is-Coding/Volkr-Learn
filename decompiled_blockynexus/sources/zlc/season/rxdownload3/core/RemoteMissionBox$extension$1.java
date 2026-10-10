package zlc.season.rxdownload3.core;

import io.reactivex.j;
import io.reactivex.l;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadService;
import zlc.season.rxdownload3.core.RemoteMissionBox;
import zlc.season.rxdownload3.extension.Extension;

/* JADX INFO: compiled from: RemoteMissionBox.kt */
/* JADX INFO: loaded from: classes5.dex */
final class RemoteMissionBox$extension$1<T> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RemoteMissionBox f23784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Mission f23785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Class f23786c;

    @Override // io.reactivex.l
    public final void a(final j<Object> jVar) {
        i.b(jVar, "emitter");
        this.f23784a.a((b<? super DownloadService.DownloadBinder, kotlin.l>) new b<DownloadService.DownloadBinder, kotlin.l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$extension$1.1
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
                RemoteMissionBox$extension$1 remoteMissionBox$extension$1 = RemoteMissionBox$extension$1.this;
                Mission mission = remoteMissionBox$extension$1.f23785b;
                Class<? extends Extension> cls = remoteMissionBox$extension$1.f23786c;
                j jVar2 = jVar;
                i.a((Object) jVar2, "emitter");
                RemoteMissionBox.SuccessCallbackImpl successCallbackImpl = new RemoteMissionBox.SuccessCallbackImpl(jVar2);
                j jVar3 = jVar;
                i.a((Object) jVar3, "emitter");
                downloadBinder.a(mission, cls, successCallbackImpl, new RemoteMissionBox.ErrorCallbackImpl(jVar3));
            }
        });
    }
}
