package zlc.season.rxdownload4.a.a;

import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: TaskInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d implements io.reactivex.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f23857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f23858b;

    d(e eVar, Ref$BooleanRef ref$BooleanRef) {
        this.f23857a = eVar;
        this.f23858b = ref$BooleanRef;
    }

    @Override // io.reactivex.b.a
    public final void run() {
        if (this.f23858b.element) {
            this.f23857a.h().b(this.f23857a.f());
        }
    }
}
