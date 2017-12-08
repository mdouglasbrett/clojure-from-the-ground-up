(ns scratch.core-test
  (:require [clojure.test :refer :all]
            [scratch.core :refer :all]))

(deftest a-test
  (testing "Numbers are equal to themselves, right?"
    (is (= 0 0))))

(deftest pow-test
  (testing "unity"
    (is (= 1 (pow 1 1)))))
