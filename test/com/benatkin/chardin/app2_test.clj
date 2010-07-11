(ns com.benatkin.chardin.app2-test
  (use [com.benatkin.chardin.app2] :reload-all)
  (use [clojure.test]))

(deftest test-parse-path
  (is (= (parse-path "bad-80s-music") {:page "bad-80s-music"}))
  (is (= (parse-path "") {:page "home"})))

(defn req [path]
  {:request-method :get
   :uri (str "http://localhost:8080/" path)})

(deftest test-app
  (let [response (web-app (req "bad-80s-music"))]
    (is (= (:status response) 404))
    (is (= ((:headers response) "Content-Type") "text/html"))
    (is (re-find #"(?i)not found" (:body response)))))
