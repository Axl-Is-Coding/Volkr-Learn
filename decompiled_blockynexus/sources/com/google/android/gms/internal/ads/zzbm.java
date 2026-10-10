package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbm implements zzbo {
    private static Logger zzda = Logger.getLogger(zzbm.class.getName());
    private ThreadLocal<ByteBuffer> zzdb = new zzbl(this);

    @Override // com.google.android.gms.internal.ads.zzbo
    public final zzbp zza(zzeok zzeokVar, zzbs zzbsVar) throws IOException {
        int i;
        long size;
        long jPosition = zzeokVar.position();
        this.zzdb.get().rewind().limit(8);
        do {
            i = zzeokVar.read(this.zzdb.get());
            if (i == 8) {
                this.zzdb.get().rewind();
                long jZzf = zzbq.zzf(this.zzdb.get());
                byte[] bArr = null;
                if (jZzf < 8 && jZzf > 1) {
                    Logger logger = zzda;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZzf);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String strZzk = zzbq.zzk(this.zzdb.get());
                if (jZzf == 1) {
                    this.zzdb.get().limit(16);
                    zzeokVar.read(this.zzdb.get());
                    this.zzdb.get().position(8);
                    size = zzbq.zzh(this.zzdb.get()) - 16;
                } else {
                    size = jZzf == 0 ? zzeokVar.size() - zzeokVar.position() : jZzf - 8;
                }
                if ("uuid".equals(strZzk)) {
                    this.zzdb.get().limit(this.zzdb.get().limit() + 16);
                    zzeokVar.read(this.zzdb.get());
                    bArr = new byte[16];
                    for (int iPosition = this.zzdb.get().position() - 16; iPosition < this.zzdb.get().position(); iPosition++) {
                        bArr[iPosition - (this.zzdb.get().position() - 16)] = this.zzdb.get().get(iPosition);
                    }
                    size -= 16;
                }
                long j = size;
                zzbp zzbpVarZza = zza(strZzk, bArr, zzbsVar instanceof zzbp ? ((zzbp) zzbsVar).getType() : "");
                zzbpVarZza.zza(zzbsVar);
                this.zzdb.get().rewind();
                zzbpVarZza.zza(zzeokVar, this.zzdb.get(), j, this);
                return zzbpVarZza;
            }
        } while (i >= 0);
        zzeokVar.zzfc(jPosition);
        throw new EOFException();
    }

    public abstract zzbp zza(String str, byte[] bArr, String str2);
}
