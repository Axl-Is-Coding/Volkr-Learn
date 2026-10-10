package io.rong.imlib.filetransfer;

import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadRequest extends Request {
    public DownloadRequest(Configuration configuration, RequestCallBack requestCallBack) {
        super(configuration, requestCallBack);
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected boolean enableEndBoundary() {
        return false;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getBoundary() {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public long getContentLength() {
        return 0L;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getContentType() {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getFormData() {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public FtConst.MimeType getMimeType() {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getUploadedUrl(String str) {
        return null;
    }

    @Override // io.rong.imlib.filetransfer.Request
    protected void headers(HttpURLConnection httpURLConnection) {
    }

    public DownloadRequest(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) {
        super(fileInfo, configuration, requestCallBack, str);
    }
}
