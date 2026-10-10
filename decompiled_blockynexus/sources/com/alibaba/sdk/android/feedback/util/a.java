package com.alibaba.sdk.android.feedback.util;

import android.media.MediaPlayer;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3699a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPlayer f3701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3703e = f3699a;

    public void a() {
        MediaPlayer mediaPlayer = this.f3701c;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f3701c.release();
            this.f3701c = null;
            this.f3702d = null;
        }
    }

    public void a(String str, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.f3701c == null) {
            this.f3701c = new MediaPlayer();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.f3702d)) {
            MediaPlayer mediaPlayer = this.f3701c;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                return;
            }
            return;
        }
        this.f3701c.reset();
        try {
            this.f3701c.setDataSource(str);
            if (this.f3703e != f3699a) {
                this.f3701c.setAudioStreamType(this.f3703e);
            }
            this.f3701c.setOnCompletionListener(onCompletionListener);
            this.f3701c.prepareAsync();
            this.f3701c.setOnPreparedListener(new b(this));
        } catch (IOException e2) {
            this.f3701c = null;
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            this.f3701c = null;
            e3.printStackTrace();
        } catch (IllegalStateException e4) {
            this.f3701c = null;
            e4.printStackTrace();
        }
        this.f3702d = str;
    }

    public boolean b() {
        MediaPlayer mediaPlayer = this.f3701c;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }
}
