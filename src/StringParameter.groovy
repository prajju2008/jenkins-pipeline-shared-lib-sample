@Grapes(
  @Grab(group='software.amazon.awssdk', module='ssm', version='2.17.19')
)
import software.amazon.awscdk.ssm.*

class StringParameter {
    Script script

    def run() {        

        String stringValue = StringParameter.valueFromLookup(this, "test");
        
        script.echo("securestring is " + stringValue)
        
    }
}