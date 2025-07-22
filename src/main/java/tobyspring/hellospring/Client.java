package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);

        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("Payment : " +  payment);

        PaymentService paymentService2 = beanFactory.getBean(PaymentService.class);
        Payment payment2 = paymentService2.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("Payment2 : " +  payment2);

        TimeUnit.SECONDS.sleep(3);

        PaymentService paymentService3 = beanFactory.getBean(PaymentService.class);
        Payment payment3 = paymentService3.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("Payment3 : " +  payment3);

    }
}
