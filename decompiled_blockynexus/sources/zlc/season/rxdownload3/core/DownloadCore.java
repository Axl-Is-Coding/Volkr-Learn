package zlc.season.rxdownload3.core;

import io.reactivex.b.g;
import io.reactivex.e;
import io.reactivex.e.a;
import io.reactivex.i;
import java.io.InterruptedIOException;
import java.net.SocketException;
import zlc.season.rxdownload3.helper.LoggerKt;

/* JADX INFO: compiled from: DownloadCore.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DownloadCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MissionBox f23667a = DownloadConfig.r.l();

    public DownloadCore() {
        a();
    }

    private final void a() {
        a.a(new g<Throwable>() { // from class: zlc.season.rxdownload3.core.DownloadCore$initRxJavaPlugin$1
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Throwable th) {
                if (th instanceof InterruptedException) {
                    LoggerKt.a("InterruptedException", th);
                } else if (th instanceof InterruptedIOException) {
                    LoggerKt.a("InterruptedIOException", th);
                } else if (th instanceof SocketException) {
                    LoggerKt.a("SocketException", th);
                }
            }
        });
    }

    public final i<Object> b(Mission mission, boolean z) {
        kotlin.jvm.internal.i.b(mission, "mission");
        return this.f23667a.a(mission, z);
    }

    public final e<Status> a(Mission mission, boolean z) {
        kotlin.jvm.internal.i.b(mission, "mission");
        return this.f23667a.b(mission, z);
    }

    public final i<Object> a(boolean z) {
        return this.f23667a.a(z);
    }

    public final i<Object> a(Mission mission) {
        kotlin.jvm.internal.i.b(mission, "mission");
        return this.f23667a.a(mission);
    }
}
