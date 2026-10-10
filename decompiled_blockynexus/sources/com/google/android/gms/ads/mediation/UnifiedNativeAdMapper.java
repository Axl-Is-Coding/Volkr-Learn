package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcjt;
    private String zzdsl;
    private String zzerg;
    private List<NativeAd.Image> zzerh;
    private NativeAd.Image zzeri;
    private String zzerj;
    private String zzerl;
    private String zzerm;
    private View zzern;
    private boolean zzero;
    private String zzerq;
    private Double zzerr;
    private View zzers;
    private Object zzert;
    private boolean zzeru;
    private boolean zzerv;
    private float zzerw;

    public View getAdChoicesContent() {
        return this.zzers;
    }

    public final String getAdvertiser() {
        return this.zzerq;
    }

    public final String getBody() {
        return this.zzdsl;
    }

    public final String getCallToAction() {
        return this.zzerj;
    }

    public float getCurrentTime() {
        return WheelView.DividerConfig.FILL;
    }

    public float getDuration() {
        return WheelView.DividerConfig.FILL;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getHeadline() {
        return this.zzerg;
    }

    public final NativeAd.Image getIcon() {
        return this.zzeri;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzerh;
    }

    public float getMediaContentAspectRatio() {
        return this.zzerw;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzerv;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzeru;
    }

    public final String getPrice() {
        return this.zzerm;
    }

    public final Double getStarRating() {
        return this.zzerr;
    }

    public final String getStore() {
        return this.zzerl;
    }

    public final VideoController getVideoController() {
        return this.zzcjt;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.zzero;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.zzers = view;
    }

    public final void setAdvertiser(String str) {
        this.zzerq = str;
    }

    public final void setBody(String str) {
        this.zzdsl = str;
    }

    public final void setCallToAction(String str) {
        this.zzerj = str;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.zzero = z;
    }

    public final void setHeadline(String str) {
        this.zzerg = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzeri = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzerh = list;
    }

    public void setMediaContentAspectRatio(float f2) {
        this.zzerw = f2;
    }

    public void setMediaView(View view) {
        this.zzern = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzerv = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzeru = z;
    }

    public final void setPrice(String str) {
        this.zzerm = str;
    }

    public final void setStarRating(Double d2) {
        this.zzerr = d2;
    }

    public final void setStore(String str) {
        this.zzerl = str;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.zzcjt = videoController;
    }

    public final View zzadh() {
        return this.zzern;
    }

    public final Object zzjx() {
        return this.zzert;
    }

    public final void zzn(Object obj) {
        this.zzert = obj;
    }
}
