import configs.TestDefaultConfiguration
import org.grpc.spring.boot.autoconfigure.annotation.GRPCLocalPort
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

/**
 * @author tolkv
 * @version 05/03/2017
 */
@SpringBootTest(webEnvironment = NONE, classes = [TestDefaultConfiguration],
    properties = [
        'grpc.servers[0].address=127.0.0.1',
        'grpc.servers[0].port=0',
    ])
class GrpcLocalPortAnnotationSpec extends Specification {
  @GRPCLocalPort
  Integer port

  def 'should init port property'() {
    expect:
    port != 0
  }
}
