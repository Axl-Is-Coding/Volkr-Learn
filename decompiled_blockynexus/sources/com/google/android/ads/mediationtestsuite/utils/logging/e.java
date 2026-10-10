package com.google.android.ads.mediationtestsuite.utils.logging;

import android.content.Context;
import android.net.Uri;
import com.android.volley.toolbox.q;
import com.android.volley.toolbox.s;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(b bVar, Context context) {
        Map<String, String> mapA = a(context);
        if (bVar.getParameters() != null) {
            mapA.putAll(bVar.getParameters());
        }
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        for (String str : mapA.keySet()) {
            builderBuildUpon.appendQueryParameter(str, mapA.get(str));
        }
        builderBuildUpon.appendQueryParameter("event_type", bVar.getEventType());
        s.a(context).a(new q(0, builderBuildUpon.build().toString(), new c(), new d()));
    }

    private static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        g gVarF = g.f();
        map.put("id", "gmob-apps");
        map.put("application_id", gVarF.a(context));
        map.put("admob_app_id", gVarF.a());
        map.put("test_suite_version", gVarF.d());
        map.put("session_id", gVarF.c());
        map.put("timestamp", String.valueOf(new Date().getTime()));
        if (g.f().b() != null) {
            map.put("country", g.f().b());
        }
        map.put("user_agent", g.f().e());
        return map;
    }
}
