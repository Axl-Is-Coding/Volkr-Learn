package io.rong.imlib.filetransfer;

import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.io.File;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class BaiDuUploadRequest extends Request {
    private static final String Boundary = "--526f6e67436c6f7564";

    public BaiDuUploadRequest(Configuration configuration, RequestCallBack requestCallBack) {
        super(configuration, requestCallBack);
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected boolean enableEndBoundary() {
        return false;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getBoundary() {
        return Boundary;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public long getContentLength() {
        return ((long) getFormData().length()) + new File(this.fileUri).length();
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getContentType() {
        return this.mimeType.getName();
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getFormData() {
        return "";
    }

    @Override // io.rong.imlib.filetransfer.Request
    public FtConst.MimeType getMimeType() {
        return this.mimeType;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getUploadedUrl(String str) {
        return this.serverIp;
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected void headers(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Authorization", this.token);
        httpURLConnection.setRequestProperty("x-bce-date", this.date);
        if (FtConst.MimeType.FILE_HTML.getName().equals(getContentType())) {
            return;
        }
        httpURLConnection.setRequestProperty("Content-Disposition", "attachment;filename=" + this.fileName);
    }

    public BaiDuUploadRequest(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) {
        super(fileInfo, configuration, requestCallBack, str);
    }
}
