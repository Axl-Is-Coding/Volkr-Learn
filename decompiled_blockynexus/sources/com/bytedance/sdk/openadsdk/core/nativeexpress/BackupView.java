package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
public abstract class BackupView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f6266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.d.h f6267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.dislike.b f6268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected TTDislikeDialogAbstract f6269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f6270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f6271f;
    protected int g;

    public BackupView(Context context) {
        super(context);
        this.f6270e = "embeded_ad";
        setTag("tt_express_backup_fl_tag_26");
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f6269d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f6268c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        }
    }

    protected abstract void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar);

    protected String getDescription() {
        return !TextUtils.isEmpty(this.f6267b.G()) ? this.f6267b.G() : !TextUtils.isEmpty(this.f6267b.H()) ? this.f6267b.H() : "";
    }

    protected String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6267b;
        return hVar == null ? "" : (hVar.K() == null || TextUtils.isEmpty(this.f6267b.K().b())) ? !TextUtils.isEmpty(this.f6267b.w()) ? this.f6267b.w() : "" : this.f6267b.K().b();
    }

    public float getRealHeight() {
        return ac.b(this.f6266a, this.g);
    }

    public float getRealWidth() {
        return ac.b(this.f6266a, this.f6271f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    protected String getTitle() {
        return (this.f6267b.K() == null || TextUtils.isEmpty(this.f6267b.K().b())) ? !TextUtils.isEmpty(this.f6267b.w()) ? this.f6267b.w() : !TextUtils.isEmpty(this.f6267b.G()) ? this.f6267b.G() : "" : this.f6267b.K().b();
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.b) {
            this.f6268c = (com.bytedance.sdk.openadsdk.dislike.b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        if (tTDislikeDialogAbstract != null && (hVar = this.f6267b) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(hVar);
        }
        this.f6269d = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    protected void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.f6266a;
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6267b;
            String str = this.f6270e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.a(context, hVar, str, ab.a(str));
        } else {
            Context context2 = this.f6266a;
            com.bytedance.sdk.openadsdk.core.d.h hVar2 = this.f6267b;
            String str2 = this.f6270e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.b(context2, hVar2, str2, ab.a(str2));
        }
        view.setOnTouchListener(bVar);
        view.setOnClickListener(bVar);
        bVar.a(new a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
            public void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
                BackupView.this.a(i, fVar);
            }
        });
    }
}
