package com.sandboxol.pingreport.converter;

import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.greenrobot.greendao.a.a;

/* JADX INFO: loaded from: classes4.dex */
public class IntListConverter implements a<List<Integer>, String> {
    public String convertToDatabaseValue(List<Integer> list) {
        if (list == null) {
            return null;
        }
        return new j().a(list);
    }

    public List<Integer> convertToEntityProperty(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (List) new j().a(str, new TypeToken<List<Integer>>() { // from class: com.sandboxol.pingreport.converter.IntListConverter.1
        }.getType());
    }
}
