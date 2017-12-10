(ns aoc2017.day6
  (:require [clojure.string :as string]))

(def input
  "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11")

(defn parse [input]
  (->> (string/split input #"\t")
       (mapv #(Integer/parseInt %))))

(defn redistribute [banks]
  (let [v (apply max banks)
        index (.indexOf banks v)
        src (banks index)
        n (count banks)]
    (loop [banks (assoc banks index 0)
           src src
           index (inc index)]
      (if (pos? src)
        (recur (update banks (mod index n) inc)
               (dec src)
               (inc index))
        banks))))

(defn step [[banks seen]]
  [(redistribute banks) (conj seen banks)])

(defn halt-seq [banks]
  (->> (iterate step [banks #{}])
       (take-while (fn [[banks seen]]
                     (not (contains? seen banks))))))

(defn steps [banks]
  (count (halt-seq banks)))

(defn loop-size [banks]
  (->> (halt-seq banks)
       (last)
       (first)
       (steps)))

(comment
  (steps [0 2 7 0])
  (steps (parse input))
  (loop-size [0 2 7 0])
  (loop-size (parse input)))