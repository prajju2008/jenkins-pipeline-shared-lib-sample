#!/usr/bin/env groovy

def call(body) {
    echo "Start Fetch"

    new GetParameter.main()

    echo "Got it"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return parameterResponse.parameter().value()
}   