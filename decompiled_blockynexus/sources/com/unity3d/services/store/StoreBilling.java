package com.unity3d.services.store;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.android.billingclient.util.BillingHelper;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.store.core.StoreException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class StoreBilling {
    public static Object asInterface(Context context, IBinder iBinder) {
        new Object[1][0] = iBinder;
        try {
            try {
                try {
                    return Class.forName("com.android.vending.billing.IInAppBillingService$Stub").getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                } catch (IllegalAccessException e2) {
                    DeviceLog.exception("Illegal access exception while invoking asInterface", e2);
                    return null;
                } catch (InvocationTargetException e3) {
                    DeviceLog.exception("Invocation target exception while invoking asInterface", e3);
                    return null;
                }
            } catch (NoSuchMethodException e4) {
                DeviceLog.exception("asInterface method not found", e4);
                return null;
            }
        } catch (ClassNotFoundException e5) {
            DeviceLog.exception("Billing service stub not found", e5);
            return null;
        }
    }

    public static JSONObject getPurchaseHistory(Context context, Object obj, String str, int i) throws IllegalAccessException, JSONException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        int i2 = 5;
        char c2 = 0;
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getPurchaseHistory", Integer.TYPE, String.class, String.class, String.class, Bundle.class);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        String str2 = null;
        int i3 = 0;
        while (true) {
            Object[] objArr = new Object[i2];
            objArr[c2] = 6;
            objArr[1] = ClientProperties.getAppName();
            objArr[2] = str;
            objArr[3] = str2;
            objArr[4] = new Bundle();
            Object objInvoke = method.invoke(obj, objArr);
            if (!(objInvoke instanceof Bundle)) {
                throw new StoreException();
            }
            Bundle bundle = (Bundle) objInvoke;
            int i4 = bundle.getInt(BillingHelper.RESPONSE_CODE);
            if (i4 != 0) {
                throw new StoreException(i4);
            }
            Iterator<String> it = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST).iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next()));
                i3++;
            }
            Iterator<String> it2 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST).iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            Iterator<String> it3 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_ITEM_LIST).iterator();
            while (it3.hasNext()) {
                jSONArray3.put(it3.next());
            }
            String string = bundle.getString(BillingHelper.INAPP_CONTINUATION_TOKEN);
            if (string == null || (i != 0 && i3 >= i)) {
                break;
            }
            str2 = string;
            i2 = 5;
            c2 = 0;
        }
        jSONObject.put("purchaseDataList", jSONArray);
        jSONObject.put("signatureList", jSONArray2);
        jSONObject.put("purchaseItemList", jSONArray3);
        return jSONObject;
    }

    public static JSONObject getPurchases(Context context, Object obj, String str) throws IllegalAccessException, JSONException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getPurchases", Integer.TYPE, String.class, String.class, String.class);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        String string = null;
        do {
            Object objInvoke = method.invoke(obj, 3, ClientProperties.getAppName(), str, string);
            if (!(objInvoke instanceof Bundle)) {
                throw new StoreException();
            }
            Bundle bundle = (Bundle) objInvoke;
            int i = bundle.getInt(BillingHelper.RESPONSE_CODE);
            DeviceLog.debug("getPurchases responds with code " + i);
            if (i != 0) {
                throw new StoreException(i);
            }
            Iterator<String> it = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST).iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next()));
            }
            Iterator<String> it2 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST).iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            Iterator<String> it3 = bundle.getStringArrayList(BillingHelper.RESPONSE_INAPP_ITEM_LIST).iterator();
            while (it3.hasNext()) {
                jSONArray3.put(it3.next());
            }
            string = bundle.getString(BillingHelper.INAPP_CONTINUATION_TOKEN);
        } while (string != null);
        jSONObject.put("purchaseDataList", jSONArray);
        jSONObject.put("signatureList", jSONArray2);
        jSONObject.put("purchaseItemList", jSONArray3);
        return jSONObject;
    }

    public static JSONArray getSkuDetails(Context context, Object obj, String str, ArrayList<String> arrayList) throws IllegalAccessException, JSONException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Method method = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("getSkuDetails", Integer.TYPE, String.class, String.class, Bundle.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Object objInvoke = method.invoke(obj, 3, ClientProperties.getAppName(), str, bundle);
        JSONArray jSONArray = new JSONArray();
        if (!(objInvoke instanceof Bundle)) {
            throw new StoreException();
        }
        Bundle bundle2 = (Bundle) objInvoke;
        int i = bundle2.getInt(BillingHelper.RESPONSE_CODE);
        if (i != 0) {
            throw new StoreException(i);
        }
        Iterator<String> it = bundle2.getStringArrayList(BillingHelper.RESPONSE_GET_SKU_DETAILS_LIST).iterator();
        while (it.hasNext()) {
            jSONArray.put(new JSONObject(it.next()));
        }
        return jSONArray;
    }

    public static int isBillingSupported(Context context, Object obj, String str) throws IllegalAccessException, StoreException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke = Class.forName("com.android.vending.billing.IInAppBillingService").getMethod("isBillingSupported", Integer.TYPE, String.class, String.class).invoke(obj, 3, ClientProperties.getAppName(), str);
        if (objInvoke != null) {
            return ((Integer) objInvoke).intValue();
        }
        throw new StoreException();
    }
}
