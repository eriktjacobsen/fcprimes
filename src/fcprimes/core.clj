(ns fcprimes.core
  (:require [clojure.string :as str])
  (:gen-class))

; This is something I had pre-written from prior code.
(defn str->int [string]
  (let [parsed (re-find #"-?\d+" (str string))]
    (if (empty? parsed) nil (Integer. parsed))))

; Starting with n, perhaps could extend to be lazy in future
; Initially started with checking every prime, later revision optimizes
; filters to sqrt of number
(defn primes
  "Generates a list of primes, from 2 to n"
  [limit]
  (when (> limit 0) ;just in case of negative or empty list
    (reduce
        (fn [primes-list n]
          (let [sqrt (Math/sqrt n)]
            (if (>= (count primes-list) limit)
              (reduced primes-list)
              (if (some #(= 0 (rem n %)) (take-while #(<= % sqrt) (rest primes-list)))
                primes-list
                (conj primes-list n)))))
        [2] (range 3 Integer/MAX_VALUE 2))))

; Start with generating all, though can be optimized into half by rotating
(defn times-table
  "Takes list of numbers, generates a multiplication table"
  [numbers]
  (apply vector
    (into [""] numbers) ;For display row
    (map (fn [n]
          (for [x (into [1] numbers)] ;For display column
            (* n x))) numbers)))

(defn print-table
  "Outputs a multiplcation table to the screen"
  [table]
  (dorun
    (for [row table]
      (println (str/join "\t" row)))))

(defn -main [& args]
  (let [size (or (str->int (first args)) 10)]
    (-> (primes size)
      (times-table)
      (print-table))))
