package io.rong.imlib;

import android.net.Uri;
import io.rong.common.RLog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.RTCUser;
import io.rong.imlib.model.UserOnlineStatusInfo;
import io.rong.message.MediaMessageContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IRongCallback {

    public interface IChatRoomHistoryMessageCallback {
        void onError(RongIMClient.ErrorCode errorCode);

        void onSuccess(List<Message> list, long j);
    }

    public interface IDownloadMediaFileCallback {
        void onCanceled();

        void onError(RongIMClient.ErrorCode errorCode);

        void onFileNameChanged(String str);

        void onProgress(int i);

        void onSuccess();
    }

    public interface IDownloadMediaMessageCallback {
        void onCanceled(Message message);

        void onError(Message message, RongIMClient.ErrorCode errorCode);

        void onProgress(Message message, int i);

        void onSuccess(Message message);
    }

    public interface IGetUserOnlineStatusCallback {
        void onError(int i);

        void onSuccess(ArrayList<UserOnlineStatusInfo> arrayList);
    }

    public interface IRTCConfigCallback {
        void onError(RongIMClient.ErrorCode errorCode);

        void onSuccess(String str, long j);
    }

    public interface IRTCDataCallback {
        void onError(RongIMClient.ErrorCode errorCode);

        void onSuccess(List<RTCUser> list);
    }

    public interface IRTCJoinRoomCallback extends IRTCJoinRoomCallbackEx<String> {
    }

    public interface IRTCJoinRoomCallbackEx<T> {
        void onError(RongIMClient.ErrorCode errorCode);

        void onSuccess(List<RTCUser> list, T t);
    }

    public interface IRtcIODataCallback {
        void onError(RongIMClient.ErrorCode errorCode);

        void onSuccess(Map<String, String> map);
    }

    public interface ISendMediaMessageCallback extends ISendMessageCallback {
        void onCanceled(Message message);

        void onProgress(Message message, int i);
    }

    public interface ISendMediaMessageCallbackWithUploader {
        void onAttached(Message message, MediaMessageUploader mediaMessageUploader);

        void onCanceled(Message message);

        void onError(Message message, RongIMClient.ErrorCode errorCode);

        void onProgress(Message message, int i);

        void onSuccess(Message message);
    }

    public interface ISendMessageCallback {
        void onAttached(Message message);

        void onError(Message message, RongIMClient.ErrorCode errorCode);

        void onSuccess(Message message);
    }

    public interface ISetSubscribeStatusCallback {
        void onStatusReceived(String str, ArrayList<UserOnlineStatusInfo> arrayList);
    }

    public interface ISetUserOnlineStatusCallback {
        void onError(int i);

        void onSuccess();
    }

    public static class MediaMessageUploader {
        private ISendMediaMessageCallbackWithUploader callbackWithUploader;
        private Message message;
        private String pushContent;
        private String pushData;

        public MediaMessageUploader(Message message, String str, String str2, ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader) {
            this.callbackWithUploader = iSendMediaMessageCallbackWithUploader;
            this.message = message;
            this.pushContent = str;
            this.pushData = str2;
        }

        public void cancel() {
            ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader = this.callbackWithUploader;
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onCanceled(this.message);
            }
        }

        public void error() {
            this.message.setSentStatus(Message.SentStatus.FAILED);
            RongIMClient.getInstance().setMessageSentStatus(this.message, null);
            ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader = this.callbackWithUploader;
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onError(this.message, RongIMClient.ErrorCode.RC_MSG_SEND_FAIL);
            }
        }

        public void success(Uri uri) {
            if (uri != null) {
                ((MediaMessageContent) this.message.getContent()).setMediaUrl(uri);
                RongIMClient.getInstance().sendMediaMessage(this.message, this.pushContent, this.pushData, new ISendMediaMessageCallback() { // from class: io.rong.imlib.IRongCallback.MediaMessageUploader.1
                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onAttached(Message message) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                    public void onCanceled(Message message) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                        if (MediaMessageUploader.this.callbackWithUploader != null) {
                            MediaMessageUploader.this.callbackWithUploader.onError(message, errorCode);
                        }
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                    public void onProgress(Message message, int i) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onSuccess(Message message) {
                        if (MediaMessageUploader.this.callbackWithUploader != null) {
                            MediaMessageUploader.this.callbackWithUploader.onSuccess(message);
                        }
                    }
                });
                return;
            }
            RLog.e("MediaMessageUploader", "uploadedUri is null.");
            ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader = this.callbackWithUploader;
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onError(this.message, RongIMClient.ErrorCode.RC_MSG_SEND_FAIL);
            }
        }

        public void update(int i) {
            ISendMediaMessageCallbackWithUploader iSendMediaMessageCallbackWithUploader = this.callbackWithUploader;
            if (iSendMediaMessageCallbackWithUploader != null) {
                iSendMediaMessageCallbackWithUploader.onProgress(this.message, i);
            }
        }
    }
}
