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
final /* synthetic */ class DownloadService$DownloadBinder$create$1 extends FunctionReference implements b<Status, l> {
    DownloadService$DownloadBinder$create$1(DownloadService.StatusCallback statusCallback) {
        super(1, statusCallback);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "apply";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(DownloadService.StatusCallback.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "apply(Lzlc/season/rxdownload3/core/Status;)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(Status status) {
        invoke2(status);
        return l.f22855a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Status status) {
        i.b(status, "p1");
        ((DownloadService.StatusCallback) this.receiver).a(status);
    }
}
