#!/usr/bin/env groovy

def call(body) {
    echo "Start Fetch"

    new GetParameter(script:this).main()

    echo "Got it"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}   