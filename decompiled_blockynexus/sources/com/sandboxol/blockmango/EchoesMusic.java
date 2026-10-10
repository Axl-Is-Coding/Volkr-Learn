package com.sandboxol.blockmango;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesMusic implements MediaPlayer.OnCompletionListener {
    private static final String TAG = "EchoesMusic";
    private MediaPlayer mBackgroundMediaPlayer;
    private final Context mContext;
    private String mCurrentPath;
    private double mInterval;
    private float mLeftVolume;
    private boolean mPaused;
    private float mRightVolume;
    private Timer mTimer;

    public EchoesMusic(Context context) {
        this.mContext = context;
        initData();
    }

    private MediaPlayer createMediaplayer(String str) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            if (str.startsWith("/")) {
                FileInputStream fileInputStream = new FileInputStream(str);
                mediaPlayer.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
            } else {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.mContext.getAssets().openFd(str);
                mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            }
            mediaPlayer.prepare();
            mediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
            return mediaPlayer;
        } catch (Exception e2) {
            Log.e(TAG, "error: " + e2.getMessage(), e2);
            return null;
        }
    }

    private void initData() {
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
        this.mBackgroundMediaPlayer = null;
        this.mPaused = false;
        this.mCurrentPath = null;
    }

    public void end() {
        try {
            if (this.mBackgroundMediaPlayer != null) {
                this.mBackgroundMediaPlayer.release();
            }
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
            initData();
            Log.e("EchoesMusic", "EchoesMusic end");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public float getBackgroundVolume() {
        return this.mBackgroundMediaPlayer != null ? (this.mLeftVolume + this.mRightVolume) / 2.0f : WheelView.DividerConfig.FILL;
    }

    public boolean isBackgroundMusicPlaying() {
        try {
            if (this.mBackgroundMediaPlayer == null) {
                return false;
            }
            return this.mBackgroundMediaPlayer.isPlaying();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(final MediaPlayer mediaPlayer) {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.sandboxol.blockmango.EchoesMusic.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (mediaPlayer == null || mediaPlayer.isPlaying()) {
                        return;
                    }
                    mediaPlayer.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }, (int) (this.mInterval * 1000.0d));
    }

    public void onDestroy() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public void pauseBackgroundMusic() {
        try {
            if (this.mBackgroundMediaPlayer == null || !this.mBackgroundMediaPlayer.isPlaying()) {
                return;
            }
            this.mBackgroundMediaPlayer.pause();
            this.mPaused = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void playBackgroundMusic(String str, boolean z, float f2, float f3) {
        MediaPlayer mediaPlayer;
        String str2 = this.mCurrentPath;
        if (str2 == null) {
            this.mBackgroundMediaPlayer = createMediaplayer(str);
            this.mCurrentPath = str;
        } else if (!str2.equals(str)) {
            MediaPlayer mediaPlayer2 = this.mBackgroundMediaPlayer;
            if (mediaPlayer2 != null) {
                try {
                    mediaPlayer2.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mBackgroundMediaPlayer = createMediaplayer(str);
            this.mCurrentPath = str;
        }
        MediaPlayer mediaPlayer3 = this.mBackgroundMediaPlayer;
        if (mediaPlayer3 == null) {
            Log.e(TAG, "playBackgroundMusic: background media player is null");
            return;
        }
        try {
            try {
                try {
                    if (mediaPlayer3.isPlaying()) {
                        this.mBackgroundMediaPlayer.stop();
                    }
                    mediaPlayer = this.mBackgroundMediaPlayer;
                } catch (Exception unused) {
                    Log.e(TAG, "playBackgroundMusic: isPlaying or stop error");
                    mediaPlayer = this.mBackgroundMediaPlayer;
                }
                mediaPlayer.prepare();
            } catch (Exception unused2) {
                Log.e(TAG, "playBackgroundMusic: prepare error");
            }
            this.mBackgroundMediaPlayer.setLooping(false);
            try {
                this.mBackgroundMediaPlayer.seekTo(0);
                this.mBackgroundMediaPlayer.start();
                if (z) {
                    this.mBackgroundMediaPlayer.setOnCompletionListener(this);
                }
                this.mPaused = false;
            } catch (Exception unused3) {
                Log.e(TAG, "playBackgroundMusic: error state");
            }
        } catch (Throwable th) {
            try {
                this.mBackgroundMediaPlayer.prepare();
            } catch (Exception unused4) {
                Log.e(TAG, "playBackgroundMusic: prepare error");
            }
            throw th;
        }
    }

    public void preloadBackgroundMusic(String str) {
        try {
            if (this.mCurrentPath == null || !this.mCurrentPath.equals(str)) {
                if (this.mBackgroundMediaPlayer != null) {
                    this.mBackgroundMediaPlayer.release();
                }
                this.mBackgroundMediaPlayer = createMediaplayer(str);
                this.mCurrentPath = str;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resumeBackgroundMusic() {
        try {
            if (this.mBackgroundMediaPlayer == null || !this.mPaused) {
                return;
            }
            this.mBackgroundMediaPlayer.start();
            this.mPaused = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void rewindBackgroundMusic() {
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mBackgroundMediaPlayer.prepare();
                this.mBackgroundMediaPlayer.seekTo(0);
                this.mBackgroundMediaPlayer.start();
                this.mPaused = false;
            } catch (Exception unused) {
                Log.e(TAG, "rewindBackgroundMusic: error state");
            }
        }
    }

    public void setBackgroundVolume(float f2) {
        if (f2 < WheelView.DividerConfig.FILL) {
            f2 = WheelView.DividerConfig.FILL;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.mRightVolume = f2;
        this.mLeftVolume = f2;
        MediaPlayer mediaPlayer = this.mBackgroundMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
        }
    }

    public void stopBackgroundMusic() {
        try {
            if (this.mBackgroundMediaPlayer != null) {
                this.mBackgroundMediaPlayer.stop();
                this.mPaused = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
