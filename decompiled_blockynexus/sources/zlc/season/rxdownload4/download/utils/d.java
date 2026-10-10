package zlc.season.rxdownload4.download.utils;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    public static final void a(io.reactivex.disposables.b bVar) {
        if (bVar == null || bVar.isDisposed()) {
            return;
        }
        bVar.dispose();
    }

    public static final long a(String str, long j) {
        i.b(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final long a() {
        File dataDirectory = Environment.getDataDirectory();
        i.a((Object) dataDirectory, "Environment.getDataDirectory()");
        StatFs statFs = new StatFs(dataDirectory.getAbsolutePath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
