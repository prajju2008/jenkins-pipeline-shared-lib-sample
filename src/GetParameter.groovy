@Grab('software.amazon.awssdk', module='aws-java-sdk', version='2.17.17')
@Grab('software.amazon.awssdk', module='regions', version='2.17.17')
@Grab('software.amazon.awssdk', module='ssm', version='2.17.17')

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

class GetParameter {

    Script script

    def run() {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    GetParameter <paraName>\n\n" +
                "Where:\n" +
                "    paraName - the name of the parameter\n"

        if (args.length < 1) {
            System.out.println(USAGE)
            System.exit(1)
         }

        // Get args
        String paraName = test

        Region region = Region.AP_SOUTH_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .build()

        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(paraName)
                .build()

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest)
        
        } catch (SsmException e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
    return (parameterResponse.parameter().value())

   }
}