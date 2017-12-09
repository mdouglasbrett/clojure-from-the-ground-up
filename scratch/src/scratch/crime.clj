(ns scratch.crime
  (:require [cheshire.core :as json]))

(defn load-json
  "Given a filename, reads a JSON file and returns it, parsed, with keywords."
  [file]
  (json/parse-string (slurp file) true))

(def fips
  "A map of FIPS codes to their county names."
  (->> "fips.json"
       load-json
       :table
       :rows
       (into {})))

