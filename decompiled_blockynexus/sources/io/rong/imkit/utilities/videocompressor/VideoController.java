package io.rong.imkit.utilities.videocompressor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import io.rong.common.RLog;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"NewApi"})
public class VideoController {
    private static volatile VideoController Instance = null;
    private static final String MIME_TYPE = "video/avc";
    private static final int PROCESSOR_TYPE_INTEL = 2;
    private static final int PROCESSOR_TYPE_MTK = 3;
    private static final int PROCESSOR_TYPE_OTHER = 0;
    private static final int PROCESSOR_TYPE_QCOM = 1;
    private static final int PROCESSOR_TYPE_SEC = 4;
    private static final int PROCESSOR_TYPE_TI = 5;
    private static final String TAG = "VideoController";
    public String path;
    private boolean videoConvertFirstWrite = true;

    interface CompressProgressListener {
        void onProgress(float f2);
    }

    public static class VideoConvertRunnable implements Runnable {
        private String destPath;
        private String videoPath;

        /* JADX INFO: Access modifiers changed from: private */
        public static void runConversion(final String str, final String str2) {
            new Thread(new Runnable() { // from class: io.rong.imkit.utilities.videocompressor.VideoController.VideoConvertRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread thread = new Thread(new VideoConvertRunnable(str, str2), "VideoConvertRunnable");
                        thread.start();
                        thread.join();
                    } catch (Exception e2) {
                        RLog.e(VideoController.TAG, e2.getMessage());
                    }
                }
            }).start();
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            VideoController.getInstance().convertVideo(this.videoPath, this.destPath, null);
        }

        private VideoConvertRunnable(String str, String str2) {
            this.videoPath = str;
            this.destPath = str2;
        }
    }

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    /* JADX WARN: Removed duplicated region for block: B:106:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00a5 -> B:99:0x00aa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyFile(java.io.File r13, java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.videocompressor.VideoController.copyFile(java.io.File, java.io.File):void");
    }

    private void didWriteData(boolean z, boolean z2) {
        if (this.videoConvertFirstWrite) {
            this.videoConvertFirstWrite = false;
        }
    }

    public static VideoController getInstance() {
        VideoController videoController = Instance;
        if (videoController == null) {
            synchronized (VideoController.class) {
                videoController = Instance;
                if (videoController == null) {
                    videoController = new VideoController();
                    Instance = videoController;
                }
            }
        }
        return videoController;
    }

    private static boolean isRecognizedFormat(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(16)
    private long readAndWriteTrack(MediaExtractor mediaExtractor, MP4Builder mP4Builder, MediaCodec.BufferInfo bufferInfo, long j, long j2, File file, boolean z) throws Exception {
        boolean z2;
        int iSelectTrack = selectTrack(mediaExtractor, z);
        if (iSelectTrack < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(iSelectTrack);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iSelectTrack);
        int iAddTrack = mP4Builder.addTrack(trackFormat, z);
        int integer = trackFormat.getInteger("max-input-size");
        long j3 = 0;
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
                bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                if (bufferInfo.size < 0) {
                    bufferInfo.size = 0;
                } else {
                    ByteBuffer byteBuffer = byteBufferAllocateDirect;
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    long j5 = (j <= j3 || j4 != -1) ? j4 : bufferInfo.presentationTimeUs;
                    if (j2 < j3 || bufferInfo.presentationTimeUs < j2) {
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        byteBufferAllocateDirect = byteBuffer;
                        mP4Builder.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo, z);
                        mediaExtractor.advance();
                        j4 = j5;
                    } else {
                        byteBufferAllocateDirect = byteBuffer;
                        j4 = j5;
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

    private static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                MediaCodecInfo mediaCodecInfo2 = mediaCodecInfo;
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        if (!codecInfoAt.getName().equals("OMX.SEC.avc.enc") || codecInfoAt.getName().equals("OMX.SEC.AVC.Encoder")) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo2 = codecInfoAt;
                    }
                }
                mediaCodecInfo = mediaCodecInfo2;
            }
        }
        return mediaCodecInfo;
    }

    @SuppressLint({"NewApi"})
    private static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        int i;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                return i3;
            }
            i = iArr[i2];
            if (isRecognizedFormat(i)) {
                if (!mediaCodecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i != 19) {
                    break;
                }
                i3 = i;
            }
            i2++;
        }
        return i;
    }

    @TargetApi(16)
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
        return -5;
    }

    private void startVideoConvertFromQueue(String str, String str2) {
        VideoConvertRunnable.runConversion(str, str2);
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @android.annotation.TargetApi(16)
    public boolean convertVideo(java.lang.String r55, java.lang.String r56, io.rong.imkit.utilities.videocompressor.VideoController.CompressProgressListener r57) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.videocompressor.VideoController.convertVideo(java.lang.String, java.lang.String, io.rong.imkit.utilities.videocompressor.VideoController$CompressProgressListener):boolean");
    }

    public void scheduleVideoConvert(String str, String str2) {
        startVideoConvertFromQueue(str, str2);
    }
}
