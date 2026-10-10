package io.rong.imkit.utilities.videocompressor;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import b.b.a.a.a;
import b.b.a.a.a.b;
import b.b.a.a.a.d;
import b.b.a.a.p;
import b.b.a.a.t;
import b.b.a.a.z;
import b.d.a.a.a.a.e;
import b.d.a.a.a.a.h;
import b.d.a.a.a.a.n;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.just.agentweb.WebIndicator;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(16)
public class Track {
    private static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    private long duration;
    private String handler;
    private a headerBox;
    private int height;
    private p sampleDescriptionBox;
    private LinkedList<Integer> syncSamples;
    private int timeScale;
    private long trackId;
    private float volume;
    private int width;
    private ArrayList<Sample> samples = new ArrayList<>();
    private Date creationTime = new Date();
    private ArrayList<Long> sampleDurations = new ArrayList<>();
    private boolean isAudio = false;
    private long lastPresentationTimeUs = 0;
    private boolean first = true;

    static {
        samplingFrequencyIndexMap.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(48000, 3);
        samplingFrequencyIndexMap.put(44100, 4);
        samplingFrequencyIndexMap.put(Integer.valueOf(LogType.UNEXP_KNOWN_REASON), 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(16000, 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(11025, 10);
        samplingFrequencyIndexMap.put(Integer.valueOf(WebIndicator.MAX_UNIFORM_SPEED_DURATION), 11);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public Track(int i, MediaFormat mediaFormat, boolean z) throws Exception {
        this.trackId = 0L;
        this.duration = 0L;
        this.headerBox = null;
        this.sampleDescriptionBox = null;
        this.syncSamples = null;
        this.volume = WheelView.DividerConfig.FILL;
        this.trackId = i;
        if (z) {
            this.sampleDurations.add(1024L);
            this.duration = 1024L;
            this.volume = 1.0f;
            this.timeScale = mediaFormat.getInteger("sample-rate");
            this.handler = "soun";
            this.headerBox = new t();
            this.sampleDescriptionBox = new p();
            b bVar = new b("mp4a");
            bVar.b(mediaFormat.getInteger("channel-count"));
            bVar.b(mediaFormat.getInteger("sample-rate"));
            bVar.a(1);
            bVar.c(16);
            b.d.a.a.a.b bVar2 = new b.d.a.a.a.b();
            h hVar = new h();
            hVar.a(0);
            n nVar = new n();
            nVar.a(2);
            hVar.a(nVar);
            e eVar = new e();
            eVar.b(64);
            eVar.c(5);
            eVar.a(1536);
            eVar.b(96000L);
            eVar.a(96000L);
            b.d.a.a.a.a.a aVar = new b.d.a.a.a.a.a();
            aVar.a(2);
            aVar.c(samplingFrequencyIndexMap.get(Integer.valueOf((int) bVar.o())).intValue());
            aVar.b(bVar.n());
            eVar.a(aVar);
            hVar.a(eVar);
            ByteBuffer byteBufferD = hVar.d();
            bVar2.a(hVar);
            bVar2.e(byteBufferD);
            bVar.a(bVar2);
            this.sampleDescriptionBox.a(bVar);
            return;
        }
        this.sampleDurations.add(3015L);
        this.duration = 3015L;
        this.width = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.height = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        this.timeScale = 90000;
        this.syncSamples = new LinkedList<>();
        this.handler = "vide";
        this.headerBox = new z();
        this.sampleDescriptionBox = new p();
        String string = mediaFormat.getString("mime");
        if (!string.equals("video/avc")) {
            if (string.equals("video/mp4v")) {
                d dVar = new d("mp4v");
                dVar.a(1);
                dVar.b(24);
                dVar.c(1);
                dVar.a(72.0d);
                dVar.b(72.0d);
                dVar.e(this.width);
                dVar.d(this.height);
                this.sampleDescriptionBox.a(dVar);
                return;
            }
            return;
        }
        d dVar2 = new d("avc1");
        dVar2.a(1);
        dVar2.b(24);
        dVar2.c(1);
        dVar2.a(72.0d);
        dVar2.b(72.0d);
        dVar2.e(this.width);
        dVar2.d(this.height);
        b.g.a.a.a aVar2 = new b.g.a.a.a();
        if (mediaFormat.getByteBuffer("csd-0") != null) {
            ArrayList arrayList = new ArrayList();
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
            byteBuffer.position(4);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            arrayList.add(bArr);
            ArrayList arrayList2 = new ArrayList();
            ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
            byteBuffer2.position(4);
            byte[] bArr2 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr2);
            arrayList2.add(bArr2);
            aVar2.b(arrayList);
            aVar2.a(arrayList2);
        }
        aVar2.a(13);
        aVar2.b(100);
        aVar2.d(-1);
        aVar2.c(-1);
        aVar2.e(-1);
        aVar2.f(1);
        aVar2.g(3);
        aVar2.h(0);
        dVar2.a(aVar2);
        this.sampleDescriptionBox.a(dVar2);
    }

    public void addSample(long j, MediaCodec.BufferInfo bufferInfo) {
        boolean z = (this.isAudio || (bufferInfo.flags & 1) == 0) ? false : true;
        this.samples.add(new Sample(j, bufferInfo.size));
        LinkedList<Integer> linkedList = this.syncSamples;
        if (linkedList != null && z) {
            linkedList.add(Integer.valueOf(this.samples.size()));
        }
        long j2 = bufferInfo.presentationTimeUs;
        long j3 = j2 - this.lastPresentationTimeUs;
        this.lastPresentationTimeUs = j2;
        long j4 = ((j3 * ((long) this.timeScale)) + 500000) / 1000000;
        if (!this.first) {
            ArrayList<Long> arrayList = this.sampleDurations;
            arrayList.add(arrayList.size() - 1, Long.valueOf(j4));
            this.duration += j4;
        }
        this.first = false;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getHandler() {
        return this.handler;
    }

    public int getHeight() {
        return this.height;
    }

    public a getMediaHeaderBox() {
        return this.headerBox;
    }

    public p getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    public ArrayList<Long> getSampleDurations() {
        return this.sampleDurations;
    }

    public ArrayList<Sample> getSamples() {
        return this.samples;
    }

    public long[] getSyncSamples() {
        LinkedList<Integer> linkedList = this.syncSamples;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        long[] jArr = new long[this.syncSamples.size()];
        for (int i = 0; i < this.syncSamples.size(); i++) {
            jArr[i] = this.syncSamples.get(i).intValue();
        }
        return jArr;
    }

    public int getTimeScale() {
        return this.timeScale;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public float getVolume() {
        return this.volume;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAudio() {
        return this.isAudio;
    }
}
