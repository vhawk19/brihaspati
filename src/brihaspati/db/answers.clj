(ns brihaspati.db.answers
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-answer [answer db-spec]
    (jdbc/insert! db-spec :answers answer))

(defn create-answers [answers db-spec]
    (jdbc/insert-multi! db-spec :answers    
                                answers))

(defn get-answers-aid-eid [eid db-spec]
    (jdbc/query db-spec ( ->  (select [:id :answer])
                                        (from :answers)
                                        (where [:= :event_id eid])
                                        sql/format)))

(defn get-answer-aid [aid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :answers)
                                  (where [:= :id aid])
                                  sql/format))))

(defn get-answers-eid [eid db-spec]
    (jdbc/query db-spec ( ->  (select :*)
                                        (from :answers)
                                        (where [:= :event_id eid])
                                        sql/format)))