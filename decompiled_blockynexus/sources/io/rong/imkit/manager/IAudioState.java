package io.rong.imkit.manager;

/* JADX INFO: loaded from: classes5.dex */
abstract class IAudioState {
    IAudioState() {
    }

    void enter() {
    }

    abstract void handleMessage(AudioStateMessage audioStateMessage);
}
