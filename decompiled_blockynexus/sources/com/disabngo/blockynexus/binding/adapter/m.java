package com.disabngo.blockynexus.binding.adapter;

import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.view.widget.NineGirdImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NineGridImageBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a(NineGirdImageView nineGirdImageView, com.disabngo.blockynexus.adapter.e eVar, List<GroupMember> list) {
        nineGirdImageView.setAdapter(eVar);
        nineGirdImageView.setImagesData(a(list));
    }

    private static List<String> a(List<GroupMember> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GroupMember> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPic());
        }
        return arrayList;
    }
}
