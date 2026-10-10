package io.rong.imlib;

import io.rong.common.fwlog.FwLog;
import io.rong.common.rlog.RLog;
import io.rong.imlib.NativeClient;
import io.rong.imlib.RongIMClient;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionState {
    private static final String TAG = "ConnectionState";
    private NativeClient.ICodeListener mConnectionStatusUpdateListener;
    private final int UNCONNECT_CODE = 34999;
    private final int SIGNUP_CODE = 34998;
    private final int NETWORK_UNAVAILABLE_CODE = 34997;
    private final int CONNECTING_CODE = 34996;
    private final int SUSPEND_CODE = 34995;
    private RongIMClient.ConnectionStatusListener.ConnectionStatus currentStatus = RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED;

    /* JADX INFO: renamed from: io.rong.imlib.ConnectionState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus = new int[RongIMClient.ConnectionStatusListener.ConnectionStatus.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.SIGN_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.TOKEN_INCORRECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[RongIMClient.ConnectionStatusListener.ConnectionStatus.CONN_USER_BLOCKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void defaultOnEvent(int i) {
        if (RongIMClient.ErrorCode.CONNECTED.getValue() == i || RongIMClient.ErrorCode.BIZ_ERROR_RECONNECT_SUCCESS.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED);
            return;
        }
        if (RongIMClient.ErrorCode.RC_DISCONN_KICK.getValue() == i || RongIMClient.ErrorCode.RC_CONN_OTHER_DEVICE_LOGIN.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT);
            return;
        }
        if (RongIMClient.ErrorCode.RC_CONN_USER_OR_PASSWD_ERROR.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.TOKEN_INCORRECT);
            return;
        }
        if (RongIMClient.ErrorCode.RC_CONN_USER_BLOCKED.getValue() == i || RongIMClient.ErrorCode.RC_DISCONN_USER_BLOCKED.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONN_USER_BLOCKED);
            return;
        }
        if (RongIMClient.ErrorCode.RC_CONN_PROTO_VERSION_ERROR.getValue() == i || RongIMClient.ErrorCode.RC_CONN_ID_REJECT.getValue() == i || RongIMClient.ErrorCode.RC_CONN_NOT_AUTHRORIZED.getValue() == i || RongIMClient.ErrorCode.RC_CONN_PACKAGE_NAME_INVALID.getValue() == i || RongIMClient.ErrorCode.RC_CONN_APP_BLOCKED_OR_DELETED.getValue() == i || RongIMClient.ErrorCode.RC_QUERY_ACK_NO_DATA.getValue() == i || RongIMClient.ErrorCode.RC_MSG_DATA_INCOMPLETE.getValue() == i || RongIMClient.ErrorCode.BIZ_ERROR_CLIENT_NOT_INIT.getValue() == i || RongIMClient.ErrorCode.BIZ_ERROR_DATABASE_ERROR.getValue() == i || RongIMClient.ErrorCode.PARAMETER_ERROR.getValue() == i || RongIMClient.ErrorCode.BIZ_ERROR_NO_CHANNEL.getValue() == i || RongIMClient.ErrorCode.BIZ_ERROR_CONNECTING.getValue() == i || RongIMClient.ErrorCode.CONCURRENT_LIMIT_ERROR.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED);
            return;
        }
        if (RongIMClient.ErrorCode.RC_MSG_SEND_FAIL.getValue() == i || RongIMClient.ErrorCode.RC_NET_CHANNEL_INVALID.getValue() == i || RongIMClient.ErrorCode.RC_NET_UNAVAILABLE.getValue() == i || RongIMClient.ErrorCode.RC_MSG_RESP_TIMEOUT.getValue() == i || RongIMClient.ErrorCode.RC_HTTP_SEND_FAIL.getValue() == i || RongIMClient.ErrorCode.RC_HTTP_REQ_TIMEOUT.getValue() == i || RongIMClient.ErrorCode.RC_HTTP_RECV_FAIL.getValue() == i || RongIMClient.ErrorCode.RC_NAVI_RESOURCE_ERROR.getValue() == i || RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue() == i || RongIMClient.ErrorCode.RC_DOMAIN_NOT_RESOLVE.getValue() == i || RongIMClient.ErrorCode.RC_SOCKET_NOT_CREATED.getValue() == i || RongIMClient.ErrorCode.RC_SOCKET_DISCONNECTED.getValue() == i || RongIMClient.ErrorCode.RC_PONG_RECV_FAIL.getValue() == i || RongIMClient.ErrorCode.RC_CONN_ACK_TIMEOUT.getValue() == i || RongIMClient.ErrorCode.RC_CONN_OVERFREQUENCY.getValue() == i || RongIMClient.ErrorCode.RC_CONN_REFUSED.getValue() == i || RongIMClient.ErrorCode.RC_CONN_REDIRECTED.getValue() == i || RongIMClient.ErrorCode.RC_NETWORK_IS_DOWN_OR_UNREACHABLE.getValue() == i || RongIMClient.ErrorCode.RC_CONN_SERVER_UNAVAILABLE.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND);
            return;
        }
        if (34999 == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED);
            return;
        }
        if (34998 == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.SIGN_OUT);
            return;
        }
        if (34997 == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE);
            return;
        }
        if (34996 == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING);
            return;
        }
        if (34995 == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND);
            return;
        }
        if (RongIMClient.ErrorCode.RC_CONNECT_TIMEOUT.getValue() == i) {
            updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.TIMEOUT);
            return;
        }
        RLog.e(TAG, "errorCodeToConnectionStatus unknown code : " + i);
        updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND);
    }

    private void unconnectedOnEvent(int i) {
        if (i != 34996) {
            return;
        }
        updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING);
    }

    private void updateCurrentStatus(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        if (this.currentStatus != connectionStatus) {
            FwLog.write(4, 1, FwLog.LogTag.L_CONNECT_S.getTag(), "last_status|status", this.currentStatus, connectionStatus);
            this.currentStatus = connectionStatus;
            NativeClient.ICodeListener iCodeListener = this.mConnectionStatusUpdateListener;
            if (iCodeListener != null) {
                iCodeListener.onChanged(connectionStatus.getValue());
            }
        }
    }

    public void connecting() {
        onEvent(34996);
    }

    protected RongIMClient.ConnectionStatusListener.ConnectionStatus getCurrentStatus() {
        return this.currentStatus;
    }

    protected void initConnectStatus(int i) {
        this.currentStatus = RongIMClient.ConnectionStatusListener.ConnectionStatus.valueOf(i);
        RLog.i(TAG, "initIpcConnectStatus " + this.currentStatus);
    }

    boolean isTerminate() {
        return this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT) || this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED) || this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SIGN_OUT) || this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.TIMEOUT) || this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.TOKEN_INCORRECT) || this.currentStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONN_USER_BLOCKED);
    }

    public void networkUnavailable() {
        onEvent(34997);
    }

    public void onEvent(int i) {
        switch (AnonymousClass1.$SwitchMap$io$rong$imlib$RongIMClient$ConnectionStatusListener$ConnectionStatus[this.currentStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                unconnectedOnEvent(i);
                break;
            default:
                defaultOnEvent(i);
                break;
        }
    }

    protected void setConnectionStatusListener(NativeClient.ICodeListener iCodeListener) {
        this.mConnectionStatusUpdateListener = iCodeListener;
    }

    public void signUp() {
        onEvent(34998);
    }

    public void suspend() {
        onEvent(34995);
    }

    public void unconnect() {
        onEvent(34999);
    }
}
