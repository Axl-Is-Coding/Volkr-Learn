package io.rong.imlib.statistics;

import android.content.Context;
import android.util.Log;
import io.rong.imlib.statistics.DeviceId;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Statistics {
    public static final String COUNTLY_SDK_VERSION_STRING = "15.06";
    public static final String DEFAULT_APP_VERSION = "1.0";
    private static final int EVENT_QUEUE_SIZE_THRESHOLD = 10;
    public static final String TAG = "Statistics";
    protected static List<String> publicKeyPinCertificates;
    private int activityCount_;
    private ConnectionQueue connectionQueue_ = new ConnectionQueue();
    private Context context_;
    private DeviceId deviceId_Manager_;
    private boolean disableUpdateSessionRequests_;
    private boolean enableLogging_;
    private EventQueue eventQueue_;
    private CountlyMessagingMode messagingMode_;
    private long prevSessionDurationStartTime_;
    private ScheduledExecutorService timerService_;

    public enum CountlyMessagingMode {
        TEST,
        PRODUCTION
    }

    private static class SingletonHolder {
        static final Statistics instance = new Statistics();

        private SingletonHolder() {
        }
    }

    Statistics() {
    }

    static int currentTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static Statistics enablePublicKeyPinning(List<String> list) {
        publicKeyPinCertificates = list;
        return sharedInstance();
    }

    static boolean isValidURL(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static Statistics sharedInstance() {
        return SingletonHolder.instance;
    }

    public synchronized Statistics addCrashLog(String str) {
        CrashDetails.addLog(str);
        return this;
    }

    public synchronized Statistics enableCrashReporting() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.rong.imlib.statistics.Statistics.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                Statistics.this.connectionQueue_.sendCrashReport(stringWriter.toString(), false);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        });
        return this;
    }

    int getActivityCount() {
        return this.activityCount_;
    }

    ConnectionQueue getConnectionQueue() {
        return this.connectionQueue_;
    }

    boolean getDisableUpdateSessionRequests() {
        return this.disableUpdateSessionRequests_;
    }

    EventQueue getEventQueue() {
        return this.eventQueue_;
    }

    long getPrevSessionDurationStartTime() {
        return this.prevSessionDurationStartTime_;
    }

    ExecutorService getTimerService() {
        return this.timerService_;
    }

    public synchronized void halt() {
        this.eventQueue_ = null;
        StatisticsStore countlyStore = this.connectionQueue_.getCountlyStore();
        if (countlyStore != null) {
            countlyStore.clear();
        }
        this.connectionQueue_.setContext(null);
        this.connectionQueue_.setServerURL(null);
        this.connectionQueue_.setAppKey(null);
        this.connectionQueue_.setCountlyStore(null);
        this.prevSessionDurationStartTime_ = 0L;
        this.activityCount_ = 0;
    }

    public Statistics init(Context context, String str, String str2) {
        return init(context, str, str2, null, OpenUDIDAdapter.isOpenUDIDAvailable() ? DeviceId.Type.OPEN_UDID : DeviceId.Type.ADVERTISING_ID);
    }

    public synchronized boolean isInitialized() {
        return this.eventQueue_ != null;
    }

    public synchronized boolean isLoggingEnabled() {
        return this.enableLogging_;
    }

    public synchronized Statistics logException(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        this.connectionQueue_.sendCrashReport(stringWriter.toString(), true);
        return this;
    }

    public void onRegistrationId(String str) {
        this.connectionQueue_.tokenSession(str, this.messagingMode_);
    }

    public synchronized void onStart() {
        if (this.eventQueue_ == null) {
            throw new IllegalStateException("init must be called before onStart");
        }
        this.activityCount_++;
        if (this.activityCount_ == 1) {
            Log.i("Statistics", "start");
            onStartHelper();
        }
        String referrer = ReferrerReceiver.getReferrer(this.context_);
        if (sharedInstance().isLoggingEnabled()) {
            Log.d("Statistics", "Checking referrer: " + referrer);
        }
        if (referrer != null) {
            this.connectionQueue_.sendReferrerData(referrer);
            ReferrerReceiver.deleteReferrer(this.context_);
        }
        CrashDetails.inForeground();
    }

    void onStartHelper() {
        this.prevSessionDurationStartTime_ = System.nanoTime();
        this.connectionQueue_.beginSession();
    }

    public synchronized void onStop() {
        if (this.eventQueue_ == null) {
            throw new IllegalStateException("init must be called before onStop");
        }
        if (this.activityCount_ == 0) {
            throw new IllegalStateException("must call onStart before onStop");
        }
        this.activityCount_--;
        if (this.activityCount_ == 0) {
            onStopHelper();
        }
        CrashDetails.inBackground();
    }

    void onStopHelper() {
        this.connectionQueue_.endSession(roundedSecondsSinceLastSessionDurationUpdate());
        this.prevSessionDurationStartTime_ = 0L;
        if (this.eventQueue_.size() > 0) {
            this.connectionQueue_.recordEvents(this.eventQueue_.events());
        }
    }

    synchronized void onTimer() {
        boolean z = true;
        if (this.activityCount_ > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTimer: update=");
            if (this.disableUpdateSessionRequests_) {
                z = false;
            }
            sb.append(z);
            sb.append(", queue=");
            sb.append(this.eventQueue_.size());
            Log.d("Statistics", sb.toString());
            if (!this.disableUpdateSessionRequests_) {
                this.connectionQueue_.updateSession(roundedSecondsSinceLastSessionDurationUpdate());
            }
            if (this.eventQueue_.size() > 0) {
                this.connectionQueue_.recordEvents(this.eventQueue_.events());
            }
        }
    }

    public void recordEvent(String str) {
        recordEvent(str, null, 1, 0.0d);
    }

    int roundedSecondsSinceLastSessionDurationUpdate() {
        long jNanoTime = System.nanoTime();
        long j = jNanoTime - this.prevSessionDurationStartTime_;
        this.prevSessionDurationStartTime_ = jNanoTime;
        double d2 = j;
        Double.isNaN(d2);
        return (int) Math.round(d2 / 1.0E9d);
    }

    void sendEventsIfNeeded() {
        Log.d("Statistics", "sendEventsIfNeeded: queue=" + this.eventQueue_.size());
        if (this.eventQueue_.size() >= 10) {
            this.connectionQueue_.recordEvents(this.eventQueue_.events());
        }
    }

    void setConnectionQueue(ConnectionQueue connectionQueue) {
        this.connectionQueue_ = connectionQueue;
    }

    public synchronized Statistics setCustomCrashSegments(Map<String, String> map) {
        if (map != null) {
            CrashDetails.setCustomSegments(map);
        }
        return this;
    }

    public synchronized Statistics setCustomUserData(Map<String, String> map) {
        if (map != null) {
            UserData.setCustomData(map);
            this.connectionQueue_.sendUserData();
        } else {
            this.connectionQueue_.sendUserData();
        }
        return this;
    }

    public synchronized Statistics setDisableUpdateSessionRequests(boolean z) {
        this.disableUpdateSessionRequests_ = z;
        return this;
    }

    void setEventQueue(EventQueue eventQueue) {
        this.eventQueue_ = eventQueue;
    }

    public synchronized Statistics setLocation(double d2, double d3) {
        this.connectionQueue_.getCountlyStore().setLocation(d2, d3);
        if (this.disableUpdateSessionRequests_) {
            this.connectionQueue_.updateSession(roundedSecondsSinceLastSessionDurationUpdate());
        }
        return this;
    }

    public synchronized Statistics setLoggingEnabled(boolean z) {
        this.enableLogging_ = z;
        return this;
    }

    void setPrevSessionDurationStartTime(long j) {
        this.prevSessionDurationStartTime_ = j;
    }

    public synchronized Statistics setUserData(Map<String, String> map) {
        return setUserData(map, null);
    }

    public Statistics init(Context context, String str, String str2, String str3) {
        return init(context, str, str2, str3, null);
    }

    public void recordEvent(String str, int i) {
        recordEvent(str, null, i, 0.0d);
    }

    public synchronized Statistics setUserData(Map<String, String> map, Map<String, String> map2) {
        UserData.setData(map);
        if (map2 != null) {
            UserData.setCustomData(map2);
        }
        this.connectionQueue_.sendUserData();
        return this;
    }

    public synchronized Statistics init(Context context, String str, String str2, String str3, DeviceId.Type type) {
        DeviceId deviceId;
        try {
            if (context != null) {
                if (isValidURL(str)) {
                    if (str2 != null && str2.length() != 0) {
                        if (str3 != null && str3.length() == 0) {
                            throw new IllegalArgumentException("valid deviceID is required");
                        }
                        if (str3 == null && type == null) {
                            if (OpenUDIDAdapter.isOpenUDIDAvailable()) {
                                type = DeviceId.Type.OPEN_UDID;
                            } else if (AdvertisingIdAdapter.isAdvertisingIdAvailable()) {
                                type = DeviceId.Type.ADVERTISING_ID;
                            }
                        }
                        if (str3 == null && type == DeviceId.Type.OPEN_UDID && !OpenUDIDAdapter.isOpenUDIDAvailable()) {
                            throw new IllegalArgumentException("valid deviceID is required because OpenUDID is not available");
                        }
                        if (str3 == null && type == DeviceId.Type.ADVERTISING_ID && !AdvertisingIdAdapter.isAdvertisingIdAvailable()) {
                            throw new IllegalArgumentException("valid deviceID is required because Advertising ID is not available (you need to include Google Play services 4.0+ into your project)");
                        }
                        if (this.eventQueue_ != null && (!this.connectionQueue_.getServerURL().equals(str) || !this.connectionQueue_.getAppKey().equals(str2) || !DeviceId.deviceIDEqualsNullSafe(str3, type, this.connectionQueue_.getDeviceId()))) {
                            throw new IllegalStateException("Statistics cannot be reinitialized with different values");
                        }
                        if (MessagingAdapter.isMessagingAvailable()) {
                            MessagingAdapter.storeConfiguration(context, str, str2, str3, type);
                        }
                        if (this.eventQueue_ == null) {
                            if (str3 != null) {
                                deviceId = new DeviceId(str3);
                            } else {
                                deviceId = new DeviceId(type);
                            }
                            StatisticsStore statisticsStore = new StatisticsStore(context);
                            deviceId.init(context, statisticsStore, true);
                            this.connectionQueue_.setServerURL(str);
                            this.connectionQueue_.setAppKey(str2);
                            this.connectionQueue_.setCountlyStore(statisticsStore);
                            this.connectionQueue_.setDeviceId(deviceId);
                            this.eventQueue_ = new EventQueue(statisticsStore);
                        }
                        this.context_ = context;
                        this.connectionQueue_.setContext(context);
                    } else {
                        throw new IllegalArgumentException("valid appKey is required");
                    }
                } else {
                    throw new IllegalArgumentException("valid serverURL is required");
                }
            } else {
                throw new IllegalArgumentException("valid context is required");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public void recordEvent(String str, int i, double d2) {
        recordEvent(str, null, i, d2);
    }

    public void recordEvent(String str, Map<String, String> map, int i) {
        recordEvent(str, map, i, 0.0d);
    }

    public synchronized void recordEvent(String str, Map<String, String> map, int i, double d2) {
        if (isInitialized()) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("Valid Statistics event key is required");
            }
            if (i >= 1) {
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        if (str2 != null && str2.length() != 0) {
                            if (map.get(str2) == null || map.get(str2).length() == 0) {
                                throw new IllegalArgumentException("Statistics event segmentation value cannot be null or empty");
                            }
                        } else {
                            throw new IllegalArgumentException("Statistics event segmentation key cannot be null or empty");
                        }
                    }
                }
                this.eventQueue_.recordEvent(str, map, i, d2);
                sendEventsIfNeeded();
            } else {
                throw new IllegalArgumentException("Statistics event count should be greater than zero");
            }
        } else {
            throw new IllegalStateException("Statistics.sharedInstance().init must be called before recordEvent");
        }
    }

    public synchronized void recordEvent(String str, Map<String, String> map) {
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        if (isInitialized()) {
            if (str != null && str.length() != 0) {
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        if (str2 != null && str2.length() != 0) {
                            if (map.get(str2) != null && map.get(str2).length() != 0) {
                                strArr[i] = str2;
                                int i2 = i + 1;
                                strArr[i2] = map.get(str2);
                                i = i2 + 1;
                            } else {
                                throw new IllegalArgumentException("Countly event segmentation value cannot be null or empty");
                            }
                        } else {
                            throw new IllegalArgumentException("Countly event segmentation key cannot be null or empty");
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                DeviceInfo.fillJSONIfValuesNotEmpty(jSONObject, strArr);
                String string = jSONObject.toString();
                try {
                    string = URLEncoder.encode(string, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                this.connectionQueue_.recordEvents(str, string);
            } else {
                throw new IllegalArgumentException("Valid Countly event key is required");
            }
        } else {
            throw new IllegalStateException("Countly.sharedInstance().init must be called before recordEvent");
        }
    }
}
