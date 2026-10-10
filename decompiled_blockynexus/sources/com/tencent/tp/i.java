package com.tencent.tp;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class i {
    public static String a(Context context) {
        String strB = b(context, q.a("ohk"));
        if (strB != null) {
            return b(strB);
        }
        return null;
    }

    public static String a(Context context, String str) throws IOException {
        return new File(context.getFilesDir(), str).getAbsolutePath();
    }

    public static void a(String str, String str2) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            file2.delete();
        }
        file.renameTo(file2);
    }

    public static boolean a(String str) throws IOException {
        return new File(str).exists();
    }

    public static boolean a(String str, int i) throws IOException {
        if (i < 1) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() == ((long) i);
    }

    public static String b(Context context, String str) {
        try {
            return a(context, str);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String b(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        return iLastIndexOf > -1 ? str.substring(0, iLastIndexOf) : str;
    }

    public static boolean b(Context context) {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String c(Context context) throws IOException {
        if (b(context)) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    public static String c(Context context, String str) throws IOException {
        if (!b(context)) {
            return a(context, str);
        }
        return Environment.getExternalStorageDirectory().getPath() + "/" + str;
    }

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        return iLastIndexOf > -1 ? str.substring(iLastIndexOf + 1, str.length()) : str;
    }

    public static String d(Context context) throws IOException {
        if (!b(context)) {
            return null;
        }
        String path = context.getExternalFilesDir(null).getPath();
        return path.substring(0, path.lastIndexOf(47));
    }

    public static void d(String str) throws IOException {
        i(b(str));
    }

    public static void e(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void f(String str) {
        try {
            e(str);
        } catch (IOException unused) {
        }
    }

    public static String[] g(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                arrayList.add(file.getName());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static long h(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private static void i(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
