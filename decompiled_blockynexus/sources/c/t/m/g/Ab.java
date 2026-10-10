package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ab implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2876f;

    public static String a(List<Ab> list) {
        if (list == null || list.size() == 0) {
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (Ab ab : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mac", ab.f2874d);
                jSONObject.put("major", ab.f2872b);
                jSONObject.put("minor", ab.f2873c);
                jSONObject.put("rssi", ab.f2875e);
                jSONObject.put("time", ab.f2876f / 1000);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final String toString() {
        return "Beacon [major=" + this.f2872b + ", minor=" + this.f2873c + ", bluetoothAddress=" + this.f2874d + ", rssi=" + this.f2875e + ", time=" + this.f2876f + "]";
    }

    @SuppressLint({"NewApi"})
    public static Ab a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice == null) {
            return null;
        }
        boolean z = false;
        int i2 = 2;
        while (true) {
            if (i2 <= 5) {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (!z) {
            return null;
        }
        Ab ab = new Ab();
        ab.f2872b = ((bArr[i2 + 20] & 255) << 8) + (bArr[i2 + 21] & 255);
        ab.f2873c = ((bArr[i2 + 22] & 255) << 8) + (bArr[i2 + 23] & 255);
        ab.f2875e = i;
        ab.f2874d = bluetoothDevice.getAddress().toUpperCase();
        ab.f2871a = bluetoothDevice.getName();
        ab.f2876f = System.currentTimeMillis();
        return ab;
    }
}
