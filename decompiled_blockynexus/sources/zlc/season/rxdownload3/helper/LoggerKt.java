package zlc.season.rxdownload3.helper;

import android.util.Log;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.core.DownloadConfig;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class LoggerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23834a = "RxDownload";

    public static final void a(String str, Throwable th) {
        i.b(str, "message");
        if (DownloadConfig.r.c()) {
            Log.e(f23834a, str, th);
        }
    }

    public static final void a(String str) {
        i.b(str, "message");
        if (DownloadConfig.r.c()) {
            Log.d(f23834a, str);
        }
    }
}
