package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes5.dex */
final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final StringBuilder f19258a = new StringBuilder();

    /* JADX INFO: compiled from: Utils.java */
    @TargetApi(11)
    private static class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    @TargetApi(12)
    private static class b {
        static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    private static class c {
        static Downloader a(Context context) {
            return new v(context);
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    private static class d extends Thread {
        public d(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static class e implements ThreadFactory {
        e() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new d(runnable);
        }
    }

    static int a(Bitmap bitmap) {
        int iA = Build.VERSION.SDK_INT >= 12 ? b.a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static Downloader c(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return c.a(context);
        } catch (ClassNotFoundException unused) {
            return new N(context);
        }
    }

    static boolean d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static void a() {
        if (!b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean b(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    static String a(RunnableC2754i runnableC2754i) {
        return a(runnableC2754i, "");
    }

    static String a(RunnableC2754i runnableC2754i, String str) {
        StringBuilder sb = new StringBuilder(str);
        AbstractC2746a abstractC2746aB = runnableC2754i.b();
        if (abstractC2746aB != null) {
            sb.append(abstractC2746aB.f19275b.d());
        }
        List<AbstractC2746a> listC = runnableC2754i.c();
        if (listC != null) {
            int size = listC.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || abstractC2746aB != null) {
                    sb.append(", ");
                }
                sb.append(listC.get(i).f19275b.d());
            }
        }
        return sb.toString();
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    static String a(C c2) {
        String strA = a(c2, f19258a);
        f19258a.setLength(0);
        return strA;
    }

    static String a(C c2, StringBuilder sb) {
        String str = c2.g;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(c2.g);
        } else {
            Uri uri = c2.f19213e;
            if (uri != null) {
                String string = uri.toString();
                sb.ensureCapacity(string.length() + 50);
                sb.append(string);
            } else {
                sb.ensureCapacity(50);
                sb.append(c2.f19214f);
            }
        }
        sb.append('\n');
        if (c2.n != WheelView.DividerConfig.FILL) {
            sb.append("rotation:");
            sb.append(c2.n);
            if (c2.q) {
                sb.append('@');
                sb.append(c2.o);
                sb.append('x');
                sb.append(c2.p);
            }
            sb.append('\n');
        }
        if (c2.c()) {
            sb.append("resize:");
            sb.append(c2.i);
            sb.append('x');
            sb.append(c2.j);
            sb.append('\n');
        }
        if (c2.k) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (c2.l) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<L> list = c2.h;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(c2.h.get(i).a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split(" ", 2);
        if ("CACHE".equals(strArrSplit[0])) {
            return true;
        }
        if (strArrSplit.length == 1) {
            return false;
        }
        try {
            if ("CONDITIONAL_CACHE".equals(strArrSplit[0])) {
                return Integer.parseInt(strArrSplit[1]) == 304;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    static long a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = a.a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    static <T> T a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    static int a(Resources resources, C c2) throws FileNotFoundException {
        Uri uri;
        if (c2.f19214f == 0 && (uri = c2.f19213e) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                List<String> pathSegments = c2.f19213e.getPathSegments();
                if (pathSegments != null && !pathSegments.isEmpty()) {
                    if (pathSegments.size() == 1) {
                        try {
                            return Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Last path segment is not a resource ID: " + c2.f19213e);
                        }
                    }
                    if (pathSegments.size() == 2) {
                        return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    }
                    throw new FileNotFoundException("More than two path segments: " + c2.f19213e);
                }
                throw new FileNotFoundException("No path segments: " + c2.f19213e);
            }
            throw new FileNotFoundException("No package provided: " + c2.f19213e);
        }
        return c2.f19214f;
    }

    static Resources a(Context context, C c2) throws FileNotFoundException {
        Uri uri;
        if (c2.f19214f == 0 && (uri = c2.f19213e) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                try {
                    return context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new FileNotFoundException("Unable to obtain resources for package: " + c2.f19213e);
                }
            }
            throw new FileNotFoundException("No package provided: " + c2.f19213e);
        }
        return context.getResources();
    }

    static void a(Looper looper) {
        O o = new O(looper);
        o.sendMessageDelayed(o.obtainMessage(), 1000L);
    }
}
