^:kindly/hide-code
(ns speakers
  (:require [clojure.edn :as edn]
            [scicloj.kindly.v4.api :as kindly]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def conference-info (edn/read-string (slurp "info.edn")))

^:kindly/hide-code
(kind/hiccup
 [:div {:style "display: flex; justify-content: flex-end; margin: 1rem 0; padding: 0.5rem; background: #f8f9fa; border-radius: 6px; border: 1px solid #e0e0e0;"}
  [:div {:style "display: flex; align-items: center; gap: 0.5rem;"}
   [:span {:style "font-size: 0.9rem; color: #666;"} "Supported by: "]
   (for [[company-key company-data] (:supporting-companies conference-info)]
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

;; # Submit Your Proposal

;; Clojure Jam celebrates creative expression through code. We're looking for talks and workshops that explore the artistic, musical, and visual possibilities of programming in Clojure.
;; 
;; Whether you're generating fractals, synthesizing music, visualizing data in new ways, or exploring any other form of creative coding, we want to see what you're building!

;; ## Timeline

^:kindly/hide-code
(let [timeline (:timeline conference-info)]
  (kind/md
   (str "\n| Event | Date |\n"
        "|-------|------|\n"
        "| Call for Proposals | " (:cfp-open timeline) " |\n"
        "| Submission Deadline | " (:cfp-deadline timeline) " |\n"
        "| Speaker Notification | " (:speaker-notification timeline) " |\n"
        "| Festival Dates | " (:festival-dates timeline) " |")))

;; ## How to Submit

;; **Step 1: Create Your Clojure Civitas Post**

;; Create a [Clojure Civitas](https://clojurecivitas.github.io/) post (can be small/draft) showing your creative work.

;; New to Civitas? Watch Timothy Pratley's 🎥 [tutorial](https://www.youtube.com/watch?v=lceazLPcSZg).

;; **Step 2: Submit Your Proposal**

;; Once you have a draft Civitas post, submit your proposal using our form.

^:kindly/hide-code
(kind/hiccup
 [:div {:style "text-align: center; margin: 2rem 0;"}
  [:a {:href (get-in conference-info [:links :submission-form])
       :target "_blank"
       :class "btn btn-gradient"
       :style "font-size: 1.2rem; padding: 1rem 2rem;"}
   "Submit Your Proposal"]])

;; **Reach out anytime**

;; Need feedback? Join [#clojure-jam-2026 Zulip](https://clojurians.zulipchat.com/#narrow/channel/544470-clojure-jam-2026) or [contact us](https://scicloj.github.io/docs/community/contact/) anytime.

;; ## Proposal Guidelines

;; ### What We're Looking For

;; We're especially interested in (but not limited to):

^:kindly/hide-code
(kind/md
 (str "\n- " (apply str (interpose "\n- " (:preferred-topics conference-info)))))

;; **Formats**: Talks (30-45 min), Workshops (60-90 min), Live Coding (30-45 min)

;; ### Audience

;; Aim for general Clojure programmers new to creative coding.

;; ### What Makes a Great Proposal

;; ✨ **Show, Don't Just Tell** - Include visual examples, sound samples, or code snippets

;; 🎨 **Share the Journey** - Explain your creative process, not just the final result

;; 🛠️ **Make it Reproducible** - Others should be able to recreate and build upon your work

;; ### Libraries & Tools

;; We're especially interested in creative uses of:

^:kindly/hide-code
(kind/md
 (str "\n- " (apply str (interpose "\n- " (:key-libraries conference-info)))))

;; ### Collaboration Welcome
;;
;; - Team presentations and cross-disciplinary collaborations encouraged
;; - New to speaking? We can help pair you with co-presenters

;; ## Questions?

;; Have questions about what makes a good proposal? Wondering if your idea fits? Want to brainstorm?

;; [Let us talk](https://scicloj.github.io/docs/community/contact/){class="btn btn-gradient" target="_blank"}
