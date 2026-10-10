package zlc.season.rxdownload3.core;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.k;
import kotlin.l;
import kotlin.reflect.e;
import zlc.season.rxdownload3.core.DownloadService;

/* JADX INFO: compiled from: DownloadService.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class DownloadService$DownloadBinder$isExists$1 extends FunctionReference implements b<Boolean, l> {
    DownloadService$DownloadBinder$isExists$1(DownloadService.BoolCallback boolCallback) {
        super(1, boolCallback);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "apply";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(DownloadService.BoolCallback.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "apply(Z)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return l.f22855a;
    }

    public final void invoke(boolean z) {
        ((DownloadService.BoolCallback) this.receiver).a(z);
    }
}
