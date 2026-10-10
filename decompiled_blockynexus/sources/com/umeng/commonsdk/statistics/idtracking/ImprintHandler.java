package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class ImprintHandler implements FileLockCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21171a = "ImprintHandler";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f21173c = ".imprint";
    private static Context k = null;
    private static FileLockUtil l = null;
    private static final int m = 0;
    private static final int n = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f21176e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f21172b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f21174d = "pbl0".getBytes();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f21175f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            try {
                int i = 0;
                if (f21175f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f21175f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i < size) {
                        if (uMImprintChangeCallback == arrayList.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f21175f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[Catch: all -> 0x0099, DONT_GENERATE, TryCatch #1 {, blocks: (B:8:0x000d, B:10:0x0015, B:12:0x001f, B:14:0x0025, B:16:0x0040, B:18:0x0046, B:19:0x005e, B:20:0x0061, B:22:0x007f, B:28:0x00a1, B:27:0x009c), top: B:33:0x000d, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.lang.String r5, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto La5
            if (r6 != 0) goto La
            goto La5
        La:
            java.lang.Object r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.g
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f21175f     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            if (r1 == 0) goto La1
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f21175f     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            if (r6 == 0) goto La1
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            if (r2 <= 0) goto La1
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r4 = "--->>> removeCallback: before remove: callbacks size is: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r3.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            com.umeng.commonsdk.statistics.common.ULog.i(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r3 = 0
        L3e:
            if (r3 >= r2) goto L61
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            if (r6 != r4) goto L5e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r2 = "--->>> removeCallback: remove index "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.append(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r1.remove(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            goto L61
        L5e:
            int r3 = r3 + 1
            goto L3e
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r2 = "--->>> removeCallback: after remove: callbacks size is: "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            int r6 = r1.size()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            if (r6 != 0) goto La1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r1 = "--->>> removeCallback: remove key from map: key = "
            r6.append(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.append(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f21175f     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            r6.remove(r5)     // Catch: java.lang.Throwable -> L99 java.lang.Throwable -> L9b
            goto La1
        L99:
            r5 = move-exception
            goto La3
        L9b:
            r5 = move-exception
            android.content.Context r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.k     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r5)     // Catch: java.lang.Throwable -> L99
        La1:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            return
        La3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            throw r5
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b(java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback):void");
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            byte[] bArrReverseHexString = DataHelper.reverseHexString(eVar.h());
            byte[] bArrA = a(eVar);
            for (int i = 0; i < 4; i++) {
                if (bArrReverseHexString[i] != bArrA[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        if (mapC.containsKey(au.f20662e)) {
            mapC.remove(au.f20662e);
            this.h.a(au.f20662e);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(mapC.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = mapC.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f21314a;
                synchronized (p) {
                    z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (g) {
                    if (!TextUtils.isEmpty(key) && f21175f.containsKey(key) && (arrayList2 = f21175f.get(key)) != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList2.get(i).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (g) {
                if (!TextUtils.isEmpty(str2) && f21175f.containsKey(str2) && (arrayList = f21175f.get(str2)) != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList.get(i2).onImprintValueChanged(str2, null);
                    }
                }
            }
            mapC.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        if (j == null) {
            j = new ImprintHandler(context);
            l = new FileLockUtil();
            if (l != null) {
                l.doFileOperateion(new File(k.getFilesDir(), f21173c), j, 0);
            }
        }
        return j;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            j.e();
        } else if (i == 1) {
            j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f21177a = new HashMap();

        a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
                    for (String str : mapC.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = mapC.get(str)) != null) {
                            String strB = eVar.b();
                            if (!TextUtils.isEmpty(strB)) {
                                this.f21177a.put(str, strB);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i(ImprintHandler.f21171a, "imKey is " + str + ", imValue is " + strB);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            if (this.f21177a != null && this.f21177a.size() > 0 && !TextUtils.isEmpty(str) && this.f21177a.containsKey(str)) {
                this.f21177a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f21177a.size() > 0) {
                String str3 = this.f21177a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public a c() {
        return this.h;
    }

    public void d() {
        if (this.i == null || l == null) {
            return;
        }
        File file = new File(k.getFilesDir(), f21173c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    UMCrashManager.reportCrash(k, e2);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        l.doFileOperateion(file, j, 1);
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        boolean z;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z2 = AnalyticsConstants.UM_DEBUG;
        HashMap map = new HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
            d(dVar);
            String strI = null;
            String strI2 = dVar2 == null ? null : dVar2.i();
            if (dVar2 == null) {
                e(dVar);
            } else {
                a(dVar2, dVar, map);
                dVar = dVar2;
            }
            this.i = dVar;
            if (dVar != null) {
                strI = dVar.i();
            }
            z = !a(strI2, strI);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.i;
        if (dVar3 != null) {
            boolean z3 = AnalyticsConstants.UM_DEBUG;
            if (z) {
                this.h.a(dVar3);
                com.umeng.commonsdk.statistics.internal.d dVar4 = this.f21176e;
                if (dVar4 != null) {
                    dVar4.onImprintChanged(this.h);
                }
            }
        }
        if (map.size() > 0) {
            synchronized (g) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f21175f.containsKey(key)) {
                        ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f21175f.get(key);
                        if (arrayList != null) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                arrayList.get(i).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f21175f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    private void e() {
        FileInputStream fileInputStreamOpenFileInput;
        File filesDir = k.getFilesDir();
        ?? r2 = f21173c;
        File file = new File(filesDir, f21173c);
        synchronized (f21172b) {
            if (file.exists()) {
                ?? r0 = 0;
                byte[] streamToByteArray = null;
                try {
                    try {
                        fileInputStreamOpenFileInput = k.openFileInput(f21173c);
                        try {
                            streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput);
                            r2 = fileInputStreamOpenFileInput;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            r2 = fileInputStreamOpenFileInput;
                        }
                    } catch (Throwable th) {
                        ?? r4 = r2;
                        th = th;
                        r0 = r4;
                        HelperUtils.safeClose((InputStream) r0);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose((InputStream) r0);
                    throw th;
                }
                HelperUtils.safeClose((InputStream) r2);
                if (streamToByteArray != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new bf().a(dVar, streamToByteArray);
                        this.i = dVar;
                        this.h.a(dVar);
                        com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
                        d(dVar2);
                        this.i = dVar2;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f21176e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
            sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).e());
            sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).h());
        }
        sb.append(dVar.f21303b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(null);
        byteBufferAllocate.putLong(eVar.e());
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr = f21174d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (bArrArray[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.i == null) {
                    return null;
                }
                return new bl().a(this.i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f21314a;
                synchronized (p) {
                    if (!TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    mapC.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!TextUtils.isEmpty(key) && f21175f.containsKey(key) && f21175f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (g) {
                    if (!TextUtils.isEmpty(key2) && f21175f.containsKey(key2) && (arrayList = f21175f.get(key2)) != null) {
                        while (i < arrayList.size()) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                            i++;
                        }
                    }
                }
                mapC.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.i == null) {
            return;
        }
        try {
            synchronized (f21172b) {
                byte[] bArrA = new bl().a(this.i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
