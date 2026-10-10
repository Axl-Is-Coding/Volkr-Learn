package cn.qqtheme.framework.picker;

import android.app.Activity;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.picker.SinglePicker;

/* JADX INFO: loaded from: classes.dex */
public class NumberPicker extends SinglePicker<Number> {

    public static abstract class OnNumberPickListener implements SinglePicker.OnItemPickListener<Number> {
        public abstract void onNumberPicked(int i, Number number);

        @Override // cn.qqtheme.framework.picker.SinglePicker.OnItemPickListener
        public final void onItemPicked(int i, Number number) {
            onNumberPicked(i, number);
        }
    }

    public interface OnWheelListener extends SinglePicker.OnWheelListener<Number> {
    }

    public NumberPicker(Activity activity) {
        super(activity, new Number[0]);
    }

    public void setOnNumberPickListener(OnNumberPickListener onNumberPickListener) {
        super.setOnItemPickListener(onNumberPickListener);
    }

    @Deprecated
    public void setOnOptionPickListener(final OptionPicker.OnOptionPickListener onOptionPickListener) {
        setOnNumberPickListener(new OnNumberPickListener() { // from class: cn.qqtheme.framework.picker.NumberPicker.1
            @Override // cn.qqtheme.framework.picker.NumberPicker.OnNumberPickListener
            public void onNumberPicked(int i, Number number) {
                onOptionPickListener.onOptionPicked(i, number.toString());
            }
        });
    }

    public void setOnWheelListener(OnWheelListener onWheelListener) {
        super.setOnWheelListener((SinglePicker.OnWheelListener) onWheelListener);
    }

    public void setRange(int i, int i2) {
        setRange(i, i2, 1);
    }

    public void setSelectedItem(int i) {
        super.setSelectedItem(Integer.valueOf(i));
    }

    public void setRange(int i, int i2, int i3) {
        while (i <= i2) {
            addItem(Integer.valueOf(i));
            i += i3;
        }
    }

    public void setSelectedItem(double d2) {
        super.setSelectedItem(Double.valueOf(d2));
    }

    public void setRange(double d2, double d3, double d4) {
        while (d2 <= d3) {
            addItem(Double.valueOf(d2));
            d2 += d4;
        }
    }
}
