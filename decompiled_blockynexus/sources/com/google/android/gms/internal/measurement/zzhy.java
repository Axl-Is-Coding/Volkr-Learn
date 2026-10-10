package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhy.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzhy<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgg<MessageType, BuilderType> {
    private static Map<Object, zzhy<?, ?>> zzd = new ConcurrentHashMap();
    protected zzks zzb = zzks.zza();
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    protected static class zza<T extends zzhy<T, ?>> extends zzgk<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    static final class zzc implements zzht<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzlg zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzln zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzji zza(zzji zzjiVar, zzjj zzjjVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzht
        public final zzjo zza(zzjo zzjoVar, zzjo zzjoVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzhy<MessageType, BuilderType> implements zzjl {
        protected zzhr<zzc> zzc = zzhr.zza();

        final zzhr<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzhr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {zza, zzb, zzc, zzd, zze, zzf, zzg};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class zzf<ContainingType extends zzjj, Type> extends zzhm<ContainingType, Type> {
    }

    protected static zzie zzbq() {
        return zzib.zzd();
    }

    protected static zzih zzbr() {
        return zzix.zzd();
    }

    protected static <E> zzig<E> zzbs() {
        return zzjw.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjx.zza().zza(this).zza(this, (zzhy) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        this.zza = zzjx.zza().zza(this).zza(this);
        return this.zza;
    }

    public String toString() {
        return zzjk.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final void zza(zzhi zzhiVar) throws IOException {
        zzjx.zza().zza(this).zza(this, zzhk.zza(zzhiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final int zzbl() {
        return this.zzc;
    }

    protected final <MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbm() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final boolean zzbn() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbo() {
        BuilderType buildertype = (BuilderType) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final int zzbp() {
        if (this.zzc == -1) {
            this.zzc = zzjx.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzji zzbt() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final /* synthetic */ zzji zzbu() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final /* synthetic */ zzjj zzbv() {
        return (zzhy) zza(zze.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zzc(int i) {
        this.zzc = i;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class zzb<MessageType extends zzhy<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgi<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzhl zzhlVar) throws zzij {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjx.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzgo(zzhlVar));
                return this;
            } catch (zzij e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzij.zza();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzgi
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzhy) zzx());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean zzbn() {
            return zzhy.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final /* synthetic */ zzjj zzbv() {
            return this.zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        /* JADX INFO: renamed from: zzt */
        public final /* synthetic */ zzgi clone() {
            return (zzb) clone();
        }

        protected void zzu() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzji
        /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
        public MessageType zzx() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjx.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzji
        /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public final MessageType zzy() {
            MessageType messagetype = (MessageType) zzx();
            if (messagetype.zzbn()) {
                return messagetype;
            }
            throw new zzkq(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjx.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(zzhb zzhbVar, zzhl zzhlVar) throws IOException {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjx.zza().zza(this.zza).zza(this.zza, zzhg.zza(zzhbVar), zzhlVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2, zzhl zzhlVar) throws zzij {
            zzb(bArr, 0, i2, zzhlVar);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(byte[] bArr, int i, int i2) throws zzij {
            zzb(bArr, 0, i2, zzhl.zza());
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.zzgi
        public final /* synthetic */ zzgi zza(zzhb zzhbVar, zzhl zzhlVar) throws IOException {
            zzb(zzhbVar, zzhlVar);
            return this;
        }
    }

    static <T extends zzhy<?, ?>> T zza(Class<T> cls) {
        zzhy<?, ?> zzhyVar = zzd.get(cls);
        if (zzhyVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhyVar = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzhyVar == null) {
            zzhyVar = (T) ((zzhy) zzkz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzhyVar != null) {
                zzd.put(cls, zzhyVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzhyVar;
    }

    protected static <T extends zzhy<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjj zzjjVar, String str, Object[] objArr) {
        return new zzjz(zzjjVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends zzhy<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzjx.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    protected static zzih zza(zzih zzihVar) {
        int size = zzihVar.size();
        return zzihVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzig<E> zza(zzig<E> zzigVar) {
        int size = zzigVar.size();
        return zzigVar.zza(size == 0 ? 10 : size << 1);
    }
}
