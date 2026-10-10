package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class FingerprintManagerCompat {

    public static abstract class a {
        public abstract void a();

        public abstract void a(int i, CharSequence charSequence);

        public abstract void a(b bVar);

        public abstract void b(int i, CharSequence charSequence);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f1180a;

        public b(c cVar) {
            this.f1180a = cVar;
        }
    }

    static c a(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new c(cryptoObject.getMac());
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(a aVar) {
        return new androidx.core.hardware.fingerprint.a(aVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f1181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f1182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mac f1183c;

        public c(Signature signature) {
            this.f1181a = signature;
            this.f1182b = null;
            this.f1183c = null;
        }

        public c(Cipher cipher) {
            this.f1182b = cipher;
            this.f1181a = null;
            this.f1183c = null;
        }

        public c(Mac mac) {
            this.f1183c = mac;
            this.f1182b = null;
            this.f1181a = null;
        }
    }
}
