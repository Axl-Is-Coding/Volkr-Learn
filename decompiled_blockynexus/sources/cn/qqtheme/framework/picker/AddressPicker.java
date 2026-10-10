package cn.qqtheme.framework.picker;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.LinkagePicker;
import cn.qqtheme.framework.util.LogUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AddressPicker extends LinkagePicker<Province, City, County> {
    private boolean hideCounty;
    private boolean hideProvince;
    private OnAddressPickListener onAddressPickListener;
    private OnWheelListener onWheelListener;
    private ArrayList<Province> provinces;

    private static class AddressProvider implements LinkagePicker.Provider<Province, City, County> {
        private List<Province> firstList = new ArrayList();
        private List<List<City>> secondList = new ArrayList();
        private List<List<List<County>>> thirdList = new ArrayList();

        public AddressProvider(List<Province> list) {
            parseData(list);
        }

        private void parseData(List<Province> list) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                Province province = list.get(i);
                this.firstList.add(province);
                List<City> cities = province.getCities();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size2 = cities.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    City city = cities.get(i2);
                    city.setProvinceId(province.getAreaId());
                    arrayList.add(city);
                    List<County> counties = city.getCounties();
                    ArrayList arrayList3 = new ArrayList();
                    int size3 = counties.size();
                    int i3 = 0;
                    while (i3 < size3) {
                        County county = counties.get(i3);
                        county.setCityId(city.getAreaId());
                        arrayList3.add(county);
                        i3++;
                        size = size;
                    }
                    arrayList2.add(arrayList3);
                }
                this.secondList.add(arrayList);
                this.thirdList.add(arrayList2);
                i++;
                size = size;
            }
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<Province> initFirstData() {
            return this.firstList;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public boolean isOnlyTwo() {
            return this.thirdList.size() == 0;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<City> linkageSecondData(int i) {
            return this.secondList.get(i);
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<County> linkageThirdData(int i, int i2) {
            return this.thirdList.get(i).get(i2);
        }
    }

    public interface OnAddressPickListener {
        void onAddressPicked(Province province, City city, County county);
    }

    public interface OnWheelListener {
        void onCityWheeled(int i, City city);

        void onCountyWheeled(int i, County county);

        void onProvinceWheeled(int i, Province province);
    }

    public AddressPicker(Activity activity, ArrayList<Province> arrayList) {
        super(activity, new AddressProvider(arrayList));
        this.hideProvince = false;
        this.hideCounty = false;
        this.provinces = new ArrayList<>();
        this.provinces = arrayList;
    }

    public City getSelectedCity() {
        List<City> cities = getSelectedProvince().getCities();
        if (cities.size() == 0) {
            return null;
        }
        return cities.get(this.selectedSecondIndex);
    }

    public County getSelectedCounty() {
        List<County> counties = getSelectedCity().getCounties();
        if (counties.size() == 0) {
            return null;
        }
        return counties.get(this.selectedThirdIndex);
    }

    public Province getSelectedProvince() {
        return this.provinces.get(this.selectedFirstIndex);
    }

    @Override // cn.qqtheme.framework.picker.LinkagePicker, cn.qqtheme.framework.popup.ConfirmPopup
    protected View makeCenterView() {
        if (this.provider == null) {
            throw new IllegalArgumentException("please set address provider before make view");
        }
        float f2 = this.firstColumnWeight;
        float f3 = this.secondColumnWeight;
        float f4 = this.thirdColumnWeight;
        if (this.hideCounty) {
            this.hideProvince = false;
        }
        if (this.hideProvince) {
            f3 = this.firstColumnWeight;
            f4 = this.secondColumnWeight;
            f2 = WheelView.DividerConfig.FILL;
        }
        this.dividerConfig.setRatio(WheelView.DividerConfig.FILL);
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewCreateWheelView = createWheelView();
        wheelViewCreateWheelView.setUseWeight(this.useWeight);
        wheelViewCreateWheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f2));
        linearLayout.addView(wheelViewCreateWheelView);
        if (this.hideProvince) {
            wheelViewCreateWheelView.setVisibility(8);
        }
        final WheelView wheelViewCreateWheelView2 = createWheelView();
        wheelViewCreateWheelView2.setUseWeight(this.useWeight);
        wheelViewCreateWheelView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f3));
        linearLayout.addView(wheelViewCreateWheelView2);
        final WheelView wheelViewCreateWheelView3 = createWheelView();
        wheelViewCreateWheelView3.setUseWeight(this.useWeight);
        wheelViewCreateWheelView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f4));
        linearLayout.addView(wheelViewCreateWheelView3);
        if (this.hideCounty) {
            wheelViewCreateWheelView3.setVisibility(8);
        }
        wheelViewCreateWheelView.setItems(this.provider.initFirstData(), this.selectedFirstIndex);
        wheelViewCreateWheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.AddressPicker.1
            /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                AddressPicker addressPicker = AddressPicker.this;
                addressPicker.selectedFirstIndex = i;
                addressPicker.selectedFirstItem = addressPicker.getSelectedProvince();
                if (AddressPicker.this.onWheelListener != null) {
                    OnWheelListener onWheelListener = AddressPicker.this.onWheelListener;
                    AddressPicker addressPicker2 = AddressPicker.this;
                    onWheelListener.onProvinceWheeled(addressPicker2.selectedFirstIndex, (Province) addressPicker2.selectedFirstItem);
                }
                LogUtils.verbose(this, "change cities after province wheeled: index=" + i);
                AddressPicker addressPicker3 = AddressPicker.this;
                addressPicker3.selectedSecondIndex = 0;
                addressPicker3.selectedThirdIndex = 0;
                List<?> listLinkageSecondData = addressPicker3.provider.linkageSecondData(addressPicker3.selectedFirstIndex);
                if (listLinkageSecondData.size() > 0) {
                    AddressPicker addressPicker4 = AddressPicker.this;
                    addressPicker4.selectedSecondItem = (Snd) listLinkageSecondData.get(addressPicker4.selectedSecondIndex);
                    wheelViewCreateWheelView2.setItems(listLinkageSecondData, AddressPicker.this.selectedSecondIndex);
                } else {
                    AddressPicker.this.selectedSecondItem = null;
                    wheelViewCreateWheelView2.setItems(new ArrayList());
                }
                AddressPicker addressPicker5 = AddressPicker.this;
                List<?> listLinkageThirdData = addressPicker5.provider.linkageThirdData(addressPicker5.selectedFirstIndex, addressPicker5.selectedSecondIndex);
                if (listLinkageThirdData.size() <= 0) {
                    AddressPicker.this.selectedThirdItem = null;
                    wheelViewCreateWheelView3.setItems(new ArrayList());
                } else {
                    AddressPicker addressPicker6 = AddressPicker.this;
                    addressPicker6.selectedThirdItem = listLinkageThirdData.get(addressPicker6.selectedThirdIndex);
                    wheelViewCreateWheelView3.setItems(listLinkageThirdData, AddressPicker.this.selectedThirdIndex);
                }
            }
        });
        wheelViewCreateWheelView2.setItems(this.provider.linkageSecondData(this.selectedFirstIndex), this.selectedSecondIndex);
        wheelViewCreateWheelView2.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.AddressPicker.2
            /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                AddressPicker addressPicker = AddressPicker.this;
                addressPicker.selectedSecondIndex = i;
                addressPicker.selectedSecondItem = addressPicker.getSelectedCity();
                if (AddressPicker.this.onWheelListener != null) {
                    OnWheelListener onWheelListener = AddressPicker.this.onWheelListener;
                    AddressPicker addressPicker2 = AddressPicker.this;
                    onWheelListener.onCityWheeled(addressPicker2.selectedSecondIndex, (City) addressPicker2.selectedSecondItem);
                }
                LogUtils.verbose(this, "change counties after city wheeled: index=" + i);
                AddressPicker addressPicker3 = AddressPicker.this;
                addressPicker3.selectedThirdIndex = 0;
                List<?> listLinkageThirdData = addressPicker3.provider.linkageThirdData(addressPicker3.selectedFirstIndex, addressPicker3.selectedSecondIndex);
                if (listLinkageThirdData.size() <= 0) {
                    AddressPicker.this.selectedThirdItem = null;
                    wheelViewCreateWheelView3.setItems(new ArrayList());
                } else {
                    AddressPicker addressPicker4 = AddressPicker.this;
                    addressPicker4.selectedThirdItem = listLinkageThirdData.get(addressPicker4.selectedThirdIndex);
                    wheelViewCreateWheelView3.setItems(listLinkageThirdData, AddressPicker.this.selectedThirdIndex);
                }
            }
        });
        wheelViewCreateWheelView3.setItems(this.provider.linkageThirdData(this.selectedFirstIndex, this.selectedSecondIndex), this.selectedThirdIndex);
        wheelViewCreateWheelView3.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.AddressPicker.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v1, types: [Trd, cn.qqtheme.framework.entity.County] */
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                AddressPicker addressPicker = AddressPicker.this;
                addressPicker.selectedThirdIndex = i;
                addressPicker.selectedThirdItem = addressPicker.getSelectedCounty();
                if (AddressPicker.this.onWheelListener != null) {
                    OnWheelListener onWheelListener = AddressPicker.this.onWheelListener;
                    AddressPicker addressPicker2 = AddressPicker.this;
                    onWheelListener.onCountyWheeled(addressPicker2.selectedThirdIndex, (County) addressPicker2.selectedThirdItem);
                }
            }
        });
        return linearLayout;
    }

    @Override // cn.qqtheme.framework.picker.LinkagePicker, cn.qqtheme.framework.popup.ConfirmPopup
    public void onSubmit() {
        if (this.onAddressPickListener != null) {
            this.onAddressPickListener.onAddressPicked(getSelectedProvince(), getSelectedCity(), this.hideCounty ? null : getSelectedCounty());
        }
    }

    public void setHideCounty(boolean z) {
        this.hideCounty = z;
    }

    public void setHideProvince(boolean z) {
        this.hideProvince = z;
    }

    public void setOnAddressPickListener(OnAddressPickListener onAddressPickListener) {
        this.onAddressPickListener = onAddressPickListener;
    }

    @Override // cn.qqtheme.framework.picker.LinkagePicker
    @Deprecated
    public final void setOnLinkageListener(LinkagePicker.OnLinkageListener onLinkageListener) {
        throw new UnsupportedOperationException("Please use setOnAddressPickListener instead.");
    }

    public void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    @Override // cn.qqtheme.framework.picker.LinkagePicker
    public void setSelectedItem(Province province, City city, County county) {
        super.setSelectedItem(province, city, county);
    }

    public void setSelectedItem(String str, String str2, String str3) {
        setSelectedItem(new Province(str), new City(str2), new County(str3));
    }
}
