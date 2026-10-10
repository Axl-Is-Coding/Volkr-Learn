package zlc.season.rxdownload4.manager;

import android.app.Notification;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: renamed from: zlc.season.rxdownload4.manager.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmptyNotification.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class C2956e implements InterfaceC2960i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2956e f23957a = new C2956e();

    private C2956e() {
    }

    @Override // zlc.season.rxdownload4.manager.InterfaceC2960i
    public Notification a(zlc.season.rxdownload4.a.a.a aVar, p pVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        kotlin.jvm.internal.i.b(pVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        return null;
    }

    @Override // zlc.season.rxdownload4.manager.InterfaceC2960i
    public void a(zlc.season.rxdownload4.a.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
    }
}
