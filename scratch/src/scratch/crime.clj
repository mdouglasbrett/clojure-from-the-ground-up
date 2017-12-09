(ns scratch.crime
  (:require [cheshire.core :as json]))

(def fips
  "A map of FIPS codes to their county names."
  (->> (json/parse-string (slurp "fips.json") true)
       :table
       :rows
       (into {})))


