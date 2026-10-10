package com.sandboxol.gamedetail.c.a.a;

import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.R;
import com.sandboxol.common.base.app.SingleTemplateActivity;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.gamedetail.view.dialog.marioguide.MarioGuideDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class X extends OnResponseListener<Map<String, List<String>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Z f17959b;

    X(Z z, String str) {
        this.f17959b = z;
        this.f17958a = str;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(final Map<String, List<String>> map) {
        ImageButton imageButton;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equals(this.f17958a)) {
                    if (!(this.f17959b.f17962a instanceof SingleTemplateActivity) || (imageButton = (ImageButton) ((Activity) this.f17959b.f17962a).findViewById(R.id.ibTemplateSecondRight)) == null) {
                        return;
                    }
                    imageButton.setVisibility(0);
                    imageButton.setImageResource(com.sandboxol.gamedetail.R.mipmap.ic_ads_game_detail_g2019_entrance);
                    imageButton.startAnimation(AnimationUtils.loadAnimation(this.f17959b.f17962a, com.sandboxol.gamedetail.R.anim.mario_icon_anim_scale));
                    final String str = this.f17958a;
                    imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.gamedetail.c.a.a.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f17995a.a(map, str, view);
                        }
                    });
                    return;
                }
            }
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    public /* synthetic */ void a(Map map, String str, View view) {
        new MarioGuideDialog(this.f17959b.f17962a, (List) map.get(str), str).show();
        ReportDataAdapter.onEvent(this.f17959b.f17962a, EventConstant.CLICK_EDITOR_BANNER, str);
    }
}
