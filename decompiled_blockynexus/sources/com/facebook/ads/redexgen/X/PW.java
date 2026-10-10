package com.facebook.ads.redexgen.X;

import android.widget.MediaController;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class PW implements MediaController.MediaPlayerControl {
    public static String[] A01;
    public final /* synthetic */ G1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"hSLXxwS3ED2PXa4HWxT5O8AkoZWeLCaL", "Gmogcdio2x0gXeHeLgUduGgoR45wUaaW", "srtP07DjK9aYu1B8NyoR8EE0J7RhN7X5", "MH7", "NBYiw3cvWUp2yNoHdye4I6uBFIshebL3", "osH0FOpWNHuyeeWL1EivPIw0cJCzEheb", "y4KJdcSo65PTSQflVKQ3KiIVJaTfePYu", "FLJEaU0xa"};
    }

    public PW(G1 g1) {
        this.A00 = g1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        if (this.A00.A06 != null) {
            return this.A00.A06.getAudioSessionId();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.A00.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.A00.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        if (this.A00.A06 != null) {
            G1 g1 = this.A00;
            if (A01[3].length() == 27) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "lkPRs4KbLtabABAzVL2ijXaoS745wM0q";
            strArr[1] = "lkPRs4KbLtabABAzVL2ijXaoS745wM0q";
            if (g1.A06.isPlaying()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        if (this.A00.A0E != null) {
            this.A00.A0E.AAQ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        this.A00.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (this.A00.A0E != null) {
            this.A00.A0E.AAR();
        }
    }
}
