(ns brihaspati.models.users-events
    (:require   [brihaspati.db.users-events :as users-events]))

(defn create-user-event [user-event-details db-spec]
    (users-events/create-user-event user-event-details db-spec))