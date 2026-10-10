package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class PartyHallHeaderItemView extends FrameLayout {
    private ImageView ivHeader;
    private ImageView ivSex;
    private TextView tvNickName;
    private View vCaptain;

    public PartyHallHeaderItemView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.item_party_hall_header, this);
        this.vCaptain = findViewById(R.id.v_captain);
        this.ivSex = (ImageView) findViewById(R.id.iv_sex);
        this.tvNickName = (TextView) findViewById(R.id.tv_nickname);
        this.ivHeader = (ImageView) findViewById(R.id.iv_header);
    }

    public void isCaptain(boolean z) {
        this.vCaptain.setEnabled(!z);
    }

    public void setNickName(String str) {
        this.tvNickName.setText(str);
    }

    public void setPicUrl(String str) {
        try {
            com.bumptech.glide.c.c(getContext()).mo55load(str).into(this.ivHeader);
        } catch (Exception unused) {
        }
    }

    public void setSex(int i) {
        if (i == 1) {
            this.ivSex.setImageDrawable(androidx.core.content.b.c(getContext(), R.mipmap.ic_male));
        } else if (i == 2) {
            this.ivSex.setImageDrawable(androidx.core.content.b.c(getContext(), R.mipmap.ic_female));
        }
    }

    public PartyHallHeaderItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartyHallHeaderItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
