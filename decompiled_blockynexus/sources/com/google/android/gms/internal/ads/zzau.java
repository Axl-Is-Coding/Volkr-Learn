package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzau implements zzx {
    private static final boolean DEBUG = zzaq.DEBUG;

    @Deprecated
    private final zzbe zzcf;
    private final zzar zzcg;
    private final zzat zzch;

    public zzau(zzar zzarVar) {
        this(zzarVar, new zzat(4096));
    }

    private static void zza(String str, zzaa<?> zzaaVar, zzao zzaoVar) throws zzao {
        zzan zzanVarZzj = zzaaVar.zzj();
        int iZzi = zzaaVar.zzi();
        try {
            zzanVarZzj.zza(zzaoVar);
            zzaaVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzi)));
        } catch (zzao e2) {
            zzaaVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iZzi)));
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0202 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0197  */
    @Override // com.google.android.gms.internal.ads.zzx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.ads.zzy zzc(com.google.android.gms.internal.ads.zzaa<?> r22) throws com.google.android.gms.internal.ads.zzao {
        /*
            Method dump skipped, instruction units count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.zzc(com.google.android.gms.internal.ads.zzaa):com.google.android.gms.internal.ads.zzy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzau(zzar zzarVar, zzat zzatVar) {
        this.zzcg = zzarVar;
        this.zzcf = zzarVar;
        this.zzch = zzatVar;
    }

    private final byte[] zza(InputStream inputStream, int i) throws zzam, IOException {
        zzbi zzbiVar = new zzbi(this.zzch, i);
        try {
            if (inputStream != null) {
                byte[] bArrZzf = this.zzch.zzf(1024);
                while (true) {
                    int i2 = inputStream.read(bArrZzf);
                    if (i2 == -1) {
                        break;
                    }
                    zzbiVar.write(bArrZzf, 0, i2);
                }
                byte[] byteArray = zzbiVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        zzaq.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzch.zza(bArrZzf);
                zzbiVar.close();
                return byteArray;
            }
            throw new zzam();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzaq.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.zzch.zza(null);
            zzbiVar.close();
            throw th;
        }
    }
}
