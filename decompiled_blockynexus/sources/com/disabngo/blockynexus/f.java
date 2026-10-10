package com.disabngo.blockynexus;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.disabngo.blockynexus.d.D;
import com.google.android.gms.measurement.AppMeasurement;
import com.sandboxol.center.router.manager.AppManager;
import com.sandboxol.common.utils.DateUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.rlog.RLogConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f10414a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f10417d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f10415b = Thread.getDefaultUncaughtExceptionHandler();

    private f(Context context) {
        this.f10416c = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static f a(Context context) {
        if (f10414a == null) {
            f10414a = new f(context);
        }
        return f10414a;
    }

    private void b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                this.f10417d.put("VersionName", packageInfo.versionName);
                this.f10417d.put("VersionCode", String.valueOf(packageInfo.versionCode));
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        for (Field field : Build.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                this.f10417d.put(field.getName(), field.get(null).toString());
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException)) {
            return;
        }
        if ((th instanceof RuntimeException) && th.getMessage() != null && th.getMessage().contains(".so")) {
            D.a(this.f10416c);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            AppManager.clearActivityStack();
        }
        b(this.f10416c);
        a(this.f10416c, th);
        a(this.f10416c, 5);
        this.f10415b.uncaughtException(thread, th);
    }

    private String a(Context context, Throwable th) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f10417d.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append("=");
            sb.append((Object) entry.getValue());
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        sb.append(stringWriter.toString());
        String str = DateUtils.timeStamp2Date(System.currentTimeMillis(), null) + RLogConfig.LOG_SUFFIX;
        File file = new File(context.getExternalFilesDir(""), AppMeasurement.CRASH_ORIGIN);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getPath(), str));
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.close();
            return str;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void a(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        File file = new File(context.getExternalFilesDir(""), AppMeasurement.CRASH_ORIGIN);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles.length > i) {
                arrayList.addAll(Arrays.asList(fileArrListFiles));
                Collections.sort(arrayList, new Comparator() { // from class: com.disabngo.blockynexus.c
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return f.a((File) obj, (File) obj2);
                    }
                });
                while (arrayList.size() > i) {
                    ((File) arrayList.get(0)).delete();
                    arrayList.remove(0);
                }
            }
        }
    }

    static /* synthetic */ int a(File file, File file2) {
        if (file.lastModified() < file2.lastModified()) {
            return -1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : 1;
    }
}
