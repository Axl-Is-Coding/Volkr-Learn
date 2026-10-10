package c.t.m.g;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, ThreadLocal<SimpleDateFormat>> f3019a = new HashMap<>();

    public static synchronized SimpleDateFormat a(String str) {
        SimpleDateFormat simpleDateFormat;
        ThreadLocal<SimpleDateFormat> threadLocal = f3019a.get(str);
        if (threadLocal == null) {
            threadLocal = new ThreadLocal<>();
            f3019a.put(str, threadLocal);
        }
        simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
            threadLocal.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }
}
