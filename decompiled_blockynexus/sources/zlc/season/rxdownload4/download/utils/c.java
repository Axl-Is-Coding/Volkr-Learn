package zlc.season.rxdownload4.download.utils;

import android.util.Log;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: LogUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f23930a = true;

    public static /* synthetic */ Object a(Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = "";
        }
        a(obj, str);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(T t, String str) {
        i.b(str, "prefix");
        if (f23930a) {
            if (t instanceof Throwable) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                Throwable th = (Throwable) t;
                sb.append(th.getMessage());
                Log.w("RxDownload", sb.toString(), th);
            } else {
                Log.d("RxDownload", str + String.valueOf(t));
            }
        }
        return t;
    }
}
