@Grab(group='software.amazon.awssdk', module='ssm', version='2.17.19')

import software.amazon.awscdk.services.ssm.*

class StringParameter {
    Script script

    def run() {        

        String secureStringToken = StringParameter.valueForSecureStringParameter(this, "test", 1); 
        
        script.echo("securestring is " + secureStringToken)
        
    }
}