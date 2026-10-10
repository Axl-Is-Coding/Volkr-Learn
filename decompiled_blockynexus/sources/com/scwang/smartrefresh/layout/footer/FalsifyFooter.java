package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.a.f;
import com.scwang.smartrefresh.layout.a.i;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes4.dex */
public class FalsifyFooter extends InternalAbstract implements f {
    private i mRefreshKernel;

    public FalsifyFooter(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int iA = c.a(5.0f);
            Context context = getContext();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth(c.a(1.0f));
            float f2 = iA;
            paint.setPathEffect(new DashPathEffect(new float[]{f2, f2, f2, f2}, 1.0f));
            canvas.drawRect(f2, f2, getWidth() - iA, getBottom() - iA, paint);
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.srl_component_falsify, FalsifyFooter.class.getSimpleName(), Float.valueOf(c.a(getHeight()))));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(getHeight(), FileTypeUtils.GIGABYTE));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onInitialized(i iVar, int i, int i2) {
        this.mRefreshKernel = iVar;
        iVar.b().setEnableAutoLoadMore(false);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onReleased(j jVar, int i, int i2) {
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.a(RefreshState.None);
            this.mRefreshKernel.a(RefreshState.LoadFinish);
        }
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
