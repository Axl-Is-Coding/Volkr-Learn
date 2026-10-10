package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$IntRef;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SVGAVideoEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.opensource.svgaplayer.b.c f15585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.opensource.svgaplayer.entities.f> f15588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.opensource.svgaplayer.entities.a> f15589f;
    private SoundPool g;
    private HashMap<String, Bitmap> h;
    private File i;
    private MovieEntity j;

    public q(JSONObject jSONObject, File file) {
        kotlin.jvm.internal.i.b(jSONObject, "obj");
        kotlin.jvm.internal.i.b(file, "cacheDir");
        this.f15584a = true;
        this.f15585b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f15586c = 15;
        this.f15588e = kotlin.collections.m.a();
        this.f15589f = kotlin.collections.m.a();
        this.h = new HashMap<>();
        this.i = file;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("movie");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("viewBox");
            if (jSONObjectOptJSONObject2 != null) {
                this.f15585b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0.0d), jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0d));
            }
            this.f15586c = jSONObjectOptJSONObject.optInt("fps", 20);
            this.f15587d = jSONObjectOptJSONObject.optInt("frames", 0);
        }
        try {
            a(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        b(jSONObject);
    }

    public final boolean a() {
        return this.f15584a;
    }

    public final List<com.opensource.svgaplayer.entities.a> b() {
        return this.f15589f;
    }

    public final int c() {
        return this.f15586c;
    }

    public final int d() {
        return this.f15587d;
    }

    public final HashMap<String, Bitmap> e() {
        return this.h;
    }

    public final SoundPool f() {
        return this.g;
    }

    protected final void finalize() {
        SoundPool soundPool = this.g;
        if (soundPool != null) {
            soundPool.release();
        }
        this.g = null;
        this.h.clear();
    }

    public final List<com.opensource.svgaplayer.entities.f> g() {
        return this.f15588e;
    }

    public final com.opensource.svgaplayer.b.c h() {
        return this.f15585b;
    }

    private final void b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sprites");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.opensource.svgaplayer.entities.f(jSONObjectOptJSONObject));
                }
            }
        }
        this.f15588e = u.b((Iterable) arrayList);
    }

    public final void a(boolean z) {
        this.f15584a = z;
    }

    public final void a(final kotlin.jvm.a.a<kotlin.l> aVar) throws IOException {
        kotlin.jvm.internal.i.b(aVar, "callback");
        MovieEntity movieEntity = this.j;
        if (movieEntity != null) {
            a(movieEntity, new kotlin.jvm.a.a<kotlin.l>() { // from class: com.opensource.svgaplayer.SVGAVideoEntity$prepare$$inlined$let$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ kotlin.l invoke() {
                    invoke2();
                    return kotlin.l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    aVar.invoke();
                }
            });
        } else {
            aVar.invoke();
        }
    }

    private final void a(JSONObject jSONObject) {
        Bitmap bitmapDecodeFile;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("images");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            kotlin.jvm.internal.i.a((Object) itKeys, "imgObjects.keys()");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                C2432r.f15590a.inPreferredConfig = Bitmap.Config.RGB_565;
                String str = this.i.getAbsolutePath() + "/" + jSONObjectOptJSONObject.get(next);
                Bitmap bitmapDecodeFile2 = new File(str).exists() ? BitmapFactory.decodeFile(str, C2432r.f15590a) : null;
                kotlin.jvm.internal.i.a((Object) next, "imageKey");
                String strA = kotlin.text.n.a(next, ".matte", "", false, 4, (Object) null);
                if (bitmapDecodeFile2 != null) {
                    this.h.put(strA, bitmapDecodeFile2);
                } else {
                    String str2 = this.i.getAbsolutePath() + "/" + jSONObjectOptJSONObject.get(next) + ".png";
                    Bitmap bitmapDecodeFile3 = new File(str2).exists() ? BitmapFactory.decodeFile(str2, C2432r.f15590a) : null;
                    if (bitmapDecodeFile3 != null) {
                        this.h.put(strA, bitmapDecodeFile3);
                    } else {
                        String str3 = this.i.getAbsolutePath() + "/" + next + ".png";
                        if (!new File(str3).exists()) {
                            str3 = null;
                        }
                        if (str3 != null && (bitmapDecodeFile = BitmapFactory.decodeFile(str3, C2432r.f15590a)) != null) {
                            this.h.put(strA, bitmapDecodeFile);
                        }
                    }
                }
            }
        }
    }

    private final void b(MovieEntity movieEntity) {
        List<com.opensource.svgaplayer.entities.f> listA;
        List<SpriteEntity> list = movieEntity.sprites;
        if (list != null) {
            listA = new ArrayList<>(kotlin.collections.n.a(list, 10));
            for (SpriteEntity spriteEntity : list) {
                kotlin.jvm.internal.i.a((Object) spriteEntity, "it");
                listA.add(new com.opensource.svgaplayer.entities.f(spriteEntity));
            }
        } else {
            listA = kotlin.collections.m.a();
        }
        this.f15588e = listA;
    }

    public q(MovieEntity movieEntity, File file) {
        kotlin.jvm.internal.i.b(movieEntity, "obj");
        kotlin.jvm.internal.i.b(file, "cacheDir");
        this.f15584a = true;
        this.f15585b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f15586c = 15;
        this.f15588e = kotlin.collections.m.a();
        this.f15589f = kotlin.collections.m.a();
        this.h = new HashMap<>();
        this.j = movieEntity;
        this.i = file;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            Float f2 = movieParams.viewBoxWidth;
            float f3 = WheelView.DividerConfig.FILL;
            this.f15585b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, f2 != null ? f2.floatValue() : WheelView.DividerConfig.FILL, movieParams.viewBoxHeight != null ? r0.floatValue() : f3);
            Integer num = movieParams.fps;
            this.f15586c = num != null ? num.intValue() : 20;
            Integer num2 = movieParams.frames;
            this.f15587d = num2 != null ? num2.intValue() : 0;
        }
        try {
            a(movieEntity);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        b(movieEntity);
    }

    private final void a(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> setEntrySet;
        Bitmap bitmapDecodeFile;
        Map<String, ByteString> map = movieEntity.images;
        if (map == null || (setEntrySet = map.entrySet()) == null) {
            return;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            C2432r.f15590a.inPreferredConfig = Bitmap.Config.RGB_565;
            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
            kotlin.jvm.internal.i.a((Object) byteArray, "byteArray");
            if (byteArray.length >= 4) {
                List<Byte> listA = kotlin.collections.i.a(byteArray, new kotlin.d.d(0, 3));
                if (listA.get(0).byteValue() != 73 || listA.get(1).byteValue() != 68 || listA.get(2).byteValue() != 51) {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, C2432r.f15590a);
                    if (bitmapDecodeByteArray != null) {
                        HashMap<String, Bitmap> map2 = this.h;
                        kotlin.jvm.internal.i.a((Object) str, "imageKey");
                        map2.put(str, bitmapDecodeByteArray);
                    } else {
                        String strUtf8 = ((ByteString) entry.getValue()).utf8();
                        if (strUtf8 != null) {
                            String str2 = this.i.getAbsolutePath() + "/" + strUtf8;
                            Bitmap bitmapDecodeFile2 = new File(str2).exists() ? BitmapFactory.decodeFile(str2, C2432r.f15590a) : null;
                            if (bitmapDecodeFile2 != null) {
                                this.h.put(str, bitmapDecodeFile2);
                            } else {
                                String str3 = this.i.getAbsolutePath() + "/" + str + ".png";
                                if (!new File(str3).exists()) {
                                    str3 = null;
                                }
                                if (str3 != null && (bitmapDecodeFile = BitmapFactory.decodeFile(str3, C2432r.f15590a)) != null) {
                                    this.h.put(str, bitmapDecodeFile);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void a(MovieEntity movieEntity, kotlin.jvm.a.a<kotlin.l> aVar) throws IOException {
        SoundPool soundPool;
        SoundPool soundPool2;
        HashMap map;
        Set<Map.Entry<String, ByteString>> setEntrySet;
        List<AudioEntity> list = movieEntity.audios;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            List<AudioEntity> list2 = list;
            if (list2 != null) {
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 0;
                if (Build.VERSION.SDK_INT >= 21) {
                    soundPool = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).setMaxStreams(Math.min(12, list2.size())).build();
                } else {
                    soundPool = new SoundPool(Math.min(12, list2.size()), 3, 0);
                }
                HashMap map2 = new HashMap();
                soundPool.setOnLoadCompleteListener(new p(ref$IntRef, list2, this, aVar, movieEntity));
                HashMap map3 = new HashMap();
                Map<String, ByteString> map4 = movieEntity.images;
                if (map4 != null && (setEntrySet = map4.entrySet()) != null) {
                    Iterator<T> it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        String str = (String) entry.getKey();
                        byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                        kotlin.jvm.internal.i.a((Object) byteArray, "byteArray");
                        if (byteArray.length >= 4) {
                            List<Byte> listA = kotlin.collections.i.a(byteArray, new kotlin.d.d(0, 3));
                            if (listA.get(0).byteValue() == 73 && listA.get(1).byteValue() == 68 && listA.get(2).byteValue() == 51) {
                                kotlin.jvm.internal.i.a((Object) str, "imageKey");
                                map3.put(str, byteArray);
                            }
                        }
                    }
                }
                if (map3.size() > 0) {
                    for (Map.Entry entry2 : map3.entrySet()) {
                        File fileCreateTempFile = File.createTempFile((String) entry2.getKey(), ".mp3");
                        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                        fileOutputStream.write((byte[]) entry2.getValue());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Object key = entry2.getKey();
                        kotlin.jvm.internal.i.a((Object) fileCreateTempFile, "tmpFile");
                        map2.put(key, fileCreateTempFile);
                    }
                }
                ArrayList arrayList = new ArrayList(kotlin.collections.n.a(list2, 10));
                for (AudioEntity audioEntity : list2) {
                    kotlin.jvm.internal.i.a((Object) audioEntity, LibStorageUtils.AUDIO);
                    com.opensource.svgaplayer.entities.a aVar2 = new com.opensource.svgaplayer.entities.a(audioEntity);
                    File file = (File) map2.get(audioEntity.audioKey);
                    if (file != null) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileDescriptor fd = fileInputStream.getFD();
                        Integer num = audioEntity.startTime;
                        double dIntValue = num != null ? num.intValue() : 0;
                        Integer num2 = audioEntity.totalTime;
                        double dIntValue2 = num2 != null ? num2.intValue() : 0;
                        Double.isNaN(dIntValue);
                        Double.isNaN(dIntValue2);
                        double d2 = dIntValue / dIntValue2;
                        double dAvailable = fileInputStream.available();
                        Double.isNaN(dAvailable);
                        soundPool2 = soundPool;
                        map = map2;
                        aVar2.b(Integer.valueOf(soundPool.load(fd, (long) (d2 * dAvailable), fileInputStream.available(), 1)));
                        fileInputStream.close();
                    } else {
                        soundPool2 = soundPool;
                        map = map2;
                    }
                    arrayList.add(aVar2);
                    soundPool = soundPool2;
                    map2 = map;
                }
                this.f15589f = arrayList;
                this.g = soundPool;
                return;
            }
        }
        aVar.invoke();
    }
}
