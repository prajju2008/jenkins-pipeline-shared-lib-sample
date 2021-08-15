#!/usr/bin/env groovy

def call(body) {
    echo "Start Fetch"

    new Parameter(script:this).run()

    echo "Got it"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}