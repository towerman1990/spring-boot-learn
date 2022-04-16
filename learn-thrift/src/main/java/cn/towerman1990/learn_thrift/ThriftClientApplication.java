package cn.towerman1990.learn_thrift;

import cn.towerman1990.learn_thrift.service.BookService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThriftClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThriftClientApplication.class, args);

        System.out.println("Client start...");
        try (TTransport transport = new TSocket("localhost", 1314, 30000)) {
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            BookService.Client client = new BookService.Client(protocol);
            transport.open();
            var result = client.getById(1);
            System.out.println(result);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
