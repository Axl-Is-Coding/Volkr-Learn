package cn.qqtheme.framework.entity;

/* JADX INFO: loaded from: classes.dex */
public class CarNumberProvince implements LinkageFirst<CarNumberCity> {
    private String name;

    public CarNumberProvince(String str) {
        this.name = str;
    }

    @Override // cn.qqtheme.framework.entity.LinkageFirst, cn.qqtheme.framework.entity.LinkageItem
    public Object getId() {
        return this.name;
    }

    @Override // cn.qqtheme.framework.entity.WheelItem
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0174  */
    @Override // cn.qqtheme.framework.entity.LinkageFirst
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<cn.qqtheme.framework.entity.CarNumberCity> getSeconds() {
        /*
            Method dump skipped, instruction units count: 1692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.qqtheme.framework.entity.CarNumberProvince.getSeconds():java.util.List");
    }

    public String toString() {
        return "name=" + this.name;
    }
}
