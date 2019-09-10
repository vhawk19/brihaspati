(ns brihaspati.http.server
    (:require [ring.adapter.jetty :as jetty]
            [clojure.tools.logging :as log]))


(defn handler 
  [request]
  {:status 200
    :body "<h1>Hello, Clojure World</h1>  <p>Welcome to your first Clojure app.  This message is returned regardless of the request, sorry</p>"
    :headers {}})

(defn int-parse [port]
    (try 
        (Integer/parseInt port)
        (catch Exception e (log/info e) 8080)))

(defonce server (atom nil))

(defn start [port]
    (reset! server (jetty/run-jetty handler {:port (int-parse port)})))

(defn stop []
    (.stop @server)
    (reset! server nil))