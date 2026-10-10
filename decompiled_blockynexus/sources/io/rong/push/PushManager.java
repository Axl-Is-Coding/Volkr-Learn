package io.rong.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.core.PushUtils;
import io.rong.push.notification.PushNotificationMessage;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.IPushConfigObserver;
import io.rong.push.pushconfig.PushConfig;
import io.rong.push.pushconfig.PushConfigManager;
import io.rong.push.pushconfig.PushFactory;
import io.rong.push.rongpush.PushReceiver;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
public class PushManager {
    private static final String NAVI_IN_TOKEN_SPLIT_SYMBOL = "@";
    private static final String TAG = "PushManager";
    private Context context;
    private PushConfig pushConfig;
    private PushConfigManager pushConfigManager;
    private ConcurrentMap<String, IPush> registeredPushMap;
    private PushType serverPushType;
    private String token;

    private static class SingletonHolder {
        private static PushManager sIns = new PushManager();

        private SingletonHolder() {
        }
    }

    public static PushManager getInstance() {
        return SingletonHolder.sIns;
    }

    private void initPushConfig(final Context context) {
        if (this.pushConfigManager != null) {
            RLog.e(TAG, "pushConfigManager already init. Return directly.");
        } else {
            this.pushConfigManager = new PushConfigManager();
            this.pushConfigManager.init(context, this.pushConfig, new IPushConfigObserver() { // from class: io.rong.push.PushManager.1
                @Override // io.rong.push.pushconfig.IPushConfigObserver
                public void onError(PushErrorCode pushErrorCode) {
                    RLog.e(PushManager.TAG, "error when config push. Will reConfig when network changed!");
                }

                @Override // io.rong.push.pushconfig.IPushConfigObserver
                public void onFail(PushType pushType, PushErrorCode pushErrorCode) {
                    RLog.e(PushManager.TAG, "Failed to config push. type:" + pushType + "; errorCode:" + pushErrorCode);
                    if (pushErrorCode.equals(PushErrorCode.NOT_REGISTER_IN_ADMIN)) {
                        RLog.e(PushManager.TAG, "Please fill in the parameters of " + pushType.getName() + " in your RongCloud Admin.");
                    }
                    PushManager.this.onErrorResponse(context, pushType, PushConst.PUSH_ACTION_QUERY_TYPE, pushErrorCode.getCode());
                }

                @Override // io.rong.push.pushconfig.IPushConfigObserver
                public void onGetPushType(PushType pushType) {
                    RLog.d(PushManager.TAG, "Success to get pushType. Go to register : " + pushType.getName());
                    PushManager.this.serverPushType = pushType;
                    if (TextUtils.isEmpty(PushManager.this.token) || PushManager.this.pushConfig == null) {
                        PushManager.this.register(context, pushType);
                    } else if (PushManager.this.token.split("\\|")[0].equals(pushType.getName())) {
                        PushManager.this.pushConfigManager.setToken(context, PushManager.this.pushConfig, PushManager.this.token);
                    } else {
                        PushManager.this.register(context, pushType);
                        PushManager.this.token = null;
                    }
                }

                @Override // io.rong.push.pushconfig.IPushConfigObserver
                public void onSuccess(PushType pushType) {
                    if (PushManager.this.pushConfigManager != null) {
                        RLog.d(PushManager.TAG, "Success to config push: " + pushType.getName());
                        PushManager.this.pushConfigManager.finishConfig(context, pushType.getName());
                        PushManager.this.token = null;
                        PushManager.this.pushConfigManager = null;
                        if (pushType.equals(PushType.RONG)) {
                            PushManager.this.register(context, PushType.RONG);
                        }
                    }
                }
            });
        }
    }

    public PushConfig getPushConfig() {
        return this.pushConfig;
    }

    public IPush getRegisteredPush(String str) {
        ConcurrentMap<String, IPush> concurrentMap = this.registeredPushMap;
        if (concurrentMap == null) {
            return null;
        }
        return concurrentMap.get(str);
    }

    public PushType getServerPushType() {
        return this.serverPushType;
    }

    public void init(Context context, PushConfig pushConfig) {
        this.pushConfig = pushConfig;
        this.context = context.getApplicationContext();
        PushType preferPushType = PushUtils.getPreferPushType(context, pushConfig);
        PushType configPushType = PushCacheHelper.getInstance().getConfigPushType(context);
        RLog.d(TAG, "preferPushType:" + preferPushType + "; cachedPushType:" + configPushType);
        String cachedEnablePushTypes = PushCacheHelper.getInstance().getCachedEnablePushTypes(context);
        String cachedPushDomain = PushCacheHelper.getInstance().getCachedPushDomain(context);
        String cachedDeviceId = PushCacheHelper.getInstance().getCachedDeviceId(context);
        if (!pushConfig.getPushDomain().equals(cachedPushDomain)) {
            PushCacheHelper.getInstance().setPushServerInIMToken(context, null);
        }
        boolean z = (TextUtils.isEmpty(cachedEnablePushTypes) || (pushConfig.getEncodedEnabledPushTypes().equals(cachedEnablePushTypes) && pushConfig.getPushDomain().equals(cachedPushDomain) && cachedDeviceId.equals(DeviceUtils.getDeviceId(context, pushConfig.getAppKey())))) ? false : true;
        RLog.d(TAG, "isConfigChanged:" + z + "; cachedEnablePush:" + cachedEnablePushTypes);
        if ((preferPushType.equals(PushType.RONG) || PushCacheHelper.getInstance().isConfigDone(context)) && !z) {
            register(context, configPushType);
        } else {
            initPushConfig(context);
            this.pushConfigManager.startConfig(context);
        }
        PushCacheHelper.getInstance().savePushDomain(context, pushConfig.getPushDomain());
        PushCacheHelper.getInstance().cacheRongDeviceId(context, DeviceUtils.getDeviceId(context, pushConfig.getAppKey()));
        PushCacheHelper.getInstance().saveEnablePushTypes(context, pushConfig.getEncodedEnabledPushTypes());
    }

    public void onErrorResponse(Context context, PushType pushType, String str, long j) {
        RLog.d(TAG, "onErrorResponse. pushType:" + pushType + "; errorCode:" + j);
        if (j == PushErrorCode.NOT_SUPPORT_BY_OFFICIAL_PUSH.getCode()) {
            register(context, PushType.RONG);
            PushConfigManager pushConfigManager = this.pushConfigManager;
            if (pushConfigManager != null) {
                pushConfigManager.finishConfig(context, PushType.RONG.getName());
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_THIRD_PARTY_PUSH_STATE);
        intent.putExtra(PushConst.PUSH_TYPE, pushType.getName());
        intent.putExtra("action", str);
        intent.putExtra(PushConst.RESULT_CODE, j);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void onNetworkReconfigEvent(Context context) {
        if (PushCacheHelper.getInstance().isConfigDone(context)) {
            RLog.d(TAG, "Config finished. Ignore this event. ");
            return;
        }
        if (this.pushConfigManager == null) {
            initPushConfig(context);
            this.pushConfigManager.startConfig(context);
        } else if (TextUtils.isEmpty(this.token)) {
            this.pushConfigManager.reConfig(context);
        } else {
            this.pushConfigManager.setToken(context, this.pushConfig, this.token);
        }
    }

    public void onNotificationMessageArrived(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage) {
        RLog.d(TAG, "onNotificationMessageArrived is called. " + pushNotificationMessage.toString());
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED);
        intent.putExtra(PushConst.PUSH_TYPE, pushType.getName());
        intent.putExtra("message", pushNotificationMessage);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void onNotificationMessageClicked(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage) {
        RLog.d(TAG, "onNotificationMessageClicked is called. " + pushNotificationMessage.toString());
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED);
        intent.putExtra(PushConst.PUSH_TYPE, pushType.getName());
        intent.putExtra("message", pushNotificationMessage);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void onPushRawData(Context context, PushType pushType, String str) {
        PushNotificationMessage pushNotificationMessageTransformToPushMessage = PushUtils.transformToPushMessage(str);
        if (pushNotificationMessageTransformToPushMessage == null) {
            RLog.e(TAG, "notification message is null. Ignore this event.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED);
        intent.putExtra(PushConst.PUSH_TYPE, pushType.getName());
        intent.putExtra("message", pushNotificationMessageTransformToPushMessage);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void onReceiveToken(Context context, PushType pushType, String str) {
        RLog.d(TAG, "onReceiveToken. token:" + str);
        if (this.pushConfig == null) {
            RLog.e(TAG, "No PushConfig, return directly. Please init in Application.");
            return;
        }
        String cachedTokenInfo = PushCacheHelper.getInstance().getCachedTokenInfo(context);
        String str2 = pushType.getName() + "|" + str;
        if (cachedTokenInfo.equals(str2)) {
            RLog.d(TAG, "token is same with cached, do nothing!");
            return;
        }
        PushCacheHelper.getInstance().clearPushConfigInfo(context);
        PushConfigManager pushConfigManager = this.pushConfigManager;
        if (pushConfigManager == null) {
            initPushConfig(context);
            this.pushConfigManager.startConfig(context);
        } else {
            pushConfigManager.setToken(context, this.pushConfig, str2);
        }
        this.token = str2;
    }

    public void onTokenRefresh(Context context, PushType pushType) {
        if (PushCacheHelper.getInstance().getConfigPushType(context).equals(pushType)) {
            register(context, pushType);
        }
    }

    public void register(Context context, PushType pushType) {
        RLog.d(TAG, "register. type:" + pushType);
        if (!pushType.equals(PushType.RONG)) {
            try {
                RLog.d(TAG, "stop PushReceiver.");
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushReceiver.class), 2, 1);
            } catch (Exception unused) {
            }
        }
        IPush pushCenterByType = this.registeredPushMap.get(pushType.getName());
        if (pushCenterByType == null) {
            pushCenterByType = PushFactory.getInstance().getPushCenterByType(pushType);
        }
        if (pushCenterByType != null) {
            pushCenterByType.register(context, this.pushConfig);
            this.registeredPushMap.put(pushType.getName(), pushCenterByType);
        }
    }

    public void updatePushServerInfoFromToken(String str) {
        if (this.context == null) {
            RLog.e(TAG, "updatePushServerInfoFromToken return:context is null, may not init ");
            return;
        }
        if (TextUtils.isEmpty(str) || !str.contains(NAVI_IN_TOKEN_SPLIT_SYMBOL)) {
            return;
        }
        String[] strArrSplit = str.split(NAVI_IN_TOKEN_SPLIT_SYMBOL);
        if (strArrSplit.length == 2) {
            PushCacheHelper.getInstance().setPushServerInIMToken(this.context, strArrSplit[1]);
        }
    }

    private PushManager() {
        this.registeredPushMap = new ConcurrentHashMap();
    }
}
