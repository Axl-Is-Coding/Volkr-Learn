package com.sandboxol.blockmango;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public class EchoesSound {
    private static final int INVALID_SOUND_ID = -1;
    private static final int INVALID_STREAM_ID = -1;
    private static final int MAX_SIMULTANEOUS_STREAMS_DEFAULT = 5;
    private static final int MAX_SIMULTANEOUS_STREAMS_I9100 = 3;
    private static final int SOUND_PRIORITY = 1;
    private static final int SOUND_QUALITY = 5;
    private static final float SOUND_RATE = 1.0f;
    private static final String TAG = "EchoesSound";
    private final Context mContext;
    private float mLeftVolume;
    private float mRightVolume;
    private Semaphore mSemaphore;
    private SoundPool mSoundPool;
    private int mStreamIdSyn;
    private final HashMap<String, ArrayList<Integer>> mPathStreamIDsMap = new HashMap<>();
    private final HashMap<String, Integer> mPathSoundIDMap = new HashMap<>();
    private final ArrayList<SoundInfoForLoadedCompleted> mEffecToPlayWhenLoadedArray = new ArrayList<>();
    private boolean isPause = false;

    public class OnLoadCompletedListener implements SoundPool.OnLoadCompleteListener {
        public OnLoadCompletedListener() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            try {
                if (i2 == 0) {
                    Iterator it = EchoesSound.this.mEffecToPlayWhenLoadedArray.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SoundInfoForLoadedCompleted soundInfoForLoadedCompleted = (SoundInfoForLoadedCompleted) it.next();
                        if (soundInfoForLoadedCompleted != null && i == soundInfoForLoadedCompleted.soundID) {
                            EchoesSound.this.mStreamIdSyn = EchoesSound.this.doPlayEffect(soundInfoForLoadedCompleted.path, soundInfoForLoadedCompleted.soundID, soundInfoForLoadedCompleted.isLoop, soundInfoForLoadedCompleted.pitch, soundInfoForLoadedCompleted.pan, soundInfoForLoadedCompleted.gain);
                            EchoesSound.this.mEffecToPlayWhenLoadedArray.remove(soundInfoForLoadedCompleted);
                            break;
                        }
                    }
                } else {
                    EchoesSound.this.mStreamIdSyn = -1;
                }
                EchoesSound.this.mSemaphore.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class SoundInfoForLoadedCompleted {
        public float gain;
        public boolean isLoop;
        public float pan;
        public String path;
        public float pitch;
        public int soundID;

        public SoundInfoForLoadedCompleted(String str, int i, boolean z, float f2, float f3, float f4) {
            this.path = str;
            this.soundID = i;
            this.isLoop = z;
            this.pitch = f2;
            this.pan = f3;
            this.gain = f4;
        }
    }

    public EchoesSound(Context context) {
        this.mContext = context;
        initData();
    }

    private float clamp(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doPlayEffect(String str, int i, boolean z, float f2, float f3, float f4) {
        if (this.isPause) {
            return -1;
        }
        float fClamp = this.mLeftVolume * f4 * (1.0f - clamp(f3, WheelView.DividerConfig.FILL, 1.0f));
        float fClamp2 = this.mRightVolume * f4 * (1.0f - clamp(-f3, WheelView.DividerConfig.FILL, 1.0f));
        int iPlay = this.mSoundPool.play(i, clamp(fClamp, WheelView.DividerConfig.FILL, 1.0f), clamp(fClamp2, WheelView.DividerConfig.FILL, 1.0f), 1, z ? -1 : 0, clamp(f2 * 1.0f, 0.5f, 2.0f));
        ArrayList<Integer> arrayList = this.mPathStreamIDsMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mPathStreamIDsMap.put(str, arrayList);
        }
        arrayList.add(Integer.valueOf(iPlay));
        return iPlay;
    }

    private void initData() {
        if (EchoesHelper.getDeviceModel().indexOf("GT-I9100") != -1) {
            this.mSoundPool = new SoundPool(3, 3, 5);
        } else {
            this.mSoundPool = new SoundPool(5, 3, 5);
        }
        this.mSoundPool.setOnLoadCompleteListener(new OnLoadCompletedListener());
        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
        this.mSemaphore = new Semaphore(0, true);
    }

    public int createSoundIDFromAsset(String str) {
        int iLoad;
        try {
            iLoad = str.startsWith("/") ? this.mSoundPool.load(str, 0) : this.mSoundPool.load(this.mContext.getAssets().openFd(str), 0);
        } catch (Exception e2) {
            Log.e(TAG, "error: " + e2.getMessage(), e2);
            iLoad = -1;
        }
        if (iLoad == 0) {
            return -1;
        }
        return iLoad;
    }

    public void end() {
        try {
            this.mSoundPool.release();
            this.mPathStreamIDsMap.clear();
            this.mPathSoundIDMap.clear();
            this.mEffecToPlayWhenLoadedArray.clear();
            this.mLeftVolume = 0.5f;
            this.mRightVolume = 0.5f;
            initData();
            Log.e(TAG, "EchoesSound end");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public float getEffectsVolume() {
        return (this.mLeftVolume + this.mRightVolume) / 2.0f;
    }

    public void pauseAllEffects() {
        this.mSoundPool.autoPause();
    }

    public void pauseEffect(int i) {
        this.mSoundPool.pause(i);
    }

    public int playEffect(String str, boolean z, float f2, float f3, float f4) {
        int i;
        Integer num = this.mPathSoundIDMap.get(str);
        if (num != null) {
            return doPlayEffect(str, num.intValue(), z, f2, f3, f4);
        }
        Integer numValueOf = Integer.valueOf(preloadEffect(str));
        if (numValueOf.intValue() == -1) {
            return -1;
        }
        synchronized (this.mSoundPool) {
            this.mEffecToPlayWhenLoadedArray.add(new SoundInfoForLoadedCompleted(str, numValueOf.intValue(), z, f2, f3, f4));
            try {
                this.mSemaphore.acquire();
                i = this.mStreamIdSyn;
            } catch (Exception unused) {
                return -1;
            }
        }
        return i;
    }

    public int preloadEffect(String str) {
        if (this.isPause) {
            return -1;
        }
        Integer numValueOf = this.mPathSoundIDMap.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(createSoundIDFromAsset(str));
            if (numValueOf.intValue() != -1) {
                this.mPathSoundIDMap.put(str, numValueOf);
            }
        }
        return numValueOf.intValue();
    }

    public void resumeAllEffects() {
        try {
            if (this.mPathStreamIDsMap.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, ArrayList<Integer>>> it = this.mPathStreamIDsMap.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<Integer> it2 = it.next().getValue().iterator();
                while (it2.hasNext()) {
                    this.mSoundPool.resume(it2.next().intValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resumeEffect(int i) {
        this.mSoundPool.resume(i);
    }

    public void setEffectsVolume(float f2) {
        if (f2 < WheelView.DividerConfig.FILL) {
            f2 = WheelView.DividerConfig.FILL;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        try {
            this.mRightVolume = f2;
            this.mLeftVolume = f2;
            if (this.mPathStreamIDsMap.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, ArrayList<Integer>>> it = this.mPathStreamIDsMap.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<Integer> it2 = it.next().getValue().iterator();
                while (it2.hasNext()) {
                    this.mSoundPool.setVolume(it2.next().intValue(), this.mLeftVolume, this.mRightVolume);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setPause(boolean z) {
        try {
            this.isPause = z;
            this.mSemaphore.release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopAllEffects() {
        try {
            if (!this.mPathStreamIDsMap.isEmpty()) {
                Iterator<Map.Entry<String, ArrayList<Integer>>> it = this.mPathStreamIDsMap.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator<Integer> it2 = it.next().getValue().iterator();
                    while (it2.hasNext()) {
                        this.mSoundPool.stop(it2.next().intValue());
                    }
                }
            }
            this.mPathStreamIDsMap.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopEffect(int i) {
        try {
            this.mSoundPool.stop(i);
            for (String str : this.mPathStreamIDsMap.keySet()) {
                if (this.mPathStreamIDsMap.get(str).contains(Integer.valueOf(i))) {
                    this.mPathStreamIDsMap.get(str).remove(this.mPathStreamIDsMap.get(str).indexOf(Integer.valueOf(i)));
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void unloadEffect(String str) {
        try {
            ArrayList<Integer> arrayList = this.mPathStreamIDsMap.get(str);
            if (arrayList != null) {
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.mSoundPool.stop(it.next().intValue());
                }
            }
            this.mPathStreamIDsMap.remove(str);
            Integer num = this.mPathSoundIDMap.get(str);
            if (num != null) {
                this.mSoundPool.unload(num.intValue());
                this.mPathSoundIDMap.remove(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
