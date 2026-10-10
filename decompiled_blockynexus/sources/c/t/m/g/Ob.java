package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ob implements Parcelable, TencentLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ob f2969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Jb f2970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Wb f2971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2974f;
    private Vb g;
    private final Bundle h;
    private String i;
    private Location j;
    private final long k;
    public long l;
    private int m;

    static {
        new Nb();
        f2969a = new Ob(-1);
    }

    /* synthetic */ Ob(int i, byte b2) {
        this(i);
    }

    static /* synthetic */ Ob c(Ob ob) {
        Ob ob2 = new Ob(-1);
        if (ob == null) {
            ob2.f2970b = new Jb();
        } else {
            Jb jb = ob.f2970b;
            Jb jb2 = new Jb();
            if (jb != null) {
                jb2.f2936a = jb.f2936a;
                jb2.f2937b = jb.f2937b;
                jb2.f2938c = jb.f2938c;
                jb2.f2939d = jb.f2939d;
                jb2.f2940e = jb.f2940e;
                jb2.f2941f = jb.f2941f;
            }
            ob2.f2970b = jb2;
            ob2.f2972d = ob.f2972d;
            ob2.f2974f = ob.f2974f;
            ob2.g = Vb.a(ob.g);
            if (ob.h.size() > 0) {
                ob2.h.putAll(ob.h);
            }
        }
        return ob2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final float getAccuracy() {
        Jb jb = this.f2970b;
        return jb != null ? jb.f2939d : WheelView.DividerConfig.FILL;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getAddress() {
        int i = this.f2972d;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        if (i == 3) {
            Vb vb = this.g;
            if (vb != null) {
                return vb.f3028c.m;
            }
            return null;
        }
        Jb jb = this.f2970b;
        if (jb != null) {
            return jb.f2941f;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final double getAltitude() {
        Jb jb = this.f2970b;
        if (jb != null) {
            return jb.f2938c;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final Integer getAreaStat() {
        Vb vb = this.g;
        if (vb != null) {
            return Integer.valueOf(vb.f3026a);
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final float getBearing() {
        Location location = this.j;
        return location == null ? WheelView.DividerConfig.FILL : location.getBearing();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getCity() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.g;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getCityCode() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.f2957d;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getCityPhoneCode() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.f2958e;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final int getCoordinateType() {
        return this.m;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final double getDirection() {
        return this.h.getDouble(TencentLocation.EXTRA_DIRECTION);
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getDistrict() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.h;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final long getElapsedRealtime() {
        return this.k;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final Bundle getExtra() {
        return this.h;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final int getGPSRssi() {
        Bundle extras;
        Location location = this.j;
        if (location == null || (extras = location.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("rssi", 0);
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getIndoorBuildingFloor() {
        Wb wb = this.f2971c;
        return wb != null ? wb.f3037b : "1000";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getIndoorBuildingId() {
        Wb wb = this.f2971c;
        if (wb != null) {
            return wb.f3036a;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final int getIndoorLocationType() {
        Wb wb = this.f2971c;
        if (wb != null) {
            return wb.f3038c;
        }
        return -1;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final double getLatitude() {
        Jb jb = this.f2970b;
        if (jb != null) {
            return jb.f2936a;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final double getLongitude() {
        Jb jb = this.f2970b;
        if (jb != null) {
            return jb.f2937b;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getName() {
        int i = this.f2972d;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        if (i == 3) {
            Vb vb = this.g;
            if (vb != null) {
                return vb.f3028c.f2956c;
            }
            return null;
        }
        Jb jb = this.f2970b;
        if (jb != null) {
            return jb.f2940e;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getNation() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.f2955b;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final List<TencentPoi> getPoiList() {
        Vb vb = this.g;
        return vb != null ? new ArrayList(vb.f3027b) : Collections.emptyList();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getProvider() {
        return this.i;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getProvince() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.f2959f;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final float getSpeed() {
        Location location = this.j;
        return location == null ? WheelView.DividerConfig.FILL : location.getSpeed();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getStreet() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.k;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getStreetNo() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.l;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final long getTime() {
        return this.l;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getTown() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.i;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final String getVillage() {
        Vb vb = this.g;
        if (vb != null) {
            return vb.f3028c.j;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public final int isMockGps() {
        return this.f2973e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TxLocation{");
        sb.append("level=");
        sb.append(this.f2972d);
        sb.append(",");
        sb.append("name=");
        sb.append(getName());
        sb.append(",");
        sb.append("address=");
        sb.append(getAddress());
        sb.append(",");
        sb.append("provider=");
        sb.append(getProvider());
        sb.append(",");
        sb.append("latitude=");
        sb.append(getLatitude());
        sb.append(",");
        sb.append("longitude=");
        sb.append(getLongitude());
        sb.append(",");
        sb.append("altitude=");
        sb.append(getAltitude());
        sb.append(",");
        sb.append("accuracy=");
        sb.append(getAccuracy());
        sb.append(",");
        sb.append("cityCode=");
        sb.append(getCityCode());
        sb.append(",");
        sb.append("areaStat=");
        sb.append(getAreaStat());
        sb.append(",");
        sb.append("nation=");
        sb.append(getNation());
        sb.append(",");
        sb.append("province=");
        sb.append(getProvince());
        sb.append(",");
        sb.append("city=");
        sb.append(getCity());
        sb.append(",");
        sb.append("district=");
        sb.append(getDistrict());
        sb.append(",");
        sb.append("street=");
        sb.append(getStreet());
        sb.append(",");
        sb.append("streetNo=");
        sb.append(getStreetNo());
        sb.append(",");
        sb.append("town=");
        sb.append(getTown());
        sb.append(",");
        sb.append("village=");
        sb.append(getVillage());
        sb.append(",");
        sb.append("bearing=");
        sb.append(getBearing());
        sb.append(",");
        sb.append("time=");
        sb.append(getTime());
        sb.append(",");
        sb.append("poilist=[");
        Iterator<TencentPoi> it = getPoiList().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2972d);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble(getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        Vb vb = this.g;
        parcel.writeString(vb != null ? vb.f3028c.f2957d : null);
        parcel.writeString(getName());
        parcel.writeLong(this.l);
        parcel.writeBundle(this.h);
    }

    /* synthetic */ Ob(String str, byte b2) throws JSONException {
        this(str);
    }

    static /* synthetic */ Ob b(Ob ob, int i) {
        ob.f2972d = i;
        return ob;
    }

    private Ob(int i) {
        this.h = new Bundle();
        this.i = TencentLocation.NETWORK_PROVIDER;
        this.f2972d = i;
        this.k = SystemClock.elapsedRealtime();
        this.l = System.currentTimeMillis();
    }

    static /* synthetic */ Ob b(Ob ob, String str) {
        ob.i = str;
        return ob;
    }

    public final void a(Location location) {
        if (this.f2970b != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            double dRound = Math.round(latitude * 1000000.0d);
            Double.isNaN(dRound);
            double dRound2 = Math.round(longitude * 1000000.0d);
            Double.isNaN(dRound2);
            Jb jb = this.f2970b;
            jb.f2936a = dRound / 1000000.0d;
            jb.f2937b = dRound2 / 1000000.0d;
            jb.f2938c = location.getAltitude();
            this.f2970b.f2939d = location.getAccuracy();
        }
    }

    /* JADX INFO: compiled from: TL */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Ob f2976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2978d = TencentLocation.NETWORK_PROVIDER;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Location f2979e;

        public final Ob a() {
            Ob ob;
            String str = this.f2975a;
            if (str != null) {
                try {
                    ob = new Ob(str, (byte) 0);
                } catch (JSONException unused) {
                    return Ob.f2969a;
                }
            } else {
                ob = Ob.c(this.f2976b);
            }
            Ob.b(ob, this.f2977c);
            Ob.b(ob, this.f2978d);
            Ob.a(ob, this.f2979e);
            Fb.a(ob, this.f2979e);
            return ob;
        }

        public final a a(Location location) {
            this.f2979e = new Location(location);
            return this;
        }
    }

    private Ob(String str) throws JSONException {
        Lb lb;
        this.h = new Bundle();
        this.i = TencentLocation.NETWORK_PROVIDER;
        this.k = SystemClock.elapsedRealtime();
        this.l = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.f2970b = new Jb(jSONObject.getJSONObject("location"));
            try {
                this.f2971c = new Wb(jSONObject.getJSONObject("indoorinfo"));
            } catch (Throwable unused) {
            }
            this.f2974f = jSONObject.optString("bearing");
            this.f2973e = jSONObject.optInt("fackgps", 0);
            this.l = jSONObject.optLong("timestamp", System.currentTimeMillis());
            try {
                String strOptString = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.h.putInt("icontrol", Integer.valueOf(strOptString.split(",")[0]).intValue());
                }
            } catch (Exception unused2) {
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("details");
            if (jSONObjectOptJSONObject != null) {
                try {
                    this.g = new Vb(jSONObjectOptJSONObject);
                } catch (JSONException e2) {
                    throw e2;
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("addrdesp");
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("detail")) {
                    this.g = new Vb(jSONObjectOptJSONObject2.optJSONObject("detail"));
                }
            }
            Vb vb = this.g;
            if (vb == null || (lb = vb.f3028c) == null) {
                return;
            }
            this.h.putAll(lb.n);
        } catch (JSONException e3) {
            throw e3;
        }
    }

    public static Ob a(Ob ob, boolean z) {
        String str;
        if (ob != null && (str = ob.f2974f) != null && !z) {
            int i = 0;
            if (str != null && str.split(",").length > 1) {
                i = Integer.parseInt(str.split(",")[1]);
            }
            Jb jb = ob.f2970b;
            if (jb != null) {
                try {
                    jb.f2939d = (float) com.tencent.tencentmap.lbssdk.service.e.r(jb.f2939d, i, -70);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
        return ob;
    }

    public static Ob a(Ob ob, Ob ob2) {
        if (ob != null && ob2 != null) {
            Jb jb = ob2.f2970b;
            if (jb != null) {
                Jb jb2 = ob.f2970b;
                if (jb2 == null) {
                    jb2 = new Jb();
                }
                jb2.f2940e = jb.f2940e;
                jb2.f2941f = jb.f2941f;
                ob.f2970b = jb2;
            }
            ob.g = Vb.a(ob2.g);
        }
        return ob;
    }

    public static Ob a(Ob ob, int i) {
        ob.m = i;
        return ob;
    }

    public static void a(Ob ob) throws JSONException {
        if (ob == f2969a) {
            throw new JSONException("location failed");
        }
    }

    static /* synthetic */ Ob a(Ob ob, Location location) {
        ob.j = location;
        return ob;
    }
}
