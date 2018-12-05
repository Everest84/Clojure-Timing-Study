# Clojure-Timing-Study

**Final project for CS441**

*Write a program in Clojure that will read a text file containing unsigned integers (which will be provided later). Your program will read in a large collection of integers and put them into a list. Using code in your program (i.e. NOT calling a library routine), sort the integers into order, using either the quicksort or mergesort algorithm. For the first pass, carry this out in a single-threaded program. Then, using Clojure's parallelism options, repeat the sort of the original list, using 2, 4, 8, 16, and 32 threads. Repeat all sorts 5 times on the same hardware and report the average times. Do not count file access time as part of the sorting time. Plot the completion time as a function of the number of threads, and produce a short (1-2 page) document summarizing and explaining your results. The summary document should include charts or graphs as appropriate to summarize your data and support your findings.*

## Getting Started

**Visit [https://clojure.org/guides/getting_started](https://clojure.org/guides/getting_started) and install all of the requirements to run Clojure projects.**

## Accepted file text formatting

The accepted formatting in the numbers file is only as follows:
```
52329
67271983
959562
9113341232
112
76819
442215623
```
If a file is provided that doesn't match the required formatting, the program will fail.

## Running the project

### Expected results

The program is designed to accept a text file containing rows of numbers, which are converted to a list of long's (64bit integers). 
*Note: The supplied file in this repository contains a list of numbers that are longer than the standard 32bit integer, so the project code is catered to that. If you know your numbers will always be less than the maximum value for a 32bit integer, you can modify the code to improve performance.*

### Mutli-threading

...
