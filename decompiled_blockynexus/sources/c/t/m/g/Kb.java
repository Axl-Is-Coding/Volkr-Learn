package c.t.m.g;

import com.sandboxol.center.config.StringConstant;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import io.rong.imkit.plugin.LocationConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Kb implements TencentPoi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f2951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f2953f;
    private double g;
    private String h;

    public Kb(TencentPoi tencentPoi) {
        this.f2948a = tencentPoi.getName();
        this.f2949b = tencentPoi.getAddress();
        this.f2950c = tencentPoi.getCatalog();
        this.f2951d = tencentPoi.getDistance();
        this.f2952e = tencentPoi.getUid();
        this.f2953f = tencentPoi.getLatitude();
        this.g = tencentPoi.getLongitude();
        this.h = tencentPoi.getDirection();
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final String getAddress() {
        return this.f2949b;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final String getCatalog() {
        return this.f2950c;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final String getDirection() {
        return this.h;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final double getDistance() {
        return this.f2951d;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final double getLatitude() {
        return this.f2953f;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final double getLongitude() {
        return this.g;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final String getName() {
        return this.f2948a;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public final String getUid() {
        return this.f2952e;
    }

    public final String toString() {
        return "PoiData{name=" + this.f2948a + ",addr=" + this.f2949b + ",catalog=" + this.f2950c + ",dist=" + this.f2951d + ",latitude=" + this.f2953f + ",longitude=" + this.g + ",direction=" + this.h + ",}";
    }

    public Kb(JSONObject jSONObject) throws JSONException {
        this.f2948a = jSONObject.optString("name");
        this.f2949b = jSONObject.optString("addr");
        this.f2950c = jSONObject.optString("catalog");
        this.f2951d = jSONObject.optDouble("dist");
        this.f2952e = jSONObject.optString(StringConstant.UID);
        this.f2953f = jSONObject.optDouble(LocationConst.LATITUDE);
        this.g = jSONObject.optDouble(LocationConst.LONGITUDE);
        this.h = jSONObject.optString(TencentLocation.EXTRA_DIRECTION, "");
        if (Double.isNaN(this.f2953f)) {
            this.f2953f = jSONObject.optDouble("pointy");
        }
        if (Double.isNaN(this.g)) {
            this.g = jSONObject.optDouble("pointx");
        }
    }
}
