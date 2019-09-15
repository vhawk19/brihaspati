(ns brihaspati.models.events
    (:require   [brihaspati.db.events :as events]
                [clojure.tools.logging :as log]))

(defn create-event [event-details db-spec]
    (log/info event-details)
    (events/create-event event-details db-spec))