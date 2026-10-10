package cn.qqtheme.framework.picker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.entity.LinkageFirst;
import cn.qqtheme.framework.entity.LinkageSecond;
import cn.qqtheme.framework.entity.LinkageThird;
import cn.qqtheme.framework.util.LogUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinkagePicker<Fst extends LinkageFirst<Snd>, Snd extends LinkageSecond<Trd>, Trd> extends WheelPicker {
    protected float firstColumnWeight;
    protected String firstLabel;
    private OnLinkageListener onLinkageListener;
    private OnPickListener onPickListener;
    private OnWheelLinkageListener onWheelLinkageListener;
    private OnWheelListener onWheelListener;
    protected Provider provider;
    protected float secondColumnWeight;
    protected String secondLabel;
    protected int selectedFirstIndex;
    protected Fst selectedFirstItem;
    protected int selectedSecondIndex;
    protected Snd selectedSecondItem;
    protected int selectedThirdIndex;
    protected Trd selectedThirdItem;
    protected float thirdColumnWeight;
    protected String thirdLabel;
    protected boolean useWeight;

    public static abstract class DataProvider implements Provider<StringLinkageFirst, StringLinkageSecond, String> {
        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<StringLinkageFirst> initFirstData() {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = provideFirstData().iterator();
            int i = 0;
            while (it.hasNext()) {
                arrayList.add(new StringLinkageFirst(it.next(), linkageSecondData(i)));
                i++;
            }
            return arrayList;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<StringLinkageSecond> linkageSecondData(int i) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = provideSecondData(i).iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList.add(new StringLinkageSecond(it.next(), linkageThirdData(i, i2)));
                i2++;
            }
            return arrayList;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<String> linkageThirdData(int i, int i2) {
            List<String> listProvideThirdData = provideThirdData(i, i2);
            return listProvideThirdData == null ? new ArrayList() : listProvideThirdData;
        }

        public abstract List<String> provideFirstData();

        public abstract List<String> provideSecondData(int i);

        public abstract List<String> provideThirdData(int i, int i2);
    }

    private static class DefaultDataProvider<Fst extends LinkageFirst<Snd>, Snd extends LinkageSecond<Trd>, Trd> implements Provider<Fst, Snd, Trd> {
        private List<Fst> firstList;
        private boolean onlyTwo;
        private List<List<Snd>> secondList;
        private List<List<List<Trd>>> thirdList;

        public DefaultDataProvider(List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
            this.firstList = new ArrayList();
            this.secondList = new ArrayList();
            this.thirdList = new ArrayList();
            this.onlyTwo = false;
            this.firstList = list;
            this.secondList = list2;
            if (list3 == null || list3.size() == 0) {
                this.onlyTwo = true;
            } else {
                this.thirdList = list3;
            }
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<Fst> initFirstData() {
            return this.firstList;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public boolean isOnlyTwo() {
            return this.onlyTwo;
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<Snd> linkageSecondData(int i) {
            return this.secondList.get(i);
        }

        @Override // cn.qqtheme.framework.picker.LinkagePicker.Provider
        public List<Trd> linkageThirdData(int i, int i2) {
            return this.onlyTwo ? new ArrayList() : this.thirdList.get(i).get(i2);
        }
    }

    @Deprecated
    public static abstract class OnLinkageListener extends OnStringPickListener {
    }

    public interface OnPickListener<Fst, Snd, Trd> {
        void onPicked(Fst fst, Snd snd, Trd trd);
    }

    public static abstract class OnStringPickListener implements OnPickListener<StringLinkageFirst, StringLinkageSecond, String> {
        public abstract void onPicked(String str, String str2, String str3);

        @Override // cn.qqtheme.framework.picker.LinkagePicker.OnPickListener
        public void onPicked(StringLinkageFirst stringLinkageFirst, StringLinkageSecond stringLinkageSecond, String str) {
            onPicked(stringLinkageFirst.getName(), stringLinkageSecond.getName(), str);
        }
    }

    public interface OnWheelLinkageListener {
        void onLinkage(int i, int i2, int i3);
    }

    @Deprecated
    public static abstract class OnWheelListener {
        public abstract void onFirstWheeled(int i, String str);

        public abstract void onSecondWheeled(int i, String str);

        public void onThirdWheeled(int i, String str) {
        }
    }

    public interface Provider<Fst extends LinkageFirst<Snd>, Snd extends LinkageSecond<Trd>, Trd> {
        List<Fst> initFirstData();

        boolean isOnlyTwo();

        List<Snd> linkageSecondData(int i);

        List<Trd> linkageThirdData(int i, int i2);
    }

    private static class StringLinkageFirst implements LinkageFirst<StringLinkageSecond> {
        private String name;
        private List<StringLinkageSecond> seconds;

        @Override // cn.qqtheme.framework.entity.LinkageFirst, cn.qqtheme.framework.entity.LinkageItem
        public Object getId() {
            return this.name;
        }

        @Override // cn.qqtheme.framework.entity.WheelItem
        public String getName() {
            return this.name;
        }

        @Override // cn.qqtheme.framework.entity.LinkageFirst
        public List<StringLinkageSecond> getSeconds() {
            return this.seconds;
        }

        private StringLinkageFirst(String str, List<StringLinkageSecond> list) {
            this.seconds = new ArrayList();
            this.name = str;
            this.seconds = list;
        }
    }

    private static class StringLinkageSecond implements LinkageSecond<String> {
        private String name;
        private List<String> thirds;

        @Override // cn.qqtheme.framework.entity.LinkageSecond, cn.qqtheme.framework.entity.LinkageItem
        public Object getId() {
            return this.name;
        }

        @Override // cn.qqtheme.framework.entity.WheelItem
        public String getName() {
            return this.name;
        }

        @Override // cn.qqtheme.framework.entity.LinkageSecond
        public List<String> getThirds() {
            return this.thirds;
        }

        private StringLinkageSecond(String str, List<String> list) {
            this.thirds = new ArrayList();
            this.name = str;
            this.thirds = list;
        }
    }

    public LinkagePicker(Activity activity) {
        super(activity);
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 1.0f;
        this.secondColumnWeight = 1.0f;
        this.thirdColumnWeight = 1.0f;
        this.useWeight = true;
    }

    public int getSelectedFirstIndex() {
        return this.selectedFirstIndex;
    }

    public Fst getSelectedFirstItem() {
        if (this.selectedFirstItem == null) {
            this.selectedFirstItem = this.provider.initFirstData().get(this.selectedFirstIndex);
        }
        return this.selectedFirstItem;
    }

    public int getSelectedSecondIndex() {
        return this.selectedSecondIndex;
    }

    public Snd getSelectedSecondItem() {
        if (this.selectedSecondItem == null) {
            this.selectedSecondItem = this.provider.linkageSecondData(this.selectedFirstIndex).get(this.selectedSecondIndex);
        }
        return this.selectedSecondItem;
    }

    public int getSelectedThirdIndex() {
        return this.selectedThirdIndex;
    }

    public Trd getSelectedThirdItem() {
        if (this.selectedThirdItem == null) {
            List<Trd> listLinkageThirdData = this.provider.linkageThirdData(this.selectedFirstIndex, this.selectedSecondIndex);
            if (listLinkageThirdData.size() > 0) {
                this.selectedThirdItem = listLinkageThirdData.get(this.selectedThirdIndex);
            }
        }
        return this.selectedThirdItem;
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    protected View makeCenterView() {
        if (this.provider == null) {
            throw new IllegalArgumentException("please set data provider before make view");
        }
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewCreateWheelView = createWheelView();
        wheelViewCreateWheelView.setUseWeight(this.useWeight);
        wheelViewCreateWheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.firstColumnWeight));
        linearLayout.addView(wheelViewCreateWheelView);
        if (!TextUtils.isEmpty(this.firstLabel)) {
            TextView textViewCreateLabelView = createLabelView();
            textViewCreateLabelView.setText(this.firstLabel);
            linearLayout.addView(textViewCreateLabelView);
        }
        final WheelView wheelViewCreateWheelView2 = createWheelView();
        wheelViewCreateWheelView2.setUseWeight(this.useWeight);
        wheelViewCreateWheelView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.secondColumnWeight));
        linearLayout.addView(wheelViewCreateWheelView2);
        if (!TextUtils.isEmpty(this.secondLabel)) {
            TextView textViewCreateLabelView2 = createLabelView();
            textViewCreateLabelView2.setText(this.secondLabel);
            linearLayout.addView(textViewCreateLabelView2);
        }
        final WheelView wheelViewCreateWheelView3 = createWheelView();
        wheelViewCreateWheelView3.setUseWeight(this.useWeight);
        if (!this.provider.isOnlyTwo()) {
            wheelViewCreateWheelView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.thirdColumnWeight));
            linearLayout.addView(wheelViewCreateWheelView3);
            if (!TextUtils.isEmpty(this.thirdLabel)) {
                TextView textViewCreateLabelView3 = createLabelView();
                textViewCreateLabelView3.setText(this.thirdLabel);
                linearLayout.addView(textViewCreateLabelView3);
            }
        }
        wheelViewCreateWheelView.setItems(this.provider.initFirstData(), this.selectedFirstIndex);
        wheelViewCreateWheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.LinkagePicker.1
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                LinkagePicker linkagePicker = LinkagePicker.this;
                linkagePicker.selectedFirstItem = linkagePicker.provider.initFirstData().get(i);
                LinkagePicker.this.selectedFirstIndex = i;
                LogUtils.verbose(this, "change second data after first wheeled");
                LinkagePicker linkagePicker2 = LinkagePicker.this;
                linkagePicker2.selectedSecondIndex = 0;
                linkagePicker2.selectedThirdIndex = 0;
                List<Snd> listLinkageSecondData = linkagePicker2.provider.linkageSecondData(linkagePicker2.selectedFirstIndex);
                LinkagePicker linkagePicker3 = LinkagePicker.this;
                linkagePicker3.selectedSecondItem = listLinkageSecondData.get(linkagePicker3.selectedSecondIndex);
                wheelViewCreateWheelView2.setItems((List<?>) listLinkageSecondData, LinkagePicker.this.selectedSecondIndex);
                if (!LinkagePicker.this.provider.isOnlyTwo()) {
                    LinkagePicker linkagePicker4 = LinkagePicker.this;
                    List<Trd> listLinkageThirdData = linkagePicker4.provider.linkageThirdData(linkagePicker4.selectedFirstIndex, linkagePicker4.selectedSecondIndex);
                    LinkagePicker linkagePicker5 = LinkagePicker.this;
                    linkagePicker5.selectedThirdItem = listLinkageThirdData.get(linkagePicker5.selectedThirdIndex);
                    wheelViewCreateWheelView3.setItems((List<?>) listLinkageThirdData, LinkagePicker.this.selectedThirdIndex);
                }
                if (LinkagePicker.this.onWheelLinkageListener != null) {
                    LinkagePicker.this.onWheelLinkageListener.onLinkage(LinkagePicker.this.selectedFirstIndex, 0, 0);
                }
                if (LinkagePicker.this.onWheelListener != null) {
                    OnWheelListener onWheelListener = LinkagePicker.this.onWheelListener;
                    LinkagePicker linkagePicker6 = LinkagePicker.this;
                    onWheelListener.onFirstWheeled(linkagePicker6.selectedFirstIndex, linkagePicker6.selectedFirstItem.getName());
                }
            }
        });
        wheelViewCreateWheelView2.setItems(this.provider.linkageSecondData(this.selectedFirstIndex), this.selectedSecondIndex);
        wheelViewCreateWheelView2.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.LinkagePicker.2
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                LinkagePicker linkagePicker = LinkagePicker.this;
                linkagePicker.selectedSecondItem = linkagePicker.provider.linkageSecondData(linkagePicker.selectedFirstIndex).get(i);
                LinkagePicker linkagePicker2 = LinkagePicker.this;
                linkagePicker2.selectedSecondIndex = i;
                if (!linkagePicker2.provider.isOnlyTwo()) {
                    LogUtils.verbose(this, "change third data after second wheeled");
                    LinkagePicker linkagePicker3 = LinkagePicker.this;
                    linkagePicker3.selectedThirdIndex = 0;
                    List<Trd> listLinkageThirdData = linkagePicker3.provider.linkageThirdData(linkagePicker3.selectedFirstIndex, linkagePicker3.selectedSecondIndex);
                    LinkagePicker linkagePicker4 = LinkagePicker.this;
                    linkagePicker4.selectedThirdItem = listLinkageThirdData.get(linkagePicker4.selectedThirdIndex);
                    wheelViewCreateWheelView3.setItems((List<?>) listLinkageThirdData, LinkagePicker.this.selectedThirdIndex);
                }
                if (LinkagePicker.this.onWheelLinkageListener != null) {
                    OnWheelLinkageListener onWheelLinkageListener = LinkagePicker.this.onWheelLinkageListener;
                    LinkagePicker linkagePicker5 = LinkagePicker.this;
                    onWheelLinkageListener.onLinkage(linkagePicker5.selectedFirstIndex, linkagePicker5.selectedSecondIndex, 0);
                }
                if (LinkagePicker.this.onWheelListener != null) {
                    OnWheelListener onWheelListener = LinkagePicker.this.onWheelListener;
                    LinkagePicker linkagePicker6 = LinkagePicker.this;
                    onWheelListener.onSecondWheeled(linkagePicker6.selectedSecondIndex, linkagePicker6.selectedSecondItem.getName());
                }
            }
        });
        if (this.provider.isOnlyTwo()) {
            return linearLayout;
        }
        wheelViewCreateWheelView3.setItems(this.provider.linkageThirdData(this.selectedFirstIndex, this.selectedSecondIndex), this.selectedThirdIndex);
        wheelViewCreateWheelView3.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.LinkagePicker.3
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                LinkagePicker linkagePicker = LinkagePicker.this;
                linkagePicker.selectedThirdItem = linkagePicker.provider.linkageThirdData(linkagePicker.selectedFirstIndex, linkagePicker.selectedSecondIndex).get(i);
                LinkagePicker linkagePicker2 = LinkagePicker.this;
                linkagePicker2.selectedThirdIndex = i;
                if (linkagePicker2.onWheelLinkageListener != null) {
                    OnWheelLinkageListener onWheelLinkageListener = LinkagePicker.this.onWheelLinkageListener;
                    LinkagePicker linkagePicker3 = LinkagePicker.this;
                    onWheelLinkageListener.onLinkage(linkagePicker3.selectedFirstIndex, linkagePicker3.selectedSecondIndex, linkagePicker3.selectedThirdIndex);
                }
                if (LinkagePicker.this.onWheelListener != null) {
                    Trd trd = LinkagePicker.this.selectedThirdItem;
                    LinkagePicker.this.onWheelListener.onThirdWheeled(LinkagePicker.this.selectedThirdIndex, trd instanceof LinkageThird ? ((LinkageThird) trd).getName() : trd.toString());
                }
            }
        });
        return linearLayout;
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    public void onSubmit() {
        LinkageFirst selectedFirstItem = getSelectedFirstItem();
        LinkageSecond selectedSecondItem = getSelectedSecondItem();
        Trd selectedThirdItem = getSelectedThirdItem();
        if (!this.provider.isOnlyTwo()) {
            OnPickListener onPickListener = this.onPickListener;
            if (onPickListener != null) {
                onPickListener.onPicked(selectedFirstItem, selectedSecondItem, selectedThirdItem);
            }
            if (this.onLinkageListener != null) {
                this.onLinkageListener.onPicked(selectedFirstItem.getName(), selectedSecondItem.getName(), selectedThirdItem instanceof LinkageThird ? ((LinkageThird) selectedThirdItem).getName() : selectedThirdItem.toString());
                return;
            }
            return;
        }
        OnPickListener onPickListener2 = this.onPickListener;
        if (onPickListener2 != null) {
            onPickListener2.onPicked(selectedFirstItem, selectedSecondItem, null);
        }
        OnLinkageListener onLinkageListener = this.onLinkageListener;
        if (onLinkageListener != null) {
            onLinkageListener.onPicked(selectedFirstItem.getName(), selectedSecondItem.getName(), (String) null);
        }
    }

    public void setColumnWeight(float f2, float f3, float f4) {
        this.firstColumnWeight = f2;
        this.secondColumnWeight = f3;
        this.thirdColumnWeight = f4;
    }

    public void setLabel(String str, String str2) {
        setLabel(str, str2, "");
    }

    @Deprecated
    public void setOnLinkageListener(OnLinkageListener onLinkageListener) {
        this.onLinkageListener = onLinkageListener;
    }

    public void setOnPickListener(OnPickListener<Fst, Snd, Trd> onPickListener) {
        this.onPickListener = onPickListener;
    }

    public void setOnStringPickListener(OnStringPickListener onStringPickListener) {
        this.onPickListener = onStringPickListener;
    }

    public void setOnWheelLinkageListener(OnWheelLinkageListener onWheelLinkageListener) {
        this.onWheelLinkageListener = onWheelLinkageListener;
    }

    @Deprecated
    public void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    protected void setProvider(DataProvider dataProvider) {
        this.provider = dataProvider;
    }

    public void setSelectedIndex(int i, int i2) {
        setSelectedIndex(i, i2, 0);
    }

    public void setSelectedItem(Fst fst, Snd snd) {
        setSelectedItem(fst, snd, null);
    }

    public void setUseWeight(boolean z) {
        this.useWeight = z;
    }

    public void setLabel(String str, String str2, String str3) {
        this.firstLabel = str;
        this.secondLabel = str2;
        this.thirdLabel = str3;
    }

    protected void setProvider(Provider<Fst, Snd, Trd> provider) {
        this.provider = provider;
    }

    public void setSelectedIndex(int i, int i2, int i3) {
        this.selectedFirstIndex = i;
        this.selectedSecondIndex = i2;
        this.selectedThirdIndex = i3;
    }

    public void setSelectedItem(Fst fst, Snd snd, Trd trd) {
        Provider provider = this.provider;
        if (provider == null) {
            throw new IllegalArgumentException("please set data provider at first");
        }
        Iterator<Fst> it = provider.initFirstData().iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Fst next = it.next();
            if (next.equals(fst)) {
                this.selectedFirstIndex = i2;
                break;
            } else if (next.getId().equals(fst.getId()) || next.getName().contains(fst.getName())) {
                break;
            } else {
                i2++;
            }
        }
        this.selectedFirstIndex = i2;
        LogUtils.verbose("init select first: " + fst.getName() + ", index:" + this.selectedFirstIndex);
        Iterator<Snd> it2 = this.provider.linkageSecondData(this.selectedFirstIndex).iterator();
        int i3 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Snd next2 = it2.next();
            if (next2.equals(snd)) {
                this.selectedFirstIndex = i2;
                break;
            } else if (next2.getId().equals(snd.getId()) || next2.getName().contains(snd.getName())) {
                break;
            } else {
                i3++;
            }
        }
        this.selectedSecondIndex = i3;
        LogUtils.verbose("init select second: " + snd.getName() + ", index:" + this.selectedSecondIndex);
        if (this.provider.isOnlyTwo()) {
            return;
        }
        Iterator<Trd> it3 = this.provider.linkageThirdData(this.selectedFirstIndex, this.selectedSecondIndex).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Trd next3 = it3.next();
            if (next3.equals(trd)) {
                this.selectedThirdIndex = i;
                break;
            }
            if (next3 instanceof LinkageThird) {
                LinkageThird linkageThird = (LinkageThird) trd;
                LinkageThird linkageThird2 = (LinkageThird) next3;
                if (linkageThird2.getId().equals(linkageThird.getId()) || linkageThird2.getName().contains(linkageThird.getName())) {
                    break;
                }
            }
            i++;
        }
        this.selectedThirdIndex = i;
        LogUtils.verbose("init select third: " + trd + ", index:" + this.selectedThirdIndex);
    }

    public void setColumnWeight(float f2, float f3) {
        this.firstColumnWeight = f2;
        this.secondColumnWeight = f3;
        this.thirdColumnWeight = WheelView.DividerConfig.FILL;
    }

    public LinkagePicker(Activity activity, DataProvider dataProvider) {
        super(activity);
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 1.0f;
        this.secondColumnWeight = 1.0f;
        this.thirdColumnWeight = 1.0f;
        this.useWeight = true;
        this.provider = dataProvider;
    }

    public LinkagePicker(Activity activity, Provider<Fst, Snd, Trd> provider) {
        super(activity);
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 1.0f;
        this.secondColumnWeight = 1.0f;
        this.thirdColumnWeight = 1.0f;
        this.useWeight = true;
        this.provider = provider;
    }

    @Deprecated
    public LinkagePicker(Activity activity, List<Fst> list, List<List<Snd>> list2) {
        this(activity, list, list2, null);
    }

    @Deprecated
    public LinkagePicker(Activity activity, List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
        super(activity);
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 1.0f;
        this.secondColumnWeight = 1.0f;
        this.thirdColumnWeight = 1.0f;
        this.useWeight = true;
        this.provider = new DefaultDataProvider(list, list2, list3);
    }
}
