(ns brihaspati.http.user
    (:require [ring.util.response :refer [response status get-header]]
                [clojure.tools.logging :as log]
                [clj-jwt.core :refer [str->jwt]]))

(defn get-uid [req]
    (let [token (get-header req "bearer")]
        (log/info (-> (str token) str->jwt :claims :user_id))
         (-> (str token) str->jwt :claims :user_id)))