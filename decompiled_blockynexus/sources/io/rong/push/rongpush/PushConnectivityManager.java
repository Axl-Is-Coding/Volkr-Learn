package io.rong.push.rongpush;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.PushErrorCode;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.common.stateMachine.State;
import io.rong.push.common.stateMachine.StateMachine;
import io.rong.push.core.PushClient;
import io.rong.push.core.PushConnectHandler;
import io.rong.push.core.PushNaviClient;
import io.rong.push.core.PushProtocalStack;
import io.rong.push.core.PushUtils;
import io.rong.push.notification.PushNotificationMessage;
import io.rong.push.pushconfig.IResultCallback;
import io.rong.push.pushconfig.PushNaviObserver;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PushConnectivityManager extends StateMachine {
    private static final int EVENT_CONNECTED = 3;
    private static final int EVENT_CONNECT_TO_NAVI = 1;
    private static final int EVENT_CONNECT_TO_SERVER = 2;
    private static final int EVENT_CUSTOM_HEART_BEAT = 11;
    private static final int EVENT_DISCONNECT = 4;
    private static final int EVENT_DISCONNECTED = 5;
    private static final int EVENT_HEART_BEAT = 6;
    private static final int EVENT_NAVI_CONNECTED = 2;
    private static final int EVENT_PING_FAILURE = 7;
    private static final int EVENT_PING_SUCCESS = 8;
    private static final int EVENT_SEND_REGISTRATION_INFO = 10;
    private static final int EVENT_USER_OPERATION = 9;
    private static final String TAG = "PushConnectivityManager";
    private int ALARM_PING_REQUEST_CODE;
    private int ALARM_REQUEST_CODE;
    private String appKey;
    private PushConnectHandler connectHandler;
    private ConnectedState connectedState;
    private ConnectingState connectingState;
    private CustomPingState customPingState;
    private DisconnectedState disconnectedState;
    private boolean initialized;
    private Context mContext;
    private NaviConnectingState naviConnectingState;
    private NetworkType networkType;
    private PingState pingState;
    private PushClient pushClient;
    private PushNaviClient pushNaviClient;
    private ArrayList<String> serverIpList;

    private class ConnectedState extends State {
        private ConnectedState() {
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public void enter() {
            RLog.d(PushConnectivityManager.TAG, "enter " + ConnectedState.class.getSimpleName());
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.d(PushConnectivityManager.TAG, ConnectedState.class.getSimpleName() + ": process msg = " + message.what);
            int i = message.what;
            if (i == 4) {
                PushConnectivityManager.this.pushClient.disconnect();
                return true;
            }
            if (i == 5) {
                PushConnectivityManager.this.pushClient.reset();
                PushConnectivityManager pushConnectivityManager = PushConnectivityManager.this;
                pushConnectivityManager.transitionTo(pushConnectivityManager.disconnectedState);
                return true;
            }
            if (i == 6) {
                PushConnectivityManager.this.pushClient.ping();
                PushConnectivityManager pushConnectivityManager2 = PushConnectivityManager.this;
                pushConnectivityManager2.transitionTo(pushConnectivityManager2.pingState);
                return true;
            }
            if (i != 7) {
                if (i != 11) {
                    return true;
                }
                PushConnectivityManager.this.pushClient.ping();
                PushConnectivityManager pushConnectivityManager3 = PushConnectivityManager.this;
                pushConnectivityManager3.transitionTo(pushConnectivityManager3.customPingState);
                return true;
            }
            PushConnectivityManager.this.stopPingTimer();
            PushConnectivityManager.this.pushClient.reset();
            PushConnectivityManager pushConnectivityManager4 = PushConnectivityManager.this;
            pushConnectivityManager4.transitionTo(pushConnectivityManager4.disconnectedState);
            PushConnectivityManager.this.getHandler().sendEmptyMessage(2);
            return true;
        }
    }

    private class ConnectingState extends State {
        private ConnectingState() {
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public void enter() {
            RLog.d(PushConnectivityManager.TAG, "enter " + ConnectingState.class.getSimpleName());
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.d(PushConnectivityManager.TAG, ConnectingState.class.getSimpleName() + ": process msg = " + message.what);
            int i = message.what;
            if (i != 2) {
                if (i == 3) {
                    PushConnectivityManager.this.setNextHeartbeat();
                    PushConnectivityManager pushConnectivityManager = PushConnectivityManager.this;
                    pushConnectivityManager.transitionTo(pushConnectivityManager.connectedState);
                    return true;
                }
                if (i == 4 || i == 5) {
                    PushConnectivityManager.this.pushClient.reset();
                    PushConnectivityManager pushConnectivityManager2 = PushConnectivityManager.this;
                    pushConnectivityManager2.transitionTo(pushConnectivityManager2.disconnectedState);
                    return true;
                }
                if (i == 8) {
                    PushConnectivityManager.this.stopPingTimer();
                    return true;
                }
                if (i != 10) {
                    return true;
                }
            }
            PushConnectivityManager.this.deferMessage(message);
            return true;
        }
    }

    private class CustomPingState extends PingState {
        private CustomPingState() {
            super();
        }

        @Override // io.rong.push.rongpush.PushConnectivityManager.PingState, io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.d(PushConnectivityManager.TAG, CustomPingState.class.getSimpleName() + ": process msg = " + message.what);
            int i = message.what;
            if (i != 3 && i != 8) {
                return true;
            }
            PushConnectivityManager.this.stopPingTimer();
            PushConnectivityManager pushConnectivityManager = PushConnectivityManager.this;
            pushConnectivityManager.transitionTo(pushConnectivityManager.connectedState);
            return true;
        }
    }

    private class DisconnectedState extends State {
        private DisconnectedState() {
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public void enter() {
            RLog.d(PushConnectivityManager.TAG, "enter " + DisconnectedState.class.getSimpleName());
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean processMessage(android.os.Message r4) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.Class<io.rong.push.rongpush.PushConnectivityManager$DisconnectedState> r1 = io.rong.push.rongpush.PushConnectivityManager.DisconnectedState.class
                java.lang.String r1 = r1.getSimpleName()
                r0.append(r1)
                java.lang.String r1 = ": process msg = "
                r0.append(r1)
                int r1 = r4.what
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "PushConnectivityManager"
                io.rong.push.common.RLog.d(r1, r0)
                int r0 = r4.what
                r1 = 1
                if (r0 == r1) goto L49
                r2 = 2
                if (r0 == r2) goto L49
                r2 = 5
                if (r0 == r2) goto L3f
                r2 = 6
                if (r0 == r2) goto L49
                switch(r0) {
                    case 8: goto L39;
                    case 9: goto L49;
                    case 10: goto L33;
                    case 11: goto L49;
                    default: goto L32;
                }
            L32:
                goto L57
            L33:
                io.rong.push.rongpush.PushConnectivityManager r0 = io.rong.push.rongpush.PushConnectivityManager.this
                io.rong.push.rongpush.PushConnectivityManager.access$100(r0, r4)
                goto L57
            L39:
                io.rong.push.rongpush.PushConnectivityManager r4 = io.rong.push.rongpush.PushConnectivityManager.this
                r4.stopPingTimer()
                goto L57
            L3f:
                io.rong.push.rongpush.PushConnectivityManager r4 = io.rong.push.rongpush.PushConnectivityManager.this
                io.rong.push.core.PushClient r4 = io.rong.push.rongpush.PushConnectivityManager.access$500(r4)
                r4.reset()
                goto L57
            L49:
                io.rong.push.rongpush.PushConnectivityManager r4 = io.rong.push.rongpush.PushConnectivityManager.this
                io.rong.push.rongpush.PushConnectivityManager.access$200(r4)
                io.rong.push.rongpush.PushConnectivityManager r4 = io.rong.push.rongpush.PushConnectivityManager.this
                io.rong.push.rongpush.PushConnectivityManager$NaviConnectingState r0 = io.rong.push.rongpush.PushConnectivityManager.access$300(r4)
                io.rong.push.rongpush.PushConnectivityManager.access$400(r4, r0)
            L57:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.push.rongpush.PushConnectivityManager.DisconnectedState.processMessage(android.os.Message):boolean");
        }
    }

    private class NaviConnectingState extends State {
        private NaviConnectingState() {
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public void enter() {
            RLog.d(PushConnectivityManager.TAG, "enter " + NaviConnectingState.class.getSimpleName());
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public boolean processMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                PushConnectivityManager.this.connectToServer();
                PushConnectivityManager pushConnectivityManager = PushConnectivityManager.this;
                pushConnectivityManager.transitionTo(pushConnectivityManager.connectingState);
                return true;
            }
            if (i != 5) {
                return true;
            }
            PushConnectivityManager.this.pushClient.reset();
            PushConnectivityManager pushConnectivityManager2 = PushConnectivityManager.this;
            pushConnectivityManager2.transitionTo(pushConnectivityManager2.disconnectedState);
            return true;
        }
    }

    public enum NetworkType {
        NONE,
        WIFI,
        MOBILE,
        ERROR
    }

    private class PingState extends State {
        private PingState() {
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public void enter() {
            RLog.d(PushConnectivityManager.TAG, "enter " + getClass().getSimpleName());
            PushConnectivityManager.this.startPingTimer();
        }

        @Override // io.rong.push.common.stateMachine.State, io.rong.push.common.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.d(PushConnectivityManager.TAG, getClass().getSimpleName() + ": process msg = " + message.what);
            switch (message.what) {
                case 2:
                    PushConnectivityManager.this.connectToServer();
                    PushConnectivityManager pushConnectivityManager = PushConnectivityManager.this;
                    pushConnectivityManager.transitionTo(pushConnectivityManager.connectingState);
                    return true;
                case 3:
                case 8:
                    PushConnectivityManager.this.stopPingTimer();
                    PushConnectivityManager.this.setNextHeartbeat();
                    PushConnectivityManager pushConnectivityManager2 = PushConnectivityManager.this;
                    pushConnectivityManager2.transitionTo(pushConnectivityManager2.connectedState);
                    return true;
                case 4:
                    PushConnectivityManager.this.pushClient.disconnect();
                    PushConnectivityManager pushConnectivityManager3 = PushConnectivityManager.this;
                    pushConnectivityManager3.transitionTo(pushConnectivityManager3.disconnectedState);
                    return true;
                case 5:
                    PushConnectivityManager.this.pushClient.reset();
                    PushConnectivityManager pushConnectivityManager4 = PushConnectivityManager.this;
                    pushConnectivityManager4.transitionTo(pushConnectivityManager4.disconnectedState);
                    break;
                case 6:
                case 11:
                    PushConnectivityManager.this.pushClient.reset();
                    PushConnectivityManager pushConnectivityManager5 = PushConnectivityManager.this;
                    pushConnectivityManager5.transitionTo(pushConnectivityManager5.disconnectedState);
                    PushConnectivityManager.this.getHandler().sendEmptyMessage(2);
                    return true;
                case 7:
                    PushConnectivityManager.this.stopPingTimer();
                    PushConnectivityManager.this.pushClient.reset();
                    PushConnectivityManager.this.getHandler().sendEmptyMessage(2);
                    PushConnectivityManager pushConnectivityManager6 = PushConnectivityManager.this;
                    pushConnectivityManager6.transitionTo(pushConnectivityManager6.disconnectedState);
                    return true;
                case 9:
                default:
                    return true;
                case 10:
                    break;
            }
            PushConnectivityManager.this.deferMessage(message);
            return true;
        }
    }

    private static class Singleton {
        static PushConnectivityManager sInstance = new PushConnectivityManager();

        private Singleton() {
        }
    }

    protected PushConnectivityManager() {
        super(TAG);
        this.networkType = NetworkType.NONE;
        this.initialized = false;
        this.ALARM_REQUEST_CODE = 101;
        this.ALARM_PING_REQUEST_CODE = 102;
        this.disconnectedState = new DisconnectedState();
        this.naviConnectingState = new NaviConnectingState();
        this.connectingState = new ConnectingState();
        this.customPingState = new CustomPingState();
        this.pingState = new PingState();
        this.connectedState = new ConnectedState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectToNavi() {
        this.pushNaviClient.getPushServerIPs(this.mContext, this.appKey, true, new PushNaviObserver() { // from class: io.rong.push.rongpush.PushConnectivityManager.2
            @Override // io.rong.push.pushconfig.PushNaviObserver
            public void onError(PushErrorCode pushErrorCode) {
                RLog.e(PushConnectivityManager.TAG, "get navi onError.");
                PushConnectivityManager.this.getHandler().sendEmptyMessage(5);
            }

            @Override // io.rong.push.pushconfig.PushNaviObserver
            public void onSuccess(ArrayList<String> arrayList) {
                PushConnectivityManager.this.serverIpList = arrayList;
                PushConnectivityManager.this.getHandler().sendEmptyMessage(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectToServer() {
        if (!isInitialized()) {
            RLog.e(TAG, "connect does not init.");
            return;
        }
        ArrayList<String> arrayList = this.serverIpList;
        if (arrayList != null && arrayList.size() > 0) {
            this.connectHandler.connect(this.mContext, this.pushClient, this.serverIpList, this.appKey, new IResultCallback<String>() { // from class: io.rong.push.rongpush.PushConnectivityManager.3
                @Override // io.rong.push.pushconfig.IResultCallback
                public void onError(PushErrorCode pushErrorCode) {
                    PushConnectivityManager.this.getHandler().sendEmptyMessage(5);
                }

                @Override // io.rong.push.pushconfig.IResultCallback
                public void onSuccess(String str) {
                    PushConnectivityManager.this.getHandler().sendEmptyMessage(3);
                }
            });
        } else {
            RLog.e(TAG, "server ip can't be null.");
            getHandler().sendEmptyMessage(5);
        }
    }

    public static PushConnectivityManager getInstance() {
        return Singleton.sInstance;
    }

    private void startPushTimer(String str, String str2, int i, long j) {
        Intent intent = new Intent(this.mContext, (Class<?>) PushReceiver.class);
        intent.setAction(PushConst.ACTION_HEARTBEAT);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra(str, str2);
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, i, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        if (alarmManager == null || broadcast == null) {
            io.rong.common.rlog.RLog.e(TAG, "alarmManager or pendingIntent is null");
            return;
        }
        alarmManager.cancel(broadcast);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            try {
                alarmManager.setExactAndAllowWhileIdle(2, j, broadcast);
                return;
            } catch (Exception e2) {
                RLog.e(TAG, e2.getMessage());
                return;
            } catch (NoSuchMethodError e3) {
                RLog.e(TAG, e3.getMessage());
                alarmManager.setExact(2, j, broadcast);
                return;
            }
        }
        if (i2 < 19) {
            alarmManager.set(2, j, broadcast);
            return;
        }
        try {
            alarmManager.setExact(2, j, broadcast);
        } catch (Exception e4) {
            RLog.e(TAG, e4.getMessage());
        } catch (NoSuchMethodError e5) {
            RLog.e(TAG, e5.getMessage());
            alarmManager.set(2, j, broadcast);
        }
    }

    private void stopPushTimer(String str, String str2, int i) {
        Intent intent = new Intent(this.mContext, (Class<?>) PushReceiver.class);
        intent.setAction(PushConst.ACTION_HEARTBEAT);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra(str, str2);
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, i, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        if (broadcast == null || alarmManager == null) {
            return;
        }
        alarmManager.cancel(broadcast);
    }

    public void cancelHeartbeat() {
        RLog.i(TAG, "cancelHeartbeat");
        if (!isInitialized()) {
            RLog.e(TAG, "cancelHeartbeat. does not init.");
        } else {
            stopPushTimer(null, null, this.ALARM_REQUEST_CODE);
            stopPingTimer();
        }
    }

    public void connect() {
        if (isInitialized()) {
            getHandler().sendEmptyMessage(1);
        } else {
            RLog.e(TAG, "connect does not init.");
        }
    }

    public void customPing() {
        if (isInitialized()) {
            getHandler().sendEmptyMessage(11);
        } else {
            RLog.e(TAG, "customPing: does not init.");
        }
    }

    public void disconnect() {
        if (!isInitialized()) {
            RLog.e(TAG, "disconnect does not init.");
        } else {
            cancelHeartbeat();
            getHandler().sendEmptyMessage(4);
        }
    }

    public NetworkType getNetworkType() {
        return this.networkType;
    }

    public synchronized void init(final Context context, String str, String str2) {
        RLog.d(TAG, "init, initialized = " + this.initialized + ", deviceId = " + str + ", appKey = " + str2);
        this.mContext = context;
        this.initialized = true;
        this.appKey = str2;
        this.pushNaviClient = new PushNaviClient();
        HandlerThread handlerThread = new HandlerThread("connect");
        handlerThread.start();
        this.connectHandler = new PushConnectHandler(handlerThread.getLooper());
        this.pushClient = new PushClient(context, str2, DeviceUtils.getPhoneInformation(context), new PushClient.ClientListener() { // from class: io.rong.push.rongpush.PushConnectivityManager.1
            @Override // io.rong.push.core.PushClient.ClientListener
            public void onDisConnected() {
                RLog.d(PushConnectivityManager.TAG, "onDisConnected");
                PushConnectivityManager.this.getHandler().sendEmptyMessage(5);
            }

            @Override // io.rong.push.core.PushClient.ClientListener
            public void onMessageArrived(PushProtocalStack.PublishMessage publishMessage) {
                if (publishMessage == null || TextUtils.isEmpty(publishMessage.getDataAsString())) {
                    RLog.e(PushConnectivityManager.TAG, "sendNotification, msg = null");
                    return;
                }
                RLog.i(PushConnectivityManager.TAG, publishMessage.getDataAsString());
                PushNotificationMessage pushNotificationMessageTransformToPushMessage = PushUtils.transformToPushMessage(publishMessage.getDataAsString());
                String packageName = PushUtils.getPackageName(publishMessage.getDataAsString());
                if (TextUtils.isEmpty(packageName)) {
                    RLog.e(PushConnectivityManager.TAG, "package name can't empty!");
                    return;
                }
                Intent intent = new Intent();
                intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED);
                intent.setPackage(packageName);
                intent.putExtra(PushConst.PUSH_TYPE, PushType.RONG.getName());
                intent.putExtra("message", pushNotificationMessageTransformToPushMessage);
                if (Build.VERSION.SDK_INT >= 12) {
                    intent.setFlags(32);
                }
                context.sendBroadcast(intent);
            }

            @Override // io.rong.push.core.PushClient.ClientListener
            public void onPingFailure() {
                RLog.d(PushConnectivityManager.TAG, "onPingFailure");
                PushConnectivityManager.this.getHandler().sendEmptyMessage(7);
            }

            @Override // io.rong.push.core.PushClient.ClientListener
            public void onPingSuccess() {
                RLog.d(PushConnectivityManager.TAG, "onPingSuccess");
                PushConnectivityManager.this.getHandler().sendEmptyMessage(8);
            }
        });
        addState(this.disconnectedState);
        addState(this.naviConnectingState, this.disconnectedState);
        addState(this.connectingState, this.disconnectedState);
        addState(this.connectedState, this.disconnectedState);
        addState(this.pingState, this.disconnectedState);
        addState(this.customPingState, this.disconnectedState);
        setInitialState(this.disconnectedState);
        start();
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void onPingTimeout() {
        if (isInitialized()) {
            getHandler().sendEmptyMessage(7);
        } else {
            RLog.e(TAG, "onPingTimeout: does not init.");
        }
    }

    public void ping() {
        if (isInitialized()) {
            getHandler().sendEmptyMessage(6);
        } else {
            RLog.e(TAG, "ping: does not init.");
        }
    }

    public void sendRegistrationIDToServer(String str) {
        if (!isInitialized()) {
            RLog.e(TAG, "sendRegistrationIDToServer: does not init.");
            return;
        }
        Message message = new Message();
        message.what = 10;
        message.obj = str;
        getHandler().sendMessage(message);
    }

    public void setNetworkType(NetworkType networkType) {
        this.networkType = networkType;
    }

    @TargetApi(23)
    public void setNextHeartbeat() {
        long jElapsedRealtime;
        RLog.i(TAG, "startHeartbeat");
        if (!isInitialized()) {
            RLog.e(TAG, "setNextHeartbeat. does not init.");
            return;
        }
        try {
            jElapsedRealtime = SystemClock.elapsedRealtime() + Long.parseLong(this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("push_heartbeat_timer", "string", this.mContext.getPackageName())));
        } catch (Exception unused) {
            RLog.d(TAG, "use default heartbeat timer.");
            jElapsedRealtime = 240000 + SystemClock.elapsedRealtime();
        }
        startPushTimer(null, null, this.ALARM_REQUEST_CODE, jElapsedRealtime);
    }

    public void setServerDomain(String str) {
        RLog.i(TAG, "setServerDomain " + str);
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "server address can't be empty!!");
            return;
        }
        PushNaviClient pushNaviClient = this.pushNaviClient;
        if (pushNaviClient == null) {
            RLog.e(TAG, "should init first!");
        } else {
            pushNaviClient.setPushNaviUrl(str);
        }
    }

    public void startPingTimer() {
        RLog.i(TAG, "startPingTimer, 10s");
        if (!isInitialized()) {
            RLog.e(TAG, "startPingTimer. does not init.");
        } else {
            startPushTimer(PushConst.PING_STRING_EXTRA, PushConst.PING_STRING_EXTRA, this.ALARM_PING_REQUEST_CODE, SystemClock.elapsedRealtime() + 10000);
        }
    }

    public void stopPingTimer() {
        RLog.i(TAG, "stopPingTimer");
        if (isInitialized()) {
            stopPushTimer(PushConst.PING_STRING_EXTRA, PushConst.PING_STRING_EXTRA, this.ALARM_PING_REQUEST_CODE);
        } else {
            RLog.e(TAG, "stopPingTimer. does not init.");
        }
    }

    public void uninit() {
        PushClient pushClient = this.pushClient;
        if (pushClient != null) {
            pushClient.uninit();
        }
        cancelHeartbeat();
        this.initialized = false;
    }
}
