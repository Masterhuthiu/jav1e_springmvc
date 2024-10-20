package com.example.jav1e_springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;


/*Cách chạy ứng dụng Spring Boot
Nếu trong Java truyền thống, khi chạy cả một project, chúng ta sẽ phải định nghĩa một hàm main() và để nó khởi chạy đầu tiên.
Thì Spring Boot cũng vậy, chúng ta sẽ phải chỉ cho Spring Boot biết nơi nó khởi chạy lần đầu, để nó cài đặt mọi thứ.
Cách thực hiện là thêm annotation @SpringBootApplication trên class chính và gọi SpringApplication.run(App.class, args); để chạy project.*/

@SpringBootApplication
public class Jav1eSpringmvcApplication {

	public static void main(String[] args) {
		// ApplicationContext chính là container, chứa toàn bộ các Bean
		ApplicationContext context = SpringApplication.run(Jav1eSpringmvcApplication.class, args);
        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        // Lấy Bean ra bằng cách
		
        Outfit outfit = context.getBean(Outfit.class);

        // In ra để xem thử nó là gì
        System.out.println("Instance: " + outfit);
        // xài hàm wear()
        outfit.wear();
        
	}

}
