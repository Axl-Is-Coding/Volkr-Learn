package io.rong.imlib.calllib;

import android.content.Context;
import android.view.SurfaceView;

/* JADX INFO: loaded from: classes5.dex */
public interface IRongCallEngine {
    void answerDegradeNormalUserToObserver(String str);

    int answerHostControlUserDevice(String str, int i, boolean z, boolean z2);

    int answerUpgradeObserverToNormalUser(String str, boolean z);

    int complain(String str, String str2);

    void create(Context context, String str, IRongCallEngineListener iRongCallEngineListener);

    SurfaceView createRendererView(Context context);

    void destroy();

    int disableVideo();

    int enableAudioVolumeIndication(int i, int i2);

    int enableVideo();

    String getCallId();

    int getServerRecordingStatus();

    boolean isSpeakerphoneEnabled();

    int joinChannel(String str, String str2, String str3, String str4);

    int leaveChannel();

    void monitorBluetoothHeadsetEvent(boolean z);

    void monitorConnectionEvent(boolean z);

    void monitorHeadsetEvent(boolean z);

    int muteAllRemoteAudioStreams(boolean z);

    int muteAllRemoteVideoStreams(boolean z);

    int muteLocalAudioStream(boolean z);

    int muteLocalVideoStream(boolean z);

    int muteRemoteAudioStream(String str, boolean z);

    int muteRemoteVideoStream(String str, boolean z);

    int rate(String str, int i, String str2);

    int requestNormalUser();

    int requestWhiteBoard();

    int setChannelProfile(int i);

    int setEnableSpeakerphone(boolean z);

    int setLocalRenderMode(int i);

    int setLogFile(String str);

    int setLogFilter(int i);

    int setRemoteRenderMode(String str, int i);

    int setSpeakerphoneVolume(int i);

    void setUserType(int i);

    int setVideoProfile(int i);

    void setupLocalVideo(SurfaceView surfaceView);

    void setupRemoteVideo(SurfaceView surfaceView, String str);

    int startAudioRecording(String str);

    int startEchoTest();

    int startPreview();

    int startServerRecording(String str);

    int stopAudioRecording();

    int stopEchoTest();

    int stopPreview();

    int stopServerRecording(String str);

    int switchCamera();

    void switchView(String str, String str2);
}
