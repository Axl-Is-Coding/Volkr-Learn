package zlc.season.rxdownload3.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.l;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.R;
import zlc.season.rxdownload3.core.Deleted;
import zlc.season.rxdownload3.core.Downloading;
import zlc.season.rxdownload3.core.Failed;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.core.Status;
import zlc.season.rxdownload3.core.Succeed;
import zlc.season.rxdownload3.core.Suspend;
import zlc.season.rxdownload3.core.Waiting;
import zlc.season.rxdownload3.extension.ApkInstallExtension;

/* JADX INFO: compiled from: NotificationFactoryImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationFactoryImpl implements NotificationFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23843a = "RxDownload";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23844b = "RxDownload";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<RealMission, l.e> f23845c = new LinkedHashMap();

    private final Notification b(l.e eVar) {
        eVar.b("下载失败");
        a(eVar);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final Notification c(l.e eVar) {
        eVar.b("安装完成");
        a(eVar);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final Notification d(l.e eVar) {
        eVar.b("安装中");
        a(eVar);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final Notification e(l.e eVar) {
        eVar.b("下载成功");
        a(eVar);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final Notification f(l.e eVar) {
        eVar.b("已暂停");
        a(eVar);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final Notification g(l.e eVar) {
        eVar.b("等待中");
        eVar.a(0, 0, true);
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    @Override // zlc.season.rxdownload3.notification.NotificationFactory
    public Notification a(Context context, RealMission realMission, Status status) {
        i.b(context, b.Q);
        i.b(realMission, "mission");
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        a(context, this.f23843a, this.f23844b);
        l.e eVarB = b(realMission, context);
        return status instanceof Suspend ? f(eVarB) : status instanceof Waiting ? g(eVarB) : status instanceof Downloading ? a(eVarB, status) : status instanceof Failed ? b(eVarB) : status instanceof Succeed ? e(eVarB) : status instanceof ApkInstallExtension.Installing ? d(eVarB) : status instanceof ApkInstallExtension.Installed ? c(eVarB) : status instanceof Deleted ? a(context, realMission) : new Notification();
    }

    private final l.e b(RealMission realMission, Context context) {
        l.e eVarA = this.f23845c.get(realMission);
        if (eVarA == null) {
            eVarA = a(realMission, context);
            this.f23845c.put(realMission, eVarA);
        }
        eVarA.c(realMission.b().b());
        i.a((Object) eVarA, "builder.setContentTitle(mission.actual.saveName)");
        return eVarA;
    }

    private final Notification a(Context context, RealMission realMission) {
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).cancel(realMission.hashCode());
            return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    private final Notification a(l.e eVar, Status status) {
        eVar.b("下载中");
        if (status.a()) {
            eVar.a(0, 0, true);
        } else {
            eVar.a((int) status.d(), (int) status.b(), false);
        }
        Notification notificationA = eVar.a();
        i.a((Object) notificationA, "builder.build()");
        return notificationA;
    }

    private final void a(l.e eVar) {
        eVar.a(0, 0, false);
    }

    private final l.e a(RealMission realMission, Context context) {
        l.e eVar = new l.e(context, this.f23843a);
        eVar.d(R.drawable.ic_download);
        eVar.c(realMission.b().b());
        i.a((Object) eVar, "Builder(context, channel…(mission.actual.saveName)");
        return eVar;
    }

    private final void a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("notification");
            if (systemService != null) {
                NotificationChannel notificationChannel = new NotificationChannel(str, str2, 2);
                notificationChannel.enableLights(true);
                notificationChannel.setShowBadge(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setLockscreenVisibility(1);
                ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }
}
