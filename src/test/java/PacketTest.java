
import net.dengzixu.blivexanmaku.Packet;
import net.dengzixu.blivexanmaku.PacketBuilder;
import net.dengzixu.blivexanmaku.enums.Operation;
import net.dengzixu.blivexanmaku.enums.ProtocolVersion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PacketTest {
    @Test
    void TestPacketBuilder() {

        String token = "-fb6dNb7TisO2sSCvdkijKAW_-A1DEQg6ieUv2jUL2rHvypUBa-Kfu2zZz3HvJFbfkk7IgFBJq6c_zED-Dvz7tB3XLmNsOubCQhQDFZCgzm-C96WtplMA2stgr_StvNBowcgUQBWqr8MRQg=";

        // 测试数据包
        Packet packet = PacketBuilder.newBuilder()
                .protocolVersion(ProtocolVersion.HEARTBEAT)
                .operation(Operation.USER_AUTHENTICATION)
                .body("12121212")
                .build();

        System.out.println(Arrays.toString(packet.getBytes()));
    }
}
