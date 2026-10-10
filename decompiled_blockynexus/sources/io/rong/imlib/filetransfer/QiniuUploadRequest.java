package io.rong.imlib.filetransfer;

import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.io.File;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class QiniuUploadRequest extends Request {
    private static final String Boundary = "--526f6e67436c6f7564";

    public QiniuUploadRequest(Configuration configuration, RequestCallBack requestCallBack) {
        super(configuration, requestCallBack);
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
        return ((((((((((((("--" + Boundary) + "\r\nContent-Disposition: form-data; name=\"token\"\r\n\r\n") + this.token) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"key\"\r\n\r\n") + this.fileName) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"file\"; filename=\"") + this.fileName) + "\"\r\nContent-Type: ") + this.mimeType.getName()) + "\r\n\r\n";
    }

    @Override // io.rong.imlib.filetransfer.Request
    public FtConst.MimeType getMimeType() {
        return this.mimeType;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getUploadedUrl(String str) {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected void headers(HttpURLConnection httpURLConnection) {
    }

    public QiniuUploadRequest(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) {
        super(fileInfo, configuration, requestCallBack, str);
    }
}
