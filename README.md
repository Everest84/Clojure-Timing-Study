# Clojure-Timing-Study

CS 441 Final Project

*Write a program in Clojure that will read a text file containing unsigned integers (which will be provided later). Your program will read in a large collection of integers and put them into a list. Using code in your program (i.e. NOT calling a library routine), sort the integers into order, using either the sort or mergesort algorithm. For the first pass, carry this out in a single-threaded program. Then, using Clojure's parallelism options, repeat the sort of the original list, using 2, 4, 8, 16, and 32 threads. Repeat all sorts 5 times on the same hardware and report the average times. Do not count file access time as part of the sorting time. Plot the completion time as a function of the number of threads, and produce a short (1-2 page) document summarizing and explaining your results. The summary document should include charts or graphs as appropriate to summarize your data and support your findings.*

## Getting Started

### Installation

Visit [https://clojure.org/guides/getting_started](https://clojure.org/guides/getting_started) and install all of the requirements to run Clojure projects.

## Text file formatting

### Valid

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

### Invalid

If a file is provided that doesn't match the required formatting, the program will fail.

For example:
```
52329 67271983 959562 9113341232 112 76819 442215623
```

## Running the project

### Linux

Run `clj -m cs441 res/numbers.txt` or provide your own numbers resource.

### Expected results

The program is designed to accept a text file containing rows of numbers, which are converted to a list of long's (64bit integers). 

*Note: The supplied file in this repository contains a list of numbers that are longer than the maximum value for a 32bit integer, so the project code is catered to use the `Long` data type instead of `Integer`. If you know your numbers will always be less than the maximum value for a 32bit integer, you can modify the code to improve performance.*

The numbers are then recorded for performance as they run through a mergesort algorithm given a number of threads to use. After the sorting is complete, the program will display the time taken to perform the mergesort.

### Mutli-threading results

The mergesort algorithm was ran in using 1, 2, 4, 8, 16, and 32 threads on a dataset of 100,000 64 bit integers.

The results were as follows:
* 1-thread: 39876.388523ms
* 2-thread: 24293.904029ms
* 4-thread: 21569.59776ms
* 8-thread: 13754.661419ms
* 16-thread: 8121.272467ms
* 32-thread: 4108.22421ms

### Conclusion

After studying the results, it is safe to say that there seems to be a significant advantage to using more threads to complete a mergesort algorithm. 
