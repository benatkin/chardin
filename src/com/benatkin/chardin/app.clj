(ns com.benatkin.chardin.app
  (:gen-class)
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]))

(defroutes web-app
  (GET "/" [] "Hello!"))

(defn start-app []
  (run-jetty web-app {:port 8080}))

(defn -main [& args]
  (start-app))
