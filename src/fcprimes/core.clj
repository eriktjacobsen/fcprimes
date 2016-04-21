(ns fcprimes.core
  (:require [clojure.string :as str])
  (:gen-class))


; Starting with n, perhaps lazy in future
; I believe filtering from a range is more performant than generating on the fly -v2
(defn primes
  "Generates a list of primes, from 2 to n"
  [n]
  (range n))

(defn times-table
  "Takes list of numbers, generates a multiplication table"
  [numbers]
  numbers)

(defn print-table
  "Outputs a multiplcation table to the screen"
  [table]
  (println table))

(defn -main [& args]
  (-> (primes 10)
    (times-table)
    (print-table)))
