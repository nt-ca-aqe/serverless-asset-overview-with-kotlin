#!/bin/bash
aws lambda update-function-code \
--zip-file=fileb://build/distributions/serverless-asset-overview-minimal-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=ServerlessAssetOverview_minimal
