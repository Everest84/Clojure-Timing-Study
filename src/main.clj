;; Matthew Downs
;; CS 441

;; "Write a program in Clojure that will read a text file containing unsigned integers.""

;; Namespace `clojure-timing-study`
(ns clojure-timing-study.core)
;; Require the string library
(require '[clojure.string :as cstr])

;; "Your program will read in a large collection of integers..."
(defn readFile [fileName]
	(with-open [rdr (clojure.java.io/reader (str fileName))](clojure.string/join "\n" (line-seq rdr)))
)

;; "...and put them into a list."
(defn convertToList [strings]
	(drop 1 
    (map 
      #(Long/parseLong %)(cstr/split strings #"\n")
    )
  )
)

;; "...sort the integers into order, using either the quicksort or mergesort algorithm."
(defn quickSort [[pivot & coll]]
  (when pivot
    (let [{lesser false greater true} (group-by #(> % pivot) coll)]
      (lazy-cat (quickSort lesser)
                [pivot]
                (quickSort greater)))))

(do
  (def numbersStringList (readFile "numbers-50.txt"))
	(def numbers (convertToList numbersStringList))
	(println "List of numbers:" numbers)
  (def sortedNumbers (quickSort numbers))
  (println "List of sorted numbers:" sortedNumbers)
)
