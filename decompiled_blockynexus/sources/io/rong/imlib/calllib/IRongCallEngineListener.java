package io.rong.imlib.calllib;

/* JADX INFO: loaded from: classes5.dex */
public interface IRongCallEngineListener {
    void onApiCallExecuted(String str, int i);

    void onAudioQuality(String str, int i, short s, short s2);

    void onAudioVolumeIndication(int i);

    void onCameraReady();

    void onConnectionInterrupted();

    void onConnectionLost();

    void onError(int i);

    void onFirstLocalVideoFrame(int i, int i2, int i3);

    void onFirstRemoteVideoDecoded(String str, int i, int i2, int i3);

    void onFirstRemoteVideoFrame(String str, int i, int i2, int i3);

    void onJoinChannelSuccess(String str, String str2, int i);

    void onLeaveChannel();

    void onLocalVideoStat(int i, int i2);

    void onMediaEngineEvent(int i);

    void onNetworkReceiveLost(int i);

    void onNotifyAnswerObserverRequestBecomeNormalUser(String str, long j);

    void onNotifyDegradeNormalUserToObserver(String str, String str2);

    void onNotifyHostControlUserDevice(String str, String str2, int i, boolean z);

    void onNotifySharingScreen(boolean z);

    void onNotifyUpgradeObserverToNormalUser(String str, String str2);

    void onRefreshRecordingServiceStatus(int i);

    void onRejoinChannelSuccess(String str, String str2, int i);

    void onRemoteVideoStat(String str, int i, int i2, int i3);

    void onRtcStats();

    void onUserJoined(String str, int i);

    void onUserMuteAudio(String str, boolean z);

    void onUserMuteVideo(String str, boolean z);

    void onUserOffline(String str, int i);

    void onVendorMessage(String str, byte[] bArr);

    void onVideoStopped();

    void onWarning(int i);

    void onWhiteBoardURL(String str);
}
