package io.rong.imlib.location;

import io.rong.imlib.location.RealTimeLocationConstant;

/* JADX INFO: loaded from: classes5.dex */
public interface RealTimeLocationObserver {
    void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode);

    void onParticipantsJoin(String str);

    void onParticipantsQuit(String str);

    @Deprecated
    void onReceiveLocation(double d2, double d3, String str);

    void onReceiveLocationWithType(double d2, double d3, RealTimeLocationType realTimeLocationType, String str);

    void onStatusChange(RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationStatus);
}
