package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class I extends com.google.gson.x<BitSet> {
    I() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // com.google.gson.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.BitSet a(com.google.gson.stream.JsonReader r8) throws java.io.IOException {
        /*
            r7 = this;
            java.util.BitSet r0 = new java.util.BitSet
            r0.<init>()
            r8.beginArray()
            com.google.gson.stream.JsonToken r1 = r8.peek()
            r2 = 0
            r3 = 0
        Le:
            com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
            if (r1 == r4) goto L75
            int[] r4 = com.google.gson.internal.bind.K.f14133a
            int r5 = r1.ordinal()
            r4 = r4[r5]
            r5 = 1
            if (r4 == r5) goto L63
            r6 = 2
            if (r4 == r6) goto L5e
            r6 = 3
            if (r4 != r6) goto L47
            java.lang.String r1 = r8.nextString()
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
            if (r1 == 0) goto L2e
            goto L69
        L2e:
            r5 = 0
            goto L69
        L30:
            com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L47:
            com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Invalid bitset value type: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L5e:
            boolean r5 = r8.nextBoolean()
            goto L69
        L63:
            int r1 = r8.nextInt()
            if (r1 == 0) goto L2e
        L69:
            if (r5 == 0) goto L6e
            r0.set(r3)
        L6e:
            int r3 = r3 + 1
            com.google.gson.stream.JsonToken r1 = r8.peek()
            goto Le
        L75:
            r8.endArray()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.I.a(com.google.gson.stream.JsonReader):java.util.BitSet");
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
        jsonWriter.beginArray();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            jsonWriter.value(bitSet.get(i) ? 1L : 0L);
        }
        jsonWriter.endArray();
    }
}
