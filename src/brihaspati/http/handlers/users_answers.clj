(ns brihaspati.http.handlers.users-answers
    (:require   [brihaspati.models.users-answers :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-users-answers-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (response (models/create-user-answer request-body db-spec))))