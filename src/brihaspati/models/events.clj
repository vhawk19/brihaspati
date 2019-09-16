(ns brihaspati.models.events
    (:require   [brihaspati.db.events :as events]
                [clojure.tools.logging :as log]))

(defn create-event [event-details db-spec]
    (events/create-event event-details db-spec))

(defn get-event [eid db-spec] 
    (events/get-event-eid eid db-spec))