package zlc.season.rxdownload4.manager;

import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: renamed from: zlc.season.rxdownload4.manager.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmptyRecorder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class C2957f implements J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2957f f23958a = new C2957f();

    private C2957f() {
    }

    @Override // zlc.season.rxdownload4.manager.J
    public void a(zlc.season.rxdownload4.a.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
    }

    @Override // zlc.season.rxdownload4.manager.J
    public void a(zlc.season.rxdownload4.a.a.a aVar, p pVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        kotlin.jvm.internal.i.b(pVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    @Override // zlc.season.rxdownload4.manager.J
    public void b(zlc.season.rxdownload4.a.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
    }
}
