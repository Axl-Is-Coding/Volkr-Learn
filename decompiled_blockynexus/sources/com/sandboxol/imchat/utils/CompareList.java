package com.sandboxol.imchat.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CompareList {
    public static <E> List<E> cleanDisRepeat(List<E> list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

    public static <E> List<E> getAddaListThanbList(List<E> list, List<E> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!myListContains(list2, list.get(i))) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static <E> List<E> getReduceaListThanbList(List<E> list, List<E> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            if (!myListContains(list, list2.get(i))) {
                arrayList.add(list2.get(i));
            }
        }
        return arrayList;
    }

    private static <E> boolean myListContains(List<E> list, E e2) {
        if (list == null || e2 == null || list.isEmpty()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            if (e2.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
