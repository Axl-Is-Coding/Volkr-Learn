package com.unity3d.services.core.properties;

import android.content.Context;
import com.just.agentweb.DefaultWebClient;
import com.unity3d.services.IUnityServicesListener;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public class SdkProperties {
    private static final String CACHE_DIR_NAME = "UnityAdsCache";
    private static final String CHINA_ISO_ALPHA_2_CODE = "CN";
    private static final String CHINA_ISO_ALPHA_3_CODE = "CHN";
    private static final String LOCAL_CACHE_FILE_PREFIX = "UnityAdsCache-";
    private static final String LOCAL_STORAGE_FILE_PREFIX = "UnityAdsStorage-";
    private static CacheDirectory _cacheDirectory;
    private static String _configUrl;
    private static boolean _debugMode;
    private static long _initializationTime;
    private static boolean _initialized;
    private static IUnityServicesListener _listener;
    private static boolean _perPlacementLoadEnabled;
    private static boolean _reinitialized;
    private static boolean _testMode;

    public static File getCacheDirectory() {
        return getCacheDirectory(ClientProperties.getApplicationContext());
    }

    public static String getCacheDirectoryName() {
        return CACHE_DIR_NAME;
    }

    public static CacheDirectory getCacheDirectoryObject() {
        return _cacheDirectory;
    }

    public static String getCacheFilePrefix() {
        return LOCAL_CACHE_FILE_PREFIX;
    }

    public static String getConfigUrl() {
        if (_configUrl == null) {
            _configUrl = getDefaultConfigUrl("release");
        }
        return _configUrl;
    }

    public static boolean getDebugMode() {
        return _debugMode;
    }

    public static String getDefaultConfigUrl(String str) {
        return (isChinaLocale(Device.getNetworkCountryISO()) ? "https://config.unityads.unitychina.cn/webview/" : "https://config.unityads.unity3d.com/webview/") + getWebViewBranch() + "/" + str + "/config.json";
    }

    public static long getInitializationTime() {
        return _initializationTime;
    }

    public static IUnityServicesListener getListener() {
        return _listener;
    }

    public static String getLocalStorageFilePrefix() {
        return LOCAL_STORAGE_FILE_PREFIX;
    }

    public static String getLocalWebViewFile() {
        return getCacheDirectory().getAbsolutePath() + "/UnityAdsWebApp.html";
    }

    public static int getVersionCode() {
        return 3420;
    }

    public static String getVersionName() {
        return "3.4.2";
    }

    private static String getWebViewBranch() {
        return getVersionName();
    }

    public static boolean isChinaLocale(String str) {
        return str.equalsIgnoreCase(CHINA_ISO_ALPHA_2_CODE) || str.equalsIgnoreCase(CHINA_ISO_ALPHA_3_CODE);
    }

    public static boolean isInitialized() {
        return _initialized;
    }

    public static boolean isPerPlacementLoadEnabled() {
        return _perPlacementLoadEnabled;
    }

    public static boolean isReinitialized() {
        return _reinitialized;
    }

    public static boolean isTestMode() {
        return _testMode;
    }

    public static void setCacheDirectory(CacheDirectory cacheDirectory) {
        _cacheDirectory = cacheDirectory;
    }

    public static void setConfigUrl(String str) throws MalformedURLException, URISyntaxException {
        if (str == null) {
            throw new MalformedURLException();
        }
        if (!str.startsWith(DefaultWebClient.HTTP_SCHEME) && !str.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
            throw new MalformedURLException();
        }
        new URL(str).toURI();
        _configUrl = str;
    }

    public static void setDebugMode(boolean z) {
        _debugMode = z;
        if (z) {
            DeviceLog.setLogLevel(8);
        } else {
            DeviceLog.setLogLevel(4);
        }
    }

    public static void setInitializationTime(long j) {
        _initializationTime = j;
    }

    public static void setInitialized(boolean z) {
        _initialized = z;
    }

    public static void setListener(IUnityServicesListener iUnityServicesListener) {
        _listener = iUnityServicesListener;
    }

    public static void setPerPlacementLoadEnabled(boolean z) {
        _perPlacementLoadEnabled = z;
    }

    public static void setReinitialized(boolean z) {
        _reinitialized = z;
    }

    public static void setTestMode(boolean z) {
        _testMode = z;
    }

    public static File getCacheDirectory(Context context) {
        if (_cacheDirectory == null) {
            setCacheDirectory(new CacheDirectory(CACHE_DIR_NAME));
        }
        return _cacheDirectory.getCacheDirectory(context);
    }
}
