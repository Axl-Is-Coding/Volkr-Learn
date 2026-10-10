package io.rong.imlib;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.config.VipSubscribeStatus;
import io.rong.common.SystemUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.common.rlog.RLog;
import io.rong.imlib.HeartBeatManager;
import io.rong.imlib.NativeClient;
import io.rong.imlib.NativeObject;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.BuildVar;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SignatureUtils;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.imlib.navigation.NavigationClient;
import io.rong.imlib.navigation.NavigationObserver;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionService {
    private static final int RECONNECT_INTERVAL = 1000;
    private static final int RECONNECT_INTERVAL_MAX_LENGTH = 10;
    private static final String TAG = "ConnectionService";
    private String mAppKey;
    private Executor mCallBackExecutor;
    private NativeClient.IConnectResultCallback<String> mConnectCallback;
    private ConnectStatusListener mConnectListener;
    private ConnectionState mConnectionState;
    private Context mContext;
    private boolean mEnableReconnectKick;
    private Handler mHandler;
    private boolean mIsForeground;
    private NativeObject mNativeObj;
    private AtomicInteger mRcRetryCount;
    private String[] mReconnectInterval;
    private ReconnectRunnable mReconnectRunnable;
    private volatile String mToken;

    private class ConnectStatusListener implements NativeObject.ConnectionStatusListener {
        private ConnectStatusListener() {
        }

        @Override // io.rong.imlib.NativeObject.ConnectionStatusListener
        public void OnDatabaseOpened(final int i) {
            ConnectionService.this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.ConnectStatusListener.5
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionService.this.OnProtocolDBOpened(i);
                }
            });
        }

        @Override // io.rong.imlib.NativeObject.ConnectionStatusListener
        public void OnPongReceived() {
            ConnectionService.this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.ConnectStatusListener.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionService.this.OnProtocolPongReceived();
                    HeartBeatManager.getInstance().dequeue();
                }
            });
        }

        @Override // io.rong.imlib.NativeObject.ConnectionStatusListener
        public void OnRmtpComplete(final int i, final String str, final int i2, final short s, final String str2) {
            ConnectionService.this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.ConnectStatusListener.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionService.this.OnProtocolRmtpComplete(i, str, i2, s, str2);
                }
            });
        }

        @Override // io.rong.imlib.NativeObject.ConnectionStatusListener
        public void OnRmtpDisconnected(final int i, final int i2, final String str) {
            ConnectionService.this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.ConnectStatusListener.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionService.this.OnProtocolRmtpDisconnected(i, i2, str);
                }
            });
        }

        @Override // io.rong.imlib.NativeObject.ConnectionStatusListener
        public void OnTcpComplete(final NativeObject.ConnectionEntry connectionEntry) {
            ConnectionService.this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.ConnectStatusListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionService.this.OnProtocolTcpComplete(connectionEntry);
                }
            });
        }
    }

    private class ReconnectRunnable implements Runnable {
        ReconnectRunnable() {
            RLog.d(ConnectionService.TAG, "ReconnectRunnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.d(ConnectionService.TAG, "ReconnectRunnable, count = " + ConnectionService.this.mRcRetryCount.get());
            String str = ConnectionService.this.mToken;
            if (!TextUtils.isEmpty(str)) {
                ConnectionService connectionService = ConnectionService.this;
                connectionService.connectServer(str, true, true, connectionService.mConnectCallback);
            }
            ConnectionService.this.mReconnectRunnable = null;
        }
    }

    private static class SingleHolder {
        static ConnectionService instance = new ConnectionService();

        private SingleHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnProtocolDBOpened(int i) {
        responseDBOpenBlock(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnProtocolPongReceived() {
        RLog.i(TAG, "ConnectionStatusListener OnPongReceived.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnProtocolRmtpComplete(int i, String str, int i2, short s, String str2) {
        RLog.d(TAG, "[connect] operationComplete status:" + i + ", logInfo:" + str2);
        if (i == 0) {
            FwLog.write(3, 1, "P-connect-R", "status_code|user_id|native_code|duration|network", Integer.valueOf(i), str, Integer.valueOf(i2), Short.valueOf(s), DeviceUtils.getNetworkType(this.mContext));
            resetReconnectCount();
            stopRetry();
            this.mConnectionState.onEvent(i);
            NativeClient.getInstance().setCurrentUserId(str);
            NavigationCacheHelper.saveUserId(this.mContext, str);
            responseConnectSuccessBlock(str);
            CMPStrategy.getInstance().onConnected();
        } else {
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Short.valueOf(s);
            objArr[4] = DeviceUtils.getNetworkType(this.mContext);
            objArr[5] = this.mIsForeground ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            FwLog.write(1, 1, "P-connect-R", "status_code|user_id|native_code|duration|network|bg", objArr);
            this.mConnectionState.onEvent(i);
            if (!this.mConnectionState.getCurrentStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND)) {
                responseConnectErrorBlock(i);
            }
            disposeReconnectByErrorCode(i, i2);
        }
        boolean zIsFetching = NavigationClient.getInstance().isFetching();
        if (NavigationClient.getInstance().isNaviCacheValid(this.mContext, this.mAppKey, this.mToken) || zIsFetching || needClearNavi(i) || TextUtils.isEmpty(this.mToken)) {
            return;
        }
        NavigationClient.getInstance().requestNavi(this.mAppKey, this.mToken, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnProtocolRmtpDisconnected(int i, int i2, String str) {
        RLog.i(TAG, "ExceptionListener onError. errorCode: " + i);
        disposeReconnectByErrorCode(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnProtocolTcpComplete(NativeObject.ConnectionEntry connectionEntry) {
        int i;
        RLog.e(TAG, "connectionCollection onComplete:" + connectionEntry.getHost() + " " + connectionEntry.getPort() + " " + connectionEntry.getError() + " " + connectionEntry.getDuration());
        if (connectionEntry.getError() != 0) {
            if (connectionEntry.getError() != -1) {
                i = 1;
            }
            FwLog.write(i, 1, "P-connect_entry-S", "code|cmp|duration", Integer.valueOf(connectionEntry.getError()), connectionEntry.getHost() + ":" + connectionEntry.getPort(), Integer.valueOf(connectionEntry.getDuration()));
        }
        CMPStrategy.getInstance().setMainCMP(connectionEntry.getHost() + ":" + connectionEntry.getPort());
        i = 3;
        FwLog.write(i, 1, "P-connect_entry-S", "code|cmp|duration", Integer.valueOf(connectionEntry.getError()), connectionEntry.getHost() + ":" + connectionEntry.getPort(), Integer.valueOf(connectionEntry.getDuration()));
    }

    private boolean canReconnect() {
        if (this.mConnectionState.isTerminate()) {
            RLog.e(TAG, "globalConnectionState can not reconnect");
            this.mToken = null;
            stopRetry();
            return false;
        }
        if (this.mConnectionState.getCurrentStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
            RLog.i(TAG, "already connected. ignore this connect event.");
            return false;
        }
        if (this.mToken == null) {
            RLog.e(TAG, "mToken is cleared for terminal reconnect reason");
            return false;
        }
        if (isNetworkAvailable()) {
            return true;
        }
        resetReconnectCount();
        this.mConnectionState.networkUnavailable();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectServer(final String str, final boolean z, final boolean z2, final NativeClient.IConnectResultCallback<String> iConnectResultCallback) {
        if (!z) {
            this.mToken = str;
        } else if (!canReconnect()) {
            RLog.i(TAG, "[connect] can't connect status " + this.mConnectionState.getCurrentStatus());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "connectServer token is null");
            if (iConnectResultCallback != null) {
                iConnectResultCallback.onError(RongIMClient.ErrorCode.PARAMETER_ERROR.getValue());
                return;
            }
            return;
        }
        this.mConnectionState.connecting();
        stopRetry();
        NavigationClient.getInstance().addObserver(new NavigationObserver() { // from class: io.rong.imlib.ConnectionService.4
            @Override // io.rong.imlib.navigation.NavigationObserver
            public void onError(String str2, int i) {
                RLog.e(ConnectionService.TAG, "[connect] get cmp error, errorCode = " + i);
                boolean privateCloudConfig = NavigationCacheHelper.getPrivateCloudConfig(ConnectionService.this.mContext);
                List<String> cmpList = CMPStrategy.getInstance().getCmpList();
                if (cmpList == null || cmpList.size() == 0) {
                    ConnectionService.this.disposeReconnectByErrorCode(i, -1);
                    if (RongIMClient.ErrorCode.RC_CONN_USER_OR_PASSWD_ERROR.getValue() == i) {
                        iConnectResultCallback.onError(i);
                    }
                } else {
                    FwLog.write(3, 1, "L-Env-S", "private:", Boolean.valueOf(privateCloudConfig));
                    ConnectionService.this.mNativeObj.SetEnvironment(privateCloudConfig);
                    ConnectionService.this.internalConnect(str, str2, z, z2, iConnectResultCallback);
                }
                if (i == 30008) {
                    FwLog.write(1, 1, "P-rtcon-E", "code|method|nativeCode|sessionId|seq_id", Integer.valueOf(i), "navi", 0, 0, "0");
                }
            }

            @Override // io.rong.imlib.navigation.NavigationObserver
            public void onSuccess(String str2) {
                RLog.d(ConnectionService.TAG, "[connect] get cmp success");
                boolean privateCloudConfig = NavigationCacheHelper.getPrivateCloudConfig(ConnectionService.this.mContext);
                FwLog.write(3, 1, "L-Env-S", "private", Boolean.valueOf(privateCloudConfig));
                ConnectionService.this.mNativeObj.SetEnvironment(privateCloudConfig);
                ConnectionService.this.internalConnect(str, str2, z, z2, iConnectResultCallback);
            }
        });
        NavigationClient.getInstance().getCMPServerString(this.mContext, this.mAppKey, str);
    }

    static String connectionEntryArrayToString(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString().substring(0, r2.length() - 1);
    }

    private NativeObject.ConnectionEntry[] getConnectionEntries(List<URL> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return (NativeObject.ConnectionEntry[]) arrayList.toArray(new NativeObject.ConnectionEntry[0]);
        }
        for (URL url : list) {
            NativeObject.ConnectionEntry connectionEntry = new NativeObject.ConnectionEntry();
            connectionEntry.setHost(url.getHost().replace("[", "").replace("]", ""));
            connectionEntry.setPort(url.getPort());
            arrayList.add(connectionEntry);
        }
        return (NativeObject.ConnectionEntry[]) arrayList.toArray(new NativeObject.ConnectionEntry[list.size()]);
    }

    static ConnectionService getInstance() {
        return SingleHolder.instance;
    }

    private List<URL> getLegalCmpList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : new ArrayList(list)) {
            URL legalServer = SystemUtils.getLegalServer(str, true);
            if (legalServer != null) {
                arrayList.add(legalServer);
            } else {
                FwLog.write(1, 1, "L-check_cmp-S", "cmp", str);
            }
        }
        return arrayList;
    }

    private void handleSuspend(int i) {
        if (i == RongIMClient.ErrorCode.RC_CONNECTION_RESET_BY_PEER.getValue() || i == RongIMClient.ErrorCode.RC_CONN_ACK_TIMEOUT.getValue()) {
            CMPStrategy.getInstance().updateCmpList();
        } else if (i == RongIMClient.ErrorCode.RC_PONG_RECV_FAIL.getValue() && isNetworkAvailable()) {
            CMPStrategy.getInstance().updateCmpList();
        } else if (needClearNavi(i)) {
            CMPStrategy.getInstance().clearCache(this.mContext);
        }
        retry();
    }

    private void incrementCount() {
        this.mRcRetryCount.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalConnect(String str, String str2, final boolean z, boolean z2, final NativeClient.IConnectResultCallback<String> iConnectResultCallback) {
        FwLog.write(3, 1, z ? "L-reconnect-T" : "L-connect-T", "sequences", Integer.valueOf(this.mRcRetryCount.get()));
        this.mToken = str;
        tryConnect(str, str2, z, z2, new NativeClient.IConnectResultCallback<String>() { // from class: io.rong.imlib.ConnectionService.5
            @Override // io.rong.imlib.NativeClient.IConnectResultCallback
            public void OnDatabaseOpened(int i) {
                NativeClient.IConnectResultCallback iConnectResultCallback2 = iConnectResultCallback;
                if (iConnectResultCallback2 != null) {
                    iConnectResultCallback2.OnDatabaseOpened(i);
                }
            }

            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onError(int i) {
                FwLog.write(1, 1, z ? "L-reconnect-R" : "L-connect-R", "code|network|sequences", Integer.valueOf(i), DeviceUtils.getNetworkType(ConnectionService.this.mContext), Integer.valueOf(ConnectionService.this.mRcRetryCount.get()));
                NativeClient.IConnectResultCallback iConnectResultCallback2 = iConnectResultCallback;
                if (iConnectResultCallback2 != null) {
                    iConnectResultCallback2.onError(i);
                }
            }

            @Override // io.rong.imlib.NativeClient.IResultCallback
            public void onSuccess(String str3) {
                FwLog.write(3, 1, z ? "L-reconnect-R" : "L-connect-R", "code|sequences", 0, Integer.valueOf(ConnectionService.this.mRcRetryCount.get()));
                NativeClient.IConnectResultCallback iConnectResultCallback2 = iConnectResultCallback;
                if (iConnectResultCallback2 != null) {
                    iConnectResultCallback2.onSuccess(str3);
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    private boolean needClearNavi(int i) {
        return i == RongIMClient.ErrorCode.RC_CONN_REDIRECTED.getValue() || i == RongIMClient.ErrorCode.PARAMETER_ERROR.getValue() || i == RongIMClient.ErrorCode.RC_CONN_REFUSED.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseConnectErrorBlock(int i) {
        NativeClient.IConnectResultCallback<String> iConnectResultCallback = this.mConnectCallback;
        if (iConnectResultCallback != null) {
            iConnectResultCallback.onError(i);
        }
    }

    private void responseConnectSuccessBlock(String str) {
        NativeClient.IConnectResultCallback<String> iConnectResultCallback = this.mConnectCallback;
        if (iConnectResultCallback != null) {
            iConnectResultCallback.onSuccess(str);
        }
    }

    private void responseDBOpenBlock(int i) {
        RLog.d(TAG, "onDatabaseOpened.");
        NativeClient.IConnectResultCallback<String> iConnectResultCallback = this.mConnectCallback;
        if (iConnectResultCallback != null) {
            iConnectResultCallback.OnDatabaseOpened(i);
        }
    }

    private void retry() {
        if (canReconnect()) {
            int length = this.mReconnectInterval.length - 1;
            int i = (int) (((this.mRcRetryCount.get() < 0 || this.mRcRetryCount.get() > length) ? Float.parseFloat(this.mReconnectInterval[length]) : Float.parseFloat(this.mReconnectInterval[this.mRcRetryCount.get()])) * 1000.0f);
            RLog.d(TAG, "onStatusChange, Will reconnect after " + i);
            FwLog.write(4, 1, "L-reconnect-S", "retry_after", Integer.valueOf(i));
            this.mReconnectRunnable = new ReconnectRunnable();
            this.mHandler.postDelayed(this.mReconnectRunnable, (long) i);
            incrementCount();
        }
    }

    private void setHeartBeatListener() {
        HeartBeatManager.getInstance().setHeartBeatListener(new HeartBeatManager.HeartBeatListener() { // from class: io.rong.imlib.ConnectionService.2
            @Override // io.rong.imlib.HeartBeatManager.HeartBeatListener
            public void onPongReceiveFail() {
                ConnectionService.this.disposeReconnectByErrorCode(RongIMClient.ErrorCode.RC_PONG_RECV_FAIL.getValue(), -1);
            }
        });
    }

    private void stopRetry() {
        ReconnectRunnable reconnectRunnable = this.mReconnectRunnable;
        if (reconnectRunnable != null) {
            this.mHandler.removeCallbacks(reconnectRunnable);
            this.mReconnectRunnable = null;
        }
    }

    private void tryConnect(String str, String str2, boolean z, boolean z2, NativeClient.IConnectResultCallback<String> iConnectResultCallback) {
        ConnectStatusListener connectStatusListener;
        TelephonyManager telephonyManager;
        this.mIsForeground = z2;
        this.mConnectCallback = iConnectResultCallback;
        String str3 = str2 == null ? "" : str2;
        List<String> cmpList = CMPStrategy.getInstance().getCmpList();
        List<URL> legalCmpList = getLegalCmpList(cmpList);
        if (legalCmpList == null || legalCmpList.size() <= 0) {
            CMPStrategy.getInstance().clearCache(this.mContext);
            this.mConnectListener.OnRmtpComplete(RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue(), "", 0, (short) 0, "");
            return;
        }
        NativeObject.ConnectionEntry[] connectionEntries = getConnectionEntries(legalCmpList);
        NativeClient.getInstance().setCurrentUserId(str3);
        boolean zIsMPOpened = NavigationClient.getInstance().isMPOpened(this.mContext);
        boolean zIsUSOpened = NavigationClient.getInstance().isUSOpened(this.mContext);
        boolean zIsGROpened = NavigationClient.getInstance().isGROpened(this.mContext);
        boolean zIsKvStorageEnabled = NavigationCacheHelper.isKvStorageEnabled(this.mContext);
        try {
            telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        } catch (SecurityException e2) {
            RLog.e(TAG, "tryConnect SecurityException", e2);
        }
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : "";
        RLog.d(TAG, "[connect] device info: " + Build.MANUFACTURER + ", " + Build.MODEL + ", " + Build.VERSION.SDK_INT + ", " + BuildVar.SDK_VERSION + ", " + DeviceUtils.getNetworkType(this.mContext) + ", " + networkOperator);
        StringBuilder sb = new StringBuilder();
        sb.append("[connect] tryConnect::cmp:");
        sb.append(connectionEntryArrayToString(cmpList));
        sb.append(", userId : ");
        sb.append(str3);
        RLog.d(TAG, sb.toString());
        FwLog.write(3, 1, "P-connect-T", "strategy|cached|use", "parallel", connectionEntryArrayToString(cmpList), connectionEntryArrayToString(cmpList));
        boolean z3 = this.mEnableReconnectKick && z;
        int groupMessageLimit = zIsGROpened ? NavigationClient.getInstance().getGroupMessageLimit(this.mContext) : 0;
        String clientIp = NavigationCacheHelper.getClientIp(this.mContext);
        if (!SystemUtils.isLegalServer(clientIp)) {
            clientIp = "";
        }
        NativeObject.UserProfile userProfile = new NativeObject.UserProfile();
        userProfile.setIpv6Preferred(false);
        userProfile.setPublicService(zIsMPOpened);
        userProfile.setPushSetting(zIsUSOpened);
        userProfile.setSdkReconnect(z3);
        userProfile.setGroupMessageLimit(groupMessageLimit);
        userProfile.setClientIp(clientIp);
        userProfile.setKvStorageOpened(zIsKvStorageEnabled);
        userProfile.setIdentification(SignatureUtils.getAppSignatureSHA1(this.mContext));
        int iConnect = this.mNativeObj.Connect(NavigationClient.getInstance().getTokenExceptNavi(str), connectionEntries, str3, userProfile);
        if (iConnect == 0 || (connectStatusListener = this.mConnectListener) == null) {
            return;
        }
        connectStatusListener.OnRmtpComplete(iConnect, "", -1, (short) 0, "");
    }

    void connect(final String str, final boolean z, final boolean z2, final NativeClient.IConnectResultCallback<String> iConnectResultCallback) {
        resetReconnectCount();
        this.mHandler.post(new Runnable() { // from class: io.rong.imlib.ConnectionService.3
            @Override // java.lang.Runnable
            public void run() {
                ConnectionService.this.connectServer(str, z, z2, iConnectResultCallback);
            }
        });
    }

    void disconnect(boolean z) {
        resetReconnectCount();
        stopRetry();
        if (this.mNativeObj == null) {
            throw new RuntimeException("NativeClient 尚未初始化!");
        }
        RLog.d(TAG, "[connect] disconnect:" + z);
        this.mConnectionState.signUp();
        this.mToken = null;
        this.mNativeObj.Disconnect(z ? 2 : 4);
    }

    boolean disposeReconnectByErrorCode(int i, int i2) {
        FwLog.write(4, 1, "P-connect-S", "status_code|native_code", Integer.valueOf(i), Integer.valueOf(i2));
        this.mConnectionState.onEvent(i);
        RongIMClient.ConnectionStatusListener.ConnectionStatus currentStatus = this.mConnectionState.getCurrentStatus();
        if (currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
            stopRetry();
        } else {
            if (currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND)) {
                handleSuspend(i);
                return true;
            }
            RLog.d(TAG, "disposeReconnectByErrorCode cannot reconnect : status = " + this.mConnectionState.getCurrentStatus());
            if (currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.TIMEOUT)) {
                disconnect(false);
            }
            stopRetry();
        }
        return false;
    }

    ConnectionState getConnectionState() {
        return this.mConnectionState;
    }

    void initIPCEnviroment(String str, int i) {
        RLog.i(TAG, "initConnectToken " + str);
        this.mToken = str;
        this.mConnectionState.initConnectStatus(i);
    }

    void initService(Context context, NativeObject nativeObject, String str) {
        int length;
        this.mContext = context;
        this.mNativeObj = nativeObject;
        this.mAppKey = str;
        this.mConnectListener = new ConnectStatusListener();
        this.mNativeObj.SetConnectionStatusListener(this.mConnectListener);
        CMPStrategy.getInstance().setEnvironment(this.mContext);
        try {
            Resources resources = context.getResources();
            this.mReconnectInterval = resources.getStringArray(resources.getIdentifier("rc_reconnect_interval", "array", context.getPackageName()));
            length = this.mReconnectInterval.length;
            RLog.i(TAG, "mReconnectInterval " + length);
        } catch (Resources.NotFoundException unused) {
            RLog.i(TAG, "Not found rc_reconnect_interval in rc_configuration.xml, use default config");
        }
        if (length != 0) {
            if (this.mReconnectInterval[0] != null) {
                if (length > 10) {
                    throw new IllegalArgumentException("The numbers of rc_reconnect_interval must less than 10");
                }
                for (String str2 : this.mReconnectInterval) {
                    try {
                        Float.parseFloat(str2);
                    } catch (NumberFormatException unused2) {
                        throw new IllegalArgumentException("The value of the field must be digits");
                    }
                }
                setHeartBeatListener();
                return;
            }
        }
        throw new IllegalArgumentException("rc_reconnect_interval must have a value and the type of the field must be string-array");
    }

    void resetReconnectCount() {
        RLog.i(TAG, "reset reconnectCount");
        this.mRcRetryCount.set(0);
    }

    void setIpcConnectTimeOut() {
        this.mCallBackExecutor.execute(new Runnable() { // from class: io.rong.imlib.ConnectionService.6
            @Override // java.lang.Runnable
            public void run() {
                if (ConnectionService.this.mConnectionState.getCurrentStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
                    return;
                }
                RLog.e(ConnectionService.TAG, "IM 重连超时，将不会继续连接");
                ConnectionService.this.disposeReconnectByErrorCode(RongIMClient.ErrorCode.RC_CONNECT_TIMEOUT.getValue(), -1);
                ConnectionService.this.responseConnectErrorBlock(RongIMClient.ErrorCode.RC_CONNECT_TIMEOUT.getValue());
            }
        });
    }

    void setMainProgressConnectionStatusListener(NativeClient.ICodeListener iCodeListener) {
        this.mConnectionState.setConnectionStatusListener(iCodeListener);
    }

    void setReconnectKickEnable(boolean z) {
        this.mEnableReconnectKick = z;
    }

    private ConnectionService() {
        this.mContext = null;
        this.mEnableReconnectKick = false;
        this.mRcRetryCount = new AtomicInteger(0);
        this.mReconnectInterval = new String[]{"0", "0.25", "0.5", "1", "2", VipSubscribeStatus.SUBSCRIPTION_PURCHASED, VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED, "16", "32", "64"};
        HandlerThread handlerThread = new HandlerThread("IPC_RECONNECT_WORK");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mCallBackExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: io.rong.imlib.ConnectionService.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "IPC_CONNECT_CALLBACK");
            }
        });
        this.mConnectionState = new ConnectionState();
    }
}
