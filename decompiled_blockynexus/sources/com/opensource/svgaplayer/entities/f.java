package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SVGAVideoSpriteEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<g> f15525c;

    public f(JSONObject jSONObject) {
        i.b(jSONObject, "obj");
        this.f15523a = jSONObject.optString("imageKey");
        this.f15524b = jSONObject.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("frames");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    g gVar = new g(jSONObjectOptJSONObject);
                    if ((!gVar.d().isEmpty()) && ((SVGAVideoShapeEntity) k.d(gVar.d())).e() && arrayList.size() > 0) {
                        gVar.a(((g) k.e(arrayList)).d());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.f15525c = u.b((Iterable) arrayList);
    }

    public final List<g> a() {
        return this.f15525c;
    }

    public final String b() {
        return this.f15523a;
    }

    public final String c() {
        return this.f15524b;
    }

    public f(SpriteEntity spriteEntity) {
        List<g> listA;
        i.b(spriteEntity, "obj");
        this.f15523a = spriteEntity.imageKey;
        this.f15524b = spriteEntity.matteKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            listA = new ArrayList<>(n.a(list, 10));
            g gVar = null;
            for (FrameEntity frameEntity : list) {
                i.a((Object) frameEntity, "it");
                g gVar2 = new g(frameEntity);
                if ((!gVar2.d().isEmpty()) && ((SVGAVideoShapeEntity) k.d(gVar2.d())).e() && gVar != null) {
                    gVar2.a(gVar.d());
                }
                listA.add(gVar2);
                gVar = gVar2;
            }
        } else {
            listA = m.a();
        }
        this.f15525c = listA;
    }
}
