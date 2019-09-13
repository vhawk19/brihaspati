(ns brihaspati.db.events
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-event [event db-spec]
    ()
    (jdbc/insert! db-spec :events event))

(defn get-event-eid [eid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :events)
                                  (where [:= :id eid])
                                  sql/format))))
