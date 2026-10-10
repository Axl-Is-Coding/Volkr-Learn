package io.rong.common.dlog;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import io.grpc.internal.GrpcUtil;
import io.rong.common.dlog.DLog;
import io.rong.common.rlog.RLogConfig;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.common.RongLibConst;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class LogReporter {
    private static final String BOUNDARY = "03297e90-eed0-4cec-b18b-92d2574b9331";
    LogThreadPool logThreadPool;

    public LogReporter(LogThreadPool logThreadPool) {
        this.logThreadPool = logThreadPool;
        checkAndReportCrashLog();
        clearExpiredLogFile();
    }

    private void checkAndReportCrashLog() {
        if (LogEntity.getInstance().getLogMode() == 1) {
            return;
        }
        this.logThreadPool.getExecutorService().submit(new Runnable() { // from class: io.rong.common.dlog.LogReporter.2
            @Override // java.lang.Runnable
            public void run() {
                for (File file : new File(LogEntity.getInstance().getLogDir()).listFiles(new FilenameFilter() { // from class: io.rong.common.dlog.LogReporter.2.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        return str.endsWith(LogEntity.CrashLogFileName);
                    }
                })) {
                    if (file.length() != 0) {
                        long jLastModified = file.lastModified();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        String str = jLastModified + "_" + jCurrentTimeMillis + RLogConfig.ZIP_SUFFIX;
                        String str2 = LogEntity.getInstance().getLogDir() + File.separator + str;
                        if (LogZipper.gzipFile(file.getAbsolutePath(), str2)) {
                            if (LogReporter.this.uploadFile(str2, jLastModified + "", jCurrentTimeMillis + "", LogEntity.getInstance().getSdkVer(), LogEntity.getInstance().getAppKey(), LogEntity.getInstance().getUserId(), LogEntity.getInstance().getToken(), true)) {
                                LogReporter.this.clearInfoForFile(LogEntity.getInstance().getLogDir() + File.separator + LogEntity.CrashLogFileName);
                            } else {
                                LogReporter.this.deleteCrashZipFile(str);
                            }
                        } else {
                            LogReporter.this.deleteCrashZipFile(str);
                        }
                    }
                }
            }
        });
    }

    private void clearExpiredLogFile() {
        try {
            for (File file : new File(LogEntity.getInstance().getLogDir()).listFiles(new FilenameFilter() { // from class: io.rong.common.dlog.LogReporter.4
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return str.endsWith(RLogConfig.ZIP_SUFFIX);
                }
            })) {
                String name = file.getName();
                if (name.contains("_")) {
                    String strSubstring = name.substring(0, name.indexOf("_"));
                    String strSubstring2 = name.substring(name.indexOf("_") + 1, name.indexOf(Consts.DOT));
                    if (System.currentTimeMillis() - Long.parseLong(strSubstring2) > LogEntity.getInstance().getOutDateTime()) {
                        file.delete();
                        DLog.write(2, 512, DLog.LogTag.G_DROP_LOG_E.getTag(), "start|end|size", strSubstring, strSubstring2, Long.valueOf(file.length()));
                    }
                } else {
                    file.delete();
                }
            }
        } catch (Exception e2) {
            DLog.write(1, 512, DLog.LogTag.G_CRASH_E.getTag(), "stacks", DLog.stackToString(e2));
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInfoForFile(String str) {
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCrashZipFile(String str) {
        File file = new File(LogEntity.getInstance().getLogDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(21:0|2|(3:100|3|4)|(4:104|5|(1:7)|8)|(5:106|9|10|102|11)|(10:12|(1:14)(1:108)|94|60|(1:62)|(2:92|64)|(1:66)|(1:68)|69|70)|15|91|16|(2:17|(1:19)(1:109))|20|(4:22|89|23|24)(1:27)|(1:29)|98|30|(1:32)|33|(1:35)|69|70|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0148, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x014c, code lost:
    
        r5 = r9;
        r9 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a3 A[Catch: IOException -> 0x01ab, TryCatch #5 {IOException -> 0x01ab, blocks: (B:64:0x019e, B:66:0x01a3, B:68:0x01a8), top: B:92:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a8 A[Catch: IOException -> 0x01ab, TRY_LEAVE, TryCatch #5 {IOException -> 0x01ab, blocks: (B:64:0x019e, B:66:0x01a3, B:68:0x01a8), top: B:92:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c0 A[Catch: IOException -> 0x01c8, TryCatch #10 {IOException -> 0x01c8, blocks: (B:76:0x01bb, B:78:0x01c0, B:80:0x01c5), top: B:96:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c5 A[Catch: IOException -> 0x01c8, TRY_LEAVE, TryCatch #10 {IOException -> 0x01c8, blocks: (B:76:0x01bb, B:78:0x01c0, B:80:0x01c5), top: B:96:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean uploadFile(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.dlog.LogReporter.uploadFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uploadString(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int responseCode;
        HttpURLConnection httpURLConnectionCreateURLConnection = null;
        try {
            try {
                httpURLConnectionCreateURLConnection = NetUtils.createURLConnection(LogEntity.getInstance().getOnlineLogServer());
                httpURLConnectionCreateURLConnection.setConnectTimeout(5000);
                httpURLConnectionCreateURLConnection.setReadTimeout(5000);
                httpURLConnectionCreateURLConnection.setDoOutput(true);
                httpURLConnectionCreateURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-App-Key", str5);
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-User-ID", str6);
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-SDK-Version", str4);
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-Platform", "Android");
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-Start-Time", String.valueOf(str2));
                httpURLConnectionCreateURLConnection.setRequestProperty("RC-End-Time", String.valueOf(str3));
                httpURLConnectionCreateURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnectionCreateURLConnection.setRequestProperty(AbstractSpiCall.HEADER_ACCEPT, AbstractSpiCall.ACCEPT_JSON_VALUE);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionCreateURLConnection.getOutputStream());
                dataOutputStream.writeBytes(str);
                responseCode = httpURLConnectionCreateURLConnection.getResponseCode();
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                if (httpURLConnectionCreateURLConnection == null) {
                    return false;
                }
            }
            if (responseCode == 200) {
                if (httpURLConnectionCreateURLConnection != null) {
                    httpURLConnectionCreateURLConnection.disconnect();
                }
                return true;
            }
            if (httpURLConnectionCreateURLConnection == null) {
                return false;
            }
            httpURLConnectionCreateURLConnection.disconnect();
            return false;
        } catch (Throwable th) {
            if (httpURLConnectionCreateURLConnection != null) {
                httpURLConnectionCreateURLConnection.disconnect();
            }
            throw th;
        }
    }

    public void reportFileLog(final DLog.ILogUploadCallback iLogUploadCallback) {
        int i;
        final boolean[] zArr = {false};
        try {
            JSONArray uploadCacheList = LogEntity.getInstance().getUploadCacheList();
            int i2 = 0;
            while (i2 < uploadCacheList.length()) {
                JSONObject jSONObject = uploadCacheList.getJSONObject(i2);
                final String string = jSONObject.getString("filename");
                final String string2 = jSONObject.getString("sdkVer");
                final String string3 = jSONObject.getString("appKey");
                final String string4 = jSONObject.getString("userId");
                final String string5 = jSONObject.getString(RongLibConst.KEY_TOKEN);
                final int i3 = i2;
                int i4 = i2;
                this.logThreadPool.getExecutorService().submit(new Runnable() { // from class: io.rong.common.dlog.LogReporter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        File file = new File(LogEntity.getInstance().getLogDir(), string);
                        if (!file.exists() || file.length() == 0) {
                            if (file.exists()) {
                                file.delete();
                                return;
                            }
                            return;
                        }
                        String str = string;
                        String strSubstring = str.substring(0, str.indexOf("_"));
                        String str2 = string;
                        String strSubstring2 = str2.substring(str2.indexOf("_") + 1, string.indexOf(Consts.DOT));
                        if (System.currentTimeMillis() - Long.parseLong(strSubstring2) > LogEntity.getInstance().getOutDateTime()) {
                            DLog.write(2, 512, DLog.LogTag.G_DROP_LOG_E.getTag(), "start|end|size", strSubstring, strSubstring2, Long.valueOf(file.length()));
                            file.delete();
                        } else {
                            if (LogReporter.this.uploadFile(file.getAbsolutePath(), strSubstring, strSubstring2, string2, string3, string4, string5, false)) {
                                LogEntity.getInstance().deleteUploadCacheList(i3);
                                return;
                            }
                            DLog.ILogUploadCallback iLogUploadCallback2 = iLogUploadCallback;
                            if (iLogUploadCallback2 == null || zArr[0]) {
                                return;
                            }
                            iLogUploadCallback2.onLogUploaded(-1);
                            zArr[0] = true;
                            Log.i("FwLog", "log upload failed.");
                        }
                    }
                });
                i2 = i4 + 1;
            }
        } catch (JSONException e2) {
            Log.e("FwLog", "ignored = " + e2);
            if (iLogUploadCallback != null) {
                i = 0;
                if (!zArr[0]) {
                    iLogUploadCallback.onLogUploaded(-1);
                    zArr[0] = true;
                    Log.i("FwLog", "log upload exception.");
                }
            }
            if (iLogUploadCallback != null) {
                return;
            } else {
                return;
            }
        }
        i = 0;
        if (iLogUploadCallback != null || zArr[i]) {
            return;
        }
        iLogUploadCallback.onLogUploaded(i);
        Log.i("FwLog", "log upload success.");
    }

    public void reportLruLog(Vector<String> vector, final String str, final String str2) {
        final Vector vector2 = new Vector(vector);
        this.logThreadPool.getExecutorService().submit(new Runnable() { // from class: io.rong.common.dlog.LogReporter.3
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray = new JSONArray();
                int size = vector2.size();
                for (int i = 0; i < size; i++) {
                    try {
                        jSONArray.put(new JSONObject((String) vector2.get(i)));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (size > 0) {
                    LogReporter.this.uploadString(jSONArray.toString(), str, str2, LogEntity.getInstance().getSdkVer(), LogEntity.getInstance().getAppKey(), LogEntity.getInstance().getUserId(), LogEntity.getInstance().getToken());
                }
            }
        });
    }
}
