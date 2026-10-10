package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RewardDislikeDialog extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f5980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTDislikeListView f5981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TTDislikeListView f5982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f5983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f5984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c.b f5985f;
    private c.b g;
    private h h;
    private a i;
    private boolean j;

    public interface a {
        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);

        void c(View view);
    }

    public RewardDislikeDialog(Context context, h hVar) {
        this(context);
        this.h = hVar;
        c();
    }

    private void d() {
        this.f5983d = (RelativeLayout) this.f5980a.findViewById(t.e(getContext(), "tt_dislike_title_content"));
        this.f5984e = this.f5980a.findViewById(t.e(getContext(), "tt_dislike_line1"));
        this.f5980a.findViewById(t.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RewardDislikeDialog.this.e();
                if (RewardDislikeDialog.this.i != null) {
                    RewardDislikeDialog.this.i.c(view);
                }
            }
        });
        this.f5981b = (TTDislikeListView) this.f5980a.findViewById(t.e(getContext(), "tt_filer_words_lv"));
        this.f5981b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        RewardDislikeDialog.this.a(filterWord);
                        if (RewardDislikeDialog.this.i != null) {
                            RewardDislikeDialog.this.i.a(i, filterWord);
                            return;
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (RewardDislikeDialog.this.i != null) {
                    try {
                        RewardDislikeDialog.this.i.a(i, RewardDislikeDialog.this.h.O().get(i));
                    } catch (Throwable unused2) {
                    }
                }
                RewardDislikeDialog.this.b();
            }
        });
        this.f5982c = (TTDislikeListView) this.f5980a.findViewById(t.e(getContext(), "tt_filer_words_lv_second"));
        this.f5982c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (RewardDislikeDialog.this.i != null) {
                    try {
                        RewardDislikeDialog.this.i.a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                    } catch (Throwable unused) {
                    }
                }
                RewardDislikeDialog.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        RelativeLayout relativeLayout = this.f5983d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.f5984e;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.f5981b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        c.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.f5982c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    public void setCallback(a aVar) {
        this.i = aVar;
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.f5985f = new c.b(layoutInflaterFrom, this.h.O());
        this.f5981b.setAdapter((ListAdapter) this.f5985f);
        this.g = new c.b(layoutInflaterFrom, new ArrayList());
        this.g.a(false);
        this.f5982c.setAdapter((ListAdapter) this.g);
        this.f5981b.setMaterialMeta(this.h);
        this.f5982c.setMaterialMeta(this.h);
    }

    public void b() {
        setVisibility(8);
        this.j = false;
        a aVar = this.i;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RewardDislikeDialog.this.b();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f5980a = LayoutInflater.from(context).inflate(t.f(context, "tt_dislike_dialog_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ac.c(getContext(), 20.0f);
        layoutParams.rightMargin = ac.c(getContext(), 20.0f);
        this.f5980a.setLayoutParams(layoutParams);
        this.f5980a.setClickable(true);
        d();
        c();
    }

    public RewardDislikeDialog(Context context) {
        this(context, (AttributeSet) null);
    }

    public RewardDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f5980a.getParent() == null) {
            addView(this.f5980a);
        }
        e();
        setVisibility(0);
        this.j = true;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        c.b bVar = this.g;
        if (bVar != null) {
            bVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.f5983d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.f5984e;
        if (view != null) {
            view.setVisibility(0);
        }
        TTDislikeListView tTDislikeListView = this.f5981b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView2 = this.f5982c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
        }
    }
}
