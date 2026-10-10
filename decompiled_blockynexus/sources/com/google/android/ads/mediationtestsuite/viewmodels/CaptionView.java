package com.google.android.ads.mediationtestsuite.viewmodels;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.Caption;

/* JADX INFO: loaded from: classes.dex */
public class CaptionView extends FrameLayout {
    private ImageView captionImageView;
    private TextView captionLabel;
    private View container;
    private Caption viewModel;

    public CaptionView(Context context, Caption caption) {
        super(context);
        this.viewModel = caption;
        initializeViews(context);
        configureViews();
    }

    private void configureViews() {
        TestState testState = this.viewModel.getTestState();
        int color = getResources().getColor(testState.getBackgroundColorResId());
        Drawable drawableI = androidx.core.graphics.drawable.a.i(androidx.core.content.b.c(getContext(), R.drawable.gmts_caption_background));
        androidx.core.graphics.drawable.a.b(drawableI, color);
        ViewCompat.a(this.container, drawableI);
        androidx.core.widget.g.a(this.captionImageView, ColorStateList.valueOf(getResources().getColor(testState.getImageTintColorResId())));
        this.captionImageView.setImageResource(testState.getDrawableResourceId());
        this.captionLabel.setText(this.viewModel.getComponent().getStringResId());
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.gmts_view_info_caption, this);
        this.captionImageView = (ImageView) findViewById(R.id.gmts_caption_image);
        this.captionLabel = (TextView) findViewById(R.id.gmts_caption_label);
        this.container = findViewById(R.id.gmts_container);
        if (this.viewModel != null) {
            configureViews();
        }
    }

    public CaptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeViews(context);
    }

    public CaptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }
}
