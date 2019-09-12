(ns brihaspati.http.server
    (:require   [ring.adapter.jetty :as jetty]
                [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
                [ring.util.response :as response]
                [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
                [clojure.tools.logging :as log]
                [brihaspati.http.handlers.questions :as questions]
                [brihaspati.http.handlers.users :as users]))


(defn handler 
  [request]
  {:status 200
    :body "<h1>Hello, Clojure World</h1>  <p>Welcome to your first Clojure app.  This message is returned regardless of the request, sorry</p>"
    :headers {}})

(defn wrap [handler]
        (-> handler
            (wrap-json-body {:keywords? true})
            (wrap-json-response)))

(defroutes app-routes
        (POST "/api/question" [] (wrap questions/create-question-handler))
        (POST "/api/user" [] (wrap users/create-user-handler)))

(defn int-parse [port]
    (try 
        (Integer/parseInt port)
        (catch Exception e (log/info e) 8080)))

(defonce server (atom nil))

(defn start [port]
    (reset! server (jetty/run-jetty app-routes {:port (int-parse port)})))

(defn stop []
    (.stop @server)
    (reset! server nil))