package com.unity3d.services.ar;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ARUtils {
    public static final int AR_CHECK_NOT_SUPPORTED = 0;
    public static final int AR_CHECK_SUPPORTED = 1;
    public static final int AR_CHECK_TRANSIENT = 2;
    private static Config.LightEstimationMode[] lightEstimationModes;
    private static Config.PlaneFindingMode[] planeFindingModes;
    private static Config.UpdateMode[] updateModes;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        r0.setPlaneFindingMode(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        r0.setUpdateMode(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        r0.setLightEstimationMode(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ar.core.Config createConfiguration(org.json.JSONObject r7, com.google.ar.core.Session r8) {
        /*
            com.google.ar.core.Config r0 = new com.google.ar.core.Config
            r0.<init>(r8)
            java.lang.String r8 = "lightEstimationMode"
            boolean r1 = r7.has(r8)
            r2 = 0
            if (r1 == 0) goto L30
            java.lang.String r8 = r7.getString(r8)     // Catch: org.json.JSONException -> L2b
            com.google.ar.core.Config$LightEstimationMode[] r1 = com.unity3d.services.ar.ARUtils.lightEstimationModes     // Catch: org.json.JSONException -> L2b
            int r3 = r1.length     // Catch: org.json.JSONException -> L2b
            r4 = 0
        L16:
            if (r4 >= r3) goto L30
            r5 = r1[r4]     // Catch: org.json.JSONException -> L2b
            java.lang.String r6 = r5.name()     // Catch: org.json.JSONException -> L2b
            boolean r6 = r8.equalsIgnoreCase(r6)     // Catch: org.json.JSONException -> L2b
            if (r6 == 0) goto L28
            r0.setLightEstimationMode(r5)     // Catch: org.json.JSONException -> L2b
            goto L30
        L28:
            int r4 = r4 + 1
            goto L16
        L2b:
            java.lang.String r8 = "lightEstimationEnabled is not a string."
            com.unity3d.services.core.log.DeviceLog.warning(r8)
        L30:
            java.lang.String r8 = "planeFindingMode"
            boolean r1 = r7.has(r8)
            if (r1 == 0) goto L5a
            java.lang.String r8 = r7.getString(r8)     // Catch: org.json.JSONException -> L55
            com.google.ar.core.Config$PlaneFindingMode[] r1 = com.unity3d.services.ar.ARUtils.planeFindingModes     // Catch: org.json.JSONException -> L55
            int r3 = r1.length     // Catch: org.json.JSONException -> L55
            r4 = 0
        L40:
            if (r4 >= r3) goto L5a
            r5 = r1[r4]     // Catch: org.json.JSONException -> L55
            java.lang.String r6 = r5.name()     // Catch: org.json.JSONException -> L55
            boolean r6 = r8.equalsIgnoreCase(r6)     // Catch: org.json.JSONException -> L55
            if (r6 == 0) goto L52
            r0.setPlaneFindingMode(r5)     // Catch: org.json.JSONException -> L55
            goto L5a
        L52:
            int r4 = r4 + 1
            goto L40
        L55:
            java.lang.String r8 = "planeFindingMode is not a string."
            com.unity3d.services.core.log.DeviceLog.warning(r8)
        L5a:
            java.lang.String r8 = "updateMode"
            boolean r1 = r7.has(r8)
            if (r1 == 0) goto L83
            java.lang.String r7 = r7.getString(r8)     // Catch: org.json.JSONException -> L7e
            com.google.ar.core.Config$UpdateMode[] r8 = com.unity3d.services.ar.ARUtils.updateModes     // Catch: org.json.JSONException -> L7e
            int r1 = r8.length     // Catch: org.json.JSONException -> L7e
        L69:
            if (r2 >= r1) goto L83
            r3 = r8[r2]     // Catch: org.json.JSONException -> L7e
            java.lang.String r4 = r3.name()     // Catch: org.json.JSONException -> L7e
            boolean r4 = r7.equalsIgnoreCase(r4)     // Catch: org.json.JSONException -> L7e
            if (r4 == 0) goto L7b
            r0.setUpdateMode(r3)     // Catch: org.json.JSONException -> L7e
            goto L83
        L7b:
            int r2 = r2 + 1
            goto L69
        L7e:
            java.lang.String r7 = "updateMode is not a string."
            com.unity3d.services.core.log.DeviceLog.warning(r7)
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ar.ARUtils.createConfiguration(org.json.JSONObject, com.google.ar.core.Session):com.google.ar.core.Config");
    }

    @TargetApi(19)
    public static JSONObject getConfigEnums() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            for (Config.LightEstimationMode lightEstimationMode : Config.LightEstimationMode.values()) {
                arrayList.add(lightEstimationMode.name());
            }
            jSONObject.put("lightEstimationMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (Config.PlaneFindingMode planeFindingMode : Config.PlaneFindingMode.values()) {
                arrayList.add(planeFindingMode.name());
            }
            jSONObject.put("planeFindingMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (Config.UpdateMode updateMode : Config.UpdateMode.values()) {
                arrayList.add(updateMode.name());
            }
            jSONObject.put("updateMode", new JSONArray(arrayList.toArray()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static int isSupported(Context context) {
        if (!ARCheck.isFrameworkPresent()) {
            return 0;
        }
        if (planeFindingModes == null) {
            planeFindingModes = Config.PlaneFindingMode.values();
            lightEstimationModes = Config.LightEstimationMode.values();
            updateModes = Config.UpdateMode.values();
        }
        ArCoreApk.Availability availabilityCheckAvailability = ArCoreApk.getInstance().checkAvailability(context);
        if (availabilityCheckAvailability.isTransient()) {
            return 2;
        }
        if (availabilityCheckAvailability == ArCoreApk.Availability.SUPPORTED_INSTALLED) {
            try {
                new Session(context);
                return 1;
            } catch (FatalException | UnavailableException unused) {
            } catch (SecurityException unused2) {
                return 1;
            }
        }
        return 0;
    }
}
