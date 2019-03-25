(ns measures.core
  (:require [clj-memory-meter.core :as mm]
            [clojure.pprint :as pprint]
            [measures.fastutil :as fast]))

(def types {:byte   byte-array
            :short  short-array
            :int    int-array
            :long   long-array
            :float  float-array
            :double double-array
            :object object-array})

(def ftypes {:byte   fast/byte-array-list
             :short  fast/short-array-list
             :int    fast/int-array-list
             :long   fast/long-array-list
             :float  fast/float-array-list
             :double fast/double-array-list})

(defn measures [& {:keys [n] :or {n 10000}}]
  (println [:measuring-at n])
  (doseq [[prim ctor] types]
    (println  (pprint/cl-format nil "~a array: ~a vector: ~a fastutil: ~a"
                                prim
                                (mm/measure (ctor (repeat n 10)))
                                (mm/measure (into (if (= prim :object) [] (vector-of prim))
                                                  (repeat n 10)))
                                (when-let [ctor (ftypes prim)]
                                  (mm/measure (ctor (repeat n 10))))))))
                    
