package com.alibaba.sdk.android.feedback.util;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
class b implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3709a;

    b(a aVar) {
        this.f3709a = aVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f3709a.f3701c.start();
    }
}
