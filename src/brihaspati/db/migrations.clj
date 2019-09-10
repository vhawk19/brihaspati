(ns brihaspati.db.migrations
    (:require  [brihaspati.config :as config]
                [ragtime.jdbc :as jdbc]
                [ragtime.repl :as repl]))

(defn- datastore [testing] (jdbc/sql-database (config/get-db-spec testing)))
(defn- migrations [] (jdbc/load-resources "clj/migrations"))


(defn- migration-config []
  {:datastore  (datastore "false")
   :migrations (migrations)})

(defn- migration-config-test []
  {:datastore  (datastore "true")
   :migrations (migrations)})

(defn migrate []
  (repl/migrate (migration-config)))

(defn migrate-test []
  (repl/migrate (migration-config-test)))

(defn rollback-all-test []
  (repl/rollback (migration-config-test) (count (jdbc/load-resources "migrations"))))

(defn rollback []
  (repl/rollback (migration-config)))
