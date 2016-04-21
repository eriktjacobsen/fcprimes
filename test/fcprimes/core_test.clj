(ns fcprimes.core-test
  (:require [clojure.test :refer :all]
            [fcprimes.core :refer :all]))

;;;;;;;;;;;;;;;;;;;;;;
;;; Primes Testing ;;;
;;;;;;;;;;;;;;;;;;;;;;

(deftest prime-count
  (testing "Make sure I get the number of primes I'm asking for."
    (is (= 1    (count (primes 1))))
    (is (= 5    (count (primes 5))))
    (is (= 10   (count (primes 10))))
    (is (= 50   (count (primes 50))))
    (is (= 100  (count (primes 100))))
    (is (= 500  (count (primes 500))))
    (is (= 1000 (count (primes 1000))))))

(deftest prime-integers?
  (testing "When I generate primes, I want integers."
    (is (= 0 (count (remove integer? (primes 1000)))))))


; These primes were pulled from: https://primes.utm.edu/lists/small/1000.txt
(deftest prime-primes?
  (testing "When I generate primes, check they are actually primes."
    (let [first-100 [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313 317 331 337 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439 443 449 457 461 463 467 479 487 491 499 503 509 521 523 541]]
      (is (= first-100 (primes 100))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Times Table Testing ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;

(deftest table-rows
  (testing "Given an input of n numbers, check there are (n+1) rows."
    (let [size 5]
      (is (= (inc size) (count (times-table (range size))))))))

(deftest table-columns
  (testing "Given an input of n numbers, check there are (n+1) columns in each row."
    (let [size 5]
      (is (= (take (inc size) (repeat (inc size))) (map count (times-table (range size))))))))
