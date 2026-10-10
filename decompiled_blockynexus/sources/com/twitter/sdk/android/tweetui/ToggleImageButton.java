package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes5.dex */
public class ToggleImageButton extends ImageButton {
    private static final int[] STATE_TOGGLED_ON = {R.attr.state_toggled_on};
    String contentDescriptionOff;
    String contentDescriptionOn;
    boolean isToggledOn;
    final boolean toggleOnClick;

    public ToggleImageButton(Context context) {
        this(context, null);
    }

    public boolean isToggledOn() {
        return this.isToggledOn;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (this.isToggledOn) {
            ImageButton.mergeDrawableStates(iArrOnCreateDrawableState, STATE_TOGGLED_ON);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.toggleOnClick) {
            toggle();
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z) {
        this.isToggledOn = z;
        setContentDescription(z ? this.contentDescriptionOn : this.contentDescriptionOff);
        refreshDrawableState();
    }

    public void toggle() {
        setToggledOn(!this.isToggledOn);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ToggleImageButton, i, 0);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.ToggleImageButton_contentDescriptionOn);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.ToggleImageButton_contentDescriptionOff);
            this.contentDescriptionOn = string == null ? (String) getContentDescription() : string;
            this.contentDescriptionOff = string2 == null ? (String) getContentDescription() : string2;
            this.toggleOnClick = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ToggleImageButton_toggleOnClick, true);
            setToggledOn(false);
        } finally {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }
}
