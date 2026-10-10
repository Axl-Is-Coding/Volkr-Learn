package com.localapi;

import com.alibaba.android.arouter.utils.Consts;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.vip.entity.VipDiamond;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class GameCatalog {
    private static final int CATALOG_VERSION = 4;
    private static final String[][] HALLS = {new String[]{StringConstant.BED_WAR_HALL_GAME_ID, "Bedwars", "g1008"}, new String[]{"g1042", "Pixel Hall", "g1043,g1044,g1045,g1053"}, new String[]{StringConstant.LUCKY_BLOCK_HALL_GAME_ID, "Lucky Block Hall", StringConstant.LUCKY_BLOCK_GAME_ID}};

    private GameCatalog() {
    }

    static synchronized void ensure(StateStore stateStore) {
        boolean z;
        JSONArray jSONArraySeedFromScriptSetting;
        JSONObject jSONObjectRoot = stateStore.root();
        boolean z2 = true;
        if (jSONObjectRoot.has("categories")) {
            z = false;
        } else {
            jSONObjectRoot.put("categories", generateCategories());
            z = true;
        }
        if (!jSONObjectRoot.has("games")) {
            JSONArray jSONArraySeedFromScriptSetting2 = seedFromScriptSetting(stateStore);
            if (jSONArraySeedFromScriptSetting2 != null) {
                jSONObjectRoot.put("catalogVersion", 4);
            }
            if (jSONArraySeedFromScriptSetting2 == null) {
                jSONArraySeedFromScriptSetting2 = generateGames(jSONObjectRoot.optJSONArray("categories"));
            }
            jSONObjectRoot.put("games", jSONArraySeedFromScriptSetting2);
            z = true;
        }
        if (ensureHalls(jSONObjectRoot)) {
            z = true;
        }
        if (jSONObjectRoot.optInt("catalogVersion", 0) < 4 && (jSONArraySeedFromScriptSetting = seedFromScriptSetting(stateStore)) != null) {
            jSONObjectRoot.put("games", jSONArraySeedFromScriptSetting);
            jSONObjectRoot.put("catalogVersion", 4);
            ensureHalls(jSONObjectRoot);
            L.i("catalog migrated to v4 (" + jSONArraySeedFromScriptSetting.length() + " real games)");
            z = true;
        }
        if (jSONObjectRoot.has("citizens")) {
            z2 = z;
        } else {
            jSONObjectRoot.put("citizens", generateCitizens());
        }
        if (!jSONObjectRoot.has("rankBoards")) {
            jSONObjectRoot.put("rankBoards", new JSONObject());
        }
        if (!jSONObjectRoot.has("shopProps")) {
            jSONObjectRoot.put("shopProps", new JSONObject());
        }
        if (!jSONObjectRoot.has("chatRooms")) {
            jSONObjectRoot.put("chatRooms", new JSONObject());
        }
        if (!jSONObjectRoot.has("nextPropId")) {
            jSONObjectRoot.put("nextPropId", 70001);
        }
        if (!jSONObjectRoot.has("nextRoomId")) {
            jSONObjectRoot.put("nextRoomId", 90001);
        }
        if (!jSONObjectRoot.has("gamePurchases")) {
            jSONObjectRoot.put("gamePurchases", new JSONArray());
        }
        if (ensurePremium(jSONObjectRoot) || z2) {
            L.i("catalog generated: " + jSONObjectRoot.optJSONArray("games").length() + " games, " + jSONObjectRoot.optJSONArray("categories").length() + " categories, " + jSONObjectRoot.optJSONArray("citizens").length() + " citizens");
            stateStore.save();
        }
    }

    private static boolean ensurePremium(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("games");
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("isPay") == 1) {
                return false;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("gameId", "5043");
        jSONObject2.put("gameTitle", "Mystic Vault");
        jSONObject2.put("gameName", "Mystic Vault");
        jSONObject2.put("gameCoverPic", "");
        jSONObject2.put("bannerPic", new JSONArray());
        jSONObject2.put("gameBannerVideoInfos", new JSONArray());
        jSONObject2.put("gameDetail", "A premium locally hosted experience. Unlock it once with diamonds — everything runs on your own server.");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("Mini Games");
        jSONObject2.put("gameTypes", jSONArray);
        jSONObject2.put(StringConstant.GAME_ORDER_TYPE_APPRECIATE, false);
        jSONObject2.put("gameMode", 1);
        jSONObject2.put("visitorEnter", 0);
        jSONObject2.put("version", 1);
        jSONObject2.put("isRankOnline", 1);
        jSONObject2.put("isShopOnline", 0);
        jSONObject2.put("isOpenParty", 0);
        jSONObject2.put("isPay", 1);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("qty", VipDiamond.MVP);
        jSONObject3.put("currency", 1);
        jSONObject3.put("orderType", 0);
        jSONObject3.put("productId", "premium_game_5043");
        jSONObject3.put("desc", "Unlock Mystic Vault");
        jSONObject2.put("gamePayInfo", jSONObject3);
        jSONObject2.put("turntableStatus", 0);
        jSONObject2.put("turntableRemainCount", 0);
        jSONObject2.put("isNewEngine", 0);
        jSONObject2.put("isUgcGame", 0);
        jSONObject2.put("gameUgcType", "");
        jSONObject2.put("currentPage", 0);
        jSONObject2.put("currentSize", 0);
        jSONObject2.put("resVersion", 1);
        jSONObject2.put("pageType", 0);
        jSONObject2.put("typeId", 106);
        jSONObject2.put("createTime", jCurrentTimeMillis);
        jSONObject2.put("complexNum", 1);
        jSONObject2.put("praiseNumber", 1);
        jSONObject2.put("onlineNumber", 1);
        jSONObject2.put(FirebaseAnalytics.Param.INDEX, 9999);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("cresVersion", 1);
        jSONObject4.put("dresVersion", 1);
        jSONObject4.put("gresVersion", 1);
        jSONObject2.put("latestResVersions", jSONObject4);
        jSONArrayOptJSONArray.put(jSONObject2);
        L.i("catalog: premium game 5043 (Mystic Vault) added");
        return true;
    }

    private static void applyHallTraits(JSONObject jSONObject, Map<String, JSONObject> map) throws JSONException {
        String strOptString = jSONObject.optString("scriptType", "");
        jSONObject.put("isLobby", 0);
        for (String[] strArr : HALLS) {
            if (strArr[0].equals(strOptString)) {
                jSONObject.put("isLobby", 1);
                jSONObject.put("gameTitle", strArr[1]);
                jSONObject.put("gameName", strArr[1]);
                JSONArray jSONArray = new JSONArray();
                if (map != null) {
                    for (String str : strArr[2].split(",")) {
                        JSONObject jSONObject2 = map.get(str);
                        if (jSONObject2 != null) {
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.put("realPlayGameList", jSONArray);
            }
        }
    }

    private static boolean ensureHalls(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("games");
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                map.put(jSONObjectOptJSONObject.optString("scriptType", ""), jSONObjectOptJSONObject);
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("scriptType", "");
                boolean z2 = false;
                for (String[] strArr : HALLS) {
                    if (strArr[0].equals(strOptString)) {
                        z2 = true;
                    }
                }
                if (!jSONObjectOptJSONObject2.has("isLobby") || (z2 && !jSONObjectOptJSONObject2.has("realPlayGameList"))) {
                    applyHallTraits(jSONObjectOptJSONObject2, map);
                    z = true;
                }
            }
        }
        if (z) {
            L.i("catalog: hall traits applied (isLobby + realPlayGameList)");
        }
        return z;
    }

    static synchronized boolean isOwned(StateStore stateStore, long j, String str) {
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("gamePurchases");
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j && str.equals(jSONObjectOptJSONObject.optString("gameId"))) {
                return true;
            }
        }
        return false;
    }

    static synchronized void recordPurchase(StateStore stateStore, long j, String str, long j2, int i, String str2) {
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("gamePurchases");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            stateStore.root().put("gamePurchases", jSONArrayOptJSONArray);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", j);
        jSONObject.put("gameId", str);
        jSONObject.put("price", j2);
        jSONObject.put("currency", i);
        jSONObject.put("orderId", str2);
        jSONObject.put("ts", System.currentTimeMillis());
        jSONArrayOptJSONArray.put(jSONObject);
    }

    private static JSONArray seedFromScriptSetting(StateStore stateStore) throws JSONException {
        File file = new File(stateStore.baseDir(), "games_seed.csv");
        JSONArray jSONArray = null;
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("categories");
        try {
            String[] strArrSplit = slurp(file).split("\r?\n");
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            int i2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (!strTrim.isEmpty() && i >= 2) {
                    String[] strArrSplit2 = strTrim.split("\t");
                    if (strArrSplit2.length >= 9) {
                        String strTrim2 = strArrSplit2[0].trim();
                        if (strTrim2.matches("g[0-9]+")) {
                            String strTrim3 = strArrSplit2[2].trim();
                            String strTrim4 = strArrSplit2[4].trim();
                            String strTrim5 = strArrSplit2[8].trim();
                            if (!strTrim3.equals("Sample") && !strTrim3.equals("Template") && !strTrim3.equals("GameTool")) {
                                long j = Long.parseLong(strTrim2.substring(1));
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("gameId", String.valueOf(j));
                                String strDisplayName = displayName(strTrim3);
                                jSONObject.put("gameTitle", strDisplayName);
                                jSONObject.put("gameName", strDisplayName);
                                jSONObject.put("remark", strTrim5);
                                jSONObject.put("scriptType", strTrim2);
                                jSONObject.put("mapName", strTrim4);
                                jSONObject.put("gameCoverPic", "");
                                jSONObject.put("bannerPic", new JSONArray());
                                jSONObject.put("gameBannerVideoInfos", new JSONArray());
                                jSONObject.put("gameDetail", String.valueOf(strTrim5) + " — running locally on your own server.");
                                long jCategoryIdFor = categoryIdFor(strTrim3, jSONArrayOptJSONArray);
                                JSONArray jSONArray3 = new JSONArray();
                                jSONArray3.put(categoryNameFor(jSONArrayOptJSONArray, jCategoryIdFor));
                                jSONObject.put("gameTypes", jSONArray3);
                                jSONObject.put(StringConstant.GAME_ORDER_TYPE_APPRECIATE, false);
                                jSONObject.put("gameMode", 1);
                                jSONObject.put("visitorEnter", 1);
                                jSONObject.put("version", 1);
                                jSONObject.put("isRankOnline", 1);
                                jSONObject.put("isShopOnline", 1);
                                jSONObject.put("isOpenParty", 1);
                                jSONObject.put("isPay", 0);
                                jSONObject.put("turntableStatus", 0);
                                jSONObject.put("turntableRemainCount", 0);
                                jSONObject.put("isNewEngine", 0);
                                jSONObject.put("isUgcGame", 0);
                                jSONObject.put("gameUgcType", "");
                                jSONObject.put("currentPage", 0);
                                jSONObject.put("currentSize", 0);
                                jSONObject.put("resVersion", 1);
                                jSONObject.put("pageType", 0);
                                jSONObject.put("typeId", jCategoryIdFor);
                                jSONObject.put("createTime", jCurrentTimeMillis - ((200 - ((long) i2)) * 86400000));
                                jSONObject.put("complexNum", ((i2 * 41) % 480) + 60);
                                jSONObject.put("praiseNumber", ((i2 * 97) % 4200) + 150);
                                jSONObject.put("onlineNumber", ((i2 * 59) % 2600) + 40);
                                int i3 = i2 + 1;
                                jSONObject.put(FirebaseAnalytics.Param.INDEX, i2);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("cresVersion", 1);
                                jSONObject2.put("dresVersion", 1);
                                jSONObject2.put("gresVersion", 1);
                                jSONObject.put("latestResVersions", jSONObject2);
                                jSONArray2.put(jSONObject);
                                i2 = i3;
                            }
                        }
                    }
                }
                i++;
                jSONArray = null;
            }
            if (jSONArray2.length() == 0) {
                return jSONArray;
            }
            L.i("catalog: seeded " + jSONArray2.length() + " real games from ScriptSetting");
            return jSONArray2;
        } catch (Throwable th) {
            L.e("catalog: games_seed.csv unreadable: " + th);
            return null;
        }
    }

    private static String displayName(String str) {
        return str.replaceAll("([a-z0-9])([A-Z])", "$1 $2").replaceAll("([A-Z]+)([A-Z][a-z])", "$1 $2");
    }

    private static long categoryIdFor(String str, JSONArray jSONArray) {
        String lowerCase = str.toLowerCase(Locale.US);
        boolean z = true;
        boolean z2 = lowerCase.contains("parkour") || lowerCase.equals("tntrun");
        boolean z3 = lowerCase.contains("skyblock") || lowerCase.contains("blockcity") || lowerCase.contains("tycoon") || lowerCase.contains("ranchers") || lowerCase.contains("lifting") || lowerCase.contains("bird") || lowerCase.contains("tinytown") || lowerCase.contains("lschampion");
        boolean z4 = lowerCase.contains("pixelgun") || lowerCase.contains("gunbattle") || lowerCase.contains("gbstrike") || lowerCase.equals("chicken") || lowerCase.contains("watchcar");
        if (!lowerCase.contains("murder") && !lowerCase.contains("hideandseek") && !lowerCase.contains("hashidden") && !lowerCase.contains("haschase") && !lowerCase.contains("hashall") && !lowerCase.contains("jailbreak")) {
            z = false;
        }
        long j = z2 ? 101L : z3 ? 102L : z ? 104L : z4 ? 105L : 103L;
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("typeId") == j) {
                return j;
            }
        }
        return (jSONArray == null || jSONArray.length() == 0) ? j : jSONArray.optJSONObject(0).optLong("typeId");
    }

    private static String categoryNameFor(JSONArray jSONArray, long j) {
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("typeId") == j) {
                return jSONObjectOptJSONObject.optString("typeName");
            }
        }
        return "";
    }

    private static String slurp(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[65536];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    private static JSONArray generateCategories() throws JSONException {
        String[][] strArr = {new String[]{"101", "Parkour", StringConstant.GAME_ORDER_TYPE_ONLINE}, new String[]{"102", "Sandbox", StringConstant.GAME_ORDER_TYPE_COMPLEX}, new String[]{"103", "PvP Arena", StringConstant.GAME_ORDER_TYPE_ONLINE}, new String[]{"104", "Role Play", StringConstant.GAME_ORDER_TYPE_APPRECIATE}, new String[]{"105", "Shooter", StringConstant.GAME_ORDER_TYPE_ONLINE}, new String[]{"106", "Mini Games", "new"}};
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 6; i++) {
            String[] strArr2 = strArr[i];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("typeId", Long.parseLong(strArr2[0]));
            jSONObject.put("typeName", strArr2[1]);
            jSONObject.put("iconUrl", "");
            jSONObject.put("iconResId", 0);
            jSONObject.put("sortType", strArr2[2]);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private static JSONArray generateGames(JSONArray jSONArray) throws JSONException {
        String[] strArr = {"Sky", "Desert", "Frozen", "Neon", "Jungle", "Lost", "Iron", "Cloud", "Ruby", "Shadow", "Golden", "Silent", "Wild", "Turbo", "Mystic", "Pixel", "Crystal", "Storm", "Nova", "Ancient", "Robo", "Candy", "Volcano", "Arctic"};
        String[] strArr2 = {"Islands", "Raiders", "Runners", "Builders", "Arena", "Legends", "Racers", "Craft", "Survival", "Battle", "Worlds", "Rush", "Quest", "Park", "Wars", "City", "Zones", "Tower", "Rift", "Kingdom"};
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < 42; i++) {
            JSONObject jSONObject = new JSONObject();
            long j = i + 5001;
            String str = String.valueOf(strArr[i % 24]) + " " + strArr2[((i * 7) + (i / 24)) % 20];
            JSONObject jSONObject2 = jSONArray.getJSONObject(i % length);
            int i2 = i % 9 == 4 ? 1 : 0;
            jSONObject.put("gameId", String.valueOf(j));
            jSONObject.put("gameTitle", str);
            jSONObject.put("gameName", str);
            String str2 = "";
            jSONObject.put("gameCoverPic", "");
            jSONObject.put("bannerPic", new JSONArray());
            jSONObject.put("gameBannerVideoInfos", new JSONArray());
            jSONObject.put("gameDetail", "A locally hosted " + jSONObject2.optString("typeName") + " experience. Everything runs on your own server.");
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(jSONObject2.optString("typeName"));
            jSONObject.put("gameTypes", jSONArray3);
            jSONObject.put(StringConstant.GAME_ORDER_TYPE_APPRECIATE, false);
            jSONObject.put("gameMode", 1);
            jSONObject.put("visitorEnter", 1);
            jSONObject.put("version", 1);
            jSONObject.put("isRankOnline", 1);
            jSONObject.put("isShopOnline", i % 3 == 0 ? 1 : 0);
            jSONObject.put("isOpenParty", i % 2 == 0 ? 1 : 0);
            jSONObject.put("isPay", 0);
            jSONObject.put("turntableStatus", 0);
            jSONObject.put("turntableRemainCount", 0);
            jSONObject.put("isNewEngine", 0);
            jSONObject.put("isUgcGame", i2);
            if (i2 != 0) {
                str2 = "ugc";
            }
            jSONObject.put("gameUgcType", str2);
            jSONObject.put("currentPage", 0);
            jSONObject.put("currentSize", 0);
            jSONObject.put("resVersion", 1);
            jSONObject.put("pageType", 0);
            jSONObject.put("typeId", jSONObject2.optLong("typeId"));
            jSONObject.put("createTime", jCurrentTimeMillis - ((42 - ((long) i)) * 86400000));
            jSONObject.put("complexNum", ((i * 37) % 460) + 40);
            jSONObject.put("praiseNumber", ((i * 91) % 3800) + 120);
            jSONObject.put("onlineNumber", ((i * 53) % 2400) + 30);
            jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cresVersion", 1);
            jSONObject3.put("dresVersion", 1);
            jSONObject3.put("gresVersion", 1);
            jSONObject.put("latestResVersions", jSONObject3);
            jSONArray2.put(jSONObject);
        }
        return jSONArray2;
    }

    private static JSONArray generateCitizens() throws JSONException {
        String[] strArr = {"Alex", "Rin", "Marco", "Zoe", "Kai", "Nina", "Theo", "Lua", "Omar", "Suki", "Finn", "Ada", "Diego", "Mira", "Jax", "Yuki", "Bram", "Lena", "Cleo", "Nico", "Tara", "Ravi", "Esme", "Otto", "Ines", "Hugo", "Nael", "Vera", "Emil", "Sana", "Luca", "Priya", "Beni", "Nova", "Ivan", "Tia"};
        String[] strArr2 = {"US", "BR", "ID", "PH", "MX", "EG", "IN", "TR", "VN", "TH", "ES", "AR"};
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 36; i++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", i + 20001);
            jSONObject.put("nickName", String.valueOf(strArr[i]) + (i + 100));
            jSONObject.put("sex", i % 2);
            jSONObject.put("country", strArr2[i % 12]);
            jSONObject.put("headPic", "");
            jSONObject.put("vip", i % 4);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    static JSONArray games(StateStore stateStore) {
        return stateStore.root().optJSONArray("games");
    }

    static synchronized JSONObject byId(StateStore stateStore, String str) {
        if (str == null) {
            return null;
        }
        JSONArray jSONArrayGames = games(stateStore);
        for (int i = 0; i < jSONArrayGames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayGames.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("gameId"))) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    static synchronized JSONArray page(StateStore stateStore, String str, long j, boolean z, int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArrayGames = games(stateStore);
        JSONArray jSONArray2 = new JSONArray();
        for (int i3 = 0; i3 < jSONArrayGames.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayGames.optJSONObject(i3);
            if (jSONObjectOptJSONObject != null && ((!z || jSONObjectOptJSONObject.optInt("isUgcGame") == 1) && (j <= 0 || jSONObjectOptJSONObject.optLong("typeId") == j))) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        if (str == null) {
            str = "";
        }
        for (int i4 = 1; i4 < jSONArray2.length(); i4++) {
            JSONObject jSONObject = jSONArray2.getJSONObject(i4);
            int i5 = i4 - 1;
            while (i5 >= 0 && compare(jSONArray2.getJSONObject(i5), jSONObject, str) > 0) {
                jSONArray2.put(i5 + 1, jSONArray2.getJSONObject(i5));
                i5--;
            }
            jSONArray2.put(i5 + 1, jSONObject);
        }
        if (i2 <= 0) {
            i2 = 20;
        }
        int iMax = Math.max(0, (i - 1) * i2);
        jSONArray = new JSONArray();
        for (int i6 = iMax; i6 < jSONArray2.length() && i6 < iMax + i2; i6++) {
            jSONArray.put(jSONArray2.get(i6));
        }
        return jSONArray;
    }

    static synchronized int count(StateStore stateStore, String str, long j, boolean z) {
        int i;
        JSONArray jSONArrayGames = games(stateStore);
        i = 0;
        for (int i2 = 0; i2 < jSONArrayGames.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayGames.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && ((!z || jSONObjectOptJSONObject.optInt("isUgcGame") == 1) && (j <= 0 || jSONObjectOptJSONObject.optLong("typeId") == j))) {
                i++;
            }
        }
        return i;
    }

    private static long metric(JSONObject jSONObject, String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != -1012222381) {
            if (iHashCode != 108960) {
                if (iHashCode == 550253784 && str.equals(StringConstant.GAME_ORDER_TYPE_APPRECIATE)) {
                    return jSONObject.optLong("praiseNumber");
                }
            } else if (str.equals("new")) {
                return jSONObject.optLong("createTime");
            }
        } else if (str.equals(StringConstant.GAME_ORDER_TYPE_ONLINE)) {
            return jSONObject.optLong("onlineNumber");
        }
        return jSONObject.optLong("complexNum");
    }

    private static int compare(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        long jMetric = metric(jSONObject, str);
        long jMetric2 = metric(jSONObject2, str);
        if (jMetric > jMetric2) {
            return -1;
        }
        return jMetric < jMetric2 ? 1 : 0;
    }

    static synchronized JSONArray list(StateStore stateStore, String str, long j, boolean z) {
        return page(stateStore, str, j, z, 1, 1073741823);
    }

    static synchronized JSONArray categories(StateStore stateStore) {
        return stateStore.root().optJSONArray("categories");
    }

    static synchronized JSONArray citizens(StateStore stateStore) {
        return stateStore.root().optJSONArray("citizens");
    }

    static synchronized JSONArray shopProps(StateStore stateStore, String str) {
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("shopProps");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null) {
            return jSONArrayOptJSONArray;
        }
        int i = 0;
        String[] strArr = {"Skin Pack", "Speed Boost", "Coin Bag", "Wings", "Pet Egg", "Trail FX"};
        JSONArray jSONArray = new JSONArray();
        int iAbs = (Math.abs(str.hashCode()) % ((jSONObjectOptJSONObject.length() == 0 ? 3 : 4) - 1)) + 3;
        while (i < iAbs) {
            JSONObject jSONObject = new JSONObject();
            int iOptInt = stateStore.root().optInt("nextPropId", 70001);
            stateStore.root().put("nextPropId", iOptInt + 1);
            jSONObject.put("id", iOptInt);
            int i2 = i + 1;
            jSONObject.put("name", String.valueOf(strArr[(Math.abs(str.hashCode()) + i) % 6]) + " " + i2);
            jSONObject.put("details", "Exclusive item for " + gameName(stateStore, str) + Consts.DOT);
            jSONObject.put("iconUrl", "");
            jSONObject.put("price", (Math.abs(str.hashCode() * (i + 3)) % 1900) + 100);
            jSONObject.put("currency", i % 2 == 0 ? 2 : 1);
            jSONObject.put("resourceId", "prop-" + str + "-" + i2);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1);
            jSONObject.put("validate", 1);
            jSONObject.put("expireDate", "");
            jSONArray.put(jSONObject);
            i = i2;
        }
        jSONObjectOptJSONObject.put(str, jSONArray);
        stateStore.save();
        return jSONArray;
    }

    private static String gameName(StateStore stateStore, String str) {
        JSONObject jSONObjectById = byId(stateStore, str);
        return jSONObjectById == null ? "this game" : jSONObjectById.optString("gameTitle");
    }

    static synchronized JSONArray rankBoard(StateStore stateStore, String str) {
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("rankBoards");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null) {
            return jSONArrayOptJSONArray;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayCitizens = citizens(stateStore);
        int iMin = Math.min(25, jSONArrayCitizens.length());
        int i = 0;
        while (i < iMin) {
            JSONObject jSONObject = jSONArrayCitizens.getJSONObject(i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userId", jSONObject.optLong("userId"));
            jSONObject2.put("nickName", jSONObject.optString("nickName"));
            jSONObject2.put("headPic", jSONObject.optString("headPic"));
            jSONObject2.put("vip", jSONObject.optInt("vip"));
            jSONObject2.put(StringConstant.REWARD_TYPE_INTEGRAL, 9800 - ((((Math.abs(str.hashCode()) + i) % 260) + 120) * i));
            jSONObject2.put("isFirst", i == 0);
            i++;
            jSONObject2.put("rank", i);
            jSONArray.put(jSONObject2);
        }
        jSONObjectOptJSONObject.put(str, jSONArray);
        stateStore.save();
        return jSONArray;
    }

    static synchronized void addIntegral(StateStore stateStore, String str, long j, String str2, int i, long j2) {
        if (j2 == 0) {
            return;
        }
        JSONArray jSONArrayRankBoard = rankBoard(stateStore, str);
        for (int i2 = 0; i2 < jSONArrayRankBoard.length(); i2++) {
            JSONObject jSONObject = jSONArrayRankBoard.getJSONObject(i2);
            if (jSONObject.optLong("userId") == j) {
                jSONObject.put(StringConstant.REWARD_TYPE_INTEGRAL, jSONObject.optLong(StringConstant.REWARD_TYPE_INTEGRAL) + j2);
                reRank(jSONArrayRankBoard);
                stateStore.save();
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", j);
        jSONObject2.put("nickName", str2);
        jSONObject2.put("headPic", "");
        jSONObject2.put("vip", i);
        jSONObject2.put(StringConstant.REWARD_TYPE_INTEGRAL, j2);
        jSONObject2.put("isFirst", false);
        jSONArrayRankBoard.put(jSONObject2);
        reRank(jSONArrayRankBoard);
        stateStore.save();
    }

    private static void reRank(JSONArray jSONArray) throws JSONException {
        for (int i = 1; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int i2 = i - 1;
            while (i2 >= 0 && jSONArray.getJSONObject(i2).optLong(StringConstant.REWARD_TYPE_INTEGRAL) < jSONObject.optLong(StringConstant.REWARD_TYPE_INTEGRAL)) {
                jSONArray.put(i2 + 1, jSONArray.getJSONObject(i2));
                i2--;
            }
            jSONArray.put(i2 + 1, jSONObject);
        }
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            int i4 = i3 + 1;
            jSONArray.getJSONObject(i3).put("rank", i4);
            jSONArray.getJSONObject(i3).put("isFirst", i3 == 0);
            i3 = i4;
        }
    }

    static synchronized String chatRoom(StateStore stateStore, String str) {
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("chatRooms");
        if (jSONObjectOptJSONObject.has(str)) {
            return jSONObjectOptJSONObject.optString(str);
        }
        String str2 = "local-room-" + stateStore.root().optInt("nextRoomId", 90001);
        stateStore.root().put("nextRoomId", stateStore.root().optInt("nextRoomId", 90001) + 1);
        jSONObjectOptJSONObject.put(str, str2);
        stateStore.save();
        return str2;
    }

    static synchronized boolean removeChatRoom(StateStore stateStore, String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("chatRooms");
                String[] names = JSONObject.getNames(jSONObjectOptJSONObject);
                boolean z = false;
                for (int i = 0; names != null && i < names.length; i++) {
                    if (str.equals(jSONObjectOptJSONObject.optString(names[i]))) {
                        jSONObjectOptJSONObject.remove(names[i]);
                        z = true;
                    }
                }
                if (z) {
                    stateStore.save();
                }
                return z;
            }
        }
        return false;
    }

    static synchronized void drift(StateStore stateStore) {
        int i;
        JSONArray jSONArrayGames = games(stateStore);
        long jCurrentTimeMillis = System.currentTimeMillis() / 3600000;
        boolean z = false;
        for (int i2 = 0; i2 < jSONArrayGames.length(); i2++) {
            JSONObject jSONObject = jSONArrayGames.getJSONObject(i2);
            if (jSONObject.optInt("isPay") != 1 && jSONObject.optInt("onlineNumber") != (i = ((i2 * 53) % 2400) + 30 + ((int) ((((long) (i2 + 7)) * jCurrentTimeMillis) % 220)))) {
                jSONObject.put("onlineNumber", i);
                z = true;
            }
        }
        if (z) {
            stateStore.save();
        }
    }
}
