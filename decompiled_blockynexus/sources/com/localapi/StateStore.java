package com.localapi;

import com.alibaba.android.arouter.utils.Consts;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TimeUtil;
import com.umeng.analytics.pro.au;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import io.rong.imlib.common.RongLibConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class StateStore {
    private final File file;
    private JSONObject root;

    public StateStore(File file) throws JSONException {
        File file2 = new File(file, "localapi");
        file2.mkdirs();
        this.file = new File(file2, "state.json");
        load();
    }

    public File baseDir() {
        return this.file.getParentFile();
    }

    private void load() throws JSONException {
        this.root = new JSONObject();
        if (recoverFrom(new File(this.file.getParentFile(), "state.json.tmp"))) {
            return;
        }
        try {
            if (this.file.exists()) {
                int length = (int) this.file.length();
                byte[] bArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(this.file);
                int i = 0;
                while (i < length) {
                    int i2 = fileInputStream.read(bArr, i, length - i);
                    if (i2 < 0) {
                        break;
                    } else {
                        i += i2;
                    }
                }
                fileInputStream.close();
                if (i > 0) {
                    this.root = new JSONObject(new String(bArr, 0, i, StandardCharsets.UTF_8));
                    return;
                }
            }
        } catch (Throwable th) {
            L.e("state load failed, starting fresh: " + th);
            this.root = new JSONObject();
        }
        if (!this.root.has("nextUserId")) {
            this.root.put("nextUserId", 10001);
        }
        if (!this.root.has("users")) {
            this.root.put("users", new JSONObject());
        }
        if (!this.root.has("tokens")) {
            this.root.put("tokens", new JSONObject());
        }
        if (!this.root.has("mailSeq")) {
            this.root.put("mailSeq", 1);
        }
        save();
    }

    private boolean recoverFrom(File file) {
        if (file.exists() && file.length() != 0) {
            try {
                int length = (int) file.length();
                byte[] bArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(file);
                int i = 0;
                while (i < length) {
                    int i2 = fileInputStream.read(bArr, i, length - i);
                    if (i2 < 0) {
                        break;
                    }
                    i += i2;
                }
                fileInputStream.close();
                if (i <= 0) {
                    return false;
                }
                this.root = new JSONObject(new String(bArr, 0, i, StandardCharsets.UTF_8));
                L.e("state recovered from state.json.tmp (crash before rename)");
                save();
                return true;
            } catch (Throwable th) {
                L.e("state.json.tmp recovery failed, falling back: " + th);
            }
        }
        return false;
    }

    public synchronized void save() {
        try {
            File file = new File(this.file.getParentFile(), "state.json.tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.root.toString().getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            if (!file.renameTo(this.file)) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.file);
                fileOutputStream2.write(this.root.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream2.close();
                file.delete();
            }
        } finally {
        }
    }

    public synchronized JSONObject root() {
        return this.root;
    }

    JSONObject users() {
        return this.root.optJSONObject("users");
    }

    private JSONObject tokens() {
        return this.root.optJSONObject("tokens");
    }

    public synchronized int userCount() {
        return users().length();
    }

    private synchronized long nextUserId() {
        long jOptLong;
        jOptLong = this.root.optLong("nextUserId", 10001L);
        this.root.put("nextUserId", 1 + jOptLong);
        return jOptLong;
    }

    public synchronized JSONObject findByKey(String str) {
        return users().optJSONObject(str);
    }

    public synchronized JSONObject findByAccount(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                JSONArray jSONArrayNames = users().names();
                if (jSONArrayNames == null) {
                    return null;
                }
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = users().optJSONObject(jSONArrayNames.optString(i));
                    if (jSONObjectOptJSONObject != null && str.equalsIgnoreCase(jSONObjectOptJSONObject.optString(GameSharedConstant.ACCOUNT))) {
                        return jSONObjectOptJSONObject;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public synchronized JSONObject findByUserId(long j) {
        JSONArray jSONArrayNames = users().names();
        if (jSONArrayNames == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = users().optJSONObject(jSONArrayNames.optString(i));
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public synchronized JSONObject findByToken(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                long jOptLong = tokens().optLong(str, 0L);
                return jOptLong > 0 ? findByUserId(jOptLong) : null;
            }
        }
        return null;
    }

    public synchronized JSONObject findByStarCode(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                JSONArray jSONArrayNames = users().names();
                if (jSONArrayNames == null) {
                    return null;
                }
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = users().optJSONObject(jSONArrayNames.optString(i));
                    if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("starCode"))) {
                        return jSONObjectOptJSONObject;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public synchronized boolean isOnline(long j) {
        JSONObject jSONObject = tokens();
        JSONArray jSONArrayNames = jSONObject.names();
        int i = 0;
        while (jSONArrayNames != null) {
            if (i >= jSONArrayNames.length()) {
                break;
            }
            if (jSONObject.optLong(jSONArrayNames.optString(i)) == j) {
                return true;
            }
            i++;
        }
        return false;
    }

    public synchronized JSONObject findOrCreateByKey(String str, boolean z) {
        JSONObject jSONObjectOptJSONObject = users().optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        JSONObject jSONObjectNewUser = newUser(z);
        jSONObjectNewUser.put("key", str);
        users().put(str, jSONObjectNewUser);
        save();
        return jSONObjectNewUser;
    }

    public synchronized JSONObject createAccount(String str, String str2, String str3) {
        if (users().optJSONObject(str) != null) {
            return null;
        }
        boolean z = false;
        JSONObject jSONObjectNewUser = newUser(false);
        jSONObjectNewUser.put("key", str);
        jSONObjectNewUser.put("password", str2 == null ? "" : str2);
        if (str2 != null && !str2.isEmpty()) {
            z = true;
        }
        jSONObjectNewUser.put("hasPassword", z);
        if (str3 == null || str3.isEmpty()) {
            str3 = str;
        }
        jSONObjectNewUser.put("nickName", str3);
        users().put(str, jSONObjectNewUser);
        save();
        return jSONObjectNewUser;
    }

    private JSONObject newUser(boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long jNextUserId = nextUserId();
        jSONObject.put("userId", jNextUserId);
        jSONObject.put(GameSharedConstant.ACCOUNT, "");
        jSONObject.put("nickName", (z ? new StringBuilder("Guest") : new StringBuilder("Player")).append(jNextUserId).toString());
        jSONObject.put("sex", 0);
        jSONObject.put("picUrl", "");
        jSONObject.put("details", "");
        jSONObject.put("telephone", "");
        jSONObject.put("email", "");
        jSONObject.put("birthday", "");
        jSONObject.put(StringConstant.CHRISTMAS_GOLDS, 50000L);
        jSONObject.put(StringConstant.CHRISTMAS_DIAMONDS, 50000L);
        jSONObject.put("gDiamonds", 5000L);
        jSONObject.put("password", "");
        jSONObject.put("isFirstLogin", true);
        jSONObject.put("expireDate", "");
        jSONObject.put("vip", 0);
        jSONObject.put("hasPassword", !z);
        jSONObject.put("platform", "android");
        jSONObject.put("starCode", "");
        return jSONObject;
    }

    public synchronized String issueToken(JSONObject jSONObject) {
        String str;
        str = "local-" + jSONObject.optLong("userId") + "-" + Long.toHexString(System.nanoTime());
        tokens().put(str, jSONObject.optLong("userId"));
        jSONObject.put("accessToken", str);
        save();
        return str;
    }

    public synchronized void dropToken(String str) {
        if (str != null) {
            tokens().remove(str);
            save();
        }
    }

    public synchronized JSONObject resolve(String str, String str2) {
        JSONObject jSONObjectFindByToken = findByToken(str);
        if (jSONObjectFindByToken != null) {
            return jSONObjectFindByToken;
        }
        if (str2 != null) {
            try {
                JSONObject jSONObjectFindByUserId = findByUserId(Long.parseLong(str2.trim()));
                if (jSONObjectFindByUserId != null) {
                    return jSONObjectFindByUserId;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return findOrCreateByKey("ghost", true);
    }

    public synchronized JSONObject userState(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        jSONObjectOptJSONObject = jSONObject.optJSONObject(ServerProtocol.DIALOG_PARAM_STATE);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("playedGames", new JSONArray());
            jSONObjectOptJSONObject.put("signIns", new JSONArray());
            jSONObjectOptJSONObject.put("adRewards", new JSONObject());
            jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, jSONObjectOptJSONObject);
        }
        return jSONObjectOptJSONObject;
    }

    public synchronized void recordPlay(JSONObject jSONObject, String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                JSONObject jSONObjectUserState = userState(jSONObject);
                JSONArray jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("playedGames");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("gameId", str);
                jSONObject2.put("at", System.currentTimeMillis());
                jSONArray.put(jSONObject2);
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length() && jSONArray.length() < 30; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && !str.equals(jSONObjectOptJSONObject.optString("gameId"))) {
                            jSONArray.put(jSONObjectOptJSONObject);
                        }
                    }
                }
                jSONObjectUserState.put("playedGames", jSONArray);
                save();
            }
        }
    }

    public synchronized JSONArray recentGames(JSONObject jSONObject, int i) {
        JSONArray jSONArrayOptJSONArray = userState(jSONObject).optJSONArray("playedGames");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray == null) {
            return jSONArray;
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length() && jSONArray.length() < i; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                jSONArray.put(jSONObjectOptJSONObject.optString("gameId"));
            }
        }
        return jSONArray;
    }

    public synchronized void award(JSONObject jSONObject, String str, long j) {
        if (j == 0) {
            return;
        }
        jSONObject.put(str, jSONObject.optLong(str) + j);
        save();
    }

    public synchronized int adRewardCount(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        jSONObjectOptJSONObject = userState(jSONObject).optJSONObject("adRewards");
        return (jSONObjectOptJSONObject == null || !str.equals(jSONObjectOptJSONObject.optString("date"))) ? 0 : jSONObjectOptJSONObject.optInt("count");
    }

    public synchronized void countAdReward(JSONObject jSONObject, String str) {
        JSONObject jSONObjectUserState = userState(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("adRewards");
        if (jSONObjectOptJSONObject == null || !str.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", str);
            jSONObjectOptJSONObject.put("count", 0);
        }
        jSONObjectOptJSONObject.put("count", jSONObjectOptJSONObject.optInt("count") + 1);
        jSONObjectUserState.put("adRewards", jSONObjectOptJSONObject);
        save();
    }

    public synchronized JSONArray signIns(JSONObject jSONObject) {
        return userState(jSONObject).optJSONArray("signIns");
    }

    public synchronized JSONObject issueMiniToken(long j, String str, String str2, int i) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject = this.root.optJSONObject("miniTokens");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            this.root.put("miniTokens", jSONObjectOptJSONObject);
        }
        jSONObject = new JSONObject();
        jSONObject.put("userId", j);
        if (str == null) {
            str = "";
        }
        jSONObject.put("gameType", str);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("mapName", str2);
        jSONObject.put("region", i);
        jSONObject.put("requestId", Long.toHexString(System.nanoTime()));
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, Long.toHexString(Double.doubleToLongBits(Math.random())));
        jSONObject.put("timestamp", System.currentTimeMillis());
        String str3 = "mg-" + j + "-" + Long.toHexString(System.nanoTime());
        jSONObjectOptJSONObject.put(str3, jSONObject);
        for (JSONArray jSONArrayNames = jSONObjectOptJSONObject.names(); jSONArrayNames != null && jSONArrayNames.length() > 40; jSONArrayNames = jSONObjectOptJSONObject.names()) {
            long j2 = Long.MAX_VALUE;
            String str4 = null;
            for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                String strOptString = jSONArrayNames.optString(i2);
                if (!strOptString.equals(str3)) {
                    long jOptLong = jSONObjectOptJSONObject.optJSONObject(strOptString) == null ? 0L : jSONObjectOptJSONObject.optJSONObject(strOptString).optLong("timestamp");
                    if (jOptLong < j2) {
                        str4 = strOptString;
                        j2 = jOptLong;
                    }
                }
            }
            if (str4 == null) {
                break;
            }
            jSONObjectOptJSONObject.remove(str4);
        }
        save();
        jSONObject.put(RongLibConst.KEY_TOKEN, str3);
        return jSONObject;
    }

    public synchronized JSONObject findMiniToken(String str) {
        JSONObject jSONObjectOptJSONObject = null;
        if (str != null) {
            if (!str.isEmpty()) {
                JSONObject jSONObjectOptJSONObject2 = this.root.optJSONObject("miniTokens");
                if (jSONObjectOptJSONObject2 != null) {
                    jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(str);
                }
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public synchronized String storeFile(byte[] bArr, String str, String str2, long j) {
        if (bArr != null) {
            if (bArr.length != 0) {
                if (bArr.length > 4194304) {
                    return null;
                }
                JSONObject jSONObjectOptJSONObject = this.root.optJSONObject("files");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    this.root.put("files", jSONObjectOptJSONObject);
                }
                String str3 = "f" + Long.toHexString(System.nanoTime()) + Long.toHexString(Double.doubleToLongBits(Math.random()));
                File file = new File(this.file.getParentFile(), "files");
                file.mkdirs();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str3));
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    JSONObject jSONObject = new JSONObject();
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("fileName", str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("fileType", str2);
                    jSONObject.put("uploaderId", j);
                    jSONObject.put("size", bArr.length);
                    jSONObject.put("createdAt", System.currentTimeMillis());
                    jSONObjectOptJSONObject.put(str3, jSONObject);
                    save();
                    return str3;
                } catch (Throwable th) {
                    L.e("file store failed: " + th);
                    return null;
                }
            }
        }
        return null;
    }

    public synchronized JSONObject fileMeta(String str) {
        JSONObject jSONObjectOptJSONObject;
        jSONObjectOptJSONObject = this.root.optJSONObject("files");
        return jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONObject(str);
    }

    public synchronized byte[] readFile(String str) {
        if (str != null) {
            if (!str.isEmpty() && !str.contains("/") && !str.contains("\\") && !str.equals(Consts.DOT) && !str.equals("..")) {
                try {
                    File file = new File(this.file.getParentFile(), "files");
                    File file2 = new File(file, str);
                    if (!file2.getCanonicalPath().startsWith(String.valueOf(file.getCanonicalPath()) + File.separator)) {
                        return null;
                    }
                    if (file2.exists() && file2.isFile()) {
                        int length = (int) file2.length();
                        byte[] bArr = new byte[length];
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        int i = 0;
                        while (i < length) {
                            int i2 = fileInputStream.read(bArr, i, length - i);
                            if (i2 < 0) {
                                break;
                            }
                            i += i2;
                        }
                        fileInputStream.close();
                        return bArr;
                    }
                    return null;
                } catch (Throwable th) {
                    L.e("file read failed: " + th);
                    return null;
                }
            }
        }
        return null;
    }

    public synchronized boolean hasSignedIn(JSONObject jSONObject, String str) {
        JSONArray jSONArraySignIns = signIns(jSONObject);
        if (jSONArraySignIns != null) {
            for (int i = 0; i < jSONArraySignIns.length(); i++) {
                if (str.equals(jSONArraySignIns.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized void markSignedIn(JSONObject jSONObject, String str) {
        if (hasSignedIn(jSONObject, str)) {
            return;
        }
        JSONArray jSONArraySignIns = signIns(jSONObject);
        if (jSONArraySignIns == null) {
            jSONArraySignIns = new JSONArray();
            userState(jSONObject).put("signIns", jSONArraySignIns);
        }
        jSONArraySignIns.put(str);
        save();
    }

    public synchronized JSONArray mails(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectUserState = userState(jSONObject);
        jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("mails");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectUserState.put("mails", jSONArrayOptJSONArray);
        }
        return jSONArrayOptJSONArray;
    }

    public synchronized long nextMailId() {
        long jOptLong;
        jOptLong = this.root.optLong("mailSeq", 1L);
        this.root.put("mailSeq", 1 + jOptLong);
        return jOptLong;
    }

    public synchronized JSONObject addMail(JSONObject jSONObject, String str, String str2, int i, String str3, JSONArray jSONArray) {
        JSONObject jSONObject2;
        jSONObject2 = new JSONObject();
        jSONObject2.put("id", nextMailId());
        if (str == null) {
            str = "";
        }
        jSONObject2.put("title", str);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject2.put("content", str2);
        jSONObject2.put("type", i);
        if (str3 == null) {
            str3 = "";
        }
        jSONObject2.put("extra", str3);
        jSONObject2.put("sendDate", System.currentTimeMillis());
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        jSONObject2.put(MessengerShareContentUtility.ATTACHMENT, jSONArray);
        mails(jSONObject).put(jSONObject2);
        save();
        return jSONObject2;
    }

    public synchronized JSONObject findMail(JSONObject jSONObject, long j) {
        JSONArray jSONArrayMails = mails(jSONObject);
        for (int i = 0; i < jSONArrayMails.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMails.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("id") == j) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public synchronized boolean markMail(JSONObject jSONObject, long j, int i) {
        JSONObject jSONObjectFindMail = findMail(jSONObject, j);
        if (jSONObjectFindMail == null) {
            return false;
        }
        jSONObjectFindMail.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i);
        save();
        return true;
    }

    public synchronized boolean deleteMail(JSONObject jSONObject, long j) {
        JSONArray jSONArrayMails = mails(jSONObject);
        for (int i = 0; i < jSONArrayMails.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMails.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("id") == j) {
                jSONArrayMails.remove(i);
                save();
                return true;
            }
        }
        return false;
    }

    public synchronized void recordEngineReport(String str, int i, String str2) {
        JSONArray jSONArrayOptJSONArray = this.root.optJSONArray("engineReports");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            this.root.put("engineReports", jSONArrayOptJSONArray);
        }
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject.put("engineVersion", str);
        jSONObject.put("newEngineVersion", i);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("country", str2);
        jSONObject.put("at", System.currentTimeMillis());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length() && jSONArray.length() < 20; i2++) {
            jSONArray.put(jSONArrayOptJSONArray.optJSONObject(i2));
        }
        this.root.put("engineReports", jSONArray);
        save();
    }

    public synchronized JSONObject campaignSignIn(JSONObject jSONObject) {
        return userState(jSONObject).optJSONObject("campaignSignIn");
    }

    public synchronized void putCampaignSignIn(JSONObject jSONObject, JSONObject jSONObject2) {
        userState(jSONObject).put("campaignSignIn", jSONObject2);
        save();
    }

    public synchronized boolean campaignSignedOn(JSONObject jSONObject, String str) {
        JSONObject jSONObjectCampaignSignIn = campaignSignIn(jSONObject);
        if (jSONObjectCampaignSignIn != null) {
            if (str.equals(jSONObjectCampaignSignIn.optString("lastDate"))) {
                return true;
            }
        }
        return false;
    }

    public synchronized JSONObject turntableDraw(JSONObject jSONObject) {
        return userState(jSONObject).optJSONObject("turntableDraw");
    }

    public synchronized void putTurntableDraw(JSONObject jSONObject, String str, long j, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("date", str);
        jSONObject2.put("prizeId", j);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject2.put("gameId", str2);
        userState(jSONObject).put("turntableDraw", jSONObject2);
        save();
    }

    public synchronized boolean turntableFreeToday(JSONObject jSONObject, String str) {
        JSONObject jSONObjectTurntableDraw = turntableDraw(jSONObject);
        if (jSONObjectTurntableDraw != null) {
            if (str.equals(jSONObjectTurntableDraw.optString("date"))) {
                return false;
            }
        }
        return true;
    }

    public static String utcDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public synchronized JSONObject activityProgress(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectUserState = userState(jSONObject);
        jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("activity");
        String strUtcDay = utcDay();
        if (jSONObjectOptJSONObject == null || !strUtcDay.equals(jSONObjectOptJSONObject.optString("day"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("day", strUtcDay);
            jSONObjectOptJSONObject.put("onlineMinutes", 0);
            jSONObjectOptJSONObject.put("lastMinute", "");
            jSONObjectOptJSONObject.put("lastDayLogin", "");
            jSONObjectOptJSONObject.put("claimed", new JSONObject());
            jSONObjectUserState.put("activity", jSONObjectOptJSONObject);
            save();
        }
        return jSONObjectOptJSONObject;
    }

    public synchronized void tickActivityMinute(JSONObject jSONObject, String str) {
        JSONObject jSONObjectActivityProgress = activityProgress(jSONObject);
        if (str.equals(jSONObjectActivityProgress.optString("lastMinute"))) {
            return;
        }
        jSONObjectActivityProgress.put("lastMinute", str);
        jSONObjectActivityProgress.put("onlineMinutes", jSONObjectActivityProgress.optInt("onlineMinutes") + 1);
        if (jSONObjectActivityProgress.optString("lastDayLogin").isEmpty()) {
            jSONObjectActivityProgress.put("lastDayLogin", utcDay());
        }
        save();
    }

    public synchronized boolean activityClaimedToday(JSONObject jSONObject, String str, long j) {
        JSONObject jSONObjectOptJSONObject = activityProgress(jSONObject).optJSONObject("claimed");
        if (jSONObjectOptJSONObject != null) {
            if (str.equals(jSONObjectOptJSONObject.optString(au.at + j))) {
                return true;
            }
        }
        return false;
    }

    public synchronized void markActivityClaimed(JSONObject jSONObject, String str, long j) {
        JSONObject jSONObjectActivityProgress = activityProgress(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObjectActivityProgress.optJSONObject("claimed");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectActivityProgress.put("claimed", jSONObjectOptJSONObject);
        }
        jSONObjectOptJSONObject.put(au.at + j, str);
        save();
    }

    public synchronized int appendReport(String str, String str2) {
        File file;
        try {
            String str3 = new SimpleDateFormat(TimeUtil.DEFAULT_DAY_NO_SEPRATOR_FORMAT, Locale.US).format(new Date());
            File file2 = new File(this.file.getParentFile(), "datareport");
            file2.mkdirs();
            file = new File(file2, String.valueOf(str) + "-" + str3 + ".jsonl");
            StringBuilder sb = new StringBuilder("{\"ts\":");
            sb.append(System.currentTimeMillis());
            sb.append(",\"body\":");
            if (str2 == null || str2.isEmpty()) {
                str2 = "null";
            }
            sb.append(str2);
            sb.append("}\n");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (Throwable th) {
            L.e("report append failed: " + th);
            return -1;
        }
        return countLines(file);
    }

    private static int countLines(File file) {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            int i = 0;
            while (lineNumberReader.readLine() != null) {
                i++;
            }
            lineNumberReader.close();
            return i;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
