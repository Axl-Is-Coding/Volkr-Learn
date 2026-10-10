package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: NotificationManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1025a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<String> f1026b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1027c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f1028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NotificationManager f1029e;

    private o(Context context) {
        this.f1028d = context;
        this.f1029e = (NotificationManager) this.f1028d.getSystemService("notification");
    }

    public static o a(Context context) {
        return new o(context);
    }

    public boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return this.f1029e.areNotificationsEnabled();
        }
        if (i < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f1028d.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f1028d.getApplicationInfo();
        String packageName = this.f1028d.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
