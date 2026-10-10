package io.rong.imkit.utilities.videocompressor;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.support.v4.media.session.PlaybackStateCompat;
import b.b.a.a;
import b.b.a.a.b;
import b.b.a.a.d;
import b.b.a.a.g;
import b.b.a.a.h;
import b.b.a.a.j;
import b.b.a.a.k;
import b.b.a.a.l;
import b.b.a.a.m;
import b.b.a.a.n;
import b.b.a.a.o;
import b.b.a.a.q;
import b.b.a.a.r;
import b.b.a.a.s;
import b.b.a.a.u;
import b.b.a.a.v;
import b.b.a.a.w;
import b.b.a.a.x;
import b.b.a.a.y;
import b.b.a.c;
import b.b.a.e;
import b.d.a.f;
import cn.qqtheme.framework.util.ConvertUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(16)
public class MP4Builder {
    private InterleaveChunkMdat mdat = null;
    private Mp4Movie currentMp4Movie = null;
    private FileOutputStream fos = null;
    private FileChannel fc = null;
    private long dataOffset = 0;
    private long writedSinceLastMdat = 0;
    private boolean writeNewMdat = true;
    private HashMap<Track, long[]> track2SampleSizes = new HashMap<>();
    private ByteBuffer sizeBuffer = null;

    private class InterleaveChunkMdat implements b {
        private long contentSize;
        private long dataOffset;
        private d parent;

        private InterleaveChunkMdat() {
            this.contentSize = ConvertUtils.GB;
            this.dataOffset = 0L;
        }

        private boolean isSmallBox(long j) {
            return j + 8 < 4294967296L;
        }

        @Override // b.b.a.a.b
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (isSmallBox(size)) {
                e.a(byteBufferAllocate, size);
            } else {
                e.a(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(c.a("mdat"));
            if (isSmallBox(size)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                e.b(byteBufferAllocate, size);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }

        public long getContentSize() {
            return this.contentSize;
        }

        public long getOffset() {
            return this.dataOffset;
        }

        public d getParent() {
            return this.parent;
        }

        @Override // b.b.a.a.b
        public long getSize() {
            return this.contentSize + 16;
        }

        public String getType() {
            return "mdat";
        }

        public void parse(f fVar, ByteBuffer byteBuffer, long j, a aVar) throws IOException {
        }

        public void setContentSize(long j) {
            this.contentSize = j;
        }

        public void setDataOffset(long j) {
            this.dataOffset = j;
        }

        @Override // b.b.a.a.b
        public void setParent(d dVar) {
            this.parent = dVar;
        }
    }

    private void flushCurrentMdat() throws Exception {
        long jPosition = this.fc.position();
        this.fc.position(this.mdat.getOffset());
        this.mdat.getBox(this.fc);
        this.fc.position(jPosition);
        this.mdat.setDataOffset(0L);
        this.mdat.setContentSize(0L);
        this.fos.flush();
    }

    public static long gcd(long j, long j2) {
        return j2 == 0 ? j : gcd(j2, j % j2);
    }

    public int addTrack(MediaFormat mediaFormat, boolean z) throws Exception {
        return this.currentMp4Movie.addTrack(mediaFormat, z);
    }

    protected h createFileTypeBox() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("3gp4");
        return new h("isom", 0L, linkedList);
    }

    public MP4Builder createMovie(Mp4Movie mp4Movie) throws Exception {
        this.currentMp4Movie = mp4Movie;
        this.fos = new FileOutputStream(mp4Movie.getCacheFile());
        this.fc = this.fos.getChannel();
        h hVarCreateFileTypeBox = createFileTypeBox();
        hVarCreateFileTypeBox.getBox(this.fc);
        this.dataOffset += hVarCreateFileTypeBox.getSize();
        this.writedSinceLastMdat += this.dataOffset;
        this.mdat = new InterleaveChunkMdat();
        this.sizeBuffer = ByteBuffer.allocateDirect(4);
        return this;
    }

    protected n createMovieBox(Mp4Movie mp4Movie) {
        n nVar = new n();
        o oVar = new o();
        oVar.a(new Date());
        oVar.b(new Date());
        oVar.a(b.d.a.b.h.f2529a);
        long timescale = getTimescale(mp4Movie);
        long j = 0;
        for (Track track : mp4Movie.getTracks()) {
            long duration = (track.getDuration() * timescale) / ((long) track.getTimeScale());
            if (duration > j) {
                j = duration;
            }
        }
        oVar.a(j);
        oVar.c(timescale);
        oVar.b(mp4Movie.getTracks().size() + 1);
        nVar.a(oVar);
        Iterator<Track> it = mp4Movie.getTracks().iterator();
        while (it.hasNext()) {
            nVar.a(createTrackBox(it.next(), mp4Movie));
        }
        return nVar;
    }

    protected b createStbl(Track track) {
        r rVar = new r();
        createStsd(track, rVar);
        createStts(track, rVar);
        createStss(track, rVar);
        createStsc(track, rVar);
        createStsz(track, rVar);
        createStco(track, rVar);
        return rVar;
    }

    protected void createStco(Track track, r rVar) {
        ArrayList arrayList = new ArrayList();
        long size = -1;
        for (Sample sample : track.getSamples()) {
            long offset = sample.getOffset();
            if (size != -1 && size != offset) {
                size = -1;
            }
            if (size == -1) {
                arrayList.add(Long.valueOf(offset));
            }
            size = sample.getSize() + offset;
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        u uVar = new u();
        uVar.a(jArr);
        rVar.a(uVar);
    }

    protected void createStsc(Track track, r rVar) {
        s sVar = new s();
        sVar.a(new LinkedList());
        int size = track.getSamples().size();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 1;
        while (i < size) {
            Sample sample = track.getSamples().get(i);
            i2++;
            if (i == size + (-1) || sample.getOffset() + sample.getSize() != track.getSamples().get(i + 1).getOffset()) {
                if (i3 != i2) {
                    sVar.h().add(new s.a(i4, i2, 1L));
                } else {
                    i2 = i3;
                }
                i4++;
                i3 = i2;
                i2 = 0;
            }
            i++;
        }
        rVar.a(sVar);
    }

    protected void createStsd(Track track, r rVar) {
        rVar.a(track.getSampleDescriptionBox());
    }

    protected void createStss(Track track, r rVar) {
        long[] syncSamples = track.getSyncSamples();
        if (syncSamples == null || syncSamples.length <= 0) {
            return;
        }
        v vVar = new v();
        vVar.a(syncSamples);
        rVar.a(vVar);
    }

    protected void createStsz(Track track, r rVar) {
        q qVar = new q();
        qVar.a(this.track2SampleSizes.get(track));
        rVar.a(qVar);
    }

    protected void createStts(Track track, r rVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = track.getSampleDurations().iterator();
        w.a aVar = null;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (aVar == null || aVar.b() != jLongValue) {
                aVar = new w.a(1L, jLongValue);
                arrayList.add(aVar);
            } else {
                aVar.a(aVar.a() + 1);
            }
        }
        w wVar = new w();
        wVar.a(arrayList);
        rVar.a(wVar);
    }

    protected x createTrackBox(Track track, Mp4Movie mp4Movie) {
        x xVar = new x();
        y yVar = new y();
        yVar.a(true);
        yVar.b(true);
        yVar.c(true);
        if (track.isAudio()) {
            yVar.a(b.d.a.b.h.f2529a);
        } else {
            yVar.a(mp4Movie.getMatrix());
        }
        yVar.c(0);
        yVar.a(track.getCreationTime());
        yVar.a((track.getDuration() * getTimescale(mp4Movie)) / ((long) track.getTimeScale()));
        yVar.a(track.getHeight());
        yVar.b(track.getWidth());
        yVar.d(0);
        yVar.b(new Date());
        yVar.b(track.getTrackId() + 1);
        yVar.a(track.getVolume());
        xVar.a(yVar);
        k kVar = new k();
        xVar.a(kVar);
        l lVar = new l();
        lVar.a(track.getCreationTime());
        lVar.a(track.getDuration());
        lVar.b(track.getTimeScale());
        lVar.a("eng");
        kVar.a(lVar);
        j jVar = new j();
        jVar.b(track.isAudio() ? "SoundHandle" : "VideoHandle");
        jVar.a(track.getHandler());
        kVar.a(jVar);
        m mVar = new m();
        mVar.a(track.getMediaHeaderBox());
        b.b.a.a.f fVar = new b.b.a.a.f();
        g gVar = new g();
        fVar.a(gVar);
        b.b.a.a.e eVar = new b.b.a.a.e();
        eVar.a(1);
        gVar.a(eVar);
        mVar.a(fVar);
        mVar.a(createStbl(track));
        kVar.a(mVar);
        return xVar;
    }

    public void finishMovie(boolean z) throws Exception {
        if (this.mdat.getContentSize() != 0) {
            flushCurrentMdat();
        }
        for (Track track : this.currentMp4Movie.getTracks()) {
            ArrayList<Sample> samples = track.getSamples();
            long[] jArr = new long[samples.size()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = samples.get(i).getSize();
            }
            this.track2SampleSizes.put(track, jArr);
        }
        createMovieBox(this.currentMp4Movie).getBox(this.fc);
        this.fos.flush();
        this.fc.close();
        this.fos.close();
    }

    public long getTimescale(Mp4Movie mp4Movie) {
        long timeScale = !mp4Movie.getTracks().isEmpty() ? mp4Movie.getTracks().iterator().next().getTimeScale() : 0L;
        Iterator<Track> it = mp4Movie.getTracks().iterator();
        while (it.hasNext()) {
            timeScale = gcd(it.next().getTimeScale(), timeScale);
        }
        return timeScale;
    }

    public boolean writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) throws Exception {
        if (this.writeNewMdat) {
            this.mdat.setContentSize(0L);
            this.mdat.getBox(this.fc);
            this.mdat.setDataOffset(this.dataOffset);
            this.dataOffset += 16;
            this.writedSinceLastMdat += 16;
            this.writeNewMdat = false;
        }
        InterleaveChunkMdat interleaveChunkMdat = this.mdat;
        interleaveChunkMdat.setContentSize(interleaveChunkMdat.getContentSize() + ((long) bufferInfo.size));
        this.writedSinceLastMdat += (long) bufferInfo.size;
        boolean z2 = true;
        if (this.writedSinceLastMdat >= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
            flushCurrentMdat();
            this.writeNewMdat = true;
            this.writedSinceLastMdat -= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        } else {
            z2 = false;
        }
        this.currentMp4Movie.addSample(i, this.dataOffset, bufferInfo);
        byteBuffer.position(bufferInfo.offset + (z ? 0 : 4));
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if (!z) {
            this.sizeBuffer.position(0);
            this.sizeBuffer.putInt(bufferInfo.size - 4);
            this.sizeBuffer.position(0);
            this.fc.write(this.sizeBuffer);
        }
        this.fc.write(byteBuffer);
        this.dataOffset += (long) bufferInfo.size;
        if (z2) {
            this.fos.flush();
        }
        return z2;
    }
}
