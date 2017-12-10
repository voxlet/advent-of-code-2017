(ns aoc2017.day2
  (:require [clojure.string :as string]
            [clojure.math.combinatorics :as combo]))

(def input
  "409\t194\t207\t470\t178\t454\t235\t333\t511\t103\t474\t293\t525\t372\t408\t428\n4321\t2786\t6683\t3921\t265\t262\t6206\t2207\t5712\t214\t6750\t2742\t777\t5297\t3764\t167\n3536\t2675\t1298\t1069\t175\t145\t706\t2614\t4067\t4377\t146\t134\t1930\t3850\t213\t4151\n2169\t1050\t3705\t2424\t614\t3253\t222\t3287\t3340\t2637\t61\t216\t2894\t247\t3905\t214\n99\t797\t80\t683\t789\t92\t736\t318\t103\t153\t749\t631\t626\t367\t110\t805\n2922\t1764\t178\t3420\t3246\t3456\t73\t2668\t3518\t1524\t273\t2237\t228\t1826\t182\t2312\n2304\t2058\t286\t2258\t1607\t2492\t2479\t164\t171\t663\t62\t144\t1195\t116\t2172\t1839\n114\t170\t82\t50\t158\t111\t165\t164\t106\t70\t178\t87\t182\t101\t86\t168\n121\t110\t51\t122\t92\t146\t13\t53\t34\t112\t44\t160\t56\t93\t82\t98\n4682\t642\t397\t5208\t136\t4766\t180\t1673\t1263\t4757\t4680\t141\t4430\t1098\t188\t1451\n158\t712\t1382\t170\t550\t913\t191\t163\t459\t1197\t1488\t1337\t900\t1182\t1018\t337\n4232\t236\t3835\t3847\t3881\t4180\t4204\t4030\t220\t1268\t251\t4739\t246\t3798\t1885\t3244\n169\t1928\t3305\t167\t194\t3080\t2164\t192\t3073\t1848\t426\t2270\t3572\t3456\t217\t3269\n140\t1005\t2063\t3048\t3742\t3361\t117\t93\t2695\t1529\t120\t3480\t3061\t150\t3383\t190\n489\t732\t57\t75\t61\t797\t266\t593\t324\t475\t733\t737\t113\t68\t267\t141\n3858\t202\t1141\t3458\t2507\t239\t199\t4400\t3713\t3980\t4170\t227\t3968\t1688\t4352\t4168")

(defn parse [input]
  (->> (string/split input #"\n")
       (mapv (fn [row]
               (->> (string/split row #"\t")
                    (mapv #(Integer/parseInt %)))))))

(defn diff [row]
  (- (apply max row) (apply min row)))

(defn checksum [rows]
  (->> (map diff rows)
       (reduce +)))

(defn quotient [row]
  (->> (combo/combinations row 2)
       (map #(sort (comp - compare) %))
       (filter #(= (apply mod %) 0))
       (map #(apply quot %))))

(defn checksum-2 [rows]
  (->> (mapcat quotient rows)
       (reduce +)))

(comment
  (checksum (parse input))
  (checksum-2 (parse input)))
