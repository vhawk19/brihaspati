(ns brihaspati.config-test
  (:require [clojure.test :refer :all]
            [brihaspati.db.migrations :as migrations]
            [brihaspati.http.server :as server]
            [brihaspati.config :as config]
            [clojure.java.jdbc :as jdbc]
            [clojure.tools.logging :as log]))

(defn database-setup [f]
  (migrations/rollback-all-test)
  (migrations/migrate-test)
  (prn "Cleared and migrated DB")
  (f)
  (prn "Cleared DB"))

(defn test-port [] 9002)

(defn server-setup [f]
  (server/start (str (test-port)))
  (f)
  (server/stop))

(defn transaction-setup [f]
  (do (jdbc/with-db-transaction [trans-conn (config/db-spec)]
                                (jdbc/db-set-rollback-only! trans-conn)
                                (log/info "DB SPEC" (config/db-spec))
                                (log/info "TRANSACTION" trans-conn)))
  (f))

