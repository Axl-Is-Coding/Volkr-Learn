package com.unity3d.ads.properties;

import com.unity3d.ads.IUnityAdsListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class AdsProperties {
    private static IUnityAdsListener _listener;
    private static Set<IUnityAdsListener> _listeners = Collections.synchronizedSet(new LinkedHashSet());
    private static int _showTimeout = 5000;

    public static void addListener(IUnityAdsListener iUnityAdsListener) {
        if (_listener == null) {
            _listener = iUnityAdsListener;
        }
        if (iUnityAdsListener == null || _listeners.contains(iUnityAdsListener)) {
            return;
        }
        _listeners.add(iUnityAdsListener);
    }

    public static IUnityAdsListener getListener() {
        return _listener;
    }

    public static Set<IUnityAdsListener> getListeners() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(_listeners);
        IUnityAdsListener iUnityAdsListener = _listener;
        if (iUnityAdsListener != null) {
            linkedHashSet.add(iUnityAdsListener);
        }
        return linkedHashSet;
    }

    public static int getShowTimeout() {
        return _showTimeout;
    }

    public static void removeListener(IUnityAdsListener iUnityAdsListener) {
        IUnityAdsListener iUnityAdsListener2 = _listener;
        if (iUnityAdsListener2 != null && iUnityAdsListener2.equals(iUnityAdsListener)) {
            _listener = null;
        }
        _listeners.remove(iUnityAdsListener);
    }

    public static void setListener(IUnityAdsListener iUnityAdsListener) {
        IUnityAdsListener iUnityAdsListener2 = _listener;
        if (iUnityAdsListener2 != null) {
            _listeners.remove(iUnityAdsListener2);
        }
        _listener = iUnityAdsListener;
    }

    public static void setShowTimeout(int i) {
        _showTimeout = i;
    }
}
