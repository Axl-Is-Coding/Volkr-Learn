package io.rong.imkit.plugin.location;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IRealTimeLocationStateListener {
    void onErrorException();

    void onParticipantChanged(List<String> list);
}
