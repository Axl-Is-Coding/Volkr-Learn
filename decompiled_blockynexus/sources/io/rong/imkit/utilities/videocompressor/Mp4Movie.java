package io.rong.imkit.utilities.videocompressor;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import b.d.a.b.h;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(16)
public class Mp4Movie {
    private File cacheFile;
    private int height;
    private h matrix = h.f2529a;
    private ArrayList<Track> tracks = new ArrayList<>();
    private int width;

    public void addSample(int i, long j, MediaCodec.BufferInfo bufferInfo) throws Exception {
        if (i < 0 || i >= this.tracks.size()) {
            return;
        }
        this.tracks.get(i).addSample(j, bufferInfo);
    }

    public int addTrack(MediaFormat mediaFormat, boolean z) throws Exception {
        ArrayList<Track> arrayList = this.tracks;
        arrayList.add(new Track(arrayList.size(), mediaFormat, z));
        return this.tracks.size() - 1;
    }

    public File getCacheFile() {
        return this.cacheFile;
    }

    public int getHeight() {
        return this.height;
    }

    public h getMatrix() {
        return this.matrix;
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCacheFile(File file) {
        this.cacheFile = file;
    }

    public void setRotation(int i) {
        if (i == 0) {
            this.matrix = h.f2529a;
            return;
        }
        if (i == 90) {
            this.matrix = h.f2530b;
        } else if (i == 180) {
            this.matrix = h.f2531c;
        } else if (i == 270) {
            this.matrix = h.f2532d;
        }
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
