package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefj;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzear {
    private static final Logger logger = Logger.getLogger(zzear.class.getName());
    private static final ConcurrentMap<String, zza> zzhut = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzb> zzhuu = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzhuv = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdzy<?>> zzhuw = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzeaq<?>> zzhux = new ConcurrentHashMap();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    interface zza {
        Set<Class<?>> zzayp();

        zzeab<?> zzayy();

        Class<?> zzayz();

        Class<?> zzaza();

        <P> zzeab<P> zzb(Class<P> cls) throws GeneralSecurityException;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    interface zzb {
    }

    private zzear() {
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private static <KeyProtoT extends zzelj> zza zza(zzeag<KeyProtoT> zzeagVar) {
        return new zzeat(zzeagVar);
    }

    private static <KeyProtoT extends zzelj> zzb zzb(zzeag<KeyProtoT> zzeagVar) {
        return new zzeav(zzeagVar);
    }

    private static synchronized zza zzhm(String str) throws GeneralSecurityException {
        if (!zzhut.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "No key manager found for key type ".concat(strValueOf) : new String("No key manager found for key type "));
        }
        return zzhut.get(str);
    }

    @Deprecated
    public static zzdzy<?> zzhn(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdzy<?> zzdzyVar = zzhuw.get(str.toLowerCase());
        if (zzdzyVar != null) {
            return zzdzyVar;
        }
        String strConcat = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase().startsWith("tinkaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase().startsWith("tink")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(strConcat);
    }

    private static zzeab<?> zzho(String str) throws GeneralSecurityException {
        return zzhm(str).zzayy();
    }

    private static synchronized void zza(String str, Class<?> cls, boolean z) throws GeneralSecurityException {
        if (zzhut.containsKey(str)) {
            zza zzaVar = zzhut.get(str);
            if (zzaVar.zzayz().equals(cls)) {
                if (!z || zzhuv.get(str).booleanValue()) {
                    return;
                }
                String strValueOf = String.valueOf(str);
                throw new GeneralSecurityException(strValueOf.length() != 0 ? "New keys are already disallowed for key type ".concat(strValueOf) : new String("New keys are already disallowed for key type "));
            }
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf2 = String.valueOf(str);
            logger2.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", strValueOf2.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(strValueOf2) : new String("Attempted overwrite of a registered key manager for key type "));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzaVar.zzayz().getName(), cls.getName()));
        }
    }

    public static synchronized zzelj zzb(zzefe zzefeVar) throws GeneralSecurityException {
        zzeab<?> zzeabVarZzho;
        zzeabVarZzho = zzho(zzefeVar.zzbbt());
        if (!zzhuv.get(zzefeVar.zzbbt()).booleanValue()) {
            String strValueOf = String.valueOf(zzefeVar.zzbbt());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return zzeabVarZzho.zzn(zzefeVar.zzbbu());
    }

    public static synchronized <P> void zza(zzeab<P> zzeabVar, boolean z) throws GeneralSecurityException {
        if (zzeabVar != null) {
            String keyType = zzeabVar.getKeyType();
            zza(keyType, zzeabVar.getClass(), z);
            if (!zzhut.containsKey(keyType)) {
                zzhut.put(keyType, new zzeau(zzeabVar));
            }
            zzhuv.put(keyType, Boolean.valueOf(z));
        } else {
            throw new IllegalArgumentException("key manager must be non-null.");
        }
    }

    public static synchronized <KeyProtoT extends zzelj> void zza(zzeag<KeyProtoT> zzeagVar, boolean z) throws GeneralSecurityException {
        String keyType = zzeagVar.getKeyType();
        zza(keyType, zzeagVar.getClass(), true);
        if (!zzhut.containsKey(keyType)) {
            zzhut.put(keyType, zza(zzeagVar));
            zzhuu.put(keyType, zzb(zzeagVar));
        }
        zzhuv.put(keyType, true);
    }

    public static synchronized <KeyProtoT extends zzelj, PublicKeyProtoT extends zzelj> void zza(zzeas<KeyProtoT, PublicKeyProtoT> zzeasVar, zzeag<PublicKeyProtoT> zzeagVar, boolean z) throws GeneralSecurityException {
        Class<?> clsZzaza;
        String keyType = zzeasVar.getKeyType();
        String keyType2 = zzeagVar.getKeyType();
        zza(keyType, zzeasVar.getClass(), true);
        zza(keyType2, zzeagVar.getClass(), false);
        if (!keyType.equals(keyType2)) {
            if (zzhut.containsKey(keyType) && (clsZzaza = zzhut.get(keyType).zzaza()) != null && !clsZzaza.equals(zzeagVar.getClass())) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append(keyType);
                sb.append(" with inconsistent public key type ");
                sb.append(keyType2);
                logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzeasVar.getClass().getName(), clsZzaza.getName(), zzeagVar.getClass().getName()));
            }
            if (!zzhut.containsKey(keyType) || zzhut.get(keyType).zzaza() == null) {
                zzhut.put(keyType, new zzeaw(zzeasVar, zzeagVar));
                zzhuu.put(keyType, zzb(zzeasVar));
            }
            zzhuv.put(keyType, true);
            if (!zzhut.containsKey(keyType2)) {
                zzhut.put(keyType2, zza(zzeagVar));
            }
            zzhuv.put(keyType2, false);
        } else {
            throw new GeneralSecurityException("Private and public key type must be different.");
        }
    }

    public static synchronized <P> void zza(zzeaq<P> zzeaqVar) throws GeneralSecurityException {
        if (zzeaqVar != null) {
            Class<P> clsZzayk = zzeaqVar.zzayk();
            if (zzhux.containsKey(clsZzayk)) {
                zzeaq<?> zzeaqVar2 = zzhux.get(clsZzayk);
                if (!zzeaqVar.getClass().equals(zzeaqVar2.getClass())) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(clsZzayk.toString());
                    logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", strValueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(strValueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clsZzayk.getName(), zzeaqVar2.getClass().getName(), zzeaqVar.getClass().getName()));
                }
            }
            zzhux.put(clsZzayk, zzeaqVar);
        } else {
            throw new IllegalArgumentException("wrapper must be non-null");
        }
    }

    private static <P> zzeab<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zza zzaVarZzhm = zzhm(str);
        if (cls == null) {
            return (zzeab<P>) zzaVarZzhm.zzayy();
        }
        if (zzaVarZzhm.zzayp().contains(cls)) {
            return zzaVarZzhm.zzb(cls);
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzaVarZzhm.zzayz());
        Set<Class<?>> setZzayp = zzaVarZzhm.zzayp();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : setZzayp) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(strValueOf).length() + String.valueOf(string).length());
        sb2.append("Primitive type ");
        sb2.append(name);
        sb2.append(" not supported by key manager of type ");
        sb2.append(strValueOf);
        sb2.append(", supported primitives: ");
        sb2.append(string);
        throw new GeneralSecurityException(sb2.toString());
    }

    public static synchronized zzefb zza(zzefe zzefeVar) throws GeneralSecurityException {
        zzeab<?> zzeabVarZzho;
        zzeabVarZzho = zzho(zzefeVar.zzbbt());
        if (!zzhuv.get(zzefeVar.zzbbt()).booleanValue()) {
            String strValueOf = String.valueOf(zzefeVar.zzbbt());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return zzeabVarZzho.zzo(zzefeVar.zzbbu());
    }

    public static <P> P zza(String str, zzelj zzeljVar, Class<P> cls) throws GeneralSecurityException {
        checkNotNull(cls);
        return (P) zza(str, cls).zza(zzeljVar);
    }

    private static <P> P zza(String str, zzeip zzeipVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zza(str, cls).zzm(zzeipVar);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        zzeip zzeipVarZzu = zzeip.zzu(bArr);
        checkNotNull(cls);
        return (P) zza(str, zzeipVarZzu, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzeao<P> zza(zzeah zzeahVar, zzeab<P> zzeabVar, Class<P> cls) throws GeneralSecurityException {
        checkNotNull(cls);
        Class<P> cls2 = cls;
        zzeay.zzc(zzeahVar.zzays());
        zzeao<P> zzeaoVar = (zzeao<P>) zzeao.zza(cls2);
        for (zzefj.zzb zzbVar : zzeahVar.zzays().zzbch()) {
            if (zzbVar.zzayu() == zzefc.ENABLED) {
                zzean zzeanVarZza = zzeaoVar.zza(zza(zzbVar.zzbcl().zzbbt(), zzbVar.zzbcl().zzbbu(), cls2), zzbVar);
                if (zzbVar.zzbcm() == zzeahVar.zzays().zzbcg()) {
                    zzeaoVar.zza(zzeanVarZza);
                }
            }
        }
        return zzeaoVar;
    }

    public static <P> P zza(zzeao<P> zzeaoVar) throws GeneralSecurityException {
        zzeaq<?> zzeaqVar = zzhux.get(zzeaoVar.zzayk());
        if (zzeaqVar == null) {
            String strValueOf = String.valueOf(zzeaoVar.zzayk().getName());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "No wrapper found for ".concat(strValueOf) : new String("No wrapper found for "));
        }
        return (P) zzeaqVar.zza(zzeaoVar);
    }
}
