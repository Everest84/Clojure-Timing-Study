(ns cs441
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import (java.util.concurrent Executors)))

(defn readFile [path]
  (map read-string
       (str/split-lines (slurp path))))

(defn workers [amount numbers]
  (partition (/ (count numbers) amount) numbers))

(defn merge-seqs
  ([left right]
   (merge-seqs (list left right)))
  ([[left right]]
   (loop [l left, r right, result []]
     (let [lhead (first l), rhead (first r)]
       (cond
             (nil? lhead) (concat result r)
             (nil? rhead) (concat result l)
             (<= lhead rhead) (recur (rest l) r (conj result lhead))
             true (recur l (rest r) (conj result rhead)))))))

(defn mergesort
  [xs]
  ((fn mergesortIndex [xs n]
     (if (<= n 1)
       xs
       (let [middle (bit-shift-right n 1)]
         (merge-seqs (map mergesortIndex
                          (split-at middle xs)
                          [middle (- n middle)])))))
    xs (count xs)))

(defn -main [& args]
  (println "Reading file...")
  (def numbers (readFile (first *command-line-args*)))
  (println "File reading complete. Running tests on 1, 2, 4, 8, 16, and 32 threads...")
  (print "1-thread mergesort: ")
  (time (mergesort numbers))
  (print "2-thread mergesort: ")
  (time (merge-seqs (pmap mergesort (workers 2 numbers))))
  (print "4-thread mergesort: ")
  (time (merge-seqs (pmap mergesort (workers 4 numbers))))
  (print "8-thread mergesort: ")
  (time (merge-seqs (pmap mergesort (workers 8 numbers))))
  (print "16-thread mergesort: ")
  (time (merge-seqs (pmap mergesort (workers 16 numbers))))
  (print "32-thread mergesort: ")
  (time (merge-seqs (pmap mergesort (workers 32 numbers))))
  (println "Tests complete.")
)
