#!/usr/bin/env bash

USER_NAME=$1
TOKEN=$2
REPO=$3
TAG_NAME=$4

#Avoid nasty escapes
DQ='"'

DATA="{${DQ}tag_name${DQ}:${DQ}${TAG_NAME}${DQ}}"

curl \
  -v -i -u $USER_NAME:$TOKEN \
  -X POST \
  -H "Accept: application/vnd.github.v3+json" \
  https://api.github.com/repos/$USER_NAME/$REPO/releases \
  -d $DATA
