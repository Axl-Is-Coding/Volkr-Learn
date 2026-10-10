package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardVideoCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f5907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<com.bytedance.sdk.openadsdk.core.d.h, Long> f5908d = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: RewardVideoCache.java */
    interface a<T> {
        void a(boolean z, T t);
    }

    private e(Context context) {
        this.f5906b = context == null ? o.a() : context.getApplicationContext();
        this.f5907c = new h(this.f5906b, "sp_reward_video");
    }

    public AdSlot b(String str) {
        return this.f5907c.e(str);
    }

    public com.bytedance.sdk.openadsdk.core.d.h c(String str) {
        com.bytedance.sdk.openadsdk.core.d.h hVarA;
        long jB = this.f5907c.b(str);
        boolean zC = this.f5907c.c(str);
        if (!(System.currentTimeMillis() - jB < 10800000) || zC) {
            return null;
        }
        try {
            String strA = this.f5907c.a(str);
            if (TextUtils.isEmpty(strA) || (hVarA = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(strA))) == null) {
                return null;
            }
            if (hVarA.s()) {
                return hVarA;
            }
            if (hVarA.v() == null) {
                return null;
            }
            n nVarV = hVarA.v();
            if (TextUtils.isEmpty(a(nVarV.h(), nVarV.k(), str))) {
                return null;
            }
            return hVarA;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(AdSlot adSlot) {
        this.f5907c.b(adSlot);
    }

    public void a(String str) {
        this.f5907c.d(str);
    }

    public AdSlot b() {
        return this.f5907c.a();
    }

    public void a() {
        File[] fileArrListFiles;
        File file;
        File[] fileArrListFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.f5906b.getDataDir(), "shared_prefs");
            } else {
                file = new File(this.f5906b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            if (file.exists() && file.isDirectory() && (fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles2) {
                    try {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.f5906b.deleteSharedPreferences(strReplace);
                        } else {
                            this.f5906b.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.i.c(file2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.f5906b.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                try {
                    com.bytedance.sdk.openadsdk.utils.i.c(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        a(adSlot);
        if (hVar != null) {
            try {
                this.f5907c.a(adSlot.getCodeId(), hVar.Z().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.f5907c.a(adSlot);
    }

    public static e a(Context context) {
        if (f5905a == null) {
            synchronized (e.class) {
                if (f5905a == null) {
                    f5905a = new e(context);
                }
            }
        }
        return f5905a;
    }

    public String a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null || hVar.v() == null || TextUtils.isEmpty(hVar.v().h())) {
            return null;
        }
        return a(hVar.v().h(), hVar.v().k(), String.valueOf(ab.d(hVar.M())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.utils.h.a(str);
        }
        File fileA = a(this.f5906b, a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b()), str2);
        if (fileA != null && fileA.exists() && fileA.isFile()) {
            return fileA.getAbsolutePath();
        }
        return null;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "reward_video_cache_" + str + "/";
        }
        return "/reward_video_cache_" + str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar, long j, m mVar) {
        VAdError vAdError;
        Long lRemove = this.f5908d.remove(hVar);
        com.bytedance.sdk.openadsdk.c.d.a(this.f5906b, hVar, "rewarded_video", z ? "load_video_success" : "load_video_error", ab.a(z, hVar, lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue(), j, (z || mVar == null || (vAdError = mVar.f5540c) == null) ? null : vAdError.getMessage()));
    }

    public void a(final com.bytedance.sdk.openadsdk.core.d.h hVar, final a<Object> aVar) {
        this.f5908d.put(hVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (hVar != null && hVar.v() != null && !TextUtils.isEmpty(hVar.v().h())) {
            String strH = hVar.v().h();
            String strK = hVar.v().k();
            if (TextUtils.isEmpty(strK)) {
                strK = com.bytedance.sdk.openadsdk.utils.h.a(strH);
            }
            final String str = strK;
            int iD = ab.d(hVar.M());
            String strA = a(String.valueOf(iD), com.bytedance.sdk.openadsdk.multipro.b.b());
            com.bytedance.sdk.openadsdk.utils.o.e("wzj", "ritId:" + iD + ",cacheDirPath=" + strA);
            final File fileA = a(this.f5906b, strA, str);
            com.bytedance.sdk.openadsdk.g.d.a(this.f5906b).a(strH, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.3
                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str2) {
                    try {
                        File parentFile = fileA.getParentFile();
                        if (parentFile == null || !parentFile.exists()) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.core.h.b().n().a(str, parentFile);
                    } catch (IOException e2) {
                        com.bytedance.sdk.openadsdk.utils.o.e("RewardVideoCache", "datastoreGet throw IOException : " + e2.toString());
                        return null;
                    }
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str2) {
                    return fileA;
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(false, null);
                    }
                    e.this.a(false, hVar, mVar == null ? -2L : mVar.h, mVar);
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str2, File file) {
                    if (file != null) {
                        e.this.a(file);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<File> mVar) {
                    if (mVar != null && mVar.f5538a != null) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(true, null);
                        }
                        e.this.a(true, hVar, 0L, mVar);
                        return;
                    }
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(false, null);
                    }
                    e.this.a(false, hVar, mVar == null ? -3L : mVar.h, mVar);
                }
            });
            return;
        }
        if (aVar != null) {
            aVar.a(false, null);
        }
        a(false, hVar, -1L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.h.b().n().a(file);
        } catch (IOException e2) {
            com.bytedance.sdk.openadsdk.utils.o.e("RewardVideoCache", "trimFileCache IOException:" + e2.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.utils.i.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
