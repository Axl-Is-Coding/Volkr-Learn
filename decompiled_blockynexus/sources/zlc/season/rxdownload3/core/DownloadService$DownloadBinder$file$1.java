package zlc.season.rxdownload3.core;

import java.io.File;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.l;
import kotlin.reflect.e;
import zlc.season.rxdownload3.core.DownloadService;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class DownloadService$DownloadBinder$file$1 extends FunctionReference implements b<File, l> {
    DownloadService$DownloadBinder$file$1(DownloadService.FileCallback fileCallback) {
        super(1, fileCallback);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "apply";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(DownloadService.FileCallback.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "apply(Ljava/io/File;)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(File file) {
        invoke2(file);
        return l.f22855a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(File file) {
        i.b(file, "p1");
        ((DownloadService.FileCallback) this.receiver).a(file);
    }
}
