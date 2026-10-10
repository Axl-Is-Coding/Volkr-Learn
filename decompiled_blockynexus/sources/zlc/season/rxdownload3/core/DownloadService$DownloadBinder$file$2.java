package zlc.season.rxdownload3.core;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.l;
import kotlin.reflect.e;
import zlc.season.rxdownload3.core.DownloadService;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class DownloadService$DownloadBinder$file$2 extends FunctionReference implements b<Throwable, l> {
    DownloadService$DownloadBinder$file$2(DownloadService.ErrorCallback errorCallback) {
        super(1, errorCallback);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "apply";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(DownloadService.ErrorCallback.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "apply(Ljava/lang/Throwable;)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(Throwable th) {
        invoke2(th);
        return l.f22855a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        i.b(th, "p1");
        ((DownloadService.ErrorCallback) this.receiver).a(th);
    }
}
