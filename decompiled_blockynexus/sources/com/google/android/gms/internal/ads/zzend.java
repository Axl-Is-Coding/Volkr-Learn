package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzend {
    private static final boolean zzifu;
    private static final zzd zziob;
    private static final boolean zzioc;
    private static final long zziod;
    private static final long zzioe;
    private static final long zziof;
    private static final long zziog;
    private static final long zzioh;
    private static final long zzioi;
    private static final long zzioj;
    private static final long zziok;
    private static final long zziol;
    private static final long zziom;
    private static final long zzion;
    private static final long zzioo;
    private static final long zziop;
    private static final long zzioq;
    private static final int zzior;
    static final boolean zzios;
    private static final Logger logger = Logger.getLogger(zzend.class.getName());
    private static final Unsafe zzhsa = zzbja();
    private static final Class<?> zziei = zzeii.zzbea();
    private static final boolean zzinz = zzm(Long.TYPE);
    private static final boolean zzioa = zzm(Integer.TYPE);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zziov.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zze(Object obj, long j, byte b2) {
            this.zziov.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zziov.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final float zzn(Object obj, long j) {
            return this.zziov.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final double zzo(Object obj, long j) {
            return this.zziov.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final byte zzy(Object obj, long j) {
            return this.zziov.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, float f2) {
            this.zziov.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, double d2) {
            this.zziov.putDouble(obj, j, d2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static abstract class zzd {
        Unsafe zziov;

        zzd(Unsafe unsafe) {
            this.zziov = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public final void zza(Object obj, long j, long j2) {
            this.zziov.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zziov.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b2);

        public final int zzk(Object obj, long j) {
            return this.zziov.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zziov.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        zzd zzdVar;
        zzd zzbVar = null;
        if (zzhsa != null) {
            if (!zzeii.zzbdz()) {
                zzbVar = new zzb(zzhsa);
            } else if (zzinz) {
                zzbVar = new zzc(zzhsa);
            } else if (zzioa) {
                zzbVar = new zza(zzhsa);
            }
        }
        zziob = zzbVar;
        zzioc = zzbjc();
        zzifu = zzbjb();
        zziod = zzk(byte[].class);
        zzioe = zzk(boolean[].class);
        zziof = zzl(boolean[].class);
        zziog = zzk(int[].class);
        zzioh = zzl(int[].class);
        zzioi = zzk(long[].class);
        zzioj = zzl(long[].class);
        zziok = zzk(float[].class);
        zziol = zzl(float[].class);
        zziom = zzk(double[].class);
        zzion = zzl(double[].class);
        zzioo = zzk(Object[].class);
        zziop = zzl(Object[].class);
        Field fieldZzbjd = zzbjd();
        zzioq = (fieldZzbjd == null || (zzdVar = zziob) == null) ? -1L : zzdVar.zziov.objectFieldOffset(fieldZzbjd);
        zzior = (int) (zziod & 7);
        zzios = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzend() {
    }

    static void zza(Object obj, long j, long j2) {
        zziob.zza(obj, j, j2);
    }

    static void zzb(Object obj, long j, int i) {
        zziob.zzb(obj, j, i);
    }

    static boolean zzbiy() {
        return zzifu;
    }

    static boolean zzbiz() {
        return zzioc;
    }

    static Unsafe zzbja() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzenf());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbjb() {
        Unsafe unsafe = zzhsa;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzeii.zzbdz()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbjc() {
        Unsafe unsafe = zzhsa;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzbjd() == null) {
                return false;
            }
            if (zzeii.zzbdz()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzbjd() {
        Field fieldZzb;
        if (zzeii.zzbdz() && (fieldZzb = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzb;
        }
        Field fieldZzb2 = zzb(Buffer.class, "address");
        if (fieldZzb2 == null || fieldZzb2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static <T> T zzj(Class<T> cls) {
        try {
            return (T) zzhsa.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzifu) {
            return zziob.zziov.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzifu) {
            return zziob.zziov.arrayIndexScale(cls);
        }
        return -1;
    }

    static boolean zzm(Object obj, long j) {
        return zziob.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zziob.zzn(obj, j);
    }

    static double zzo(Object obj, long j) {
        return zziob.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zziob.zziov.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) (((j ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    static void zza(Object obj, long j, boolean z) {
        zziob.zza(obj, j, z);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzeii.zzbdz()) {
            return false;
        }
        try {
            Class<?> cls2 = zziei;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzend.zzios) {
                zzend.zzb(obj, j, z);
            } else {
                zzend.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzend.zzios) {
                zzend.zza(obj, j, b2);
            } else {
                zzend.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final boolean zzm(Object obj, long j) {
            return zzend.zzios ? zzend.zzs(obj, j) : zzend.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final byte zzy(Object obj, long j) {
            return zzend.zzios ? zzend.zzq(obj, j) : zzend.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzend.zzios) {
                zzend.zzb(obj, j, z);
            } else {
                zzend.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzend.zzios) {
                zzend.zza(obj, j, b2);
            } else {
                zzend.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final boolean zzm(Object obj, long j) {
            return zzend.zzios ? zzend.zzs(obj, j) : zzend.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final byte zzy(Object obj, long j) {
            return zzend.zzios ? zzend.zzq(obj, j) : zzend.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.ads.zzend.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static void zza(Object obj, long j, float f2) {
        zziob.zza(obj, j, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ (-1))));
    }

    static int zzk(Object obj, long j) {
        return zziob.zzk(obj, j);
    }

    static long zzl(Object obj, long j) {
        return zziob.zzl(obj, j);
    }

    static void zza(Object obj, long j, double d2) {
        zziob.zza(obj, j, d2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zziob.zziov.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static byte zza(byte[] bArr, long j) {
        return zziob.zzy(bArr, zziod + j);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zziob.zze(bArr, zziod + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ (-1))));
    }
}
