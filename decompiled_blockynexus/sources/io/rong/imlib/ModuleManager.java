package io.rong.imlib;

import android.content.Context;
import io.rong.common.RLog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.cs.CustomServiceManager;
import io.rong.imlib.location.RealTimeLocationManager;
import io.rong.imlib.model.Message;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ModuleManager {
    private static final String TAG = "ModuleManager";
    private static Object rongCallClientInstance;
    private static RongIMClient.OnReceiveMessageListener sListener;
    private static CopyOnWriteArrayList<MessageRouter> messageRouters = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<ConnectivityStateChangedListener> connectivityStateChangedListeners = new CopyOnWriteArrayList<>();

    public interface ConnectivityStateChangedListener {
        void onChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus);
    }

    public interface MessageRouter {
        boolean onReceived(Message message, int i, boolean z, int i2);
    }

    public static void addConnectivityStateChangedListener(ConnectivityStateChangedListener connectivityStateChangedListener) {
        connectivityStateChangedListeners.add(connectivityStateChangedListener);
    }

    public static void addMessageRouter(MessageRouter messageRouter) {
        messageRouters.add(messageRouter);
    }

    static void connectivityChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        Iterator<ConnectivityStateChangedListener> it = connectivityStateChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onChanged(connectionStatus);
        }
    }

    public static RongIMClient.OnReceiveMessageListener getListener() {
        return sListener;
    }

    static void init(Context context, IHandler iHandler, RongIMClient.OnReceiveMessageListener onReceiveMessageListener) {
        RLog.i(TAG, "init");
        sListener = onReceiveMessageListener;
        try {
            rongCallClientInstance = Class.forName("io.rong.calllib.RongCallClient").getConstructor(Context.class, IHandler.class).newInstance(context, iHandler);
        } catch (Exception unused) {
            RLog.i(TAG, "Can not find RongCallClient module.");
        }
        RealTimeLocationManager.getInstance().init(context, onReceiveMessageListener, iHandler);
        CustomServiceManager.getInstance().init(context, onReceiveMessageListener, iHandler);
    }

    public static void removeConnectivityStateChangedListener(ConnectivityStateChangedListener connectivityStateChangedListener) {
        connectivityStateChangedListeners.remove(connectivityStateChangedListener);
    }

    public static void removeMessageRouter(MessageRouter messageRouter) {
        messageRouters.remove(messageRouter);
    }

    static boolean routeMessage(Message message, int i, boolean z, int i2) {
        Iterator<MessageRouter> it = messageRouters.iterator();
        while (it.hasNext()) {
            if (it.next().onReceived(message, i, z, i2)) {
                return true;
            }
        }
        return false;
    }

    static void unInit() {
        if (rongCallClientInstance != null) {
            try {
                Method method = Class.forName("io.rong.calllib.RongCallClient").getMethod("unInit", null);
                method.setAccessible(true);
                method.invoke(rongCallClientInstance, null);
            } catch (ClassNotFoundException e2) {
                RLog.e(TAG, "unInit ClassNotFoundException", e2);
            } catch (IllegalAccessException e3) {
                RLog.e(TAG, "unInit IllegalAccessException", e3);
            } catch (NoSuchMethodException e4) {
                RLog.e(TAG, "unInit NoSuchMethodException", e4);
            } catch (InvocationTargetException e5) {
                RLog.e(TAG, "unInit InvocationTargetException", e5);
            }
            rongCallClientInstance = null;
        }
    }
}
