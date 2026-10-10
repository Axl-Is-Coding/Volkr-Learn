package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: compiled from: FingerprintManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
class a extends FingerprintManager.AuthenticationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FingerprintManagerCompat.a f1184a;

    a(FingerprintManagerCompat.a aVar) {
        this.f1184a = aVar;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        this.f1184a.a(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        this.f1184a.a();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        this.f1184a.b(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        this.f1184a.a(new FingerprintManagerCompat.b(FingerprintManagerCompat.a(authenticationResult.getCryptoObject())));
    }
}
