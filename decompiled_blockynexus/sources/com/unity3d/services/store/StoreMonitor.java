package com.unity3d.services.store;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.android.billingclient.api.BillingClient;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.store.core.StoreException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(14)
public class StoreMonitor {
    private static Object _billingService;
    private static StoreLifecycleListener _lifecycleListener;

    public static JSONObject getPurchaseHistory(String str, int i) throws IllegalAccessException, JSONException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return StoreBilling.getPurchaseHistory(ClientProperties.getApplicationContext(), _billingService, str, i);
    }

    public static JSONObject getPurchases(String str) throws JSONException, IllegalAccessException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return StoreBilling.getPurchases(ClientProperties.getApplicationContext(), _billingService, str);
    }

    public static JSONArray getSkuDetails(String str, ArrayList<String> arrayList) throws IllegalAccessException, JSONException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return StoreBilling.getSkuDetails(ClientProperties.getApplicationContext(), _billingService, str, arrayList);
    }

    public static void initialize(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        ClientProperties.getApplicationContext().bindService(intent, new ServiceConnection() { // from class: com.unity3d.services.store.StoreMonitor.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Object unused = StoreMonitor._billingService = StoreBilling.asInterface(ClientProperties.getApplicationContext(), iBinder);
                if (StoreMonitor._billingService != null) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZED, new Object[0]);
                } else {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.INITIALIZATION_FAILED, new Object[0]);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Object unused = StoreMonitor._billingService = null;
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.DISCONNECTED, new Object[0]);
            }
        }, 1);
    }

    public static int isBillingSupported(String str) throws IllegalAccessException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return StoreBilling.isBillingSupported(ClientProperties.getApplicationContext(), _billingService, str);
    }

    public static boolean isInitialized() {
        return _billingService != null;
    }

    public static void sendPurchaseStatusOnResume(String str, ArrayList<String> arrayList) {
        if (!isInitialized()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.NOT_INITIALIZED, str, "StoreMonitor not initialized");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (arrayList.contains(BillingClient.SkuType.INAPP)) {
                jSONObject.put(BillingClient.SkuType.INAPP, getPurchases(BillingClient.SkuType.INAPP));
            }
            if (arrayList.contains(BillingClient.SkuType.SUBS)) {
                jSONObject.put(BillingClient.SkuType.SUBS, getPurchases(BillingClient.SkuType.SUBS));
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME, str, jSONObject);
        } catch (StoreException e2) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.STORE_ERROR, str, e2.getMessage(), Integer.valueOf(e2.getResultCode()));
        } catch (ClassNotFoundException e3) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.CLASS_NOT_FOUND, str, e3.getMessage());
        } catch (IllegalAccessException e4) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.ILLEGAL_ACCESS, str, e4.getMessage());
        } catch (NoSuchMethodException e5) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.NO_SUCH_METHOD, str, e5.getMessage());
        } catch (InvocationTargetException e6) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.INVOCATION_TARGET, str, e6.getMessage());
        } catch (JSONException e7) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_RESUME_ERROR, StoreError.JSON_ERROR, str, e7.getMessage());
        }
    }

    public static void sendPurchaseStatusOnStop(String str, ArrayList<String> arrayList) {
        if (!isInitialized()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.NOT_INITIALIZED, str, "StoreMonitor not initialized");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (arrayList.contains(BillingClient.SkuType.INAPP)) {
                jSONObject.put(BillingClient.SkuType.INAPP, getPurchases(BillingClient.SkuType.INAPP));
            }
            if (arrayList.contains(BillingClient.SkuType.SUBS)) {
                jSONObject.put(BillingClient.SkuType.SUBS, getPurchases(BillingClient.SkuType.SUBS));
            }
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP, str, jSONObject);
        } catch (StoreException e2) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.STORE_ERROR, str, e2.getMessage(), Integer.valueOf(e2.getResultCode()));
        } catch (ClassNotFoundException e3) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.CLASS_NOT_FOUND, str, e3.getMessage());
        } catch (IllegalAccessException e4) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.ILLEGAL_ACCESS, str, e4.getMessage());
        } catch (NoSuchMethodException e5) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.NO_SUCH_METHOD, str, e5.getMessage());
        } catch (InvocationTargetException e6) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.INVOCATION_TARGET, str, e6.getMessage());
        } catch (JSONException e7) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORE, StoreEvent.PURCHASE_STATUS_ON_STOP_ERROR, StoreError.JSON_ERROR, str, e7.getMessage());
        }
    }

    public static void startPurchaseTracking(boolean z, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (_lifecycleListener != null) {
            stopPurchaseTracking();
        }
        _lifecycleListener = new StoreLifecycleListener(z, arrayList, arrayList2);
        ClientProperties.getApplication().registerActivityLifecycleCallbacks(_lifecycleListener);
    }

    public static void stopPurchaseTracking() {
        if (_lifecycleListener != null) {
            ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(_lifecycleListener);
            _lifecycleListener = null;
        }
    }
}
