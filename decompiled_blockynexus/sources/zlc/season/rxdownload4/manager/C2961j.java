package zlc.season.rxdownload4.manager;

import android.app.Notification;
import android.app.NotificationManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference0Impl;
import zlc.season.claritypotion.ClarityPotion;

/* JADX INFO: renamed from: zlc.season.rxdownload4.manager.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: NotificationHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class C2961j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f23960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.e f23961b;

    static {
        PropertyReference0Impl propertyReference0Impl = new PropertyReference0Impl(kotlin.jvm.internal.k.a(C2961j.class, "rxdownload4_release"), "notificationManager", "getNotificationManager()Landroid/app/NotificationManager;");
        kotlin.jvm.internal.k.a(propertyReference0Impl);
        f23960a = new kotlin.reflect.g[]{propertyReference0Impl};
        f23961b = kotlin.g.a(new kotlin.jvm.a.a<NotificationManager>() { // from class: zlc.season.rxdownload4.manager.NotificationHelperKt$notificationManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final NotificationManager invoke() {
                Object systemService = ClarityPotion.f23647d.a().getSystemService("notification");
                if (systemService != null) {
                    return (NotificationManager) systemService;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
            }
        });
    }

    private static final NotificationManager a() {
        kotlin.e eVar = f23961b;
        kotlin.reflect.g gVar = f23960a[0];
        return (NotificationManager) eVar.getValue();
    }

    public static final void a(zlc.season.rxdownload4.a.a.a aVar, Notification notification) {
        kotlin.jvm.internal.i.b(aVar, "task");
        if (notification != null) {
            a().notify(aVar.hashCode(), notification);
        }
    }

    public static final void a(zlc.season.rxdownload4.a.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        a().cancel(aVar.hashCode());
    }
}
