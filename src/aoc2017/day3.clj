(ns aoc2017.day3)

(def input 265149)

(defn layer [n]
  (-> (Math/sqrt n)
      (Math/ceil)
      (/ 2)
      (int)))

(defn square [n]
  (* n n))

(defn nth-odd [n]
  (inc (* 2 n)))

(defn distance [n]
  (let [l (layer n)
        index (- n (square (nth-odd (dec l))))
        pos (mod index (dec (nth-odd l)))
        offs (Math/abs ^int (- l pos))]
    (+ l offs)))

(comment
  (distance input))
