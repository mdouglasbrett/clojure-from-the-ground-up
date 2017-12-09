(ns scratch.crime
  (:require [cheshire.core :as json]))

(defn load-json
  "Given a filename, reads a JSON file and returns it, parsed, with keywords."
  [file]
  (json/parse-string (slurp file) true))

(defn most-duis
  "Given a JSON filename of UCR crime data for a particular year, finds the counties with the most DUIs."
  [file]
  (->> file
       load-json
       (sort-by :driving_under_influence)
       (take-last 10)
       (map #(select-keys % [:driving_under_influence
                             :fips_county_code
                             :fips_state_code]))))

(defn fips-code
  "Given a county (a map with :fips_state_code and :fips_county_code keys), returns the five-digit FIPS code for the
  county, as a string."
  [county]
  (str (:fips_state_code county) (:fips_county_code county)))

(def fips
  "A map of FIPS codes to their county names."
  (->> "fips.json"
       load-json
       :table
       :rows
       (into {})))

