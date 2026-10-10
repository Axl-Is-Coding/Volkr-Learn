package io.rong.imlib;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.common.rlog.RLog;
import io.rong.imlib.IHandler;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.filetransfer.CancelCallback;
import io.rong.imlib.filetransfer.MediaDownloadEngine;
import io.rong.imlib.filetransfer.PauseCallback;
import io.rong.imlib.filetransfer.upload.MediaUploadEngine;
import io.rong.imlib.httpdns.HttpDnsCompletion;
import io.rong.imlib.httpdns.RongHttpDns;
import io.rong.imlib.httpdns.RongHttpDnsResult;
import io.rong.imlib.model.ChatRoomInfo;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.ConversationStatus;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.RTCStatusDate;
import io.rong.imlib.model.RTCUser;
import io.rong.imlib.model.RemoteHistoryMsgOption;
import io.rong.imlib.model.RemoteModelWrap;
import io.rong.imlib.model.RongListWrap;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.model.UserData;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.imlib.navigation.NavigationClient;
import io.rong.imlib.statistics.CrashDetails;
import io.rong.rtlog.upload.RtLogUploadManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class LibHandlerStub extends IHandler.Stub {
    private static final String TAG = "LibHandlerStub";
    private boolean mCancelSDKHeartbeat;
    private NativeClient mClient = NativeClient.getInstance();
    private Context mContext;
    private String mCurrentUserId;

    private class OperationCallback implements NativeClient.OperationCallback {
        IOperationCallback callback;

        public OperationCallback(IOperationCallback iOperationCallback) {
            this.callback = iOperationCallback;
        }

        @Override // io.rong.imlib.NativeClient.OperationCallback
        public void onError(int i) {
            IOperationCallback iOperationCallback = this.callback;
            if (iOperationCallback != null) {
                try {
                    iOperationCallback.onFailure(i);
                } catch (RemoteException e2) {
                    LibHandlerStub.this.handleRemoteException(e2);
                }
            }
        }

        @Override // io.rong.imlib.NativeClient.OperationCallback
        public void onSuccess() {
            IOperationCallback iOperationCallback = this.callback;
            if (iOperationCallback != null) {
                try {
                    iOperationCallback.onComplete();
                } catch (RemoteException e2) {
                    LibHandlerStub.this.handleRemoteException(e2);
                }
            }
        }
    }

    public LibHandlerStub(Context context, String str, String str2) {
        this.mContext = context;
        this.mClient.init(this.mContext, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoteException(RemoteException remoteException) {
        FwLog.write(1, 1, FwLog.LogTag.L_CRASH_IPC_RMT_E.getTag(), "stacks|env", FwLog.stackToString(remoteException), CrashDetails.getIMCrashData(this.mContext, remoteException.toString()));
        remoteException.printStackTrace();
    }

    private void handleRuntimeException(RuntimeException runtimeException) {
        FwLog.write(1, 1, FwLog.LogTag.L_CRASH_IPC_RTM_F.getTag(), "stacks|env", FwLog.stackToString(runtimeException), CrashDetails.getIMCrashData(this.mContext, runtimeException.toString()));
        throw runtimeException;
    }

    private void processConversationList(List<Conversation> list, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        int i2;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Conversation> it = list.iterator();
            loop0: while (true) {
                i2 = 0;
                while (it.hasNext()) {
                    arrayList.add(it.next());
                    i2++;
                    if (i2 >= i) {
                        break;
                    }
                }
                iGetConversationListWithProcessCallback.onProcess(arrayList);
                arrayList.clear();
            }
            if (i2 > 0) {
                iGetConversationListWithProcessCallback.onProcess(arrayList);
                arrayList.clear();
            }
        }
        iGetConversationListWithProcessCallback.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRTCProfile() {
        String rTCProfile = getRTCProfile();
        if (TextUtils.isEmpty(rTCProfile)) {
            RLog.e(TAG, "updateRTCProfile,rtcProfile is empty");
            return;
        }
        try {
            updateVoIPCallInfo(rTCProfile);
        } catch (RemoteException e2) {
            RLog.e(TAG, e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void addMemberToDiscussion(String str, List<String> list, IOperationCallback iOperationCallback) {
        try {
            this.mClient.addMemberToDiscussion(str, list, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void addToBlacklist(String str, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.addToBlacklist(str, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.42
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void cancelAllDownloadMediaMessage(IOperationCallback iOperationCallback) throws RemoteException {
        try {
            MediaDownloadEngine.getInstance().cancelAll();
            if (iOperationCallback != null) {
                iOperationCallback.onComplete();
            }
        } catch (Exception e2) {
            RLog.e(TAG, "cancelAllDownloadMediaMessage", e2);
            if (iOperationCallback != null) {
                try {
                    iOperationCallback.onFailure(-1);
                } catch (RemoteException e3) {
                    handleRemoteException(e3);
                }
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public void cancelDownloadMediaMessage(Message message, final IOperationCallback iOperationCallback) throws RemoteException {
        try {
            MediaDownloadEngine.getInstance().cancel(message.getMessageId(), new CancelCallback() { // from class: io.rong.imlib.LibHandlerStub.37
                @Override // io.rong.imlib.filetransfer.CancelCallback
                public void onCanceled(Object obj) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.filetransfer.CancelCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public synchronized void cancelSDKHeartBeat() {
        this.mCancelSDKHeartbeat = true;
        try {
            HeartBeatManager.getInstance().cancelSDKHeartBeat(this.mContext);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void cancelSendMediaMessage(Message message, final IOperationCallback iOperationCallback) throws RemoteException {
        try {
            MediaUploadEngine.getInstance().cancel(message.getMessageId(), new CancelCallback() { // from class: io.rong.imlib.LibHandlerStub.36
                @Override // io.rong.imlib.filetransfer.CancelCallback
                public void onCanceled(Object obj) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.filetransfer.CancelCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean cleanConversationDraft(Conversation conversation) {
        try {
            return this.mClient.clearTextMessageDraft(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void cleanHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) {
        try {
            this.mClient.cleanHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), j, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void cleanRemoteHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) {
        try {
            this.mClient.cleanRemoteHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), j, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearConversations(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        try {
            Conversation.ConversationType[] conversationTypeArr = new Conversation.ConversationType[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                conversationTypeArr[i] = Conversation.ConversationType.setValue(iArr[i]);
            }
            return this.mClient.clearConversations(conversationTypeArr);
        } catch (IllegalAccessException e2) {
            RLog.e(TAG, "clearConversations", e2);
            return false;
        } catch (RuntimeException e3) {
            handleRuntimeException(e3);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearEncryptedConversations() {
        return this.mClient.clearEncryptedConversations();
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearMessages(Conversation conversation) {
        try {
            return this.mClient.clearMessages(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearMessagesUnreadStatus(Conversation conversation) {
        try {
            return this.mClient.clearMessagesUnreadStatus(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearTextMessageDraft(Conversation conversation) {
        try {
            return this.mClient.clearTextMessageDraft(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean clearUnreadByReceipt(int i, String str, long j) {
        try {
            return this.mClient.clearUnreadByReceipt(i, str, j);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void connect(String str, boolean z, boolean z2, final IConnectStringCallback iConnectStringCallback) {
        try {
            this.mClient.connect(str, z, z2, new NativeClient.IConnectResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.1
                @Override // io.rong.imlib.NativeClient.IConnectResultCallback
                public void OnDatabaseOpened(int i) {
                    IConnectStringCallback iConnectStringCallback2 = iConnectStringCallback;
                    if (iConnectStringCallback2 != null) {
                        try {
                            iConnectStringCallback2.OnDatabaseOpened(i);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    HeartBeatManager.getInstance().removeHeartbeatFromAM(LibHandlerStub.this.mContext);
                    IConnectStringCallback iConnectStringCallback2 = iConnectStringCallback;
                    if (iConnectStringCallback2 != null) {
                        try {
                            iConnectStringCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str2) {
                    if (iConnectStringCallback != null) {
                        LibHandlerStub.this.mCurrentUserId = str2;
                        HeartBeatManager.getInstance().scheduleHeartbeat(LibHandlerStub.this.mContext);
                        try {
                            iConnectStringCallback.onComplete(str2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void createDiscussion(final String str, final List<String> list, final IResultCallback iResultCallback) {
        try {
            this.mClient.createDiscussion(str, list, new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.19
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str2) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(new RemoteModelWrap(new Discussion(str2, str, LibHandlerStub.this.mCurrentUserId, true, list)));
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean createEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) {
        return this.mClient.createEncryptedConversation(str, rCEncryptedSession);
    }

    @Override // io.rong.imlib.IHandler
    public void deleteChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.deleteChatRoomEntry(str, str2, str3, Boolean.valueOf(z), str4, z2, z3, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            RLog.e(TAG, "deleteChatRoomEntry ", e2);
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean deleteConversationMessage(int i, String str) {
        try {
            return this.mClient.deleteMessage(Conversation.ConversationType.setValue(i), str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean deleteMessage(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        try {
            return this.mClient.deleteMessages(iArr);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void deleteMessages(int i, String str, Message[] messageArr, IOperationCallback iOperationCallback) {
        try {
            Conversation.ConversationType value = Conversation.ConversationType.setValue(i);
            if (value.equals(Conversation.ConversationType.CHATROOM)) {
                RLog.e(TAG, "this conversationType isn't supported!");
            } else {
                if (messageArr == null || messageArr.length == 0) {
                    throw new IllegalArgumentException("messages 参数异常。");
                }
                this.mClient.deleteMessages(value, str, messageArr, new OperationCallback(iOperationCallback));
            }
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void disconnect(boolean z) {
        try {
            HeartBeatManager.getInstance().removeHeartbeatFromAM(this.mContext);
            this.mClient.disconnect(z);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void downloadMedia(Conversation conversation, int i, String str, final IDownloadMediaCallback iDownloadMediaCallback) {
        try {
            this.mClient.downloadMedia(conversation.getConversationType(), conversation.getTargetId(), i, str, new NativeClient.IResultProgressCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.33
                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onCanceled(int i2) {
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onError(int i2) {
                    IDownloadMediaCallback iDownloadMediaCallback2 = iDownloadMediaCallback;
                    if (iDownloadMediaCallback2 != null) {
                        try {
                            iDownloadMediaCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onProgress(int i2) {
                    IDownloadMediaCallback iDownloadMediaCallback2 = iDownloadMediaCallback;
                    if (iDownloadMediaCallback2 != null) {
                        try {
                            iDownloadMediaCallback2.onProgress(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onSuccess(String str2) {
                    IDownloadMediaCallback iDownloadMediaCallback2 = iDownloadMediaCallback;
                    if (iDownloadMediaCallback2 != null) {
                        try {
                            iDownloadMediaCallback2.onComplete(str2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void downloadMediaFile(String str, String str2, String str3, String str4, final IDownloadMediaFileCallback iDownloadMediaFileCallback) {
        try {
            this.mClient.downloadMediaFile(str, str2, str3, str4, new NativeClient.IDownloadMediaFileCallback<Boolean>() { // from class: io.rong.imlib.LibHandlerStub.35
                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onCanceled() {
                    IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                    if (iDownloadMediaFileCallback2 != null) {
                        try {
                            iDownloadMediaFileCallback2.onCanceled();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onError(int i) {
                    IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                    if (iDownloadMediaFileCallback2 != null) {
                        try {
                            iDownloadMediaFileCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaFileCallback
                public void onFileNameChanged(String str5) {
                    IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                    if (iDownloadMediaFileCallback2 == null) {
                        return;
                    }
                    try {
                        iDownloadMediaFileCallback2.onFileNameChanged(str5);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onProgress(int i) {
                    IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                    if (iDownloadMediaFileCallback2 != null) {
                        try {
                            iDownloadMediaFileCallback2.onProgress(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onSuccess(Boolean bool) {
                    IDownloadMediaFileCallback iDownloadMediaFileCallback2 = iDownloadMediaFileCallback;
                    if (iDownloadMediaFileCallback2 != null) {
                        try {
                            iDownloadMediaFileCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void downloadMediaMessage(Message message, final IDownloadMediaMessageCallback iDownloadMediaMessageCallback) {
        try {
            this.mClient.downloadMediaMessage(message, new NativeClient.IDownloadMediaMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.34
                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onCanceled() {
                    IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                    if (iDownloadMediaMessageCallback2 != null) {
                        try {
                            iDownloadMediaMessageCallback2.onCanceled();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onError(int i) {
                    IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                    if (iDownloadMediaMessageCallback2 != null) {
                        try {
                            iDownloadMediaMessageCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onProgress(int i) {
                    IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                    if (iDownloadMediaMessageCallback2 != null) {
                        try {
                            iDownloadMediaMessageCallback2.onProgress(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IDownloadMediaMessageCallback
                public void onSuccess(Message message2) {
                    IDownloadMediaMessageCallback iDownloadMediaMessageCallback2 = iDownloadMediaMessageCallback;
                    if (iDownloadMediaMessageCallback2 != null) {
                        try {
                            iDownloadMediaMessageCallback2.onComplete(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void exitRTCRoom(String str, IOperationCallback iOperationCallback) {
        try {
            this.mClient.exitRTCRoom(str, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getAllChatRoomEntries(String str, final IDataByBatchListener iDataByBatchListener) throws RemoteException {
        this.mClient.getAllChatRoomStatus(str, new NativeClient.IResultCallback<HashMap<String, String>>() { // from class: io.rong.imlib.LibHandlerStub.67
            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onError(int i) {
                IDataByBatchListener iDataByBatchListener2 = iDataByBatchListener;
                if (iDataByBatchListener2 != null) {
                    try {
                        iDataByBatchListener2.onError(i);
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "getAllChatRoomEntries error ", e2);
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }

            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onSuccess(HashMap<String, String> map) {
                if (iDataByBatchListener != null) {
                    try {
                        HashMap map2 = new HashMap();
                        if (map != null && map.size() > 0) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                map2.put(entry.getKey(), entry.getValue());
                                if (map2.size() % 50 == 0) {
                                    iDataByBatchListener.onProgress(map2);
                                    map2.clear();
                                }
                            }
                            if (map2.size() > 0) {
                                iDataByBatchListener.onProgress(map2);
                                map2.clear();
                            }
                        }
                        iDataByBatchListener.onComplete();
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "getAllChatRoomEntries success ", e2);
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public List<RCEncryptedSession> getAllEncryptedConversations() {
        return this.mClient.getAllEncryptedConversations();
    }

    @Override // io.rong.imlib.IHandler
    public void getBlacklist(final IStringCallback iStringCallback) {
        try {
            this.mClient.getBlacklist(new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.45
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onComplete(str);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getBlacklistStatus(String str, final IIntegerCallback iIntegerCallback) {
        try {
            this.mClient.getBlacklistStatus(str, new NativeClient.IResultCallback<NativeClient.BlacklistStatus>() { // from class: io.rong.imlib.LibHandlerStub.44
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IIntegerCallback iIntegerCallback2 = iIntegerCallback;
                    if (iIntegerCallback2 != null) {
                        try {
                            iIntegerCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(NativeClient.BlacklistStatus blacklistStatus) {
                    IIntegerCallback iIntegerCallback2 = iIntegerCallback;
                    if (iIntegerCallback2 != null) {
                        try {
                            iIntegerCallback2.onComplete(blacklistStatus.getValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Conversation> getBlockedConversationList(int[] iArr) {
        try {
            return this.mClient.getBlockedConversationList(iArr);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getChatRoomEntry(String str, String str2, final IStringCallback iStringCallback) throws RemoteException {
        this.mClient.getChatRoomStatusByKey(str, str2, new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.66
            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onError(int i) {
                IStringCallback iStringCallback2 = iStringCallback;
                if (iStringCallback2 != null) {
                    try {
                        iStringCallback2.onFailure(i);
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "getChatRoomEntry - " + e2.toString());
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }

            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onSuccess(String str3) {
                IStringCallback iStringCallback2 = iStringCallback;
                if (iStringCallback2 != null) {
                    try {
                        iStringCallback2.onComplete(str3);
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "getChatRoomEntry - " + e2.toString());
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public void getChatRoomInfo(String str, int i, int i2, final IResultCallback iResultCallback) {
        try {
            this.mClient.queryChatRoomInfo(str, i, i2, new NativeClient.IResultCallback<ChatRoomInfo>() { // from class: io.rong.imlib.LibHandlerStub.24
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i3) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(ChatRoomInfo chatRoomInfo) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(new RemoteModelWrap(chatRoomInfo));
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getChatroomHistoryMessages(String str, long j, int i, int i2, final IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) {
        try {
            this.mClient.getChatroomHistoryMessages(str, j, i, i2, new NativeClient.IResultCallbackEx<List<Message>, Long>() { // from class: io.rong.imlib.LibHandlerStub.8
                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onError(int i3) {
                    IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback2 = iChatRoomHistoryMessageCallback;
                    if (iChatRoomHistoryMessageCallback2 != null) {
                        try {
                            iChatRoomHistoryMessageCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onSuccess(List<Message> list, Long l) {
                    if (iChatRoomHistoryMessageCallback != null) {
                        if (list != null) {
                            try {
                                if (list.size() == 0) {
                                    iChatRoomHistoryMessageCallback.onComplete(null, l.longValue());
                                } else {
                                    iChatRoomHistoryMessageCallback.onComplete(new RemoteModelWrap(RongListWrap.obtain(list, Message.class)), l.longValue());
                                }
                            } catch (RemoteException e2) {
                                LibHandlerStub.this.handleRemoteException(e2);
                            }
                        } else {
                            iChatRoomHistoryMessageCallback.onComplete(null, l.longValue());
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public Conversation getConversation(int i, String str) {
        try {
            return this.mClient.getConversation(Conversation.ConversationType.setValue(i), str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getConversationDraft(Conversation conversation) {
        try {
            return this.mClient.getTextMessageDraft(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Conversation> getConversationList() {
        try {
            List<Conversation> conversationList = this.mClient.getConversationList();
            if (conversationList == null || conversationList.size() == 0) {
                return null;
            }
            return conversationList;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getConversationListByBatch(int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        if (iGetConversationListWithProcessCallback == null) {
            return;
        }
        try {
            processConversationList(this.mClient.getConversationList(), i, iGetConversationListWithProcessCallback);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Conversation> getConversationListByPage(int[] iArr, long j, int i) {
        try {
            return this.mClient.getConversationListByPage(iArr, j, i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Conversation> getConversationListByType(int[] iArr) {
        try {
            List<Conversation> conversationList = this.mClient.getConversationList(iArr);
            if (conversationList == null || conversationList.size() == 0) {
                return null;
            }
            return conversationList;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getConversationListOfTypesByBatch(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        if (iGetConversationListWithProcessCallback == null) {
            return;
        }
        try {
            processConversationList(this.mClient.getConversationList(iArr), i, iGetConversationListWithProcessCallback);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getConversationNotificationStatus(int i, String str, final ILongCallback iLongCallback) {
        try {
            this.mClient.getConversationNotificationStatus(Conversation.ConversationType.setValue(i), str, new NativeClient.IResultCallback<Integer>() { // from class: io.rong.imlib.LibHandlerStub.16
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Integer num) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onComplete(num.intValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getConversationUnreadCount(Conversation conversation) {
        try {
            return this.mClient.getUnreadCount(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getCurrentUserId() {
        try {
            return this.mClient.getCurrentUserId();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public long getDeltaTime() {
        try {
            return this.mClient.getDeltaTime();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getDiscussion(String str, final IResultCallback iResultCallback) {
        try {
            this.mClient.getDiscussion(str, new NativeClient.IResultCallback<Discussion>() { // from class: io.rong.imlib.LibHandlerStub.18
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Discussion discussion) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(new RemoteModelWrap(discussion));
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public RCEncryptedSession getEncryptedConversation(String str) {
        return this.mClient.getEncryptedConversation(str);
    }

    @Override // io.rong.imlib.IHandler
    public boolean getFileDownloadingStatus(String str) {
        return MediaDownloadEngine.getInstance().getDownloadingFromMap(this.mContext, str);
    }

    @Override // io.rong.imlib.IHandler
    public int getGIFLimitSize() {
        return this.mClient.getGIFLimitSize();
    }

    @Override // io.rong.imlib.IHandler
    public boolean getJoinMultiChatRoomEnable() {
        try {
            return NavigationCacheHelper.isJoinMChatroomEnabled(this.mContext);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getMatchedMessages(String str, int i, long j, int i2, int i3) {
        try {
            return this.mClient.getMatchedMessages(str, Conversation.ConversationType.setValue(i), j, i2, i3);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public Message getMessage(int i) {
        try {
            return this.mClient.getMessage(i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public Message getMessageByUid(String str) {
        try {
            return this.mClient.getMessageByUid(str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getMessageCount(int i, String str) {
        try {
            Conversation.ConversationType value = Conversation.ConversationType.setValue(i);
            if (value != null && str != null) {
                return this.mClient.getMessageCount(value, str);
            }
            return 0;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public long getNaviCachedTime() {
        try {
            return NavigationCacheHelper.getCachedTime();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getNewestMessages(Conversation conversation, int i) {
        try {
            return this.mClient.getLatestMessages(conversation.getConversationType(), conversation.getTargetId(), i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getNotificationQuietHours(final IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback) {
        try {
            this.mClient.getNotificationQuietHours(new NativeClient.GetNotificationQuietHoursCallback() { // from class: io.rong.imlib.LibHandlerStub.31
                @Override // io.rong.imlib.NativeClient.GetNotificationQuietHoursCallback
                public void onError(int i) {
                    IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback2 = iGetNotificationQuietHoursCallback;
                    if (iGetNotificationQuietHoursCallback2 != null) {
                        try {
                            iGetNotificationQuietHoursCallback2.onError(i);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.GetNotificationQuietHoursCallback
                public void onSuccess(String str, int i) {
                    IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback2 = iGetNotificationQuietHoursCallback;
                    if (iGetNotificationQuietHoursCallback2 != null) {
                        try {
                            iGetNotificationQuietHoursCallback2.onSuccess(str, i);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getOffLineLogServer() throws RemoteException {
        try {
            return this.mClient.getOffLineLogServer();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getOfflineMessageDuration() {
        try {
            return this.mClient.getOfflineMessageDuration();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getOlderMessages(Conversation conversation, long j, int i) {
        try {
            return this.mClient.getHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), (int) j, i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getOlderMessagesByObjectName(Conversation conversation, String str, long j, int i, boolean z) {
        try {
            List<Message> historyMessages = this.mClient.getHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), str, (int) j, i, z);
            if (historyMessages == null || historyMessages.size() == 0) {
                return null;
            }
            return historyMessages;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getOlderMessagesByObjectNames(Conversation conversation, List<String> list, long j, int i, boolean z) {
        try {
            List<Message> historyMessages = this.mClient.getHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), list, j, i, z);
            if (historyMessages == null || historyMessages.size() == 0) {
                return null;
            }
            return historyMessages;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getOlderMessagesOneWay(Conversation conversation, long j, int i, OnGetHistoryMessagesCallback onGetHistoryMessagesCallback) {
        try {
            try {
                onGetHistoryMessagesCallback.onComplete(new RemoteModelWrap(RongListWrap.obtain(this.mClient.getHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), (int) j, i), Message.class)));
            } catch (RemoteException e2) {
                RLog.e(TAG, "getOlderMessages", e2);
            }
        } catch (RuntimeException e3) {
            handleRuntimeException(e3);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getPublicServiceList(final IResultCallback iResultCallback) {
        try {
            this.mClient.getPublicServiceList(new NativeClient.IResultCallback<PublicServiceProfileList>() { // from class: io.rong.imlib.LibHandlerStub.23
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(PublicServiceProfileList publicServiceProfileList) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(new RemoteModelWrap(publicServiceProfileList));
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getPublicServiceProfile(String str, int i, final IResultCallback iResultCallback) {
        try {
            this.mClient.getPublicServiceProfile(str, i, new NativeClient.IResultCallback<PublicServiceProfile>() { // from class: io.rong.imlib.LibHandlerStub.22
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(PublicServiceProfile publicServiceProfile) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(publicServiceProfile != null ? new RemoteModelWrap(publicServiceProfile) : null);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getPushSetting(int i) {
        try {
            return this.mClient.getPushSetting(i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRTCConfig(String str, String str2, long j, String str3, final IRTCConfigCallback iRTCConfigCallback) throws RemoteException {
        this.mClient.getRTCConfig(str, str2, j, str3, new NativeObject.RTCConfigListener() { // from class: io.rong.imlib.LibHandlerStub.59
            @Override // io.rong.imlib.NativeObject.RTCConfigListener
            public void onError(int i) {
                try {
                    iRTCConfigCallback.onError(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    RLog.e(LibHandlerStub.TAG, e2.toString());
                }
            }

            @Override // io.rong.imlib.NativeObject.RTCConfigListener
            public void onSuccess(String str4, long j2) {
                try {
                    iRTCConfigCallback.onSuccess(str4, j2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    RLog.e(LibHandlerStub.TAG, e2.toString());
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public String getRTCProfile() {
        try {
            return this.mClient.getRTCProfile();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRTCToken(String str, int i, int i2, final IStringCallback iStringCallback) {
        try {
            this.mClient.getRTCToken(str, i, i2, new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.60
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i3) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str2) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onComplete(str2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRTCUserData(String str, int i, final RTCDataListener rTCDataListener) {
        try {
            this.mClient.getRTCUserData(str, i, new NativeClient.IResultCallback<List<RTCUser>>() { // from class: io.rong.imlib.LibHandlerStub.55
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    try {
                        rTCDataListener.OnError(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(List<RTCUser> list) {
                    try {
                        rTCDataListener.OnSuccess(list);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRTCUserDatas(String str, String[] strArr, final RTCDataListener rTCDataListener) throws RemoteException {
        try {
            this.mClient.getRTCUserDatas(str, strArr, new NativeClient.IResultCallback<List<RTCUser>>() { // from class: io.rong.imlib.LibHandlerStub.64
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    try {
                        rTCDataListener.OnError(i);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(List<RTCUser> list) {
                    try {
                        rTCDataListener.OnSuccess(list);
                    } catch (Exception e2) {
                        io.rong.common.RLog.e(LibHandlerStub.TAG, "getRTCUserDatas onSuccess", e2);
                    }
                }
            });
        } catch (Exception e2) {
            RLog.e(TAG, "getRTCUserDatas - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRTCUsers(String str, int i, final RTCDataListener rTCDataListener) {
        try {
            this.mClient.getRTCUsers(str, i, new NativeClient.IResultCallback<List<RTCUser>>() { // from class: io.rong.imlib.LibHandlerStub.54
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    try {
                        rTCDataListener.OnError(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(List<RTCUser> list) {
                    try {
                        rTCDataListener.OnSuccess(list);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRemoteHistoryMessages(Conversation conversation, long j, int i, final IResultCallback iResultCallback) {
        try {
            this.mClient.getRemoteHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), j, i, new NativeClient.IResultCallback<List<Message>>() { // from class: io.rong.imlib.LibHandlerStub.14
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(List<Message> list) {
                    if (iResultCallback != null) {
                        if (list != null) {
                            try {
                                if (list.size() == 0) {
                                    iResultCallback.onComplete(null);
                                } else {
                                    iResultCallback.onComplete(new RemoteModelWrap(RongListWrap.obtain(list, Message.class)));
                                }
                            } catch (RemoteException e2) {
                                LibHandlerStub.this.handleRemoteException(e2);
                            }
                        } else {
                            iResultCallback.onComplete(null);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getRemoteHistoryMessagesOption(Conversation conversation, RemoteHistoryMsgOption remoteHistoryMsgOption, final IResultCallback iResultCallback) throws RemoteException {
        try {
            this.mClient.getRemoteHistoryMessages(conversation.getConversationType(), conversation.getTargetId(), remoteHistoryMsgOption, new NativeClient.IResultCallback<List<Message>>() { // from class: io.rong.imlib.LibHandlerStub.15
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(List<Message> list) {
                    if (iResultCallback != null) {
                        if (list != null) {
                            try {
                                if (list.size() == 0) {
                                    iResultCallback.onComplete(null);
                                } else {
                                    iResultCallback.onComplete(new RemoteModelWrap(RongListWrap.obtain(list, Message.class)));
                                }
                            } catch (RemoteException e2) {
                                LibHandlerStub.this.handleRemoteException(e2);
                            }
                        } else {
                            iResultCallback.onComplete(null);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public long getSendTimeByMessageId(int i) {
        try {
            return this.mClient.getSendTimeByMessageId(i);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getTextMessageDraft(Conversation conversation) {
        try {
            return this.mClient.getTextMessageDraft(conversation.getConversationType(), conversation.getTargetId());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public Message getTheFirstUnreadMessage(int i, String str) {
        return this.mClient.getTheFirstUnreadMessage(i, str);
    }

    @Override // io.rong.imlib.IHandler
    public void getTopConversationList(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        if (iGetConversationListWithProcessCallback == null) {
            return;
        }
        try {
            processConversationList(this.mClient.getTopConversationList(iArr), i, iGetConversationListWithProcessCallback);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getTotalUnreadCount() {
        try {
            return this.mClient.getTotalUnreadCount();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getUnreadCount(int[] iArr) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    Conversation.ConversationType[] conversationTypeArr = new Conversation.ConversationType[iArr.length];
                    for (int i = 0; i < iArr.length; i++) {
                        conversationTypeArr[i] = Conversation.ConversationType.setValue(iArr[i]);
                    }
                    return this.mClient.getUnreadCount(conversationTypeArr);
                }
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
        return 0;
    }

    @Override // io.rong.imlib.IHandler
    public int getUnreadCountByConversation(Conversation[] conversationArr) {
        try {
            return this.mClient.getTotalUnreadCount(conversationArr);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getUnreadCountById(int i, String str) {
        try {
            Conversation.ConversationType value = Conversation.ConversationType.setValue(i);
            if (value != null && str != null) {
                return this.mClient.getUnreadCount(value, str);
            }
            return 0;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getUnreadCountWithDND(int[] iArr, boolean z) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    Conversation.ConversationType[] conversationTypeArr = new Conversation.ConversationType[iArr.length];
                    for (int i = 0; i < iArr.length; i++) {
                        conversationTypeArr[i] = Conversation.ConversationType.setValue(iArr[i]);
                    }
                    return this.mClient.getUnreadCount(z, conversationTypeArr);
                }
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
        return 0;
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> getUnreadMentionedMessages(int i, String str) {
        try {
            List<Message> unreadMentionedMessages = this.mClient.getUnreadMentionedMessages(Conversation.ConversationType.setValue(i), str);
            if (unreadMentionedMessages == null || unreadMentionedMessages.size() == 0) {
                return null;
            }
            return unreadMentionedMessages;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public String getUploadLogConfigInfo() throws RemoteException {
        try {
            return this.mClient.getUploadConfigInfo();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getUserStatus(String str, final IGetUserStatusCallback iGetUserStatusCallback) {
        try {
            this.mClient.getUserStatus(str, new NativeClient.IResultCallbackEx<String, Integer>() { // from class: io.rong.imlib.LibHandlerStub.9
                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onError(int i) {
                    IGetUserStatusCallback iGetUserStatusCallback2 = iGetUserStatusCallback;
                    if (iGetUserStatusCallback2 != null) {
                        try {
                            iGetUserStatusCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onSuccess(String str2, Integer num) {
                    IGetUserStatusCallback iGetUserStatusCallback2 = iGetUserStatusCallback;
                    if (iGetUserStatusCallback2 != null) {
                        try {
                            iGetUserStatusCallback2.onComplete(str2, num.intValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getVendorToken(final IStringCallback iStringCallback) {
        try {
            this.mClient.getVendorToken(new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.50
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onComplete(str);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public int getVideoLimitTime() {
        return this.mClient.getVideoLimitTime();
    }

    @Override // io.rong.imlib.IHandler
    public String getVoIPCallInfo() {
        try {
            return this.mClient.getVoIPCallInfo();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void getVoIPKey(int i, String str, String str2, final IStringCallback iStringCallback) {
        try {
            this.mClient.getVoIPKey(i, str, str2, new NativeClient.IResultCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.47
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(String str3) {
                    IStringCallback iStringCallback2 = iStringCallback;
                    if (iStringCallback2 != null) {
                        try {
                            iStringCallback2.onComplete(str3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void initAppendixModule() {
        this.mClient.initAppendixModule();
    }

    @Override // io.rong.imlib.IHandler
    public void initHttpDns() {
        try {
            this.mClient.initHttpDns();
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void initIPCEnviroment(String str, int i) {
        this.mClient.initIPCEnviroment(str, i);
    }

    @Override // io.rong.imlib.IHandler
    public Message insertMessage(Message message) {
        try {
            return this.mClient.insertMessage(message.getConversationType(), message.getTargetId(), message.getSenderUserId(), message.getContent(), message.getSentTime());
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public Message insertSettingMessage(Message message) {
        try {
            return this.mClient.insertSettingMessage(message);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean isDnsEnabled() throws RemoteException {
        return this.mClient.isDnsEnabled();
    }

    @Override // io.rong.imlib.IHandler
    public boolean isPhrasesEnabled() {
        return this.mClient.isPhrasesEnabled();
    }

    @Override // io.rong.imlib.IHandler
    public void joinChatRoom(final String str, int i, final IOperationCallback iOperationCallback) {
        try {
            FwLog.write(3, 1, FwLog.LogTag.L_JOIN_CHATROOM_T.getTag(), "room_id|existed", str, false);
            this.mClient.joinChatRoom(str, i, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.25
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    FwLog.write(1, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(i2), str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    FwLog.write(3, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", 0, str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void joinExistChatRoom(final String str, int i, final IOperationCallback iOperationCallback, boolean z) {
        FwLog.write(3, 1, FwLog.LogTag.L_JOIN_CHATROOM_T.getTag(), "room_id|existed", str, true);
        try {
            this.mClient.joinExistChatRoom(str, i, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.27
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    FwLog.write(1, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(i2), str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    FwLog.write(3, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", 0, str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            }, z);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void joinGroup(String str, String str2, IOperationCallback iOperationCallback) {
        try {
            this.mClient.joinGroup(str, str2, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void joinRTCRoomAndGetData(String str, int i, int i2, final IRTCJoinRoomCallback iRTCJoinRoomCallback) {
        try {
            this.mClient.joinRTCRoomAndGetData(str, i, i2, new NativeClient.IResultCallbackEx<List<RTCUser>, String[]>() { // from class: io.rong.imlib.LibHandlerStub.58
                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onError(int i3) {
                    try {
                        iRTCJoinRoomCallback.OnError(i3);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onSuccess(List<RTCUser> list, String[] strArr) {
                    try {
                        iRTCJoinRoomCallback.OnSuccess(list, strArr[0], strArr[1]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void notifyAppBackgroundChanged(boolean z) throws RemoteException {
        RtLogUploadManager.getInstance().setIsBackgroundMode(z);
        HeartBeatManager.getInstance().setIsBackgroundMode(this.mContext, z);
    }

    @Override // io.rong.imlib.IHandler
    public void pauseTransferMediaFile(String str, final IOperationCallback iOperationCallback) throws RemoteException {
        MediaDownloadEngine.getInstance().pause(str, new PauseCallback() { // from class: io.rong.imlib.LibHandlerStub.39
            @Override // io.rong.imlib.filetransfer.PauseCallback
            public void onError(int i) {
                try {
                    iOperationCallback.onFailure(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // io.rong.imlib.filetransfer.PauseCallback
            public void onPaused(Object obj) {
                try {
                    iOperationCallback.onComplete();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public void pauseTransferMediaMessage(Message message, final IOperationCallback iOperationCallback) throws RemoteException {
        MediaDownloadEngine.getInstance().pause(message.getMessageId(), new PauseCallback() { // from class: io.rong.imlib.LibHandlerStub.38
            @Override // io.rong.imlib.filetransfer.PauseCallback
            public void onError(int i) {
                try {
                    iOperationCallback.onFailure(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // io.rong.imlib.filetransfer.PauseCallback
            public void onPaused(Object obj) {
                try {
                    iOperationCallback.onComplete();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public void quitChatRoom(final String str, final IOperationCallback iOperationCallback) {
        FwLog.write(3, 1, FwLog.LogTag.L_QUIT_CHATROOM_T.getTag(), "room_id", str);
        try {
            this.mClient.quitChatRoom(str, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.28
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i) {
                    FwLog.write(1, 1, FwLog.LogTag.L_QUIT_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(i), str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    FwLog.write(3, 1, FwLog.LogTag.L_QUIT_CHATROOM_R.getTag(), "code|room_id", 0, str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void quitDiscussion(String str, IOperationCallback iOperationCallback) {
        try {
            this.mClient.quitDiscussion(str, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void quitGroup(String str, IOperationCallback iOperationCallback) {
        try {
            this.mClient.quitGroup(str, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void reJoinChatRoom(final String str, int i, final IOperationCallback iOperationCallback) {
        FwLog.write(3, 1, FwLog.LogTag.L_REJOIN_CHATROOM_T.getTag(), "room_id", str);
        try {
            this.mClient.reJoinChatRoom(str, i, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.26
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    FwLog.write(1, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", Integer.valueOf(i2), str);
                    RLog.e(LibHandlerStub.TAG, "reJoinChatRoom " + i2);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    FwLog.write(3, 1, FwLog.LogTag.L_JOIN_CHATROOM_R.getTag(), "code|room_id", 0, str);
                    RLog.d(LibHandlerStub.TAG, "reJoinChatRoom " + str);
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void recallMessage(String str, byte[] bArr, String str2, int i, String str3, int i2, boolean z, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.recallMessage(str, bArr, str2, i, str3, i2, z, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.41
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i3) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void registerCmdMsgType(String str) {
        try {
            this.mClient.registerCmdMsgType(str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void registerCmdMsgTypes(List<String> list) throws RemoteException {
        try {
            this.mClient.registerCmdMsgType(list);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void registerDeleteMessageType(List<String> list) {
        try {
            this.mClient.registerDeleteMessageType(list);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.rong.imlib.IHandler
    public void registerMessageType(String str) {
        try {
            this.mClient.registerMessageType((Class<? extends MessageContent>) Class.forName(str));
        } catch (Exception e2) {
            FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "class_name", str);
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            RLog.e(TAG, "registerMessageType Exception :\n" + stringWriter.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void registerMessageTypes(List<String> list) throws RemoteException {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Class.forName(it.next()));
                }
                this.mClient.registerMessageType(arrayList);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next());
                    sb.append(",");
                }
                FwLog.write(1, 1, FwLog.LogTag.L_REGTYPE_E.getTag(), "class_names", sb.toString());
                StringWriter stringWriter = new StringWriter();
                e2.printStackTrace(new PrintWriter(stringWriter));
                RLog.e(TAG, "registerMessageTypeList Exception :\n" + stringWriter.toString());
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean removeConversation(int i, String str) {
        try {
            Conversation.ConversationType value = Conversation.ConversationType.setValue(i);
            if (value != null) {
                return this.mClient.removeConversation(value, str);
            }
            RLog.i(TAG, "removeConversation the conversation type is null");
            return false;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void removeDiscussionMember(String str, String str2, IOperationCallback iOperationCallback) {
        try {
            this.mClient.removeMemberFromDiscussion(str, str2, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean removeEncryptedConversation(String str) {
        return this.mClient.removeEncryptedConversation(str);
    }

    @Override // io.rong.imlib.IHandler
    public void removeFromBlacklist(String str, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.removeFromBlacklist(str, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.43
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void removeMessageAllExpansion(String str, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.removeMessageAllExpansion(str, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void removeMessageExpansion(List<String> list, String str, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.removeMessageExpansion(list, str, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void removeNotificationQuietHours(final IOperationCallback iOperationCallback) {
        try {
            this.mClient.removeNotificationQuietHours(new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.30
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcDeleteInnerData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) {
        try {
            this.mClient.rtcDeleteInnerData(str, i, strArr, str2, str3, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "rtcDeleteInnerData - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcDeleteOuterData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) {
        try {
            this.mClient.rtcDeleteOuterData(str, i, strArr, str2, str3, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "rtcDeleteOuterData - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcGetInnerData(String str, int i, String[] strArr, final IRtcIODataListener iRtcIODataListener) {
        try {
            this.mClient.rtcGetInnerData(str, i, strArr, new NativeClient.IResultCallback<Map<String, String>>() { // from class: io.rong.imlib.LibHandlerStub.56
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    try {
                        iRtcIODataListener.OnError(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Map<String, String> map) {
                    try {
                        iRtcIODataListener.OnSuccess(map);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }
            });
        } catch (Exception e2) {
            RLog.e(TAG, "rtcGetInnerData - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcGetOuterData(String str, int i, String[] strArr, final IRtcIODataListener iRtcIODataListener) {
        try {
            this.mClient.rtcGetOuterData(str, i, strArr, new NativeClient.IResultCallback<Map<String, String>>() { // from class: io.rong.imlib.LibHandlerStub.57
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    try {
                        iRtcIODataListener.OnError(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Map<String, String> map) {
                    try {
                        iRtcIODataListener.OnSuccess(map);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        RLog.e(LibHandlerStub.TAG, e2.toString());
                    }
                }
            });
        } catch (Exception e2) {
            RLog.e(TAG, "rtcGetOuterData - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcPutInnerData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) {
        try {
            this.mClient.rtcPutInnerData(str, i, str2, str3, str4, str5, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "rtcPutInnerDatum - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcPutOuterData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) {
        try {
            this.mClient.rtcPutOuterData(str, i, str2, str3, str4, str5, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "rtcPutOuterDatum - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void rtcSetUserResource(String str, RTCStatusDate[] rTCStatusDateArr, String str2, RTCStatusDate[] rTCStatusDateArr2, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.rtcSetUserResource(str, rTCStatusDateArr, str2, rTCStatusDateArr2, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, "RTCSetUserResource - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean saveConversationDraft(Conversation conversation, String str) {
        try {
            RLog.i(TAG, "saveConversationDraft " + str);
            return this.mClient.saveTextMessageDraft(conversation.getConversationType(), conversation.getTargetId(), str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean saveTextMessageDraft(Conversation conversation, String str) {
        try {
            return this.mClient.saveTextMessageDraft(conversation.getConversationType(), conversation.getTargetId(), str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<SearchConversationResult> searchConversations(String str, int[] iArr, String[] strArr) {
        try {
            return this.mClient.searchConversations(str, iArr, strArr);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> searchMessages(String str, int i, String str2, int i2, long j) {
        try {
            return this.mClient.searchMessages(str, Conversation.ConversationType.setValue(i), str2, i2, j);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public List<Message> searchMessagesByUser(String str, int i, String str2, int i2, long j) {
        try {
            return this.mClient.searchMessagesByUser(str, Conversation.ConversationType.setValue(i), str2, i2, j);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void searchPublicService(String str, int i, int i2, final IResultCallback iResultCallback) {
        try {
            this.mClient.searchPublicService(str, i, i2, new NativeClient.IResultCallback<PublicServiceProfileList>() { // from class: io.rong.imlib.LibHandlerStub.20
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i3) {
                    IResultCallback iResultCallback2 = iResultCallback;
                    if (iResultCallback2 != null) {
                        try {
                            iResultCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(PublicServiceProfileList publicServiceProfileList) {
                    if (iResultCallback != null) {
                        try {
                            iResultCallback.onComplete(new RemoteModelWrap(publicServiceProfileList));
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, final ISendMediaMessageCallback iSendMediaMessageCallback) {
        try {
            this.mClient.sendMediaMessage(message, strArr, str, str2, new NativeClient.ISendMediaMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.49
                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onAttached(Message message2) {
                    try {
                        if (iSendMediaMessageCallback != null) {
                            iSendMediaMessageCallback.onAttached(message2);
                        }
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onCanceled(Message message2) {
                    try {
                        if (iSendMediaMessageCallback != null) {
                            iSendMediaMessageCallback.onCanceled(message2);
                        }
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onError(Message message2, int i) {
                    try {
                        if (iSendMediaMessageCallback != null) {
                            iSendMediaMessageCallback.onError(message2, i);
                        }
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onProgress(Message message2, int i) {
                    try {
                        if (iSendMediaMessageCallback != null) {
                            iSendMediaMessageCallback.onProgress(message2, i);
                        }
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onSuccess(Message message2) {
                    try {
                        if (iSendMediaMessageCallback != null) {
                            iSendMediaMessageCallback.onSuccess(message2);
                        }
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendDirectionalMessage(Message message, String str, String str2, String[] strArr, final ISendMessageCallback iSendMessageCallback) {
        try {
            this.mClient.sendMessage(message, str, str2, strArr, new NativeClient.ISendMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.6
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendLocationMessage(Message message, String str, String str2, final ISendMessageCallback iSendMessageCallback) {
        try {
            this.mClient.sendLocationMessage(message, str, str2, new NativeClient.ISendMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.7
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendMediaMessage(Message message, String str, String str2, final ISendMediaMessageCallback iSendMediaMessageCallback) {
        try {
            this.mClient.sendMediaMessage(message, str, str2, new NativeClient.ISendMediaMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.48
                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onAttached(Message message2) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        try {
                            iSendMediaMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onCanceled(Message message2) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        try {
                            iSendMediaMessageCallback2.onCanceled(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onError(Message message2, int i) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        try {
                            iSendMediaMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onProgress(Message message2, int i) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        try {
                            iSendMediaMessageCallback2.onProgress(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMediaMessageCallback
                public void onSuccess(Message message2) {
                    ISendMediaMessageCallback iSendMediaMessageCallback2 = iSendMediaMessageCallback;
                    if (iSendMediaMessageCallback2 != null) {
                        try {
                            iSendMediaMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendMessage(Message message, String str, String str2, final ISendMessageCallback iSendMessageCallback) {
        try {
            this.mClient.sendMessage(message, str, str2, null, new NativeClient.ISendMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.4
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, final ISendMessageCallback iSendMessageCallback) throws RemoteException {
        try {
            this.mClient.sendMessageOption(message, str, str2, sendMessageOption, null, new NativeClient.ISendMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.5
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendPing() {
        try {
            HeartBeatManager.getInstance().ping(this.mContext);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendRTCDirectionalMessage(Message message, String str, String str2, String[] strArr, SendMessageOption sendMessageOption, boolean z, final ISendMessageCallback iSendMessageCallback) throws RemoteException {
        try {
            this.mClient.sendMessageOption(message, str, str2, sendMessageOption, strArr, z, new NativeClient.ISendMessageCallback<Message>() { // from class: io.rong.imlib.LibHandlerStub.65
                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onAttached(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onAttached(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onError(Message message2, int i) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onError(message2, i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.ISendMessageCallback
                public void onSuccess(Message message2) {
                    ISendMessageCallback iSendMessageCallback2 = iSendMessageCallback;
                    if (iSendMessageCallback2 != null) {
                        try {
                            iSendMessageCallback2.onSuccess(message2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void sendRTCPing(String str, IOperationCallback iOperationCallback) {
        try {
            this.mClient.sendRTCPing(str, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "SendRTCPing - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.setChatRoomEntry(str, str2, str3, Boolean.valueOf(z), str4, z2, z3, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            RLog.e(TAG, "setChatRoomEntry - " + e2.toString());
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setConnectionStatusListener(final IConnectionStatusListener iConnectionStatusListener) {
        try {
            this.mClient.setConnectionStatusListener(new NativeClient.ICodeListener() { // from class: io.rong.imlib.LibHandlerStub.2
                @Override // io.rong.imlib.NativeClient.ICodeListener
                public void onChanged(int i) {
                    RLog.d(LibHandlerStub.TAG, "[connect] onChanged status:" + i);
                    if (!LibHandlerStub.this.mCancelSDKHeartbeat) {
                        HeartBeatManager.getInstance().replenishPing(LibHandlerStub.this.mContext, i);
                    }
                    IConnectionStatusListener iConnectionStatusListener2 = iConnectionStatusListener;
                    if (iConnectionStatusListener2 != null) {
                        try {
                            iConnectionStatusListener2.onChanged(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setConversationNotificationStatus(int i, String str, int i2, final ILongCallback iLongCallback) {
        try {
            this.mClient.setConversationNotificationStatus(Conversation.ConversationType.setValue(i), str, Conversation.ConversationNotificationStatus.setValue(i2), new NativeClient.IResultCallback<Integer>() { // from class: io.rong.imlib.LibHandlerStub.17
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i3) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onFailure(i3);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Integer num) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onComplete(num.intValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setConversationStatusListener(final ConversationStatusListener conversationStatusListener) {
        if (conversationStatusListener != null) {
            try {
                this.mClient.setConversationStatusListener(new NativeObject.ConversationStatusListener() { // from class: io.rong.imlib.LibHandlerStub.53
                    @Override // io.rong.imlib.NativeObject.ConversationStatusListener
                    public void OnStatusChanged(ConversationStatus[] conversationStatusArr) {
                        try {
                            conversationStatusListener.OnStatusChanged(conversationStatusArr);
                        } catch (RemoteException e2) {
                            RLog.e(LibHandlerStub.TAG, e2.toString());
                        }
                    }
                });
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setConversationTopStatus(int i, String str, boolean z, boolean z2) {
        try {
            Conversation.ConversationType value = Conversation.ConversationType.setValue(i);
            if (value != null) {
                return this.mClient.setConversationToTop(value, str, z, z2);
            }
            RLog.e(TAG, "setConversationTopStatus ConversationType is null");
            return false;
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setDiscussionInviteStatus(String str, int i, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.setDiscussionInviteStatus(str, i, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.40
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setDiscussionName(String str, String str2, IOperationCallback iOperationCallback) {
        try {
            this.mClient.setDiscussionName(str, str2, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) {
        return this.mClient.setEncryptedConversation(str, rCEncryptedSession);
    }

    @Override // io.rong.imlib.IHandler
    public void setIpcConnectTimeOut() {
        this.mClient.setIpcConnectTimeOut();
    }

    @Override // io.rong.imlib.IHandler
    public void setKvStatusListener(final KVStatusDataByBatchListener kVStatusDataByBatchListener) throws RemoteException {
        this.mClient.setKVStatusListener(new NativeClient.KVStatusListener() { // from class: io.rong.imlib.LibHandlerStub.69
            @Override // io.rong.imlib.NativeClient.KVStatusListener
            public void onChatRoomKVStatusChange(String str, Map<String, String> map) {
                if (kVStatusDataByBatchListener != null) {
                    try {
                        HashMap map2 = new HashMap();
                        if (map != null && map.size() > 0) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                map2.put(entry.getKey(), entry.getValue());
                                if (map2.size() % 50 == 0) {
                                    kVStatusDataByBatchListener.onProgressDataChange(map2);
                                    map2.clear();
                                }
                            }
                            if (map2.size() > 0) {
                                kVStatusDataByBatchListener.onProgressDataChange(map2);
                                map2.clear();
                            }
                        }
                        kVStatusDataByBatchListener.onCompleteDataChange(str);
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "setKvStatusListener StatusDidChange Exception ", e2);
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }

            @Override // io.rong.imlib.NativeClient.KVStatusListener
            public void onChatRoomKVStatusRemove(String str, Map<String, String> map) {
                if (kVStatusDataByBatchListener != null) {
                    try {
                        HashMap map2 = new HashMap();
                        if (map != null && map.size() > 0) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                map2.put(entry.getKey(), entry.getValue());
                                if (map2.size() % 50 == 0) {
                                    kVStatusDataByBatchListener.onProgressDataRemove(map2);
                                    map2.clear();
                                }
                            }
                            if (map2.size() > 0) {
                                kVStatusDataByBatchListener.onProgressDataRemove(map2);
                                map2.clear();
                            }
                        }
                        kVStatusDataByBatchListener.onCompleteDataRemove(str);
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "setKvStatusListener StatusDidRemove Exception ", e2);
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }
            }

            @Override // io.rong.imlib.NativeClient.KVStatusListener
            public void onChatRoomKVStatusSync(String str) {
                KVStatusDataByBatchListener kVStatusDataByBatchListener2 = kVStatusDataByBatchListener;
                if (kVStatusDataByBatchListener2 != null) {
                    try {
                        kVStatusDataByBatchListener2.onDataSync(str);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public boolean setMessageContent(int i, byte[] bArr, String str) {
        try {
            return this.mClient.setMessageContent(i, bArr, str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setMessageExpansionListener(IMessageExpansionListener iMessageExpansionListener) throws RemoteException {
        if (iMessageExpansionListener != null) {
            try {
                this.mClient.setMessageExpansionListener(iMessageExpansionListener);
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setMessageExtra(int i, String str) {
        try {
            return this.mClient.setMessageExtra(i, str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setMessageReadTime(long j, long j2) {
        try {
            return this.mClient.setMessageReadTime(j, j2);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setMessageReceivedStatus(int i, int i2) {
        try {
            return this.mClient.setMessageReceivedStatus(i, new Message.ReceivedStatus(i2));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean setMessageSentStatus(int i, int i2) {
        try {
            return this.mClient.setMessageSentStatus(i, Message.SentStatus.setValue(i2));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setNaviContentUpdateListener(final INaviContentUpdateCallBack iNaviContentUpdateCallBack) throws RemoteException {
        this.mClient.setNaviContentUpdateListener(new NavigationClient.NaviUpdateListener() { // from class: io.rong.imlib.LibHandlerStub.68
            @Override // io.rong.imlib.navigation.NavigationClient.NaviUpdateListener
            public void onNaviUpdate() {
                try {
                    iNaviContentUpdateCallBack.naviContentUpdate();
                } catch (RemoteException e2) {
                    LibHandlerStub.this.handleRemoteException(e2);
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public void setNotificationQuietHours(String str, int i, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.setNotificationQuietHours(str, i, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.29
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setOfflineMessageDuration(String str, final ILongCallback iLongCallback) {
        try {
            this.mClient.setOfflineMessageDuration(str, new NativeClient.IResultCallback<Long>() { // from class: io.rong.imlib.LibHandlerStub.51
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Long l) {
                    ILongCallback iLongCallback2 = iLongCallback;
                    if (iLongCallback2 != null) {
                        try {
                            iLongCallback2.onComplete(l.longValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setOnReceiveMessageListener(final OnReceiveMessageListener onReceiveMessageListener) {
        if (onReceiveMessageListener != null) {
            try {
                this.mClient.setOnReceiveMessageListener(new NativeClient.OnReceiveMessageListener() { // from class: io.rong.imlib.LibHandlerStub.3
                    @Override // io.rong.imlib.NativeClient.OnReceiveMessageListener
                    public void onReceived(Message message, int i, boolean z, boolean z2, int i2) {
                        try {
                            onReceiveMessageListener.onReceived(message, i, z, z2, i2);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setPushSetting(int i, String str, final ISetPushSettingCallback iSetPushSettingCallback) {
        try {
            this.mClient.setPushSetting(i, str, new NativeClient.IResultCallback<Long>() { // from class: io.rong.imlib.LibHandlerStub.12
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    try {
                        iSetPushSettingCallback.onFailure(i2);
                    } catch (RemoteException e2) {
                        LibHandlerStub.this.handleRemoteException(e2);
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Long l) {
                    ISetPushSettingCallback iSetPushSettingCallback2 = iSetPushSettingCallback;
                    if (iSetPushSettingCallback2 != null) {
                        try {
                            iSetPushSettingCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setRLogOtherProgressCallback(final IRLogOtherProgressCallback iRLogOtherProgressCallback) throws RemoteException {
        try {
            RLog.setRlogOtherProgressCallBack(new RLog.IRlogOtherProgressCallback() { // from class: io.rong.imlib.LibHandlerStub.61
                @Override // io.rong.common.rlog.RLog.IRlogOtherProgressCallback
                public void setLogLevel(int i) {
                    try {
                        iRLogOtherProgressCallback.setLogLevel(i);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // io.rong.common.rlog.RLog.IRlogOtherProgressCallback
                public void uploadRLog() {
                    try {
                        iRLogOtherProgressCallback.uploadRLog();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // io.rong.common.rlog.RLog.IRlogOtherProgressCallback
                public void write(String str, int i) {
                    try {
                        iRLogOtherProgressCallback.write(str, i);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setRTCUserData(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.setRTCUserState(str, str2, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "setRTCUserData - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setRTCUserDatas(String str, int i, Map map, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.setRTCUserData(str, i, map, str2, str3, new OperationCallback(iOperationCallback));
        } catch (Exception e2) {
            RLog.e(TAG, "setRTCUserDatas - " + e2.toString());
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setReconnectKickEnable(boolean z) {
        this.mClient.setReconnectKickEnable(z);
    }

    @Override // io.rong.imlib.IHandler
    public void setServerInfo(String str, String str2) {
        try {
            this.mClient.setServerInfo(str, str2);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setSubscribeStatusListener(final ISubscribeUserStatusCallback iSubscribeUserStatusCallback) {
        try {
            this.mClient.setSubscribeStatusListener(new NativeClient.IResultCallbackEx<String, String>() { // from class: io.rong.imlib.LibHandlerStub.11
                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onError(int i) {
                }

                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onSuccess(String str, String str2) {
                    ISubscribeUserStatusCallback iSubscribeUserStatusCallback2 = iSubscribeUserStatusCallback;
                    if (iSubscribeUserStatusCallback2 != null) {
                        try {
                            iSubscribeUserStatusCallback2.onStatusReceived(str, str2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setUserData(UserData userData, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.setUserData(userData, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.46
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setUserPolicy(boolean z) {
        try {
            NavigationCacheHelper.setUserPolicy(z);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setUserProfileListener(final UserProfileSettingListener userProfileSettingListener) {
        if (userProfileSettingListener != null) {
            try {
                this.mClient.SetPushNotificationListener(new NativeClient.PushNotificationListener() { // from class: io.rong.imlib.LibHandlerStub.52
                    @Override // io.rong.imlib.NativeClient.PushNotificationListener
                    public void OnPushNotificationChanged(long j) {
                        try {
                            userProfileSettingListener.OnPushNotificationChanged(j);
                            LibHandlerStub.this.updateRTCProfile();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (RuntimeException e2) {
                handleRuntimeException(e2);
                throw null;
            }
        }
    }

    @Override // io.rong.imlib.IHandler
    public void setUserStatus(int i, final ISetUserStatusCallback iSetUserStatusCallback) {
        try {
            this.mClient.setUserStatus(i, new NativeClient.IResultCallback<Integer>() { // from class: io.rong.imlib.LibHandlerStub.13
                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onError(int i2) {
                    ISetUserStatusCallback iSetUserStatusCallback2 = iSetUserStatusCallback;
                    if (iSetUserStatusCallback2 != null) {
                        try {
                            iSetUserStatusCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallback
                public void onSuccess(Integer num) {
                    ISetUserStatusCallback iSetUserStatusCallback2 = iSetUserStatusCallback;
                    if (iSetUserStatusCallback2 != null) {
                        try {
                            iSetUserStatusCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void solveServerHosts(String str, final ISolveServerHostsCallBack iSolveServerHostsCallBack) throws RemoteException {
        HttpDnsManager.getInstance().asyncSolveDnsIp(this.mContext, str, new RongHttpDns.CompletionHandler() { // from class: io.rong.imlib.LibHandlerStub.62
            @Override // io.rong.imlib.httpdns.RongHttpDns.CompletionHandler
            public void completionHandler(RongHttpDnsResult rongHttpDnsResult) {
                if (rongHttpDnsResult.getResolveStatus() == RongHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    try {
                        if (iSolveServerHostsCallBack != null) {
                            iSolveServerHostsCallBack.onSuccess(rongHttpDnsResult.getIpv4List());
                        }
                    } catch (RemoteException e2) {
                        RLog.e(LibHandlerStub.TAG, "solveServerHosts:" + e2);
                    }
                }
            }
        }, new HttpDnsCompletion(this.mContext) { // from class: io.rong.imlib.LibHandlerStub.63
            @Override // io.rong.imlib.httpdns.HttpDnsCompletion
            protected void onFailed(int i) {
                try {
                    if (iSolveServerHostsCallBack != null) {
                        iSolveServerHostsCallBack.onFailed(i);
                    }
                } catch (RemoteException e2) {
                    RLog.e(LibHandlerStub.TAG, "solveServerHosts:" + e2);
                }
            }

            @Override // io.rong.imlib.httpdns.HttpDnsCompletion
            protected void onSuccess(ArrayList<String> arrayList) {
                try {
                    if (iSolveServerHostsCallBack != null) {
                        iSolveServerHostsCallBack.onSuccess(arrayList);
                    }
                } catch (RemoteException e2) {
                    RLog.e(LibHandlerStub.TAG, "solveServerHosts:" + e2);
                }
            }
        });
    }

    @Override // io.rong.imlib.IHandler
    public void subscribePublicService(String str, int i, boolean z, final IOperationCallback iOperationCallback) {
        try {
            this.mClient.subscribePublicService(str, i, z, new NativeClient.OperationCallback() { // from class: io.rong.imlib.LibHandlerStub.21
                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onError(int i2) {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onFailure(i2);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.OperationCallback
                public void onSuccess() {
                    IOperationCallback iOperationCallback2 = iOperationCallback;
                    if (iOperationCallback2 != null) {
                        try {
                            iOperationCallback2.onComplete();
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void subscribeStatus(List<String> list, final IIntegerCallback iIntegerCallback) {
        try {
            this.mClient.subscribeStatus(list, new NativeClient.IResultCallbackEx<Integer, Integer>() { // from class: io.rong.imlib.LibHandlerStub.10
                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onError(int i) {
                    IIntegerCallback iIntegerCallback2 = iIntegerCallback;
                    if (iIntegerCallback2 != null) {
                        try {
                            iIntegerCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultCallbackEx
                public void onSuccess(Integer num, Integer num2) {
                    IIntegerCallback iIntegerCallback2 = iIntegerCallback;
                    if (iIntegerCallback2 != null) {
                        try {
                            iIntegerCallback2.onComplete(num2.intValue());
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean supportResumeBrokenTransfer(String str) {
        return MediaDownloadEngine.checkSupportResumeTransfer(str);
    }

    @Override // io.rong.imlib.IHandler
    public void switchAppKey(String str, String str2) {
        try {
            this.mClient.switchAppKey(str, str2);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void syncGroup(List<Group> list, IOperationCallback iOperationCallback) {
        try {
            this.mClient.syncGroup(list, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean updateConversationInfo(int i, String str, String str2, String str3) {
        try {
            return this.mClient.updateConversationInfo(Conversation.ConversationType.setValue(i), str, str2, str3);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void updateMessageExpansion(Map map, String str, IOperationCallback iOperationCallback) throws RemoteException {
        try {
            this.mClient.updateMessageExpansion(map, str, new OperationCallback(iOperationCallback));
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean updateMessageReceiptStatus(String str, int i, long j) {
        try {
            return this.mClient.updateMessageReceiptStatus(str, i, j);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean updateReadReceiptRequestInfo(String str, String str2) {
        if (str == null || str2 == null) {
            RLog.d(TAG, "updateReadReceiptRequestInfo parameter error");
            return false;
        }
        try {
            return this.mClient.updateReadReceiptRequestInfo(str, str2);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void updateVoIPCallInfo(String str) throws RemoteException {
        try {
            this.mClient.updateVoIPCallInfo(str);
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void uploadMedia(Message message, final IUploadCallback iUploadCallback) {
        try {
            this.mClient.uploadMedia(message, new NativeClient.IResultProgressCallback<String>() { // from class: io.rong.imlib.LibHandlerStub.32
                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onCanceled(int i) {
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onError(int i) {
                    IUploadCallback iUploadCallback2 = iUploadCallback;
                    if (iUploadCallback2 != null) {
                        try {
                            iUploadCallback2.onFailure(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onProgress(int i) {
                    IUploadCallback iUploadCallback2 = iUploadCallback;
                    if (iUploadCallback2 != null) {
                        try {
                            iUploadCallback2.onProgress(i);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }

                @Override // io.rong.imlib.NativeClient.IResultProgressCallback
                public void onSuccess(String str) {
                    IUploadCallback iUploadCallback2 = iUploadCallback;
                    if (iUploadCallback2 != null) {
                        try {
                            iUploadCallback2.onComplete(str);
                        } catch (RemoteException e2) {
                            LibHandlerStub.this.handleRemoteException(e2);
                        }
                    }
                }
            });
        } catch (RuntimeException e2) {
            handleRuntimeException(e2);
            throw null;
        }
    }

    @Override // io.rong.imlib.IHandler
    public boolean useRTCOnly() {
        try {
            return this.mClient.useRTCOnly();
        } catch (Exception e2) {
            RLog.e(TAG, "UseRTCOnly - " + e2.toString());
            return false;
        }
    }

    @Override // io.rong.imlib.IHandler
    public void writeFwLog(int i, String str, String str2, String str3, long j) {
        FwLog.write(i, str, str2, str3, j);
    }
}
