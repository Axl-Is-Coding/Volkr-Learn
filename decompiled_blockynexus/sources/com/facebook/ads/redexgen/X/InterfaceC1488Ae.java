package com.facebook.ads.redexgen.X;

import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1488Ae {
    void onAudioSessionId(C1487Ad c1487Ad, int i);

    void onAudioUnderrun(C1487Ad c1487Ad, int i, long j, long j2);

    void onDecoderDisabled(C1487Ad c1487Ad, int i, BU bu);

    void onDecoderEnabled(C1487Ad c1487Ad, int i, BU bu);

    void onDecoderInitialized(C1487Ad c1487Ad, int i, String str, long j);

    void onDecoderInputFormatChanged(C1487Ad c1487Ad, int i, Format format);

    void onDownstreamFormatChanged(C1487Ad c1487Ad, FL fl);

    void onDrmKeysLoaded(C1487Ad c1487Ad);

    void onDrmKeysRemoved(C1487Ad c1487Ad);

    void onDrmKeysRestored(C1487Ad c1487Ad);

    void onDrmSessionManagerError(C1487Ad c1487Ad, Exception exc);

    void onDroppedVideoFrames(C1487Ad c1487Ad, int i, long j);

    void onLoadError(C1487Ad c1487Ad, FK fk, FL fl, IOException iOException, boolean z);

    void onLoadingChanged(C1487Ad c1487Ad, boolean z);

    void onMediaPeriodCreated(C1487Ad c1487Ad);

    void onMediaPeriodReleased(C1487Ad c1487Ad);

    void onMetadata(C1487Ad c1487Ad, Metadata metadata);

    void onPlaybackParametersChanged(C1487Ad c1487Ad, AF af);

    void onPlayerError(C1487Ad c1487Ad, C14789u c14789u);

    void onPlayerStateChanged(C1487Ad c1487Ad, boolean z, int i);

    void onPositionDiscontinuity(C1487Ad c1487Ad, int i);

    void onReadingStarted(C1487Ad c1487Ad);

    void onRenderedFirstFrame(C1487Ad c1487Ad, Surface surface);

    void onSeekProcessed(C1487Ad c1487Ad);

    void onSeekStarted(C1487Ad c1487Ad);

    void onTimelineChanged(C1487Ad c1487Ad, int i);

    void onTracksChanged(C1487Ad c1487Ad, TrackGroupArray trackGroupArray, C1644Gz c1644Gz);

    void onVideoSizeChanged(C1487Ad c1487Ad, int i, int i2, int i3, float f2);
}
