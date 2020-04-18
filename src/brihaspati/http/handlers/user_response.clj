(ns brihaspati.http.handlers.user_response
    (:require [brihaspati.models.user_response :as models]
    [ring.util.response :refer [response status]]
    [clojure.tools.logging :as log]
    [brihaspati.http.user :as user]
    [brihaspati.config :as config]))

(defn create-response-handler [req]
    (let [db-spec (config/db-spec)
         request-body (:body req)
         event-id (get-in req [:params :event-id])
         user-id  (user/get-uid req)
         response-details (map (fn add-user-id [request-body]
                                            (assoc request-body :user_id user-id))
                                             request-body)]
         (log/info req)
         (log/info user-id)
         (log/info response-details)
         (try
            (models/create-response response-details db-spec event-id)
            (response nil)
            (catch Exception e (status (response (str "caught exception" (.getMessage e)))
                                        500)))))