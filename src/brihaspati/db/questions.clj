(ns brihaspati.db.questions
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-question [question db-spec]
    (jdbc/insert! db-spec :questions question))

(defn create-questions [questions db-spec]
    (jdbc/insert-multi! db-spec :questions
                                questions))


(defn get-question-qid [qid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :questions)
                                  (where [:= :id qid])
                                  sql/format))))

(defn get-question-eid [eid db-spec]
    (jdbc/query db-spec ( ->  (select :*)
                                        (from :questions)
                                        (where [:= :event_id eid])
                                        sql/format)))