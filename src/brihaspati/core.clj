(ns brihaspati.core
  (:gen-class)
  (:require [brihaspati.http.server :as server]
            [clojure.tools.logging :as log]
            [brihaspati.db.migrations :as db-migrations]
            [brihaspati.config :as config]))

(defn -main
  [& args]
  "starts the brihaspati webserver"
  (db-migrations/migrate)
  (log/info "All migrations applied")
  (server/start (config/port))
  (log/info "Server started"))
