package zlc.season.rxdownload3;

import io.reactivex.e;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadCore;
import zlc.season.rxdownload3.core.Mission;
import zlc.season.rxdownload3.core.Status;

/* JADX INFO: compiled from: RxDownload.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RxDownload implements RxDownloadI {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RxDownload f23659b = new RxDownload();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DownloadCore f23658a = new DownloadCore();

    private RxDownload() {
    }

    public e<Status> a(Mission mission, boolean z) {
        i.b(mission, "mission");
        return f23658a.a(mission, z);
    }

    public io.reactivex.i<Object> b(Mission mission, boolean z) {
        i.b(mission, "mission");
        return f23658a.b(mission, z);
    }

    public io.reactivex.i<Object> a(String str) {
        i.b(str, "url");
        return a(new Mission(str));
    }

    public io.reactivex.i<Object> a(Mission mission) {
        i.b(mission, "mission");
        return f23658a.a(mission);
    }

    public io.reactivex.i<Object> a(String str, boolean z) {
        i.b(str, "url");
        return b(new Mission(str), z);
    }

    public io.reactivex.i<Object> a(boolean z) {
        return f23658a.a(z);
    }
}
