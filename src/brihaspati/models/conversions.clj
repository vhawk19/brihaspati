(ns brihaspati.models.conversions)



(defn to-vec 
  [x]
  (->> x
      (map #(vec (vals %))) 
      (vec)))


(defn replace-hyphen [map-entry]
  (let [map-key (name (first map-entry))
        map-value (second map-entry)]
    (vector (keyword (clojure.string/replace map-key #"-" "_")) map-value)))


(defn hyphen-to-underscore-converter [incoming-map]
  (into {} (map replace-hyphen incoming-map)))