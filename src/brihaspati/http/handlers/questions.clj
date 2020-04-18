(ns brihaspati.http.handlers.questions
    (:require   [brihaspati.models.questions :as models]
                [ring.util.response :refer [response status]]
                [brihaspati.config :as config]
                [clojure.tools.logging :as log]))

(defn create-question-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
          (log/info req)
          (try 
            (models/create-questions request-body db-spec)
            (response nil)
            (catch Exception e (status (response (str "caught exception" (.getMessage e)))
                                       500)))))

(defn get-questions-event-handler [req ]
  (let [db-spec (config/db-spec)
        event-id  (get-in req [:params :event-id])]
      (try 
            (response (models/get-questions-event event-id db-spec))
            (catch Exception e (status (response (str "caught exception" (.getMessage e)))
                                        500)))))