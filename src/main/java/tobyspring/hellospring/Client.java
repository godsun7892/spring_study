package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.payment.Payment;
import tobyspring.hellospring.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);

        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("Payment : " +  payment);

    }
}
