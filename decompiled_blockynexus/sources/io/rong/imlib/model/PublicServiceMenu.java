package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceMenu implements Parcelable {
    public static final Parcelable.Creator<PublicServiceMenu> CREATOR = new Parcelable.Creator<PublicServiceMenu>() { // from class: io.rong.imlib.model.PublicServiceMenu.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMenu createFromParcel(Parcel parcel) {
            return new PublicServiceMenu(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMenu[] newArray(int i) {
            return new PublicServiceMenu[i];
        }
    };
    private static final String TAG = "PublicServiceMenu";
    private List<PublicServiceMenuItem> menuItems;

    public enum PublicServiceMenuItemType {
        Group(0, "GROUP"),
        View(1, "VIEW"),
        Click(2, "CLICK"),
        Entry(3, "ENTRY");

        private String command;
        private int value;

        PublicServiceMenuItemType(int i, String str) {
            this.value = i;
            this.command = str;
        }

        public static PublicServiceMenuItemType setValue(int i) {
            for (PublicServiceMenuItemType publicServiceMenuItemType : values()) {
                if (i == publicServiceMenuItemType.getValue()) {
                    return publicServiceMenuItemType;
                }
            }
            return null;
        }

        public String getMessage() {
            return this.command;
        }

        public int getValue() {
            return this.value;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PublicServiceMenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(List<PublicServiceMenuItem> list) {
        this.menuItems = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeListToParcel(parcel, this.menuItems);
    }

    public PublicServiceMenu(JSONArray jSONArray) {
        this.menuItems = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.menuItems.add(new PublicServiceMenuItem(jSONArray.optJSONObject(i)));
            } catch (Exception e2) {
                RLog.e(TAG, "PublicServiceMenu ", e2);
            }
        }
    }

    private PublicServiceMenu() {
    }

    private PublicServiceMenu(Parcel parcel) {
        this.menuItems = ParcelUtils.readListFromParcel(parcel, PublicServiceMenuItem.class);
    }
}
