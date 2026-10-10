package io.rong.imlib.filetransfer.upload.uploader;

import com.alibaba.android.arouter.utils.Consts;
import io.grpc.internal.GrpcUtil;
import io.rong.common.FileUtils;
import io.rong.common.rlog.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.AliUploadRequest;
import io.rong.imlib.filetransfer.Configuration;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;

/* JADX INFO: loaded from: classes5.dex */
public class AliMediaUploader extends BaseMediaUploader {
    private static final String TAG = "AliMediaUploader";

    public static final class Builder extends BaseMediaUploader.BaseBuilder<Builder> {
        public AliMediaUploader build() {
            return new AliMediaUploader(this);
        }

        private Builder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            super(filePlatformInfo, nativeObject, upload);
        }
    }

    public AliMediaUploader(BaseMediaUploader.BaseBuilder baseBuilder) {
        super(baseBuilder);
    }

    public static Builder newBuilder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
        return new Builder(filePlatformInfo, nativeObject, upload);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public void buildDownloadUrl(String str, final BaseMediaUploader.IGetUrlResultCallback iGetUrlResultCallback) {
        this.nativeObj.GetDownloadUrl(this.option.getMimeType().getValue(), this.option.getFileName(), FileUtils.getFileInfoByUri(NativeClient.getApplicationContext(), this.option.fileUri).getName(), new NativeObject.TokenListener() { // from class: io.rong.imlib.filetransfer.upload.uploader.AliMediaUploader.1
            @Override // io.rong.imlib.NativeObject.TokenListener
            public void OnError(int i, String str2) {
                if (i == 0) {
                    iGetUrlResultCallback.onSuccess(str2);
                    return;
                }
                RLog.d(AliMediaUploader.TAG, "GetDownloadUrl onError code =" + i);
                iGetUrlResultCallback.onError(i);
            }
        }, true);
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public Request buildRequest() {
        AliUploadRequest aliUploadRequest = new AliUploadRequest(this.configuration, this);
        aliUploadRequest.setContext(NativeClient.getApplicationContext());
        aliUploadRequest.ossAccessKeyId = this.option.authorInfo.getOssAccessKeyId();
        aliUploadRequest.signature = this.option.authorInfo.getSignature();
        aliUploadRequest.policy = this.option.authorInfo.getPolicy();
        aliUploadRequest.mimeType = this.option.getMimeType();
        aliUploadRequest.method = GrpcUtil.HTTP_METHOD;
        aliUploadRequest.serverIp = handleURL(this.option.authorInfo.getBucketName() + Consts.DOT + this.option.getServerIp());
        aliUploadRequest.fileUri = this.option.fileUri.toString();
        aliUploadRequest.tag = Integer.valueOf(this.option.getMessageId());
        aliUploadRequest.fileName = this.option.getFileName();
        aliUploadRequest.isMessage = true;
        return aliUploadRequest;
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader
    protected Configuration getConfiguration() {
        return null;
    }
}
