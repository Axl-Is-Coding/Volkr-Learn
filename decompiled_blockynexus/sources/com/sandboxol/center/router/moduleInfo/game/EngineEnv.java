package com.sandboxol.center.router.moduleInfo.game;

import android.content.Context;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.download.entity.CommonProgressInfo;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes.dex */
public class EngineEnv {
    private static int curUseEngineTypeInGame;

    public static int getCurUseEngineTypeInGame() {
        return curUseEngineTypeInGame;
    }

    public static CommonProgressInfo getDownloadCommonInfo(int i, int i2) {
        return i == 1 ? i2 == 0 ? DownloadInfoCenter.getInstance().getCommonProgressInfo() : DownloadInfoCenter.getInstance().getCommonProgressInfoUgc() : DownloadInfoCenter.getInstance().getCommonProgressInfo();
    }

    public static AbstractEngineEnv getEngine(int i, int i2) {
        return i == 1 ? i2 == 0 ? EngineEnvFactory.v2() : EngineEnvFactory.v3() : EngineEnvFactory.v1();
    }

    public static String getEngineType(int i, int i2) {
        return i == 1 ? i2 == 0 ? "v2" : "v3" : "v1";
    }

    public static long getEngineVersion(int i, int i2) {
        return i == 1 ? i2 == 0 ? EngineEnvFactory.v2().getEngineVersion() : EngineEnvFactory.v3().getEngineVersion() : EngineEnvFactory.v1().getEngineVersion();
    }

    public static String getGameResDir(int i, int i2) {
        return i == 1 ? i2 == 0 ? "app_resourcesv2" : "app_resourcesv3" : "app_resources/Media";
    }

    public static AbstractEngineEnv getInstance(int i) {
        return i == 2 ? EngineEnvFactory.v2() : i == 3 ? EngineEnvFactory.v3() : EngineEnvFactory.v1();
    }

    public static void init() {
        EngineEnvFactory.v1();
        EngineEnvFactory.v2();
        EngineEnvFactory.v3();
    }

    public static boolean isEngineVersion(long j) {
        return j == EngineEnvFactory.v1().getEngineVersion() || j == EngineEnvFactory.v2().getEngineVersion() || j == EngineEnvFactory.v3().getEngineVersion();
    }

    public static boolean isOldEngine(int i) {
        return i == 0;
    }

    public static long loadCommonResVersion(Context context, int i, int i2) {
        return i == 1 ? i2 == 0 ? SharedUtils.getLong(context, SharedConstant.ENGINE_V2_COMMON_RES_VERSION) : SharedUtils.getLong(context, SharedConstant.ENGINE_V3_COMMON_RES_VERSION) : SharedUtils.getLong(context, SharedConstant.ENGINE_V1_COMMON_RES_VERSION);
    }

    public static void storeCommonResVersion(Context context, int i, int i2, long j) {
        if (i != 1) {
            SharedUtils.putLong(context, SharedConstant.ENGINE_V1_COMMON_RES_VERSION, j);
        } else if (i2 == 0) {
            SharedUtils.putLong(context, SharedConstant.ENGINE_V2_COMMON_RES_VERSION, j);
        } else {
            SharedUtils.putLong(context, SharedConstant.ENGINE_V3_COMMON_RES_VERSION, j);
        }
    }

    public static void switchEngine(int i, int i2) {
        if (i != 1) {
            v1();
        } else if (i2 == 0) {
            v2();
        } else {
            v3();
        }
    }

    public static AbstractEngineEnv v1() {
        curUseEngineTypeInGame = 1;
        return EngineEnvFactory.v1();
    }

    public static AbstractEngineEnv v2() {
        curUseEngineTypeInGame = 2;
        return EngineEnvFactory.v2();
    }

    public static AbstractEngineEnv v3() {
        curUseEngineTypeInGame = 3;
        return EngineEnvFactory.v3();
    }
}
