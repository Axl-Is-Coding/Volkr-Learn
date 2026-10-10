package zlc.season.rxdownload3.core;

import com.facebook.internal.AnalyticsEvents;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Failed extends Status {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Throwable f23674e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Failed(Status status, Throwable th) {
        super(status);
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        i.b(th, "throwable");
        this.f23674e = th;
    }

    public final Throwable e() {
        return this.f23674e;
    }
}
