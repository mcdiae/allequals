#!/bin/bash

mvn install

java -jar target/benchmarks.jar -prof gc
