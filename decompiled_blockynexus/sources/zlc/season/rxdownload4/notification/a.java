package zlc.season.rxdownload4.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.l;
import androidx.core.app.o;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.reflect.g;
import zlc.season.claritypotion.ClarityPotion;

/* JADX INFO: compiled from: NotificationUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ g[] f23985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f23986b;

    static {
        PropertyReference0Impl propertyReference0Impl = new PropertyReference0Impl(k.a(a.class, "rxdownload4_release"), "notificationManager", "getNotificationManager()Landroid/app/NotificationManager;");
        k.a(propertyReference0Impl);
        f23985a = new g[]{propertyReference0Impl};
        f23986b = kotlin.g.a(new kotlin.jvm.a.a<NotificationManager>() { // from class: zlc.season.rxdownload4.notification.NotificationUtilKt$notificationManager$2
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

    public static final boolean a() {
        o oVarA = o.a(ClarityPotion.f23647d.a());
        i.a((Object) oVarA, "NotificationManagerCompat.from(clarityPotion)");
        return oVarA.a();
    }

    private static final NotificationManager b() {
        e eVar = f23986b;
        g gVar = f23985a[0];
        return (NotificationManager) eVar.getValue();
    }

    public static final void a(String str, String str2, String str3) {
        i.b(str, "channelId");
        i.b(str2, "channelName");
        i.b(str3, "channelDescription");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 2);
            notificationChannel.setDescription(str3);
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.setSound(null, null);
            b().createNotificationChannel(notificationChannel);
        }
    }

    public static final l.e a(String str, String str2, String str3, int i, PendingIntent pendingIntent, zlc.season.rxdownload4.a.a aVar, List<? extends l.a> list) {
        i.b(str, "channelId");
        i.b(str2, "title");
        i.b(str3, "content");
        i.b(list, "actions");
        l.e eVar = new l.e(ClarityPotion.f23647d.a(), str);
        eVar.c(str2);
        eVar.b(str3);
        eVar.d(i);
        eVar.a(pendingIntent);
        eVar.a(new long[]{0});
        eVar.a((Uri) null);
        eVar.b(8);
        if (aVar != null) {
            eVar.a((int) aVar.c(), (int) aVar.a(), aVar.d());
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            eVar.a((l.a) it.next());
        }
        return eVar;
    }
}
