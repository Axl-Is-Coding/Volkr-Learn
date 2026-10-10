package com.sandboxol.blockmango;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.game.R;

/* JADX INFO: loaded from: classes2.dex */
public class GameVideoDialog extends HideNavigationBarDialog implements MediaPlayer.OnCompletionListener, View.OnClickListener {
    private VideoView mVideoView;

    public GameVideoDialog(Context context, int i, String str) {
        super(context);
        initView(i, str);
    }

    private void initView(int i, String str) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.activity_game_video, (ViewGroup) null);
        setCanceledOnTouchOutside(true);
        setContentView(viewInflate);
        viewInflate.findViewById(R.id.btnClose).setOnClickListener(this);
        this.mVideoView = (VideoView) viewInflate.findViewById(R.id.gameVideo);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setMediaController(new MediaController(this.context));
        this.mVideoView.setVideoPath(str);
        this.mVideoView.start();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.mVideoView != null && this.mVideoView.isPlaying()) {
                this.mVideoView.stopPlayback();
            }
            super.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        cancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnClose) {
            cancel();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        cancel();
    }
}
