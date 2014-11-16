#!/bin/bash

mvn clean install

java -jar target/benchmark.jar -prof gc
