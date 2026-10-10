package cn.qqtheme.framework.picker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DoublePicker extends WheelPicker {
    private List<String> firstData;
    private CharSequence firstPrefixLabel;
    private CharSequence firstSuffixLabel;
    private OnPickListener onPickListener;
    private OnWheelListener onWheelListener;
    private List<String> secondData;
    private CharSequence secondPrefixLabel;
    private CharSequence secondSuffixLabel;
    private int selectedFirstIndex;
    private int selectedSecondIndex;

    public interface OnPickListener {
        void onPicked(int i, int i2);
    }

    public interface OnWheelListener {
        void onFirstWheeled(int i, String str);

        void onSecondWheeled(int i, String str);
    }

    public DoublePicker(Activity activity, List<String> list, List<String> list2) {
        super(activity);
        this.firstData = new ArrayList();
        this.secondData = new ArrayList();
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.firstData = list;
        this.secondData = list2;
    }

    public String getSelectedFirstItem() {
        int size = this.firstData.size();
        int i = this.selectedFirstIndex;
        return size > i ? this.firstData.get(i) : "";
    }

    public String getSelectedSecondItem() {
        int size = this.secondData.size();
        int i = this.selectedSecondIndex;
        return size > i ? this.secondData.get(i) : "";
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    protected View makeCenterView() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (!TextUtils.isEmpty(this.firstPrefixLabel)) {
            TextView textViewCreateLabelView = createLabelView();
            textViewCreateLabelView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewCreateLabelView.setText(this.firstPrefixLabel);
            linearLayout.addView(textViewCreateLabelView);
        }
        WheelView wheelViewCreateWheelView = createWheelView();
        wheelViewCreateWheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewCreateWheelView);
        if (!TextUtils.isEmpty(this.firstSuffixLabel)) {
            TextView textViewCreateLabelView2 = createLabelView();
            textViewCreateLabelView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewCreateLabelView2.setText(this.firstSuffixLabel);
            linearLayout.addView(textViewCreateLabelView2);
        }
        if (!TextUtils.isEmpty(this.secondPrefixLabel)) {
            TextView textViewCreateLabelView3 = createLabelView();
            textViewCreateLabelView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewCreateLabelView3.setText(this.secondPrefixLabel);
            linearLayout.addView(textViewCreateLabelView3);
        }
        WheelView wheelViewCreateWheelView2 = createWheelView();
        wheelViewCreateWheelView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(wheelViewCreateWheelView2);
        if (!TextUtils.isEmpty(this.secondSuffixLabel)) {
            TextView textViewCreateLabelView4 = createLabelView();
            textViewCreateLabelView4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textViewCreateLabelView4.setText(this.secondSuffixLabel);
            linearLayout.addView(textViewCreateLabelView4);
        }
        wheelViewCreateWheelView.setItems(this.firstData, this.selectedFirstIndex);
        wheelViewCreateWheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DoublePicker.1
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                DoublePicker.this.selectedFirstIndex = i;
                if (DoublePicker.this.onWheelListener != null) {
                    DoublePicker.this.onWheelListener.onFirstWheeled(DoublePicker.this.selectedFirstIndex, (String) DoublePicker.this.firstData.get(DoublePicker.this.selectedFirstIndex));
                }
            }
        });
        wheelViewCreateWheelView2.setItems(this.secondData, this.selectedSecondIndex);
        wheelViewCreateWheelView2.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DoublePicker.2
            @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
            public void onSelected(int i) {
                DoublePicker.this.selectedSecondIndex = i;
                if (DoublePicker.this.onWheelListener != null) {
                    DoublePicker.this.onWheelListener.onSecondWheeled(DoublePicker.this.selectedSecondIndex, (String) DoublePicker.this.secondData.get(DoublePicker.this.selectedSecondIndex));
                }
            }
        });
        return linearLayout;
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    public void onSubmit() {
        OnPickListener onPickListener = this.onPickListener;
        if (onPickListener != null) {
            onPickListener.onPicked(this.selectedFirstIndex, this.selectedSecondIndex);
        }
    }

    public void setFirstLabel(CharSequence charSequence, CharSequence charSequence2) {
        this.firstPrefixLabel = charSequence;
        this.firstSuffixLabel = charSequence2;
    }

    public void setOnPickListener(OnPickListener onPickListener) {
        this.onPickListener = onPickListener;
    }

    public void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    public void setSecondLabel(CharSequence charSequence, CharSequence charSequence2) {
        this.secondPrefixLabel = charSequence;
        this.secondSuffixLabel = charSequence2;
    }

    public void setSelectedIndex(int i, int i2) {
        if (i >= 0 && i < this.firstData.size()) {
            this.selectedFirstIndex = i;
        }
        if (i2 < 0 || i2 >= this.secondData.size()) {
            return;
        }
        this.selectedSecondIndex = i2;
    }
}
