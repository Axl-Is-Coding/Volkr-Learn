package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;

/* JADX INFO: loaded from: classes5.dex */
public class VideoView extends SurfaceView implements VideoControlView.a {
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private String TAG;
    private GestureDetector gestureDetector;
    private int mAudioSession;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private MediaPlayer.OnErrorListener mErrorListener;
    private MediaPlayer.OnInfoListener mInfoListener;
    private boolean mLooping;
    private VideoControlView mMediaController;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    MediaPlayer.OnPreparedListener mPreparedListener;
    SurfaceHolder.Callback mSHCallback;
    private int mSeekWhenPrepared;
    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public VideoView(Context context) {
        super(context);
        this.TAG = "VideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new o(this);
        this.mPreparedListener = new p(this);
        this.mCompletionListener = new q(this);
        this.mInfoListener = new r(this);
        this.mErrorListener = new s(this);
        this.mBufferingUpdateListener = new t(this);
        this.gestureDetector = new GestureDetector(getContext(), new u(this));
        this.mSHCallback = new v(this);
        initVideoView();
    }

    private void attachMediaController() {
        VideoControlView videoControlView;
        if (this.mMediaPlayer == null || (videoControlView = this.mMediaController) == null) {
            return;
        }
        videoControlView.setMediaPlayer(this);
        this.mMediaController.setEnabled(isInPlaybackState());
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == -1 || i == 0 || i == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        if (this.mUri == null || this.mSurfaceHolder == null) {
            return;
        }
        release(false);
        try {
            this.mMediaPlayer = new MediaPlayer();
            if (this.mAudioSession != 0) {
                this.mMediaPlayer.setAudioSessionId(this.mAudioSession);
            } else {
                this.mAudioSession = this.mMediaPlayer.getAudioSessionId();
            }
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mCurrentBufferPercentage = 0;
            this.mMediaPlayer.setLooping(this.mLooping);
            this.mMediaPlayer.setDataSource(getContext(), this.mUri);
            this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = 1;
            attachMediaController();
        } catch (Exception e2) {
            Log.w(this.TAG, "Unable to open content: " + this.mUri, e2);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (isInPlaybackState() && z && this.mMediaController != null) {
            if (i == 79 || i == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                } else {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            }
            if (i == 126) {
                if (!this.mMediaPlayer.isPlaying()) {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            }
            if (i == 86 || i == 127) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                }
                return true;
            }
            toggleMediaControlsVisiblity();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[PHI: r6
      0x0065: PHI (r6v6 int) = (r6v5 int), (r6v3 int), (r6v3 int), (r6v3 int) binds: [B:27:0x0064, B:25:0x0061, B:19:0x0051, B:13:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.mVideoWidth
            int r0 = android.view.SurfaceView.getDefaultSize(r0, r6)
            int r1 = r5.mVideoHeight
            int r1 = android.view.SurfaceView.getDefaultSize(r1, r7)
            int r2 = r5.mVideoWidth
            if (r2 <= 0) goto L84
            int r2 = r5.mVideoHeight
            if (r2 <= 0) goto L84
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L44
            if (r1 != r2) goto L44
            int r0 = r5.mVideoWidth
            int r1 = r0 * r7
            int r2 = r5.mVideoHeight
            int r3 = r6 * r2
            if (r1 >= r3) goto L39
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L84
        L39:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L65
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L85
        L44:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L56
            int r0 = r5.mVideoHeight
            int r0 = r0 * r6
            int r2 = r5.mVideoWidth
            int r0 = r0 / r2
            if (r1 != r3) goto L54
            if (r0 <= r7) goto L54
            goto L63
        L54:
            r1 = r0
            goto L85
        L56:
            if (r1 != r2) goto L67
            int r1 = r5.mVideoWidth
            int r1 = r1 * r7
            int r2 = r5.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r3) goto L64
            if (r1 <= r6) goto L64
        L63:
            goto L65
        L64:
            r6 = r1
        L65:
            r1 = r7
            goto L85
        L67:
            int r2 = r5.mVideoWidth
            int r4 = r5.mVideoHeight
            if (r1 != r3) goto L74
            if (r4 <= r7) goto L74
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L75
        L74:
            r1 = r4
        L75:
            if (r0 != r3) goto L82
            if (r2 <= r6) goto L82
            int r7 = r5.mVideoHeight
            int r7 = r7 * r6
            int r0 = r5.mVideoWidth
            int r1 = r7 / r0
            goto L85
        L82:
            r6 = r2
            goto L85
        L84:
            r6 = r0
        L85:
            r5.setMeasuredDimension(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.VideoView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public void seekTo(int i) {
        if (!isInPlaybackState()) {
            this.mSeekWhenPrepared = i;
        } else {
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
        }
    }

    public void setMediaController(VideoControlView videoControlView) {
        VideoControlView videoControlView2 = this.mMediaController;
        if (videoControlView2 != null) {
            videoControlView2.hide();
        }
        this.mMediaController = videoControlView;
        attachMediaController();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setVideoURI(Uri uri, boolean z) {
        this.mUri = uri;
        this.mLooping = z;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    @Override // com.twitter.sdk.android.tweetui.internal.VideoControlView.a
    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "VideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mSizeChangedListener = new o(this);
        this.mPreparedListener = new p(this);
        this.mCompletionListener = new q(this);
        this.mInfoListener = new r(this);
        this.mErrorListener = new s(this);
        this.mBufferingUpdateListener = new t(this);
        this.gestureDetector = new GestureDetector(getContext(), new u(this));
        this.mSHCallback = new v(this);
        initVideoView();
    }
}
