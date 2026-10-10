package cn.qqtheme.framework.picker;

import android.app.Activity;
import cn.qqtheme.framework.picker.SinglePicker;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OptionPicker extends SinglePicker<String> {

    public static abstract class OnOptionPickListener implements SinglePicker.OnItemPickListener<String> {
        public abstract void onOptionPicked(int i, String str);

        @Override // cn.qqtheme.framework.picker.SinglePicker.OnItemPickListener
        public final void onItemPicked(int i, String str) {
            onOptionPicked(i, str);
        }
    }

    public interface OnWheelListener extends SinglePicker.OnWheelListener<String> {
    }

    public OptionPicker(Activity activity, String[] strArr) {
        super(activity, strArr);
    }

    public void setOnOptionPickListener(OnOptionPickListener onOptionPickListener) {
        super.setOnItemPickListener(onOptionPickListener);
    }

    public void setOnWheelListener(OnWheelListener onWheelListener) {
        super.setOnWheelListener((SinglePicker.OnWheelListener) onWheelListener);
    }

    public OptionPicker(Activity activity, List<String> list) {
        super(activity, list);
    }
}
