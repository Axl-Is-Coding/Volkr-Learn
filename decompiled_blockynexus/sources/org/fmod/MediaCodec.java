package org.fmod;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class MediaCodec {
    private long mCodecPtr = 0;
    private long mLength = 0;
    private int mSampleRate = 0;
    private int mChannelCount = 0;
    private boolean mInputFinished = false;
    private boolean mOutputFinished = false;
    private android.media.MediaCodec mDecoder = null;
    private Object mDataSourceProxy = null;
    private MediaExtractor mExtractor = null;
    private ByteBuffer[] mInputBuffers = null;
    private ByteBuffer[] mOutputBuffers = null;
    private int mCurrentOutputBufferIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static native long fmodGetSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int fmodReadAt(long j, long j2, byte[] bArr, int i, int i2);

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public long getLength() {
        return this.mLength;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public boolean init(long j) {
        this.mCodecPtr = j;
        int i = Build.VERSION.SDK_INT;
        if (i < 17) {
            Log.w("fmod", "MediaCodec::init : MediaCodec unavailable, ensure device is running at least 4.2 (JellyBean).\n");
            return false;
        }
        if (i < 23) {
            try {
                Class<?> cls = Class.forName("android.media.DataSource");
                Method method = Class.forName("android.media.MediaExtractor").getMethod("setDataSource", cls);
                this.mExtractor = new MediaExtractor();
                this.mDataSourceProxy = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this));
                method.invoke(this.mExtractor, this.mDataSourceProxy);
            } catch (ClassNotFoundException e2) {
                Log.w("fmod", "MediaCodec::init : " + e2.toString());
                return false;
            } catch (IllegalAccessException e3) {
                Log.e("fmod", "MediaCodec::init : " + e3.toString());
                return false;
            } catch (NoSuchMethodException e4) {
                Log.w("fmod", "MediaCodec::init : " + e4.toString());
                return false;
            } catch (InvocationTargetException e5) {
                Log.e("fmod", "MediaCodec::init : " + e5.toString());
                return false;
            }
        } else {
            try {
                this.mExtractor = new MediaExtractor();
                this.mExtractor.setDataSource(new b(this));
            } catch (IOException e6) {
                Log.w("fmod", "MediaCodec::init : " + e6.toString());
                return false;
            }
        }
        int trackCount = this.mExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            Log.d("fmod", "MediaCodec::init : Format " + i2 + " / " + trackCount + " -- " + trackFormat);
            if (string.equals("audio/mp4a-latm")) {
                try {
                    this.mDecoder = android.media.MediaCodec.createDecoderByType(string);
                    this.mExtractor.selectTrack(i2);
                    this.mDecoder.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.mDecoder.start();
                    this.mInputBuffers = this.mDecoder.getInputBuffers();
                    this.mOutputBuffers = this.mDecoder.getOutputBuffers();
                    int integer = trackFormat.containsKey("encoder-delay") ? trackFormat.getInteger("encoder-delay") : 0;
                    int integer2 = trackFormat.containsKey("encoder-padding") ? trackFormat.getInteger("encoder-padding") : 0;
                    long j2 = trackFormat.getLong("durationUs");
                    this.mChannelCount = trackFormat.getInteger("channel-count");
                    this.mSampleRate = trackFormat.getInteger("sample-rate");
                    this.mLength = (((int) (((j2 * ((long) this.mSampleRate)) + 999999) / 1000000)) - integer) - integer2;
                    return true;
                } catch (IOException e7) {
                    Log.e("fmod", "MediaCodec::init : " + e7.toString());
                    return false;
                }
            }
        }
        return false;
    }

    public int read(byte[] bArr, int i) {
        int iDequeueInputBuffer;
        int i2 = (this.mInputFinished && this.mOutputFinished && this.mCurrentOutputBufferIndex == -1) ? -1 : 0;
        while (!this.mInputFinished && (iDequeueInputBuffer = this.mDecoder.dequeueInputBuffer(0L)) >= 0) {
            int sampleData = this.mExtractor.readSampleData(this.mInputBuffers[iDequeueInputBuffer], 0);
            if (sampleData >= 0) {
                this.mDecoder.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, this.mExtractor.getSampleTime(), 0);
                this.mExtractor.advance();
            } else {
                this.mDecoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                this.mInputFinished = true;
            }
        }
        if (!this.mOutputFinished && this.mCurrentOutputBufferIndex == -1) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int iDequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, 10000L);
            if (iDequeueOutputBuffer >= 0) {
                this.mCurrentOutputBufferIndex = iDequeueOutputBuffer;
                this.mOutputBuffers[iDequeueOutputBuffer].limit(bufferInfo.size);
                this.mOutputBuffers[iDequeueOutputBuffer].position(bufferInfo.offset);
            } else if (iDequeueOutputBuffer == -3) {
                this.mOutputBuffers = this.mDecoder.getOutputBuffers();
            } else if (iDequeueOutputBuffer == -2) {
                Log.d("fmod", "MediaCodec::read : MediaCodec::dequeueOutputBuffer returned MediaCodec.INFO_OUTPUT_FORMAT_CHANGED " + this.mDecoder.getOutputFormat());
            } else if (iDequeueOutputBuffer == -1) {
                Log.d("fmod", "MediaCodec::read : MediaCodec::dequeueOutputBuffer returned MediaCodec.INFO_TRY_AGAIN_LATER.");
            } else {
                Log.w("fmod", "MediaCodec::read : MediaCodec::dequeueOutputBuffer returned " + iDequeueOutputBuffer);
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.mOutputFinished = true;
            }
        }
        int i3 = this.mCurrentOutputBufferIndex;
        if (i3 == -1) {
            return i2;
        }
        ByteBuffer byteBuffer = this.mOutputBuffers[i3];
        int iMin = Math.min(byteBuffer.remaining(), i);
        byteBuffer.get(bArr, 0, iMin);
        if (!byteBuffer.hasRemaining()) {
            byteBuffer.clear();
            this.mDecoder.releaseOutputBuffer(this.mCurrentOutputBufferIndex, false);
            this.mCurrentOutputBufferIndex = -1;
        }
        return iMin;
    }

    public void release() {
        android.media.MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mDecoder.release();
            this.mDecoder = null;
        }
        MediaExtractor mediaExtractor = this.mExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mExtractor = null;
        }
    }

    public void seek(int i) {
        int i2 = this.mCurrentOutputBufferIndex;
        if (i2 != -1) {
            this.mOutputBuffers[i2].clear();
            this.mCurrentOutputBufferIndex = -1;
        }
        this.mInputFinished = false;
        this.mOutputFinished = false;
        this.mDecoder.flush();
        long j = i;
        this.mExtractor.seekTo((j * 1000000) / ((long) this.mSampleRate), 0);
        long sampleTime = ((this.mExtractor.getSampleTime() * ((long) this.mSampleRate)) + 999999) / 1000000;
        int i3 = (int) ((j - sampleTime) * ((long) this.mChannelCount) * 2);
        if (i3 >= 0) {
            byte[] bArr = new byte[1024];
            while (i3 > 0) {
                i3 -= read(bArr, Math.min(bArr.length, i3));
            }
        } else {
            Log.w("fmod", "MediaCodec::seek : Seek to " + i + " resulted in position " + sampleTime);
        }
    }
}
