package com.unity3d.ads;

import android.app.Activity;
import com.unity3d.services.UnityServices;
import com.unity3d.services.ads.UnityAdsImplementation;

/* JADX INFO: loaded from: classes5.dex */
public final class UnityAds {

    public enum FinishState {
        ERROR,
        SKIPPED,
        COMPLETED
    }

    public enum PlacementState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    public enum UnityAdsError {
        NOT_INITIALIZED,
        INITIALIZE_FAILED,
        INVALID_ARGUMENT,
        VIDEO_PLAYER_ERROR,
        INIT_SANITY_CHECK_FAIL,
        AD_BLOCKER_DETECTED,
        FILE_IO_ERROR,
        DEVICE_ID_ERROR,
        SHOW_ERROR,
        INTERNAL_ERROR
    }

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.addListener(iUnityAdsListener);
    }

    public static boolean getDebugMode() {
        return UnityAdsImplementation.getDebugMode();
    }

    @Deprecated
    public static IUnityAdsListener getListener() {
        return UnityAdsImplementation.getListener();
    }

    public static PlacementState getPlacementState() {
        return UnityAdsImplementation.getPlacementState();
    }

    public static String getVersion() {
        return UnityAdsImplementation.getVersion();
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener) {
        initialize(activity, str, iUnityAdsListener, false, false);
    }

    public static boolean isInitialized() {
        return UnityServices.isInitialized();
    }

    public static boolean isReady() {
        return UnityAdsImplementation.isReady();
    }

    public static boolean isSupported() {
        return UnityAdsImplementation.isSupported();
    }

    public static void load(String str) {
        UnityAdsImplementation.load(str);
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.removeListener(iUnityAdsListener);
    }

    public static void setDebugMode(boolean z) {
        UnityAdsImplementation.setDebugMode(z);
    }

    @Deprecated
    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        UnityAdsImplementation.setListener(iUnityAdsListener);
    }

    public static void show(Activity activity) {
        UnityAdsImplementation.show(activity);
    }

    public static PlacementState getPlacementState(String str) {
        return UnityAdsImplementation.getPlacementState(str);
    }

    public static void initialize(Activity activity, String str) {
        initialize(activity, str, null, false, false);
    }

    public static boolean isReady(String str) {
        return UnityAdsImplementation.isReady(str);
    }

    public static void show(Activity activity, String str) {
        UnityAdsImplementation.show(activity, str);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z) {
        UnityAdsImplementation.initialize(activity, str, iUnityAdsListener, z, false);
    }

    public static void initialize(Activity activity, String str, boolean z) {
        UnityAdsImplementation.initialize(activity, str, null, z, false);
    }

    @Deprecated
    public static void initialize(Activity activity, String str, IUnityAdsListener iUnityAdsListener, boolean z, boolean z2) {
        UnityAdsImplementation.initialize(activity, str, iUnityAdsListener, z, z2);
    }

    public static void initialize(Activity activity, String str, boolean z, boolean z2) {
        UnityAdsImplementation.initialize(activity, str, null, z, z2);
    }
}
