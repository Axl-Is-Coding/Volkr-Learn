package com.sandboxol.decorate.manager;

import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ResStatusManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f17201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, List<ObservableField<Boolean>>> f17202b;

    /* JADX INFO: compiled from: ResStatusManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final q f17203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final q f17204b;

        static {
            f17203a = new q();
            f17204b = new q();
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str + Consts.DOT + str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        return str.replace(strTrim, "").replace(".png", "") + Consts.DOT + strTrim;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        return strArrSplit[0] + "_" + strArrSplit[1];
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        return strArrSplit[0] + strArrSplit[1] + ".png";
    }

    public static String[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\.");
    }

    private q() {
        this.f17202b = new HashMap();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "selectable_action." + str.split("_")[str.split("_").length - 1];
    }

    public static void a(q qVar, String str, ObservableField<Boolean> observableField) {
        if (qVar.f17202b.get(str) == null) {
            qVar.f17202b.put(str, new ArrayList());
        }
        List<ObservableField<Boolean>> list = qVar.f17202b.get(str);
        list.getClass();
        list.add(observableField);
    }

    public static q b() {
        return a.f17204b;
    }

    public static void a(String str, boolean z) {
        if (z) {
            o.a().b(str);
        }
        if (a().f17201a.get().booleanValue()) {
            if (!a().f17202b.containsKey(str) || a().f17202b.get(str) == null) {
                return;
            }
            Iterator<ObservableField<Boolean>> it = a().f17202b.get(str).iterator();
            while (it.hasNext()) {
                it.next().set(Boolean.valueOf(z));
            }
            return;
        }
        if (!b().f17202b.containsKey(str) || b().f17202b.get(str) == null) {
            return;
        }
        Iterator<ObservableField<Boolean>> it2 = b().f17202b.get(str).iterator();
        while (it2.hasNext()) {
            it2.next().set(Boolean.valueOf(z));
        }
    }

    public static q a() {
        return a.f17203a;
    }
}
