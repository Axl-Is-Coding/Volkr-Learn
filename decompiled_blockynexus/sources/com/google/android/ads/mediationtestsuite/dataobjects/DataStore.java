package com.google.android.ads.mediationtestsuite.dataobjects;

import android.content.Context;
import android.util.Log;
import com.android.volley.VolleyError;
import com.android.volley.m;
import com.google.android.ads.mediationtestsuite.activities.OnAdUnitsStateChangedListener;
import com.google.android.ads.mediationtestsuite.activities.OnNetworkConfigStateChangedListener;
import com.google.android.ads.mediationtestsuite.utils.d;
import com.google.android.ads.mediationtestsuite.utils.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DataStore {
    private static String appId;
    private static Context context;
    private static final Map<String, AdUnit> adUnits = new HashMap();
    private static final Map<Integer, NetworkConfig> networkConfigs = new HashMap();
    private static final List<AdUnit> workingAdUnits = new ArrayList();
    private static final List<AdUnit> failingAdUnits = new ArrayList();
    private static final Set<OnAdUnitsStateChangedListener> adUnitUpdateListeners = new HashSet();
    private static final Set<OnNetworkConfigStateChangedListener> networkConfigStateChangedListeners = new HashSet();
    private static Boolean initialized = false;
    private static Boolean didAcceptDisclaimer = false;

    public static void adUnitFailed(AdUnit adUnit) {
        workingAdUnits.remove(adUnit);
        if (!failingAdUnits.contains(adUnit)) {
            failingAdUnits.add(adUnit);
        }
        notifyListenersOfUpdatedAdUnits();
    }

    public static void adUnitWorked(AdUnit adUnit) {
        if (!workingAdUnits.contains(adUnit)) {
            workingAdUnits.add(adUnit);
        }
        failingAdUnits.remove(adUnit);
        notifyListenersOfUpdatedAdUnits();
    }

    private static void addNetworkConfig(NetworkConfig networkConfig) {
        networkConfigs.put(Integer.valueOf(networkConfig.getId()), networkConfig);
    }

    public static void addToAdUnitListeners(OnAdUnitsStateChangedListener onAdUnitsStateChangedListener) {
        adUnitUpdateListeners.add(onAdUnitsStateChangedListener);
    }

    public static void addToNetworkConfigListeners(OnNetworkConfigStateChangedListener onNetworkConfigStateChangedListener) {
        networkConfigStateChangedListeners.add(onNetworkConfigStateChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void buildAdUnitDataStructures(List<AdUnit> list) {
        workingAdUnits.clear();
        failingAdUnits.clear();
        adUnits.clear();
        networkConfigs.clear();
        for (AdUnit adUnit : list) {
            if (adUnit.hasAllConfigsPassingForOneFormat()) {
                workingAdUnits.add(adUnit);
            } else {
                failingAdUnits.add(adUnit);
            }
            adUnits.put(adUnit.getId(), adUnit);
            Iterator<NetworkConfig> it = adUnit.getNetworkConfigs().iterator();
            while (it.hasNext()) {
                addNetworkConfig(it.next());
            }
        }
    }

    public static void downloadAdUnits() throws IOException {
        if (initialized.booleanValue()) {
            m.a(new m.b<ConfigResponse>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.DataStore.1
                @Override // com.android.volley.m.b
                public void onResponse(ConfigResponse configResponse) {
                    DataStore.buildAdUnitDataStructures(new ArrayList(configResponse.getAdUnits()));
                    DataStore.notifyListenersOfUpdatedAdUnits();
                }
            }, new m.a() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.DataStore.2
                @Override // com.android.volley.m.a
                public void onErrorResponse(VolleyError volleyError) {
                }
            });
        } else {
            Log.e("gma_test", "Must initialize data store before downloading ad units");
        }
    }

    public static AdUnit getAdUnit(String str) {
        return adUnits.get(str);
    }

    public static Map<String, AdUnit> getAdUnits() {
        return adUnits;
    }

    public static String getAppId() {
        return appId;
    }

    public static Context getContext() {
        if (context == null) {
            Log.e("gma_test", "Context is null, please ensure to initialize the DataStore first");
        }
        return context;
    }

    public static boolean getDidAcceptDisclaimer() {
        return didAcceptDisclaimer.booleanValue();
    }

    public static List<AdUnit> getFailingAdUnits() {
        return failingAdUnits;
    }

    public static NetworkConfig getNetworkConfig(int i) {
        return networkConfigs.get(Integer.valueOf(i));
    }

    public static List<AdUnit> getWorkingAdUnits() {
        return workingAdUnits;
    }

    public static boolean initialize(Context context2, String str) {
        if (str == null || str.length() != 38) {
            Log.e("gma_test", "The provided app ID doesn't look valid. Are you sure it's correct?");
            return false;
        }
        appId = str;
        context = context2.getApplicationContext();
        d.a(context2);
        initialized = true;
        return true;
    }

    public static void networkConfigUpdated(NetworkConfig networkConfig) {
        notifyListenersOfUpdatedNetworkConfig(networkConfig);
    }

    public static void notifyListenersOfUpdatedAdUnits() {
        Iterator<OnAdUnitsStateChangedListener> it = adUnitUpdateListeners.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public static void notifyListenersOfUpdatedNetworkConfig(NetworkConfig networkConfig) {
        Iterator<OnNetworkConfigStateChangedListener> it = networkConfigStateChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(networkConfig);
        }
    }

    public static void removeFromAdUnitListeners(OnAdUnitsStateChangedListener onAdUnitsStateChangedListener) {
        adUnitUpdateListeners.remove(onAdUnitsStateChangedListener);
    }

    public static void removeFromListeners(OnAdUnitsStateChangedListener onAdUnitsStateChangedListener) {
        adUnitUpdateListeners.remove(onAdUnitsStateChangedListener);
    }

    public static void removeFromNetworkConfigListeners(OnNetworkConfigStateChangedListener onNetworkConfigStateChangedListener) {
        networkConfigStateChangedListeners.remove(onNetworkConfigStateChangedListener);
    }

    public static void setDidAcceptDisclaimer(boolean z) {
        didAcceptDisclaimer = Boolean.valueOf(z);
    }
}
