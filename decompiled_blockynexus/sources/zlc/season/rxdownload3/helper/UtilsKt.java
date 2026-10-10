package zlc.season.rxdownload3.helper;

import android.content.Context;
import io.reactivex.disposables.b;
import java.io.File;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f23835a = new Object();

    public static final Object a() {
        return f23835a;
    }

    public static final void a(b bVar) {
        if (bVar == null || bVar.isDisposed()) {
            return;
        }
        bVar.dispose();
    }

    public static final String a(Context context, File file) {
        i.b(context, com.umeng.analytics.pro.b.Q);
        i.b(file, "apkFile");
        String str = context.getPackageManager().getPackageArchiveInfo(file.getPath(), 128).packageName;
        i.a((Object) str, "apkInfo.packageName");
        return str;
    }
}
