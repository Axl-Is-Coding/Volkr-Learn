package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeie;
import com.google.android.gms.internal.ads.zzeif;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeif<MessageType extends zzeif<MessageType, BuilderType>, BuilderType extends zzeie<MessageType, BuilderType>> implements zzelj {
    protected int zziee = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzekb.checkNotNull(iterable);
        if (iterable instanceof zzeku) {
            List<?> listZzbhj = ((zzeku) iterable).zzbhj();
            zzeku zzekuVar = (zzeku) list;
            int size = list.size();
            for (Object obj : listZzbhj) {
                if (obj == null) {
                    int size2 = zzekuVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzekuVar.size() - 1; size3 >= size; size3--) {
                        zzekuVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzeip) {
                    zzekuVar.zzaj((zzeip) obj);
                } else {
                    zzekuVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzelv) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbgh()];
            zzejj zzejjVarZzw = zzejj.zzw(bArr);
            zzb(zzejjVarZzw);
            zzejjVarZzw.zzbfq();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final zzeip zzbdw() {
        try {
            zzeix zzeixVarZzfw = zzeip.zzfw(zzbgh());
            zzb(zzeixVarZzfw.zzbeo());
            return zzeixVarZzfw.zzben();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    int zzbdx() {
        throw new UnsupportedOperationException();
    }

    void zzfq(int i) {
        throw new UnsupportedOperationException();
    }
}
