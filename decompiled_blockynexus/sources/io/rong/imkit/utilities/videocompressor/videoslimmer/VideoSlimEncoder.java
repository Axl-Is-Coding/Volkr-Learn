package io.rong.imkit.utilities.videocompressor.videoslimmer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import io.rong.common.RLog;
import io.rong.imkit.utilities.videocompressor.videoslimmer.muxer.CodecInputSurface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class VideoSlimEncoder {
    private static int FRAME_RATE = 25;
    private static int IFRAME_INTERVAL = 10;
    private static final int MEDIATYPE_NOT_AUDIO_VIDEO = -233;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "VideoSlimEncoder";
    private static final boolean VERBOSE = true;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mDecoder;
    private MediaCodec mEncoder;
    private CodecInputSurface mInputSurface;
    private MediaMuxer mMuxer;
    private int mTrackIndex;
    private String outputPath;
    private String path;
    private int mWidth = -1;
    private int mHeight = -1;
    private int mBitRate = -1;
    private final int TIMEOUT_USEC = 2500;

    private boolean checkParmsError(int i, int i2, int i3) {
        return i <= 0 || i2 <= 0 || i3 <= 0;
    }

    private void prepareEncoder(MediaFormat mediaFormat) {
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, this.mWidth, this.mHeight);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", this.mBitRate);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", FRAME_RATE);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", IFRAME_INTERVAL);
        RLog.d(TAG, "format: " + mediaFormatCreateVideoFormat);
        try {
            this.mEncoder = MediaCodec.createEncoderByType(MIME_TYPE);
        } catch (IOException e2) {
            RLog.d(TAG, "prepareEncoder:" + e2);
        }
        this.mEncoder.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = new CodecInputSurface(this.mEncoder.createInputSurface());
        this.mInputSurface.makeCurrent();
        this.mEncoder.start();
        try {
            this.mDecoder = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        } catch (IOException e3) {
            RLog.d(TAG, "prepareEncoder:" + e3);
        }
        this.mInputSurface.createRender();
        this.mDecoder.configure(mediaFormat, this.mInputSurface.getSurface(), (MediaCrypto) null, 0);
        this.mDecoder.start();
        this.mTrackIndex = -1;
    }

    private boolean releaseCoder() {
        RLog.d(TAG, "releasing encoder objects");
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mEncoder.release();
            this.mEncoder = null;
        }
        MediaCodec mediaCodec2 = this.mDecoder;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.mDecoder.release();
            this.mDecoder = null;
        }
        CodecInputSurface codecInputSurface = this.mInputSurface;
        if (codecInputSurface != null) {
            codecInputSurface.release();
            this.mInputSurface = null;
        }
        MediaMuxer mediaMuxer = this.mMuxer;
        if (mediaMuxer == null) {
            return true;
        }
        try {
            mediaMuxer.stop();
            this.mMuxer.release();
            return true;
        } catch (Exception unused) {
            RLog.e(TAG, "mMuxer fail");
            return false;
        } finally {
            this.mMuxer = null;
        }
    }

    private int selectTrack(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return MEDIATYPE_NOT_AUDIO_VIDEO;
    }

    private long simpleReadAndWriteTrack(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, MediaCodec.BufferInfo bufferInfo, long j, long j2, boolean z) throws Exception {
        boolean z2;
        int iSelectTrack = selectTrack(mediaExtractor, z);
        if (iSelectTrack < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(iSelectTrack);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iSelectTrack);
        int iAddTrack = mediaMuxer.addTrack(trackFormat);
        if (!z) {
            mediaMuxer.start();
        }
        int integer = trackFormat.getInteger("max-input-size");
        long j3 = 0;
        int i = 0;
        if (j > 0) {
            mediaExtractor.seekTo(j, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(integer);
        boolean z3 = false;
        long j4 = -1;
        while (!z3) {
            int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
            if (sampleTrackIndex == iSelectTrack) {
                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, i);
                if (bufferInfo.size < 0) {
                    bufferInfo.size = i;
                } else {
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    long j5 = (j <= j3 || j4 != -1) ? j4 : bufferInfo.presentationTimeUs;
                    if (j2 < j3 || bufferInfo.presentationTimeUs < j2) {
                        i = 0;
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                        mediaExtractor.advance();
                        j4 = j5;
                    } else {
                        j4 = j5;
                        z2 = true;
                        i = 0;
                    }
                }
            } else {
                z2 = sampleTrackIndex == -1;
            }
            if (z2) {
                z3 = true;
            }
            j3 = 0;
        }
        mediaExtractor.unselectTrack(iSelectTrack);
        return j4;
    }

    private long writeAudioTrack(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, MediaCodec.BufferInfo bufferInfo, long j, long j2, File file, int i) throws Exception {
        boolean z;
        boolean z2;
        int iSelectTrack = selectTrack(mediaExtractor, true);
        if (iSelectTrack < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(iSelectTrack);
        int integer = mediaExtractor.getTrackFormat(iSelectTrack).getInteger("max-input-size");
        long j3 = 0;
        int i2 = 0;
        if (j > 0) {
            mediaExtractor.seekTo(j, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(integer);
        long j4 = -1;
        boolean z3 = false;
        while (!z3) {
            int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
            if (sampleTrackIndex == iSelectTrack) {
                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, i2);
                if (bufferInfo.size < 0) {
                    bufferInfo.size = i2;
                    z = z3;
                    z2 = true;
                } else {
                    z = z3;
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    if (j > j3 && j4 == -1) {
                        j4 = bufferInfo.presentationTimeUs;
                    }
                    if (j2 < j3 || bufferInfo.presentationTimeUs < j2) {
                        i2 = 0;
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        mediaMuxer.writeSampleData(i, byteBufferAllocateDirect, bufferInfo);
                        mediaExtractor.advance();
                    } else {
                        z2 = true;
                        i2 = 0;
                    }
                }
            } else {
                z = z3;
                z2 = sampleTrackIndex == -1;
            }
            if (z2) {
                z = true;
            }
            z3 = z;
            j3 = 0;
        }
        mediaExtractor.unselectTrack(iSelectTrack);
        return j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a5, code lost:
    
        r5 = r35;
        r0 = r6;
        r14 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d4 A[Catch: Exception -> 0x03ad, all -> 0x03e0, TryCatch #0 {all -> 0x03e0, blocks: (B:176:0x03bb, B:178:0x03c8, B:50:0x0131, B:52:0x0137, B:60:0x0170, B:62:0x017b, B:75:0x01ac, B:129:0x02d4, B:138:0x02f1, B:141:0x02fd, B:145:0x0306, B:147:0x030d, B:152:0x031f, B:154:0x0333, B:156:0x0346, B:158:0x0350, B:160:0x0358, B:150:0x0315, B:162:0x0363, B:163:0x0379, B:80:0x01cc, B:82:0x01d2, B:85:0x01de, B:87:0x01e8, B:89:0x01f8, B:91:0x01fe, B:94:0x0209, B:96:0x0212, B:98:0x021a, B:101:0x0227, B:105:0x024d, B:107:0x0251, B:109:0x0257, B:111:0x025d, B:113:0x0263, B:116:0x0293, B:119:0x029d, B:120:0x02a7, B:122:0x02b6, B:126:0x02c1, B:114:0x0287, B:164:0x037a, B:165:0x0395, B:92:0x0201, B:166:0x0396, B:167:0x03ac, B:53:0x014a, B:174:0x03b6, B:184:0x03d8, B:185:0x03df), top: B:227:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0414 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x02cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0170 A[Catch: Exception -> 0x03ad, all -> 0x03e0, TryCatch #0 {all -> 0x03e0, blocks: (B:176:0x03bb, B:178:0x03c8, B:50:0x0131, B:52:0x0137, B:60:0x0170, B:62:0x017b, B:75:0x01ac, B:129:0x02d4, B:138:0x02f1, B:141:0x02fd, B:145:0x0306, B:147:0x030d, B:152:0x031f, B:154:0x0333, B:156:0x0346, B:158:0x0350, B:160:0x0358, B:150:0x0315, B:162:0x0363, B:163:0x0379, B:80:0x01cc, B:82:0x01d2, B:85:0x01de, B:87:0x01e8, B:89:0x01f8, B:91:0x01fe, B:94:0x0209, B:96:0x0212, B:98:0x021a, B:101:0x0227, B:105:0x024d, B:107:0x0251, B:109:0x0257, B:111:0x025d, B:113:0x0263, B:116:0x0293, B:119:0x029d, B:120:0x02a7, B:122:0x02b6, B:126:0x02c1, B:114:0x0287, B:164:0x037a, B:165:0x0395, B:92:0x0201, B:166:0x0396, B:167:0x03ac, B:53:0x014a, B:174:0x03b6, B:184:0x03d8, B:185:0x03df), top: B:227:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018c  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v24, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r13v30, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v5, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r30v0, types: [io.rong.imkit.utilities.videocompressor.videoslimmer.VideoSlimEncoder] */
    /* JADX WARN: Type inference failed for: r35v1, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean convertVideo(java.lang.String r31, java.lang.String r32, int r33, int r34, int r35, io.rong.imkit.utilities.videocompressor.videoslimmer.listner.SlimProgressListener r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.videocompressor.videoslimmer.VideoSlimEncoder.convertVideo(java.lang.String, java.lang.String, int, int, int, io.rong.imkit.utilities.videocompressor.videoslimmer.listner.SlimProgressListener):boolean");
    }
}
