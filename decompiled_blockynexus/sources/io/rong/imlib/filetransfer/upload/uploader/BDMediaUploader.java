package io.rong.imlib.filetransfer.upload.uploader;

import io.grpc.internal.GrpcUtil;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.BaiDuUploadRequest;
import io.rong.imlib.filetransfer.Configuration;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;

/* JADX INFO: loaded from: classes5.dex */
public class BDMediaUploader extends BaseMediaUploader {

    public static final class Builder extends BaseMediaUploader.BaseBuilder<Builder> {
        public BDMediaUploader build() {
            return new BDMediaUploader(this);
        }

        private Builder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            super(filePlatformInfo, nativeObject, upload);
        }
    }

    public BDMediaUploader(BaseMediaUploader.BaseBuilder baseBuilder) {
        super(baseBuilder);
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
        BaiDuUploadRequest baiDuUploadRequest = new BaiDuUploadRequest(this.configuration, this);
        baiDuUploadRequest.setContext(NativeClient.getApplicationContext());
        baiDuUploadRequest.token = this.option.authorInfo.getAlternative();
        baiDuUploadRequest.date = this.option.authorInfo.getDate();
        baiDuUploadRequest.mimeType = this.option.getMimeType();
        baiDuUploadRequest.method = GrpcUtil.HTTP_METHOD;
        baiDuUploadRequest.serverIp = handleURL(this.option.getServerIp() + this.option.authorInfo.getPath());
        baiDuUploadRequest.fileUri = this.option.fileUri.toString();
        baiDuUploadRequest.tag = Integer.valueOf(this.option.getMessageId());
        baiDuUploadRequest.fileName = this.option.getFileName();
        baiDuUploadRequest.isMessage = true;
        return baiDuUploadRequest;
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader
    protected Configuration getConfiguration() {
        return null;
    }
}
