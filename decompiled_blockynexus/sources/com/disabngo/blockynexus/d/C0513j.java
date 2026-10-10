package com.disabngo.blockynexus.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.c.fa;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskManageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0513j {
    public static void a(final Context context, final List<GameDiskCacheInfo> list, ObservableField<Boolean> observableField, ObservableField<Long> observableField2, io.reactivex.w<Long> wVar) {
        observableField.set(true);
        io.reactivex.p.create(new io.reactivex.s() { // from class: com.disabngo.blockynexus.d.b
            @Override // io.reactivex.s
            public final void a(io.reactivex.r rVar) throws Exception {
                C0513j.a(list, context, rVar);
            }
        }).subscribeOn(io.reactivex.f.b.b()).observeOn(io.reactivex.android.b.b.a()).subscribe(new C0510g(wVar, context, observableField, observableField2, list));
    }

    private static long b(GameDiskCacheInfo gameDiskCacheInfo, boolean z, ObservableField<Long> observableField, String str) {
        String[] list;
        long jB = 0;
        if (gameDiskCacheInfo.getIsNewEngine() != 0 && !TextUtils.isEmpty(str) && (list = new File(str).list()) != null && list.length != 0) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2) && str2.equals(gameDiskCacheInfo.getGameId())) {
                    File file = new File(str, str2);
                    if (file.exists()) {
                        if (z) {
                            observableField.set(Long.valueOf(observableField.get().longValue() - m.b(file)));
                            m.a(file);
                        } else {
                            jB += m.b(file);
                        }
                    }
                }
            }
        }
        return jB;
    }

    static /* synthetic */ void a(List list, final Context context, io.reactivex.r rVar) throws Exception {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final Iterator it = list.iterator();
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
            for (int i = 0; i < iAvailableProcessors; i++) {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.disabngo.blockynexus.d.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0513j.a(it, context);
                    }
                });
            }
            executorServiceNewFixedThreadPool.shutdown();
            while (!executorServiceNewFixedThreadPool.isTerminated()) {
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            com.apkfuns.logutils.c.a("initGameSize").d("initGameSize end ----------------------------------: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        rVar.onComplete();
    }

    private static void b(Context context, GameDiskCacheInfo gameDiskCacheInfo) {
        if (gameDiskCacheInfo.getIsNewEngine() == 1 && CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
            SharedUtils.putLong(context, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION, 0L);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
            U.newInstance().c(new C0511h(gameDiskCacheInfo, countDownLatch));
        } else {
            U.newInstance().b(gameDiskCacheInfo.getGameId(), new C0512i(gameDiskCacheInfo, countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(Iterator it, Context context) {
        while (it.hasNext()) {
            try {
                a(context, (GameDiskCacheInfo) it.next());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static long a(Context context, GameDiskCacheInfo gameDiskCacheInfo, ObservableField<Long> observableField) {
        return a(context, gameDiskCacheInfo, true, observableField);
    }

    public static long a(Context context, GameDiskCacheInfo gameDiskCacheInfo) {
        return a(context, gameDiskCacheInfo, false, (ObservableField<Long>) new ObservableField(0L));
    }

    private static long a(Context context, GameDiskCacheInfo gameDiskCacheInfo, boolean z, ObservableField<Long> observableField) {
        long jA = 0;
        if (gameDiskCacheInfo != null && !TextUtils.isEmpty(gameDiskCacheInfo.getGameId())) {
            if (!z && !gameDiskCacheInfo.getIsDataChange()) {
                return gameDiskCacheInfo.getDiskSpaceSize();
            }
            if (z && gameDiskCacheInfo.getDiskSpaceSize() == 0) {
                return 0L;
            }
            ObservableField observableField2 = new ObservableField(0L);
            if (z) {
                b(context, gameDiskCacheInfo);
            }
            String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(context);
            AbstractEngineEnv engine = EngineEnv.getEngine(gameDiskCacheInfo.getIsNewEngine(), gameDiskCacheInfo.getIsUgcGame());
            String resRootPath = engine.getResRootPath();
            String mapRootPath = engine.getMapRootPath();
            String mapTempRootPath = engine.getMapTempRootPath();
            try {
                jA = 0 + a(gameDiskCacheInfo, z, observableField, (ObservableField<Long>) observableField2, apkOrSoDownloadPath) + a(context, gameDiskCacheInfo, z, observableField, observableField2, resRootPath) + a(gameDiskCacheInfo, z, observableField, mapRootPath);
                jA += b(gameDiskCacheInfo, z, observableField, mapTempRootPath);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GameDiskCacheInfo gameDiskCacheInfoB = fa.newInstance().b(gameDiskCacheInfo.getGameId());
            gameDiskCacheInfoB.setDiskSpaceSize(jA);
            if (!CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
                gameDiskCacheInfoB.setIsDataChange(false);
            }
            fa.newInstance().b(gameDiskCacheInfoB);
            if (z) {
                a(((Long) observableField2.get()).longValue());
                fa.newInstance().c(gameDiskCacheInfo.getGameId());
            }
        }
        return jA;
    }

    private static long a(GameDiskCacheInfo gameDiskCacheInfo, boolean z, ObservableField<Long> observableField, ObservableField<Long> observableField2, String str) {
        long jB;
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (!CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
                    if (file2 != null && file2.exists() && file2.getName().contains("appres") && file2.getName().contains(gameDiskCacheInfo.getGameId())) {
                        if (z) {
                            observableField.set(Long.valueOf(observableField.get().longValue() - m.b(file2)));
                            m.a(file2);
                        } else {
                            jB = m.b(file2);
                            j += jB;
                        }
                    }
                } else if (file2 != null && file2.exists() && file2.getName().contains("appres") && file2.getName().contains("gamecommonv2")) {
                    if (z) {
                        long jB2 = m.b(file2);
                        observableField2.set(Long.valueOf(observableField2.get().longValue() + jB2));
                        observableField.set(Long.valueOf(observableField.get().longValue() - jB2));
                        m.a(file2);
                    } else {
                        jB = m.b(file2);
                        j += jB;
                    }
                }
            }
        }
        return j;
    }

    private static long a(Context context, GameDiskCacheInfo gameDiskCacheInfo, boolean z, ObservableField<Long> observableField, ObservableField<Long> observableField2, String str) {
        long jB = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] list = new File(str).list();
        if (list != null && list.length != 0) {
            for (String str2 : list) {
                if (!CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase().endsWith(".md5") && str2.contains("appres") && str2.contains(gameDiskCacheInfo.getGameId())) {
                        Iterator<String> it = com.sandboxol.file.f.b.a(context, str, str2).keySet().iterator();
                        while (it.hasNext()) {
                            File file = new File(str, it.next());
                            if (file.exists()) {
                                if (z) {
                                    observableField.set(Long.valueOf(observableField.get().longValue() - m.b(file)));
                                    m.a(file);
                                } else {
                                    jB += m.b(file);
                                }
                            }
                        }
                        if (z) {
                            m.a(new File(str, str2));
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase().endsWith(".md5") && str2.contains("appres") && str2.contains("gamecommonv2")) {
                        Iterator<String> it2 = com.sandboxol.file.f.b.a(context, str, str2).keySet().iterator();
                        while (it2.hasNext()) {
                            File file2 = new File(str, it2.next());
                            if (file2.exists()) {
                                if (z) {
                                    long jB2 = m.b(file2);
                                    observableField2.set(Long.valueOf(observableField2.get().longValue() + jB2));
                                    observableField.set(Long.valueOf(observableField.get().longValue() - jB2));
                                    m.a(file2);
                                } else {
                                    jB += m.b(file2);
                                }
                            }
                        }
                        if (z) {
                            m.a(new File(str, str2));
                        }
                    }
                }
            }
        }
        return jB;
    }

    private static long a(GameDiskCacheInfo gameDiskCacheInfo, boolean z, ObservableField<Long> observableField, String str) {
        long jB = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] list = new File(str).list();
        if (list != null && list.length != 0) {
            if (gameDiskCacheInfo.getIsNewEngine() == 0) {
                GameDiskCacheInfo gameDiskCacheInfoB = fa.newInstance().b(gameDiskCacheInfo.getGameId());
                if (gameDiskCacheInfoB == null || gameDiskCacheInfoB.getMapPathName() == null || gameDiskCacheInfoB.getMapPathName().size() == 0) {
                    return 0L;
                }
                Iterator<String> it = gameDiskCacheInfoB.getMapPathName().keySet().iterator();
                while (it.hasNext()) {
                    File file = new File(str, it.next());
                    if (file.exists()) {
                        if (z) {
                            observableField.set(Long.valueOf(observableField.get().longValue() - m.b(file)));
                            m.a(file);
                        } else {
                            jB += m.b(file);
                        }
                    }
                }
            } else {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(gameDiskCacheInfo.getGameId())) {
                        File file2 = new File(str, str2);
                        if (file2.exists()) {
                            if (z) {
                                observableField.set(Long.valueOf(observableField.get().longValue() - m.b(file2)));
                                m.a(file2);
                            } else {
                                jB += m.b(file2);
                            }
                        }
                    }
                }
            }
        }
        return jB;
    }

    private static void a(long j) {
        List<GameDiskCacheInfo> listB = fa.newInstance().b();
        if (listB == null || listB.size() <= 0) {
            return;
        }
        for (GameDiskCacheInfo gameDiskCacheInfo : listB) {
            if (gameDiskCacheInfo != null && !TextUtils.isEmpty(gameDiskCacheInfo.getGameId()) && CommonUtils.isNewEngineCommonGame(gameDiskCacheInfo.getGameId())) {
                gameDiskCacheInfo.setDiskSpaceSize(gameDiskCacheInfo.getDiskSpaceSize() - j > 0 ? gameDiskCacheInfo.getDiskSpaceSize() - j : 0L);
                fa.newInstance().b(gameDiskCacheInfo);
            }
        }
    }
}
