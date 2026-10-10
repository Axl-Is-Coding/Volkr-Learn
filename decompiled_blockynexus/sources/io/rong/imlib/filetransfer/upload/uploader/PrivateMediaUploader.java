package io.rong.imlib.filetransfer.upload.uploader;

import io.grpc.internal.GrpcUtil;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.Configuration;
import io.rong.imlib.filetransfer.PrivateUploadRequest;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;
import io.rong.imlib.filetransfer.upload.uploader.QiniuMediaUploader;

/* JADX INFO: loaded from: classes5.dex */
public class PrivateMediaUploader extends BaseMediaUploader {
    private static final String TAG = "PrivateMediaUploader";

    public static final class Builder extends BaseMediaUploader.BaseBuilder<QiniuMediaUploader.Builder> {
        public PrivateMediaUploader build() {
            return new PrivateMediaUploader(this);
        }

        private Builder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            super(filePlatformInfo, nativeObject, upload);
        }
    }

    public PrivateMediaUploader(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
        return new Builder(filePlatformInfo, nativeObject, upload);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public void buildDownloadUrl(String str, BaseMediaUploader.IGetUrlResultCallback iGetUrlResultCallback) {
        iGetUrlResultCallback.onSuccess(str);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public Request buildRequest() {
        PrivateUploadRequest privateUploadRequest = new PrivateUploadRequest(this.configuration, this);
        privateUploadRequest.setContext(NativeClient.getApplicationContext());
        privateUploadRequest.token = this.option.authorInfo.getToken();
        privateUploadRequest.mimeType = this.option.getMimeType();
        privateUploadRequest.method = GrpcUtil.HTTP_METHOD;
        privateUploadRequest.serverIp = handleURL(this.option.getServerIp());
        privateUploadRequest.fileUri = this.option.fileUri.toString();
        privateUploadRequest.tag = Integer.valueOf(this.option.getMessageId());
        privateUploadRequest.fileName = this.option.getFileName();
        privateUploadRequest.isMessage = true;
        return privateUploadRequest;
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader
    protected Configuration getConfiguration() {
        return null;
    }
}
