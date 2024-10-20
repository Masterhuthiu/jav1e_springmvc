# jav1e_springmvc
tao spring project dep:thy, web
tao file index.html trong thu muc static
run spring boot

https://codemind365.wordpress.com/2020/05/15/annotation-requestmapping-getmapping-postmapping/

Từ phiên bản 4.3, Spring giới thiệu một số annotation để chúng dễ dang khai báo request method hơn. Đó là các annotation:
////////
	@GetMapping cho method GET
	@PostMapping cho method POST
	@PutMapping cho method PUT
	@DeleteMapping cho method DELETE
	@PatchMapping cho method PATH
	Bây giờ thì chúng ta không cần khai báo:
		@RequestMapping(value = “”, method = RequestMethod.GET)
	mà chỉ cần
	@GetMapping(value = “”)
	Lưu ý: @RequestMapping có thể được sử dụng ở cấp lớp và cấp phương thức. Trong hầu hết các trường hợ, ở cấp phương thức, các ứng dụng sẽ thích sử dụng một biến thể cụ thể của phương thức HTTP như @GetMapping, @PostMapping, @PutMapping, @DeleteMapping hoặc @PatchMapping.
///////
\\\\\\\\

////////

https://viblo.asia/p/springgiai-thich-dependency-injection-di-va-ioc-bang-ngoc-trinh-naQZRW3Alvx

**ApplicationContext?
	(https://magz.techover.io/2021/08/25/spring-applicationcontext-trong-spring-framework/)
  - Trong Spring framwork IoC được mô tả qua BeanFactory và ApplicationContext interface. BeanFactory là root interface truy cập vào Spring IoC, cung cấp chức năng cơ bản để quản lí Bean. Còn ApplicationContext là sub-interface cúa BeanFactory interface. Do đó, nó cung cấp tất cả các chức năng cơ bản của BeanFactory cùng nhưng chức năng tiên tiến hơn cho các ứng dụng Spring và phù hợp hơn cho những ứng dụng J2EE.
  - Hay hiểu đơn giản với các ứng dụng Spring, Bean là object được tạo ra và quản lí bới Spring IoC container.
  - Cấu hình Bean trong Container
	Để ApplicationContext có thể quản lí được các Bean, ứng dụng phải cũng cấp cấu hình bean cho ApplicationContext container. Ta sẽ có những cách khác nhau cấu hình để cấu hình bean:

		XML-Based Configuration
		Java-Based Configuration
		Annotation-Based Configuration
** Hướng dẫn Component và Autowired 
		(https://techmaster.vn/posts/36165/spring-boot-1-huong-dan-component-va-autowired)
  - Singleton
    Điều đặc biệt là các Bean được quản lý bên trong ApplicationContext đều là singleton. Bạn chắc đã để ý điều này từ các Output ở phía trên.

\\\\\\
** @Component và @Bean trong Spring không?
	(https://shareprogramming.net/dung-lau-nhung-ban-co-phan-biet-duoc-component-va-bean-trong-spring-khong/)
  - Một trong những lợi ích quan trọng mà Spring mang lại là Dependency Injection cho phép khởi tạo và quản lý các bean tự động. Các bean được tạo ra sẽ được quản lý bởi Spring IoC container, để sử dụng, chúng ta chỉ cần khai báo các bean với @Autowired annotation, IoC sẽ tự động tìm kiếm và tiêm chúng vào class mà chúng ta cần sử dụng.
  - Trong Spring, để tạo ra một bean chúng ta phải thông qua 2 annotation @Bean và @Component, do vậy thông thường chúng ta sẽ gặp 2 annotation này rất nhiều khi làm việc với Spring. 
    1. @Component
       Là một class-level annotation. Nó yêu cầu Spring sử dụng class này để tạo một bean nếu có nơi nào khác sử dụng class này như một dependency. Việc khởi tạo class hoàn toàn do Spring kiểm soát và chỉ một bean được tạo cho mỗi class.

       @Component
       class UserService { public void updateUser(User user){…}}
       @Controller
       class UserController { private final UserService userService;
                              @Autowired
                              public UserController(UserService userService) {this.userService = userService;}
                            } 
       }
	- Trong ví dụ trên, UserService class được chú thích với @Component do vậy nó sẽ được Spring khởi tạo và đăng ký với Application context. Khi UserController khai báo UserService là một dependency mà nó cần sử dụng, Spring sẽ tìm kiếm và tiêm một UserService instance đã được khởi tạo từ trước vào UserController để sử dụng.
     2. @Bean
        - Điều đầu tiên đó @Bean được sử dụng cho các hàm thay vì class như @Component, hàm này sẽ trả về một object sẽ được đăng ký và quản lý bởi Spring IoC container.
        - Bạn có thể sử dụng @Bean trong trường hợp bạn đang sử dụng các class thư viện bên thứ ba, lúc này bạn không thể khai báo @Component trên những class này mà bắt buộc bạn phải tạo một method trả về các instance của chúng và được chú thích bởi @Bean annotation. 
        - Bạn phải sử dụng @Bean trong các @Configuration class để Spring có thể quét và khởi tạo các bean được khai báo bên trong.
        
        class UserService {
    		@Autowired
		private PasswordEncoder passwordEncoder 
    		public String createUser(UserCreateReq req) {
        	UserEntity user = UserEntity.builder().setPassword(this.encoder.encode(req.getPassword())).build();
        	repo.save(user); }
	} 
	@Configuration
	class PasswordEncoderConfiguration {
	    @Bean
	    public PasswordEncoder passwordEncoder () {
	        return new BCryptPasswordEncoder();}
  - Trong ví dụ trên, mình đã sử dụng BCryptPasswordEncoder bởi thư viện bên thứ 3, chính vì thế mình phải sử dụng bCryptPasswordEncoder() để khởi tạo một bean và đăng ký nó với Spring IoC.	

  - NOTE: chi tiet (https://techmaster.vn/posts/36165/spring-boot-1-huong-dan-component-va-autowired)
** Định nghĩa về interface
	(https://viblo.asia/p/dieu-gi-xay-ra-neu-ta-implements-2-interface-co-cung-1-phuong-thuc-giong-nhau-djeZ1zMJlWz)
  - Interface là một abstract type trong java, nó bao gồm các hành vi mà các lớp triển khai nó bắt buộc phải thực hiện. Nó được nhận biết bằng từ khóa interface. Các phương thức trong interface là public và abstract. Từ java 8 thì chúng ta có thể define và implement các static method

/////
Dependency Injection là việc các Object nên phụ thuộc vào các Abstract Class và thể hiện chi tiết của nó sẽ được Inject vào đối tượng lúc runtime.
** Giải thích Dependency Injection (DI) và IoC bằng Ngọc Trinh
		(https://viblo.asia/p/springgiai-thich-dependency-injection-di-va-ioc-bang-ngoc-trinh-naQZRW3Alvx)	
//////

https://magz.techover.io/2021/08/25/spring-applicationcontext-trong-spring-framework/
Hay hiểu đơn giản với các ứng dụng Spring, Bean là object được tạo ra và quản lí bới Spring IoC container.
https://shareprogramming.net/dung-lau-nhung-ban-co-phan-biet-duoc-component-va-bean-trong-spring-khong/

** Java Spring Boot là gì ? Java Spring MVC là gì ? Spring Framework là gì ?

	(https://lotusacademy.edu.vn/blog/java-spring-boot-la-gi-java-spring-mvc-la-gi-spring-framework-la-gi-256)
  - Java Spring Boot là một Framework nhỏ hơn thuộc Spring Framework, giúp phát triển ứng dụng dựa trên ngôn ngữ lập trình Java, trong khi Java Spring MVC (Model-View-Controller) là một mô hình thiết kế phần mềm dựa trên Spring Framework. Java Spring Boot được thiết kế để giúp đơn giản hóa việc xây dựng các ứng dụng web và dịch vụ RESTful, trong khi Java Spring MVC là một mô hình thiết kế phần mềm được sử dụng để phát triển các ứng dụng web.

  - Các điểm nổi bật của Spring Framework bao gồm:
     1. IoC (Inversion of Control): Spring Framework thực hiện nguyên tắc IoC, cho phép bạn định nghĩa các thành phần và các phụ thuộc giữa chúng thông qua cấu hình bên ngoài, thay vì đặt trực tiếp trong mã. Điều này giúp tách biệt các thành phần và làm cho ứng dụng dễ dàng kiểm thử, mở rộng và quản lý.
     2. DI (Dependency Injection): Spring Framework thực hiện cơ chế Dependency Injection, tức là nó tự động tiêm các phụ thuộc vào các thành phần cần chúng. Điều này giảm thiểu sự phụ thuộc chặt chẽ giữa các thành phần và tạo ra một cách tiếp cận linh hoạt hơn trong việc quản lý phụ thuộc.	
     3. Mô hình MVC: Spring Framework cung cấp hỗ trợ mô hình MVC (Model-View-Controller) thông qua Spring MVC, giúp tách biệt logic kinh doanh, giao diện người dùng và xử lý dữ liệu.
     4. Cơ sở dữ liệu và JPA: Spring hỗ trợ tích hợp dễ dàng với cơ sở dữ liệu thông qua JDBC (Java Database Connectivity) và cung cấp tích hợp với JPA (Java Persistence API) để làm việc với cơ sở dữ liệu một cách hiệu quả.
     5. Quản lý giao diện người dùng: Spring hỗ trợ tạo giao diện người dùng thông qua các công nghệ như Thymeleaf, JSP, và nhiều thứ khác.
     6. Tích hợp với các công nghệ khác: Spring Framework tích hợp dễ dàng với các công nghệ khác như Hibernate, JMS (Java Message Service), Quartz Scheduler, và nhiều thư viện khác.
     7. Bảo mật: Spring cung cấp cơ chế bảo mật mạnh mẽ thông qua Spring Security để quản lý xác thực và ủy quyền trong ứng dụng.
        Tóm lại, Spring Framework là một công cụ mạnh mẽ trong việc phát triển các ứng dụng Java, giúp tạo ra các ứng dụng dễ quản lý, mở rộng và bảo trì

   - Java Spring Boot:
     - Java Spring Boot là một framework thuộc Spring Framework giúp phát triển ứng dụng dựa trên ngôn ngữ lập trình Java, được thiết kế để giúp đơn giản hóa việc xây dựng các ứng dụng web và dịch vụ RESTful. Spring Boot cung cấp một cách tiếp cận tự động hóa nhiều công việc cơ bản trong quá trình phát triển ứng dụng, từ cấu hình và cài đặt ban đầu đến triển khai và quản lý ứng dụng.
     1. Tự động cấu hình: Spring Boot cho phép tự động cấu hình ứng dụng dựa trên thư viện và các tùy chọn cấu hình mặc định. Điều này giúp giảm thiểu khối lượng công việc liên quan đến cấu hình thủ công.
     2. Tích hợp sẵn: Spring Boot tích hợp sẵn các thư viện và công nghệ phổ biến như Spring Framework, Hibernate, Thymeleaf, và nhiều thứ khác để giúp bạn dễ dàng xây dựng ứng dụng mà không cần cài đặt nhiều thứ bổ sung.
     3. Tạo ứng dụng độc lập: Spring Boot cho phép bạn tạo ra các ứng dụng chạy độc lập mà không cần phải triển khai vào các máy chủ ứng dụng bên ngoài như Tomcat hay Jetty. Ứng dụng có thể được đóng gói thành các file JAR hoặc WAR.
     4. Quản lý phụ thuộc: Spring Boot sử dụng công cụ quản lý phụ thuộc như Maven hoặc Gradle để quản lý các thư viện và phiên bản phụ thuộc.
     5. Hỗ trợ viết mã ít và cấu trúc tốt: Spring Boot giúp viết ít mã hơn và tập trung vào logic ứng dụng hơn là việc cấu hình. Nó cũng thúc đẩy việc tuân theo các nguyên tắc cấu trúc tốt để dễ dàng duy trì ứng dụng.
     6. Hỗ trợ cài đặt và triển khai: Spring Boot cung cấp các công cụ hỗ trợ cài đặt và triển khai ứng dụng, bao gồm cả việc tạo file thực thi (executable) cho ứng dụng.
        Spring Boot không chỉ dừng lại ở việc xây dựng ứng dụng web, mà còn hỗ trợ xây dựng các loại ứng dụng khác như ứng dụng dòng lệnh (CLI) và ứng dụng đa luồng.
        Tóm lại, Java Spring Boot là một framework giúp đơn giản hóa việc xây dựng các ứng dụng Java, giúp nhà phát triển tập trung vào logic ứng dụng thay vì mất thời gian quá nhiều trong việc cấu hình và triển khai. 
   - Java Spring MVC là gì ? Mô hình Spring MVC ?
     Java Spring MVC (Model-View-Controller) là một mô hình thiết kế phần mềm dựa trên Spring Framework, được sử dụng để phát triển các ứng dụng web. Mô hình MVC tách riêng các thành phần của ứng dụng để tạo ra một cách tổ chức rõ ràng và dễ dàng bảo trì.
     Cụ thể, Java Spring MVC chia ứng dụng web thành ba phần chính:
     1. Model (M): Đại diện cho dữ liệu và logic liên quan đến dữ liệu. Model đảm nhận trách nhiệm xử lý dữ liệu, thực hiện các hoạt động như truy vấn cơ sở dữ liệu, xử lý logic kinh doanh và chuẩn bị dữ liệu để hiển thị.
     2. View (V): Đại diện cho giao diện người dùng và hiển thị dữ liệu cho người dùng cuối. View chịu trách nhiệm về việc hiển thị dữ liệu theo cách thích hợp, thường là thông qua HTML, CSS và các thành phần tương tự.
     3. Controller (C): Đóng vai trò là điểm giao tiếp giữa Model và View. Controller xử lý các yêu cầu từ người dùng và quyết định Model nào cần được sử dụng để xử lý yêu cầu đó. Sau đó, nó chuẩn bị dữ liệu từ Model và chọn View phù hợp để hiển thị dữ liệu.
     Java Spring MVC cung cấp cơ chế quản lý và xử lý các yêu cầu HTTP từ người dùng và tạo ra một luồng xử lý chuẩn cho các ứng dụng web. Nó cũng hỗ trợ nhiều tính năng như quản lý phiên, xác thực, kiểm tra dữ liệu đầu vào và nhiều thứ khác.
     Tóm lại, Java Spring MVC là một phần của Spring Framework giúp triển khai mô hình MVC trong phát triển ứng dụng web Java, giúp tách biệt dữ liệu, giao diện và logic điều khiển để tạo ra các ứng dụng dễ dàng quản lý và mở rộng.

+ Giới thiệu chung về @Controller và @RestController trong Spring framework


	(https://laptrinhjavaweb.com/controller-restcontroller-trong-spring-framework-157)
  - 	
