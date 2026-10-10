package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.common.b;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = "com.facebook.devicerequests.internal.DeviceRequestsHelper";
    private static HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    public static void cleanUpAdvertisementService(String str) {
        cleanUpAdvertisementServiceImpl(str);
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e2) {
                Utility.logd(TAG, e2);
            }
            deviceRequestsListeners.remove(str);
        }
    }

    public static Bitmap generateQRCode(String str) {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.MARGIN, 2);
        try {
            b bVarA = new c().a(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
            int iC = bVarA.c();
            int iD = bVarA.d();
            int[] iArr = new int[iC * iD];
            for (int i = 0; i < iC; i++) {
                int i2 = i * iD;
                for (int i3 = 0; i3 < iD; i3++) {
                    iArr[i2 + i3] = bVarA.a(i3, i) ? -16777216 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iD, iC, Bitmap.Config.ARGB_8888);
            try {
                bitmapCreateBitmap.setPixels(iArr, 0, iD, 0, 0, iD, iC);
                return bitmapCreateBitmap;
            } catch (WriterException unused) {
                return bitmapCreateBitmap;
            }
        } catch (WriterException unused2) {
            return null;
        }
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DEVICE_INFO_DEVICE, Build.DEVICE);
            jSONObject.put(DEVICE_INFO_MODEL, Build.MODEL);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static boolean isAvailable() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return Build.VERSION.SDK_INT >= 16 && appSettingsWithoutQuery != null && appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled);
    }

    public static boolean startAdvertisementService(String str) {
        if (isAvailable()) {
            return startAdvertisementServiceImpl(str);
        }
        return false;
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        if (deviceRequestsListeners.containsKey(str)) {
            return true;
        }
        final String str2 = String.format("%s_%s_%s", SDK_HEADER, String.format("%s-%s", "android", FacebookSdk.getSdkVersion().replace('.', '|')), str);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType(SERVICE_TYPE);
        nsdServiceInfo.setServiceName(str2);
        nsdServiceInfo.setPort(80);
        NsdManager nsdManager = (NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
        NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.devicerequests.internal.DeviceRequestsHelper.1
            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo2, int i) {
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo2) {
                if (str2.equals(nsdServiceInfo2.getServiceName())) {
                    return;
                }
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo2) {
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo2, int i) {
            }
        };
        deviceRequestsListeners.put(str, registrationListener);
        nsdManager.registerService(nsdServiceInfo, 1, registrationListener);
        return true;
    }
}
