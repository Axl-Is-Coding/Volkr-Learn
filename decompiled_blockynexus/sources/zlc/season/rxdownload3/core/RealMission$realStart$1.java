package zlc.season.rxdownload3.core;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.l;
import kotlin.reflect.e;

/* JADX INFO: compiled from: RealMission.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class RealMission$realStart$1 extends FunctionReference implements b<Status, l> {
    RealMission$realStart$1(RealMission realMission) {
        super(1, realMission);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "emitStatusWithNotification";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final e getOwner() {
        return k.a(RealMission.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "emitStatusWithNotification(Lzlc/season/rxdownload3/core/Status;)V";
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ l invoke(Status status) {
        invoke2(status);
        return l.f22855a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Status status) {
        i.b(status, "p1");
        ((RealMission) this.receiver).b(status);
    }
}
