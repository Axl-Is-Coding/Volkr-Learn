package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgi;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgi<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzji {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhb zzhbVar, zzhl zzhlVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzij {
        try {
            zzhb zzhbVarZza = zzhb.zza(bArr, 0, i2, false);
            zza(zzhbVarZza, zzhl.zza());
            zzhbVarZza.zza(0);
            return this;
        } catch (zzij e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(zza("byte array"), e3);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzhl zzhlVar) throws zzij {
        try {
            zzhb zzhbVarZza = zzhb.zza(bArr, 0, i2, false);
            zza(zzhbVarZza, zzhlVar);
            zzhbVarZza.zza(0);
            return this;
        } catch (zzij e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(zza("byte array"), e3);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(zzjj zzjjVar) {
        if (zzbv().getClass().isInstance(zzjjVar)) {
            return zza((zzgg) zzjjVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(byte[] bArr, zzhl zzhlVar) throws zzij {
        return zza(bArr, 0, bArr.length, zzhlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(byte[] bArr) throws zzij {
        return zza(bArr, 0, bArr.length);
    }
}
