^:kindly/hide-code
(ns participation
  "Participation instructions for Clojure Jam"
  (:require [clojure.edn :as edn]
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

;; # How to Participate

;; Welcome to Clojure Jam - a festival celebrating creative coding in Clojure! Here's how to get involved.

;; ## For Attendees

;; ### Registration (Coming Soon)

;; Registration will open soon! The festival is **free** and **online via Zoom**. Sign up to receive:
;;
;; - Zoom links for all sessions
;; - Schedule updates and announcements
;; - Calendar invites with session times

;; Check back here or join our Zulip chat for updates!

;; ### Join the Community Chat

;; Connect with fellow creative coders on the [Clojurians Zulip](https://scicloj.github.io/docs/community/chat/):
;;
;; 1. Visit [clojurians.zulipchat.com](https://clojurians.zulipchat.com/) to create an account
;; 2. Look for the **#clojure-jam** channel (coming soon)
;; 3. Introduce yourself and share what creative coding interests you!

;; This is where we'll:
;;
;; - Announce registration and schedule details
;; - Discuss creative coding techniques and projects
;; - Share resources and collaborate
;; - Provide real-time support during the festival

;; ## For Speakers

;; Want to present your creative coding project or teach a workshop?

;; 👉 See our [Submit Proposal](./speakers.html) page for guidelines and how to submit.

;; **Remember:** All speakers commit to writing a [Clojure Civitas](https://clojurecivitas.github.io/) post documenting their work!

;; ## What to Expect

;; Clojure Jam will feature:
;;
;; - **🎵 Creative Talks** - Speakers showcase their music, art, and visualization projects
;; - **🛠️ Hands-On Workshops** - Learn creative coding techniques step-by-step
;; - **💻 Live Coding** - Watch creativity unfold in real-time
;; - **💬 Discussions** - Connect with other creative coders
;; - **📝 Clojure Civitas Posts** - Lasting documentation you can learn from and build upon

;; All sessions will be:
;;
;; - Free to attend
;; - Recorded and shared on [Scicloj's YouTube channel](https://www.youtube.com/@Scicloj)
;; - Interactive with Q&A time
;; - Documented on Clojure Civitas

;; ## Before the Festival

;; Once registration opens, you'll want to:
;;
;; 1. **Install Zoom** or prepare to use it in your browser
;; 2. **Test your audio/video** if you plan to ask questions
;; 3. **Review the schedule** (will be published closer to the event)
;; 4. **Explore [Clojure Civitas](https://clojurecivitas.github.io/)** - get inspired by existing creative coding posts!

;; ## Code of Conduct

;; We're committed to creating a welcoming, inclusive space for all participants. Please read our [Code of Conduct](./code_of_conduct.html) before attending.

;; ## Stay Updated
;;
;; - **This page** - We'll update it with registration links and details
;; - **Zulip** - Join for real-time announcements
;; - **[Scicloj website](https://scicloj.github.io/)** - Community updates and resources

;; ## Questions?

;; - Post in the Zulip #clojure-jam channel (coming soon)
;; - [Contact the Scicloj organizers](https://scicloj.github.io/docs/community/contact/)

;; ---

;; **See you in March 2026!** 🎨🎵✨
