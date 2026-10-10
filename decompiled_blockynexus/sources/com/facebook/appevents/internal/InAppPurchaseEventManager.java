package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseEventManager";
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    InAppPurchaseEventManager() {
    }

    static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
    }

    static void clearSkuDetailsCache() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0L);
        if (j == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
        } else if (jCurrentTimeMillis - j > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
        }
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor editorEdit = purchaseInappSharedPrefs.edit();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (jCurrentTimeMillis - (j / 1000) <= 86400 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    editorEdit.putString(string, string2);
                    arrayList2.add(str);
                }
            } catch (JSONException unused) {
            }
        }
        editorEdit.apply();
        return arrayList2;
    }

    private static Class<?> getClass(Context context, String str) {
        Class<?> clsLoadClass = classMap.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        try {
            clsLoadClass = context.getClassLoader().loadClass(str);
            classMap.put(str, clsLoadClass);
            return clsLoadClass;
        } catch (ClassNotFoundException unused) {
            return clsLoadClass;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Method getMethod(Class<?> cls, String str) {
        Method declaredMethod = methodMap.get(str);
        if (declaredMethod != null) {
            return declaredMethod;
        }
        Class<?>[] clsArr = null;
        byte b2 = -1;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals(GET_PURCHASES)) {
                        b2 = 3;
                    }
                    break;
                case -1450694211:
                    if (str.equals(IS_BILLING_SUPPORTED)) {
                        b2 = 2;
                    }
                    break;
                case -1123215065:
                    if (str.equals(AS_INTERFACE)) {
                        b2 = 0;
                    }
                    break;
                case -594356707:
                    if (str.equals(GET_PURCHASE_HISTORY)) {
                        b2 = 4;
                    }
                    break;
                case -573310373:
                    if (str.equals(GET_SKU_DETAILS)) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (b2 == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (b2 == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (b2 == 3) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            } else if (b2 == 4) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            }
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
            methodMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            return declaredMethod;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<java.lang.String> getPurchaseHistory(android.content.Context r20, java.lang.Object r21, java.lang.String r22) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Boolean r1 = isBillingSupported(r20, r21, r22)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L96
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L13:
            r6 = 5
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r2] = r7
            java.lang.String r7 = com.facebook.appevents.internal.InAppPurchaseEventManager.PACKAGE_NAME
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r22
            r7 = 3
            r6[r7] = r3
            r3 = 4
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r6[r3] = r7
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r7 = "getPurchaseHistory"
            r9 = r20
            r10 = r21
            java.lang.Object r3 = invokeMethod(r9, r3, r7, r10, r6)
            if (r3 == 0) goto L8d
            long r6 = java.lang.System.currentTimeMillis()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r11
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r13 = "RESPONSE_CODE"
            int r13 = r3.getInt(r13)
            if (r13 != 0) goto L8d
            java.lang.String r13 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r13 = r3.getStringArrayList(r13)
            if (r13 != 0) goto L58
            goto L8d
        L58:
            java.util.Iterator r13 = r13.iterator()
        L5c:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L85
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5c
            r15.<init>(r14)     // Catch: org.json.JSONException -> L5c
            java.lang.String r1 = "purchaseTime"
            long r16 = r15.getLong(r1)     // Catch: org.json.JSONException -> L5c
            long r16 = r16 / r11
            long r16 = r6 - r16
            r18 = 1200(0x4b0, double:5.93E-321)
            int r1 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r1 <= 0) goto L7f
            r5 = 1
            goto L85
        L7f:
            r0.add(r14)     // Catch: org.json.JSONException -> L5c
            int r4 = r4 + 1
            goto L5c
        L85:
            java.lang.String r1 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r1 = r3.getString(r1)
            r3 = r1
            goto L8e
        L8d:
            r3 = 0
        L8e:
            r1 = 30
            if (r4 >= r1) goto L96
            if (r3 == 0) goto L96
            if (r5 == 0) goto L13
        L96:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.getPurchaseHistory(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : filterPurchases(getPurchaseHistory(context, obj, "inapp"));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r10 != 0) goto L8
            return r0
        L8:
            java.lang.Boolean r1 = isBillingSupported(r9, r10, r11)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L5c
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L16:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5[r1] = r7
            r7 = 1
            java.lang.String r8 = com.facebook.appevents.internal.InAppPurchaseEventManager.PACKAGE_NAME
            r5[r7] = r8
            r7 = 2
            r5[r7] = r11
            r5[r6] = r3
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r6 = "getPurchases"
            java.lang.Object r3 = invokeMethod(r9, r3, r6, r10, r5)
            if (r3 == 0) goto L55
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)
            if (r5 != 0) goto L55
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)
            if (r5 == 0) goto L5c
            int r6 = r5.size()
            int r4 = r4 + r6
            r0.addAll(r5)
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)
            goto L56
        L55:
            r3 = r2
        L56:
            r5 = 30
            if (r4 >= r5) goto L5c
            if (r3 != 0) goto L16
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, "inapp"));
    }

    static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, "subs"));
    }

    static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> skuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!skuDetailsFromCache.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        skuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        return skuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        HashMap map = new HashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
            Object[] objArr = new Object[4];
            objArr[0] = 3;
            objArr[1] = PACKAGE_NAME;
            objArr[2] = z ? "subs" : "inapp";
            objArr[3] = bundle;
            Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
            if (objInvokeMethod != null) {
                Bundle bundle2 = (Bundle) objInvokeMethod;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            map.put(arrayList.get(i), stringArrayList.get(i));
                        }
                    }
                    writeSkuDetailsToCache(map);
                }
            }
        }
        return map;
    }

    static boolean hasFreeTrialPeirod(String str) {
        try {
            String strOptString = new JSONObject(str).optString("freeTrialPeriod");
            if (strOptString != null) {
                return !strOptString.isEmpty();
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
        if (objInvokeMethod != null && ((Integer) objInvokeMethod).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap map = new HashMap();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            String string = skuDetailSharedPrefs.getString(str, null);
            if (string != null) {
                String[] strArrSplit = string.split(";", 2);
                if (jCurrentTimeMillis - Long.parseLong(strArrSplit[0]) < 43200) {
                    map.put(str, strArrSplit[1]);
                }
            }
        }
        return map;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            editorEdit.putString(entry.getKey(), jCurrentTimeMillis + ";" + entry.getValue());
        }
        editorEdit.apply();
    }
}
