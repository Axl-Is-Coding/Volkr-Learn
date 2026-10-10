package com.alibaba.sdk.android.feedback.xblink.g;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

/* JADX INFO: loaded from: classes.dex */
class c implements HandshakeCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3878a;

    c(b bVar) {
        this.f3878a = bVar;
    }

    @Override // javax.net.ssl.HandshakeCompletedListener
    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        g.a("tag", "Handshake finished!");
        g.a("tag", "\t CipherSuite:" + handshakeCompletedEvent.getCipherSuite());
        g.a("tag", "\t SessionId " + handshakeCompletedEvent.getSession());
        g.a("tag", "\t PeerHost " + handshakeCompletedEvent.getSession().getPeerHost());
    }
}
