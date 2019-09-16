(ns brihaspati.db.users-answers
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-user-answer [user-answer db-spec]
    (jdbc/insert! db-spec :users_answers user-answer))

(defn get-user-answer-uaid [qid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :users_answers)
                                  (where [:= :id qid])
                                  sql/format))))
(defn get-user-answer-eid [eid db-spec]
    (jdbc/query db-spec ( ->  (select :*)
                                        (from :users_answers)
                                        (where [:= :event_id eid])
                                        sql/format)))
                                