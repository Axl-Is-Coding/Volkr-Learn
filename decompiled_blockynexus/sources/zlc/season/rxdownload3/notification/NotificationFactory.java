package zlc.season.rxdownload3.notification;

import android.app.Notification;
import android.content.Context;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.core.Status;

/* JADX INFO: compiled from: NotificationFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface NotificationFactory {
    Notification a(Context context, RealMission realMission, Status status);
}
