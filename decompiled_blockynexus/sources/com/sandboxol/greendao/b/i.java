package com.sandboxol.greendao.b;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: ListConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements org.greenrobot.greendao.a.a<List<String>, String> {
    public List<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (List) new com.google.gson.j().a(str, new h(this).getType());
    }

    public String a(List<String> list) {
        if (list == null) {
            return null;
        }
        return new com.google.gson.j().a(list);
    }
}
