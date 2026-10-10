package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.TencentLocationListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20047a = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20048b = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20049c = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f20050d = 3600000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f20051e = Pattern.compile("([0-9]+)");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f20052f = Pattern.compile("\\s*([0-9]+)");
    private static final FileFilter g = new FileFilter() { // from class: com.tendcloud.tenddata.p.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                try {
                    String name = file.getName();
                    if (name != null && name.startsWith(com.umeng.analytics.pro.au.v)) {
                        for (int i = 3; i < name.length(); i++) {
                            if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                                return false;
                            }
                        }
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    };
    private static BroadcastReceiver h = new BroadcastReceiver() { // from class: com.tendcloud.tenddata.p.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    };

    public static class a {
        static final int HCE_ENABLED = 3;
        static final int NFC_ENABLED = 2;
        static final int NOT_ENALBED = 1;
        static final int UNKNOWN = 0;
    }

    public static String a() {
        return ab.j + Build.VERSION.RELEASE;
    }

    public static String b() {
        try {
            return Build.ID;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c() {
        return Build.MANUFACTURER.trim();
    }

    public static String d() {
        return Build.BRAND.trim();
    }

    public static String e() {
        return Build.MODEL.trim();
    }

    public static int f() {
        return TimeZone.getDefault().getRawOffset() / f20050d;
    }

    public static String g() {
        try {
            String strTrim = Build.MODEL.trim();
            String strA = a(Build.MANUFACTURER.trim(), strTrim);
            if (TextUtils.isEmpty(strA)) {
                strA = a(Build.BRAND.trim(), strTrim);
            }
            StringBuilder sb = new StringBuilder();
            if (strA == null) {
                strA = "";
            }
            sb.append(strA);
            sb.append(":");
            sb.append(strTrim);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h() {
        try {
            return af.a(14) ? Build.getRadioVersion() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static int i() {
        return Build.VERSION.SDK_INT;
    }

    public static String j() {
        return Build.VERSION.RELEASE;
    }

    public static String k() {
        return Locale.getDefault().getLanguage();
    }

    public static String l() {
        return Locale.getDefault().getCountry();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[Catch: Throwable -> 0x009e, TryCatch #2 {Throwable -> 0x009e, blocks: (B:6:0x0013, B:15:0x003c, B:23:0x0054, B:25:0x0065, B:27:0x006c, B:29:0x0075, B:31:0x0085, B:32:0x008f, B:33:0x0092, B:34:0x0095, B:18:0x0045, B:19:0x004b, B:20:0x004c, B:8:0x0022, B:10:0x0028, B:13:0x0034, B:14:0x003b), top: B:42:0x0013, inners: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] m() {
        /*
            r0 = 4
            java.lang.String[] r1 = new java.lang.String[r0]
            r2 = 0
            r3 = 0
        L5:
            if (r3 >= r0) goto Le
            java.lang.String r4 = ""
            r1[r3] = r4
            int r3 = r3 + 1
            goto L5
        Le:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9e
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L9e
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9e
            r5 = 1024(0x400, float:1.435E-42)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L9e
        L21:
            r5 = 1
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
            if (r6 == 0) goto L3c
            r0.add(r6)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
            int r6 = r0.size()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
            r7 = 104857600(0x6400000, float:3.6111186E-35)
            if (r6 > r7) goto L34
            goto L21
        L34:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
            java.lang.String r7 = "List size more than 104857600 limit"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
            throw r6     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4c
        L3c:
            r4.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L9e
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L9e
        L42:
            r3 = 1
            goto L53
        L44:
            r0 = move-exception
            r4.close()     // Catch: java.io.IOException -> L4b java.lang.Throwable -> L9e
            r3.close()     // Catch: java.io.IOException -> L4b java.lang.Throwable -> L9e
        L4b:
            throw r0     // Catch: java.lang.Throwable -> L9e
        L4c:
            r4.close()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L9e
            r3.close()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L9e
        L52:
            r3 = 0
        L53:
            r4 = 3
            java.lang.String[] r6 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = "Processor\\s*:\\s*(.*)"
            r6[r2] = r7     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = "CPU\\s*variant\\s*:\\s*0x(.*)"
            r6[r5] = r7     // Catch: java.lang.Throwable -> L9e
            r7 = 2
            java.lang.String r8 = "Hardware\\s*:\\s*(.*)"
            r6[r7] = r8     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L95
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L9e
            r7 = 0
        L6a:
            if (r7 >= r4) goto L95
            r8 = r6[r7]     // Catch: java.lang.Throwable -> L9e
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)     // Catch: java.lang.Throwable -> L9e
            r9 = 0
        L73:
            if (r9 >= r3) goto L92
            java.lang.Object r10 = r0.get(r9)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L9e
            java.util.regex.Matcher r10 = r8.matcher(r10)     // Catch: java.lang.Throwable -> L9e
            boolean r11 = r10.find()     // Catch: java.lang.Throwable -> L9e
            if (r11 == 0) goto L8f
            java.util.regex.MatchResult r10 = r10.toMatchResult()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r10 = r10.group(r5)     // Catch: java.lang.Throwable -> L9e
            r1[r7] = r10     // Catch: java.lang.Throwable -> L9e
        L8f:
            int r9 = r9 + 1
            goto L73
        L92:
            int r7 = r7 + 1
            goto L6a
        L95:
            java.lang.String r0 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            java.lang.String r0 = c(r0)     // Catch: java.lang.Throwable -> L9e
            r1[r4] = r0     // Catch: java.lang.Throwable -> L9e
            goto La2
        L9e:
            r0 = move-exception
            com.tendcloud.tenddata.bp.postSDKError(r0)
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.p.m():java.lang.String[]");
    }

    public static JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", m()[2]);
            jSONObject.put("coreNum", o());
            jSONObject.put("maxFreq", a(f20047a));
            jSONObject.put("minFreq", a(f20048b));
            jSONObject.put("curFreq", a(f20049c));
            return jSONObject;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static int o() {
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(g);
            if (fileArrListFiles != null) {
                return fileArrListFiles.length;
            }
            return 1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int p(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return -1;
                }
                context = ab.g;
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return -1;
    }

    public static String[] p() {
        return null;
    }

    public static int[] q() {
        int[] iArr = {0, 0};
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                int availableBlocks = statFs.getAvailableBlocks();
                iArr[0] = (blockCount * (blockSize / 512)) / 2;
                iArr[1] = (availableBlocks * (blockSize / 512)) / 2;
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public static int[] r() {
        int[] iArr = {0, 0};
        int[] iArr2 = new int[4];
        for (int i = 0; i < 4; i++) {
            iArr2[i] = 0;
        }
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line.length() > 104857600) {
                            throw new RuntimeException("Input stream more than 100 MB size limit");
                        }
                        iArr2[i2] = b(line);
                    } catch (IOException unused) {
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                            fileReader.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            }
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1] + iArr2[2] + iArr2[3];
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th2) {
            bp.postSDKError(th2);
        }
        return iArr;
    }

    private static JSONArray s(Context context) {
        ServiceInfo[] serviceInfoArr;
        Bundle bundle;
        if (!af.a(59)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<PackageInfo> listA = a(context, 4);
            if (listA == null) {
                return jSONArray;
            }
            for (PackageInfo packageInfo : listA) {
                if (packageInfo != null && (serviceInfoArr = packageInfo.services) != null) {
                    int length = serviceInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            try {
                                bundle = context.getPackageManager().getServiceInfo(new ComponentName(serviceInfo.packageName, serviceInfo.name), 128).metaData;
                            } catch (Throwable unused) {
                            }
                            if (bundle != null && bundle.containsKey("android.nfc.cardemulation.host_apdu_service")) {
                                jSONArray.put(packageInfo.packageName);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static int t(Context context) {
        NfcAdapter defaultAdapter;
        try {
            if (!af.a(59) || (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) == null) {
                return -1;
            }
            return CardEmulation.getInstance(defaultAdapter).getSelectionModeForCategory("payment");
        } catch (Throwable th) {
            bp.postSDKError(th);
            return -1;
        }
    }

    public static boolean a(Context context) {
        try {
            if (af.a(17)) {
                return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nfcStatus", c(context));
            jSONObject.put("appsRegistedHCE", s(context));
            jSONObject.put("ssMode", t(context));
            return jSONObject;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static int c(Context context) {
        NfcAdapter defaultAdapter;
        if (context == null) {
            return 0;
        }
        try {
            if (!af.a(10) || (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) == null) {
                return 0;
            }
            if (!defaultAdapter.isEnabled()) {
                return 1;
            }
            if (af.a(59)) {
                if (context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) {
                    return 3;
                }
            }
            return 2;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return 0;
        }
    }

    public static String d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return "";
            }
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            return Math.min(i, i2) + "*" + Math.max(i, i2) + "*" + displayMetrics.densityDpi;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int e(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return 0;
                }
                context = ab.g;
            } catch (Throwable th) {
                bp.postSDKError(th);
                return 0;
            }
        }
        Intent intentRegisterReceiver = context.registerReceiver(h, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = intentRegisterReceiver != null ? intentRegisterReceiver.getExtras().getInt(FirebaseAnalytics.Param.LEVEL, 0) : 0;
        context.unregisterReceiver(h);
        return i;
    }

    public static int f(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return 0;
                }
                context = ab.g;
            } catch (Throwable th) {
                bp.postSDKError(th);
                return 0;
            }
        }
        Intent intentRegisterReceiver = context.registerReceiver(h, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0) : 0;
        context.unregisterReceiver(h);
        return intExtra;
    }

    public static boolean i(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.location.gps");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.wifi");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.bluetooth");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.nfc");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.usb.host");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int o(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return -1;
                }
                context = ab.g;
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return -1;
    }

    private static List<PackageInfo> a(Context context, int i) throws Throwable {
        Process processExec;
        BufferedReader bufferedReader;
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getInstalledPackages(i);
        } catch (Throwable unused) {
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    processExec = Runtime.getRuntime().exec("pm list packages");
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                } catch (Throwable th) {
                    th = th;
                }
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(packageManager.getPackageInfo(line.substring(line.indexOf(58) + 1), i));
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th;
                    }
                    return arrayList;
                }
                processExec.waitFor();
                bufferedReader.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static JSONObject g(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mobile", n(context));
            jSONObject.put(TencentLocationListener.WIFI, j(context));
            jSONObject.put("gps", i(context));
            jSONObject.put("telephone", m(context));
            jSONObject.put("nfc", l(context));
            jSONObject.put("bluetooth", k(context));
            jSONObject.put("otg", h(context));
            return jSONObject;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("brightness", r(context));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int t() {
        try {
            Matcher matcher = f20052f.matcher(c("/sys/class/power_supply/battery/full_bat"));
            if (matcher.find()) {
                return Integer.parseInt(matcher.toMatchResult().group(0));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int b(String str) {
        try {
            Matcher matcher = f20051e.matcher(str);
            return Integer.parseInt(matcher.find() ? matcher.toMatchResult().group(0) : "");
        } catch (Exception e2) {
            bp.postSDKError(e2);
            return 0;
        }
    }

    private static String c(String str) {
        FileReader fileReader;
        char[] cArr;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileReader = new FileReader(str);
            cArr = new char[1024];
            bufferedReader = new BufferedReader(fileReader, 1024);
        } catch (Throwable unused) {
        }
        while (true) {
            int i = bufferedReader.read(cArr, 0, 1024);
            if (-1 == i) {
                break;
            }
            stringBuffer.append(new String(cArr, 0, i));
            return stringBuffer.toString();
        }
        bufferedReader.close();
        fileReader.close();
        return stringBuffer.toString();
    }

    public static boolean n(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int q(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return -1;
                }
                context = ab.g;
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return -1;
    }

    public static int[] s() {
        try {
            int[] iArr = new int[4];
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                iArr[0] = (statFs.getBlockCount() * (statFs.getBlockSize() / 512)) / 2;
                iArr[1] = (statFs.getAvailableBlocks() * (statFs.getBlockSize() / 512)) / 2;
            } catch (Throwable unused) {
            }
            try {
                StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                iArr[2] = (statFs2.getBlockCount() * (statFs2.getBlockSize() / 512)) / 2;
                iArr[3] = (statFs2.getAvailableBlocks() * (statFs2.getBlockSize() / 512)) / 2;
            } catch (Throwable unused2) {
            }
            return iArr;
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static String a(String str, String str2) {
        try {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("unknown") && !lowerCase.startsWith("alps") && !lowerCase.startsWith("android") && !lowerCase.startsWith("sprd") && !lowerCase.startsWith("spreadtrum") && !lowerCase.startsWith("rockchip") && !lowerCase.startsWith("wondermedia") && !lowerCase.startsWith("mtk") && !lowerCase.startsWith("mt65") && !lowerCase.startsWith("nvidia") && !lowerCase.startsWith("brcm") && !lowerCase.startsWith("marvell")) {
                if (!str2.toLowerCase().contains(lowerCase)) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int r(Context context) {
        if (context == null && (context = ab.g) == null) {
            return -1;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                jSONObject.put("pixel", Math.min(i, i2) + "*" + Math.max(i, i2) + "*" + displayMetrics.densityDpi);
                jSONObject.put("densityDpi", displayMetrics.densityDpi);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int a(String str) throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        String line;
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable unused) {
            bufferedReader = null;
            fileReader = null;
        }
        try {
            line = bufferedReader.readLine();
        } catch (Throwable unused2) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable unused3) {
                }
            }
            if (bufferedReader != null) {
            }
            return i;
        }
        if (line.length() <= 104857600) {
            i = Integer.parseInt(line.trim());
            try {
                fileReader.close();
            } catch (Throwable unused4) {
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused5) {
            }
            return i;
        }
        throw new RuntimeException("Input stream more than 100 MB size limit");
    }

    public static boolean m(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getPhoneType() != 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
