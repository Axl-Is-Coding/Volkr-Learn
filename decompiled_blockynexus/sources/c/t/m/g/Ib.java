package c.t.m.g;

import android.os.Parcel;
import com.tencent.map.geolocation.TencentLocation;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ib implements Mb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f2929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f2930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f2931f;
    public String g;
    public String h;

    static {
        new Hb();
    }

    public Ib() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "AddressData{name=" + this.f2926a + ",dtype=" + this.f2927b + ",pointx=" + this.f2929d + ",pointy=" + this.f2930e + ",dist=" + this.f2931f + ",direction=" + this.g + ",tag=" + this.h + ",}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2926a);
        parcel.writeString(this.f2927b);
        parcel.writeString(this.f2928c);
        parcel.writeDouble(this.f2929d);
        parcel.writeDouble(this.f2930e);
        parcel.writeDouble(this.f2931f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    public Ib(JSONObject jSONObject) {
        this.f2926a = jSONObject.optString("name");
        this.f2927b = jSONObject.optString("dtype");
        this.f2928c = jSONObject.optString("addr");
        this.f2929d = jSONObject.optDouble("pointx");
        this.f2930e = jSONObject.optDouble("pointy");
        this.f2931f = jSONObject.optDouble("dist");
        this.g = jSONObject.optString(TencentLocation.EXTRA_DIRECTION);
        this.h = jSONObject.optString("tag");
    }
}
