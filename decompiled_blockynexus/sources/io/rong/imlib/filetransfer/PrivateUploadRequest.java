package io.rong.imlib.filetransfer;

import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class PrivateUploadRequest extends Request {
    private static final String Boundary = "--526f6e67436c6f7564";
    private static final String PATH = "path";
    private static final String TAG = "rc_url";
    private static final String TYPE = "type";

    public PrivateUploadRequest(Configuration configuration, RequestCallBack requestCallBack) {
        super(configuration, requestCallBack);
    }

    private String fileNameEncoding(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "fileNameEncoding ", e2);
            return str;
        }
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected boolean enableEndBoundary() {
        return true;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getBoundary() {
        return Boundary;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public long getContentLength() {
        return ((long) getFormData().length()) + new File(this.fileUri).length() + ((long) 26);
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getContentType() {
        return "multipart/form-data; boundary=--526f6e67436c6f7564";
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getFormData() {
        String str = ((((((((("--" + Boundary) + "\r\nContent-Disposition: form-data; name=\"token\"\r\n\r\n") + this.token) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"key\"\r\n\r\n") + this.fileName) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"file\"; filename=\"";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = this.fileUri;
        sb.append(fileNameEncoding(str2.substring(str2.lastIndexOf("/") + 1)));
        return ((sb.toString() + "\"\r\nContent-Type: ") + this.mimeType.getName()) + "\r\n\r\n";
    }

    @Override // io.rong.imlib.filetransfer.Request
    public FtConst.MimeType getMimeType() {
        return this.mimeType;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getUploadedUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject(TAG);
                int i = jSONObject.getInt("type");
                String string = jSONObject.getString(PATH);
                if (i == 1) {
                    return string;
                }
                return this.serverIp + string;
            } catch (Exception e2) {
                RLog.e(TAG, "getUploadedUrl error:" + str);
                RLog.e(TAG, "getUploadedUrl ", e2);
            }
        }
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected void headers(HttpURLConnection httpURLConnection) {
    }

    public PrivateUploadRequest(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) {
        super(fileInfo, configuration, requestCallBack, str);
    }
}
