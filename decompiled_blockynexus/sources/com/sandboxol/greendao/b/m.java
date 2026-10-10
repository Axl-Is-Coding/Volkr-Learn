package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.RealPlayGame;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: RealPlayGamerListConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements org.greenrobot.greendao.a.a<List<RealPlayGame>, String> {
    public List<RealPlayGame> a(String str) {
        return TextUtils.isEmpty(str) ? new ArrayList() : (List) new com.google.gson.j().a(str, new l(this).getType());
    }

    public String a(List<RealPlayGame> list) {
        if (list == null) {
            return null;
        }
        return new com.google.gson.j().a(list);
    }
}
