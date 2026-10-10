package io.rong.imlib;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.IOperationCallback;
import io.rong.imlib.IRTCConfigCallback;
import io.rong.imlib.IRTCJoinRoomCallback;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.IRtcIODataListener;
import io.rong.imlib.ISendMessageCallback;
import io.rong.imlib.ISolveServerHostsCallBack;
import io.rong.imlib.IStringCallback;
import io.rong.imlib.RTCDataListener;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.ipc.IpcCallbackProxy;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.RTCStatusDate;
import io.rong.imlib.model.RTCUser;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.typingmessage.TypingMessageManager;
import io.rong.imlib.typingmessage.TypingStatusMessage;
import io.rong.message.ReadReceiptMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IMLibRTCClient {
    private static final String TAG = "IMLibRTCClient";
    private static Handler mHandler;
    private static RTCRoomActionListener rtcRoomActionListener;
    private IHandler mLibHandler;
    private Handler mWorkHandler;

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$10, reason: invalid class name */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ String[] val$keys;
        final /* synthetic */ String val$roomId;
        final /* synthetic */ int val$type;

        AnonymousClass10(IpcCallbackProxy ipcCallbackProxy, String str, int i, String[] strArr) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$roomId = str;
            this.val$type = i;
            this.val$keys = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            if (IMLibRTCClient.this.mLibHandler != null) {
                try {
                    IMLibRTCClient.this.mLibHandler.rtcGetInnerData(this.val$roomId, this.val$type, this.val$keys == null ? new String[0] : this.val$keys, new IRtcIODataListener.Stub() { // from class: io.rong.imlib.IMLibRTCClient.10.1
                        @Override // io.rong.imlib.IRtcIODataListener
                        public void OnError(final int i) throws RemoteException {
                            RLog.d(IMLibRTCClient.TAG, "rtcGetInnerData errorCode =  " + i);
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            IpcCallbackProxy ipcCallbackProxy = anonymousClass10.val$ipcCallbackProxy;
                            if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                                return;
                            }
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.10.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRtcIODataCallback) AnonymousClass10.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                                    AnonymousClass10.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }

                        @Override // io.rong.imlib.IRtcIODataListener
                        public void OnSuccess(final Map map) throws RemoteException {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            IpcCallbackProxy ipcCallbackProxy = anonymousClass10.val$ipcCallbackProxy;
                            if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                                return;
                            }
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.10.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRtcIODataCallback) AnonymousClass10.this.val$ipcCallbackProxy.callback).onSuccess(map);
                                    AnonymousClass10.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    });
                    return;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            IpcCallbackProxy ipcCallbackProxy = this.val$ipcCallbackProxy;
            if (ipcCallbackProxy == null || (t = ipcCallbackProxy.callback) == 0) {
                return;
            }
            ((IRongCallback.IRtcIODataCallback) t).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
            this.val$ipcCallbackProxy.callback = null;
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$11, reason: invalid class name */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ String[] val$keys;
        final /* synthetic */ String val$roomId;
        final /* synthetic */ int val$type;

        AnonymousClass11(IpcCallbackProxy ipcCallbackProxy, String str, int i, String[] strArr) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$roomId = str;
            this.val$type = i;
            this.val$keys = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            if (IMLibRTCClient.this.mLibHandler != null) {
                try {
                    IMLibRTCClient.this.mLibHandler.rtcGetOuterData(this.val$roomId, this.val$type, this.val$keys == null ? new String[0] : this.val$keys, new IRtcIODataListener.Stub() { // from class: io.rong.imlib.IMLibRTCClient.11.1
                        @Override // io.rong.imlib.IRtcIODataListener
                        public void OnError(final int i) throws RemoteException {
                            RLog.d(IMLibRTCClient.TAG, "rtcGetOuterData errorCode =  " + i);
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            IpcCallbackProxy ipcCallbackProxy = anonymousClass11.val$ipcCallbackProxy;
                            if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                                return;
                            }
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.11.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRtcIODataCallback) AnonymousClass11.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                                    AnonymousClass11.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }

                        @Override // io.rong.imlib.IRtcIODataListener
                        public void OnSuccess(final Map map) throws RemoteException {
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            if (anonymousClass11.val$ipcCallbackProxy.callback != 0) {
                                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.11.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IRongCallback.IRtcIODataCallback) AnonymousClass11.this.val$ipcCallbackProxy.callback).onSuccess(map);
                                        AnonymousClass11.this.val$ipcCallbackProxy.callback = null;
                                    }
                                });
                            }
                        }
                    });
                    return;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            IpcCallbackProxy ipcCallbackProxy = this.val$ipcCallbackProxy;
            if (ipcCallbackProxy == null || (t = ipcCallbackProxy.callback) == 0) {
                return;
            }
            ((IRongCallback.IRtcIODataCallback) t).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
            this.val$ipcCallbackProxy.callback = null;
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$19, reason: invalid class name */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ String val$roomId;
        final /* synthetic */ List val$userIds;

        AnonymousClass19(IpcCallbackProxy ipcCallbackProxy, List list, String str) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$userIds = list;
            this.val$roomId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (IMLibRTCClient.this.mLibHandler == null) {
                    if (this.val$ipcCallbackProxy == null || this.val$ipcCallbackProxy.callback == 0) {
                        return;
                    }
                    ((IRongCallback.IRTCDataCallback) this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                    return;
                }
                String[] strArr = new String[0];
                if (this.val$userIds != null && !this.val$userIds.isEmpty()) {
                    strArr = (String[]) this.val$userIds.toArray(new String[0]);
                }
                IMLibRTCClient.this.mLibHandler.getRTCUserDatas(this.val$roomId, strArr, new RTCDataListener.Stub() { // from class: io.rong.imlib.IMLibRTCClient.19.1
                    @Override // io.rong.imlib.RTCDataListener
                    public void OnError(final int i) {
                        RLog.d(IMLibRTCClient.TAG, "getRTCUserData errorCode =  " + i);
                        AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                        if (anonymousClass19.val$ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.19.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRTCDataCallback) AnonymousClass19.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                                    AnonymousClass19.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.RTCDataListener
                    public void OnSuccess(final List list) {
                        AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                        if (anonymousClass19.val$ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.19.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRTCDataCallback) AnonymousClass19.this.val$ipcCallbackProxy.callback).onSuccess(list);
                                    AnonymousClass19.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (RemoteException e2) {
                RLog.e(IMLibRTCClient.TAG, e2.toString());
                IpcCallbackProxy ipcCallbackProxy = this.val$ipcCallbackProxy;
                if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                    return;
                }
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.19.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IRongCallback.IRTCDataCallback) AnonymousClass19.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        AnonymousClass19.this.val$ipcCallbackProxy.callback = null;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ int val$order;
        final /* synthetic */ String val$roomId;

        AnonymousClass2(IpcCallbackProxy ipcCallbackProxy, String str, int i) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$roomId = str;
            this.val$order = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            if (IMLibRTCClient.this.mLibHandler == null) {
                IpcCallbackProxy ipcCallbackProxy = this.val$ipcCallbackProxy;
                if (ipcCallbackProxy == null || (t = ipcCallbackProxy.callback) == 0) {
                    return;
                }
                ((IRongCallback.IRTCDataCallback) t).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                return;
            }
            try {
                IMLibRTCClient.this.mLibHandler.getRTCUsers(this.val$roomId, this.val$order, new RTCDataListener.Stub() { // from class: io.rong.imlib.IMLibRTCClient.2.1
                    @Override // io.rong.imlib.RTCDataListener
                    public void OnError(final int i) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        IpcCallbackProxy ipcCallbackProxy2 = anonymousClass2.val$ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                            return;
                        }
                        IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IRongCallback.IRTCDataCallback) AnonymousClass2.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                                AnonymousClass2.this.val$ipcCallbackProxy.callback = null;
                            }
                        });
                    }

                    @Override // io.rong.imlib.RTCDataListener
                    public void OnSuccess(final List list) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        IpcCallbackProxy ipcCallbackProxy2 = anonymousClass2.val$ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                            return;
                        }
                        IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IRongCallback.IRTCDataCallback) AnonymousClass2.this.val$ipcCallbackProxy.callback).onSuccess(list);
                                AnonymousClass2.this.val$ipcCallbackProxy.callback = null;
                            }
                        });
                    }
                });
            } catch (RemoteException e2) {
                RLog.e(IMLibRTCClient.TAG, e2.toString());
                IpcCallbackProxy ipcCallbackProxy2 = this.val$ipcCallbackProxy;
                if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                    return;
                }
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IRongCallback.IRTCDataCallback) AnonymousClass2.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        AnonymousClass2.this.val$ipcCallbackProxy.callback = null;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$20, reason: invalid class name */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ boolean val$isFilterBlackList;
        final /* synthetic */ Message val$message;
        final /* synthetic */ SendMessageOption val$option;
        final /* synthetic */ String val$pushContent;
        final /* synthetic */ String val$pushData;
        final /* synthetic */ String[] val$userIds;

        AnonymousClass20(IpcCallbackProxy ipcCallbackProxy, Message message, String str, String str2, String[] strArr, SendMessageOption sendMessageOption, boolean z) {
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$message = message;
            this.val$pushContent = str;
            this.val$pushData = str2;
            this.val$userIds = strArr;
            this.val$option = sendMessageOption;
            this.val$isFilterBlackList = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IMLibRTCClient.this.mLibHandler == null) {
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        T t;
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        IpcCallbackProxy ipcCallbackProxy = anonymousClass20.val$ipcCallbackProxy;
                        if (ipcCallbackProxy == null || (t = ipcCallbackProxy.callback) == 0) {
                            return;
                        }
                        ((IRongCallback.ISendMessageCallback) t).onError(anonymousClass20.val$message, RongIMClient.ErrorCode.IPC_DISCONNECT);
                        AnonymousClass20.this.val$ipcCallbackProxy.callback = null;
                    }
                });
                return;
            }
            try {
                IMLibRTCClient.this.mLibHandler.sendRTCDirectionalMessage(this.val$message, this.val$pushContent, this.val$pushData, this.val$userIds, this.val$option, this.val$isFilterBlackList, new ISendMessageCallback.Stub() { // from class: io.rong.imlib.IMLibRTCClient.20.2
                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onAttached(final Message message) throws RemoteException {
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        if (anonymousClass20.val$ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.20.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass20.this.val$ipcCallbackProxy.callback).onAttached(message);
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onError(final Message message, final int i) throws RemoteException {
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        if (anonymousClass20.val$ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.20.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass20.this.val$ipcCallbackProxy.callback).onError(message, RongIMClient.ErrorCode.valueOf(i));
                                    AnonymousClass20.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }

                    @Override // io.rong.imlib.ISendMessageCallback
                    public void onSuccess(final Message message) throws RemoteException {
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        if (anonymousClass20.val$ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.20.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.ISendMessageCallback) AnonymousClass20.this.val$ipcCallbackProxy.callback).onSuccess(message);
                                    AnonymousClass20.this.val$ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                });
            } catch (Exception e2) {
                RLog.e(IMLibRTCClient.TAG, "sendDirectionalMessage exception : ", e2);
            }
        }
    }

    /* JADX INFO: renamed from: io.rong.imlib.IMLibRTCClient$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ IpcCallbackProxy val$ipcCallbackProxy;
        final /* synthetic */ int val$order;
        final /* synthetic */ String val$roomId;

        AnonymousClass3(String str, IpcCallbackProxy ipcCallbackProxy, int i) {
            this.val$roomId = str;
            this.val$ipcCallbackProxy = ipcCallbackProxy;
            this.val$order = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            if (IMLibRTCClient.this.mLibHandler == null) {
                FwLog.write(1, 2, "L-getRTCUserData-E", "roomId|code|desc", this.val$roomId, Integer.valueOf(RongIMClient.ErrorCode.IPC_DISCONNECT.getValue()), "LibHandler is Null");
                IpcCallbackProxy ipcCallbackProxy = this.val$ipcCallbackProxy;
                if (ipcCallbackProxy == null || (t = ipcCallbackProxy.callback) == 0) {
                    return;
                }
                ((IRongCallback.IRTCDataCallback) t).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                return;
            }
            try {
                IMLibRTCClient.this.mLibHandler.getRTCUserData(this.val$roomId, this.val$order, new RTCDataListener.Stub() { // from class: io.rong.imlib.IMLibRTCClient.3.1
                    @Override // io.rong.imlib.RTCDataListener
                    public void OnError(final int i) {
                        FwLog.write(1, 2, "L-getRTCUserData-E", "roomId|code", AnonymousClass3.this.val$roomId, Integer.valueOf(i));
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        IpcCallbackProxy ipcCallbackProxy2 = anonymousClass3.val$ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                            return;
                        }
                        IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.3.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IRongCallback.IRTCDataCallback) AnonymousClass3.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                                AnonymousClass3.this.val$ipcCallbackProxy.callback = null;
                            }
                        });
                    }

                    @Override // io.rong.imlib.RTCDataListener
                    public void OnSuccess(final List list) {
                        FwLog.write(3, 2, "L-getRTCUserData-R", "roomId", AnonymousClass3.this.val$roomId);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        IpcCallbackProxy ipcCallbackProxy2 = anonymousClass3.val$ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                            return;
                        }
                        IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IRongCallback.IRTCDataCallback) AnonymousClass3.this.val$ipcCallbackProxy.callback).onSuccess(list);
                                AnonymousClass3.this.val$ipcCallbackProxy.callback = null;
                            }
                        });
                    }
                });
            } catch (RemoteException e2) {
                FwLog.write(1, 2, "L-getRTCUserData-E", "roomId|code|desc", this.val$roomId, Integer.valueOf(RongIMClient.ErrorCode.IPC_DISCONNECT.getValue()), e2.toString());
                IpcCallbackProxy ipcCallbackProxy2 = this.val$ipcCallbackProxy;
                if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                    return;
                }
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IRongCallback.IRTCDataCallback) AnonymousClass3.this.val$ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        AnonymousClass3.this.val$ipcCallbackProxy.callback = null;
                    }
                });
            }
        }
    }

    private class DefaultOperationCallback extends IOperationCallback.Stub {
        private IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy;

        public DefaultOperationCallback(IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy) {
            this.ipcCallbackProxy = ipcCallbackProxy;
        }

        @Override // io.rong.imlib.IOperationCallback
        public void onComplete() {
            RongIMClient.OperationCallback operationCallback;
            IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy = this.ipcCallbackProxy;
            if (ipcCallbackProxy == null || (operationCallback = ipcCallbackProxy.callback) == null) {
                return;
            }
            operationCallback.onCallback();
            this.ipcCallbackProxy.callback = null;
        }

        @Override // io.rong.imlib.IOperationCallback
        public void onFailure(int i) {
            RongIMClient.OperationCallback operationCallback;
            IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy = this.ipcCallbackProxy;
            if (ipcCallbackProxy == null || (operationCallback = ipcCallbackProxy.callback) == null) {
                return;
            }
            operationCallback.onFail(i);
            this.ipcCallbackProxy.callback = null;
        }
    }

    private class JoinRTCRoomCallback extends IRTCJoinRoomCallback.Stub {
        private int broadcastType;
        private IpcCallbackProxy<IRongCallback.IRTCJoinRoomCallbackEx<String[]>> ipcCallbackProxy;
        private int roomType;
        private String rtcRoomId;

        public JoinRTCRoomCallback(IpcCallbackProxy<IRongCallback.IRTCJoinRoomCallbackEx<String[]>> ipcCallbackProxy, String str, int i, int i2) {
            this.rtcRoomId = str;
            this.broadcastType = i2;
            this.roomType = i;
            this.ipcCallbackProxy = ipcCallbackProxy;
            RLog.d(IMLibRTCClient.TAG, this + "");
        }

        @Override // io.rong.imlib.IRTCJoinRoomCallback
        public void OnError(final int i) throws RemoteException {
            RLog.e(IMLibRTCClient.TAG, "join rtcRroom " + this.rtcRoomId + ", error: " + i);
            IpcCallbackProxy<IRongCallback.IRTCJoinRoomCallbackEx<String[]>> ipcCallbackProxy = this.ipcCallbackProxy;
            if (ipcCallbackProxy != null && ipcCallbackProxy.callback != null) {
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.JoinRTCRoomCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IRongCallback.IRTCJoinRoomCallbackEx) JoinRTCRoomCallback.this.ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.valueOf(i));
                        JoinRTCRoomCallback.this.ipcCallbackProxy.callback = null;
                    }
                });
            }
            if (IMLibRTCClient.rtcRoomActionListener != null) {
                IMLibRTCClient.rtcRoomActionListener.onError(this.rtcRoomId, RongIMClient.ErrorCode.valueOf(i));
            }
        }

        @Override // io.rong.imlib.IRTCJoinRoomCallback
        public void OnSuccess(final List list, final String str, final String str2) throws RemoteException {
            IpcCallbackProxy<IRongCallback.IRTCJoinRoomCallbackEx<String[]>> ipcCallbackProxy = this.ipcCallbackProxy;
            if (ipcCallbackProxy != null && ipcCallbackProxy.callback != null) {
                IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.JoinRTCRoomCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IRongCallback.IRTCJoinRoomCallbackEx) JoinRTCRoomCallback.this.ipcCallbackProxy.callback).onSuccess(list, new String[]{str, str2});
                        JoinRTCRoomCallback.this.ipcCallbackProxy.callback = null;
                    }
                });
            }
            if (IMLibRTCClient.rtcRoomActionListener != null) {
                IMLibRTCClient.rtcRoomActionListener.onJoined(this.rtcRoomId, list);
            }
        }

        public String toString() {
            return "JoinRTCRoomCallback{rtcRoomId='" + this.rtcRoomId + "'}";
        }
    }

    private class RTCExitRoomCallback extends DefaultOperationCallback {
        public RTCExitRoomCallback(IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy) {
            super(ipcCallbackProxy);
        }

        @Override // io.rong.imlib.IMLibRTCClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
        public void onComplete() {
            RLog.d(IMLibRTCClient.TAG, "RTCExitRoomCallback onComplete ");
            super.onComplete();
        }

        @Override // io.rong.imlib.IMLibRTCClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
        public void onFailure(int i) {
            RLog.d(IMLibRTCClient.TAG, "RTCExitRoomCallback errorCode =  " + i);
            super.onFailure(i);
        }
    }

    private class RTCOperationCallback extends DefaultOperationCallback {
        public RTCOperationCallback(IpcCallbackProxy<RongIMClient.OperationCallback> ipcCallbackProxy) {
            super(ipcCallbackProxy);
        }

        @Override // io.rong.imlib.IMLibRTCClient.DefaultOperationCallback, io.rong.imlib.IOperationCallback
        public void onFailure(int i) {
            RLog.d(IMLibRTCClient.TAG, "RTCOperationCallback errorCode =  " + i);
            super.onFailure(i);
        }
    }

    public interface RTCRoomActionListener {
        void onError(String str, RongIMClient.ErrorCode errorCode);

        void onExited(String str);

        void onJoined(String str, List<RTCUser> list);

        void onJoining(String str);
    }

    private class RTCRoomCacheRunnable implements Runnable {
        int broadcastType;
        int roomType;
        String rtcRoomID;

        public RTCRoomCacheRunnable(String str, int i, int i2) {
            this.rtcRoomID = str;
            this.roomType = i;
            this.broadcastType = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RongIMClient.ConnectionStatusListener.ConnectionStatus currentConnectionStatus = RongIMClient.getInstance().getCurrentConnectionStatus();
            RLog.d(IMLibRTCClient.TAG, "rejoin rtc_room " + this);
            if (IMLibRTCClient.this.mLibHandler == null || !RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED.equals(currentConnectionStatus)) {
                RLog.e(IMLibRTCClient.TAG, "rejoin rtc-room error : " + currentConnectionStatus);
                return;
            }
            IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(null);
            if (IMLibRTCClient.rtcRoomActionListener != null) {
                IMLibRTCClient.rtcRoomActionListener.onJoining(this.rtcRoomID);
            }
            try {
                IMLibRTCClient.this.mLibHandler.joinRTCRoomAndGetData(this.rtcRoomID, this.roomType, this.broadcastType, IMLibRTCClient.this.new JoinRTCRoomCallback(ipcCallbackProxy, this.rtcRoomID, this.roomType, this.broadcastType));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                RLog.e(IMLibRTCClient.TAG, "rejoin rtc-room exception.");
            }
        }

        public String toString() {
            return "RTCRoomCacheRunnable{rtcRoomID='" + this.rtcRoomID + "'roomType= }";
        }
    }

    private static class SingletonHolder {
        static IMLibRTCClient sInstance = new IMLibRTCClient();

        private SingletonHolder() {
        }
    }

    public static IMLibRTCClient getInstance() {
        return SingletonHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static void setRtcRoomActionListener(RTCRoomActionListener rTCRoomActionListener) {
        rtcRoomActionListener = rTCRoomActionListener;
    }

    public void OnServiceConnected(IHandler iHandler) {
        this.mLibHandler = iHandler;
    }

    public void OnServiceDisconnected() {
        this.mLibHandler = null;
    }

    public void exitRTCRoom(final String str, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler == null) {
                        IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                            return;
                        }
                        ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    try {
                        RLog.d(IMLibRTCClient.TAG, "exitRTCRoom roomId = " + str);
                        IMLibRTCClient.this.mLibHandler.exitRTCRoom(str, IMLibRTCClient.this.new RTCExitRoomCallback(ipcCallbackProxy));
                        if (IMLibRTCClient.rtcRoomActionListener != null) {
                            IMLibRTCClient.rtcRoomActionListener.onExited(str);
                        }
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    @Deprecated
    public void getRTCConfig(String str, String str2, long j, IRongCallback.IRTCConfigCallback iRTCConfigCallback) {
        RLog.w(TAG, "getRTCConfig has already Deprecated");
    }

    public void getRTCToken(final String str, final int i, final int i2, RongIMClient.ResultCallback<String> resultCallback) {
        FwLog.write(3, 2, "L-getRTCToken-T", "roomId|roomType|mediaType", str, Integer.valueOf(i), Integer.valueOf(i2));
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(resultCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.15
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        IMLibRTCClient.this.mLibHandler.getRTCToken(str, i, i2, new IStringCallback.Stub() { // from class: io.rong.imlib.IMLibRTCClient.15.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IStringCallback
                            public void onComplete(String str2) throws RemoteException {
                                FwLog.write(3, 2, "L-getRTCToken-R", "code|token", 0, str2);
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.ResultCallback) t).onCallback(str2);
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IStringCallback
                            public void onFailure(int i3) throws RemoteException {
                                FwLog.write(1, 2, "L-getRTCToken-E", "code", Integer.valueOf(i3));
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.ResultCallback) t).onFail(RongIMClient.ErrorCode.valueOf(i3));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                        return;
                    }
                    FwLog.write(1, 2, "L-getRTCToken-E", "code|desc", Integer.valueOf(RongIMClient.ErrorCode.IPC_DISCONNECT.getValue()), "IM LibHandler is Null");
                    if (ipcCallbackProxy.callback != 0) {
                        ((RongIMClient.ResultCallback) ipcCallbackProxy.callback).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                } catch (RemoteException e2) {
                    RLog.e(IMLibRTCClient.TAG, "getRTCToken", e2);
                }
            }
        });
    }

    public void getRTCUserData(String str, int i, IRongCallback.IRTCDataCallback iRTCDataCallback) {
        if (!TextUtils.isEmpty(str)) {
            FwLog.write(3, 2, "L-getRTCUserData-T", "roomId", str);
            this.mWorkHandler.post(new AnonymousClass3(str, new IpcCallbackProxy(iRTCDataCallback), i));
        } else {
            FwLog.write(1, 2, "L-getRTCUserData-E", "code|desc", Integer.valueOf(RongIMClient.ErrorCode.PARAMETER_ERROR.getValue()), "RTC_Room_ID is empty.");
            if (iRTCDataCallback != null) {
                iRTCDataCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getRTCUsers(String str, int i, IRongCallback.IRTCDataCallback iRTCDataCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.mWorkHandler.post(new AnonymousClass2(new IpcCallbackProxy(iRTCDataCallback), str, i));
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (iRTCDataCallback != null) {
                iRTCDataCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public String getVoIPInfo() {
        try {
            if (this.mLibHandler == null) {
                RLog.e(TAG, "IPC disconnected.");
            }
            return this.mLibHandler == null ? "" : this.mLibHandler.getVoIPCallInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void init(Handler handler) {
        this.mWorkHandler = handler;
    }

    public void joinRTCRoomAndGetData(String str, final IRongCallback.IRTCJoinRoomCallback iRTCJoinRoomCallback) {
        joinRTCRoomAndGetData(str, 0, 1, new IRongCallback.IRTCJoinRoomCallbackEx<String[]>() { // from class: io.rong.imlib.IMLibRTCClient.12
            @Override // io.rong.imlib.IRongCallback.IRTCJoinRoomCallbackEx
            public void onError(RongIMClient.ErrorCode errorCode) {
                IRongCallback.IRTCJoinRoomCallback iRTCJoinRoomCallback2 = iRTCJoinRoomCallback;
                if (iRTCJoinRoomCallback2 != null) {
                    iRTCJoinRoomCallback2.onError(errorCode);
                }
            }

            @Override // io.rong.imlib.IRongCallback.IRTCJoinRoomCallbackEx
            public /* bridge */ /* synthetic */ void onSuccess(List list, String[] strArr) {
                onSuccess2((List<RTCUser>) list, strArr);
            }

            /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(List<RTCUser> list, String[] strArr) {
                IRongCallback.IRTCJoinRoomCallback iRTCJoinRoomCallback2 = iRTCJoinRoomCallback;
                if (iRTCJoinRoomCallback2 != null) {
                    iRTCJoinRoomCallback2.onSuccess(list, (strArr == null || strArr.length < 1) ? null : strArr[0]);
                }
            }
        });
    }

    public void rtcDeleteInnerData(final String str, final int i, final String[] strArr, final String str2, final String str3, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.8
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        try {
                            IMLibRTCClient.this.mLibHandler.rtcDeleteInnerData(str, i, strArr == null ? new String[0] : strArr, str2, str3, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                    if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                        return;
                    }
                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcDeleteOuterData(final String str, final int i, final String[] strArr, final String str2, final String str3, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.9
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        try {
                            IMLibRTCClient.this.mLibHandler.rtcDeleteOuterData(str, i, strArr == null ? new String[0] : strArr, str2, str3, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                    if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                        return;
                    }
                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcGetInnerData(String str, int i, String[] strArr, IRongCallback.IRtcIODataCallback iRtcIODataCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.mWorkHandler.post(new AnonymousClass10(new IpcCallbackProxy(iRtcIODataCallback), str, i, strArr));
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (iRtcIODataCallback != null) {
                iRtcIODataCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcGetOuterData(String str, int i, String[] strArr, IRongCallback.IRtcIODataCallback iRtcIODataCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.mWorkHandler.post(new AnonymousClass11(new IpcCallbackProxy(iRtcIODataCallback), str, i, strArr));
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (iRtcIODataCallback != null) {
                iRtcIODataCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcPutInnerDatum(final String str, final int i, final String str2, final String str3, final String str4, final String str5, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        try {
                            IMLibRTCClient.this.mLibHandler.rtcPutInnerData(str, i, str2, str3, str4, str5, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                    if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                        return;
                    }
                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcPutOuterDatum(final String str, final int i, final String str2, final String str3, final String str4, final String str5, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.7
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    T t2;
                    if (IMLibRTCClient.this.mLibHandler == null) {
                        IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || (t2 = ipcCallbackProxy2.callback) == 0) {
                            return;
                        }
                        ((RongIMClient.OperationCallback) t2).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                        return;
                    }
                    try {
                        IMLibRTCClient.this.mLibHandler.rtcPutOuterData(str, i, str2, str3, str4, str5, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        IpcCallbackProxy ipcCallbackProxy3 = ipcCallbackProxy;
                        if (ipcCallbackProxy3 == null || (t = ipcCallbackProxy3.callback) == 0) {
                            return;
                        }
                        ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.UNKNOWN);
                        ipcCallbackProxy.callback = null;
                    }
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void rtcSetUserResource(final String str, final RTCStatusDate[] rTCStatusDateArr, final String str2, final RTCStatusDate[] rTCStatusDateArr2, RongIMClient.OperationCallback operationCallback) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.21
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        try {
                            IMLibRTCClient.this.mLibHandler.rtcSetUserResource(str, rTCStatusDateArr, str2, rTCStatusDateArr2, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                    if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                        return;
                    }
                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                    ipcCallbackProxy.callback = null;
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (operationCallback != null) {
                operationCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void sendRTCDirectMessage(String str, MessageContent messageContent, String[] strArr, String str2, String str3, SendMessageOption sendMessageOption, boolean z, IRongCallback.ISendMessageCallback iSendMessageCallback) {
        Message messageObtain = Message.obtain(str, Conversation.ConversationType.RTC_ROOM, messageContent);
        if (messageObtain.getConversationType() == null || TextUtils.isEmpty(str) || messageContent == null) {
            RLog.e(TAG, "sendDirectionalMessage : conversation type or targetId or content can't be null!");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(messageObtain, RongIMClient.ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (((MessageTag) messageContent.getClass().getAnnotation(MessageTag.class)) == null) {
            RLog.e(TAG, "sendDirectionalMessage 自定义消息没有加注解信息。");
            if (iSendMessageCallback != null) {
                iSendMessageCallback.onError(messageObtain, RongIMClient.ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        if (TypingMessageManager.getInstance().isShowMessageTyping() && !(messageContent instanceof TypingStatusMessage) && !(messageContent instanceof ReadReceiptMessage)) {
            TypingMessageManager.getInstance().setTypingEnd(messageObtain.getConversationType(), messageObtain.getTargetId());
        }
        this.mWorkHandler.post(new AnonymousClass20(new IpcCallbackProxy(iSendMessageCallback), messageObtain, str2, str3, strArr, sendMessageOption, z));
    }

    public void sendRTCPing(final String str, RongIMClient.OperationCallback operationCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                T t;
                if (IMLibRTCClient.this.mLibHandler != null) {
                    try {
                        IMLibRTCClient.this.mLibHandler.sendRTCPing(str, IMLibRTCClient.this.new RTCOperationCallback(ipcCallbackProxy));
                        return;
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                    return;
                }
                ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                ipcCallbackProxy.callback = null;
            }
        });
    }

    public void setRTCUserData(final String str, final int i, final HashMap map, final String str2, final String str3, RongIMClient.OperationCallback operationCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.18
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        IMLibRTCClient.this.mLibHandler.setRTCUserDatas(str, i, map, str2, str3, new IOperationCallback.Stub() { // from class: io.rong.imlib.IMLibRTCClient.18.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onComplete() throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.OperationCallback) t).onCallback();
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onFailure(int i2) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.valueOf(i2));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } else {
                        if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                            return;
                        }
                        ((RongIMClient.OperationCallback) ipcCallbackProxy.callback).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                } catch (RemoteException e2) {
                    RLog.e(IMLibRTCClient.TAG, "setRTCUserState", e2);
                }
            }
        });
    }

    public void setRTCUserState(final String str, final String str2, RongIMClient.OperationCallback operationCallback) {
        final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(operationCallback);
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.16
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        IMLibRTCClient.this.mLibHandler.setRTCUserData(str, str2, new IOperationCallback.Stub() { // from class: io.rong.imlib.IMLibRTCClient.16.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onComplete() throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.OperationCallback) t).onCallback();
                                    ipcCallbackProxy.callback = null;
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // io.rong.imlib.IOperationCallback
                            public void onFailure(int i) throws RemoteException {
                                T t = ipcCallbackProxy.callback;
                                if (t != 0) {
                                    ((RongIMClient.OperationCallback) t).onFail(RongIMClient.ErrorCode.valueOf(i));
                                    ipcCallbackProxy.callback = null;
                                }
                            }
                        });
                    } else {
                        if (ipcCallbackProxy == null || ipcCallbackProxy.callback == 0) {
                            return;
                        }
                        ((RongIMClient.OperationCallback) ipcCallbackProxy.callback).onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        ipcCallbackProxy.callback = null;
                    }
                } catch (RemoteException e2) {
                    RLog.e(IMLibRTCClient.TAG, "setRTCUserState", e2);
                }
            }
        });
    }

    public void setUseRTCOnly(final RongIMClient.ResultCallback<Boolean> resultCallback) {
        this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.5
            @Override // java.lang.Runnable
            public void run() {
                if (IMLibRTCClient.this.mLibHandler == null) {
                    RongIMClient.ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onCallback(false);
                        return;
                    }
                    return;
                }
                try {
                    boolean zUseRTCOnly = IMLibRTCClient.this.mLibHandler.useRTCOnly();
                    if (resultCallback != null) {
                        resultCallback.onCallback(Boolean.valueOf(zUseRTCOnly));
                    }
                } catch (RemoteException e2) {
                    RongIMClient.ResultCallback resultCallback3 = resultCallback;
                    if (resultCallback3 != null) {
                        resultCallback3.onCallback(false);
                    }
                    e2.printStackTrace();
                }
            }
        });
    }

    public void solveServerHosts(String str, final RongIMClient.ResultCallback<List<String>> resultCallback) {
        IHandler iHandler = this.mLibHandler;
        if (iHandler == null) {
            if (resultCallback != null) {
                resultCallback.onFail(RongIMClient.ErrorCode.IPC_DISCONNECT);
                return;
            }
            return;
        }
        boolean zIsDnsEnabled = false;
        try {
            zIsDnsEnabled = iHandler.isDnsEnabled();
        } catch (RemoteException e2) {
            RLog.e(TAG, "isDnsEnabled", e2);
        }
        if (!zIsDnsEnabled) {
            if (resultCallback != null) {
                resultCallback.onFail(RongIMClient.ErrorCode.RC_OPERATION_NOT_SUPPORT);
            }
        } else {
            try {
                this.mLibHandler.solveServerHosts(str, new ISolveServerHostsCallBack.Stub() { // from class: io.rong.imlib.IMLibRTCClient.17
                    @Override // io.rong.imlib.ISolveServerHostsCallBack
                    public void onFailed(int i) throws RemoteException {
                        resultCallback.onFail(i);
                    }

                    @Override // io.rong.imlib.ISolveServerHostsCallBack
                    public void onSuccess(List<String> list) throws RemoteException {
                        resultCallback.onSuccess(list);
                    }
                });
            } catch (RemoteException e3) {
                RLog.e(TAG, "sloveServerHosts", e3);
            }
        }
    }

    private IMLibRTCClient() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getRTCConfig(final String str, final String str2, final long j, final String str3, final IRongCallback.IRTCConfigCallback iRTCConfigCallback) {
        if (iRTCConfigCallback == null) {
            RLog.d(TAG, "getRTCConfig error =   callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(iRTCConfigCallback);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.14
                @Override // java.lang.Runnable
                public void run() {
                    if (IMLibRTCClient.this.mLibHandler != null) {
                        try {
                            IMLibRTCClient.this.mLibHandler.getRTCConfig(str, str2, j, str3, new IRTCConfigCallback.Stub() { // from class: io.rong.imlib.IMLibRTCClient.14.1
                                @Override // io.rong.imlib.IRTCConfigCallback
                                public void onError(int i) throws RemoteException {
                                    RLog.d(IMLibRTCClient.TAG, "getRTCConfig errorCode =  " + i);
                                    iRTCConfigCallback.onError(RongIMClient.ErrorCode.valueOf(i));
                                }

                                @Override // io.rong.imlib.IRTCConfigCallback
                                public void onSuccess(String str4, long j2) throws RemoteException {
                                    iRTCConfigCallback.onSuccess(str4, j2);
                                }
                            });
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                    if (ipcCallbackProxy2 == null || ipcCallbackProxy2.callback == 0) {
                        return;
                    }
                    RLog.d(IMLibRTCClient.TAG, "getRTCConfig error =  ipcCallbackProxy or callback is null");
                    ((IRongCallback.IRTCConfigCallback) ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                }
            });
            return;
        }
        RLog.e(TAG, "getRTCConfig parameter error, roomid=|model=" + str + "|osVersion=" + str2);
        if (iRTCConfigCallback != null) {
            iRTCConfigCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
        }
    }

    public void joinRTCRoomAndGetData(final String str, final int i, final int i2, IRongCallback.IRTCJoinRoomCallbackEx<String[]> iRTCJoinRoomCallbackEx) {
        if (!TextUtils.isEmpty(str)) {
            final IpcCallbackProxy ipcCallbackProxy = new IpcCallbackProxy(iRTCJoinRoomCallbackEx);
            this.mWorkHandler.post(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.13
                @Override // java.lang.Runnable
                public void run() {
                    T t;
                    if (IMLibRTCClient.this.mLibHandler == null) {
                        IpcCallbackProxy ipcCallbackProxy2 = ipcCallbackProxy;
                        if (ipcCallbackProxy2 == null || (t = ipcCallbackProxy2.callback) == 0) {
                            return;
                        }
                        ((IRongCallback.IRTCJoinRoomCallbackEx) t).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                        return;
                    }
                    try {
                        IMLibRTCClient.this.mLibHandler.joinRTCRoomAndGetData(str, i, i2, IMLibRTCClient.this.new JoinRTCRoomCallback(ipcCallbackProxy, str, i, i2));
                    } catch (RemoteException e2) {
                        RLog.e(IMLibRTCClient.TAG, e2.toString());
                        if (ipcCallbackProxy.callback != 0) {
                            IMLibRTCClient.this.runOnUiThread(new Runnable() { // from class: io.rong.imlib.IMLibRTCClient.13.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IRongCallback.IRTCJoinRoomCallbackEx) ipcCallbackProxy.callback).onError(RongIMClient.ErrorCode.IPC_DISCONNECT);
                                    ipcCallbackProxy.callback = null;
                                }
                            });
                        }
                    }
                }
            });
        } else {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (iRTCJoinRoomCallbackEx != null) {
                iRTCJoinRoomCallbackEx.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
            }
        }
    }

    public void getRTCUserData(String str, List<String> list, IRongCallback.IRTCDataCallback iRTCDataCallback) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "RTC_Room_ID is empty.");
            if (iRTCDataCallback != null) {
                iRTCDataCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR);
                return;
            }
            return;
        }
        this.mWorkHandler.post(new AnonymousClass19(new IpcCallbackProxy(iRTCDataCallback), list, str));
    }
}
