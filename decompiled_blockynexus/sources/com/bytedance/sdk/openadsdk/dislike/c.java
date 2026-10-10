package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTDislikeDialogDefault.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends TTDislikeDialogAbstract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTDislikeListView f6710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTDislikeListView f6711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f6712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f6713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f6714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f6715f;
    private h g;
    private a h;

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();

        void c();
    }

    /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
    public static class b extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6721a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<FilterWord> f6722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LayoutInflater f6723c;

        /* JADX INFO: compiled from: TTDislikeDialogDefault.java */
        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            TextView f6724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ImageView f6725b;

            private a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f6722b = list;
            this.f6723c = layoutInflater;
        }

        public void a(boolean z) {
            this.f6721a = z;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f6722b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f6722b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            a aVar;
            if (view == null) {
                aVar = new a();
                LayoutInflater layoutInflater = this.f6723c;
                viewInflate = layoutInflater.inflate(t.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f6724a = (TextView) viewInflate.findViewById(t.e(this.f6723c.getContext(), "tt_item_tv"));
                aVar.f6725b = (ImageView) viewInflate.findViewById(t.e(this.f6723c.getContext(), "tt_item_arrow"));
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f6722b.get(i);
            aVar.f6724a.setText(filterWord.getName());
            if (i != this.f6722b.size() - 1) {
                aVar.f6724a.setBackgroundResource(t.d(this.f6723c.getContext(), "tt_dislike_middle_seletor"));
            } else {
                aVar.f6724a.setBackgroundResource(t.d(this.f6723c.getContext(), "tt_dislike_bottom_seletor"));
            }
            if (this.f6721a && i == 0) {
                aVar.f6724a.setBackgroundResource(t.d(this.f6723c.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f6725b.setVisibility(0);
            } else {
                aVar.f6725b.setVisibility(8);
            }
            return viewInflate;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f6722b.clear();
            this.f6722b.addAll(list);
            notifyDataSetChanged();
        }

        public void a() {
            this.f6722b.clear();
            notifyDataSetChanged();
        }
    }

    public c(Context context, h hVar) {
        super(context, t.g(context, "tt_dislikeDialog"));
        this.g = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return t.f(getContext(), "tt_dislike_dialog_layout");
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ac.c(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{t.e(getContext(), "tt_filer_words_lv"), t.e(getContext(), "tt_filer_words_lv_second")};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        a();
        a(getContext());
        b();
        setMaterialMeta(this.g);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.h != null) {
                    c.this.h.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.h != null) {
                    c.this.h.b();
                }
            }
        });
        this.f6714e = new b(getLayoutInflater(), this.g.O());
        this.f6710a.setAdapter((ListAdapter) this.f6714e);
        this.f6715f = new b(getLayoutInflater(), new ArrayList());
        this.f6715f.a(false);
        this.f6711b.setAdapter((ListAdapter) this.f6715f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        RelativeLayout relativeLayout = this.f6712c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.f6713d;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.f6710a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        b bVar = this.f6715f;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.f6711b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    public void a(h hVar) {
        b bVar = this.f6714e;
        if (bVar == null || hVar == null) {
            return;
        }
        this.g = hVar;
        bVar.a(this.g.O());
        setMaterialMeta(this.g);
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 50;
            window.setAttributes(attributes);
        }
    }

    private void a(Context context) {
        this.f6712c = (RelativeLayout) findViewById(t.e(getContext(), "tt_dislike_title_content"));
        this.f6713d = findViewById(t.e(getContext(), "tt_dislike_line1"));
        findViewById(t.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.c();
                if (c.this.h != null) {
                    c.this.h.c();
                }
            }
        });
        this.f6710a = (TTDislikeListView) findViewById(t.e(getContext(), "tt_filer_words_lv"));
        this.f6710a.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        c.this.a(filterWord);
                        if (c.this.h != null) {
                            c.this.h.a(i, filterWord);
                            return;
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (c.this.h != null) {
                    try {
                        c.this.h.a(i, c.this.g.O().get(i));
                    } catch (Throwable unused2) {
                    }
                }
                c.this.dismiss();
            }
        });
        this.f6711b = (TTDislikeListView) findViewById(t.e(getContext(), "tt_filer_words_lv_second"));
        this.f6711b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (c.this.h != null) {
                    try {
                        c.this.h.a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                    } catch (Throwable unused) {
                    }
                }
                c.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        b bVar = this.f6715f;
        if (bVar != null) {
            bVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.f6712c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.f6713d;
        if (view != null) {
            view.setVisibility(0);
        }
        TTDislikeListView tTDislikeListView = this.f6710a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView2 = this.f6711b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
        }
    }
}
