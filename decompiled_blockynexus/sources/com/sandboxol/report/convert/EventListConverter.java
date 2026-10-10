package com.sandboxol.report.convert;

import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.report.entity.NewEvent;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.a.a;

/* JADX INFO: loaded from: classes4.dex */
public class EventListConverter implements a<List<NewEvent>, String> {
    public String convertToDatabaseValue(List<NewEvent> list) {
        if (list == null) {
            return null;
        }
        return new j().a(new ArrayList(list));
    }

    public List<NewEvent> convertToEntityProperty(String str) {
        return TextUtils.isEmpty(str) ? new ArrayList() : (List) new j().a(str, new TypeToken<List<NewEvent>>() { // from class: com.sandboxol.report.convert.EventListConverter.1
        }.getType());
    }
}
