package io.rong.imlib.filetransfer;

import android.net.Uri;
import io.rong.common.FileUtils;
import io.rong.imlib.NativeClient;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.model.FileInfo;
import java.io.File;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class AliUploadRequest extends Request {
    private static final String Boundary = "526f6e67436c6f7564";

    public AliUploadRequest(Configuration configuration, RequestCallBack requestCallBack) {
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
        return ((long) getFormData().length()) + new File(this.fileUri).length() + ((long) 24);
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getContentType() {
        return "multipart/form-data; boundary=526f6e67436c6f7564";
    }

    @Override // io.rong.imlib.filetransfer.Request
    public String getFormData() {
        String str = ((((((("--" + Boundary) + "\r\nContent-Disposition: form-data; name=\"OSSAccessKeyId\"\r\n\r\n") + this.ossAccessKeyId) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"key\"\r\n\r\n") + this.fileName) + "\r\n--";
        if (!FtConst.MimeType.FILE_HTML.getName().equals(getContentType())) {
            str = (((str + Boundary) + "\r\nContent-Disposition: form-data; name=\"Content-Disposition\"\r\n\r\n") + "attachment;filename=" + FileUtils.getFileInfoByUri(NativeClient.getApplicationContext(), Uri.parse(this.fileUri)).getName()) + "\r\n--";
        }
        return (((((((((((((str + Boundary) + "\r\nContent-Disposition: form-data; name=\"policy\"\r\n\r\n") + this.policy) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"Signature\"\r\n\r\n") + this.signature) + "\r\n--") + Boundary) + "\r\nContent-Disposition: form-data; name=\"file\"; filename=\"") + this.fileName) + "\"\r\nContent-Type: ") + this.mimeType.getName()) + "\r\n\r\n";
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

    public AliUploadRequest(FileInfo fileInfo, Configuration configuration, RequestCallBack requestCallBack, String str) {
        super(fileInfo, configuration, requestCallBack, str);
    }
}
