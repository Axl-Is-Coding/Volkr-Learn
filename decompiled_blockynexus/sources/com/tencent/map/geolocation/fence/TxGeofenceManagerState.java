package com.tencent.map.geolocation.fence;

import com.tencent.map.geolocation.TencentLocation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public interface TxGeofenceManagerState {
    void add(int i, TencentLocation tencentLocation);

    long getLastInterval();

    TencentLocation getLastLocation();

    long getLastLocationTime();

    Map<String, String> getLastSummary();

    String getLocationTimes();

    List<TencentLocation> getLocations();

    long getNextLocationTime();

    double getSpeed();

    List<Map<String, String>> getSummary();

    void reset();
}
