(ns brihaspati.models.user_response
    (:require [brihaspati.db.user_response :as db]
              [clojure.tools.logging :as log]))

(defn create-response [response-details db-spec eid]
    (let [response-detail-with-eid (map (fn add-event-id [response-detail]
                                            (assoc response-detail :event_id eid))
                                             response-details)]
    (db/create-user-response response-detail-with-eid db-spec)))