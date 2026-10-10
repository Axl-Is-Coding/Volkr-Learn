package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TTDislikeListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f6699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdapterView.OnItemClickListener f6700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdapterView.OnItemClickListener f6701c;

    public TTDislikeListView(Context context) {
        super(context);
        this.f6701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                if (!filterWord.hasSecondOptions()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f6699a != null) {
                        d.a(TTDislikeListView.this.f6699a, arrayList);
                    }
                }
                try {
                    if (TTDislikeListView.this.f6700b != null) {
                        TTDislikeListView.this.f6700b.onItemClick(adapterView, view, i, j);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        a();
    }

    public void setMaterialMeta(h hVar) {
        this.f6699a = hVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f6700b = onItemClickListener;
    }

    private void a() {
        super.setOnItemClickListener(this.f6701c);
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                if (!filterWord.hasSecondOptions()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f6699a != null) {
                        d.a(TTDislikeListView.this.f6699a, arrayList);
                    }
                }
                try {
                    if (TTDislikeListView.this.f6700b != null) {
                        TTDislikeListView.this.f6700b.onItemClick(adapterView, view, i, j);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i2) == null || !(TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                if (!filterWord.hasSecondOptions()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f6699a != null) {
                        d.a(TTDislikeListView.this.f6699a, arrayList);
                    }
                }
                try {
                    if (TTDislikeListView.this.f6700b != null) {
                        TTDislikeListView.this.f6700b.onItemClick(adapterView, view, i2, j);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        a();
    }
}
