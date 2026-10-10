package com.sandboxol.center.download.utils;

import android.content.Context;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.download.entity.CommonGameProgressInfo;
import com.sandboxol.center.download.entity.CommonProgressInfo;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class ProgressUtils {
    public static void downloadSpeedUpload(Context context, int i, double d2) {
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "map" : "common" : "alone_game" : "common_game" : "dress";
        if (d2 < 1.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "speed<1 kb/s");
            return;
        }
        if (d2 < 10.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "1 kb/s<speed<10 kb/s");
            return;
        }
        if (d2 < 100.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "10 kb/s<speed<100 kb/s");
            return;
        }
        if (d2 < 300.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "100 kb/s<speed<300 kb/s");
            return;
        }
        if (d2 < 500.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "300 kb/s<speed<500 kb/s");
            return;
        }
        if (d2 < 1000.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "100 kb/s<speed<1000 kb/s");
            return;
        }
        if (d2 < 10000.0d) {
            ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "1 mb/s<speed<10 mb/s");
            return;
        }
        ReportDataAdapter.onEvent(context, str + EventConstant.DOWNLOAD_SPEED, "speed>10 mb/s");
    }

    public static String formatSize(Long l) {
        double dDoubleValue = l.doubleValue();
        double d2 = dDoubleValue / 1024.0d;
        double d3 = d2 / 1024.0d;
        double d4 = d3 / 1024.0d;
        double d5 = d4 / 1024.0d;
        if (d5 >= 1.0d) {
            return new BigDecimal(d5).setScale(2, 4).doubleValue() + " TB";
        }
        if (d4 >= 1.0d) {
            return new BigDecimal(d4).setScale(2, 4).doubleValue() + " GB";
        }
        if (d3 >= 1.0d) {
            return new BigDecimal(d3).setScale(2, 4).doubleValue() + " MB";
        }
        if (d2 >= 1.0d) {
            return new BigDecimal(d2).setScale(2, 4).doubleValue() + " KB";
        }
        return new BigDecimal(dDoubleValue).setScale(2, 4).doubleValue() + " B";
    }

    private static String formatString(long j, long j2) {
        if (j > j2) {
            j = j2;
        }
        return formatSize(Long.valueOf(j)) + "/" + formatSize(Long.valueOf(j2));
    }

    public static void updateDownloadGameProgressInfo(String str, GameProgressInfo gameProgressInfo) {
        updateDownloadIsDownload(str, gameProgressInfo);
        updateDownloadProgressValue(str, gameProgressInfo);
        updateDownloadProgressText(str, gameProgressInfo);
        updateDownloadIsFinish(str, gameProgressInfo);
        updateDownloadIsError(str, gameProgressInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateDownloadIsDownload(java.lang.String r3, com.sandboxol.center.download.entity.GameProgressInfo r4) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateDownloadIsDownload(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateDownloadIsError(java.lang.String r4, com.sandboxol.center.download.entity.GameProgressInfo r5) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateDownloadIsError(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateDownloadIsFinish(java.lang.String r3, com.sandboxol.center.download.entity.GameProgressInfo r4) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateDownloadIsFinish(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    private static void updateDownloadProgressText(String str, GameProgressInfo gameProgressInfo) {
        long jLongValue;
        long jLongValue2;
        String string = null;
        if (str != null) {
            if (EngineEnv.isOldEngine(gameProgressInfo.getIsNewEngine().get().intValue())) {
                GameProgressInfo gameProgressInfo2 = DownloadInfoCenter.getInstance().getGameProgressInfoMap().get(str);
                if (gameProgressInfo2 != null && gameProgressInfo2.getProgress().get().getTotalSize().longValue() > 0) {
                    string = BaseApplication.getContext().getString(R.string.base_res_downloading, gameProgressInfo2.getProgress().get().formatString());
                }
            } else if (CommonUtils.isNewEngineCommonGame(str)) {
                CommonGameProgressInfo commonGameProgressInfo = DownloadInfoCenter.getInstance().getCommonGameProgressInfo();
                CommonProgressInfo downloadCommonInfo = EngineEnv.getDownloadCommonInfo(gameProgressInfo.getIsNewEngine().get().intValue(), gameProgressInfo.getIsUgc().get().intValue());
                long jLongValue3 = commonGameProgressInfo.getProgress().get().getDownloadSize().longValue() + downloadCommonInfo.getProgress().get().getDownloadSize().longValue();
                long jLongValue4 = commonGameProgressInfo.getProgress().get().getTotalSize().longValue() + downloadCommonInfo.getProgress().get().getTotalSize().longValue();
                if (jLongValue4 > 0) {
                    string = BaseApplication.getContext().getString(R.string.base_res_downloading, formatString(jLongValue3, jLongValue4));
                }
            } else {
                GameProgressInfo gameProgressInfo3 = DownloadInfoCenter.getInstance().getGameProgressInfoMap().get(str);
                if (gameProgressInfo3 != null) {
                    jLongValue = gameProgressInfo3.getProgress().get().getDownloadSize().longValue() + 0;
                    jLongValue2 = gameProgressInfo3.getProgress().get().getTotalSize().longValue() + 0;
                } else {
                    jLongValue = 0;
                    jLongValue2 = 0;
                }
                CommonProgressInfo downloadCommonInfo2 = EngineEnv.getDownloadCommonInfo(gameProgressInfo.getIsNewEngine().get().intValue(), gameProgressInfo.getIsUgc().get().intValue());
                long jLongValue5 = jLongValue + downloadCommonInfo2.getProgress().get().getDownloadSize().longValue();
                long jLongValue6 = jLongValue2 + downloadCommonInfo2.getProgress().get().getTotalSize().longValue();
                if (jLongValue6 > 0) {
                    string = BaseApplication.getContext().getString(R.string.base_res_downloading, formatString(jLongValue5, jLongValue6));
                }
            }
        }
        if (string != null) {
            gameProgressInfo.getProgressText().set(string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateDownloadProgressValue(java.lang.String r8, com.sandboxol.center.download.entity.GameProgressInfo r9) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateDownloadProgressValue(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    public static void updateUnzipGameProgressInfo(String str, GameProgressInfo gameProgressInfo) {
        updateUnzipIsDownload(str, gameProgressInfo);
        updateUnzipProgressText(str, gameProgressInfo);
        updateUnzipIsFinish(str, gameProgressInfo);
        updateUnzipIsError(str, gameProgressInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateUnzipIsDownload(java.lang.String r3, com.sandboxol.center.download.entity.GameProgressInfo r4) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateUnzipIsDownload(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateUnzipIsError(java.lang.String r4, com.sandboxol.center.download.entity.GameProgressInfo r5) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateUnzipIsError(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateUnzipIsFinish(java.lang.String r3, com.sandboxol.center.download.entity.GameProgressInfo r4) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.download.utils.ProgressUtils.updateUnzipIsFinish(java.lang.String, com.sandboxol.center.download.entity.GameProgressInfo):void");
    }

    public static void updateUnzipProgressText(String str, GameProgressInfo gameProgressInfo) {
        String string = (str == null || gameProgressInfo.getProgressValue().get().intValue() != 100) ? null : BaseApplication.getContext().getString(R.string.base_game_detail_game_unzip);
        if (string != null) {
            gameProgressInfo.getProgressText().set(string);
        }
    }

    private static void updateUnzipProgressValue(String str, GameProgressInfo gameProgressInfo) {
        if (str != null) {
            if (EngineEnv.isOldEngine(gameProgressInfo.getIsNewEngine().get().intValue())) {
                GameProgressInfo gameProgressInfo2 = DownloadInfoCenter.getInstance().getGameProgressInfoMap().get(str);
                if (gameProgressInfo2 != null) {
                    iIntValue = gameProgressInfo2.getProgressValue().get().intValue();
                }
            } else if (CommonUtils.isNewEngineCommonGame(str)) {
                iIntValue = (DownloadInfoCenter.getInstance().getCommonGameProgressInfo().getProgressValue().get().intValue() + EngineEnv.getDownloadCommonInfo(gameProgressInfo.getIsNewEngine().get().intValue(), gameProgressInfo.getIsUgc().get().intValue()).getProgressValue().get().intValue()) / 2;
            } else {
                GameProgressInfo gameProgressInfo3 = DownloadInfoCenter.getInstance().getGameProgressInfoMap().get(str);
                iIntValue = ((gameProgressInfo3 != null ? 0 + gameProgressInfo3.getProgressValue().get().intValue() : 0) + EngineEnv.getDownloadCommonInfo(gameProgressInfo.getIsNewEngine().get().intValue(), gameProgressInfo.getIsUgc().get().intValue()).getProgressValue().get().intValue()) / 2;
            }
        }
        gameProgressInfo.getProgressValue().set(Integer.valueOf(iIntValue));
    }
}
