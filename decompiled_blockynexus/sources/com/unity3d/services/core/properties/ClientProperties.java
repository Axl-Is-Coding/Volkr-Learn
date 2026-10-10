package com.unity3d.services.core.properties;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ClientProperties {
    private static final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static WeakReference<Activity> _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static String _gameId;

    public static JSONArray areClassesPresent(JSONArray jSONArray) {
        String string;
        if (jSONArray == null) {
            return new JSONArray();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                string = jSONArray.get(i).toString();
            } catch (Exception unused) {
                string = "";
            }
            try {
                try {
                    Class.forName(string);
                    jSONObject.put("class", string);
                    jSONObject.put("found", true);
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                jSONObject.put("class", string);
                jSONObject.put("found", false);
            }
            try {
                jSONArray2.put(jSONObject);
            } catch (Exception unused4) {
            }
        }
        return jSONArray2;
    }

    public static Activity getActivity() {
        return _activity.get();
    }

    public static String getAppName() {
        return _applicationContext.getPackageName();
    }

    public static String getAppVersion() {
        String packageName = getApplicationContext().getPackageName();
        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            return packageManager.getPackageInfo(packageName, 0).versionName == null ? "FakeVersionName" : packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            DeviceLog.exception("Error getting package info", e2);
            return null;
        }
    }

    public static Application getApplication() {
        return _application;
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static String getGameId() {
        return _gameId;
    }

    public static boolean isAppDebuggable() {
        boolean zEquals;
        if (getApplicationContext() == null) {
            return false;
        }
        PackageManager packageManager = getApplicationContext().getPackageManager();
        String packageName = getApplicationContext().getPackageName();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            int i = applicationInfo.flags & 2;
            applicationInfo.flags = i;
            zEquals = i != 0;
            z = false;
        } catch (PackageManager.NameNotFoundException e2) {
            DeviceLog.exception("Could not find name", e2);
            zEquals = false;
        }
        if (z) {
            try {
                for (Signature signature : packageManager.getPackageInfo(packageName, 64).signatures) {
                    zEquals = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getSubjectX500Principal().equals(DEBUG_CERT);
                    if (zEquals) {
                        break;
                    }
                }
            } catch (PackageManager.NameNotFoundException e3) {
                DeviceLog.exception("Could not find name", e3);
            } catch (CertificateException e4) {
                DeviceLog.exception("Certificate exception", e4);
            }
        }
        return zEquals;
    }

    public static void setActivity(Activity activity) {
        _activity = new WeakReference<>(activity);
    }

    public static void setApplication(Application application) {
        _application = application;
    }

    public static void setApplicationContext(Context context) {
        _applicationContext = context;
    }

    public static void setGameId(String str) {
        _gameId = str;
    }
}
