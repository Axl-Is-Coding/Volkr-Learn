package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.R;

/* JADX INFO: loaded from: classes5.dex */
public class VideoControlView extends FrameLayout {
    static final int FADE_DURATION_MS = 150;
    static final long PROGRESS_BAR_TICKS = 1000;
    private static final int SHOW_PROGRESS_MSG = 1001;
    TextView currentTime;
    TextView duration;

    @SuppressLint({"HandlerLeak"})
    private final Handler handler;
    a player;
    SeekBar seekBar;
    ImageButton stateControl;

    public interface a {
        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        boolean isPlaying();

        void pause();

        void seekTo(int i);

        void start();
    }

    public VideoControlView(Context context) {
        super(context);
        this.handler = new m(this);
    }

    public /* synthetic */ void a(View view) {
        if (this.player.isPlaying()) {
            this.player.pause();
        } else {
            this.player.start();
        }
        show();
    }

    SeekBar.OnSeekBarChangeListener createProgressChangeListener() {
        return new n(this);
    }

    View.OnClickListener createStateControlClickListener() {
        return new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.internal.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20409a.a(view);
            }
        };
    }

    void hide() {
        this.handler.removeMessages(1001);
        f.b(this, 150);
    }

    void initSubviews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.tw__video_control, this);
        this.stateControl = (ImageButton) findViewById(R.id.tw__state_control);
        this.currentTime = (TextView) findViewById(R.id.tw__current_time);
        this.duration = (TextView) findViewById(R.id.tw__duration);
        this.seekBar = (SeekBar) findViewById(R.id.tw__progress);
        this.seekBar.setMax(1000);
        this.seekBar.setOnSeekBarChangeListener(createProgressChangeListener());
        this.stateControl.setOnClickListener(createStateControlClickListener());
        setDuration(0);
        setCurrentTime(0);
        setProgress(0, 0, 0);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initSubviews();
    }

    void setCurrentTime(int i) {
        this.currentTime.setText(h.a(i));
    }

    void setDuration(int i) {
        this.duration.setText(h.a(i));
    }

    public void setMediaPlayer(a aVar) {
        this.player = aVar;
    }

    void setPauseDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_pause_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__pause));
    }

    void setPlayDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_play_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__play));
    }

    void setProgress(int i, int i2, int i3) {
        this.seekBar.setProgress((int) (i2 > 0 ? (((long) i) * 1000) / ((long) i2) : 0L));
        this.seekBar.setSecondaryProgress(i3 * 10);
    }

    void setReplayDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_replay_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__replay));
    }

    void show() {
        this.handler.sendEmptyMessage(1001);
        f.a(this, 150);
    }

    public void update() {
        this.handler.sendEmptyMessage(1001);
    }

    void updateProgress() {
        int duration = this.player.getDuration();
        int currentPosition = this.player.getCurrentPosition();
        int bufferPercentage = this.player.getBufferPercentage();
        setDuration(duration);
        setCurrentTime(currentPosition);
        setProgress(currentPosition, duration, bufferPercentage);
    }

    void updateStateControl() {
        if (this.player.isPlaying()) {
            setPauseDrawable();
        } else if (this.player.getCurrentPosition() > Math.max(this.player.getDuration() - 500, 0)) {
            setReplayDrawable();
        } else {
            setPlayDrawable();
        }
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new m(this);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new m(this);
    }
}
