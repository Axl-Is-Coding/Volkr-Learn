package zlc.season.rxdownload3.core;

import io.reactivex.j;
import io.reactivex.l;
import io.rong.common.LibStorageUtils;
import java.io.File;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadService;
import zlc.season.rxdownload3.core.RemoteMissionBox;

/* JADX INFO: compiled from: RemoteMissionBox.kt */
/* JADX INFO: loaded from: classes5.dex */
final class RemoteMissionBox$file$1<T> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RemoteMissionBox f23787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Mission f23788b;

    @Override // io.reactivex.l
    public final void a(final j<File> jVar) {
        i.b(jVar, "emitter");
        this.f23787a.a((b<? super DownloadService.DownloadBinder, kotlin.l>) new b<DownloadService.DownloadBinder, kotlin.l>() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox$file$1.1
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
                Mission mission = RemoteMissionBox$file$1.this.f23788b;
                DownloadService.FileCallback fileCallback = new DownloadService.FileCallback() { // from class: zlc.season.rxdownload3.core.RemoteMissionBox.file.1.1.1
                    @Override // zlc.season.rxdownload3.core.DownloadService.FileCallback
                    public void a(File file) {
                        i.b(file, LibStorageUtils.FILE);
                        jVar.onSuccess(file);
                    }
                };
                j jVar2 = jVar;
                i.a((Object) jVar2, "emitter");
                downloadBinder.a(mission, fileCallback, new RemoteMissionBox.ErrorCallbackImpl(jVar2));
            }
        });
    }
}
