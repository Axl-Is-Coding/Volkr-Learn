package io.rong.push.pushconfig;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import io.rong.imlib.common.BuildVar;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.PushErrorCode;
import io.rong.push.PushType;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.common.RLog;
import io.rong.push.core.PushClient;
import io.rong.push.core.PushConnectHandler;
import io.rong.push.core.PushNaviClient;
import io.rong.push.core.PushProtocalStack;
import io.rong.push.core.PushUtils;
import io.rong.push.rongpush.PushReceiver;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PushConfigManager {
    private static PushClient pushClient;
    private final String TAG = PushConfigManager.class.getSimpleName();
    private IPushConfigObserver configResultCallback;
    private PushConnectHandler connectHandler;
    boolean isDisconnected;
    private boolean isInitialized;
    private PushConfig pushConfig;
    private PushConfigReceiver pushConfigReceiver;
    private PushNaviClient pushNaviClient;
    private String token;

    /* JADX INFO: renamed from: io.rong.push.pushconfig.PushConfigManager$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            PushConfigManager.this.pushNaviClient.getPushServerIPs(this.val$context, PushConfigManager.this.pushConfig.getAppKey(), false, new PushNaviObserver() { // from class: io.rong.push.pushconfig.PushConfigManager.2.1
                @Override // io.rong.push.pushconfig.PushNaviObserver
                public void onError(PushErrorCode pushErrorCode) {
                    RLog.e(PushConfigManager.this.TAG, "error when connect to navi.");
                    PushConfigManager.pushClient.disconnect();
                    PushConfigManager.this.configResultCallback.onError(pushErrorCode);
                }

                @Override // io.rong.push.pushconfig.PushNaviObserver
                public void onSuccess(ArrayList<String> arrayList) {
                    PushConfigManager.this.connectHandler.connect(AnonymousClass2.this.val$context, PushConfigManager.pushClient, arrayList, PushConfigManager.this.pushConfig.getAppKey(), new IResultCallback<String>() { // from class: io.rong.push.pushconfig.PushConfigManager.2.1.1
                        @Override // io.rong.push.pushconfig.IResultCallback
                        public void onError(PushErrorCode pushErrorCode) {
                            RLog.e(PushConfigManager.this.TAG, "error when connect to server.");
                            PushConfigManager.pushClient.disconnect();
                            PushConfigManager.this.configResultCallback.onError(pushErrorCode);
                        }

                        @Override // io.rong.push.pushconfig.IResultCallback
                        public void onSuccess(String str) {
                            StringBuilder sb = new StringBuilder();
                            boolean z = true;
                            for (PushType pushType : PushConfigManager.this.pushConfig.getEnabledPushTypes()) {
                                if (!z) {
                                    sb.append("|");
                                }
                                z = false;
                                sb.append(pushType.getName());
                            }
                            String string = sb.toString();
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            PushType preferPushType = PushUtils.getPreferPushType(anonymousClass2.val$context, PushConfigManager.this.pushConfig);
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            PushConfigManager pushConfigManager = PushConfigManager.this;
                            pushConfigManager.queryPushType(anonymousClass22.val$context, pushConfigManager.pushConfig.getAppKey(), string, preferPushType);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryPushType(final Context context, final String str, final String str2, final PushType pushType) {
        this.connectHandler.post(new Runnable() { // from class: io.rong.push.pushconfig.PushConfigManager.3
            @Override // java.lang.Runnable
            public void run() {
                String strReplace = context.getPackageName().replace("-", "_");
                PushConfigManager.pushClient.query(PushClient.QueryMethod.GET_PUSH_TYPE, String.format("%s-%s-%s-%s", str2, str, strReplace, DeviceUtils.getDeviceManufacturer()), DeviceUtils.getDeviceId(context, str), new PushClient.QueryCallback() { // from class: io.rong.push.pushconfig.PushConfigManager.3.1
                    @Override // io.rong.push.core.PushClient.QueryCallback
                    public void onFailure(PushErrorCode pushErrorCode) {
                        PushConfigManager.pushClient.disconnect();
                        PushConfigManager.this.configResultCallback.onError(pushErrorCode);
                        RLog.e(PushConfigManager.this.TAG, "Failure when query!");
                    }

                    @Override // io.rong.push.core.PushClient.QueryCallback
                    public void onSuccess(String str3) {
                        RLog.d(PushConfigManager.this.TAG, "query result:" + str3 + ";prefer type:" + pushType.getName());
                        if (!str3.equals(pushType.getName()) && !str3.equals(PushType.GOOGLE_GCM.getName()) && !str3.equals(PushType.GOOGLE_FCM.getName()) && (!pushType.equals(PushType.UNKNOWN) || !str3.equals(PushType.RONG.getName()))) {
                            PushConfigManager.this.configResultCallback.onFail(pushType, PushErrorCode.NOT_REGISTER_IN_ADMIN);
                        } else if (str3.equals(PushType.RONG.getName())) {
                            PushConfigManager.this.configResultCallback.onSuccess(PushType.RONG);
                        } else {
                            PushConfigManager.this.configResultCallback.onGetPushType(PushType.getType(str3));
                        }
                    }
                });
            }
        });
    }

    private void registerConfigReceiver(Context context) {
        RLog.d(this.TAG, "registerConfigReceiver");
        this.pushConfigReceiver = new PushConfigReceiver();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.registerReceiver(this.pushConfigReceiver, intentFilter);
        } catch (Exception e2) {
            RLog.i(this.TAG, "registerConfigReceiver failed: " + e2.getMessage());
        }
    }

    public void finishConfig(Context context, String str) {
        PushCacheHelper.getInstance().savePushConfigInfo(context, str);
        PushCacheHelper.getInstance().saveTokenInfo(context, this.token);
        PushCacheHelper.getInstance().savePushDomain(context, this.pushConfig.getPushDomain());
        try {
            if (this.pushConfigReceiver != null) {
                context.unregisterReceiver(this.pushConfigReceiver);
            }
        } catch (Exception e2) {
            RLog.i(this.TAG, e2.getMessage());
        }
        pushClient.disconnect();
        if (TextUtils.isEmpty(str) || str.equals(PushType.RONG.getName())) {
            return;
        }
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushReceiver.class), 2, 1);
        } catch (Exception unused) {
        }
    }

    public void init(Context context, PushConfig pushConfig, IPushConfigObserver iPushConfigObserver) {
        if (this.isInitialized) {
            RLog.d(this.TAG, "already initialized. Return directly!");
            return;
        }
        this.configResultCallback = iPushConfigObserver;
        this.pushConfig = pushConfig;
        HandlerThread handlerThread = new HandlerThread("PushConfig");
        handlerThread.start();
        this.connectHandler = new PushConnectHandler(handlerThread.getLooper());
        registerConfigReceiver(context);
        if (this.pushNaviClient == null) {
            this.pushNaviClient = new PushNaviClient();
            this.pushNaviClient.setPushNaviUrl(pushConfig.getPushDomain());
        }
        if (pushClient == null) {
            pushClient = new PushClient(context, pushConfig.getAppKey(), DeviceUtils.getPhoneInformation(context), new PushClient.ClientListener() { // from class: io.rong.push.pushconfig.PushConfigManager.1
                @Override // io.rong.push.core.PushClient.ClientListener
                public void onDisConnected() {
                    PushConfigManager.this.isDisconnected = true;
                }

                @Override // io.rong.push.core.PushClient.ClientListener
                public void onMessageArrived(PushProtocalStack.PublishMessage publishMessage) {
                }

                @Override // io.rong.push.core.PushClient.ClientListener
                public void onPingFailure() {
                }

                @Override // io.rong.push.core.PushClient.ClientListener
                public void onPingSuccess() {
                }
            });
        }
        this.isInitialized = true;
    }

    public void reConfig(Context context) {
        if (this.isInitialized) {
            startConfig(context);
        } else {
            RLog.e(this.TAG, "reConfig. Doesn't init, ignore this event.");
        }
    }

    public void setToken(final Context context, final PushConfig pushConfig, final String str) {
        if (!this.isInitialized) {
            RLog.e(this.TAG, "setToken. Doesn't init, ignore this event.");
        } else {
            this.token = str;
            this.connectHandler.post(new Runnable() { // from class: io.rong.push.pushconfig.PushConfigManager.4
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = Build.MANUFACTURER;
                    String str3 = Build.MODEL;
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = String.format("%s|%s|%s|%s|%s", str, pushConfig.getAppKey(), str2, str3, BuildVar.SDK_VERSION);
                    RLog.d(PushConfigManager.this.TAG, "setToken. information:" + str4);
                    String deviceId = DeviceUtils.getDeviceId(context, pushConfig.getAppKey());
                    final String str5 = str.split("\\|")[0];
                    PushConfigManager.pushClient.query(PushClient.QueryMethod.SET_TOKEN, str4, deviceId, new PushClient.QueryCallback() { // from class: io.rong.push.pushconfig.PushConfigManager.4.1
                        @Override // io.rong.push.core.PushClient.QueryCallback
                        public void onFailure(PushErrorCode pushErrorCode) {
                            PushConfigManager.pushClient.disconnect();
                            PushConfigManager.this.configResultCallback.onError(pushErrorCode);
                            RLog.e(PushConfigManager.this.TAG, "setToken.onFailure.");
                        }

                        @Override // io.rong.push.core.PushClient.QueryCallback
                        public void onSuccess(String str6) {
                            RLog.d(PushConfigManager.this.TAG, "setToken.onSuccess.");
                            PushConfigManager.this.configResultCallback.onSuccess(PushType.getType(str5));
                        }
                    });
                }
            });
        }
    }

    public void startConfig(Context context) {
        RLog.d(this.TAG, "startConfig");
        if (this.isInitialized) {
            this.connectHandler.post(new AnonymousClass2(context));
        } else {
            RLog.e(this.TAG, "startConfig. Doesn't init, ignore this event.");
        }
    }
}
