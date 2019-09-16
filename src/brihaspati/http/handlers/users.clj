(ns brihaspati.http.handlers.users
    (:require   [brihaspati.models.users :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-user-handler [req]
    (let [request-body (:body req)
          db-spec (config/db-spec)]
        (response (models/create-user request-body db-spec))))