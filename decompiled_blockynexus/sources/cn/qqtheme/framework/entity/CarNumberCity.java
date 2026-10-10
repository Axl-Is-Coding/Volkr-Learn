package cn.qqtheme.framework.entity;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CarNumberCity implements LinkageSecond<Void> {
    private String name;

    public CarNumberCity(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CarNumberCity) {
            return this.name.equals(((CarNumberCity) obj).getName());
        }
        return false;
    }

    @Override // cn.qqtheme.framework.entity.LinkageSecond, cn.qqtheme.framework.entity.LinkageItem
    public Object getId() {
        return this.name;
    }

    @Override // cn.qqtheme.framework.entity.WheelItem
    public String getName() {
        return this.name;
    }

    @Override // cn.qqtheme.framework.entity.LinkageSecond
    public List<Void> getThirds() {
        return null;
    }

    public String toString() {
        return "name=" + this.name;
    }
}
