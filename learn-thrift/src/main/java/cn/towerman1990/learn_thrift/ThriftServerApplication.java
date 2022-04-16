package cn.towerman1990.learn_thrift;

import cn.towerman1990.learn_thrift.impl.BookModelServiceImpl;
import cn.towerman1990.learn_thrift.service.BookService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThriftServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThriftServerApplication.class, args);

        try {
            System.out.println("Server start...");
            TProcessor tprocessor = new BookService.Processor<BookService.Iface>(new BookModelServiceImpl());
            TServerSocket serverTransport = new TServerSocket(1314);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
