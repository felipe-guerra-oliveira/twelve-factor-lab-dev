#!/bin/bash
docker run --name twelve-factor-base -d -p 9000:9000 twelvefactorlab/base-ci:1.0
docker ps -a
