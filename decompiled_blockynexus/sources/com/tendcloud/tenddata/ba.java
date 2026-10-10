package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f19826a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f19827b = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19828c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19829d = -40;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19830e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f19831f;

    /* JADX INFO: compiled from: td */
    static class b {
        static final int DEFAULT_MAX_BSS_ENTRIES = 50;
        static final int DEFAULT_MAX_FINGERPRINTS = 10;
        static final int DEFAULT_MIN_FINGERPRINTS = 3;
        static final int DEFAULT_RSSI_THRESHOLD = -85;
        private int maxFingerprints = 10;
        private int minFingerprints = 3;
        private int maxBssEntries = 50;
        private int rssiThreshold = -85;

        b() {
        }

        int getMaxBssEntries() {
            return this.maxBssEntries;
        }

        int getMaxFingerprints() {
            return this.maxFingerprints;
        }

        int getMinFingerprints() {
            return this.minFingerprints;
        }

        int getRssiThreshold() {
            return this.rssiThreshold;
        }

        void setMaxBssEntries(int i) {
            this.maxBssEntries = i;
        }

        void setMaxFingerprints(int i) {
            this.maxFingerprints = i;
        }

        void setMinFingerprints(int i) {
            this.minFingerprints = i;
        }

        void setRssiThreshold(int i) {
            this.rssiThreshold = i;
        }
    }

    /* JADX INFO: compiled from: td */
    class c {
        private List<a> bsslist;
        private Map<String, a> bssmap;
        private long poiId;
        private int timestamp;

        c() {
        }

        c cloneFingerprint() {
            c cVar = ba.this.new c();
            cVar.setTimestamp(this.timestamp);
            cVar.setPoiId(this.poiId);
            LinkedList linkedList = new LinkedList();
            Iterator<a> it = this.bsslist.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().cloneBssEntry());
            }
            cVar.setBsslist(linkedList);
            return cVar;
        }

        List<a> getBsslist() {
            return this.bsslist;
        }

        Map<String, a> getBssmap(boolean z) {
            if (this.bssmap == null || z) {
                this.bssmap = new HashMap();
                for (a aVar : this.bsslist) {
                    this.bssmap.put(aVar.getBssid(), aVar);
                }
            }
            return this.bssmap;
        }

        long getPoiId() {
            return this.poiId;
        }

        int getTimestamp() {
            return this.timestamp;
        }

        void setBsslist(List<a> list) {
            this.bsslist = list;
        }

        void setPoiId(long j) {
            this.poiId = j;
        }

        void setTimestamp(int i) {
            this.timestamp = i;
        }
    }

    /* JADX INFO: compiled from: td */
    class d {
        c fp1;
        c fp2;
        double score;

        d(c cVar, c cVar2, double d2) {
            this.fp1 = cVar;
            this.fp2 = cVar2;
            this.score = d2;
        }
    }

    /* JADX INFO: compiled from: td */
    class e {
        Object key;
        Object value;

        e(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    ba() {
        this(new b());
    }

    double a(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        HashSet hashSet = new HashSet();
        int i = 0;
        int rssi = 0;
        double d2 = 0.0d;
        double dA = 0.0d;
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            rssi += value.getRssi();
            if (aVar == null) {
                hashSet.add(value);
            } else {
                i++;
                double dB = b(value.getRssi(), aVar.getRssi());
                d2 += dB;
                dA += dB * a(value.getRssi(), aVar.getRssi());
            }
        }
        if (i == 0) {
            return 0.0d;
        }
        double d3 = 0.0d;
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            rssi += entry2.getValue().getRssi();
            if (!bssmap.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int size = rssi / ((cVar.getBsslist().size() + cVar2.getBsslist().size()) - 0);
        int rssiThreshold = this.f19831f.getRssiThreshold();
        double d4 = size;
        Double.isNaN(d4);
        int iMax = Math.max(rssiThreshold, (int) (d4 + 1.2d));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).getRssi() > iMax) {
                d3 += 1.0d;
            }
        }
        double d5 = i * 2;
        Double.isNaN(d5);
        return (dA / d2) * (1.0d - Math.pow(d3 / (d5 + d3), f19830e));
    }

    c b(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        TreeMap treeMap = new TreeMap();
        c cVar3 = new c();
        cVar3.setPoiId(cVar2.getPoiId());
        cVar3.setTimestamp(cVar2.getTimestamp());
        LinkedList linkedList = new LinkedList();
        cVar3.setBsslist(linkedList);
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            if (aVar == null) {
                double d2 = -value.getRssi();
                while (treeMap.containsKey(Double.valueOf(d2))) {
                    d2 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d2), value);
            } else {
                linkedList.add(new a(aVar.getSsid(), aVar.getBssid(), (byte) ((aVar.getRssi() + value.getRssi()) / 2), aVar.getBand(), aVar.getChannel()));
            }
        }
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            if (!bssmap.containsKey(entry2.getKey())) {
                double d3 = -entry2.getValue().getRssi();
                while (treeMap.containsKey(Double.valueOf(d3))) {
                    d3 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d3), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b2 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f19831f.getMaxBssEntries() || b2 < this.f19831f.getRssiThreshold()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return cVar3;
    }

    ba(b bVar) {
        this.f19831f = bVar;
    }

    /* JADX INFO: compiled from: td */
    class a {
        private byte band;
        private String bssid;
        private byte channel;
        private byte rssi;
        private String ssid;

        a() {
            this.ssid = "";
            this.bssid = "00:00:00:00:00:00";
            this.rssi = (byte) -127;
            this.band = (byte) 1;
            this.channel = (byte) 1;
        }

        a cloneBssEntry() {
            return ba.this.new a(this.ssid, this.bssid, this.rssi, this.band, this.channel);
        }

        byte getBand() {
            return this.band;
        }

        String getBssid() {
            return this.bssid;
        }

        byte getChannel() {
            return this.channel;
        }

        byte getRssi() {
            return this.rssi;
        }

        String getSsid() {
            return this.ssid;
        }

        void setBand(byte b2) {
            this.band = b2;
        }

        void setBssid(String str) {
            this.bssid = str;
        }

        void setChannel(byte b2) {
            this.channel = b2;
        }

        void setRssi(byte b2) {
            this.rssi = b2;
        }

        void setSsid(String str) {
            this.ssid = str;
        }

        a(String str, String str2, byte b2, byte b3, byte b4) {
            this.ssid = str;
            this.bssid = str2;
            this.rssi = b2;
            this.band = b3;
            this.channel = b4;
        }
    }

    double a(c cVar, List<c> list) {
        Iterator<c> it = list.iterator();
        double dMax = 0.0d;
        while (it.hasNext()) {
            dMax = Math.max(a(it.next(), cVar), dMax);
        }
        return dMax;
    }

    double a(List<c> list, List<c> list2) {
        double d2 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i = 0;
        for (d dVar : linkedList) {
            if (dVar.fp1 != null && dVar.fp2 != null) {
                d2 += dVar.score;
                i++;
            }
        }
        double d3 = i;
        Double.isNaN(d3);
        return d2 / d3;
    }

    void b(List<c> list, List<c> list2, List<d> list3) {
        ArrayList<d> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (c cVar : list) {
            for (c cVar2 : list2) {
                hashSet2.add(cVar2);
                arrayList.add(new d(cVar, cVar2, a(cVar, cVar2)));
            }
            hashSet.add(cVar);
        }
        Collections.sort(arrayList, new Comparator<d>() { // from class: com.tendcloud.tenddata.ba.1
            @Override // java.util.Comparator
            public int compare(d dVar, d dVar2) {
                if (Double.doubleToLongBits(dVar.score) == Double.doubleToLongBits(dVar2.score)) {
                    return 0;
                }
                return Double.doubleToLongBits(dVar.score) < Double.doubleToLongBits(dVar2.score) ? 1 : -1;
            }
        });
        list3.clear();
        for (d dVar : arrayList) {
            if (hashSet.contains(dVar.fp1) && hashSet2.contains(dVar.fp2)) {
                hashSet.remove(dVar.fp1);
                hashSet2.remove(dVar.fp2);
                list3.add(dVar);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            list3.add(new d((c) it.next(), null, 0.0d));
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            list3.add(new d(null, (c) it2.next(), 0.0d));
        }
    }

    double a(List<c> list, List<c> list2, List<c> list3) {
        c cVar;
        double d2 = 0.0d;
        if (!list.isEmpty() && !list2.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            b(list, list2, linkedList);
            int i = 0;
            for (d dVar : linkedList) {
                c cVar2 = dVar.fp1;
                if (cVar2 != null && (cVar = dVar.fp2) != null) {
                    d2 += dVar.score;
                    i++;
                    list3.add(b(cVar2, cVar));
                } else if (list3.size() < this.f19831f.getMinFingerprints()) {
                    c cVar3 = dVar.fp1;
                    list3.add(cVar3 == null ? dVar.fp2.cloneFingerprint() : cVar3.cloneFingerprint());
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

    double a(int i, int i2) {
        double d2 = 0.0d;
        if (i >= 0 || i2 >= 0) {
            return 0.0d;
        }
        double d3 = (i2 + i) / 2;
        double d4 = i;
        Double.isNaN(d4);
        Double.isNaN(d3);
        double dAbs = Math.abs(d4 - d3);
        int i3 = f19826a;
        if (dAbs > i3) {
            double d5 = i3;
            Double.isNaN(d5);
            d2 = dAbs - d5;
        }
        Double.isNaN(d3);
        Double.isNaN(d3);
        return Math.pow((d2 + d3) / d3, f19827b);
    }

    double b(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            return 0.0d;
        }
        double dMax = Math.max(i, i2);
        int i3 = f19829d;
        if (dMax >= i3) {
            return 1.0d;
        }
        Double.isNaN(dMax);
        double d2 = i3 + 128;
        Double.isNaN(d2);
        return Math.pow((dMax + 128.0d) / d2, f19828c);
    }
}
