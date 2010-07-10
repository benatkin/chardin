(ns com.benatkin.chardin.app2-test
  (use [com.benatkin.chardin.app2] :reload-all)
  (use [clojure.test]))

(defn req [path]
  {:request-method :get
   :uri (str "http://localhost:8080" path)})

(deftest test-app
  (let [response (web-app (req "/bad-80s-music"))]
    (is (= (:status response) 404))
    (is (= (:headers "Content-Type") "text/json"))
    (is (re-find #"(?i)not found" (:body response)))))
