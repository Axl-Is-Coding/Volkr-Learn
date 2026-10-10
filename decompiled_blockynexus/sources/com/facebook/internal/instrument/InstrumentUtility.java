package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InstrumentUtility {
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    private static final String FBSDK_PREFIX = "com.facebook";
    private static final String INSTRUMENT_DIR = "instrument";

    public static boolean deleteFile(String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    public static String getCause(Throwable th) {
        if (th == null) {
            return null;
        }
        return th.getCause() == null ? th.toString() : th.getCause().toString();
    }

    public static File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static String getStackTrace(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (true) {
            Throwable th3 = th2;
            th2 = th;
            if (th2 == null || th2 == th3) {
                break;
            }
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th = th2.getCause();
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSDKRelatedException(java.lang.Throwable r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 0
        L5:
            r6 = r1
            r1 = r7
            r7 = r6
            if (r1 == 0) goto L2c
            if (r1 == r7) goto L2c
            java.lang.StackTraceElement[] r7 = r1.getStackTrace()
            int r2 = r7.length
            r3 = 0
        L12:
            if (r3 >= r2) goto L27
            r4 = r7[r3]
            java.lang.String r4 = r4.getClassName()
            java.lang.String r5 = "com.facebook"
            boolean r4 = r4.startsWith(r5)
            if (r4 == 0) goto L24
            r7 = 1
            return r7
        L24:
            int r3 = r3 + 1
            goto L12
        L27:
            java.lang.Throwable r7 = r1.getCause()
            goto L5
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.instrument.InstrumentUtility.isSDKRelatedException(java.lang.Throwable):boolean");
    }

    public static File[] listCrashReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.matches(String.format("^%s[0-9]+.json$", InstrumentUtility.CRASH_REPORT_PREFIX));
            }
        });
        return fileArrListFiles != null ? fileArrListFiles : new File[0];
    }

    public static JSONObject readFile(String str, boolean z) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
            } catch (Exception unused) {
                if (z) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    public static void sendReports(String str, JSONArray jSONArray, GraphRequest.Callback callback) {
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            GraphRequest.newPostRequest(null, String.format("%s/instruments", FacebookSdk.getApplicationId()), jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    public static void writeFile(String str, String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
