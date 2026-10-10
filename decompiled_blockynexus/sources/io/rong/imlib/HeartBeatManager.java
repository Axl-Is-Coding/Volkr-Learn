package io.rong.imlib;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import io.rong.common.RLog;
import io.rong.common.WakeLockUtils;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.RongIMClient;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes5.dex */
public class HeartBeatManager {
    private static final long PING_ACQUIRE_WAKELOCK_TIME = 1000;
    private static final long PING_MAX_TIME_OUT = 90000;
    private static final long PING_PERIOD = 15000;
    private static final String TAG = "heartBeatManager";
    private volatile long acquireWakeLockTime;
    private HeartBeatListener heartBeatListener;
    private ConcurrentLinkedQueue<Long> heartBeatQueue;
    private volatile boolean isBackground;
    private final Object mLock;
    private PowerManager.WakeLock mRunWakeLock;
    private Handler mWorkHandler;
    private NativeObject nativeObject;
    private PowerManager pm;
    private Timer timer;

    interface HeartBeatListener {
        void onPongReceiveFail();
    }

    static class HeartBeatManagerHolder {
        static final HeartBeatManager instance = new HeartBeatManager();

        HeartBeatManagerHolder() {
        }
    }

    private void acquirePingWakeLock(Context context) {
        synchronized (this.mLock) {
            if (this.pm == null) {
                RLog.d(TAG, "acquirePingWakeLock pm is null");
                this.pm = (PowerManager) context.getApplicationContext().getSystemService("power");
            }
            if (this.mRunWakeLock == null && this.pm != null) {
                this.mRunWakeLock = this.pm.newWakeLock(1, "HeartBeatManager:run");
            }
            if (this.mRunWakeLock != null && !this.mRunWakeLock.isHeld()) {
                RLog.d(TAG, "acquirePingWakeLock");
                this.mRunWakeLock.acquire(this.acquireWakeLockTime);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void enqueue(long j, int i) {
        RLog.d(TAG, "enqueue pingCode = " + i);
        boolean zIsPingTimeOut = isPingTimeOut(j);
        RLog.d(TAG, "isTimeOut = " + zIsPingTimeOut);
        if (zIsPingTimeOut) {
            resetQueueAndReconnect();
        } else if (i == 0 && this.heartBeatQueue != null) {
            this.heartBeatQueue.add(Long.valueOf(j));
        }
    }

    public static HeartBeatManager getInstance() {
        return HeartBeatManagerHolder.instance;
    }

    private void initConfig(Context context) {
        RLog.d(TAG, "initConfig");
        Resources resources = context.getResources();
        try {
            this.acquireWakeLockTime = Long.parseLong(resources.getString(resources.getIdentifier("rc_heartbeat_acquire_time", "string", context.getPackageName())));
        } catch (Exception unused) {
            this.acquireWakeLockTime = 1000L;
            RLog.e(TAG, "Read config file exception. Use default heartbeat time value.");
        }
        if (this.acquireWakeLockTime < 1000) {
            this.acquireWakeLockTime = 1000L;
        }
    }

    private boolean isPingTimeOut(long j) {
        Long lPeek;
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue = this.heartBeatQueue;
        return (concurrentLinkedQueue == null || (lPeek = concurrentLinkedQueue.peek()) == null || j - lPeek.longValue() <= PING_MAX_TIME_OUT) ? false : true;
    }

    private void releasePingWakeLock() {
        synchronized (this.mLock) {
            if (this.mRunWakeLock != null && this.mRunWakeLock.isHeld()) {
                RLog.d(TAG, "releasePingWakeLock");
                try {
                    this.mRunWakeLock.release();
                } catch (Exception e2) {
                    RLog.e(TAG, "releasePingWakeLock exception ", e2);
                }
                this.mRunWakeLock.setReferenceCounted(false);
                this.mRunWakeLock = null;
            }
        }
    }

    private void resetQueue() {
        RLog.d(TAG, "resetQueue");
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue = this.heartBeatQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }

    private void resetQueueAndReconnect() {
        RLog.d(TAG, "resetQueueAndReconnect");
        resetQueue();
        retry();
    }

    private void retry() {
        RLog.d(TAG, "retry");
        HeartBeatListener heartBeatListener = this.heartBeatListener;
        if (heartBeatListener != null) {
            heartBeatListener.onPongReceiveFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPingWithWakeLock(Context context) {
        RLog.d(TAG, "startPingWithWakeLock");
        acquirePingWakeLock(context);
        enqueue(System.currentTimeMillis(), this.nativeObject.ping());
        scheduleHeartbeat(context);
    }

    private synchronized void startReplenishHeartbeat(final NativeObject nativeObject) {
        if (this.timer == null) {
            RLog.d(TAG, "start replenish heartbeat");
            this.timer = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: io.rong.imlib.HeartBeatManager.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "interval|enabled", Long.valueOf(HeartBeatManager.PING_PERIOD), "polling");
                    HeartBeatManager.this.enqueue(System.currentTimeMillis(), nativeObject.ping());
                }
            };
            FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "interval|enabled", 0, true);
            this.timer.schedule(timerTask, 0L, PING_PERIOD);
        }
    }

    private synchronized void stopReplenishHeartbeat() {
        if (this.timer != null) {
            FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "interval|enabled", Long.valueOf(PING_PERIOD), false);
            this.timer.cancel();
            this.timer = null;
            RLog.d(TAG, "stop replenish heartbeat");
        }
    }

    void cancelSDKHeartBeat(Context context) {
        RLog.d(TAG, "cancelSDKHeartBeat");
        FwLog.write(2, 1, FwLog.LogTag.L_PING_S.getTag(), "cancel", true);
        WakeLockUtils.cancelSDKHeartBeat(context);
    }

    synchronized void dequeue() {
        RLog.d(TAG, "dequeue");
        boolean zIsPingTimeOut = isPingTimeOut(System.currentTimeMillis());
        RLog.d(TAG, "isTimeOut = " + zIsPingTimeOut);
        if (zIsPingTimeOut) {
            resetQueueAndReconnect();
        } else if (this.heartBeatQueue != null) {
            this.heartBeatQueue.poll();
        }
        releasePingWakeLock();
    }

    void init(Context context, NativeObject nativeObject) {
        RLog.d(TAG, "init : " + nativeObject);
        if (nativeObject == null) {
            throw new RuntimeException("NativeClient is uninitialized!");
        }
        this.nativeObject = nativeObject;
        HandlerThread handlerThread = new HandlerThread("PING_WORK");
        handlerThread.start();
        this.mWorkHandler = new Handler(handlerThread.getLooper());
        initConfig(context);
    }

    void ping(final Context context) {
        RLog.d(TAG, "ping");
        FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "time", Long.valueOf(System.currentTimeMillis()));
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: io.rong.imlib.HeartBeatManager.1
                @Override // java.lang.Runnable
                public void run() {
                    HeartBeatManager.this.startPingWithWakeLock(context);
                }
            });
        }
    }

    void removeHeartbeatFromAM(Context context) {
        RLog.d(TAG, "cancelHeartbeat");
        WakeLockUtils.cancelHeartbeat(context);
    }

    synchronized void replenishPing(Context context, int i) {
        replenishPing(context, this.isBackground, i);
    }

    void scheduleHeartbeat(Context context) {
        RLog.d(TAG, "scheduleHeartbeat");
        WakeLockUtils.scheduleHeartbeat(context);
    }

    void setHeartBeatListener(HeartBeatListener heartBeatListener) {
        this.heartBeatListener = heartBeatListener;
    }

    void setIsBackgroundMode(Context context, boolean z) {
        this.isBackground = z;
        replenishPing(context, z, ConnectionService.getInstance().getConnectionState().getCurrentStatus().getValue());
    }

    private HeartBeatManager() {
        this.mRunWakeLock = null;
        this.mLock = new Object();
        this.heartBeatQueue = new ConcurrentLinkedQueue<>();
    }

    private synchronized void replenishPing(Context context, boolean z, int i) {
        RLog.d(TAG, "replenishPing context = " + context + "，isBackground = " + z + ", status = " + i);
        if (i != RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED.getValue()) {
            removeHeartbeatFromAM(context);
            stopReplenishHeartbeat();
        } else if (z) {
            stopReplenishHeartbeat();
        } else {
            startReplenishHeartbeat(this.nativeObject);
        }
    }
}
