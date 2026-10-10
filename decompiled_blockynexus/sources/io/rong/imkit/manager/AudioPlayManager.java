package io.rong.imkit.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class AudioPlayManager implements SensorEventListener {
    private static final String TAG = "AudioPlayManager";
    private IAudioPlayListener _playListener;
    private PowerManager _powerManager;
    private Sensor _sensor;
    private SensorManager _sensorManager;
    private PowerManager.WakeLock _wakeLock;
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
    private Handler handler;
    private boolean isVOIPMode;
    private AudioManager mAudioManager;
    private Context mContext;
    private final Object mLock;
    private MediaPlayer mMediaPlayer;
    private Uri mUriPlaying;

    static class SingletonHolder {
        static AudioPlayManager sInstance = new AudioPlayManager();

        SingletonHolder() {
        }
    }

    public static AudioPlayManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private boolean isHeadphonesPlugged(AudioManager audioManager) {
        int i;
        synchronized (this.mLock) {
            if (audioManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 23) {
                return audioManager.isWiredHeadsetOn();
            }
            AudioDeviceInfo[] devices = audioManager.getDevices(3);
            int length = devices.length;
            while (i < length) {
                AudioDeviceInfo audioDeviceInfo = devices[i];
                i = (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) ? 0 : i + 1;
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean judgeCondition(android.hardware.SensorEvent r5, float r6, double r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "HUAWEI"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L3c
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1c
            android.hardware.Sensor r5 = r5.sensor     // Catch: java.lang.Throwable -> L3c
            float r5 = r5.getMaximumRange()     // Catch: java.lang.Throwable -> L3c
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 < 0) goto L1a
            goto L3a
        L1a:
            r2 = 0
            goto L3a
        L1c:
            java.lang.String r5 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "ZTE"
            boolean r5 = r5.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L29
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L35
        L29:
            java.lang.String r5 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "nubia"
            boolean r5 = r5.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L35
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
        L35:
            double r5 = (double) r6     // Catch: java.lang.Throwable -> L3c
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L1a
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            return r2
        L3c:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            goto L40
        L3f:
            throw r5
        L40:
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.manager.AudioPlayManager.judgeCondition(android.hardware.SensorEvent, float, double):boolean");
    }

    @TargetApi(8)
    private void muteAudioFocus(AudioManager audioManager, boolean z) {
        synchronized (this.mLock) {
            try {
                if (audioManager == null) {
                    return;
                }
                if (z) {
                    audioManager.requestAudioFocus(this.afChangeListener, 3, 2);
                } else {
                    audioManager.abandonAudioFocus(this.afChangeListener);
                    this.afChangeListener = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void replay() {
        String str;
        String str2;
        FileInputStream fileInputStream;
        synchronized (this.mLock) {
            if (this.mMediaPlayer == null) {
                return;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    this.mMediaPlayer.reset();
                    if (Build.BRAND.equals("samsung") && Build.MODEL.equals("SM-N9200")) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(2).build());
                        } else {
                            this.mMediaPlayer.setAudioStreamType(0);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
                    } else {
                        this.mMediaPlayer.setAudioStreamType(3);
                    }
                    this.mMediaPlayer.setVolume(1.0f, 1.0f);
                    fileInputStream = new FileInputStream(this.mUriPlaying.getPath());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                this.mMediaPlayer.setDataSource(fileInputStream.getFD());
                this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: io.rong.imkit.manager.AudioPlayManager.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e3) {
                            RLog.e(AudioPlayManager.TAG, "replay", e3);
                            Thread.currentThread().interrupt();
                        }
                        mediaPlayer.start();
                    }
                });
                this.mMediaPlayer.prepareAsync();
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    str = TAG;
                    str2 = "replay";
                    RLog.e(str, str2, e);
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                RLog.e(TAG, "replay", e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e = e5;
                        str = TAG;
                        str2 = "replay";
                        RLog.e(str, str2, e);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        RLog.e(TAG, "replay", e6);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        resetMediaPlayer();
        resetAudioPlayManager();
    }

    private void resetAudioPlayManager() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setMode(0);
            muteAudioFocus(this.mAudioManager, false);
        }
        if (this._sensorManager != null) {
            setScreenOn();
            this._sensorManager.unregisterListener(this);
        }
        this._sensorManager = null;
        this._sensor = null;
        this._powerManager = null;
        this.mAudioManager = null;
        this._wakeLock = null;
        this.mUriPlaying = null;
        this._playListener = null;
    }

    private void resetMediaPlayer() {
        synchronized (this.mLock) {
            if (this.mMediaPlayer != null) {
                try {
                    this.mMediaPlayer.stop();
                    this.mMediaPlayer.reset();
                    this.mMediaPlayer.release();
                    this.mMediaPlayer = null;
                } catch (IllegalStateException e2) {
                    RLog.e(TAG, "resetMediaPlayer", e2);
                }
            }
        }
    }

    @TargetApi(21)
    private void setScreenOff() {
        synchronized (this.mLock) {
            if (this._wakeLock == null && this._powerManager != null) {
                this._wakeLock = this._powerManager.newWakeLock(32, "AudioPlayManager:wakelockTag");
            }
            if (this._wakeLock != null && !this._wakeLock.isHeld()) {
                this._wakeLock.acquire(600000L);
            }
        }
    }

    private void setScreenOn() {
        synchronized (this.mLock) {
            if (this._wakeLock != null && this._wakeLock.isHeld()) {
                this._wakeLock.setReferenceCounted(false);
                this._wakeLock.release();
                this._wakeLock = null;
            }
        }
    }

    public Uri getPlayingUri() {
        Uri uri;
        synchronized (this.mLock) {
            uri = this.mUriPlaying != null ? this.mUriPlaying : Uri.EMPTY;
        }
        return uri;
    }

    public boolean isInNormalMode(Context context) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) context.getApplicationContext().getSystemService(LibStorageUtils.AUDIO);
            }
            z = this.mAudioManager != null && this.mAudioManager.getMode() == 0;
        }
        return z;
    }

    public boolean isInVOIPMode(Context context) {
        return this.isVOIPMode;
    }

    public boolean isPlaying() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mMediaPlayer != null && this.mMediaPlayer.isPlaying();
        }
        return z;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @TargetApi(11)
    public void onSensorChanged(SensorEvent sensorEvent) {
        String str;
        String str2;
        FileInputStream fileInputStream;
        synchronized (this.mLock) {
            float f2 = sensorEvent.values[0];
            RLog.d(TAG, "onSensorChanged. range:" + f2 + "; max range:" + sensorEvent.sensor.getMaximumRange());
            if (this._sensor != null && this.mMediaPlayer != null && this.mAudioManager != null) {
                boolean zJudgeCondition = judgeCondition(sensorEvent, f2, 0.0d);
                if (this.mMediaPlayer.isPlaying()) {
                    FileInputStream fileInputStream2 = null;
                    if (!zJudgeCondition) {
                        if (!Build.BRAND.equals("samsung") || !Build.MODEL.equals("SM-N9200")) {
                            setScreenOff();
                        }
                        if (Build.VERSION.SDK_INT >= 11) {
                            if (this.mAudioManager.getMode() == 3) {
                                return;
                            } else {
                                this.mAudioManager.setMode(3);
                            }
                        } else if (this.mAudioManager.getMode() == 2) {
                            return;
                        } else {
                            this.mAudioManager.setMode(2);
                        }
                        this.mAudioManager.setSpeakerphoneOn(false);
                        replay();
                    } else {
                        if (this.mAudioManager.getMode() == 0) {
                            return;
                        }
                        this.mAudioManager.setMode(0);
                        this.mAudioManager.setSpeakerphoneOn(true);
                        final int currentPosition = this.mMediaPlayer.getCurrentPosition();
                        try {
                            try {
                                this.mMediaPlayer.reset();
                                if (Build.VERSION.SDK_INT >= 21) {
                                    this.mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
                                } else {
                                    this.mMediaPlayer.setAudioStreamType(3);
                                }
                                this.mMediaPlayer.setVolume(1.0f, 1.0f);
                                fileInputStream = new FileInputStream(this.mUriPlaying.getPath());
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                        }
                        try {
                            this.mMediaPlayer.setDataSource(fileInputStream.getFD());
                            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: io.rong.imkit.manager.AudioPlayManager.1
                                @Override // android.media.MediaPlayer.OnPreparedListener
                                public void onPrepared(MediaPlayer mediaPlayer) {
                                    mediaPlayer.seekTo(currentPosition);
                                }
                            });
                            this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: io.rong.imkit.manager.AudioPlayManager.2
                                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                                public void onSeekComplete(MediaPlayer mediaPlayer) {
                                    mediaPlayer.start();
                                }
                            });
                            this.mMediaPlayer.prepareAsync();
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e = e3;
                                str = TAG;
                                str2 = "startPlay";
                                RLog.e(str, str2, e);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            fileInputStream2 = fileInputStream;
                            RLog.e(TAG, "onSensorChanged", e);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    str = TAG;
                                    str2 = "startPlay";
                                    RLog.e(str, str2, e);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    RLog.e(TAG, "startPlay", e6);
                                }
                            }
                            throw th;
                        }
                        setScreenOn();
                    }
                } else if (f2 > 0.0d) {
                    if (this.mAudioManager.getMode() == 0) {
                        return;
                    }
                    this.mAudioManager.setMode(0);
                    this.mAudioManager.setSpeakerphoneOn(true);
                    setScreenOn();
                }
            }
        }
    }

    public void setInVoipMode(boolean z) {
        this.isVOIPMode = z;
    }

    public void setPlayListener(IAudioPlayListener iAudioPlayListener) {
        synchronized (this.mLock) {
            this._playListener = iAudioPlayListener;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startPlay(final android.content.Context r7, android.net.Uri r8, io.rong.imkit.manager.IAudioPlayListener r9) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.manager.AudioPlayManager.startPlay(android.content.Context, android.net.Uri, io.rong.imkit.manager.IAudioPlayListener):void");
    }

    public void stopPlay() {
        synchronized (this.mLock) {
            if (this.mContext != null) {
                ((Activity) this.mContext).getWindow().clearFlags(128);
            }
            if (this._playListener != null && this.mUriPlaying != null) {
                this._playListener.onStop(this.mUriPlaying);
            }
            reset();
        }
    }

    private AudioPlayManager() {
        this.mLock = new Object();
        this.isVOIPMode = false;
        this.handler = new Handler(Looper.getMainLooper());
    }
}
