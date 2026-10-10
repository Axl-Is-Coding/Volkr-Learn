package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.media.MediaPlayer;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class o implements MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f3815a;

    o(k kVar) {
        this.f3815a = kVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3815a).f3803b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "onAudioComplete");
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "0");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaPlayer", "MediaPlayer.OnCompletion");
            k kVar = this.f3815a;
            kVar.a(kVar.f3807d.a(), jSONObject.toString());
        }
    }
}
