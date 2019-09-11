(ns brihaspati.http.handlers.questions
    (:require   [brihaspati.models.questions :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-question-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (models/create-question request-body db-spec)))