package com.opensource.svgaplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: compiled from: SVGAPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SVGAPlayer extends SVGAImageView {
    private HashMap _$_findViewCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context) {
        super(context);
        kotlin.jvm.internal.i.b(context, com.umeng.analytics.pro.b.Q);
    }

    @Override // com.opensource.svgaplayer.SVGAImageView
    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.opensource.svgaplayer.SVGAImageView
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.i.b(attributeSet, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.i.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.i.b(attributeSet, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        kotlin.jvm.internal.i.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.i.b(attributeSet, "attrs");
    }
}
