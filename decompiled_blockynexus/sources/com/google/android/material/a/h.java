package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.i<String, i> f13094a = new a.a.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.a.i<String, PropertyValuesHolder[]> f13095b = new a.a.i<>();

    public void a(String str, i iVar) {
        this.f13094a.put(str, iVar);
    }

    public i b(String str) {
        if (d(str)) {
            return this.f13094a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean c(String str) {
        return this.f13095b.get(str) != null;
    }

    public boolean d(String str) {
        return this.f13094a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f13094a.equals(((h) obj).f13094a);
        }
        return false;
    }

    public int hashCode() {
        return this.f13094a.hashCode();
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f13094a + "}\n";
    }

    public PropertyValuesHolder[] a(String str) {
        if (c(str)) {
            return a(this.f13095b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public void a(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f13095b.put(str, propertyValuesHolderArr);
    }

    private PropertyValuesHolder[] a(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i = 0; i < propertyValuesHolderArr.length; i++) {
            propertyValuesHolderArr2[i] = propertyValuesHolderArr[i].clone();
        }
        return propertyValuesHolderArr2;
    }

    public <T> ObjectAnimator a(String str, T t, Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, a(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        b(str).a((Animator) objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public long a() {
        int size = this.f13094a.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            i iVarD = this.f13094a.d(i);
            jMax = Math.max(jMax, iVarD.a() + iVarD.b());
        }
        return jMax;
    }

    public static h a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return a(context, resourceId);
    }

    public static h a(Context context, int i) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return a(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e2);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(hVar, list.get(i));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }
}
