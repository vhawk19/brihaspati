(ns brihaspati.http.handlers.answers
    (:require   [brihaspati.models.answers :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.http.user :as user]))

(defn create-answer-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)
          user-id  (user/get-uid req)
          answer-details (map (fn add-user-id [request-body]
                                            (assoc request-body :created_by user-id))
                                             request-body)]
          (log/info req)
          (log/info user-id)
          (log/info answer-details)
          (try  
            (models/create-answers answer-details db-spec)
            (response nil)
            (catch Exception e (status (response (str "caught exception" (.getMessage e)))
                                  500)))))

(defn get-answers-event-handler [req]
    (let [db-spec (config/db-spec)
          event-id (get-in req [:params :event-id])]
          (try 
            (response (models/get-answers-event event-id db-spec))
            (catch Exception e (status (response (str "caught exception" (.getMessage e)))
                                  500)))))