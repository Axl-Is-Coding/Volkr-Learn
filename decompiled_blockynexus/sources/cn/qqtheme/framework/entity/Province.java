package cn.qqtheme.framework.entity;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Province extends Area implements LinkageFirst<City> {
    private List<City> cities;

    public Province() {
        this.cities = new ArrayList();
    }

    public List<City> getCities() {
        return this.cities;
    }

    @Override // cn.qqtheme.framework.entity.LinkageFirst
    public List<City> getSeconds() {
        return this.cities;
    }

    public void setCities(List<City> list) {
        this.cities = list;
    }

    public Province(String str) {
        super(str);
        this.cities = new ArrayList();
    }

    public Province(String str, String str2) {
        super(str, str2);
        this.cities = new ArrayList();
    }
}
