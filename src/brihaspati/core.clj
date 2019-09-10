(ns brihaspati.core
  (:gen-class)
  (:require [brihaspati.http.server :as server]
            [clojure.tools.logging :as log]))

(defn -main
  [& args]
  "starts the brihaspati webserver"
  (server/start "9001")
  (println "Hello, World!"))
