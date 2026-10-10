package b.e.a.a.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WindowManager f2576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f2577b = {"x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static float f2578c = Resources.getSystem().getDisplayMetrics().density;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f2579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f2580b;

        a(float f2, float f3) {
            this.f2579a = f2;
            this.f2580b = f3;
        }
    }

    static float a(int i) {
        return i / f2578c;
    }

    public static JSONObject a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i));
            jSONObject.put("y", a(i2));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, a(i3));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, a(i4));
        } catch (JSONException e2) {
            c.a("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void a(Context context) {
        if (context != null) {
            f2578c = context.getResources().getDisplayMetrics().density;
            f2576a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject) {
        a aVarB = b(jSONObject);
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, aVarB.f2579a);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, aVarB.f2580b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            c.a("Error with setting ad session id", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            c.a("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e2) {
            c.a("Error with setting friendly obstruction", e2);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static b.e.a.a.a.d.b.a b(org.json.JSONObject r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 0
            r3 = 17
            if (r0 < r3) goto L27
            android.view.WindowManager r13 = b.e.a.a.a.d.b.f2576a
            if (r13 == 0) goto L65
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r2, r2)
            android.view.WindowManager r0 = b.e.a.a.a.d.b.f2576a
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getRealSize(r13)
            int r0 = r13.x
            float r1 = a(r0)
            int r13 = r13.y
            float r13 = a(r13)
            goto L66
        L27:
            java.lang.String r0 = "childViews"
            org.json.JSONArray r13 = r13.optJSONArray(r0)
            if (r13 == 0) goto L65
            int r0 = r13.length()
            r3 = 0
        L34:
            if (r2 >= r0) goto L63
            org.json.JSONObject r4 = r13.optJSONObject(r2)
            if (r4 == 0) goto L60
            java.lang.String r5 = "x"
            double r5 = r4.optDouble(r5)
            java.lang.String r7 = "y"
            double r7 = r4.optDouble(r7)
            java.lang.String r9 = "width"
            double r9 = r4.optDouble(r9)
            java.lang.String r11 = "height"
            double r11 = r4.optDouble(r11)
            double r5 = r5 + r9
            float r4 = (float) r5
            float r1 = java.lang.Math.max(r1, r4)
            double r7 = r7 + r11
            float r4 = (float) r7
            float r3 = java.lang.Math.max(r3, r4)
        L60:
            int r2 = r2 + 1
            goto L34
        L63:
            r13 = r3
            goto L66
        L65:
            r13 = 0
        L66:
            b.e.a.a.a.d.b$a r0 = new b.e.a.a.a.d.b$a
            r0.<init>(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.e.a.a.a.d.b.b(org.json.JSONObject):b.e.a.a.a.d.b$a");
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            c.a("Error with setting not visible reason", e2);
        }
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && c(jSONObject, jSONObject2) && d(jSONObject, jSONObject2) && e(jSONObject, jSONObject2) && f(jSONObject, jSONObject2);
    }

    private static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f2577b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    private static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!a(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (!jSONArrayOptJSONArray.optString(i, "").equals(jSONArrayOptJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!a(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (!b(jSONArrayOptJSONArray.optJSONObject(i), jSONArrayOptJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
