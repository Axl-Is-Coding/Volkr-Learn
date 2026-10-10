package cn.qqtheme.framework.picker;

import android.app.Activity;
import cn.qqtheme.framework.entity.CarNumberCity;
import cn.qqtheme.framework.entity.CarNumberProvince;
import cn.qqtheme.framework.picker.LinkagePicker;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CarNumberPicker extends LinkagePicker<CarNumberProvince, CarNumberCity, Void> {
    private static final String[] ABBREVIATIONS = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    private static class CarNumberDataProvider implements LinkagePicker.Provider<CarNumberProvince, CarNumberCity, Void> {
        private List<CarNumberProvince> provinces = new ArrayList();

        CarNumberDataProvider() {
            for (String str : CarNumberPicker.ABBREVIATIONS) {
                this.provinces.add(new CarNumberProvince(str));
            }
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<CarNumberProvince> initFirstData() {
            return this.provinces;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public boolean isOnlyTwo() {
            return true;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<CarNumberCity> linkageSecondData(int i) {
            return this.provinces.get(i).getSeconds();
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<Void> linkageThirdData(int i, int i2) {
            return new ArrayList();
        }
    }

    public CarNumberPicker(Activity activity) {
        super(activity, new CarNumberDataProvider());
    }
}
