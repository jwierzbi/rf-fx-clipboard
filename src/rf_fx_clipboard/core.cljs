(ns rf-fx-clipboard.core
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-fx
 :write-to-clipboard-fx
 (fn [{:keys [text on-success on-failure]}]
   (-> (.. js/navigator -clipboard (writeText text))
       (.then
        (fn [response]
          (re-frame/dispatch (conj on-success response))))
       (.catch
        (fn [error]
          (re-frame/dispatch (conj on-failure error)))))))
