package io.rong.push.core;

import android.content.Context;
import io.rong.imlib.common.BuildVar;
import io.rong.push.PushErrorCode;
import io.rong.push.common.RLog;
import io.rong.push.core.PushProtocalStack;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public class PushClient {
    private static final String TAG = "PushClient";
    private String appKey;
    private ConnectStatusCallback connectCallback;
    private Context context;
    private String deviceInfo;
    private PushProtocalStack.MessageInputStream in;
    private ClientListener listener;
    private PushProtocalStack.MessageOutputStream out;
    private QueryCallback queryCallback;
    private PushReader reader;
    private boolean running;
    private Socket socket;

    /* JADX INFO: renamed from: io.rong.push.core.PushClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type = new int[PushProtocalStack.Message.Type.values().length];

        static {
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[PushProtocalStack.Message.Type.CONNACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[PushProtocalStack.Message.Type.PINGRESP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[PushProtocalStack.Message.Type.QUERYACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[PushProtocalStack.Message.Type.PUBLISH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[PushProtocalStack.Message.Type.DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface ClientListener {
        void onDisConnected();

        void onMessageArrived(PushProtocalStack.PublishMessage publishMessage);

        void onPingFailure();

        void onPingSuccess();
    }

    public interface ConnectStatusCallback {
        void onConnected();

        void onError();
    }

    private class PushReader extends Thread {
        private PushReader() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            PushProtocalStack.Message message = null;
            while (PushClient.this.running) {
                try {
                    Thread.sleep(100L);
                    if (PushClient.this.in != null) {
                        message = PushClient.this.in.readMessage();
                    }
                    if (message != null) {
                        PushClient.this.handleMessage(message);
                    }
                } catch (Exception e2) {
                    RLog.e(PushClient.TAG, "PushReader IOException. " + e2.getMessage());
                    e2.printStackTrace();
                    if (PushClient.this.listener != null) {
                        PushClient.this.listener.onDisConnected();
                        return;
                    }
                    return;
                }
            }
        }

        /* synthetic */ PushReader(PushClient pushClient, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface QueryCallback {
        void onFailure(PushErrorCode pushErrorCode);

        void onSuccess(String str);
    }

    public enum QueryMethod {
        GET_PUSH_TYPE("getPushType"),
        SET_TOKEN("setToken");

        private String methodName;

        QueryMethod(String str) {
            this.methodName = str;
        }

        public String getMethodName() {
            return this.methodName;
        }
    }

    public PushClient(Context context, String str, String str2, ClientListener clientListener) {
        this.context = context;
        this.appKey = str;
        this.listener = clientListener;
        this.deviceInfo = str2;
        this.appKey = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(PushProtocalStack.Message message) throws IOException {
        ClientListener clientListener;
        if (message == null) {
            return;
        }
        RLog.d(TAG, "handleMessage, msg type = " + message.getType());
        int i = AnonymousClass1.$SwitchMap$io$rong$push$core$PushProtocalStack$Message$Type[message.getType().ordinal()];
        if (i == 1) {
            ConnectStatusCallback connectStatusCallback = this.connectCallback;
            if (connectStatusCallback != null) {
                connectStatusCallback.onConnected();
                return;
            }
            return;
        }
        if (i == 2) {
            ClientListener clientListener2 = this.listener;
            if (clientListener2 != null) {
                clientListener2.onPingSuccess();
                return;
            }
            return;
        }
        if (i != 3) {
            if (i != 4) {
                if (i == 5 && (clientListener = this.listener) != null) {
                    clientListener.onDisConnected();
                    return;
                }
                return;
            }
            ClientListener clientListener3 = this.listener;
            if (clientListener3 != null) {
                clientListener3.onMessageArrived((PushProtocalStack.PublishMessage) message);
                return;
            }
            return;
        }
        PushProtocalStack.QueryAckMessage queryAckMessage = (PushProtocalStack.QueryAckMessage) message;
        int status = queryAckMessage.getStatus();
        RLog.d(TAG, "queryAck status:" + status + "content:" + queryAckMessage.getDataAsString());
        if (this.queryCallback != null) {
            if (status == PushProtocalStack.QueryAckMessage.QueryStatus.STATUS_OK.get()) {
                this.queryCallback.onSuccess(queryAckMessage.getDataAsString());
            } else {
                this.queryCallback.onFailure(PushErrorCode.NOT_REGISTER_IN_ADMIN);
            }
        }
    }

    public void connect(String str, int i, String str2, ConnectStatusCallback connectStatusCallback) {
        RLog.d(TAG, "connect, deviceId = " + str2 + ", host = " + str + ", port = " + i);
        if (this.reader != null) {
            Socket socket = this.socket;
            if (socket != null && socket.isConnected()) {
                RLog.d(TAG, "old socket is connected. Ignore this connect event.");
                return;
            } else {
                RLog.d(TAG, "reset old socket.");
                reset();
            }
        }
        try {
            this.socket = new Socket();
            this.socket.connect(new InetSocketAddress(str, i), 4000);
            this.in = new PushProtocalStack.MessageInputStream(this.socket.getInputStream());
            this.out = new PushProtocalStack.MessageOutputStream(this.socket.getOutputStream());
            this.connectCallback = connectStatusCallback;
            PushProtocalStack.ConnectMessage connectMessage = new PushProtocalStack.ConnectMessage(str2, true, 300);
            connectMessage.setWill(this.context.getPackageName(), String.format("%s-%s-%s", "AndroidPush", this.deviceInfo, BuildVar.SDK_VERSION));
            connectMessage.setCredentials(this.appKey);
            this.out.writeMessage(connectMessage);
            this.reader = new PushReader(this, null);
            this.running = true;
            this.reader.start();
        } catch (Exception e2) {
            RLog.e(TAG, "connect IOException");
            e2.printStackTrace();
            if (connectStatusCallback != null) {
                connectStatusCallback.onError();
            }
        }
    }

    public void disconnect() {
        ClientListener clientListener;
        RLog.d(TAG, "disconnect");
        try {
            try {
                if (this.reader != null) {
                    this.reader.interrupt();
                }
                if (this.in != null) {
                    this.in.close();
                }
                if (this.out != null) {
                    this.out.close();
                }
                if (this.socket != null) {
                    this.socket.close();
                }
                this.running = false;
                this.reader = null;
                this.in = null;
                this.out = null;
                this.socket = null;
                clientListener = this.listener;
                if (clientListener == null) {
                    return;
                }
            } catch (IOException e2) {
                RLog.e(TAG, "disconnect IOException");
                e2.printStackTrace();
                this.running = false;
                this.reader = null;
                this.in = null;
                this.out = null;
                this.socket = null;
                clientListener = this.listener;
                if (clientListener == null) {
                    return;
                }
            }
            clientListener.onDisConnected();
        } catch (Throwable th) {
            this.running = false;
            this.reader = null;
            this.in = null;
            this.out = null;
            this.socket = null;
            ClientListener clientListener2 = this.listener;
            if (clientListener2 != null) {
                clientListener2.onDisConnected();
            }
            throw th;
        }
    }

    public void ping() {
        try {
            if (this.socket != null && this.socket.isConnected() && this.out != null) {
                this.out.writeMessage(new PushProtocalStack.PingReqMessage());
            } else if (this.listener != null) {
                this.listener.onPingFailure();
            }
        } catch (IOException e2) {
            RLog.e(TAG, "ping IOException");
            e2.printStackTrace();
            ClientListener clientListener = this.listener;
            if (clientListener != null) {
                clientListener.onPingFailure();
            }
        }
    }

    public void query(QueryMethod queryMethod, String str, String str2, QueryCallback queryCallback) {
        RLog.d(TAG, "query. topic:" + queryMethod.getMethodName() + ", queryInfo:" + str);
        this.queryCallback = queryCallback;
        try {
            if (this.socket == null || !this.socket.isConnected() || this.out == null || !this.running) {
                RLog.e(TAG, "server has disconnected");
                this.queryCallback.onFailure(PushErrorCode.SERVER_DISCONNECTED);
            } else {
                this.out.writeMessage(new PushProtocalStack.QueryMessage(queryMethod.getMethodName(), str, str2));
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            this.queryCallback.onFailure(PushErrorCode.IO_EXCEPTION);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reset() {
        RLog.d(TAG, "reset");
        try {
            try {
                if (this.reader != null) {
                    this.reader.interrupt();
                }
                if (this.socket != null) {
                    this.socket.close();
                }
                if (this.in != null) {
                    this.in.close();
                }
                if (this.out != null) {
                    this.out.close();
                }
            } catch (IOException e2) {
                RLog.e(TAG, "reset IOException");
                e2.printStackTrace();
            }
        } finally {
            this.running = false;
            this.reader = null;
            this.socket = null;
            this.in = null;
            this.out = null;
        }
    }

    public void uninit() {
        this.listener = null;
        disconnect();
    }
}
