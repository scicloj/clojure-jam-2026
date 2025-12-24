^:kindly/hide-code
(ns sessions
  "Sessions page for Clojure Jam"
  (:require [clojure.edn :as edn]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def conference-data
  (edn/read-string (slurp "info.edn")))

^:kindly/hide-code
(kind/hiccup
 [:div {:style "display: flex; justify-content: flex-end; margin: 1rem 0; padding: 0.5rem; background: #f8f9fa; border-radius: 6px; border: 1px solid #e0e0e0;"}
  [:div {:style "display: flex; align-items: center; gap: 0.5rem;"}
   [:span {:style "font-size: 0.9rem; color: #666;"} "Supported by: "]
   (for [[company-key company-data] (:supporting-companies conference-data)]
     [:a {:key (name company-key)
          :href "./index.html#supporting-companies"
          :style "display: inline-flex; align-items: center; gap: 0.5rem; margin-left: 0.5rem; text-decoration: none;"}
      (when-let [logo-mark (:logo-mark company-data)]
        [:img {:src logo-mark
               :alt (str (:name company-data) " mark")
               :style "height: 20px; width: auto;"}])
      (when-let [logo (:logo company-data)]
        [:img {:src logo
               :alt (str (:name company-data) " logo")
               :style "height: 20px; width: auto;"}])])]])

;; # Sessions

;; Sessions will be announced here once talk and workshop proposals are accepted!

;; ## Want to Present?

;; We're seeking creative coding talks and workshops covering music, art, visualization, and more.

;; 👉 [Submit Your Proposal](./speakers.html)

^:kindly/hide-code
(kind/hiccup
 [:div {:style "text-align: center; margin: 2rem 0;"}
  [:a {:href "./speakers.html"
       :class "btn btn-gradient"
       :style "display: inline-block; text-decoration: none; font-size: 1.1rem; padding: 0.75rem 1.5rem;"
       :aria-label "Submit your proposal for Clojure Jam"}
   "🎨 Submit Your Proposal"]])

;; ## Stay Updated
;;
;; - Join the [Clojurians Zulip](https://scicloj.github.io/docs/community/chat/) #clojure-jam channel
;; - Check back on this page for session announcements
;; - Follow [Scicloj](https://scicloj.github.io/) for updates
