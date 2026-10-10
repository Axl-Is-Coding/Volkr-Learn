package com.tencent.tp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ci;
import io.rong.common.dlog.DLog;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.zip.ZipInputStream;
import okio.Utf8;

/* JADX INFO: loaded from: classes5.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f19717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f19718b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f19719c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f19720d;

    public static String a(Context context) {
        String strSubstring;
        StringBuilder sb;
        if (!a()) {
            return "NotImp";
        }
        String str = f19717a;
        if (str != null && str.length() > 0) {
            return f19717a;
        }
        String strE = e(context);
        if (strE.toUpperCase(Locale.getDefault()).indexOf("CPUNAME") != -1) {
            return strE.substring(8);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/cpuinfo"))));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.indexOf("Processor") != -1) {
                    strSubstring = line.substring(line.indexOf(":") + 1);
                } else if (line.indexOf("vendor_id") != -1) {
                    strSubstring = line.substring(line.indexOf(":") + 1);
                } else {
                    if (line.indexOf("Hardware") != -1) {
                        int iIndexOf = line.indexOf(":");
                        sb = new StringBuilder();
                        sb.append(strE);
                        sb.append("(");
                        sb.append(line.substring(iIndexOf + 1).trim());
                        break;
                    }
                    if (line.indexOf("model name") != -1) {
                        int iIndexOf2 = line.indexOf(":");
                        sb = new StringBuilder();
                        sb.append(strE);
                        sb.append("(");
                        sb.append(line.substring(iIndexOf2 + 1).trim());
                        break;
                    }
                }
                strE = strSubstring.trim();
            }
            sb.append(")");
            strE = sb.toString();
            bufferedReader.close();
            if (strE == null || strE.length() == 0) {
                f19717a = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            f19717a = strE;
            return strE;
        } catch (Throwable unused) {
            f19717a = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    private static String a(String str) {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        try {
            Process processExec = Runtime.getRuntime().exec(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream()));
            char[] cArr = new char[4096];
            stringBuffer = new StringBuffer();
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= 0) {
                    break;
                }
                stringBuffer.append(cArr, 0, i);
            }
            bufferedReader.close();
            stringBuffer2 = new StringBuffer();
            while (true) {
                int i2 = bufferedReader2.read(cArr);
                if (i2 <= 0) {
                    break;
                }
                stringBuffer2.append(cArr, 0, i2);
            }
            bufferedReader2.close();
            processExec.waitFor();
        } catch (Throwable unused) {
        }
        if (stringBuffer.toString().trim().length() > 0) {
            return stringBuffer.toString();
        }
        if (stringBuffer2.toString().trim().length() > 0) {
            return stringBuffer2.toString();
        }
        return "";
    }

    public static boolean a() {
        if (!f19718b) {
            k();
            f19718b = true;
        }
        return f19719c;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 42);
        }
        return bArr;
    }

    public static String b() {
        try {
            return String.valueOf(Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return "null";
        }
    }

    public static String b(Context context) {
        String strE = e(context);
        if (strE.toUpperCase(Locale.getDefault()).indexOf("CPUNAME:") == -1) {
            return "REAL_DEVICE(arm)";
        }
        if (strE.toUpperCase(Locale.getDefault()).indexOf("ATOM") != -1) {
            return "REAL_DEVICE(" + strE.substring(8) + ")";
        }
        return d() + "(" + l.a().a(context) + ")";
    }

    public static int c() {
        return Integer.parseInt(b());
    }

    public static String c(Context context) {
        String strA = q.a("PIFIJRI");
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.heightPixels;
            return displayMetrics.widthPixels + q.a(au.ax) + i;
        } catch (Throwable unused) {
            return strA;
        }
    }

    public static String d() {
        if (!a()) {
            return "NotImp";
        }
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        try {
            return Build.HARDWARE;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                if (applicationInfo != null) {
                    return packageManager.getApplicationLabel(applicationInfo).toString();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String e() {
        try {
            return Build.MODEL;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String e(Context context) {
        byte[] bArrA;
        if (!a()) {
            return "NotImp";
        }
        String str = f19720d;
        if ((str == null || str.length() <= 0) && (bArrA = a(new byte[]{122, 97, 41, 46, 62, 42, 42, 42, 34, 42, 93, 101, -125, 98, -37, -91, -124, 36, -112, 44, 42, 42, -74, 62, 42, 42, 35, 42, 42, 42, 71, 83, 73, 90, 95, 67, 68, 76, 69, -57, 114, 115, -90, 97, 123, 50, 20, -35, -36, 100, 119, -90, -128, 87, 65, 2, -96, -101, -1, 56, -18, 48, 44, -97, -59, 38, 59, 97, 119, -105, 31, -7, -62, -98, -71, -36, 56, -82, 10, -97, -9, 126, 57, 104, -56, 111, 104, 70, 37, -94, 34, 8, 87, 58, 107, -121, -93, 46, -93, 10, -53, -85, 114, 120, -101, -82, 10, 59, -84, -48, -28, 72, -52, -128, 96, 82, -40, 24, 77, -40, -9, -43, -42, -43, -43, -73, -43, -42, 77, -63, -10, 89, -3, -47, -116, -90, -71, ci.l, -93, -42, 6, 28, -42, 123, 71, -83, -89, -70, 43, -70, 96, 57, 64, -113, 95, 29, 123, 99, 35, 67, 111, 112, 56, 17, -7, 65, -85, 44, 38, 32, -53, -102, 123, -111, 126, -95, 76, -82, 105, -125, -117, -44, 112, -48, -128, 54, 111, 126, 91, 88, -43, 99, 45, -6, -76, 73, 44, 38, 89, 42, -111, -38, -31, 58, -3, 55, 106, 81, 36, 127, -56, -102, -95, 20, 76, 22, 29, -34, -79, -33, 34, -45, 35, -73, 122, -2, -52, 29, 57, 84, 120, -118, -14, -81, -74, 47, 85, 84, -43, 25, 6, -37, -47, -18, 125, -19, -89, 74, 79, -75, -113, -117, 98, -75, 90, 2, -104, 22, 50, -31, 33, -66, 29, -20, -116, 106, -119, 22, -105, 71, -76, -12, -7, -120, -7, 3, 53, -69, -51, 53, -79, -115, 101, -29, -7, -51, -6, -96, 49, 74, 121, -34, 20, -99, 10, 101, 5, -115, -109, 113, 94, -56, -35, -83, 105, 97, 41, -44, 122, ci.l, 78, -118, 52, 114, -113, -45, 31, 9, -110, -96, 3, 91, 105, 33, 6, -35, 45, 0, -68, -47, -67, 67, -117, -38, 5, -84, -40, Utf8.REPLACEMENT_BYTE, 112, 102, ci.k, 127, -101, 122, -18, 114, 44, 109, 26, 60, -95, 110, 35, -116, 9, -118, -81, 107, 38, -64, -80, -117, -21, -106, 30, 52, -115, 71, 72, 44, 102, 59, -73, -118, -119, 90, -98, -10, 49, -91, -8, 112, -10, -6, 41, 23, 81, 32, -113, 120, -30, -86, -70, 80, 50, Utf8.REPLACEMENT_BYTE, -100, 85, 48, 40, 0, -6, 42, -126, 117, 74, -121, 78, 27, -19, 28, -101, 68, -33, -86, 8, -101, 20, -99, 17, -38, -100, 93, -81, 86, 10, -50, 9, 11, 53, 105, -16, 107, 86, 45, 115, 37, 107, 20, 120, -93, -86, -75, -125, 110, -22, 64, 0, -95, 82, 21, -109, -7, 32, 87, 52, 126, -125, -24, 64, -17, 82, 124, -6, -64, -31, -19, 19, -66, -87, 100, -128, -127, 126, -107, -25, -34, -52, 126, 93, 120, -41, 40, -7, 113, 121, -73, 20, 116, -76, -82, -80, -8, 23, 53, -71, 73, 23, -28, -25, 61, 38, 19, 93, 49, 112, 91, 12, 95, -68, 108, 97, -73, -63, 108, 111, -77, -45, 86, 92, -36, 62, 0, 49, 25, -71, 119, -82, ci.l, -76, -105, 41, -51, 91, 24, -37, 48, 71, -123, -89, -33, 2, -66, 73, -92, -33, 30, 101, 12, -12, -21, -88, 112, -63, 78, -56, 9, -123, -109, 120, -102, 105, 60, ci.k, 57, -75, -109, 111, 103, -45, 62, 121, -37, 78, -19, -7, -92, -27, 94, -113, 71, 77, 77, -31, 114, -38, -99, -57, 34, 107, -50, 70, 0, -53, -56, 59, 127, 78, -49, -84, 126, 120, -93, -57, 101, -5, 48, -25, -10, 22, -11, -4, 33, 24, -125, -65, 30, 21, -12, -108, 47, 65, 85, -88, -99, -43, -74, 71, -30, 99, -64, -88, 102, -8, -49, -29, 10, 87, 2, -59, -124, -45, -128, -13, -78, -32, -128, -67, -78, -35, -7, -126, 71, 66, 86, -22, -122, -115, ci.m, 87, -1, 29, 2, 79, -12, 118, 100, -48, -30, 99, 53, -71, 121, -1, ci.m, -52, 23, -39, 124, -107, 33, -118, 95, 26, -51, 3, -52, 94, -1, -98, -87, -44, 59, 22, -51, 72, -43, 8, -4, 2, 115, -116, -8, 66, -104, -94, 76, -48, 51, 71, 116, 91, -16, -20, 7, -55, -73, -116, -107, -109, 19, -105, -97, 19, -27, -65, 124, -82, -29, 71, -48, 23, -52, -34, 56, 89, 116, 5, 103, 110, -77, 17, 49, 27, 93, 77, -115, 9, -57, -89, -77, 6, -92, 75, 24, 123, -89, 80, -72, -78, -108, 77, -3, 86, 109, 66, 108, -3, 86, 109, -109, 18, 107, -17, 127, -11, 3, -50, 82, -48, 86, 21, -2, -7, 70, -48, -59, ci.l, -76, 98, -79, 69, 50, -64, 28, 19, 91, 99, 96, -106, -65, -126, 107, -84, -117, -44, 24, 57, 60, 19, -37, 124, 28, -11, 117, 86, 3, -79, -35, 21, 54, 25, -107, -78, -59, -109, -7, 4, -74, 5, ci.l, -39, 23, -2, 8, -4, 18, -49, 17, 104, ci.k, -48, -49, -35, 118, 4, 81, 59, 37, -7, -99, 85, -55, -112, -41, 94, 22, 1, -111, -115, 86, -115, -125, 101, 108, 88, -126, -40, -1, 22, -24, 61, 66, -46, 33, -108, 106, -47, -108, -49, 88, -123, 112, -2, -78, -115, 34, -39, 28, -78, -17, -126, -32, -76, ci.m, -29, -70, 97, 108, 123, 92, -58, 93, -100, 102, -53, 47, 72, 28, -101, -101, -104, 69, 74, 97, -7, 105, 94, 9, 105, 126, -31, -59, 89, 67, 110, -91, 111, 105, ci.n, 17, 93, 73, -128, 124, 102, -7, 0, -87, 105, 97, -112, -18, -111, 93, -93, 29, -46, 111, -75, 60, -113, 127, 114, 90, 98, -79, -43, -42, -9, 113, 25, -95, 98, 65, 127, -125, 119, -101, -120, 70, -71, -110, -9, 111, -27, 24, 88, 64, 108, 35, 73, 55, -28, 67, 36, -81, -98, 60, -43, 17, -74, -102, -27, -115, -36, 120, -83, -112, 115, 
        52, -9, -126, -126, 30, 75, -119, -42, 51, -22, 54, -46, 44, 35, 117, 104, -76, -60, 90, -63, 36, -97, 30, -55, 122, -126, -107, 32, 26, -54, 69, 77, -37, 17, ci.k, 88, 21, 23, 86, 17, -86, 2, -42, -58, -22, -94, 54, 36, 43, 84, -14, ci.n, 113, -47, -39, 117, 3, 124, 106, -40, -22, 94, 51, 114, 32, -43, 106, -127, 85, -10, 124, -15, 60, ci.m, 94, -97, -34, 112, 3, ci.m, -104, -75, -2, -3, 8, -36, -110, 117, -40, -12, 64, -71, 109, 91, 120, 35, 55, 61, -20, -108, 57, 54, 127, -104, 90, -20, -7, 114, -93, 8, -45, 97, -116, 126, 46, 78, 73, 51, 36, 100, ci.m, -4, -120, -125, 31, -12, -98, -16, -106, 60, -24, -107, -64, 65, 4, 29, -87, -48, 55, -64, 18, 109, -37, -114, -20, 39, 39, 79, Utf8.REPLACEMENT_BYTE, 51, -13, 92, 114, -91, -44, -76, 100, 31, -43, 89, -16, -13, -84, -121, 104, -74, -84, 94, -60, -22, -107, -95, 55, 90, 34, 88, 29, 70, -67, 11, -91, 105, 80, -102, 7, -124, 105, -64, -70, 115, -30, -33, -70, 0, 82, 94, -111, -110, 10, -91, 106, 36, -83, 86, 34, -125, 105, 92, -18, 50, -100, 107, 92, 45, -35, 38, ci.l, -125, 1, 95, -113, -124, -2, -65, -112, 120, 125, -44, 105, -29, -117, 62, -72, 28, -54, 115, 45, 84, 5, 90, 41, -121, -86, 64, -77, -107, 85, 30, 59, -110, 1, -39, -111, 120, 35, -6, 102, -10, 5, -108, -50, 88, 123, 47, -104, -81, -49, 36, 18, 107, -56, -35, 37, -115, -110, 121, 86, -68, -46, 23, 78, -123, 82, 109, -16, 7, -39, -35, -114, 26, -53, 88, -113, -70, 35, 11, -71, 104, -60, 72, -35, 22, 84, -83, 94, -93, -44, -16, 42, 67, -62, -57, -126, 4, 88, -105, 42, -105, -119, -6, -15, 33, -45, Utf8.REPLACEMENT_BYTE, 83, 99, -50, -11, 33, -89, -65, 60, -35, -4, 101, -56, 36, 89, -105, 87, -121, 85, 58, 12, 64, 54, 26, 61, 114, 108, ci.k, 71, -42, -78, 27, 105, -9, ci.m, -55, -115, -65, 95, 93, 37, -38, 36, 76, -55, -127, 5, -20, 35, 9, 3, -91, -84, 95, 93, 21, 69, -107, 84, -98, -101, 29, 116, 59, 29, 72, -84, -100, -66, 82, 91, 43, 38, -20, -128, -94, 125, 117, 55, -93, -123, -124, 78, 56, 4, -56, -121, -6, -56, Utf8.REPLACEMENT_BYTE, -18, 49, 33, -84, -125, -81, 125, -128, -24, 44, -37, -56, 68, -93, 77, ci.l, 64, 46, -105, 48, 85, -105, -34, -84, -34, 74, 46, -100, 114, -66, -9, 48, -105, -21, 32, -43, -104, 50, -12, ci.k, 65, 65, -44, 32, 55, 59, -67, -53, -96, -64, -3, 72, 27, 71, 31, -57, 31, 78, -42, -122, 125, -17, -88, -97, 0, 97, 106, -127, 38, 47, -94, -99, 22, 64, -102, 45, -59, 61, 125, 123, -56, 39, 110, 1, 1, -5, -67, -62, -107, 22, -104, -24, 97, -83, -1, 81, 79, 26, 60, 37, 111, 9, -50, 69, 97, 105, -101, -124, 24, -101, 84, -15, -46, -41, -28, -11, 102, 90, 79, -100, -67, 18, 100, -8, 23, 0, 18, -96, -14, 113, -57, -82, 103, 76, 81, -90, 73, 69, -85, 82, -73, -17, 20, -66, -13, -12, -55, 50, -17, 94, 116, 62, -85, -60, 72, -57, 78, -100, -3, 19, 96, -122, 22, -101, -99, -48, 33, -12, 66, 92, 108, 18, -10, -88, 125, -27, -24, 49, ci.l, 88, -102, -7, 87, 64, -55, -78, 75, -29, -27, 3, -110, -23, 6, -106, 0, 49, -19, 52, -13, -32, -55, -113, -2, 24, 85, -128, -73, -119, -97, ci.m, -76, 8, 78, -77, -81, -51, -100, 89, 94, 1, 26, 5, -95, 6, -106, 35, 92, -92, 103, -8, -59, -37, -32, 65, 82, -4, 69, 104, -107, -39, 124, 42, -89, -13, -80, -94, 69, 21, 36, -50, 114, -86, -99, 59, 90, 34, 116, -80, -76, -99, 21, -38, 120, 72, -58, 28, 91, 4, 5, -42, -85, -99, 125, -26, -73, 103, -74, -1, -63, -66, ci.k, 107, -27, 113, -99, -23, -68, 69, 52, -99, 17, 42, 98, -100, 83, -85, 82, 109, 7, -106, 77, 55, 42, -38, 118, 47, 82, -115, 115, 118, -5, -91, -79, ci.k, -127, 62, -54, -113, 111, -106, -108, -68, 47, 95, 112, -3, 105, -54, -120, -14, 21, 31, 30, 77, -85, 84, 65, 88, -127, 7, -105, -22, 81, 122, 74, 87, 85, 42, 122, 97, 43, 40, 21, 42, 62, 42, 42, 42, 34, 42, 93, 101, -125, 98, -37, -91, -124, 36, -112, 44, 42, 42, -74, 62, 42, 42, 35, 42, ci.l, 42, 42, 42, 42, 42, 42, 42, 10, 42, 42, 42, 42, 42, 42, 42, 71, 83, 73, 90, 95, 67, 68, 76, 69, 32, 42, 10, 42, 42, 42, 42, 42, 43, 42, 50, 42, -28, 84, -36, 94, -68, -125, -5, 43, -13, 119, -33, 94, -68, -125, -5, 43, 20, 118, -65, -86, -11, -113, -5, 43, 122, 97, 47, 44, 42, 42, 42, 42, 43, 42, 43, 42, 113, 42, 42, 42, -53, 44, 42, 42, 42, 42})) != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrA);
            ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
            while (zipInputStream.getNextEntry() != null) {
                try {
                    byte[] bArr = new byte[DLog.CRS];
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(context.getFilesDir().getAbsolutePath() + "/mycpuinfo"));
                    while (true) {
                        int i = zipInputStream.read(bArr, 0, DLog.CRS);
                        if (i != -1) {
                            bufferedOutputStream.write(bArr, 0, i);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (Throwable unused) {
                }
            }
            zipInputStream.close();
            byteArrayInputStream.close();
            a("chmod 755 " + context.getFilesDir().getAbsolutePath() + "/mycpuinfo\n");
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            sb.append("/mycpuinfo\n");
            String strA = a(sb.toString());
            f19720d = strA.trim();
            return strA.trim();
        }
        return f19720d;
    }

    public static String f() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(e());
        stringBuffer.append(";Android ");
        stringBuffer.append(h());
        stringBuffer.append(",level ");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }

    public static String h() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "null";
        }
    }

    public static String i() {
        if (!a()) {
            return "NotImp";
        }
        try {
            return Build.HARDWARE;
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    public static String j() {
        if (!a()) {
            return "NotImp";
        }
        try {
            return i() + "(" + l() + ")";
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void k() {
        String strD = r.d(new String(a(new byte[]{99, 89, 111, 68, 75, 72, 70, 79, 78, 117, 27, ci.n, 75, 70, 70, 69, 93, 117, 66, 93})));
        if (strD != null) {
            f19719c = Integer.parseInt(strD) != 0;
        }
    }

    private static String l() {
        if (!a()) {
            return "NotImp";
        }
        return Build.CPU_ABI + "|" + Build.CPU_ABI2;
    }
}
