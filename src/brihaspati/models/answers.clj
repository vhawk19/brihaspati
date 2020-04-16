(ns brihaspati.models.answers
    (:require   [brihaspati.db.answers :as answers]
                [brihaspati.models.conversions :as convert]
                [clojure.tools.logging :as log]))

(defn create-answers [answer-details db-spec]
    (answers/create-answers answer-details db-spec))

(defn get-answers-event [event-id db-spec]
    (answers/get-answers-eid event-id db-spec))