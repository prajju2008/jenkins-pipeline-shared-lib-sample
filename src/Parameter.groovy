@Grab(group = 'software.amazon.awscdk.services', module = 'ssm', version = '2.16.2')

import software.amazon.awscdk.services.ssm.StringParameter

class Parameter {
    Script script

    def run() {

        String secureStringToken = StringParameter.valueForSecureStringParameter(this, "test", 1); 
        
        script.echo("securestring is " + secureStringToken)
        
    }
}