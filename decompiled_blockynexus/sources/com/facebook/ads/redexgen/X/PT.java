package com.facebook.ads.redexgen.X;

import android.widget.MediaController;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class PT implements MediaController.MediaPlayerControl {
    public static String[] A01;
    public final /* synthetic */ G2 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"T46fCpiGc88W2sm67KitVw29EyPc3", "CnzVRlVQiaWVzZBS", "ndpW2a6BPo0GfPTTlqn3VUL3zbZB353", "6dBvfVqLyh6nhF4N5m", "imXeYKfRY50epxOYIoCDJpdee5DGPOn9", "a2YCts1Ck8i", "mjIxnllGj7l0AybsaVU42LegCoMqgA9", "OPSSIwvLFtyh4B3JmayX8W92hCUnvGiN"};
    }

    public PT(G2 g2) {
        this.A00 = g2;
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
        if (this.A00.A0C != null) {
            return this.A00.A0C.A05();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.A00.A0C != null) {
            return this.A00.A0C.A06();
        }
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
        return this.A00.A0C != null && this.A00.A0C.A0K();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        if (this.A00.A0F != null) {
            InterfaceC1847Pc interfaceC1847Pc = this.A00.A0F;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "BHfWGVDMvGTMo8ZI3A6S5KtrLH6Ee";
            strArr2[3] = "BHfWGVDMvGTMo8ZI3A6S5KtrLH6Ee";
            interfaceC1847Pc.AAQ();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        this.A00.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (this.A00.A0F != null) {
            this.A00.A0F.AAR();
        }
    }
}
