package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ay> f19834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, ay> f19835d;

    public int a() {
        return this.f19832a;
    }

    public long b() {
        return this.f19833b;
    }

    public List<ay> c() {
        return this.f19834c;
    }

    public bb d() {
        bb bbVar = new bb();
        bbVar.setTimestamp(this.f19832a);
        bbVar.setPoiId(this.f19833b);
        LinkedList linkedList = new LinkedList();
        Iterator<ay> it = this.f19834c.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f());
        }
        bbVar.setBsslist(linkedList);
        return bbVar;
    }

    public void setBsslist(List<ay> list) {
        this.f19834c = list;
    }

    public void setPoiId(long j) {
        this.f19833b = j;
    }

    public void setTimestamp(int i) {
        this.f19832a = i;
    }

    public Map<String, ay> a(boolean z) {
        if (this.f19835d == null || z) {
            this.f19835d = new HashMap();
            for (ay ayVar : this.f19834c) {
                this.f19835d.put(ayVar.b(), ayVar);
            }
        }
        return this.f19835d;
    }
}
