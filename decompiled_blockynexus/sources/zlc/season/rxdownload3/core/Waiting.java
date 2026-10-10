package zlc.season.rxdownload3.core;

import com.facebook.internal.AnalyticsEvents;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Waiting extends Status {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Waiting(Status status) {
        super(status);
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }
}
