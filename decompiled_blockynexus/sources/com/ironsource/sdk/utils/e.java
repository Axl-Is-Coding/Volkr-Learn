package com.ironsource.sdk.utils;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceStorageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static void a(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                a(file.getAbsolutePath());
                file.delete();
            } else {
                file.delete();
            }
        }
    }

    public static String b(Context context) {
        c(context);
        return d(context);
    }

    private static String c(Context context) {
        File fileA = a(context, "supersonicads");
        if (!fileA.exists()) {
            fileA.mkdir();
        }
        return fileA.getPath();
    }

    private static String d(Context context) {
        String strB = d.a(context).b();
        String strG = a.g();
        if (strB.equalsIgnoreCase(strG)) {
            return a(context, "supersonicads").getPath();
        }
        d.d().d(strG);
        File fileG = com.ironsource.environment.b.g(context);
        if (fileG != null) {
            a(fileG.getAbsolutePath() + File.separator + "supersonicads" + File.separator);
        }
        a(com.ironsource.environment.b.i(context) + File.separator + "supersonicads" + File.separator);
        return c(context);
    }

    public static boolean e(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    private static JSONObject f(String str, String str2) {
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    Object objB = b(file2);
                    if (objB instanceof JSONArray) {
                        jSONObject.put("files", b(file2));
                    } else if (objB instanceof JSONObject) {
                        jSONObject.put(file2.getName(), b(file2));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    new b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
                }
            }
        }
        return jSONObject;
    }

    public static String b(String str, String str2) {
        JSONObject jSONObjectF = f(str, str2);
        try {
            jSONObjectF.put("path", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObjectF.toString();
    }

    public static boolean c(String str, String str2) {
        return new File(str, str2).exists();
    }

    private static Object b(File file) {
        String strA;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
            new b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
        }
        if (file.isFile()) {
            jSONArray.put(file.getName());
            return jSONArray;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                jSONObject.put(file2.getName(), b(file2));
            } else {
                jSONArray.put(file2.getName());
                jSONObject.put("files", jSONArray);
            }
        }
        if (file.isDirectory() && (strA = d.d().a(file.getName())) != null) {
            jSONObject.put("lastUpdateTime", strA);
        }
        return jSONObject;
    }

    private static File a(Context context, String str) {
        return new File(a(context) + File.separator + str);
    }

    public static String a(Context context) {
        if (i.j()) {
            File fileG = com.ironsource.environment.b.g(context);
            if (fileG != null && fileG.canWrite()) {
                return fileG.getPath();
            }
            return com.ironsource.environment.b.i(context);
        }
        return com.ironsource.environment.b.i(context);
    }

    public static String d(String str, String str2) {
        File file = new File(str, str2);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static synchronized boolean a(String str, String str2, String str3) {
        File file = new File(str, str2);
        if (!file.exists()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile() && file2.getName().equalsIgnoreCase(str3)) {
                return file2.delete();
            }
        }
        return false;
    }

    public static synchronized boolean a(String str, com.ironsource.sdk.data.e eVar) {
        File file = new File(str, eVar.e());
        if (file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile() && file2.getName().equalsIgnoreCase(i.c(eVar.c()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a(java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.Class<com.ironsource.sdk.utils.e> r0 = com.ironsource.sdk.utils.e.class
            monitor-enter(r0)
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L19
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L19
            boolean r2 = a(r1)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L16
            boolean r2 = r1.delete()     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L16
            r2 = 1
            goto L17
        L16:
            r2 = 0
        L17:
            monitor-exit(r0)
            return r2
        L19:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.utils.e.a(java.lang.String, java.lang.String):boolean");
    }

    private static boolean a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        boolean zA = true;
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                zA &= a(file2);
            }
            if (!file2.delete()) {
                zA = false;
            }
        }
        return zA;
    }

    public static int a(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i = 0;
            while (true) {
                int i2 = byteArrayInputStream.read(bArr2);
                if (i2 == -1) {
                    return i;
                }
                fileOutputStream.write(bArr2, 0, i2);
                i += i2;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }
}
