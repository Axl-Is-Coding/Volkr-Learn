package io.rong.imlib.filetransfer;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tendcloud.tenddata.cp;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.common.NetUtils;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Request extends AbstractRequest {
    private static final String TAG = "Request";
    private static final int TIMEOUT = 120000;
    private HttpURLConnection conn;
    public int connTimeout;
    public String date;
    public long fileLength;
    public String fileName;
    public String fileUri;
    public int finished = 0;
    public FileInfo info;
    public boolean isMessage;
    public OnProgressListener listener;
    public Context mContext;
    public int messageId;
    public String method;
    public FtConst.MimeType mimeType;
    public String ossAccessKeyId;
    public String pausedPath;
    public String policy;
    public int readTimeout;
    public RequestCallBack requestCallBack;
    public String serverIp;
    public String signature;
    public Object tag;
    public boolean terminated;
    public String token;

    public Request(Configuration configuration, RequestCallBack requestCallBack) {
        this.connTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
        this.requestCallBack = requestCallBack;
    }

    private void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                RLog.e(TAG, "closeInputStream", e2);
            }
        }
    }

    private void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                RLog.e(TAG, "closeOutputStream", e2);
            }
        }
    }

    private void downloadComplete() {
        this.info.setDownLoading(false);
        this.requestCallBack.onComplete(this.info.getFileName());
        FileUtils.removeFile(this.pausedPath);
        if (this.isMessage) {
            MediaDownloadEngine.getInstance().removeFromFileDownloadMap(this.info.getMessageId());
        } else {
            MediaDownloadEngine.getInstance().removeFromFileDownloadMap(this.tag.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void downloadInMultiSlice(long r24, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.filetransfer.Request.downloadInMultiSlice(long, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x021e -> B:96:0x0224). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void downloadInOnceSlice(long r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.filetransfer.Request.downloadInOnceSlice(long):void");
    }

    private FileInfo getFileInfoFromJsonString(String str) {
        FileInfo fileInfo = new FileInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            fileInfo.setFileName(jSONObject.optString("filename"));
            fileInfo.setUrl(jSONObject.optString("url"));
            fileInfo.setLength(jSONObject.optLong(cp.a.LENGTH));
            fileInfo.setFinished(jSONObject.optLong("finish"));
            fileInfo.setStop(jSONObject.optBoolean("isStop", false));
            fileInfo.setDownLoading(jSONObject.optBoolean("isDownLoading", false));
        } catch (JSONException e2) {
            RLog.e(TAG, "getFileInfoFromJsonString", e2);
        }
        return fileInfo;
    }

    private void getLength() {
        long j = this.fileLength;
        if (j > 0) {
            this.info.setLength(j);
            return;
        }
        HttpURLConnection httpURLConnectionCreateURLConnection = null;
        try {
            try {
                try {
                    httpURLConnectionCreateURLConnection = NetUtils.createURLConnection(this.info.getUrl());
                    httpURLConnectionCreateURLConnection.setRequestMethod("GET");
                    httpURLConnectionCreateURLConnection.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    long j2 = httpURLConnectionCreateURLConnection.getResponseCode() == 200 ? Long.parseLong(httpURLConnectionCreateURLConnection.getHeaderField("Content-Length")) : -1L;
                    if (j2 <= 0) {
                        RLog.e(TAG, "file length from server is 0. Return directly!");
                    }
                    this.info.setLength(j2);
                    if (httpURLConnectionCreateURLConnection != null) {
                        httpURLConnectionCreateURLConnection.disconnect();
                    }
                } catch (Exception e2) {
                    RLog.e(TAG, "getLength", e2);
                }
            } catch (Exception e3) {
                RLog.e(TAG, "getLength", e3);
                if (httpURLConnectionCreateURLConnection != null) {
                    httpURLConnectionCreateURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            if (httpURLConnectionCreateURLConnection != null) {
                try {
                    httpURLConnectionCreateURLConnection.disconnect();
                } catch (Exception e4) {
                    RLog.e(TAG, "getLength", e4);
                }
            }
            throw th;
        }
    }

    private String getSaveJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filename", this.info.getFileName());
            jSONObject.put("url", this.info.getUrl());
            jSONObject.put(cp.a.LENGTH, this.info.getLength());
            jSONObject.put("finish", this.info.getFinished());
            jSONObject.put("isStop", this.info.isStop());
            jSONObject.put("isDownLoading", this.info.isDownLoading());
        } catch (JSONException e2) {
            RLog.e(TAG, "getSaveJsonString", e2);
        }
        return jSONObject.toString();
    }

    private void sendRequestNotSupportResumeTransfer() throws Exception {
        this.conn = NetUtils.createURLConnection(this.serverIp);
        this.conn.setConnectTimeout(120000);
        this.conn.setUseCaches(false);
        this.conn.setRequestMethod(this.method);
        this.conn.setDoInput(true);
        this.conn.connect();
        int responseCode = this.conn.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            this.requestCallBack.onError(30002);
            RLog.d("fileTransfer", "download request response code is " + responseCode);
            FwLog.write(2, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "responseCode", Integer.valueOf(responseCode));
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.conn.getInputStream());
        int contentLength = this.conn.getContentLength();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.fileName));
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = bufferedInputStream.read(bArr);
            if (i4 == -1) {
                fileOutputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                fileOutputStream.close();
                this.requestCallBack.onComplete(this.fileName);
                return;
            }
            byteArrayOutputStream.write(bArr, 0, i4);
            i += i4;
            i2 += i4;
            int i5 = (int) ((((long) i) * 100) / ((long) contentLength));
            if (i3 < i5) {
                this.requestCallBack.onProgress(i5);
                i3 = i5;
            }
            if (Thread.currentThread().isInterrupted()) {
                RLog.w(TAG, "sendRequest terminated.");
                this.terminated = true;
                this.requestCallBack.onCanceled(this.tag);
                throw new InterruptedIOException();
            }
            if (i2 > 1048576) {
                fileOutputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                byteArrayOutputStream.reset();
                i2 = 0;
            }
        }
    }

    private void sendRequestSupportResumeTransfer() throws Exception {
        getLength();
        int downloadEachSliceLength = MediaDownloadEngine.getInstance().getDownloadEachSliceLength();
        long finished = this.info.getFinished();
        if (finished == this.info.getLength()) {
            downloadComplete();
        } else if ((((long) downloadEachSliceLength) + finished) - 1 > this.info.getLength()) {
            downloadInOnceSlice(finished);
        } else {
            downloadInMultiSlice(finished, downloadEachSliceLength);
        }
    }

    private void setFileInfo(FileInfo fileInfo) throws Throwable {
        try {
            this.info = fileInfo;
            String stringFromFile = FileUtils.getStringFromFile(this.pausedPath);
            FileInfo fileInfoFromJsonString = TextUtils.isEmpty(stringFromFile) ? null : getFileInfoFromJsonString(stringFromFile);
            if (fileInfoFromJsonString != null) {
                this.info.setFinished(fileInfoFromJsonString.getFinished());
                this.info.setDownLoading(fileInfoFromJsonString.isDownLoading());
                this.info.setLength(fileInfoFromJsonString.getLength());
                this.info.setFileName(fileInfoFromJsonString.getFileName());
                this.info.setUrl(fileInfoFromJsonString.getUrl());
            }
        } catch (Exception e2) {
            RLog.e(TAG, "setFileInfo", e2);
        }
    }

    protected abstract boolean enableEndBoundary();

    public abstract String getBoundary();

    public abstract long getContentLength();

    public abstract String getContentType();

    public abstract String getFormData();

    public abstract FtConst.MimeType getMimeType();

    public abstract String getUploadedUrl(String str);

    protected abstract void headers(HttpURLConnection httpURLConnection);

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0178, code lost:
    
        r13 = r8;
        r13.writeBytes(r0);
        r18.requestCallBack.onProgress(100);
        r13.flush();
        r0 = r18.conn.getResponseCode();
        r8 = new java.io.BufferedInputStream(r18.conn.getInputStream());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0197, code lost:
    
        r6 = new java.io.ByteArrayOutputStream(1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x019e, code lost:
    
        r7 = r8.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01a2, code lost:
    
        if (r7 == (-1)) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01a4, code lost:
    
        r6.write(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01aa, code lost:
    
        if (r0 < 200) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01ae, code lost:
    
        if (r0 < 300) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01b1, code lost:
    
        r18.requestCallBack.onComplete(getUploadedUrl(r6.toString()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01c0, code lost:
    
        r18.requestCallBack.onError(r0);
        io.rong.common.fwlog.FwLog.write(2, 1, io.rong.common.fwlog.FwLog.LogTag.L_MEDIA_S.getTag(), "responseCode", java.lang.Integer.valueOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01df, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01e0, code lost:
    
        r6 = r0;
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01e3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01e4, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x02ea: MOVE (r8 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:139:0x02e9 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x02e9: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:139:0x02e9 */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0276 A[Catch: all -> 0x02e8, TryCatch #4 {all -> 0x02e8, blocks: (B:108:0x0272, B:110:0x0276, B:112:0x0295, B:113:0x02a2, B:36:0x019e, B:38:0x01a4, B:44:0x01b1, B:45:0x01c0), top: B:167:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0315 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0308 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendRequest() {
        /*
            Method dump skipped, instruction units count: 813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.filetransfer.Request.sendRequest():void");
    }

    public void sendRequestForNoneMessage() {
        boolean zCheckSupportResumeTransfer;
        try {
            if (!this.method.equals("GET")) {
                return;
            }
            zCheckSupportResumeTransfer = MediaDownloadEngine.checkSupportResumeTransfer(this.serverIp);
            try {
                if (zCheckSupportResumeTransfer) {
                    sendRequestSupportResumeTransfer();
                } else {
                    sendRequestNotSupportResumeTransfer();
                }
                return;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            zCheckSupportResumeTransfer = false;
        }
        if (!this.terminated) {
            this.requestCallBack.onError(30002);
            FwLog.write(2, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "stacks", FwLog.stackToString(e));
            if (zCheckSupportResumeTransfer) {
                MediaDownloadEngine.getInstance().addToFileDownloadMap(this.serverIp, false);
            }
        }
        RLog.e(TAG, "sendRequestForNoneMessage", e);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setFileUri(String str) {
        this.fileUri = str;
    }

    public Request(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) throws Throwable {
        this.pausedPath = str;
        setFileInfo(fileInfo);
        this.connTimeout = configuration.getConnectTimeout();
        this.readTimeout = configuration.getReadTimeout();
        this.requestCallBack = requestCallBack;
    }
}
