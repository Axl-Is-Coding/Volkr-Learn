package com.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes5.dex */
public class Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f20097a = true;

    public List<Entity> a(String str) {
        if (str != null && str.length() != 0) {
            if (str.indexOf(this.f20097a ? 46 : 58) != -1) {
                ArrayList arrayList = new ArrayList();
                Matcher matcher = a.l.matcher(str);
                while (matcher.find()) {
                    if (matcher.group(4) != null || (this.f20097a && !a.n.matcher(matcher.group(2)).matches())) {
                        String strGroup = matcher.group(3);
                        int iStart = matcher.start(3);
                        int iEnd = matcher.end(3);
                        Matcher matcher2 = a.m.matcher(strGroup);
                        if (matcher2.find()) {
                            strGroup = matcher2.group();
                            iEnd = strGroup.length() + iStart;
                        }
                        arrayList.add(new Entity(iStart, iEnd, strGroup, Entity.Type.URL));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public static class Entity {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f20098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected int f20099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final String f20100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final String f20101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final Type f20102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected String f20103f;
        protected String g;

        public enum Type {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public Entity(int i, int i2, String str, String str2, Type type) {
            this.f20103f = null;
            this.g = null;
            this.f20098a = i;
            this.f20099b = i2;
            this.f20100c = str;
            this.f20101d = str2;
            this.f20102e = type;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entity)) {
                return false;
            }
            Entity entity = (Entity) obj;
            return this.f20102e.equals(entity.f20102e) && this.f20098a == entity.f20098a && this.f20099b == entity.f20099b && this.f20100c.equals(entity.f20100c);
        }

        public int hashCode() {
            return this.f20102e.hashCode() + this.f20100c.hashCode() + this.f20098a + this.f20099b;
        }

        public String toString() {
            return this.f20100c + "(" + this.f20102e + ") [" + this.f20098a + "," + this.f20099b + "]";
        }

        public Entity(int i, int i2, String str, Type type) {
            this(i, i2, str, null, type);
        }
    }
}
