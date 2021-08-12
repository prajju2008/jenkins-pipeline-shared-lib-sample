#!/usr/bin/env groovy

def call(body) {
    echo "Fetching ssm param"

    String my_key = new GetParameter(script:this).run()

    echo "Fetched"
    //currentBuild.result = 'SUCCESS' //FAILURE to fail

    return my_key
}
