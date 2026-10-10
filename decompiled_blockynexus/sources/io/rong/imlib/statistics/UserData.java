package io.rong.imlib.statistics;

import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UserData {
    public static final String BYEAR_KEY = "byear";
    public static final String CUSTOM_KEY = "custom";
    public static final String EMAIL_KEY = "email";
    public static final String GENDER_KEY = "gender";
    public static final String NAME_KEY = "name";
    public static final String ORG_KEY = "organization";
    public static final String PHONE_KEY = "phone";
    public static final String PICTURE_KEY = "picture";
    public static final String PICTURE_PATH_KEY = "picturePath";
    public static final String USERNAME_KEY = "username";
    public static int byear = 0;
    public static Map<String, String> custom = null;
    public static String email = null;
    public static String gender = null;
    public static boolean isSynced = true;
    public static String name;

    /* JADX INFO: renamed from: org, reason: collision with root package name */
    public static String f22801org;
    public static String phone;
    public static String picture;
    public static String picturePath;
    public static String username;

    static void fromJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            name = jSONObject.optString("name", null);
            username = jSONObject.optString(USERNAME_KEY, null);
            email = jSONObject.optString("email", null);
            f22801org = jSONObject.optString(ORG_KEY, null);
            phone = jSONObject.optString("phone", null);
            picture = jSONObject.optString("picture", null);
            gender = jSONObject.optString(GENDER_KEY, null);
            byear = jSONObject.optInt(BYEAR_KEY, 0);
            if (jSONObject.isNull(CUSTOM_KEY)) {
                return;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(CUSTOM_KEY);
                HashMap map = new HashMap(jSONObject2.length());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject2.isNull(next)) {
                        map.put(next, jSONObject2.getString(next));
                    }
                }
            } catch (JSONException e2) {
                if (Statistics.sharedInstance().isLoggingEnabled()) {
                    Log.w("Statistics", "Got exception converting an Custom Json to Custom User data", e2);
                }
            }
        }
    }

    static String getDataForRequest() {
        String str;
        String strEncode;
        if (!isSynced) {
            isSynced = true;
            JSONObject json = toJSON();
            if (json != null) {
                String string = json.toString();
                try {
                    strEncode = URLEncoder.encode(string, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                if (strEncode != null && !strEncode.equals("")) {
                    string = "&user_details=" + strEncode;
                    if (picturePath != null) {
                        str = string + "&picturePath=" + URLEncoder.encode(picturePath, "UTF-8");
                    } else {
                        str = string;
                    }
                } else if (picturePath != null) {
                    str = "&user_details&picturePath=" + URLEncoder.encode(picturePath, "UTF-8");
                } else {
                    str = "";
                }
                if (str != null) {
                    return str;
                }
            }
        }
        return "";
    }

    public static String getPicturePathFromQuery(URL url) {
        String query = url.getQuery();
        if (query == null) {
            return "";
        }
        String[] strArrSplit = query.split("&");
        if (!url.getQuery().contains(PICTURE_PATH_KEY)) {
            return "";
        }
        for (String str : strArrSplit) {
            int iIndexOf = str.indexOf("=");
            if (str.substring(0, iIndexOf).equals(PICTURE_PATH_KEY)) {
                try {
                    return URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    return "";
                }
            }
        }
        return "";
    }

    static void setCustomData(Map<String, String> map) {
        custom = new HashMap();
        custom.putAll(map);
        isSynced = false;
    }

    static void setData(Map<String, String> map) {
        if (map.containsKey("name")) {
            name = map.get("name");
        }
        if (map.containsKey(USERNAME_KEY)) {
            username = map.get(USERNAME_KEY);
        }
        if (map.containsKey("email")) {
            email = map.get("email");
        }
        if (map.containsKey(ORG_KEY)) {
            f22801org = map.get(ORG_KEY);
        }
        if (map.containsKey("phone")) {
            phone = map.get("phone");
        }
        if (map.containsKey(PICTURE_PATH_KEY)) {
            picturePath = map.get(PICTURE_PATH_KEY);
        }
        String str = picturePath;
        if (str != null && !new File(str).isFile()) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.w("Statistics", "Provided file " + picturePath + " can not be opened");
            }
            picturePath = null;
        }
        if (map.containsKey("picture")) {
            picture = map.get("picture");
        }
        if (map.containsKey(GENDER_KEY)) {
            gender = map.get(GENDER_KEY);
        }
        if (map.containsKey(BYEAR_KEY)) {
            try {
                byear = Integer.parseInt(map.get(BYEAR_KEY));
            } catch (NumberFormatException unused) {
                if (Statistics.sharedInstance().isLoggingEnabled()) {
                    Log.w("Statistics", "Incorrect byear number format");
                }
                byear = 0;
            }
        }
        isSynced = false;
    }

    static JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (name != null) {
                if (name == "") {
                    jSONObject.put("name", JSONObject.NULL);
                } else {
                    jSONObject.put("name", name);
                }
            }
            if (username != null) {
                if (username == "") {
                    jSONObject.put(USERNAME_KEY, JSONObject.NULL);
                } else {
                    jSONObject.put(USERNAME_KEY, username);
                }
            }
            if (email != null) {
                if (email == "") {
                    jSONObject.put("email", JSONObject.NULL);
                } else {
                    jSONObject.put("email", email);
                }
            }
            if (f22801org != null) {
                if (f22801org == "") {
                    jSONObject.put(ORG_KEY, JSONObject.NULL);
                } else {
                    jSONObject.put(ORG_KEY, f22801org);
                }
            }
            if (phone != null) {
                if (phone == "") {
                    jSONObject.put("phone", JSONObject.NULL);
                } else {
                    jSONObject.put("phone", phone);
                }
            }
            if (picture != null) {
                if (picture == "") {
                    jSONObject.put("picture", JSONObject.NULL);
                } else {
                    jSONObject.put("picture", picture);
                }
            }
            if (gender != null) {
                if (gender == "") {
                    jSONObject.put(GENDER_KEY, JSONObject.NULL);
                } else {
                    jSONObject.put(GENDER_KEY, gender);
                }
            }
            if (byear != 0) {
                if (byear > 0) {
                    jSONObject.put(BYEAR_KEY, byear);
                } else {
                    jSONObject.put(BYEAR_KEY, JSONObject.NULL);
                }
            }
            if (custom != null) {
                if (custom.isEmpty()) {
                    jSONObject.put(CUSTOM_KEY, JSONObject.NULL);
                } else {
                    jSONObject.put(CUSTOM_KEY, new JSONObject(custom));
                }
            }
        } catch (JSONException e2) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.w("Statistics", "Got exception converting an UserData to JSON", e2);
            }
        }
        return jSONObject;
    }
}
