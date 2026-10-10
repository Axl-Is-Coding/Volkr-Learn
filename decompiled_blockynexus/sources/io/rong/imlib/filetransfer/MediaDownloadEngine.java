package io.rong.imlib.filetransfer;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import io.rong.common.FileUtils;
import io.rong.imlib.NativeClient;
import io.rong.imlib.filetransfer.upload.AbstractMediaFileService;
import io.rong.imlib.model.FileInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class MediaDownloadEngine extends AbstractMediaFileService {
    private static final String TAG = "MediaDownloadEngine";
    private Map<String, Boolean> downloadMap;
    private Context mContext;

    private static class SingletonHolder {
        private static final MediaDownloadEngine INSTANCE = new MediaDownloadEngine();

        private SingletonHolder() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkSupportResumeTransfer(java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2e
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2e
            java.net.URLConnection r5 = r2.openConnection()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2e
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2e
            java.lang.String r1 = "GET"
            r5.setRequestMethod(r1)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3d
            java.lang.String r1 = "Range"
            java.lang.String r2 = "bytes=0-1"
            r5.setRequestProperty(r1, r2)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3d
            int r1 = r5.getResponseCode()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3d
            r2 = 206(0xce, float:2.89E-43)
            if (r1 == r2) goto L22
            goto L23
        L22:
            r0 = 1
        L23:
            if (r5 == 0) goto L3c
        L25:
            r5.disconnect()
            goto L3c
        L29:
            r1 = move-exception
            goto L32
        L2b:
            r0 = move-exception
            r5 = r1
            goto L3e
        L2e:
            r5 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L32:
            java.lang.String r2 = io.rong.imlib.filetransfer.MediaDownloadEngine.TAG     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = "checkSupportResumeTransfer"
            io.rong.common.RLog.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L3d
            if (r5 == 0) goto L3c
            goto L25
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            if (r5 == 0) goto L43
            r5.disconnect()
        L43:
            goto L45
        L44:
            throw r0
        L45:
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.filetransfer.MediaDownloadEngine.checkSupportResumeTransfer(java.lang.String):boolean");
    }

    public static MediaDownloadEngine getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addToFileDownloadMap(int i, boolean z) {
        this.downloadMap.put(FileUtils.getTempFileMD5(this.mContext, i), Boolean.valueOf(z));
    }

    public void cancelAll() {
        dispatcher().cancelAll();
        Map<String, Boolean> map = this.downloadMap;
        if (map != null) {
            map.clear();
        }
    }

    public void download(int i, String str, long j, RequestOption requestOption) {
        FileInfo fileInfo = new FileInfo("", str);
        fileInfo.setFileName(requestOption.getFileName());
        fileInfo.setStop(false);
        fileInfo.setMessageId(requestOption.getMessageId());
        DownloadRequest downloadRequest = new DownloadRequest(fileInfo, getConfiguration(), requestOption.getRequestCallBack(), FileUtils.getTempFilePath(this.mContext, i));
        downloadRequest.mimeType = requestOption.getMimeType();
        downloadRequest.method = "GET";
        downloadRequest.serverIp = str;
        downloadRequest.tag = Integer.valueOf(i);
        downloadRequest.fileName = requestOption.getFileName();
        downloadRequest.fileLength = j;
        downloadRequest.isMessage = true;
        downloadRequest.requestCallBack = requestOption.getRequestCallBack();
        Call.create(dispatcher(), downloadRequest).enqueue();
    }

    public int getDownloadEachSliceLength() {
        Context context = this.mContext;
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getInteger(resources.getIdentifier("rc_resume_file_transfer_size_each_slice", "integer", this.mContext.getPackageName()));
    }

    public boolean getDownloadingFromMap(Context context, int i) {
        String tempFileMD5 = FileUtils.getTempFileMD5(context, i);
        Map<String, Boolean> map = this.downloadMap;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.downloadMap.get(tempFileMD5).booleanValue();
    }

    public void pause(int i, PauseCallback pauseCallback) {
        if (i > 0) {
            dispatcher().pause(Integer.valueOf(i), pauseCallback);
        }
    }

    public void removeFromFileDownloadMap(int i) {
        String tempFileMD5 = FileUtils.getTempFileMD5(this.mContext, i);
        Map<String, Boolean> map = this.downloadMap;
        if (map != null) {
            map.remove(tempFileMD5);
        }
    }

    private MediaDownloadEngine() {
        this.mContext = NativeClient.getApplicationContext();
        this.downloadMap = new HashMap();
    }

    public void pause(String str, PauseCallback pauseCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        dispatcher().pause(str, pauseCallback);
    }

    public void addToFileDownloadMap(String str, boolean z) {
        this.downloadMap.put(FileUtils.getTempFileMD5(this.mContext, str), Boolean.valueOf(z));
    }

    public boolean getDownloadingFromMap(Context context, String str) {
        String tempFileMD5 = FileUtils.getTempFileMD5(context, str);
        Map<String, Boolean> map = this.downloadMap;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.downloadMap.get(tempFileMD5).booleanValue();
    }

    public void removeFromFileDownloadMap(String str) {
        String tempFileMD5 = FileUtils.getTempFileMD5(this.mContext, str);
        Map<String, Boolean> map = this.downloadMap;
        if (map != null) {
            map.remove(tempFileMD5);
        }
    }

    public void download(String str, String str2, RequestOption requestOption) {
        FileInfo fileInfo = new FileInfo("", str2);
        fileInfo.setFileName(requestOption.getFileName());
        fileInfo.setStop(false);
        fileInfo.setMessageId(requestOption.getMessageId());
        DownloadRequest downloadRequest = new DownloadRequest(fileInfo, getConfiguration(), requestOption.getRequestCallBack(), FileUtils.getTempFilePath(this.mContext, str));
        downloadRequest.mimeType = requestOption.getMimeType();
        downloadRequest.method = "GET";
        downloadRequest.serverIp = str2;
        downloadRequest.tag = str;
        downloadRequest.fileName = requestOption.getFileName();
        downloadRequest.requestCallBack = requestOption.getRequestCallBack();
        downloadRequest.isMessage = false;
        Call.create(dispatcher(), downloadRequest).enqueue();
    }
}
