package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: FileHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f6942a;

    public static void a(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        f6942a = context;
    }

    public static File b(Context context) {
        return context.getCacheDir();
    }

    public static boolean c() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState)) {
                if (!"mounted_ro".equals(externalStorageState)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return c.a().b();
        }
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static File b() {
        if (!c() || !d()) {
            return null;
        }
        File file = new File(a(), "video");
        a(file);
        return file;
    }

    @Deprecated
    public static File a() {
        return b(f6942a);
    }

    public static File a(File file, String str) {
        if (!c() || !d() || TextUtils.isEmpty(str)) {
            return null;
        }
        if (file == null) {
            file = a();
        }
        File file2 = new File(file, str);
        a(file2);
        return file2;
    }

    public static void a(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
