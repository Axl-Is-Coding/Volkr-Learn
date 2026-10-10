package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: VideoTrafficTipLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f6621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.d f6623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f6624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6625f = false;
    private n g;
    private ViewStub h;
    private View i;

    /* JADX INFO: compiled from: VideoTrafficTipLayout.java */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* JADX INFO: compiled from: VideoTrafficTipLayout.java */
    public interface b {
        boolean h();

        void j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f6622c == null) {
            return;
        }
        d();
    }

    private void d() {
        View view = this.f6620a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void b(Context context, View view) {
        ViewStub viewStub;
        if (context == null || view == null || (viewStub = this.h) == null || viewStub.getParent() == null || this.f6620a != null) {
            return;
        }
        this.h.inflate();
        this.f6620a = view.findViewById(t.e(context, "tt_video_traffic_tip_layout"));
        this.f6621b = (TextView) view.findViewById(t.e(context, "tt_video_traffic_tip_tv"));
        view.findViewById(t.e(context, "tt_video_traffic_continue_play_btn")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.c();
                if (e.this.f6623d != null) {
                    e.this.f6623d.a(a.START_VIDEO, (String) null);
                }
            }
        });
    }

    public void a(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.i = view;
        this.f6622c = o.a().getApplicationContext();
        this.h = (ViewStub) LayoutInflater.from(context).inflate(t.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(t.e(context, "tt_video_traffic_tip_layout_viewStub"));
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        this.f6624e = bVar;
        this.f6623d = dVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i, n nVar) {
        Context context = this.f6622c;
        if (context == null || nVar == null) {
            return true;
        }
        b(context, this.i);
        this.g = nVar;
        if (i == 1 || i == 2) {
            return a(i);
        }
        return true;
    }

    private boolean a(int i) {
        b bVar;
        if (a() || this.f6625f) {
            return true;
        }
        if (this.f6623d != null && (bVar = this.f6624e) != null) {
            if (bVar.h()) {
                this.f6623d.e(null, null);
            }
            this.f6623d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.f6620a;
        return view != null && view.getVisibility() == 0;
    }

    private void a(n nVar, boolean z) {
        View view;
        String str;
        View view2;
        if (nVar == null || (view = this.f6620a) == null || this.f6622c == null || view.getVisibility() == 0) {
            return;
        }
        b bVar = this.f6624e;
        if (bVar != null) {
            bVar.j();
        }
        double d2 = nVar.d();
        Double.isNaN(d2);
        double dCeil = Math.ceil((d2 * 1.0d) / 1048576.0d);
        if (z) {
            str = String.format(t.a(this.f6622c, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(dCeil).floatValue()));
        } else {
            str = t.a(this.f6622c, "tt_video_without_wifi_tips") + t.a(this.f6622c, "tt_video_bytesize");
        }
        ac.a(this.f6620a, 0);
        ac.a(this.f6621b, str);
        if (!ac.d(this.f6620a) || (view2 = this.f6620a) == null) {
            return;
        }
        view2.bringToFront();
    }
}
