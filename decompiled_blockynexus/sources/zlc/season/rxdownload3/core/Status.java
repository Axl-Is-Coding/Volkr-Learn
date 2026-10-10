package zlc.season.rxdownload3.core;

import com.facebook.internal.AnalyticsEvents;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public class Status {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23806d;

    public Status() {
        this(0L, 0L, false, null, 15, null);
    }

    public Status(long j, long j2, boolean z, String str) {
        i.b(str, "downloadUrl");
        this.f23803a = j;
        this.f23804b = j2;
        this.f23805c = z;
        this.f23806d = str;
    }

    public final void a(long j) {
        this.f23803a = j;
    }

    public final long b() {
        return this.f23803a;
    }

    public final String c() {
        return this.f23806d;
    }

    public final long d() {
        return this.f23804b;
    }

    public /* synthetic */ Status(long j, long j2, boolean z, String str, int i, f fVar) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str);
    }

    public final boolean a() {
        return this.f23805c;
    }

    public final void b(long j) {
        this.f23804b = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Status(Status status) {
        this(status.f23803a, status.f23804b, status.f23805c, status.f23806d);
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
    }

    public final void a(String str) {
        i.b(str, "<set-?>");
        this.f23806d = str;
    }
}
