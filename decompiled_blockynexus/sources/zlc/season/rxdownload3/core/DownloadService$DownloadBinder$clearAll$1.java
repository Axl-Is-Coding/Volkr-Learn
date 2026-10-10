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
final /* synthetic */ class DownloadService$DownloadBinder$clearAll$1 extends FunctionReference implements b<Object, l> {
    DownloadService$DownloadBinder$clearAll$1(DownloadService.SuccessCallback successCallback) {
        super(1, successCallback);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "apply";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(DownloadService.SuccessCallback.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "apply(Ljava/lang/Object;)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(Object obj) {
        invoke2(obj);
        return l.f22855a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        i.b(obj, "p1");
        ((DownloadService.SuccessCallback) this.receiver).apply(obj);
    }
}
