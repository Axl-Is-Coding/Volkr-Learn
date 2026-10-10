package io.rong.imlib.filetransfer.upload;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import io.rong.common.FileInfo;
import io.rong.common.FileUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.common.rlog.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.filetransfer.FtUtilities;
import io.rong.imlib.filetransfer.RequestOption;
import io.rong.imlib.filetransfer.upload.uploader.BaseMediaUploader;
import io.rong.imlib.model.Message;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.imlib.navigation.NavigationClient;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MediaUploadEngine extends AbstractMediaFileService {
    private static final String TAG = "MediaUploadEngine";
    private static MediaUploadEngine mInstance;
    private Hashtable<Integer, Integer> cacheProgress;

    public interface IMediaUploadResultCallback {
        void onCanceled(Object obj, String str);

        void onComplete(String str);

        void onError(int i, String str);

        void onProgress(int i);
    }

    private static class SingletonHolder {
        private static final MediaUploadEngine INSTANCE = new MediaUploadEngine();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseMediaUploader> buildUploaderListSorted(NativeObject nativeObject, String str, MediaUploadAuthorInfo mediaUploadAuthorInfo, String str2, Uri uri, Message message, FtConst.MimeType mimeType) {
        List<FilePlatformInfo> arrayList = new ArrayList<>();
        if (!NavigationCacheHelper.getPrivateCloudConfig(NativeClient.getApplicationContext()) || TextUtils.isEmpty(str)) {
            arrayList = NavigationClient.getInstance().getMediaServerConfigs(NativeClient.getApplicationContext());
        } else {
            arrayList.add(new FilePlatformInfo(str, "0", FtConst.ServiceType.PRIVATE_CLOUD));
            arrayList.add(new FilePlatformInfo(str, "1", FtConst.ServiceType.QI_NIU));
        }
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (FilePlatformInfo filePlatformInfo : arrayList) {
            BaseMediaUploader baseMediaUploaderCreate = BaseMediaUploader.Factory.params(filePlatformInfo, nativeObject, RequestOption.Upload.newBuilder(uri, str2, mimeType, message.getMessageId(), mediaUploadAuthorInfo, filePlatformInfo.getHost()).requestCallback(null).build()).create(filePlatformInfo.getType());
            if (baseMediaUploaderCreate != null) {
                arrayList2.add(baseMediaUploaderCreate);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpload(final List<BaseMediaUploader> list, final FileInfo fileInfo, final Message message, final NativeClient.IResultProgressCallback<String> iResultProgressCallback) {
        if (list == null || list.size() == 0) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        list.remove(0).run(dispatcher(), new IMediaUploadResultCallback() { // from class: io.rong.imlib.filetransfer.upload.MediaUploadEngine.2
            @Override // io.rong.imlib.filetransfer.upload.MediaUploadEngine.IMediaUploadResultCallback
            public void onCanceled(Object obj, String str) {
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "upload", FtUtilities.getMimeType(fileInfo.getName()), true, Long.valueOf(fileInfo.getSize() / 1024), str, Long.valueOf(jElapsedRealtime - SystemClock.elapsedRealtime()), 0);
                iResultProgressCallback.onCanceled(((Integer) obj).intValue());
                MediaUploadEngine.this.cacheProgress.remove(Integer.valueOf(message.getMessageId()));
            }

            @Override // io.rong.imlib.filetransfer.upload.MediaUploadEngine.IMediaUploadResultCallback
            public void onComplete(String str) {
                iResultProgressCallback.onSuccess(str);
                MediaUploadEngine.this.cacheProgress.remove(Integer.valueOf(message.getMessageId()));
                FwLog.write(4, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "upload", FtUtilities.getMimeType(fileInfo.getName()), false, Long.valueOf(fileInfo.getSize() / 1024), str, Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), 0);
            }

            @Override // io.rong.imlib.filetransfer.upload.MediaUploadEngine.IMediaUploadResultCallback
            public void onError(int i, String str) {
                List list2 = list;
                if (list2 != null && list2.size() != 0) {
                    MediaUploadEngine.this.doUpload(list, fileInfo, message, iResultProgressCallback);
                    return;
                }
                FwLog.write(1, 1, FwLog.LogTag.L_MEDIA_S.getTag(), "type|media_type|user_stop|size|fileUri|duration|code", "upload", FtUtilities.getMimeType(fileInfo.getName()), false, Long.valueOf(fileInfo.getSize() / 1024), str, Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), Integer.valueOf(i));
                RLog.d(MediaUploadEngine.TAG, "uploadMedia onError code =" + i);
                iResultProgressCallback.onError(RongIMClient.ErrorCode.RC_FILE_UPLOAD_FAILED.getValue());
                MediaUploadEngine.this.cacheProgress.remove(Integer.valueOf(message.getMessageId()));
            }

            @Override // io.rong.imlib.filetransfer.upload.MediaUploadEngine.IMediaUploadResultCallback
            public void onProgress(int i) {
                Integer num = (Integer) MediaUploadEngine.this.cacheProgress.get(Integer.valueOf(message.getMessageId()));
                if (num == null || num.intValue() < i) {
                    iResultProgressCallback.onProgress(i);
                    MediaUploadEngine.this.cacheProgress.put(Integer.valueOf(message.getMessageId()), Integer.valueOf(i));
                }
            }
        });
    }

    public static MediaUploadEngine getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void uploadMedia(final Handler handler, final NativeObject nativeObject, final Message message, final Uri uri, final String str, final NativeClient.IResultProgressCallback<String> iResultProgressCallback) {
        final FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(NativeClient.getApplicationContext(), uri);
        if (fileInfoByUri == null) {
            RLog.e(TAG, "Uri error path is " + uri.toString());
            iResultProgressCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
            return;
        }
        final FtConst.MimeType mimeType = FtUtilities.getMimeType(fileInfoByUri.getName());
        final String str2 = FtUtilities.generateKey(mimeType.getName()) + FtUtilities.getSuffixName(fileInfoByUri.getName());
        nativeObject.GetUploadToken(mimeType.getValue(), str2, new NativeObject.FileTokenListener() { // from class: io.rong.imlib.filetransfer.upload.MediaUploadEngine.1
            @Override // io.rong.imlib.NativeObject.FileTokenListener
            public void OnError(int i, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10) {
                if (i == 0) {
                    handler.post(new Runnable() { // from class: io.rong.imlib.filetransfer.upload.MediaUploadEngine.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MediaUploadAuthorInfo mediaUploadAuthorInfoBuild = MediaUploadAuthorInfo.newBuilder().token(str3).alternative(str4).path(str6).date(str5).ossAccessKeyId(str7).ossPolicy(str8).ossSignature(str9).bucket(str10).build();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            List listBuildUploaderListSorted = MediaUploadEngine.this.buildUploaderListSorted(nativeObject, str, mediaUploadAuthorInfoBuild, str2, uri, message, mimeType);
                            if (listBuildUploaderListSorted == null || listBuildUploaderListSorted.size() == 0) {
                                iResultProgressCallback.onError(RongIMClient.ErrorCode.RC_FILE_UPLOAD_FAILED.getValue());
                            } else {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                MediaUploadEngine.this.doUpload(listBuildUploaderListSorted, fileInfoByUri, message, iResultProgressCallback);
                            }
                        }
                    });
                } else {
                    iResultProgressCallback.onError(i);
                }
            }
        });
    }

    private MediaUploadEngine() {
        this.cacheProgress = new Hashtable<>();
    }
}
