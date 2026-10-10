package io.rong.imlib.statistics;

import android.content.Context;
import android.util.Log;
import io.rong.imlib.statistics.Statistics;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionQueue {
    private String appKey_;
    private Future<?> connectionProcessorFuture_;
    private Context context_;
    private DeviceId deviceId_;
    private ExecutorService executor_;
    private String serverURL_;
    private SSLContext sslContext_;
    private StatisticsStore store_;

    void beginSession() {
        if (this.store_.uploadIfNeed()) {
            checkInternalState();
            this.store_.addConnection(("deviceId=" + this.deviceId_.getId() + "&appKey=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp()) + "&deviceInfo=" + DeviceInfo.getMetrics(this.context_));
            tick();
        }
    }

    void checkInternalState() {
        if (this.context_ == null) {
            throw new IllegalStateException("context has not been set");
        }
        String str = this.appKey_;
        if (str == null || str.length() == 0) {
            throw new IllegalStateException("app key has not been set");
        }
        if (this.store_ == null) {
            throw new IllegalStateException("countly store has not been set");
        }
        String str2 = this.serverURL_;
        if (str2 == null || !Statistics.isValidURL(str2)) {
            throw new IllegalStateException("server URL is not valid");
        }
    }

    void endSession(int i) {
        checkInternalState();
        String str = "app_key=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + "&end_session=1";
        if (i > 0) {
            str = str + "&session_duration=" + i;
        }
        this.store_.addConnection(str);
        tick();
    }

    void ensureExecutor() {
        if (this.executor_ == null) {
            this.executor_ = Executors.newSingleThreadExecutor();
        }
    }

    String getAppKey() {
        return this.appKey_;
    }

    Future<?> getConnectionProcessorFuture() {
        return this.connectionProcessorFuture_;
    }

    Context getContext() {
        return this.context_;
    }

    StatisticsStore getCountlyStore() {
        return this.store_;
    }

    DeviceId getDeviceId() {
        return this.deviceId_;
    }

    ExecutorService getExecutor() {
        return this.executor_;
    }

    String getServerURL() {
        return this.serverURL_;
    }

    void recordEvents(String str) {
        checkInternalState();
        this.store_.addConnection("deviceId=" + this.deviceId_.getId() + "&appKey=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + "&pushEvent=" + str);
        tick();
    }

    void recordLocation(String str) {
        checkInternalState();
        this.store_.addConnection("app_key=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + "&events=" + str);
        tick();
    }

    void sendCrashReport(String str, boolean z) {
        checkInternalState();
        this.store_.addConnection("app_key=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + "&sdk_version=" + Statistics.COUNTLY_SDK_VERSION_STRING + "&crash=" + CrashDetails.getCrashData(this.context_, str, Boolean.valueOf(z)));
        tick();
    }

    void sendReferrerData(String str) {
        checkInternalState();
        if (str != null) {
            this.store_.addConnection("app_key=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + str);
            tick();
        }
    }

    void sendUserData() {
        checkInternalState();
        String dataForRequest = UserData.getDataForRequest();
        if (dataForRequest.equals("")) {
            return;
        }
        this.store_.addConnection("app_key=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + dataForRequest);
        tick();
    }

    void setAppKey(String str) {
        this.appKey_ = str;
    }

    void setConnectionProcessorFuture(Future<?> future) {
        this.connectionProcessorFuture_ = future;
    }

    void setContext(Context context) {
        this.context_ = context;
    }

    void setCountlyStore(StatisticsStore statisticsStore) {
        this.store_ = statisticsStore;
    }

    public void setDeviceId(DeviceId deviceId) {
        this.deviceId_ = deviceId;
    }

    void setExecutor(ExecutorService executorService) {
        this.executor_ = executorService;
    }

    void setServerURL(String str) {
        this.serverURL_ = str;
        if (!str.startsWith("https")) {
            this.sslContext_ = null;
            return;
        }
        try {
            Log.d("Statistics", "init ssl");
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: io.rong.imlib.statistics.ConnectionQueue.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str2) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            this.sslContext_ = SSLContext.getInstance("TLS");
            this.sslContext_.init(null, trustManagerArr, null);
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    void tick() {
        if (this.store_.isEmptyConnections()) {
            return;
        }
        Future<?> future = this.connectionProcessorFuture_;
        if (future == null || future.isDone()) {
            ensureExecutor();
            this.connectionProcessorFuture_ = this.executor_.submit(new ConnectionProcessor(this.serverURL_, this.store_, this.deviceId_, this.sslContext_));
        }
    }

    public void tokenSession(String str, Statistics.CountlyMessagingMode countlyMessagingMode) {
        checkInternalState();
        StringBuilder sb = new StringBuilder();
        sb.append("app_key=");
        sb.append(this.appKey_);
        sb.append("&timestamp=");
        sb.append(Statistics.currentTimestamp());
        sb.append("&token_session=1&android_token=");
        sb.append(str);
        sb.append("&test_mode=");
        sb.append(countlyMessagingMode == Statistics.CountlyMessagingMode.TEST ? 2 : 0);
        sb.append("&locale=");
        sb.append(DeviceInfo.getLocale());
        final String string = sb.toString();
        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() { // from class: io.rong.imlib.statistics.ConnectionQueue.2
            @Override // java.lang.Runnable
            public void run() {
                ConnectionQueue.this.store_.addConnection(string);
                ConnectionQueue.this.tick();
            }
        }, 10L, TimeUnit.SECONDS);
    }

    void updateSession(int i) {
        checkInternalState();
        if (i > 0) {
            this.store_.addConnection("deviceId=" + this.deviceId_.getId() + "&appKey=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp());
            tick();
        }
    }

    void recordEvents(String str, String str2) {
        checkInternalState();
        this.store_.addConnection("deviceId=" + this.deviceId_.getId() + "&appKey=" + this.appKey_ + "&timestamp=" + Statistics.currentTimestamp() + "&" + str + "=" + str2);
        tick();
    }
}
