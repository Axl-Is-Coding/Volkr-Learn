package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import com.google.android.gms.internal.ads.zzejz.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzejz<MessageType extends zzejz<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeif<MessageType, BuilderType> {
    private static Map<Object, zzejz<?, ?>> zzije = new ConcurrentHashMap();
    protected zzena zzijc = zzena.zzbiv();
    private int zzijd = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static class zza<T extends zzejz<T, ?>> extends zzeig<T> {
        private final T zzijg;

        public zza(T t) {
            this.zzijg = t;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zzc implements zzeju<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final zzelm zza(zzelm zzelmVar, zzelj zzeljVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final zzeno zzbga() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final zzenr zzbgb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final boolean zzbgc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final boolean zzbgd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final int zzv() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzeju
        public final zzels zza(zzels zzelsVar, zzels zzelsVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzejz<MessageType, BuilderType> implements zzell {
        protected zzejs<zzc> zzijj = zzejs.zzbfy();

        final zzejs<zzc> zzbgu() {
            if (this.zzijj.isImmutable()) {
                this.zzijj = (zzejs) this.zzijj.clone();
            }
            return this.zzijj;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public enum zze {
        public static final int zzijk = 1;
        public static final int zzijl = 2;
        public static final int zzijm = 3;
        public static final int zzijn = 4;
        public static final int zzijo = 5;
        public static final int zzijp = 6;
        public static final int zzijq = 7;
        private static final /* synthetic */ int[] zzijr = {zzijk, zzijl, zzijm, zzijn, zzijo, zzijp, zzijq};
        public static final int zzijs = 1;
        public static final int zzijt = 2;
        private static final /* synthetic */ int[] zziju = {zzijs, zzijt};
        public static final int zzijv = 1;
        public static final int zzijw = 2;
        private static final /* synthetic */ int[] zzijx = {zzijv, zzijw};

        public static int[] zzbgv() {
            return (int[]) zzijr.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static class zzf<ContainingType extends zzelj, Type> extends zzejn<ContainingType, Type> {
    }

    protected static <T extends zzejz<?, ?>> void zza(Class<T> cls, T t) {
        zzije.put(cls, t);
    }

    protected static zzekf zzbgi() {
        return zzekc.zzbgw();
    }

    protected static zzekh zzbgj() {
        return zzekx.zzbhn();
    }

    protected static <E> zzekk<E> zzbgk() {
        return zzelx.zzbib();
    }

    static <T extends zzejz<?, ?>> T zzd(Class<T> cls) {
        zzejz<?, ?> zzejzVar = zzije.get(cls);
        if (zzejzVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzejzVar = zzije.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzejzVar == null) {
            zzejzVar = (T) ((zzejz) zzend.zzj(cls)).zza(zze.zzijp, (Object) null, (Object) null);
            if (zzejzVar == null) {
                throw new IllegalStateException();
            }
            zzije.put(cls, zzejzVar);
        }
        return (T) zzejzVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzely.zzbic().zzaw(this).equals(this, (zzejz) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zziee;
        if (i != 0) {
            return i;
        }
        this.zziee = zzely.zzbic().zzaw(this).hashCode(this);
        return this.zziee;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return zzelo.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzelj
    public final void zzb(zzejj zzejjVar) throws IOException {
        zzely.zzbic().zzaw(this).zza(this, zzejl.zza(zzejjVar));
    }

    @Override // com.google.android.gms.internal.ads.zzeif
    final int zzbdx() {
        return this.zzijd;
    }

    protected final <MessageType extends zzejz<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbgf() {
        return (BuilderType) zza(zze.zzijo, (Object) null, (Object) null);
    }

    public final BuilderType zzbgg() {
        BuilderType buildertype = (BuilderType) zza(zze.zzijo, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final int zzbgh() {
        if (this.zzijd == -1) {
            this.zzijd = zzely.zzbic().zzaw(this).zzat(this);
        }
        return this.zzijd;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ zzelm zzbgl() {
        zzb zzbVar = (zzb) zza(zze.zzijo, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ zzelm zzbgm() {
        return (zzb) zza(zze.zzijo, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzelj zzbgn() {
        return (zzejz) zza(zze.zzijp, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzeif
    final void zzfq(int i) {
        this.zzijd = i;
    }

    protected static Object zza(zzelj zzeljVar, String str, Object[] objArr) {
        return new zzema(zzeljVar, str, objArr);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static abstract class zzb<MessageType extends zzejz<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeie<MessageType, BuilderType> {
        private final MessageType zzijg;
        protected MessageType zzijh;
        protected boolean zziji = false;

        protected zzb(MessageType messagetype) {
            this.zzijg = messagetype;
            this.zzijh = (MessageType) messagetype.zza(zze.zzijn, null, null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzely.zzbic().zzaw(messagetype).zzg(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzeie
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzijg.zza(zze.zzijo, null, null);
            zzbVar.zza((zzejz) zzbgs());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.ads.zzell
        public final boolean isInitialized() {
            return zzejz.zza(this.zzijh, false);
        }

        @Override // com.google.android.gms.internal.ads.zzeie
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            zza(this.zzijh, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.ads.zzeie
        /* JADX INFO: renamed from: zzbdv */
        public final /* synthetic */ zzeie clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzell
        public final /* synthetic */ zzelj zzbgn() {
            return this.zzijg;
        }

        protected void zzbgp() {
            MessageType messagetype = (MessageType) this.zzijh.zza(zze.zzijn, null, null);
            zza(messagetype, this.zzijh);
            this.zzijh = messagetype;
        }

        @Override // com.google.android.gms.internal.ads.zzelm
        /* JADX INFO: renamed from: zzbgq, reason: merged with bridge method [inline-methods] */
        public MessageType zzbgs() {
            if (this.zziji) {
                return this.zzijh;
            }
            MessageType messagetype = this.zzijh;
            zzely.zzbic().zzaw(messagetype).zzaj(messagetype);
            this.zziji = true;
            return this.zzijh;
        }

        @Override // com.google.android.gms.internal.ads.zzelm
        /* JADX INFO: renamed from: zzbgr, reason: merged with bridge method [inline-methods] */
        public final MessageType zzbgt() {
            MessageType messagetype = (MessageType) zzbgs();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzemy(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzeie
        public final /* synthetic */ zzeie zza(byte[] bArr, int i, int i2, zzejm zzejmVar) throws zzekj {
            zzb(bArr, 0, i2, zzejmVar);
            return this;
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzejm zzejmVar) throws zzekj {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            try {
                zzely.zzbic().zzaw(this.zzijh).zza(this.zzijh, bArr, 0, i2 + 0, new zzeik(zzejmVar));
                return this;
            } catch (zzekj e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzekj.zzbgx();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeie
        public final /* synthetic */ zzeie zza(zzeja zzejaVar, zzejm zzejmVar) throws IOException {
            zzb(zzejaVar, zzejmVar);
            return this;
        }

        private final BuilderType zzb(zzeja zzejaVar, zzejm zzejmVar) throws IOException {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            try {
                zzely.zzbic().zzaw(this.zzijh).zza(this.zzijh, zzejh.zza(zzejaVar), zzejmVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }
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

    private static <T extends zzejz<T, ?>> T zzb(T t, zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        try {
            zzeja zzejaVarZzbeh = zzeipVar.zzbeh();
            T t2 = (T) zza(t, zzejaVarZzbeh, zzejmVar);
            try {
                zzejaVarZzbeh.zzfy(0);
                return t2;
            } catch (zzekj e2) {
                throw e2.zzl(t2);
            }
        } catch (zzekj e3) {
            throw e3;
        }
    }

    protected static final <T extends zzejz<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zzijk, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzav = zzely.zzbic().zzaw(t).zzav(t);
        if (z) {
            t.zza(zze.zzijl, zZzav ? t : null, null);
        }
        return zZzav;
    }

    protected static zzekf zza(zzekf zzekfVar) {
        int size = zzekfVar.size();
        return zzekfVar.zzft(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzekk<E> zza(zzekk<E> zzekkVar) {
        int size = zzekkVar.size();
        return zzekkVar.zzft(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzejz<T, ?>> T zza(T t, zzeja zzejaVar, zzejm zzejmVar) throws zzekj {
        T t2 = (T) t.zza(zze.zzijn, null, null);
        try {
            zzemf zzemfVarZzaw = zzely.zzbic().zzaw(t2);
            zzemfVarZzaw.zza(t2, zzejh.zza(zzejaVar), zzejmVar);
            zzemfVarZzaw.zzaj(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzekj) {
                throw ((zzekj) e2.getCause());
            }
            throw new zzekj(e2.getMessage()).zzl(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzekj) {
                throw ((zzekj) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends zzejz<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzejm zzejmVar) throws zzekj {
        T t2 = (T) t.zza(zze.zzijn, null, null);
        try {
            zzemf zzemfVarZzaw = zzely.zzbic().zzaw(t2);
            zzemfVarZzaw.zza(t2, bArr, 0, i2, new zzeik(zzejmVar));
            zzemfVarZzaw.zzaj(t2);
            if (t2.zziee == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzekj) {
                throw ((zzekj) e2.getCause());
            }
            throw new zzekj(e2.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzekj.zzbgx().zzl(t2);
        }
    }

    private static <T extends zzejz<T, ?>> T zza(T t) throws zzekj {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzekj(new zzemy(t).getMessage()).zzl(t);
    }

    protected static <T extends zzejz<T, ?>> T zza(T t, zzeip zzeipVar) throws zzekj {
        T t2 = (T) zzb(t, zzeipVar, zzejm.zzbft());
        zza(t2);
        zza(t2);
        return t2;
    }

    protected static <T extends zzejz<T, ?>> T zza(T t, zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        T t2 = (T) zzb(t, zzeipVar, zzejmVar);
        zza(t2);
        return t2;
    }

    protected static <T extends zzejz<T, ?>> T zza(T t, byte[] bArr) throws zzekj {
        T t2 = (T) zza(t, bArr, 0, bArr.length, zzejm.zzbft());
        zza(t2);
        return t2;
    }

    protected static <T extends zzejz<T, ?>> T zza(T t, byte[] bArr, zzejm zzejmVar) throws zzekj {
        T t2 = (T) zza(t, bArr, 0, bArr.length, zzejmVar);
        zza(t2);
        return t2;
    }
}
