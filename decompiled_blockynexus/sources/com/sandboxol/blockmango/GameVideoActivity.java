package com.sandboxol.blockmango;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.sandboxol.game.R;

/* JADX INFO: loaded from: classes2.dex */
public class GameVideoActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, View.OnClickListener {
    private VideoView mGameVideo;

    public /* synthetic */ void b(int i) {
        if ((i & 4) == 0) {
            toggleHideBar();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnClose) {
            finish();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game_video);
        toggleHideBar();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.sandboxol.blockmango.kb
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                this.f16213a.b(i);
            }
        });
        findViewById(R.id.btnClose).setOnClickListener(this);
        this.mGameVideo = (VideoView) findViewById(R.id.gameVideo);
        this.mGameVideo.setOnCompletionListener(this);
        Intent intent = getIntent();
        intent.getIntExtra("videoType", 3);
        this.mGameVideo.setVideoPath(intent.getStringExtra("videoPath"));
        this.mGameVideo.setMediaController(new MediaController(this));
        this.mGameVideo.start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mGameVideo.isPlaying()) {
            this.mGameVideo.stopPlayback();
        }
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            toggleHideBar();
        }
    }

    public void toggleHideBar() {
        if (getWindow() == null || getWindow().getDecorView() == null || Build.VERSION.SDK_INT <= 18) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
