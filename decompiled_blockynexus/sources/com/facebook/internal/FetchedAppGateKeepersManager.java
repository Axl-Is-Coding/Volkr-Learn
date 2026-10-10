package com.facebook.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = "com.facebook.internal.FetchedAppGateKeepersManager";
    private static Long timestamp;
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    public interface Callback {
        void onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString("sdk_version", FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", str, APPLICATION_GATEKEEPER_EDGE), null);
        graphRequestNewGraphPathRequest.setSkipClientToken(true);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        return graphRequestNewGraphPathRequest.executeAndWait().getJSONObject();
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        loadAppGateKeepersAsync();
        return (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) ? z : fetchedAppGateKeepers.get(str2).optBoolean(str, z);
    }

    private static boolean isTimestampValid(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT;
    }

    static void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        jSONObject2 = fetchedAppGateKeepers.containsKey(str) ? fetchedAppGateKeepers.get(str) : new JSONObject();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.optJSONObject(0) : null;
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD) == null) {
            fetchedAppGateKeepers.put(str, jSONObject2);
        } else {
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                try {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i);
                    jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                } catch (JSONException e2) {
                    Utility.logd("FacebookSDK", e2);
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!callbacks.isEmpty()) {
            final Callback callbackPoll = callbacks.poll();
            if (callbackPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        callbackPoll.onCompleted();
                    }
                });
            }
        }
    }

    static JSONObject queryAppGateKeepers(String str, boolean z) {
        if (!z && fetchedAppGateKeepers.containsKey(str)) {
            return fetchedAppGateKeepers.get(str);
        }
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse == null) {
            return null;
        }
        FacebookSdk.getApplicationContext().getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, str), appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON(str, appGateKeepersQueryResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static synchronized void loadAppGateKeepersAsync(com.facebook.internal.FetchedAppGateKeepersManager.Callback r8) {
        /*
            java.lang.Class<com.facebook.internal.FetchedAppGateKeepersManager> r0 = com.facebook.internal.FetchedAppGateKeepersManager.class
            monitor-enter(r0)
            if (r8 == 0) goto La
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppGateKeepersManager$Callback> r1 = com.facebook.internal.FetchedAppGateKeepersManager.callbacks     // Catch: java.lang.Throwable -> L6e
            r1.add(r8)     // Catch: java.lang.Throwable -> L6e
        La:
            java.lang.Long r8 = com.facebook.internal.FetchedAppGateKeepersManager.timestamp     // Catch: java.lang.Throwable -> L6e
            boolean r8 = isTimestampValid(r8)     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L17
            pollCallbacks()     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r0)
            return
        L17:
            android.content.Context r8 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "com.facebook.internal.APP_GATEKEEPERS.%s"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6e
            r5 = 0
            r4[r5] = r1     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch: java.lang.Throwable -> L6e
            if (r8 != 0) goto L2f
            monitor-exit(r0)
            return
        L2f:
            java.lang.String r4 = "com.facebook.internal.preferences.APP_GATEKEEPERS"
            android.content.SharedPreferences r4 = r8.getSharedPreferences(r4, r5)     // Catch: java.lang.Throwable -> L6e
            r6 = 0
            java.lang.String r4 = r4.getString(r2, r6)     // Catch: java.lang.Throwable -> L6e
            boolean r7 = com.facebook.internal.Utility.isNullOrEmpty(r4)     // Catch: java.lang.Throwable -> L6e
            if (r7 != 0) goto L52
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L47 java.lang.Throwable -> L6e
            r7.<init>(r4)     // Catch: org.json.JSONException -> L47 java.lang.Throwable -> L6e
            r6 = r7
            goto L4d
        L47:
            r4 = move-exception
            java.lang.String r7 = "FacebookSDK"
            com.facebook.internal.Utility.logd(r7, r4)     // Catch: java.lang.Throwable -> L6e
        L4d:
            if (r6 == 0) goto L52
            parseAppGateKeepersFromJSON(r1, r6)     // Catch: java.lang.Throwable -> L6e
        L52:
            java.util.concurrent.Executor r4 = com.facebook.FacebookSdk.getExecutor()     // Catch: java.lang.Throwable -> L6e
            if (r4 != 0) goto L5a
            monitor-exit(r0)
            return
        L5a:
            java.util.concurrent.atomic.AtomicBoolean r6 = com.facebook.internal.FetchedAppGateKeepersManager.isLoading     // Catch: java.lang.Throwable -> L6e
            boolean r3 = r6.compareAndSet(r5, r3)     // Catch: java.lang.Throwable -> L6e
            if (r3 != 0) goto L64
            monitor-exit(r0)
            return
        L64:
            com.facebook.internal.FetchedAppGateKeepersManager$1 r3 = new com.facebook.internal.FetchedAppGateKeepersManager$1     // Catch: java.lang.Throwable -> L6e
            r3.<init>()     // Catch: java.lang.Throwable -> L6e
            r4.execute(r3)     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r0)
            return
        L6e:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppGateKeepersManager.loadAppGateKeepersAsync(com.facebook.internal.FetchedAppGateKeepersManager$Callback):void");
    }
}
