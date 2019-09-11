(ns thursdays.models.hyphen-to-underscore)

(defn replace-hyphen [map-entry]
  (let [map-key (name (first map-entry))
        map-value (second map-entry)]
    (vector (keyword (clojure.string/replace map-key #"-" "_")) map-value)))


(defn hyphen-to-underscore-converter [incoming-map]
  (into {} (map replace-hyphen incoming-map)))