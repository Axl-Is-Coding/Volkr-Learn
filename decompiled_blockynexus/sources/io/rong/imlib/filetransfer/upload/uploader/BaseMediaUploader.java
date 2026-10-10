package io.rong.imlib.filetransfer.upload.uploader;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.just.agentweb.DefaultWebClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.Call;
import io.rong.imlib.filetransfer.CallDispatcher;
import io.rong.imlib.filetransfer.Configuration;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.filetransfer.Request;
import io.rong.imlib.filetransfer.RequestCallBack;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import io.rong.imlib.filetransfer.upload.MediaUploadEngine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseMediaUploader implements RequestCallBack, IMediaUploader {
    private static final String TAG = "BaseMediaUploader";
    public MediaUploadEngine.IMediaUploadResultCallback callback;
    protected Configuration configuration;
    protected NativeObject nativeObj;
    public RequestOption.Upload option;
    protected FilePlatformInfo platform;
    private Request request;

    /* JADX INFO: renamed from: io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType = new int[FtConst.ServiceType.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType[FtConst.ServiceType.QI_NIU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType[FtConst.ServiceType.BAI_DU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType[FtConst.ServiceType.ALI_OSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType[FtConst.ServiceType.PRIVATE_CLOUD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static abstract class BaseBuilder<T> {
        public NativeObject nativeObj;
        private RequestOption.Upload option;
        public FilePlatformInfo platform;

        public BaseBuilder(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            this.platform = filePlatformInfo;
            this.nativeObj = nativeObject;
            this.option = upload;
        }
    }

    public static class Factory {
        NativeObject nativeObj;
        RequestOption.Upload option;
        private FilePlatformInfo platform;

        public Factory(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            this.platform = filePlatformInfo;
            this.nativeObj = nativeObject;
            this.option = upload;
        }

        public static Factory params(FilePlatformInfo filePlatformInfo, NativeObject nativeObject, RequestOption.Upload upload) {
            return new Factory(filePlatformInfo, nativeObject, upload);
        }

        public BaseMediaUploader create(FtConst.ServiceType serviceType) {
            int i = AnonymousClass2.$SwitchMap$io$rong$imlib$filetransfer$FtConst$ServiceType[serviceType.ordinal()];
            if (i == 1) {
                return QiniuMediaUploader.newBuilder(this.platform, this.nativeObj, this.option).build();
            }
            if (i == 2) {
                return BDMediaUploader.newBuilder(this.platform, this.nativeObj, this.option).build();
            }
            if (i == 3) {
                return AliMediaUploader.newBuilder(this.platform, this.nativeObj, this.option).build();
            }
            if (i != 4) {
                return null;
            }
            return PrivateMediaUploader.newBuilder(this.platform, this.nativeObj, this.option).build();
        }
    }

    public interface IGetUrlResultCallback {
        void onError(int i);

        void onSuccess(String str);
    }

    public BaseMediaUploader(BaseBuilder baseBuilder) {
        this.platform = baseBuilder.platform;
        this.nativeObj = baseBuilder.nativeObj;
        this.configuration = getConfiguration() != null ? getConfiguration() : new Configuration.Builder().connectTimeout(30).readTimeout(60).build();
        this.option = baseBuilder.option;
    }

    protected abstract Configuration getConfiguration();

    protected String handleURL(String str) {
        if (str.toLowerCase().startsWith("http")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) ? DefaultWebClient.HTTP_SCHEME : DefaultWebClient.HTTPS_SCHEME);
        sb.append(str);
        return sb.toString();
    }

    @Override // io.rong.imlib.filetransfer.RequestCallBack
    public void onCanceled(Object obj) {
        MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback = this.callback;
        if (iMediaUploadResultCallback != null) {
            iMediaUploadResultCallback.onCanceled(obj, this.request.serverIp);
        }
    }

    @Override // io.rong.imlib.filetransfer.RequestCallBack
    public void onComplete(final String str) {
        buildDownloadUrl(str, new IGetUrlResultCallback() { // from class: io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader.1
            @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader.IGetUrlResultCallback
            public void onError(int i) {
                MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback = BaseMediaUploader.this.callback;
                if (iMediaUploadResultCallback != null) {
                    iMediaUploadResultCallback.onError(i, str);
                }
            }

            @Override // io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader.IGetUrlResultCallback
            public void onSuccess(String str2) {
                MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback = BaseMediaUploader.this.callback;
                if (iMediaUploadResultCallback != null) {
                    iMediaUploadResultCallback.onComplete(str2);
                }
            }
        });
    }

    @Override // io.rong.imlib.filetransfer.RequestCallBack
    public void onError(int i) {
        MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback = this.callback;
        if (iMediaUploadResultCallback != null) {
            iMediaUploadResultCallback.onError(i, this.platform.getHost());
        }
    }

    @Override // io.rong.imlib.filetransfer.RequestCallBack
    public void onProgress(int i) {
        MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback = this.callback;
        if (iMediaUploadResultCallback != null) {
            iMediaUploadResultCallback.onProgress(i);
        }
    }

    @Override // io.rong.imlib.filetransfer.upload.uploader.IMediaUploader
    public void run(CallDispatcher callDispatcher, MediaUploadEngine.IMediaUploadResultCallback iMediaUploadResultCallback) {
        this.callback = iMediaUploadResultCallback;
        this.request = buildRequest();
        Call.create(callDispatcher, this.request).enqueue();
    }
}
