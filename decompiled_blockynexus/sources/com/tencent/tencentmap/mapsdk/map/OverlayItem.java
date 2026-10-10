package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mapsdk.raster.model.GeoPoint;

/* JADX INFO: loaded from: classes5.dex */
public class OverlayItem implements Parcelable {
    public static final Parcelable.Creator<OverlayItem> CREATOR = new Parcelable.Creator<OverlayItem>() { // from class: com.tencent.tencentmap.mapsdk.map.OverlayItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OverlayItem createFromParcel(Parcel parcel) {
            return new OverlayItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OverlayItem[] newArray(int i) {
            return new OverlayItem[i];
        }
    };
    protected boolean boDragable;
    private Drawable mMarker;
    protected GeoPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    protected OverlayItem(Parcel parcel) {
        this.boDragable = true;
        this.mPoint = (GeoPoint) parcel.readValue(GeoPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
    }

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        this.boDragable = true;
        this.mPoint = geoPoint.Copy();
        this.mTitle = str;
        this.mSnippet = str2;
        this.mMarker = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Drawable getMarker() {
        return this.mMarker;
    }

    public GeoPoint getPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isDragable() {
        return this.boDragable;
    }

    public void setDragable(boolean z) {
        this.boDragable = z;
    }

    public void setMarker(Drawable drawable) {
        this.mMarker = drawable;
        Drawable drawable2 = this.mMarker;
        if (drawable2 == null) {
            return;
        }
        Rect bounds = drawable2.getBounds();
        if (bounds == null) {
            ItemizedOverlay.boundCenterBottom(this.mMarker);
        } else if (bounds.left == 0 && bounds.right == 0 && bounds.top == 0 && bounds.bottom == 0) {
            ItemizedOverlay.boundCenterBottom(this.mMarker);
        }
    }

    public void setPoint(GeoPoint geoPoint) {
        this.mPoint = geoPoint.Copy();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
    }
}
