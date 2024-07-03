import com.examples.java.mod.order.OrderService;
import com.examples.java.mod.order.OrderServiceImpl;

module mod1 {
    exports com.examples.java.mod.order;
//    exports com.examples.java.mod.product to mod2;

    provides com.examples.java.mod.order.OrderService with OrderServiceImpl;
}