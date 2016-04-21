# fcprimes

A Clojure library designed to solve a Funding Circle coding challenge.

It should print a multiplication table of primes.

# Usage:

To run from commandline, change directories into the project and run:

```
lein run
```

To run with an arbitrary number of primes, run:

```
lein run <number_of_primes>
```

## Tests

To run tests:

```
lein test fcprimes.core-test
```


# Scaling

This chart (made in Gorilla REPL) shows runtime for the `primes` function
with milliseconds on Y axis and number of primes on X axis up to 100k primes.

![runtime chart](https://raw.githubusercontent.com/eriktjacobsen/fcprimes/master/scaling.png)
