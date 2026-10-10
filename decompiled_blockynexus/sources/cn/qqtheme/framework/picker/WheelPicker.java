package cn.qqtheme.framework.picker;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.qqtheme.framework.popup.ConfirmPopup;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public abstract class WheelPicker extends ConfirmPopup<View> {
    protected View contentView;
    protected boolean cycleDisable;
    protected WheelView.DividerConfig dividerConfig;
    protected float lineSpaceMultiplier;
    protected int offset;
    protected int padding;
    protected int textColorFocus;
    protected int textColorNormal;
    protected int textSize;

    public WheelPicker(Activity activity) {
        super(activity);
        this.lineSpaceMultiplier = 2.5f;
        this.padding = -1;
        this.textSize = 16;
        this.textColorNormal = -4473925;
        this.textColorFocus = WheelView.TEXT_COLOR_FOCUS;
        this.offset = 3;
        this.cycleDisable = true;
        this.dividerConfig = new WheelView.DividerConfig();
    }

    protected TextView createLabelView() {
        TextView textView = new TextView(this.activity);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextColor(this.textColorFocus);
        textView.setTextSize(this.textSize);
        return textView;
    }

    protected WheelView createWheelView() {
        WheelView wheelView = new WheelView(this.activity);
        wheelView.setLineSpaceMultiplier(this.lineSpaceMultiplier);
        wheelView.setPadding(this.padding);
        wheelView.setTextSize(this.textSize);
        wheelView.setTextColor(this.textColorNormal, this.textColorFocus);
        wheelView.setDividerConfig(this.dividerConfig);
        wheelView.setOffset(this.offset);
        wheelView.setCycleDisable(this.cycleDisable);
        return wheelView;
    }

    @Override // cn.qqtheme.framework.popup.BasicPopup
    public View getContentView() {
        if (this.contentView == null) {
            this.contentView = makeCenterView();
        }
        return this.contentView;
    }

    public void setCycleDisable(boolean z) {
        this.cycleDisable = z;
    }

    public void setDividerColor(int i) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setVisible(true);
        this.dividerConfig.setColor(i);
    }

    public void setDividerConfig(WheelView.DividerConfig dividerConfig) {
        if (dividerConfig != null) {
            this.dividerConfig = dividerConfig;
            return;
        }
        this.dividerConfig = new WheelView.DividerConfig();
        this.dividerConfig.setVisible(false);
        this.dividerConfig.setShadowVisible(false);
    }

    public void setDividerRatio(float f2) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setRatio(f2);
    }

    public void setDividerVisible(boolean z) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setVisible(z);
    }

    @Deprecated
    public void setLineColor(int i) {
        setDividerColor(i);
    }

    @Deprecated
    public void setLineConfig(WheelView.DividerConfig dividerConfig) {
        setDividerConfig(dividerConfig);
    }

    public final void setLineSpaceMultiplier(float f2) {
        this.lineSpaceMultiplier = f2;
    }

    @Deprecated
    public void setLineVisible(boolean z) {
        setDividerVisible(z);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setPadding(int i) {
        this.padding = i;
    }

    public void setShadowColor(int i) {
        setShadowColor(i, 100);
    }

    public void setShadowVisible(boolean z) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setShadowVisible(z);
    }

    public void setTextColor(int i, int i2) {
        this.textColorFocus = i;
        this.textColorNormal = i2;
    }

    public void setTextSize(int i) {
        this.textSize = i;
    }

    public void setShadowColor(int i, int i2) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setShadowColor(i);
        this.dividerConfig.setShadowAlpha(i2);
    }

    public void setTextColor(int i) {
        this.textColorFocus = i;
    }
}
