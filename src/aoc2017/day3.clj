(ns aoc2017.day3)

(def input 265149)

(defn layer [n]
  (-> (Math/sqrt n) Math/ceil (/ 2) int))

(defn square [n]
  (* n n))

(defn nth-odd [n]
  (inc (* 2 n)))

(defn abs [n]
  (Math/abs ^int n))

(defn distance [n]
  (let [l (layer n)
        index (- n (square (nth-odd (dec l))))
        pos (mod index (dec (nth-odd l)))
        offs (abs (- l pos))]
    (+ l offs)))

(comment
  (distance input))

(defn direction [x y]
  (cond
    (> (abs x) (abs y)) (if (pos? x) :right :left)
    (< (abs x) (abs y)) (if (pos? y) :up :down)
    (= (abs x) (abs y))
    (if (pos? x)
      (if (pos? y) :right :down)
      (if (pos? y) :up :left))))

(defn index [x y]
  (let [l (max (abs x) (abs y))
        lmax (square (nth-odd l))
        subtract (case (direction x y)
                   :down (+ l (- x))
                   :left (+ (* 3 l) y)
                   :up (+ (* 5 l) x)
                   :right (+ (* 7 l) (- y)))]
    (dec (- lmax subtract))))

(defn coords [index]
  (let [index (inc index)
        l (layer index)
        lmax (square (nth-odd l))
        offs (- lmax index)]
    (cond
      (> index (- lmax (* 2 l))) [(- l offs) (- l)]
      (> index (- lmax (* 4 l))) [(- l) (- offs (* 3 l))]
      (> index (- lmax (* 6 l))) [(- offs (* 5 l)) l]
      :default [l (- (* 7 l) offs)])))

(comment
  (->> (for [n (range 10000)]
         (when (not= n (apply index (coords n)))))
       (remove nil?)))

(defn neighbors [memory [x y]]
  (->> (for [dx (range -1 2)
             dy (range -1 2)
             :when (not= x y 0)]
         (nth memory (index (+ x dx) (+ y dy)) nil))
       (remove nil?)))

(defn stress-test [memory]
  (->> (coords (count memory))
       (neighbors memory)
       (reduce +)
       (conj memory)))

(comment
  (->> (iterate stress-test [1])
       (take-while #(<= (last %) input))
       (last)
       (stress-test)
       (last)))
