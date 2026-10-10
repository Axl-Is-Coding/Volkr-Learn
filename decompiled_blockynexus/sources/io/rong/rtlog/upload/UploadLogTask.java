package io.rong.rtlog.upload;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UploadLogTask {
    private static final String BOUNDARY = "03297e90-eed0-4cec-b18b-92d2574b9331";
    private static final String TAG = "UploadLogTask";
    protected static final String URL_ENCODE_CHARSET = "utf-8";

    protected String encodeParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, URL_ENCODE_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    protected abstract String getUploadUrl();

    protected abstract void onUploadResponse(String str);

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(5:141|3|139|4|5)|(6:147|6|145|7|143|8)|(4:9|(1:11)(1:149)|42|90)|12|(4:13|(1:15)(1:150)|42|90)|16|(3:18|(1:20)|21)|(1:23)|129|24|(2:121|29)|135|33|37|(2:41|42)|90|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
    
        io.rong.common.rlog.RLog.e(io.rong.rtlog.upload.UploadLogTask.TAG, "outStream", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
    
        io.rong.common.rlog.RLog.e(io.rong.rtlog.upload.UploadLogTask.TAG, "fileInputStream", r15);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean upload(java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.rtlog.upload.UploadLogTask.upload(java.lang.String):boolean");
    }
}
