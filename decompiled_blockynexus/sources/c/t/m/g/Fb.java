package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2904a = true;

    static {
        new Eb();
    }

    public static TencentLocation a(TencentLocation tencentLocation, byte[] bArr) {
        tencentLocation.getExtra().putByteArray("raw_data", bArr);
        return tencentLocation;
    }

    public static boolean a(int i) {
        return i == 0 || i == 1 || i == 3 || i == 4 || i == 7;
    }

    public static void a(TencentLocation tencentLocation, String str) {
        if (tencentLocation == null) {
            return;
        }
        tencentLocation.getExtra().putString("raw_query", str);
    }

    public static void a(TencentLocation tencentLocation, Location location) {
        if (tencentLocation == null) {
            return;
        }
        try {
            tencentLocation.getExtra().putParcelable("raw_gps", location);
        } catch (Exception unused) {
        }
    }

    public static boolean a(TencentLocationRequest tencentLocationRequest) {
        if (tencentLocationRequest == null) {
            return false;
        }
        return tencentLocationRequest.getExtras().getBoolean("request_raw_data");
    }
}
