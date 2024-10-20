package com.example.jav1e_springmvc;



/*

1. Khái niệm Interface là gì?
Trong lập trình hướng đối tượng, Interface được hiểu là một lớp vỏ bên ngoài của các hàm nhỏ lẻ. Bằng cách lập trình, chúng ta có thể liên kết nhiều Interface để các hàm kết nối với nhau. Đây được xem là một khuôn mẫu và để tạo ra được kết quả như ý muốn đòi hỏi các hành động phải tuân thủ theo khuôn mẫu này.
Bạn có thể hiểu đơn giản như sau: một interface không phải là một lớp, nó chỉ giống như viết một lớp, nhưng thực tế chúng lại có 2 định nghĩa khác nhau. Trong đó, một lớp mô tả các thuộc tính và hành vi của một đối tượng. Còn một lớp chứa các hành vi mà một class triển khai.
nterface  là một lớp vỏ bên ngoài của các hàm nhỏ lẻ.

Trong java, Interface là một hệ thống giao diện. Thông qua cách sử dụng, chúng ta có thể kế thừa nhiều lớp Interface để tạo thành một lớp hoàn toàn mới. 

*/

public interface Outfit {
	
    public void wear();
}
