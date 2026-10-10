package com.tendcloud.tenddata;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f20041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f20042b = "pref.deviceid.key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20045e = ".tcookieid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f20043c = Pattern.compile("[0-4][0-9a-f]{24,32}");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f20044d = Pattern.compile("[0-4][0-9a-f]{32}");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f20046f = null;

    public static synchronized String a(Context context) {
        if (f20041a == null) {
            f20041a = d(context);
        }
        return f20041a;
    }

    static String b(Context context) {
        try {
            String strB = w.b(context, "tdid", f20042b, (String) null);
            return af.b(strB) ? PreferenceManager.getDefaultSharedPreferences(context).getString(f20042b, null) : strB;
        } catch (Throwable unused) {
            return "";
        }
    }

    static String c(Context context) {
        if (f20046f == null) {
            try {
                Sensor[] sensorArr = new Sensor[64];
                for (Sensor sensor : ((SensorManager) context.getSystemService(com.umeng.analytics.pro.au.ab)).getSensorList(-1)) {
                    if (sensor.getType() < sensorArr.length && sensor.getType() >= 0) {
                        sensorArr[sensor.getType()] = sensor;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < sensorArr.length; i++) {
                    if (sensorArr[i] != null) {
                        stringBuffer.append(i);
                        stringBuffer.append('.');
                        stringBuffer.append(sensorArr[i].getVendor());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i].getName());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i].getVersion());
                        stringBuffer.append('\n');
                    }
                }
                f20046f = String.valueOf(stringBuffer.toString().hashCode());
            } catch (Throwable unused) {
            }
        }
        return f20046f;
    }

    private static String d(Context context) throws Throwable {
        String str;
        String strF;
        String strB = b(context);
        String strA = a();
        boolean zB = b();
        String strA2 = a(context, zB);
        String[] strArr = {strB, strA, strA2};
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (!af.b(str) && f20044d.matcher(str).matches()) {
                break;
            }
            i++;
        }
        if (!af.b(str) || af.b(strB) || Math.random() >= 0.99d) {
            strF = str;
        } else {
            int length2 = strArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                strF = strArr[i2];
                if (!af.b(strF) && f20043c.matcher(strF).matches()) {
                    break;
                }
            }
            strF = str;
        }
        if (af.b(strF)) {
            strF = af.a(29) ? f(context) : e(context);
        }
        if (!strF.equals(strB)) {
            b(context, strF);
        }
        if (!strF.equals(strA2)) {
            a(context, strF, zB);
        }
        if (!strF.equals(strA)) {
            a(context, strF);
        }
        return strF;
    }

    private static String e(Context context) {
        return "3" + af.c(g(context));
    }

    private static String f(Context context) {
        String strD = q.d(context);
        if (af.b(strD)) {
            strD = q.e(context);
        }
        if (af.b(strD)) {
            strD = UUID.randomUUID().toString();
        }
        return VipSubscribeStatus.SUBSCRIPTION_PURCHASED + af.c(3 + strD);
    }

    private static String g(Context context) {
        try {
            return q.a("imei") + '-' + q.d(context) + '-' + q.a("androidId");
        } catch (Throwable unused) {
            return "";
        }
    }

    static String a(Context context, boolean z) throws Throwable {
        if (af.a(23) && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return "";
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = f20045e;
        if (!z) {
            str = f20045e + c(context);
        }
        String strA = a(new File(externalStorageDirectory, str));
        if (!af.b(strA)) {
            return strA;
        }
        return a(new File(Environment.getExternalStorageDirectory(), ".tid" + c(context)));
    }

    private static void b(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tdid", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(f20042b, str);
                editorEdit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    static boolean b() {
        return !(af.a(9) ? Environment.isExternalStorageRemovable() : true);
    }

    static String a() {
        try {
            File[] fileArrListFiles = new File("/").listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                String strA = null;
                for (File file : fileArrListFiles) {
                    try {
                        if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                            if (file.canWrite()) {
                                strA = a(new File(file, f20045e));
                                if (!af.b(strA)) {
                                    return strA;
                                }
                            }
                            if (file.listFiles() != null) {
                                String strA2 = strA;
                                for (File file2 : file.listFiles()) {
                                    try {
                                        if (file2.isDirectory()) {
                                            strA2 = a(new File(file2, f20045e));
                                            if (!af.b(strA2)) {
                                                return strA2;
                                            }
                                        }
                                    } catch (Throwable unused) {
                                        return strA2;
                                    }
                                }
                                strA = strA2;
                            } else {
                                continue;
                            }
                        }
                    } catch (Throwable unused2) {
                        return strA;
                    }
                }
                return strA;
            }
            return null;
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (file.exists() && file.canRead()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[128];
                            String str = new String(bArr, 0, fileInputStream.read(bArr));
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused) {
                            }
                            return str;
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable unused3) {
                        fileInputStream = null;
                    }
                } else {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
            } catch (Throwable unused4) {
            }
            return null;
        } catch (Throwable th) {
            th = th;
        }
    }

    private static void a(Context context, String str, boolean z) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String str2 = f20045e;
            if (!z) {
                str2 = f20045e + c(context);
            }
            a(new File(externalStorageDirectory, str2), str);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str) {
        try {
            File[] fileArrListFiles = new File("/").listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file : fileArrListFiles) {
                    if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                        if (file.canWrite()) {
                            if (!new File(file, f20045e + c(context)).exists()) {
                                a(new File(file, f20045e), str);
                            }
                        }
                        if (file.listFiles() != null) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isDirectory() && file2.canWrite()) {
                                    if (!new File(file2, f20045e + c(context)).exists()) {
                                        a(new File(file2, f20045e), str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.canWrite()) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(str.getBytes());
                        if (af.a(9)) {
                            file.getClass().getMethod("setReadable", Boolean.TYPE, Boolean.TYPE).invoke(file, true, false);
                        } else {
                            Runtime.getRuntime().exec("chmod 444 " + file.getAbsolutePath());
                        }
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable unused) {
                        if (fileOutputStream == null) {
                            return;
                        } else {
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (Throwable unused2) {
                return;
            }
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
    }
}
