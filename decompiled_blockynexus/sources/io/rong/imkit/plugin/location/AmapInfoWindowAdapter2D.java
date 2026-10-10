package io.rong.imkit.plugin.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.Marker;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class AmapInfoWindowAdapter2D implements AMap.InfoWindowAdapter {
    private Context context;

    public AmapInfoWindowAdapter2D(Context context) {
        this.context = context;
    }

    private void setViewContent(Marker marker, View view) {
        ((TextView) view.findViewById(R.id.rc_location_marker_title)).setText(marker.getTitle());
    }

    public View getInfoContents(Marker marker) {
        return null;
    }

    public View getInfoWindow(Marker marker) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.rc_location_marker_info_window, (ViewGroup) null);
        setViewContent(marker, viewInflate);
        return viewInflate;
    }
}
