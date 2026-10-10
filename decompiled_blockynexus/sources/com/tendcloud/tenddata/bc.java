package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f19836a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f19837b = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19838c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19839d = -40;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19840e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private az f19841f;

    /* JADX INFO: compiled from: td */
    class a {
        public bb fp1;
        public bb fp2;
        public double score;

        public a(bb bbVar, bb bbVar2, double d2) {
            this.fp1 = bbVar;
            this.fp2 = bbVar2;
            this.score = d2;
        }
    }

    /* JADX INFO: compiled from: td */
    class b {
        public Object key;
        public Object value;

        public b(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    public bc() {
        this(new az());
    }

    public double a(bb bbVar, bb bbVar2) {
        Map<String, ay> mapA = bbVar.a(false);
        Map<String, ay> mapA2 = bbVar2.a(false);
        HashSet hashSet = new HashSet();
        int i = 0;
        int iC = 0;
        double d2 = 0.0d;
        double dA = 0.0d;
        for (Map.Entry<String, ay> entry : mapA.entrySet()) {
            ay value = entry.getValue();
            ay ayVar = mapA2.get(entry.getKey());
            iC += value.c();
            if (ayVar == null) {
                hashSet.add(value);
            } else {
                i++;
                double dB = b(value.c(), ayVar.c());
                d2 += dB;
                dA += dB * a(value.c(), ayVar.c());
            }
        }
        if (i == 0) {
            return 0.0d;
        }
        double d3 = 0.0d;
        for (Map.Entry<String, ay> entry2 : mapA2.entrySet()) {
            iC += entry2.getValue().c();
            if (!mapA.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int size = iC / ((bbVar.c().size() + bbVar2.c().size()) - 0);
        int iD = this.f19841f.d();
        double d4 = size;
        Double.isNaN(d4);
        int iMax = Math.max(iD, (int) (d4 + 1.2d));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ay) it.next()).c() > iMax) {
                d3 += 1.0d;
            }
        }
        double d5 = i * 2;
        Double.isNaN(d5);
        return (dA / d2) * (1.0d - Math.pow(d3 / (d5 + d3), f19840e));
    }

    public bb b(bb bbVar, bb bbVar2) {
        Map<String, ay> mapA = bbVar.a(false);
        Map<String, ay> mapA2 = bbVar2.a(false);
        TreeMap treeMap = new TreeMap();
        bb bbVar3 = new bb();
        bbVar3.setPoiId(bbVar2.b());
        bbVar3.setTimestamp(bbVar2.a());
        LinkedList linkedList = new LinkedList();
        bbVar3.setBsslist(linkedList);
        for (Map.Entry<String, ay> entry : mapA.entrySet()) {
            ay value = entry.getValue();
            ay ayVar = mapA2.get(entry.getKey());
            if (ayVar == null) {
                double d2 = -value.c();
                while (treeMap.containsKey(Double.valueOf(d2))) {
                    d2 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d2), value);
            } else {
                linkedList.add(new ay(ayVar.a(), ayVar.b(), (byte) ((ayVar.c() + value.c()) / 2), ayVar.d(), ayVar.e()));
            }
        }
        for (Map.Entry<String, ay> entry2 : mapA2.entrySet()) {
            if (!mapA.containsKey(entry2.getKey())) {
                double d3 = -entry2.getValue().c();
                while (treeMap.containsKey(Double.valueOf(d3))) {
                    d3 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d3), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b2 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f19841f.c() || b2 < this.f19841f.d()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return bbVar3;
    }

    public bc(az azVar) {
        this.f19841f = azVar;
    }

    public double a(bb bbVar, List<bb> list) {
        Iterator<bb> it = list.iterator();
        double dMax = 0.0d;
        while (it.hasNext()) {
            dMax = Math.max(a(it.next(), bbVar), dMax);
        }
        return dMax;
    }

    public double a(List<bb> list, List<bb> list2) {
        double d2 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i = 0;
        for (a aVar : linkedList) {
            if (aVar.fp1 != null && aVar.fp2 != null) {
                d2 += aVar.score;
                i++;
            }
        }
        double d3 = i;
        Double.isNaN(d3);
        return d2 / d3;
    }

    public void b(List<bb> list, List<bb> list2, List<a> list3) {
        ArrayList<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (bb bbVar : list) {
            for (bb bbVar2 : list2) {
                hashSet2.add(bbVar2);
                arrayList.add(new a(bbVar, bbVar2, a(bbVar, bbVar2)));
            }
            hashSet.add(bbVar);
        }
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.tendcloud.tenddata.bc.1
            @Override // java.util.Comparator
            public int compare(a aVar, a aVar2) {
                double d2 = aVar.score;
                double d3 = aVar2.score;
                if (d2 == d3) {
                    return 0;
                }
                return d2 < d3 ? 1 : -1;
            }
        });
        list3.clear();
        for (a aVar : arrayList) {
            if (hashSet.contains(aVar.fp1) && hashSet2.contains(aVar.fp2)) {
                hashSet.remove(aVar.fp1);
                hashSet2.remove(aVar.fp2);
                list3.add(aVar);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            list3.add(new a((bb) it.next(), null, 0.0d));
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            list3.add(new a(null, (bb) it2.next(), 0.0d));
        }
    }

    public double a(List<bb> list, List<bb> list2, List<bb> list3) {
        bb bbVar;
        double d2 = 0.0d;
        if (!list.isEmpty() && !list2.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            b(list, list2, linkedList);
            int i = 0;
            for (a aVar : linkedList) {
                bb bbVar2 = aVar.fp1;
                if (bbVar2 != null && (bbVar = aVar.fp2) != null) {
                    d2 += aVar.score;
                    i++;
                    list3.add(b(bbVar2, bbVar));
                } else if (list3.size() < this.f19841f.b()) {
                    bb bbVar3 = aVar.fp1;
                    list3.add(bbVar3 == null ? aVar.fp2.d() : bbVar3.d());
                }
            }
            double d3 = i;
            Double.isNaN(d3);
            return d2 / d3;
        }
        list3.addAll(list);
        list3.addAll(list2);
        return 0.0d;
    }

    public double a(int i, int i2) {
        double d2 = 0.0d;
        if (i >= 0 || i2 >= 0) {
            return 0.0d;
        }
        double d3 = (i2 + i) / 2;
        double d4 = i;
        Double.isNaN(d4);
        Double.isNaN(d3);
        double dAbs = Math.abs(d4 - d3);
        int i3 = f19836a;
        if (dAbs > i3) {
            double d5 = i3;
            Double.isNaN(d5);
            d2 = dAbs - d5;
        }
        Double.isNaN(d3);
        Double.isNaN(d3);
        return Math.pow((d2 + d3) / d3, f19837b);
    }

    public double b(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            return 0.0d;
        }
        double dMax = Math.max(i, i2);
        int i3 = f19839d;
        if (dMax >= i3) {
            return 1.0d;
        }
        Double.isNaN(dMax);
        double d2 = i3 + 128;
        Double.isNaN(d2);
        return Math.pow((dMax + 128.0d) / d2, f19838c);
    }
}
