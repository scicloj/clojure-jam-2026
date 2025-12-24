^:kindly/hide-code
(ns people
  "People page for Clojure Jam - speakers and organizers"
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

;; # People

;; Meet the creative coders, speakers, and organizers of Clojure Jam!

;; ## Speakers

;; We're excited to announce our first speakers:

^:kindly/hide-code
(kind/hiccup
 [:div {:style "display: flex; justify-content: center; gap: 2rem; flex-wrap: wrap; margin: 2rem 0;"}
  (for [[speaker-key speaker-data] (:people conference-data)]
    [:div {:key (name speaker-key)
           :style "text-align: center; flex: 0 1 200px;"}
     [:img {:src (:image speaker-data)
            :alt (:name speaker-data)
            :style "width: 150px; height: 150px; border-radius: 50%; object-fit: cover; margin-bottom: 1rem; border: 3px solid #e0e0e0;"}]
     [:h3 {:style "margin: 0; font-size: 1.1rem;"} (:name speaker-data)]])])

;; More speakers will be announced as proposals are accepted. Want to join them?

;; 👉 [Submit Your Proposal](./speakers.html)

;; ## Organizers

;; Clojure Jam is organized by [Scicloj](https://scicloj.github.io/), the Clojure data science community.

;; Scicloj is dedicated to growing Clojure in data science, scientific computing, and now creative coding! We organize conferences, create open-source tools, and foster collaboration across the Clojure community.

;; **Want to help organize?** [Contact us](https://scicloj.github.io/docs/community/contact/)

;; ## Join the Community
;;
;; - [Clojurians Zulip](https://scicloj.github.io/docs/community/chat/) - Join the #clojure-jam channel
;; - [Clojure Civitas](https://clojurecivitas.github.io/) - Read creative coding posts from the community
;; - [Scicloj](https://scicloj.github.io/) - Learn more about our community

^:kindly/hide-code
(kind/hiccup
 [:div {:style "text-align: center; margin: 2rem 0;"}
  [:a {:href "./speakers.html"
       :class "btn btn-gradient"
       :style "display: inline-block; text-decoration: none; font-size: 1.1rem; padding: 0.75rem 1.5rem;"
       :aria-label "Submit your proposal for Clojure Jam"}
   "🎨 Submit Your Proposal"]])
