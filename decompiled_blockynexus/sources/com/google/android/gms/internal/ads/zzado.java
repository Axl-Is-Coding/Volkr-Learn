package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzado extends RelativeLayout {
    private static final float[] zzddi = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzddj;

    public zzado(Context context, zzadl zzadlVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzadlVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzddi, null, null));
        shapeDrawable.getPaint().setColor(zzadlVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzp.zzkt();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadlVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadlVar.getText());
            textView.setTextColor(zzadlVar.getTextColor());
            textView.setTextSize(zzadlVar.getTextSize());
            zzwm.zzpt();
            int iZzc = zzbbg.zzc(context, 4);
            zzwm.zzpt();
            textView.setPadding(iZzc, 0, zzbbg.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadq> listZzsc = zzadlVar.zzsc();
        if (listZzsc != null && listZzsc.size() > 1) {
            this.zzddj = new AnimationDrawable();
            Iterator<zzadq> it = listZzsc.iterator();
            while (it.hasNext()) {
                try {
                    this.zzddj.addFrame((Drawable) ObjectWrapper.unwrap(it.next().zzsg()), zzadlVar.zzsd());
                } catch (Exception e2) {
                    zzbbq.zzc("Error while getting drawable.", e2);
                }
            }
            com.google.android.gms.ads.internal.zzp.zzkt();
            imageView.setBackground(this.zzddj);
        } else if (listZzsc.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(listZzsc.get(0).zzsg()));
            } catch (Exception e3) {
                zzbbq.zzc("Error while getting drawable.", e3);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzddj;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
