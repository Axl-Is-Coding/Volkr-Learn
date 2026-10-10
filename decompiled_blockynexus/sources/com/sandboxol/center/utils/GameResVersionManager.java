package com.sandboxol.center.utils;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GameResVersionManager {
    public static Map<String, String> defaultGameResVersionMap = new HashMap();

    public static long getOldGameResVersion(Game game, String str) {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        long gresVersion = (game.getLatestResVersions() == null || game.getLatestResVersions().getGresVersion() == 0) ? 0L : game.getLatestResVersions().getGresVersion();
        try {
            JSONObject jSONObject = new JSONObject(game.getIsNewEngine() == 1 ? defaultGameResVersionMap.get(StringConstant.KEY_DEFAULT_GAME_RES_VERSION_NEW_ENGINE) : defaultGameResVersionMap.get(StringConstant.KEY_DEFAULT_GAME_RES_VERSION_OLD_ENGINE));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                arrayList.add(String.valueOf(itKeys.next()));
            }
            if (arrayList.contains(str)) {
                j = jSONObject.getLong(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (CommonUtils.isNewEngineCommonGame(str)) {
            gresVersion = Math.max(gresVersion, SharedUtils.getLong(BaseApplication.getContext(), SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION));
        }
        return Math.max(gresVersion, j);
    }
}
