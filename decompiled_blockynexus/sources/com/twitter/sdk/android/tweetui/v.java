package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

/* JADX INFO: compiled from: PlayerController.java */
/* JADX INFO: loaded from: classes5.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final VideoView f20457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final VideoControlView f20458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ProgressBar f20459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TextView f20460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final View f20461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f20462f;
    boolean g = true;
    final SwipeToDismissTouchListener.a h;

    v(View view, SwipeToDismissTouchListener.a aVar) {
        this.f20461e = view;
        this.f20457a = (VideoView) view.findViewById(R.id.video_view);
        this.f20458b = (VideoControlView) view.findViewById(R.id.video_control_view);
        this.f20459c = (ProgressBar) view.findViewById(R.id.video_progress_view);
        this.f20460d = (TextView) view.findViewById(R.id.call_to_action_view);
        this.h = aVar;
    }

    void a(PlayerActivity.PlayerItem playerItem) {
        try {
            b(playerItem);
            a(playerItem.looping, playerItem.showVideoControls);
            this.f20457a.setOnTouchListener(SwipeToDismissTouchListener.a(this.f20457a, this.h));
            this.f20457a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.twitter.sdk.android.tweetui.e
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    this.f20370a.a(mediaPlayer);
                }
            });
            this.f20457a.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.twitter.sdk.android.tweetui.g
                @Override // android.media.MediaPlayer.OnInfoListener
                public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    return this.f20372a.a(mediaPlayer, i, i2);
                }
            });
            this.f20457a.setVideoURI(Uri.parse(playerItem.url), playerItem.looping);
            this.f20457a.requestFocus();
        } catch (Exception e2) {
            com.twitter.sdk.android.core.n.e().e("PlayerController", "Error occurred during video playback", e2);
        }
    }

    void b() {
        this.g = this.f20457a.isPlaying();
        this.f20462f = this.f20457a.getCurrentPosition();
        this.f20457a.pause();
    }

    void c() {
        int i = this.f20462f;
        if (i != 0) {
            this.f20457a.seekTo(i);
        }
        if (this.g) {
            this.f20457a.start();
            this.f20458b.update();
        }
    }

    void d() {
        this.f20458b.setVisibility(4);
        this.f20457a.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20373a.a(view);
            }
        });
    }

    void e() {
        this.f20457a.setMediaController(this.f20458b);
    }

    void f() {
        this.f20461e.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20371a.b(view);
            }
        });
    }

    void b(PlayerActivity.PlayerItem playerItem) {
        if (playerItem.callToActionText == null || playerItem.callToActionUrl == null) {
            return;
        }
        this.f20460d.setVisibility(0);
        this.f20460d.setText(playerItem.callToActionText);
        a(playerItem.callToActionUrl);
        f();
    }

    public /* synthetic */ void b(View view) {
        if (this.f20460d.getVisibility() == 0) {
            this.f20460d.setVisibility(8);
        } else {
            this.f20460d.setVisibility(0);
        }
    }

    public /* synthetic */ void a(MediaPlayer mediaPlayer) {
        this.f20459c.setVisibility(8);
    }

    public /* synthetic */ boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 702) {
            this.f20459c.setVisibility(8);
            return true;
        }
        if (i != 701) {
            return false;
        }
        this.f20459c.setVisibility(0);
        return true;
    }

    void a() {
        this.f20457a.stopPlayback();
    }

    void a(boolean z, boolean z2) {
        if (z && !z2) {
            d();
        } else {
            e();
        }
    }

    public /* synthetic */ void a(View view) {
        if (this.f20457a.isPlaying()) {
            this.f20457a.pause();
        } else {
            this.f20457a.start();
        }
    }

    void a(final String str) {
        this.f20460d.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20368a.a(str, view);
            }
        });
    }

    public /* synthetic */ void a(String str, View view) {
        com.twitter.sdk.android.core.h.b(this.f20460d.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
