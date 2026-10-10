package com.google.android.gms.internal.ads;

import com.sandboxol.common.utils.TextEllipsizeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeip implements Serializable, Iterable<Byte> {
    public static final zzeip zzier = new zzeiz(zzekb.zziex);
    private static final zzeiv zzies;
    private static final Comparator<zzeip> zziet;
    private int zzidx = 0;

    static {
        zzeio zzeioVar = null;
        zzies = zzeii.zzbdz() ? new zzejb(zzeioVar) : new zzeit(zzeioVar);
        zziet = new zzeir();
    }

    zzeip() {
    }

    private static zzeip zza(Iterator<zzeip> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        zzeip zzeipVarZza = zza(it, i2);
        zzeip zzeipVarZza2 = zza(it, i - i2);
        if (Integer.MAX_VALUE - zzeipVarZza.size() >= zzeipVarZza2.size()) {
            return zzemc.zza(zzeipVarZza, zzeipVarZza2);
        }
        int size = zzeipVarZza.size();
        int size2 = zzeipVarZza2.size();
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    static void zzaa(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b2) {
        return b2 & 255;
    }

    public static zzeiy zzbei() {
        return new zzeiy(128);
    }

    static zzeix zzfw(int i) {
        return new zzeix(i, null);
    }

    public static zzeip zzg(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i = 0;
            while (i < iMin) {
                int i2 = inputStream.read(bArr, i, iMin - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            zzeip zzeipVarZzi = i == 0 ? null : zzi(bArr, 0, i);
            if (zzeipVarZzi == null) {
                return zzl(arrayList);
            }
            arrayList.add(zzeipVarZzi);
            iMin = Math.min(iMin << 1, 8192);
        }
    }

    public static zzeip zzhu(String str) {
        return new zzeiz(str.getBytes(zzekb.UTF_8));
    }

    public static zzeip zzi(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        return new zzeiz(zzies.zzj(bArr, i, i2));
    }

    public static zzeip zzl(Iterable<zzeip> iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            size = 0;
            Iterator<zzeip> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzier : zza(iterable.iterator(), size);
    }

    public static zzeip zzu(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    static zzeip zzv(byte[] bArr) {
        return new zzeiz(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzh = this.zzidx;
        if (iZzh == 0) {
            int size = size();
            iZzh = zzh(size, 0, size);
            if (iZzh == 0) {
                iZzh = 1;
            }
            this.zzidx = iZzh;
        }
        return iZzh;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzekb.zziex;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzemt.zzam(this) : String.valueOf(zzemt.zzam(zzz(0, 47))).concat(TextEllipsizeUtil.SignLib.END_POINT);
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    protected abstract String zza(Charset charset);

    abstract void zza(zzeim zzeimVar) throws IOException;

    protected abstract void zzb(byte[] bArr, int i, int i2, int i3);

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzbee, reason: merged with bridge method [inline-methods] */
    public zzeiu iterator() {
        return new zzeio(this);
    }

    public final String zzbef() {
        return size() == 0 ? "" : zza(zzekb.UTF_8);
    }

    public abstract boolean zzbeg();

    public abstract zzeja zzbeh();

    protected abstract int zzbej();

    protected abstract boolean zzbek();

    protected final int zzbel() {
        return this.zzidx;
    }

    public abstract byte zzfu(int i);

    abstract byte zzfv(int i);

    protected abstract int zzg(int i, int i2, int i3);

    protected abstract int zzh(int i, int i2, int i3);

    public abstract zzeip zzz(int i, int i2);

    static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzi(i, i + i3, size());
        zzi(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }
}
