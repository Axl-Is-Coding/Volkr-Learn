package com.sandboxol.gamedetail.view.dialog.marioguide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sandboxol.gamedetail.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HandleLinearLayoutView extends LinearLayout {
    private List<ImageView> imageViews;
    private LinearLayout llHandle;

    public HandleLinearLayoutView(Context context) {
        this(context, null);
    }

    private void addView(boolean z) {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_machine_selector));
        imageView.setEnabled(z);
        this.imageViews.add(imageView);
        this.llHandle.addView(imageView);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_handle_linearlayout, this);
        this.llHandle = (LinearLayout) findViewById(R.id.llHandle);
    }

    public void addViews(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                addView(false);
            } else {
                addView(true);
            }
        }
    }

    public void changeStatus(int i) {
        Iterator<ImageView> it = this.imageViews.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(true);
        }
        List<ImageView> list = this.imageViews;
        list.get(Math.abs(i % list.size())).setEnabled(false);
    }

    public HandleLinearLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HandleLinearLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imageViews = new ArrayList();
        initView(context);
    }
}
