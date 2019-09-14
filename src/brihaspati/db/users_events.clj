(ns brihaspati.db.users-events
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-user-event [user-event db-spec]
    (jdbc/insert! db-spec :users_events user-event))

(defn get-user-event-ueid [qid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :users_events)
                                  (where [:= :id qid])
                                  sql/format))))

                                