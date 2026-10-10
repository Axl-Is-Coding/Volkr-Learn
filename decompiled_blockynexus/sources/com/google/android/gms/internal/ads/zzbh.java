package com.google.android.gms.internal.ads;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbh extends zzaa<String> {
    private final Object mLock;
    private zzal<String> zzcy;

    public zzbh(int i, String str, zzal<String> zzalVar, zzai zzaiVar) {
        super(i, str, zzaiVar);
        this.mLock = new Object();
        this.zzcy = zzalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    protected final zzaj<String> zza(zzy zzyVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzyVar.data;
            Map<String, String> map = zzyVar.zzam;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals(HybridPlusWebView.CHARSET)) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzyVar.data);
        }
        return zzaj.zza(str, zzbc.zzb(zzyVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaa
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public void zza(String str) {
        zzal<String> zzalVar;
        synchronized (this.mLock) {
            zzalVar = this.zzcy;
        }
        if (zzalVar != null) {
            zzalVar.zzb(str);
        }
    }
}
