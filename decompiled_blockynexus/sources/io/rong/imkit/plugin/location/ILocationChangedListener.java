package io.rong.imkit.plugin.location;

import io.rong.imlib.location.RealTimeLocationConstant;

/* JADX INFO: loaded from: classes5.dex */
public interface ILocationChangedListener {
    void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode);

    void onLocationChanged(double d2, double d3, String str);

    void onParticipantJoinSharing(String str);

    void onParticipantQuitSharing(String str);

    void onSharingTerminated();
}
