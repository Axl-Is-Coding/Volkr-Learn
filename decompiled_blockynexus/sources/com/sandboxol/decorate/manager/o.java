package com.sandboxol.decorate.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResStatusCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f17198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f17199b;

    /* JADX INFO: compiled from: ResStatusCache.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final o f17200a = new o();
    }

    public static o a() {
        return a.f17200a;
    }

    public void b(Context context) {
        this.f17199b = context.getSharedPreferences("BMResStatus", 0);
        this.f17198a = (List) new com.google.gson.j().a(this.f17199b.getString("resStatusList", ""), new TypeToken<List<String>>() { // from class: com.sandboxol.decorate.manager.ResStatusCache$1
        }.getType());
        if (this.f17198a == null) {
            this.f17198a = new ArrayList();
        }
    }

    private o() {
    }

    public boolean a(String str) {
        List<String> list = this.f17198a;
        if (list == null) {
            return false;
        }
        return list.contains(str);
    }

    public void a(Context context) {
        this.f17199b = context.getSharedPreferences("BMResStatus", 0);
        SharedPreferences.Editor editorEdit = this.f17199b.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public void b(String str) {
        List<String> list = this.f17198a;
        if (list == null || list.contains(str)) {
            return;
        }
        this.f17198a.add(str);
        ArrayList arrayList = new ArrayList(this.f17198a);
        SharedPreferences.Editor editorEdit = this.f17199b.edit();
        editorEdit.putString("resStatusList", new com.google.gson.j().a(arrayList));
        editorEdit.apply();
    }
}
