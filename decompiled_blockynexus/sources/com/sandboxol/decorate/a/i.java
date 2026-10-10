package com.sandboxol.decorate.a;

import com.sandboxol.decorate.a.f;
import com.sandboxol.decorate.widget.DressViewPageFilter;
import java.util.List;

/* JADX INFO: compiled from: DressViewPageFilterBindAdapters.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static void a(DressViewPageFilter dressViewPageFilter, List<String> list, List<String> list2, String str, String str2, f.a aVar, f.a aVar2) {
        if (list == null || list2 == null || str == null || str2 == null || aVar == null || aVar2 == null) {
            return;
        }
        dressViewPageFilter.setLeftListData(list);
        dressViewPageFilter.setRightListData(list2);
        dressViewPageFilter.setLeftText(str);
        dressViewPageFilter.setRightText(str2);
        dressViewPageFilter.setLeftListener(aVar);
        dressViewPageFilter.setRightListener(aVar2);
    }
}
