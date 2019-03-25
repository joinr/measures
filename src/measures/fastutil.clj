(ns measures.fastutil
    (:import [it.unimi.dsi.fastutil.doubles DoubleArrayList] 
             [it.unimi.dsi.fastutil.floats FloatArrayList]
             [it.unimi.dsi.fastutil.ints IntArrayList]
             [it.unimi.dsi.fastutil.longs LongArrayList]
             [it.unimi.dsi.fastutil.shorts ShortArrayList]
             [it.unimi.dsi.fastutil.bytes ByteArrayList]))

(defn ^LongArrayList long-array-list [size-or-seq]
  (reduce (fn [^LongArrayList acc x]
            (doto acc (.add ^long x)))
          (new LongArrayList)
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))

(defn ^ShortArrayList short-array-list [size-or-seq]
  (reduce (fn [^ShortArrayList acc x]
            (doto acc (.add ^short x)))
          (new ShortArrayList)
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))

(defn ^IntArrayList int-array-list [size-or-seq]
  (reduce (fn [^IntArrayList acc x]
            (doto acc (.add ^int x)))
          (new IntArrayList)
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))

(defn ^DoubleArrayList double-array-list [size-or-seq]
  (reduce (fn [^DoubleArrayList acc x]
            (doto acc (.add ^double x)))
          (new DoubleArrayList)          
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))

(defn ^ByteArrayList byte-array-list [size-or-seq]
  (reduce (fn [^ByteArrayList acc x]
            (doto acc (.add ^byte x)))
          (new ByteArrayList)
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))

(defn ^FloatArrayList float-array-list [size-or-seq]
  (reduce (fn [^FloatArrayList acc x]
            (doto acc (.add ^float x)))
          (new FloatArrayList)          
          (if (number? size-or-seq)
            (repeat size-or-seq 0)
            size-or-seq)))
