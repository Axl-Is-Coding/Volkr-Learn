package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabi {
    private File file;

    @VisibleForTesting
    private String zzbre;

    @VisibleForTesting
    private String zzcyu;

    @VisibleForTesting
    private BlockingQueue<zzabs> zzcyx = new ArrayBlockingQueue(100);

    @VisibleForTesting
    private LinkedHashMap<String, String> zzcyy = new LinkedHashMap<>();

    @VisibleForTesting
    private Map<String, zzabm> zzcyz = new HashMap();
    private final HashSet<String> zzcza = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    private AtomicBoolean zzczb;

    @VisibleForTesting
    private Context zzvr;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.zzvr = context;
        this.zzbre = str;
        this.zzcyu = str2;
        this.zzczb = new AtomicBoolean(false);
        this.zzczb.set(zzacs.zzdba.get().booleanValue());
        if (this.zzczb.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzcyy.put(entry.getKey(), entry.getValue());
        }
        zzbbz.zzeep.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzabh
            private final zzabi zzcyw;

            {
                this.zzcyw = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.zzcyw.zzro();
            }
        });
        this.zzcyz.put("action", zzabm.zzczd);
        this.zzcyz.put(FirebaseAnalytics.Param.AD_FORMAT, zzabm.zzczd);
        this.zzcyz.put("e", zzabm.zzcze);
    }

    public final zzabm zzcu(String str) {
        zzabm zzabmVar = this.zzcyz.get(str);
        return zzabmVar != null ? zzabmVar : zzabm.zzczc;
    }

    public final void zzcv(String str) throws Throwable {
        if (this.zzcza.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzbre);
        linkedHashMap.put("ue", str);
        zza(zza(this.zzcyy, linkedHashMap), "");
    }

    final /* synthetic */ void zzro() throws Throwable {
        while (true) {
            try {
                zzabs zzabsVarTake = this.zzcyx.take();
                String strZzrt = zzabsVarTake.zzrt();
                if (!TextUtils.isEmpty(strZzrt)) {
                    zza(zza(this.zzcyy, zzabsVarTake.zzru()), strZzrt);
                }
            } catch (InterruptedException e2) {
                zzbbq.zzd("CsiReporter:reporter interrupted", e2);
                return;
            }
        }
    }

    public final boolean zza(zzabs zzabsVar) {
        return this.zzcyx.offer(zzabsVar);
    }

    private final void zza(Map<String, String> map, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        Uri.Builder builderBuildUpon = Uri.parse(this.zzcyu).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        StringBuilder sb = new StringBuilder(builderBuildUpon.build().toString());
        if (!TextUtils.isEmpty(str)) {
            sb.append("&it=");
            sb.append(str);
        }
        String string = sb.toString();
        if (this.zzczb.get()) {
            File file = this.file;
            if (file != null) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file, true);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(string.getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e3) {
                        zzbbq.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                        return;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream2 = fileOutputStream;
                    zzbbq.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e5) {
                            zzbbq.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            zzbbq.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e6);
                        }
                    }
                    throw th;
                }
            }
            zzbbq.zzfe("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zzb(this.zzvr, this.zzbre, string);
    }

    final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzcu(key).zzg((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }
}
