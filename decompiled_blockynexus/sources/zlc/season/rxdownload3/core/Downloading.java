package zlc.season.rxdownload3.core;

import com.facebook.internal.AnalyticsEvents;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Downloading extends Status {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Downloading(Status status) {
        super(status);
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }
}
