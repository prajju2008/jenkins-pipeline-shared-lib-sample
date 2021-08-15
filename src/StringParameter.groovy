@Grab(group='software.amazon.awssdk', module='ssm', version='2.17.9')

import software.amazon.awscdk.ssm.StringParameter

class StringParameter {
    Script script

    def run() {

        String secureStringToken = StringParameter.valueForSecureStringParameter(this, "test", 1); 
        
        script.echo("securestring is " + secureStringToken)
        
    }
}