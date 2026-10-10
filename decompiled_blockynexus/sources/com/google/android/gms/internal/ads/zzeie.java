package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeie;
import com.google.android.gms.internal.ads.zzeif;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeie<MessageType extends zzeif<MessageType, BuilderType>, BuilderType extends zzeie<MessageType, BuilderType>> implements zzelm {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzeja zzejaVar, zzejm zzejmVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzejm zzejmVar) throws zzekj {
        try {
            zzeja zzejaVarZzb = zzeja.zzb(bArr, 0, i2, false);
            zza(zzejaVarZzb, zzejmVar);
            zzejaVarZzb.zzfy(0);
            return this;
        } catch (zzekj e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzbdv, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    @Override // com.google.android.gms.internal.ads.zzelm
    public final /* synthetic */ zzelm zzf(zzelj zzeljVar) {
        if (zzbgn().getClass().isInstance(zzeljVar)) {
            return zza((zzeif) zzeljVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
