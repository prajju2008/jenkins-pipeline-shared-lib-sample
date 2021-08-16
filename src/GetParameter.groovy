@Grab(group='software.amazon.awssdk', module='regions', version='2.17.19')
@Grab(group='software.amazon.awssdk', module='protocol-core', version='2.17.19')
//@Grab(group='software.amazon.awssdk', module='services', version='2.17.19')
@Grab(group='software.amazon.awssdk', module='ssm', version='2.17.19')

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ssm.SsmClient
import software.amazon.awssdk.services.ssm.model.GetParameterRequest
import software.amazon.awssdk.services.ssm.model.GetParameterResponse
import software.amazon.awssdk.services.ssm.model.SsmException


public class GetParameter {

    static void main() {

        //final String USAGE = "\n" +
        //      "Usage:\n" +
        //     "    GetParameter <paraName>\n\n" +
        //        "Where:\n" +
        //        "    paraName - the name of the parameter.\n";

        //    script.echo(USAGE);
        //    System.exit(1);
        

        String paraName = "test"
        Region region = Region.AP_SOUTH_1
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .build()

        getParaValue(ssmClient, paraName)
        ssmClient.close()
    }

    static void getParaValue(SsmClient ssmClient, String paraName) {

       // try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(paraName)
                .build()

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest)
            System.out.println("The parameter value is "+parameterResponse.parameter().value())

       // } catch (SsmException e) {
       // System.err.println(e.getMessage());
       // System.exit(1);
       // }
   }
}
