(defproject chardin "0.0.1-SNAPSHOT"
  :description "Stretching the concept of a wiki"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]
                 [compojure "0.4.0"]
                 [ring/ring-jetty-adapter "0.2.3"]
                 [com.ashafa/clutch "0.2.1"]]
  :dev-dependencies [[swank-clojure "1.2.1"]]
  :main com.benatkin.chardin.app2)
