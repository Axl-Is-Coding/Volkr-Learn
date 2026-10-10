package b.f.d.b;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: ISNAdViewJSInterface.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f2651a;

    b(h hVar) {
        this.f2651a = hVar;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.f2651a.handleMessageFromAd(str);
    }
}
