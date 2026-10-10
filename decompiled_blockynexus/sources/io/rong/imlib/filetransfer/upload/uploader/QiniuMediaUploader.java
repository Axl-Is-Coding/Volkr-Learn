package io.rong.imlib.filetransfer.upload.uploader;

import io.grpc.internal.GrpcUtil;
import io.rong.common.FileUtils;
import io.rong.common.rlog.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.Configuration;
import io.rong.imlib.filetransfer.QiniuUploadRequest;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;

/* JADX INFO: loaded from: classes5.dex */
public class QiniuMediaUploader extends BaseMediaUploader {
    private static final String TAG = "QiniuMediaUploader";

    public static final class Builder extends BaseMediaUploader.BaseBuilder<Builder> {
        public QiniuMediaUploader build() {
            return new QiniuMediaUploader(this);
        }

        private Builder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            super(filePlatformInfo, nativeObject, upload);
        }
    }

    public QiniuMediaUploader(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
        return new Builder(filePlatformInfo, nativeObject, upload);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public void buildDownloadUrl(String str, final BaseMediaUploader.IGetUrlResultCallback iGetUrlResultCallback) {
        this.nativeObj.GetDownloadUrl(this.option.getMimeType().getValue(), this.option.getFileName(), FileUtils.getFileInfoByUri(NativeClient.getApplicationContext(), this.option.fileUri).getName(), new NativeObject.TokenListener() { // from class: io.rong.imlib.filetransfer.upload.uploader.QiniuMediaUploader.1
            @Override // io.rong.imlib.NativeObject.TokenListener
            public void OnError(int i, String str2) {
                if (i == 0) {
                    iGetUrlResultCallback.onSuccess(str2);
                    return;
                }
                RLog.d(QiniuMediaUploader.TAG, "GetDownloadUrl onError code =" + i);
                iGetUrlResultCallback.onError(i);
            }
        }, false);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public Request buildRequest() {
        QiniuUploadRequest qiniuUploadRequest = new QiniuUploadRequest(this.configuration, this);
        qiniuUploadRequest.setContext(NativeClient.getApplicationContext());
        qiniuUploadRequest.token = this.option.authorInfo.getToken();
        qiniuUploadRequest.mimeType = this.option.getMimeType();
        qiniuUploadRequest.method = GrpcUtil.HTTP_METHOD;
        qiniuUploadRequest.serverIp = handleURL(this.option.getServerIp());
        qiniuUploadRequest.fileUri = this.option.fileUri.toString();
        qiniuUploadRequest.tag = Integer.valueOf(this.option.getMessageId());
        qiniuUploadRequest.fileName = this.option.getFileName();
        qiniuUploadRequest.isMessage = true;
        return qiniuUploadRequest;
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader
    protected Configuration getConfiguration() {
        return null;
    }
}
