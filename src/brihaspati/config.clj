(ns brihaspati.config
  (:require [aero.core :refer [read-config]]
            [clojure.tools.logging :as log]
            [clojure.java.jdbc :as jdbc]
            [clojure.java.io :as io]))



;(defn db-spec []
;    (get (read-config "config.edn") :db-spec))


(defn- config
  ([]
   (-> "config.edn"
       io/resource
       read-config))
  ([test]
   (-> "config.edn"
       io/resource
       (read-config test))))

(defn get-db-spec [testing-header]
  (if (= "true" testing-header)
    (:db-spec (config {:profile :test}))
    (:db-spec (config))))

(defn db-spec []
  (:db-spec (config)))

(defn test-db-spec []
  (:db-spec (config {:profile :test})))


(defn port []
  (:port (config)))
(ns thursdays.config
  (:require [aero.core :refer [read-config]]
            [clojure.tools.logging :as log]
            [clojure.java.jdbc :as jdbc]
            [clojure.java.io :as io]))

