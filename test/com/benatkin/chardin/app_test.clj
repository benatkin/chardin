(ns com.benatkin.chardin.app-test
  (use [com.benatkin.chardin.app] :reload-all)
  (use [clojure.test]))

(defn request [resource web-app & params]
  (web-app {:request-method :get :uri resource :params (first params)}))

(deftest test-routes
  (is (:body (request "/" web-app)) "Hello!"))
