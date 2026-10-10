package com.unity3d.services.core.misc;

import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Utilities {
    public static String Sha256(String str) {
        return Sha256(str.getBytes());
    }

    public static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject3.put(next, jSONObject2.get(next));
        }
        Iterator<String> itKeys2 = jSONObject.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            if (jSONObject3.has(next2) && (jSONObject3.get(next2) instanceof JSONObject) && (jSONObject.get(next2) instanceof JSONObject)) {
                jSONObject3.put(next2, mergeJsonObjects(jSONObject.getJSONObject(next2), jSONObject3.getJSONObject(next2)));
            } else {
                jSONObject3.put(next2, jSONObject.get(next2));
            }
        }
        return jSONObject3;
    }

    public static byte[] readFileBytes(File file) throws IOException {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[(int) file.length()];
        int i = 0;
        long j = 4096;
        int length = file.length() < j ? (int) file.length() : 4096;
        while (true) {
            int i2 = fileInputStream.read(bArr, i, length);
            if (i2 <= 0) {
                fileInputStream.close();
                return bArr;
            }
            i += i2;
            if (file.length() - ((long) i) < j) {
                length = ((int) file.length()) - i;
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i <= 15) {
                str = str + "0";
            }
            str = str + Integer.toHexString(i);
        }
        return str;
    }

    public static boolean writeFile(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (file == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception e3) {
                DeviceLog.exception("Error closing FileOutputStream", e3);
            }
            z = true;
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            DeviceLog.exception("Could not write file", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                    DeviceLog.exception("Error closing FileOutputStream", e5);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e6) {
                    DeviceLog.exception("Error closing FileOutputStream", e6);
                }
            }
            throw th;
        }
        if (z) {
            DeviceLog.debug("Wrote file: " + file.getAbsolutePath());
        }
        return z;
    }

    public static String Sha256(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, 0, bArr.length);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            DeviceLog.exception("SHA-256 algorithm not found", e2);
            return null;
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            DeviceLog.exception("SHA-256 algorithm not found", e2);
            return null;
        }
    }
}
