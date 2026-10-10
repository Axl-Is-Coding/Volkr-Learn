package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.BannerEntity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BannerListConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements org.greenrobot.greendao.a.a<List<BannerEntity>, String> {
    public List<BannerEntity> a(String str) {
        return TextUtils.isEmpty(str) ? new ArrayList() : (List) new com.google.gson.j().a(str, new b(this).getType());
    }

    public String a(List<BannerEntity> list) {
        if (list == null) {
            return null;
        }
        return new com.google.gson.j().a(list);
    }
}
