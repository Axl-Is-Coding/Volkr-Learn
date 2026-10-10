package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.Locale;

/* JADX INFO: compiled from: IdUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f6240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f6241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f6242f;
    private static boolean g;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f6237a) && !g) {
            synchronized (j.class) {
                if (!g) {
                    g(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(f6237a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                f6237a = d.a(f(context)).b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return f6237a;
    }

    public static String b(Context context) {
        if (f6240d == null && !g) {
            synchronized (j.class) {
                if (!g) {
                    g(context);
                }
            }
        }
        return f6240d;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f6238b) && !g) {
            synchronized (j.class) {
                if (!g) {
                    g(context);
                }
            }
        }
        return f6238b;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f6241e) && !g) {
            synchronized (j.class) {
                if (!g) {
                    g(context);
                }
            }
        }
        return f6241e;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(f6242f) && !g) {
            synchronized (j.class) {
                if (!g) {
                    g(context);
                }
            }
        }
        return f6242f;
    }

    private static Context f(Context context) {
        return context == null ? o.a() : context;
    }

    @SuppressLint({"HardwareIds"})
    private static void g(Context context) {
        Context contextF;
        if (g || (contextF = f(context)) == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                f6242f = Build.getSerial();
            } else {
                f6242f = Build.SERIAL;
            }
        } catch (Exception unused) {
        }
        f6238b = a(contextF, true);
        f6237a = d.a(contextF).b("did", (String) null);
        f6239c = b();
        f6240d = String.valueOf(Build.TIME);
        f6241e = d.a(contextF).b("uuid", (String) null);
        g = true;
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.utils.u.e()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.utils.u.b()) {
                sb.append("FLYME-");
            } else {
                String strN = com.bytedance.sdk.openadsdk.utils.u.n();
                if (com.bytedance.sdk.openadsdk.utils.u.a(strN)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strN)) {
                    sb.append(strN);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(f6237a)) {
            return;
        }
        d.a(context).a("did", str);
        f6237a = str;
    }

    @SuppressLint({"TrulyRandom", "HardwareIds"})
    private static synchronized String a(Context context, boolean z) {
        String string;
        String strA;
        Context contextF = f(context);
        if (contextF == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(contextF.getContentResolver(), "android_id");
        } catch (Exception unused) {
            string = null;
        }
        if (string != null) {
            try {
                if (string.equals("9774d56d682e549c") || string.length() < 13) {
                }
            } catch (Exception unused2) {
            }
            return string;
        }
        d dVarA = d.a(contextF);
        String strB = dVarA.b("openudid", (String) null);
        if (a(strB)) {
            string = strB;
        } else {
            String string2 = new BigInteger(64, new SecureRandom()).toString(16);
            if (string2.charAt(0) == '-') {
                string2 = string2.substring(1);
            }
            int length = 13 - string2.length();
            if (length > 0) {
                StringBuilder sb = new StringBuilder();
                while (length > 0) {
                    sb.append('F');
                    length--;
                }
                sb.append(string2);
                string2 = sb.toString();
            }
            if (z) {
                strA = a("openudid.dat", string2);
                if (a(strA)) {
                }
                dVarA.a("openudid", strA);
                string = strA;
            }
            strA = string2;
            dVarA.a("openudid", strA);
            string = strA;
        }
        return string;
    }

    private static String a(String str, String str2) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        int i;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLockLock = null;
        try {
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                return str2;
            }
            File file2 = new File(str4);
            randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                if (file2.isFile() && (i = randomAccessFile.read((bArr = new byte[129]), 0, 129)) > 0 && i < 129) {
                    String str5 = new String(bArr, 0, i, "UTF-8");
                    if (a(str5)) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused2) {
                        }
                        return str5;
                    }
                }
                byte[] bytes = str2.getBytes("UTF-8");
                randomAccessFile.setLength(0L);
                randomAccessFile.write(bytes);
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception unused3) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Exception unused4) {
                }
                return str2;
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception unused6) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (Exception unused7) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception unused8) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        if (fileLockLock != null) {
            try {
                fileLockLock.release();
            } catch (Exception unused9) {
            }
        }
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception unused10) {
            }
        }
        return str2;
    }

    private static boolean a(String str) {
        int length;
        if (str == null || (length = str.length()) < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static String a() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String string = locale.toString();
            if (locale.toString().length() >= 5) {
                string = string.substring(0, 5);
            }
            return Locale.SIMPLIFIED_CHINESE.toString().equals(string) ? "zh" : "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
