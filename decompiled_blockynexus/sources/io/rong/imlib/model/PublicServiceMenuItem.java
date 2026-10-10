package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.model.PublicServiceMenu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceMenuItem implements Parcelable {
    public static final Parcelable.Creator<PublicServiceMenuItem> CREATOR = new Parcelable.Creator<PublicServiceMenuItem>() { // from class: io.rong.imlib.model.PublicServiceMenuItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMenuItem createFromParcel(Parcel parcel) {
            return new PublicServiceMenuItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMenuItem[] newArray(int i) {
            return new PublicServiceMenuItem[i];
        }
    };
    private static final String TAG = "PublicServiceMenuItem";
    private String id;
    private String name;
    private List<PublicServiceMenuItem> subMenuItems;
    private PublicServiceMenu.PublicServiceMenuItemType type;
    private String url;

    public PublicServiceMenuItem(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray;
        this.subMenuItems = new ArrayList();
        try {
            if (jSONObject.has("id")) {
                this.id = jSONObject.optString("id");
            }
            if (jSONObject.has("name")) {
                this.name = jSONObject.optString("name");
            }
            if (jSONObject.has("url")) {
                this.url = jSONObject.optString("url");
            }
            if (jSONObject.has("type")) {
                this.type = PublicServiceMenu.PublicServiceMenuItemType.setValue(jSONObject.optInt("type"));
                if (this.type == null || this.type != PublicServiceMenu.PublicServiceMenuItemType.Group || !jSONObject.has("children") || (jSONArray = jSONObject.getJSONArray("children")) == null) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        try {
                            this.subMenuItems.add(new PublicServiceMenuItem(jSONObjectOptJSONObject));
                        } catch (Exception e2) {
                            RLog.e(TAG, "PublicServiceMenuItem ", e2);
                        }
                    }
                }
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "PublicServiceMenuItem", e3);
            throw new Exception("PublicServiceMenuItem parse error!");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<PublicServiceMenuItem> getSubMenuItems() {
        return this.subMenuItems;
    }

    public PublicServiceMenu.PublicServiceMenuItemType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.id);
        ParcelUtils.writeToParcel(parcel, this.name);
        ParcelUtils.writeToParcel(parcel, this.url);
        PublicServiceMenu.PublicServiceMenuItemType publicServiceMenuItemType = this.type;
        ParcelUtils.writeToParcel(parcel, publicServiceMenuItemType != null ? Integer.valueOf(publicServiceMenuItemType.getValue()) : null);
        ParcelUtils.writeToParcel(parcel, this.subMenuItems);
    }

    private PublicServiceMenuItem() {
        this.subMenuItems = new ArrayList();
    }

    public PublicServiceMenuItem(Parcel parcel) {
        this.subMenuItems = new ArrayList();
        this.id = ParcelUtils.readFromParcel(parcel);
        this.name = ParcelUtils.readFromParcel(parcel);
        this.url = ParcelUtils.readFromParcel(parcel);
        this.type = PublicServiceMenu.PublicServiceMenuItemType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue());
        this.subMenuItems = ParcelUtils.readListFromParcel(parcel, PublicServiceMenuItem.class);
    }
}
