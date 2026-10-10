package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehe;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzehb<T_WRAPPER extends zzehe<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzehb.class.getName());
    private static final List<Provider> zzicw;
    public static final zzehb<zzehd, Cipher> zzicx;
    public static final zzehb<zzehh, Mac> zzicy;
    private static final zzehb<zzehj, Signature> zzicz;
    private static final zzehb<zzehk, MessageDigest> zzida;
    public static final zzehb<zzehg, KeyAgreement> zzidb;
    public static final zzehb<zzehi, KeyPairGenerator> zzidc;
    public static final zzehb<zzehf, KeyFactory> zzidd;
    private T_WRAPPER zzide;
    private List<Provider> zzidf = zzicw;
    private boolean zzidg = true;

    static {
        if (zzehu.zzbdt()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            zzicw = arrayList;
        } else {
            zzicw = new ArrayList();
        }
        zzicx = new zzehb<>(new zzehd());
        zzicy = new zzehb<>(new zzehh());
        zzicz = new zzehb<>(new zzehj());
        zzida = new zzehb<>(new zzehk());
        zzidb = new zzehb<>(new zzehg());
        zzidc = new zzehb<>(new zzehi());
        zzidd = new zzehb<>(new zzehf());
    }

    private zzehb(T_WRAPPER t_wrapper) {
        this.zzide = t_wrapper;
    }

    public final T_ENGINE zzhs(String str) throws GeneralSecurityException {
        Iterator<Provider> it = this.zzidf.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.zzide.zza(str, it.next());
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
            }
        }
        if (this.zzidg) {
            return (T_ENGINE) this.zzide.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
