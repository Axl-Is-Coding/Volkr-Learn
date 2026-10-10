package cn.qqtheme.framework.entity;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class City extends Area implements LinkageSecond<County> {
    private List<County> counties;
    private String provinceId;

    public City() {
        this.counties = new ArrayList();
    }

    public List<County> getCounties() {
        return this.counties;
    }

    public String getProvinceId() {
        return this.provinceId;
    }

    @Override // cn.qqtheme.framework.entity.LinkageSecond
    public List<County> getThirds() {
        return this.counties;
    }

    public void setCounties(List<County> list) {
        this.counties = list;
    }

    public void setProvinceId(String str) {
        this.provinceId = str;
    }

    public City(String str) {
        super(str);
        this.counties = new ArrayList();
    }

    public City(String str, String str2) {
        super(str, str2);
        this.counties = new ArrayList();
    }
}
