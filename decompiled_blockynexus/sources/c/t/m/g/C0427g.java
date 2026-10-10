package c.t.m.g;

import android.text.TextUtils;
import com.sandboxol.center.config.StringConstant;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: renamed from: c.t.m.g.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0427g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f3205a;

    /* JADX INFO: renamed from: c.t.m.g.g$a */
    final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f3207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3208c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3210e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3211f;
        public boolean g;
        public boolean h;

        public a(String str, int i, String str2, String str3, String str4, String str5) {
            this.f3209d = false;
            this.f3210e = false;
            this.f3211f = false;
            this.g = false;
            this.h = false;
            this.f3206a = str;
            String[] strArrSplit = str.split("-");
            if (strArrSplit.length < 5) {
                this.f3207b = new String[]{StringConstant.VIDEO_TYPE_ALL, StringConstant.VIDEO_TYPE_ALL, StringConstant.VIDEO_TYPE_ALL, StringConstant.VIDEO_TYPE_ALL, StringConstant.VIDEO_TYPE_ALL};
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    this.f3207b[i2] = strArrSplit[i2];
                }
            } else {
                this.f3207b = strArrSplit;
            }
            this.f3209d = a(0, String.valueOf(i));
            this.f3210e = a(1, str2);
            this.f3211f = a(2, str3);
            this.g = a(3, str4);
            this.h = a(4, str5);
            this.f3207b = null;
        }

        private boolean a(int i, String str) {
            String[] strArr = this.f3207b;
            if (strArr.length < i + 1) {
                return false;
            }
            boolean zEquals = strArr[i].equals(str);
            if (zEquals || this.f3207b[i].equals(StringConstant.VIDEO_TYPE_ALL)) {
                return zEquals;
            }
            this.f3208c = false;
            return zEquals;
        }
    }

    public final synchronized String a() {
        if (this.f3205a == null) {
            return "";
        }
        return this.f3205a.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String a(java.lang.String r13, int r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0427g.a(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public final synchronized void a(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f3205a == null) {
                this.f3205a = jSONObject;
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
            String strOptString = jSONObject.optString("version");
            if (jSONObjectOptJSONObject2 != null && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObjectOptJSONObject3 = this.f3205a.optJSONObject("data");
                if (jSONObjectOptJSONObject3 == null) {
                    this.f3205a.putOpt("data", jSONObjectOptJSONObject2);
                } else {
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(next)) != null) {
                            jSONObjectOptJSONObject3.putOpt(next, jSONObjectOptJSONObject);
                        }
                    }
                }
                this.f3205a.putOpt("version", strOptString);
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void b() {
        this.f3205a = null;
    }

    public final synchronized String c() {
        if (this.f3205a == null) {
            return "";
        }
        return this.f3205a.optString("version");
    }
}
